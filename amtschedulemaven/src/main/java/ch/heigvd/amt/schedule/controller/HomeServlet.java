package ch.heigvd.amt.schedule.controller;

import ch.heigvd.amt.schedule.model.Title;
import ch.heigvd.amt.schedule.utility.JobHandler;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(urlPatterns = {"/my", "/home","/dashboard"})
public class HomeServlet extends HttpServlet {

    private static final String HOME_VIEW = "/WEB-INF/pages/home.jsp";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JobHandler.setPageTitle(request, "home");

        this.getServletContext().getRequestDispatcher(HOME_VIEW).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(HOME_VIEW);
    }
}
