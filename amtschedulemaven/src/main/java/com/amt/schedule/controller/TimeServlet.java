package com.amt.schedule.controller;

import com.amt.schedule.entities.Lecture;
import com.amt.schedule.entities.Time;
import com.amt.schedule.inter.ClassroomEJB;
import com.amt.schedule.inter.LectureEJB;
import com.amt.schedule.inter.TimeEJB;
import com.amt.schedule.inter.UserEJB;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "TimeServlet")
public class TimeServlet extends HttpServlet {

    @EJB
    private LectureEJB lectureEJB;

    @EJB
    private UserEJB userEJB;

    @EJB
    private ClassroomEJB classroomEJB;

    @EJB
    private TimeEJB timeEJB;

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
            System.out.println(key);
            mesCours = lectureEJB.list(userEJB.chercher(Integer.parseInt(key)));
        } else if (criteria.compareToIgnoreCase("classroom") == 0) {
            mesCours = lectureEJB.list(classroomEJB.chercher(Integer.parseInt(key)));
        } else {
            mesCours = lectureEJB.list();
            System.out.println(mesCours);
        }
        for (Lecture c : mesCours) {
            List<Time> times = timeEJB.list(c);
            for (Time t : times) {
                hour = t.getSlotEvent().getHeure().split("-");
                out.append("<lecture>");
                out.append("<id>").append(t.getLecture().getId()).append("</id>");
                out.append("<ens>").append(t.getLecture().getUser().getFirstname())
                        .append("</ens>");
                out.append("<titre>").append(t.getLecture().getCourse().getTitre())
                        .append("</titre>");
                out.append("<debut>").append(hour[0])
                        .append("</debut>");
                out.append("<fin>").append(hour[1]).append("</fin>");
                out.append("<classroom>").append(t.getLecture().getClassroom().getName())
                        .append("</classroom>");
                out.append("</lecture>");
            }
        }
        out.append("</lecture_list>");
        response.setContentType("text/xml;charset=UTF-8");
        PrintWriter write = response.getWriter();
        write.write(out.toString());
        write.flush();
    }
}
