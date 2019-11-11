package com.amt.schedule.impl;

import com.amt.schedule.entities.Course;
import com.amt.schedule.entities.Role;
import com.amt.schedule.entities.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourseDAOTest {

    @Test
    public void creer() {
    }

    @Test
    public void chercher() {
        try {
            CourseDAO courseDAO = new CourseDAO();
            Course course = courseDAO.chercher(2);
            boolean result = course != null;
            boolean expresult = true;
            assertEquals(result, expresult);
        } catch (Exception e) {

        }
    }

    @Test
    public void list() {
        try {
            CourseDAO courseDAO = new CourseDAO();
            User user = new User();
            user.setUserid(2);
            java.util.List<Course> courses = courseDAO.list(user);
            int result = courses.size();
            int expresult = 2;
            assertEquals(result, expresult);
        } catch (Exception e) {

        }
    }

    @Test
    public void testList() {
        try {
            CourseDAO courseDAO = new CourseDAO();
            java.util.List<Course> courses = courseDAO.list();
            int result = courses.size();
            int expresult = 3;
            assertEquals(result, expresult);
        } catch (Exception e) {

        }
    }

    @Test
    public void delete() {
        try {
            CourseDAO CourseDAO = new CourseDAO();
            User user = new User();
            user.setUserid(2);
            Course course = new Course("INF400", null, user);
            String result = CourseDAO.delete(course);
            String expresult = "succes";
            assertEquals(result, expresult);
        } catch (Exception e) {

        }
    }

    @Test
    public void edit() {
    }
}