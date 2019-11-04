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

import com.amt.schedule.inter.TypeEJB;
import com.amt.schedule.inter.UtilisateurEJB;

/**
 * Servlet implementation class UtilisateurS
 */
@WebServlet("/UtilisateurS")
public class UtilisateurS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private UtilisateurEJB utilisateur;

	@EJB
	private TypeEJB type;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UtilisateurS() {
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
		request.setAttribute("enseignants",
				utilisateur.lister("Enseignant"));
		response.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("allEnseignant.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String matricule = request.getParameter("mat");
		String nom = request.getParameter("nom");
		String email = request.getParameter("email");
		String sexeC = request.getParameter("sexe");
		String grade = request.getParameter("grade");
		String password = request.getParameter("pass");
		boolean sexe = true;

		PrintWriter out = response.getWriter();

		if (sexeC.compareToIgnoreCase("feminin") == 0) {
			sexe = false;
		}

		String state = null;
		try {
			state = utilisateur.creer(matricule, nom, email, sexe,
					type.chercher(request.getParameter("type")), password, grade);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		out.print(state);
		out.flush();
	}
}
