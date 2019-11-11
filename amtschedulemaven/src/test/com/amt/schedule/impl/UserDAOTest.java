package com.amt.schedule.impl;

import com.amt.schedule.entities.Role;
import com.amt.schedule.entities.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDAOTest {

    @Test
    public void creer() {
        try {
            UserDAO userDAO = new UserDAO();
            Role role = new Role("Etudiant");
            String result = userDAO.creer("doriane","kevin", role);
            String expresult = "user name deja utilise";
            assertEquals(result, expresult);
        } catch (Exception e) {

        }
    }

    @Test
    public void chercher() {
        try {
            UserDAO userDAO = new UserDAO();
            User user = userDAO.chercher(2);
            boolean result = user != null;
            assertEquals(result, true);
        } catch (Exception e) {

        }
    }

    @Test
    public void list() {
        try {
            UserDAO userDAO = new UserDAO();
            Role role = new Role("Enseignant");
            int result = userDAO.list(role).size();
            int expresult = 1;
            assertEquals(result, expresult);
        } catch (Exception e) {

        }
    }

    @Test
    public void delete() {
        try {
            UserDAO userDAO = new UserDAO();
            User user = new User();
            user.setUserid(4);
            String result = userDAO.delete(user);
            String expresult = "succes";
            assertEquals(result, expresult);
        } catch (Exception e) {

        }
    }

    @Test
    public void login() {
        try {
            UserDAO userDAO = new UserDAO();
            User user = userDAO.login("doriane", "doriane", "Administrateur");
            boolean result = user != null;
            assertEquals(result, false);
        } catch (Exception e) {

        }
    }
}