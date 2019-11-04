package com.amt.schedule.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amt.schedule.inter.SalleEJB;

/**
 * Servlet implementation class SalleS
 */
@WebServlet("/SalleS")
public class SalleS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private SalleEJB salle;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SalleS() {
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
		String code = request.getParameter("code");
		String opt = request.getParameter("opt");
		String state = "";
		int contenance = 0;

		PrintWriter out = response.getWriter();

		if (opt.compareToIgnoreCase("ajouter") == 0) {
			contenance = Integer.parseInt(request.getParameter("contenance"));
			state = salle.creer(code, contenance);
		} else if (opt.compareToIgnoreCase("modifier") == 0) {
			contenance = Integer.parseInt(request.getParameter("contenance"));
			state = salle.modifier(salle.chercher(code), contenance);
		} else {
			state = salle.supprimer(salle.chercher(code));
		}
		out.print(state);
		out.flush();
	}

}
