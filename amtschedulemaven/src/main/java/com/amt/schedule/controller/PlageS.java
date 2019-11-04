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

import com.amt.schedule.inter.PlageEJB;
import com.amt.schedule.inter.SalleEJB;
import com.amt.schedule.entities.Plage;

/**
 * Servlet implementation class PlageS
 */
@WebServlet("/PlageS")
public class PlageS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private PlageEJB plage;

	@EJB
	private SalleEJB salle;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PlageS() {
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
		String salleId = request.getParameter("salle");
		java.util.List<Plage> plages = plage.lister(salle.chercher(salleId));
		StringBuilder out = new StringBuilder();
		out.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		out.append("<plage_description>");
		for (Plage p : plages) {
			out.append("<plage>");
			out.append("<id>").append(p.getNumPlage()).append("</id>");
			out.append("<jour>").append(p.getJour()).append("</jour>");
			out.append("<debut>").append(p.getDebut()).append("</debut>");
			out.append("<fin>").append(p.getFin()).append("</fin>");
			out.append("</plage>");
		}
		out.append("</plage_description>");
		PrintWriter write = response.getWriter();
		response.setContentType("text/xml;charset=UTF-8");
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

		String opt = request.getParameter("opt");
		String jour = request.getParameter("jour");
		String debut = request.getParameter("debut");
		String fin = request.getParameter("fin");
		String salleId = request.getParameter("salle");
		int numplage;
		String state = "";

		PrintWriter out = response.getWriter();

		if (opt.compareToIgnoreCase("ajouter") == 0) {
			try {
				state = plage.creer(jour, debut, fin, salle.chercher(salleId));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (opt.compareToIgnoreCase("supprimer") == 0) {
			numplage = Integer.parseInt(request.getParameter("num"));
			try {
				state = plage.supprimer(plage.chercher(numplage));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		out.print(state);
		out.flush();
	}
}
