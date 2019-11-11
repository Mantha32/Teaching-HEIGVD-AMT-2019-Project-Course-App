package com.amt.schedule.impl;

import com.amt.schedule.entities.Classroom;
import com.amt.schedule.entities.Course;
import com.amt.schedule.entities.Lecture;
import com.amt.schedule.entities.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class LectureDAOTest {

    @Test
    public void creer() {
        try {
            LectureDAO lectureDAO = new LectureDAO();
            User user = new User();
            user.setUserid(2);
            Course course = new Course();
            course.setCourseid(3);
            Classroom classroom = new Classroom();
            classroom.setNumero(2);
            String result = lectureDAO.creer(user, course, classroom, "");
            String expresult = "succes";
            assertEquals(result, expresult);
        } catch (Exception e) {

        }
    }

    @Test
    public void list() {
    }

    @Test
    public void chercher() {
        try {
            LectureDAO lectureDAO = new LectureDAO();
            String result = lectureDAO.chercher(1).getClass().getName();
            String expresult = "com.amt.schedule.entities.Lecture";
            assertEquals(result, expresult);
        } catch (Exception e) {

        }
    }

    @Test
    public void delete() {
        try {
            LectureDAO lectureDAO = new LectureDAO();
            Lecture lecture = new Lecture();
            lecture.setId(1);
            String result = lectureDAO.delete(lecture);
            String expresult = "succes";
            assertEquals(result, expresult);
        } catch (Exception e) {

        }
    }
}