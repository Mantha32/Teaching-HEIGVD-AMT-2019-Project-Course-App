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

import com.amt.schedule.entities.Type;
import com.amt.schedule.inter.TypeEJB;

/**
 * Servlet implementation class TypeS
 */
@WebServlet("/TypeS")
public class TypeS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private TypeEJB type;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TypeS() {
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
		PrintWriter out = response.getWriter();
		java.util.List<Type> liste = null;
		try {
			liste = type.lister();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String stream = "";
		if (liste.size() == 0)
			stream = "";
		else {
			for (Type t : liste) {
				stream += t.getStatut() + ",";
			}
			stream = stream.substring(0, stream.lastIndexOf(","));
		}
		out.print(stream);
		out.flush();
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
