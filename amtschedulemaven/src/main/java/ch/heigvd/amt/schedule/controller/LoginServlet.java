package ch.heigvd.amt.schedule.controller;

import ch.heigvd.amt.schedule.utility.JobHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final Integer userSession = null;
    private static final String HOME_VIEW = "home";
    private static final String LOGIN_VIEW = "login";
    private static final String ABSOLUTE_PATH_LOGIN_VIEW = "/WEB-INF/pages/login.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JobHandler.setPageTitle(request, "login");
        this.getServletContext().getRequestDispatcher(ABSOLUTE_PATH_LOGIN_VIEW).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(ABSOLUTE_PATH_LOGIN_VIEW) ;
    }
}