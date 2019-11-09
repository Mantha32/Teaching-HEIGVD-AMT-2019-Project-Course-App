package com.amt.schedule.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amt.schedule.inter.UserEJB;
import com.amt.schedule.entities.User;
import com.amt.schedule.utility.InvalidCredentialsException;

/**
 * Servlet implementation class Authentification
 */
@WebServlet("/Authentication")
public class Authentification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	UserEJB user;

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
		String username = request.getParameter("username");
		String password = request.getParameter("pass");
		String page = "admin.jsp";
		PrintWriter out = response.getWriter();
		User u = null;

		try {
			u = user.login(username, password,
						request.getParameter("role"));
				HttpSession session = request.getSession();
				session.setAttribute("userid", u.getUserid());
				session.setAttribute("username", u.getUsername());
				session.setAttribute("role", u.getRole());
				if (u.getRole().getStatus()
						.compareToIgnoreCase("Enseignant") == 0) {
					page = "enseignant.jsp";
				} else if (u.getRole().getStatus()
						.compareToIgnoreCase("Etudiant") == 0) {
					page = "index.jsp";
				}
				out.write(page);
				out.flush();
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
