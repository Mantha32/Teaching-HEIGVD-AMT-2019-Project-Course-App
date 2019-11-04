package com.amt.schedule.controller;

import com.amt.schedule.inter.NiveauEJB;
import com.amt.schedule.entities.Niveau;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "NiveauS")
public class NiveauS extends HttpServlet {
    @EJB
    private NiveauEJB niveau;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        java.util.List<Niveau> liste = null;
        try {
            liste = niveau.lister();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String stream = "";
        if (liste.size() == 0)
            stream = "";
        else {
            for (Niveau t : liste) {
                stream += t.getNiveau() + ",";
            }
            stream = stream.substring(0, stream.lastIndexOf(","));
        }
        out.print(stream);
        out.flush();
    }
}
