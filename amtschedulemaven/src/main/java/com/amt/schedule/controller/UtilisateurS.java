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
import com.amt.schedule.inter.IUtilisateurLocal;

/**
 * Servlet implementation class UtilisateurS
 */
@WebServlet("/UtilisateurS")
public class UtilisateurS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private IUtilisateurLocal utilisateur;

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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}
}
