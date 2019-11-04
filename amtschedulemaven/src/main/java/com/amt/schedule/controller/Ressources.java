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
import com.amt.schedule.inter.EvenementEJB;
import com.amt.schedule.inter.NiveauEJB;
import com.amt.schedule.inter.SalleEJB;
import com.amt.schedule.entities.Cours;
import com.amt.schedule.entities.Evenement;
import com.amt.schedule.inter.TraineauEJB;
import com.amt.schedule.inter.TypeEJB;
import com.amt.schedule.inter.UtilisateurEJB;

/**
 * Servlet implementation class SalleS
 */
@WebServlet("/Ressources")
public class Ressources extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private SalleEJB salle;

	@EJB
	private UtilisateurEJB utilisateur;

	@EJB
	private NiveauEJB niveau;

	@EJB
	private TypeEJB type;

	@EJB
	private EvenementEJB evenement;

	@EJB
	private TraineauEJB traineau;

	@EJB
	private CoursEJB cours;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ressources() {
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
		String page = request.getParameter("page");
		String matricule;

		java.util.List<Cours> listCours = new java.util.ArrayList<Cours>();
		java.util.List<Evenement> listEvts = new java.util.ArrayList<Evenement>();
		;

		PrintWriter write = response.getWriter();

		if (page.compareToIgnoreCase("tableSalle.jsp") == 0
				|| page.compareToIgnoreCase("tableSalleP.jsp") == 0
				|| page.compareToIgnoreCase("tableSallePlage.jsp") == 0) {
			request.setAttribute("salles", salle.lister());
		} else if (page.compareToIgnoreCase("tableEnseignant.jsp") == 0) {
			request.setAttribute("enseignants",
					utilisateur.lister("Enseignant"));
		} else if (page.compareToIgnoreCase("tableType.jsp") == 0) {
			try {
				request.setAttribute("types", type.lister());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (page.compareToIgnoreCase("tableNiveau.jsp") == 0) {
			try {
				request.setAttribute("niveaux", niveau.lister());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (page.compareToIgnoreCase("tableEvenement.jsp") == 0) {
			matricule = request.getParameter("matricule");
			try {
				request.setAttribute("niveaux", niveau.lister());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("evenements",
					evenement.lister(utilisateur.chercher(matricule)));
		} else if (page.compareToIgnoreCase("tableTraineau.jsp") == 0) {
			matricule = request.getParameter("matricule");
			request.setAttribute("traineaux",
					traineau.lister(utilisateur.chercher(matricule)));
		} else if (page.compareToIgnoreCase("timeTable") == 0) {
			if ((matricule = request.getParameter("matricule")) != null) {
				try {
					listCours = cours.lister(utilisateur.chercher(matricule));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				listEvts = evenement.lister(utilisateur.chercher(matricule));
			} else {
				matricule = request.getParameter("niveau");
				try {
					listCours = cours.lister(niveau.chercher(Integer.parseInt(matricule)));
					listEvts = evenement.lister(niveau.chercher(Integer.parseInt(matricule)));
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			StringBuilder out = processTimeTable(listCours, listEvts);
			write.print(out.toString());
			write.flush();
			return;
		}
		response.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher(page).include(request, response);
	}

	public StringBuilder processTimeTable(java.util.List<Cours> listCours,
			java.util.List<Evenement> listEvts) {

		StringBuilder out = new StringBuilder();
		int i = 0;

		out.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");

		out.append("<time_description>");
		for (Cours c : listCours) {
			out.append("<time_line>");
			out.append("<id>").append(i++).append("</id>");
			out.append("<titre>").append(c.getMatiere().getCode())
					.append("</titre>");
			out.append("<niveau>")
					.append("L" + c.getMatiere().getNiveau().getNiveau())
					.append("</niveau>");
			out.append("<debut>").append(c.getPlage().getDebut())
					.append("</debut>");
			out.append("<fin>").append(c.getPlage().getFin()).append("</fin>");
			out.append("<salle>").append(c.getPlage().getSalle().getCode())
					.append("</salle>");
			out.append("</time_line>");
		}

		for (Evenement evt : listEvts) {
			out.append("<time_line>");
			out.append("<id>").append(i++).append("</id>");
			out.append("<titre>").append(evt.getTitre()).append("</titre>");
			out.append("<niveau>").append("L" + evt.getNiveau().getNiveau())
					.append("</niveau>");
			out.append("<debut>").append(evt.getPlage().getDebut())
					.append("</debut>");
			out.append("<fin>").append(evt.getPlage().getFin())
					.append("</fin>");
			out.append("<salle>").append(evt.getPlage().getSalle().getCode())
					.append("</salle>");
			out.append("</time_line>");
		}
		out.append("</time_description>");
		return out;
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
