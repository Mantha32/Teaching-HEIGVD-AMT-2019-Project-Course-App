package com.amt.schedule.controller;

import com.amt.schedule.inter.CourseEJB;
import com.amt.schedule.inter.UserEJB;
import com.amt.schedule.entities.Course;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CourseServlet")
public class CourseServlet extends HttpServlet {
    @EJB
    private CourseEJB courseEJB;

    @EJB
    private UserEJB userEJB;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opt = request.getParameter("opt");
        String userid = request.getParameter("userid");
        String courseid = request.getParameter("courseid");
        String tite = request.getParameter("titre");
        String desc = request.getParameter("desc");
        String out = "";
        if (opt.compareToIgnoreCase("add") == 0) {
            out = courseEJB.creer(tite, desc, userEJB.chercher(Integer.parseInt(userid)));
        } else if(opt.compareToIgnoreCase("edit") == 0) {
            out = courseEJB.edit(courseEJB.chercher(Integer.parseInt(courseid)), tite, desc);
        }
        response.getWriter().write(out);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Course> courses;
        if (request.getParameter("criteria") != null) {
            courses = courseEJB.list(userEJB.chercher(Integer.parseInt(request.getParameter("userid"))));
        } else {
            courses = courseEJB.list();
        }
        request.setAttribute("courses", courses);
        request.getRequestDispatcher("/courses/listCourse.jsp").forward(request, response);
    }
}
