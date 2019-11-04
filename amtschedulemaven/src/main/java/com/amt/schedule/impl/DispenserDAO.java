package com.amt.schedule.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.amt.schedule.entities.*;
import com.amt.schedule.inter.DispenserEJB;
import com.amt.schedule.inter.MatiereEJB;
import com.amt.schedule.utility.DB;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class DispenserDAO
 */
@Stateless(name = "DispenserImpl")
public class DispenserDAO implements
        DispenserEJB {

	private Connection con = DB.connection();

	@EJB
    private MatiereEJB matiereEJB;

	/**
	 * Default constructor.
	 */
	public DispenserDAO() throws Exception {
	}

	/**
	 * @see DispenserEJB#lister(Utilisateur)
	 */
	public java.util.List<Dispenser> lister(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		String req = "SELECT MATRICULE, dispenser.CODE, matiere.INTITULE, matiere.NIVEAU FROM dispenser, matiere where matricule = ?";
		java.util.List<Dispenser> dispensers = new ArrayList<>();
		try {
			PreparedStatement prepared = con.prepareStatement(req);
			prepared.setString(1, utilisateur.getMatricule());
			ResultSet result = prepared.executeQuery();
			while (result.next()) {
				new Dispenser(utilisateur, matiereEJB.chercher(result.getString("code")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dispensers;
	}

	@Override
	public List<Dispenser> select(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		String req = "SELECT MATRICULE, dispenser.CODE, matiere.INTITULE, matiere.NIVEAU FROM dispenser, matiere where matricule = ? AND OCCP = 0";
		java.util.List<Dispenser> dispensers = new ArrayList<>();
		try {
			PreparedStatement prepared = con.prepareStatement(req);
			prepared.setString(1, utilisateur.getMatricule());
			ResultSet result = prepared.executeQuery();
			while (result.next()) {
				new Dispenser(utilisateur, matiereEJB.chercher(result.getString("code")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dispensers;
	}

	@Override
	public String occuper(Utilisateur utilisateur, Matiere matiere) {
		// TODO Auto-generated method stub
		String req = "UPDATE dispenser SET OCCP = ? WHERE MATRICULE = ? AND CODE = ?";
		Matiere mat = null;
		try {
			PreparedStatement prepared = con.prepareStatement(req);
			prepared.setBoolean(1, true);
			prepared.setString(2, utilisateur.getMatricule());
			prepared.setString(3, matiere.getCode());
			prepared.executeUpdate();
			return "succes";
		} catch (SQLException e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public String liberer(Utilisateur utilisateur, Matiere matiere) {
		// TODO Auto-generated method stub
		String req = "UPDATE dispenser SET OCCP = ? WHERE MATRICULE = ? AND CODE = ?";
		Matiere mat = null;
		try {
			PreparedStatement prepared = con.prepareStatement(req);
			prepared.setBoolean(1, false);
			prepared.setString(2, utilisateur.getMatricule());
			prepared.setString(3, matiere.getCode());
			prepared.executeUpdate();
			return "succes";
		} catch (SQLException e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public Dispenser chercher(Utilisateur utilisateur, Matiere matiere) {
		// TODO Auto-generated method stub
		String req = "SELECT * FROM dispenser WHERE MATRICULE = ? AND CODE = ?";
		Dispenser dispenser = null;
		try {
			PreparedStatement preapared = con.prepareStatement(req);
			preapared.setString(1, utilisateur.getMatricule());
			preapared.setString(2, matiere.getCode());
			ResultSet result = preapared.executeQuery();
			if(result.first()) {
				dispenser = new Dispenser(utilisateur, matiere);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return dispenser;
	}

}
