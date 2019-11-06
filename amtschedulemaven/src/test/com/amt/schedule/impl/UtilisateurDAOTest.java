package com.amt.schedule.service;

import com.amt.schedule.model.Utilisateur;
import org.junit.Test;

import static org.junit.Assert.*;

public class UtilisateurDAOTest {

    @Test
    public void creer() {
        try {
            UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
            String result = utilisateurDAO.creer("16w2180", "test", "test@gmail.com", true,
                    new Type("Eleve"), "12345", "Principal");
            String expResult = "succes";
            assertEquals(expResult, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void chercher() {
        try {
            UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
            Utilisateur user = utilisateurDAO.chercher("16w2182");
            String result = user.getClass().getName();
            String expResult = "com.amt.schedule.entities.Utilisateur";
            assertEquals(expResult, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void lister() {
    }

    @Test
    public void testLister() {
    }

    @Test
    public void login() {
        try {
            UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
            Utilisateur user = utilisateurDAO.login("16w2182", "12345", new Type("Eleve"));
            String result = user.getClass().getName();
            String expResult = "com.amt.schedule.entities.Utilisateur";
            assertEquals(expResult, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}