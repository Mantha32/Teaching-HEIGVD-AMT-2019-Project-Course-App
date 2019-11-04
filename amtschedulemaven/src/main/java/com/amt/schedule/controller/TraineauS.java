package com.amt.schedule.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amt.schedule.inter.CoursEJB;
import com.amt.schedule.inter.PlageEJB;
import com.amt.schedule.entities.Cours;
import com.amt.schedule.entities.Dispenser;
import com.amt.schedule.entities.Traineau;
import com.amt.schedule.entities.Utilisateur;
import com.amt.schedule.inter.DispenserEJB;
import com.amt.schedule.inter.UtilisateurEJB;
import com.amt.schedule.inter.TraineauEJB;

/**
 * Servlet implementation class TraineauS
 */
@WebServlet("/TraineauS")
public class TraineauS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	TraineauEJB traineau;

	@EJB
    UtilisateurEJB utilisateur;

	@EJB
    CoursEJB cours;

	@EJB
    PlageEJB plage;

	@EJB
	DispenserEJB dispenser;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TraineauS() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		java.util.List<Traineau> traineaux = traineau.lister(utilisateur
				.chercher(request.getParameter("matricule")));

		StringBuilder out = new StringBuilder();
		out.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		out.append("<traineaux_description>");

		for (Traineau t : traineaux) {
			out.append("<traineau>");
			out.append("<id>").append(t.getNumero()).append("</id>");
			out.append("<jour>").append(t.getJour()).append("</jour>");
			out.append("<debut>").append(t.getDebut()).append("</debut>");
			out.append("<fin>").append(t.getFin()).append("</fin>");
			out.append("</traineau>");
		}
		out.append("</traineaux_description>");
		response.setContentType("text/xml;charset=UTF-8");
		PrintWriter write = response.getWriter();
		write.write(out.toString());
		write.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String jour = request.getParameter("jour");
		String debut = request.getParameter("debut");
		String fin = request.getParameter("fin");
		String opt = request.getParameter("opt");
		String state = "";
		int num;

		PrintWriter out = response.getWriter();
		Cours coursD;

		String matricule = request.getParameter("matricule");
		Utilisateur user;

		if (opt.compareToIgnoreCase("modifier") == 0) {
			num = Integer.parseInt(request.getParameter("num"));
			try {
				coursD = cours.supprimer(traineau.chercher(num));
				dispenser.liberer(coursD.getUtilisateur(), coursD.getMatiere());
				if (coursD != null) {
					traineau.modifier(num, jour, debut, fin);
					user = utilisateur.chercher(matricule);
					Dispenser disp = dispenser.select(user).get(0);
					state = cours.creer(user, disp.getMatiere(),
							plage.libre(jour, debut, fin).get(0), disp.getType());
					dispenser.occuper(disp.getUtilisateur(), disp.getMatiere());
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (opt.compareToIgnoreCase("supprimer") == 0) {
			num = Integer.parseInt(request.getParameter("num"));
			state = traineau.supprimer(num);
		} else {
			user = utilisateur.chercher(matricule);
			state = traineau.creer(jour, debut, fin, user);
		}
		out.print(state);
		out.flush();
	}
}
