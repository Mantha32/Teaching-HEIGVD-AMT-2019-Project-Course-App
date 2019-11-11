package com.amt.schedule.impl;

import com.amt.schedule.entities.Classroom;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClassroomDAOTest {

    @Test
    public void create() {
        try {
            ClassroomDAO classroomDAO = new ClassroomDAO();
            String result = classroomDAO.create("2", "S004");
            String expresult = "succes";
            assertEquals(result, expresult);
        } catch (Exception e) {

        }
    }

    @Test
    public void chercher() {
        try {
            ClassroomDAO classroomDAO = new ClassroomDAO();
            Classroom classroom = classroomDAO.chercher(1);
            boolean result = classroom != null;
            boolean expresult = true;
            assertEquals(result, expresult);
        } catch (Exception e) {

        }
    }

    @Test
    public void list() {
        try {
            ClassroomDAO classroomDAO = new ClassroomDAO();
            java.util.List<Classroom> classrooms = classroomDAO.list();
            int result = classrooms.size();
            int expresult = 3;
            assertEquals(result, expresult);
        } catch (Exception e) {

        }
    }

    @Test
    public void delete() {
        try {
            ClassroomDAO classroomDAO = new ClassroomDAO();
            Classroom classroom = new Classroom(3, "2", "S004");
            String result = classroomDAO.delete(classroom);
            String expresult = "succes";
            assertEquals(result, expresult);
        } catch (Exception e) {

        }
    }

    @Test
    public void edit() {
    }
}