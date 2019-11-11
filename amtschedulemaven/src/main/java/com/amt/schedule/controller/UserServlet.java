package com.amt.schedule.controller;

import com.amt.schedule.inter.RoleEJB;
import com.amt.schedule.inter.UserEJB;
import com.amt.schedule.entities.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet")
public class UserServlet extends HttpServlet {
    @EJB
    private UserEJB userEJB;

    @EJB
    private RoleEJB roleEJB;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opt = request.getParameter("opt");
        String id = request.getParameter("userid");
        String username = request.getParameter("username");
        String nom = request.getParameter("nom");
        String role = request.getParameter("role");
        String out= "";
        if (opt.compareToIgnoreCase("add") == 0) {
            out = userEJB.creer(username, role, roleEJB.chercher(role));
        } else if(opt.compareToIgnoreCase("edit") == 0) {
            out = userEJB.edit(userEJB.chercher(Integer.parseInt(id)), username, nom, roleEJB.chercher(role));
        }
        response.getWriter().write(out);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String role = request.getParameter("role");
        List<User> users = userEJB.list(roleEJB.chercher(role));
        request.setAttribute("users", users);
        request.getRequestDispatcher("/user/listUser.jsp").forward(request, response);
    }
}
