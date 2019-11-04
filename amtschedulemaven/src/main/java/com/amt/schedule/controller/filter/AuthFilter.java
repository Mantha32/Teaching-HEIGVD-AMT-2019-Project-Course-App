package com.amt.schedule.controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "authFilter")
public class AuthFilter implements Filter {
    private  ServletContext context;

    public void init(FilterConfig config) throws ServletException {
        this.context = config.getServletContext();
        this.context.log("authFilter");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String uri = request.getRequestURI();
        this.context.log(uri);
        HttpSession session = request.getSession(false);
        boolean login = session != null && session.getAttribute("matricule") != null;
        if (login || uri.equals(request.getContextPath() + "/login")) {
            chain.doFilter(req, resp);
        } else {
            ((HttpServletResponse) resp).sendRedirect("login.jsp");
        }
    }

    public void destroy() {
    }
}
