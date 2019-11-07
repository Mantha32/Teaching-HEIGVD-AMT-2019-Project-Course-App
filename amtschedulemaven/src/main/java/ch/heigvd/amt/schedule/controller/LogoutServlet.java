package ch.heigvd.amt.schedule.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutServlet extends HomeServlet {
    private static final String ABSOLUTE_PATH_LOGIN_VIEW = "login";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //invalidate the session if exists
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
        }

        response.sendRedirect(ABSOLUTE_PATH_LOGIN_VIEW);
    }
}
