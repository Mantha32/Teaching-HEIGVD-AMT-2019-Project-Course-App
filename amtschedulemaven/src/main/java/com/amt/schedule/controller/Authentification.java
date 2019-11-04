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
import javax.servlet.http.HttpSession;

import com.amt.schedule.entities.Utilisateur;
import com.amt.schedule.inter.TypeEJB;
import com.amt.schedule.inter.UtilisateurEJB;
import com.amt.schedule.utility.InvalidCredentialsException;

/**
 * Servlet implementation class Authentification
 */
@WebServlet("/Authentication")
public class Authentification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	UtilisateurEJB utilisateur;

	@EJB
	private TypeEJB type;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Authentification() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
						  HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String matricule = request.getParameter("mat");
		String password = request.getParameter("key");
		String page = "index.jsp";
		PrintWriter out = response.getWriter();
		Utilisateur user;

		try {
			try {
				user = utilisateur.login(matricule, password,
						type.chercher(request.getParameter("type")));
				HttpSession session = request.getSession();
				session.setAttribute("matricule", matricule);
				session.setAttribute("nom", user.getNom());
				session.setAttribute("type", user.getType());
				if (user.getType().getStatut()
						.compareToIgnoreCase("Administrateur") != 0) {
					page = "index_.jsp";
				}
				out.write(page);
				out.flush();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch(InvalidCredentialsException ex) {
			response.setStatus(404);
			response.setContentType("text/xml;charset=UTF-8");
			StringBuilder buff = new StringBuilder();
			buff.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			buff.append("<err_desc>");
			buff.append("<err>").append("<field>"+ex.getType()+"</field>").append("<msg>"+ex.getMessage()+"</msg>").append("</err>");
			buff.append("</err_desc>");
			out.write(buff.toString());
			out.flush();
		}
	}

}
