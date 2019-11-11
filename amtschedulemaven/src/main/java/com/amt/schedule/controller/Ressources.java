package com.amt.schedule.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amt.schedule.entities.Lecture;
import com.amt.schedule.inter.*;

/**
 * Servlet implementation class SalleS
 */
@WebServlet("/Ressources")
public class Ressources extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private ClassroomEJB classroomEJB;

	@EJB
	private UserEJB userEJB;

	@EJB
	private RoleEJB roleEJB;

	@EJB
	private RoleEJB type;

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

		PrintWriter write = response.getWriter();

		if (page.compareToIgnoreCase("/classroom/tableClassroom.jsp") == 0) {
			request.setAttribute("classroom", classroomEJB.list());
		} else if (page.compareToIgnoreCase("/user/tableUser.jsp") == 0) {
			request.setAttribute("users",
					userEJB.list(roleEJB.chercher("Enseignant")));
		} else if (page.compareToIgnoreCase("listRole.jsp") == 0) {
			request.setAttribute("roles", type.list());
		} else if (page.compareToIgnoreCase("timeTable") == 0) {
			return;
		}
		response.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher(page).include(request, response);
	}

	public StringBuilder processTimeTable(java.util.List<Lecture> listCours) {

		StringBuilder out = new StringBuilder();
		int i = 0;

		out.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");

		out.append("<time_description>");
		for (Lecture c : listCours) {
			out.append("<time_line>");
			out.append("<id>").append(i++).append("</id>");
			out.append("<titre>").append(c.getCourse().getTitre())
					.append("</titre>");
			out.append("<debut>").append("")
					.append("</debut>");
			out.append("<fin>").append("").append("</fin>");
			out.append("<classroom>").append(c.getClassroom().getName())
					.append("</classroom>");
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
