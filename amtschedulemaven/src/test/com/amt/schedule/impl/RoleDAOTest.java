package com.amt.schedule.impl;

import com.amt.schedule.entities.Role;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoleDAOTest {

    @Test
    public void chercher() {
        try {
            RoleDAO roleDAO = new RoleDAO();
            Role role = roleDAO.chercher("Enseignant");
            boolean result = role != null;
            boolean expresult = true;
            assertEquals(result, expresult);
        } catch (Exception e) {

        }
    }

    @Test
    public void list() {
        try {
            RoleDAO roleDAO = new RoleDAO();
            int result = roleDAO.list().size();
            int expresult = 3;
            assertEquals(result, expresult);
        } catch (Exception e) {

        }
    }

    @Test
    public void creer() {
        try {
            RoleDAO roleDAO = new RoleDAO();
            String result = roleDAO.creer("Eleve");
            String expresult = "succes";
            assertEquals(result, expresult);
        } catch (Exception e) {

        }
    }

    @Test
    public void delete() {
        try {
            RoleDAO roleDAO = new RoleDAO();
            Role role = new Role("Eleve");
            String result = roleDAO.delete(role);
            String expresult = "succes";
            assertEquals(result, expresult);
        } catch (Exception e) {

        }
    }
}