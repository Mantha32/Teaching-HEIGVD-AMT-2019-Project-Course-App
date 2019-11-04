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

import com.amt.schedule.inter.EvenementEJB;
import com.amt.schedule.inter.NiveauEJB;
import com.amt.schedule.entities.Date;
import com.amt.schedule.entities.Evenement;
import com.amt.schedule.entities.Niveau;
import com.amt.schedule.inter.UtilisateurEJB;

/**
 * Servlet implementation class EvenementS
 */
@WebServlet("/EvenementS")
public class EvenementS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private EvenementEJB evenement;

	@EJB
	private UtilisateurEJB utilisateur;

	@EJB
	private NiveauEJB niveau;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EvenementS() {
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
		String matricule = request.getParameter("matricule");
		java.util.List<Evenement> evenements;
		if (matricule != null) {
			evenements = evenement.lister(utilisateur.chercher(matricule));
		} else {
			try {
				evenements = evenement.lister(niveau.chercher(Integer.parseInt(request
						.getParameter("niveau"))));
				request.setAttribute("evenements", evenements);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		request.getRequestDispatcher("evenement.jsp")
				.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String matricule = request.getParameter("matricule");
		String jour = request.getParameter("jour");
		String debut = request.getParameter("debut");
		String fin = request.getParameter("fin");
		String titre = request.getParameter("titre");
		String opt = request.getParameter("opt");
		String state = "";
		int contenance = Integer.parseInt(request.getParameter("contenance"));

		PrintWriter out = response.getWriter();

		if (opt.compareToIgnoreCase("ajouter") == 0) {
			Niveau niv = null;
			try {
				niv = niveau.chercher(Integer.parseInt(request.getParameter("niveau")));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			state = evenement.creer(utilisateur.chercher(matricule), null, niv,
					new Date(1, jour, debut, fin), titre, contenance);
		}
		out.print(state);
		out.flush();
	}
}
