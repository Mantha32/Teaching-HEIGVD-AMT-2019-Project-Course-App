package com.amt.schedule.controller;

import com.amt.schedule.inter.ClassroomEJB;
import com.amt.schedule.inter.RoleEJB;
import com.amt.schedule.entities.Classroom;
import com.amt.schedule.entities.Role;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ClassroomServlet")
public class ClassroomServlet extends HttpServlet {
    @EJB
    private ClassroomEJB classroomEJB;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String floor = request.getParameter("floor");
        String name = request.getParameter("name");
        String opt = request.getParameter("opt");
        String out = "";
        if(opt.compareToIgnoreCase("add") == 0) {
            out = classroomEJB.create(floor, name);
        } else if(opt.compareToIgnoreCase("edit") == 0) {
            Classroom classroom = classroomEJB.chercher(Integer.parseInt(request.getParameter("num")));
            out = classroomEJB.edit(classroom, floor, name);
        }
        response.getWriter().write(out);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("classrooms", classroomEJB.list());
        request.getRequestDispatcher("/classroom/listClassroom.jsp").forward(request, response);
    }
}
