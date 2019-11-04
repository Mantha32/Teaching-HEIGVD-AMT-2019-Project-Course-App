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
import com.amt.schedule.inter.NiveauEJB;
import com.amt.schedule.inter.SalleEJB;
import com.amt.schedule.entities.Cours;
import com.amt.schedule.inter.UtilisateurEJB;

/**
 * Servlet implementation class CourS
 */
@WebServlet("/CourS")
public class CourS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
    CoursEJB cours;

	@EJB
    UtilisateurEJB utilisateur;

	@EJB
    NiveauEJB niveau;

	@EJB
    SalleEJB salle;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CourS() {
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
		String criteria = request.getParameter("criteria");
		String key = request.getParameter("key");
		int i = 0;

		java.util.List<Cours> mesCours = new java.util.ArrayList<Cours>();
		StringBuilder out = new StringBuilder();
		out.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		out.append("<cours_description>");

		if (criteria.compareToIgnoreCase("utilisateur") == 0) {
			try {
				mesCours = cours.lister(utilisateur.chercher(key));
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else if (criteria.compareToIgnoreCase("niveau") == 0) {
			try {
				mesCours = cours.lister(niveau.chercher(Integer.parseInt(key)));
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else if (criteria.compareToIgnoreCase("salle") == 0) {
			try {
				mesCours = cours.lister(salle.chercher(key));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		for (Cours c : mesCours) {
			out.append("<ue>");
			out.append("<id>").append(i++).append("</id>");
			out.append("<ens>").append(c.getUtilisateur().getNom())
					.append("</ens>");
			out.append("<code>").append(c.getMatiere().getCode())
					.append("</code>");
			out.append("<debut>").append(c.getPlage().getDebut())
					.append("</debut>");
			out.append("<fin>").append(c.getPlage().getFin()).append("</fin>");
			out.append("<salle>").append(c.getPlage().getSalle().getCode())
					.append("</salle>");
			out.append("</ue>");
		}
		out.append("</cours_description>");
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
	}

}