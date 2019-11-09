package com.amt.schedule.controller;

import com.amt.schedule.inter.ClassroomEJB;
import com.amt.schedule.inter.LectureEJB;
import com.amt.schedule.inter.UserEJB;
import com.amt.schedule.entities.Lecture;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "LectureServlet")
public class LectureServlet extends HttpServlet {
    @EJB
    private LectureEJB lectureEJB;

    @EJB
    private UserEJB userEJB;

    @EJB
    private ClassroomEJB classroomEJB;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String criteria = request.getParameter("criteria");
        String key = request.getParameter("key");
        String[] hour;

        java.util.List<Lecture> mesCours = new java.util.ArrayList<Lecture>();
        StringBuilder out = new StringBuilder();
        out.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        out.append("<lecture_list>");

        if (criteria.compareToIgnoreCase("user") == 0) {
            mesCours = lectureEJB.list(userEJB.chercher(key));
        } else if (criteria.compareToIgnoreCase("classroom") == 0) {
            mesCours = lectureEJB.list(classroomEJB.chercher(Integer.parseInt(request.getParameter("classroom"))));
        }
        request.setAttribute("lectures", mesCours);
        request.getRequestDispatcher("").forward(request, response);
    }
}
