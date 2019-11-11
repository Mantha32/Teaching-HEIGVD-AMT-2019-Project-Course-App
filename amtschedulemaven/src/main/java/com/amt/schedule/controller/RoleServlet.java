package com.amt.schedule.controller;

import com.amt.schedule.inter.RoleEJB;
import com.amt.schedule.entities.Role;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "RoleServlet")
public class RoleServlet extends HttpServlet {
    @EJB
    private RoleEJB roleEJB;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String status = request.getParameter("role");
        roleEJB.creer(status);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        java.util.List<Role> liste = null;

        liste = roleEJB.list();
        String stream = "";
        if (liste.size() == 0)
            stream = "";
        else {
            for (Role t : liste) {
                stream += t.getStatus() + ",";
            }
            stream = stream.substring(0, stream.lastIndexOf(","));
        }
        out.print(stream);
        out.flush();
    }
}
