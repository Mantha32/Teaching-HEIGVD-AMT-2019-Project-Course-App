package com.amt.schedule.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.amt.schedule.entities.Type;
import com.amt.schedule.entities.Utilisateur;
import com.amt.schedule.inter.UtilisateurEJB;
import com.amt.schedule.utility.DataFactory;
import com.amt.schedule.utility.InvalidCredentialsException;
import com.amt.schedule.utility.DB;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class UtilisateurDAO
 */
@Stateless(name = "UtilisateurImpl")
public class UtilisateurDAO implements
		UtilisateurEJB {

	private Connection con = DB.connection();

	public UtilisateurDAO() throws Exception {
	}

	@Override
	public String creer(String matricule, String nom, String email,
			boolean sexe, Type type, String password, String grade) {
		// TODO Auto-generated method stub
		String cPass = DataFactory.crypt(password);
		String req = "INSERT INTO utilisateur (MATRICULE, NOM, EMAIL, STATUT, PASSWORD, SEXE, GRADE) VALUES (?,?,?,?,?,?,?)";
		try {
			PreparedStatement prepared = con.prepareStatement(req);
			prepared.setString(1, matricule);
			prepared.setString(2, nom);
			prepared.setString(3, email);
			prepared.setString(4, type.getStatut());
			prepared.setString(5, cPass);
			prepared.setBoolean(6, sexe);
			prepared.setString(7, grade);
			prepared.execute();
			return "succes";
		} catch(SQLException e) {
			return "fail";
		}
	}

	@Override
	public Utilisateur chercher(String matiricule) {
		// TODO Auto-generated method stub
		String req = "SELECT * FROM utilisateur WHERE MATRICULE = ?";
		Utilisateur user = null;
		try {
			PreparedStatement prepared = con.prepareStatement(req);
			prepared.setString(1, matiricule);
			ResultSet result = prepared.executeQuery();
			while (result.next()) {
				user = new Utilisateur(result.getString("matricule"), result.getString("nom"),
						result.getString("email"), result.getBoolean("sexe"), new Type(result.getString("statut")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  user;
	}

	@Override
	public List<Utilisateur> lister(String type) {
		// TODO Auto-generated method stub
		String req = "SELECT * FROM utilisateur WHERE STATUT = ?";
		java.util.List<Utilisateur> users = new ArrayList<>();
		try {
			PreparedStatement prepared = con.prepareStatement(req);
			prepared.setString(1, type);
			ResultSet result = prepared.executeQuery();
			while (result.next()) {
				users.add(	new Utilisateur(result.getString("matricule"), result.getString("nom"),
						result.getString("email"), result.getBoolean("sexe"), new Type(result.getString("statut"))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  users;
	}

	@Override
	public List<Utilisateur> lister() {
		// TODO Auto-generated method stub
		String req = "SELECT * FROM utilisateur";
		java.util.List<Utilisateur> users = new ArrayList<>();
		try {
			PreparedStatement prepared = con.prepareStatement(req);
			ResultSet result = prepared.executeQuery();
			while (result.next()) {
				users.add(new Utilisateur(result.getString("matricule"), result.getString("nom"),
						result.getString("email"), result.getBoolean("sexe"), new Type(result.getString("statut"))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  users;
	}

	@Override
	public Utilisateur login(String key, String password, Type type) throws InvalidCredentialsException {
		// TODO Auto-generated method stub
		String msg = "";
		String errField = "";
		String cPass = DataFactory.crypt(password);
		String req = "SELECT * FROM utilisateur WHERE MATRICULE = ? AND PASSWORD = ?";
		Utilisateur user = null;
		try {
			PreparedStatement prepared = con.prepareStatement(req);
			prepared.setString(1, key);
			prepared.setString(2, cPass);
			ResultSet result = prepared.executeQuery();
			while (result.next()) {
				user = new Utilisateur(result.getString("matricule"), result.getString("nom"),
						result.getString("email"), result.getBoolean("sexe"), new Type(result.getString("statut")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (user != null) {
			return user;
		} else {
			user = chercher(key);
			if(user == null) {
				errField = "mat";
				msg = "Matricule introuvable";
			}
			else {
				errField = "pass";
				msg = "Mot de passe incorrect";
			}
			throw new InvalidCredentialsException(msg, errField);
		}
	}
}
