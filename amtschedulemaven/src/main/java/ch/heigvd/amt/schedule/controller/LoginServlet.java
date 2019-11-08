package ch.heigvd.amt.schedule.controller;

import ch.heigvd.amt.schedule.service.DAO.LoginManagerLocal;
import ch.heigvd.amt.schedule.utility.JobHandler;
import ch.heigvd.amt.schedule.model.*;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final Integer userSession = null;
    private static final String HOME_VIEW = "home";
    private static final String LOGIN_VIEW = "login";
    private static final String ABSOLUTE_PATH_LOGIN_VIEW = "/WEB-INF/pages/login.jsp";


    @EJB
    private LoginManagerLocal loginManager;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JobHandler.setPageTitle(request, "login");
        this.getServletContext().getRequestDispatcher(ABSOLUTE_PATH_LOGIN_VIEW).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get request parameters for userID and password
        String username = request.getParameter("inputUsername");
        String pwd = request.getParameter("inputPassword");

        if(loginManager.isRightCredentials(username,pwd)){

            User loggedUser = loginManager.infoUserLogged(username, pwd);

            //Create session
            HttpSession session = request.getSession(true);

            //User info
            session.setAttribute("userSession", loggedUser.getUserName());
            session.setAttribute("userIdSession", loggedUser.getUserId());
            session.setAttribute("userStatusSession", loggedUser.isAdmin());

            //setting session to expiry in 30 mins
            session.setMaxInactiveInterval(30*60);
            /*
            Cookie userName = new Cookie("user", user);
            userName.setMaxAge(30*60);
            response.addCookie(userName);

             */
            request.setAttribute("pageTitle", "Home");

            response.sendRedirect(HOME_VIEW);
        }else{
            response.sendRedirect(ABSOLUTE_PATH_LOGIN_VIEW) ;
        }

    }
}