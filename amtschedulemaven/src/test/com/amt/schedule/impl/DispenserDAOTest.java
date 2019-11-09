package com.amt.schedule.impl;

import com.amt.schedule.entities.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class DispenserDAOTest {

    @Test
    public void lister() {
    }

    @Test
    public void select() {
    }

    @Test
    public void occuper() {
    }

    @Test
    public void liberer() {
    }

    @Test
    public void chercher() {
        try {
            DispenserDAO dispenserDAO = new DispenserDAO();
            Dispenser dispenser = dispenserDAO.chercher(new Utilisateur("16w2182", "kevin", "ulrichkev2017@gmail.com",
                    true, new Role("Eleve")), new Matiere("ICT201", "Graph", new Niveau(1)));
            String result = dispenser.getClass().getName();
            String expResult = "com.amt.schedule.entities.Dispenser";
            assertEquals(expResult, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}