package com.amt.schedule.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.amt.schedule.entities.*;
import com.amt.schedule.inter.EvenementEJB;
import com.amt.schedule.inter.UtilisateurEJB;
import com.amt.schedule.utility.DB;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

/**
 * Session Bean implementation class EvenementDAO
 */
@Stateless(name = "EvenementImpl")
public class EvenementDAO implements
        EvenementEJB {

	@EJB
	private UtilisateurEJB utilisateurEJB;

	private Connection con = DB.connection();

	public EvenementDAO() throws Exception {
	}
	/**
	 * @see EvenementEJB#creer(Utilisateur, Plage, Niveau, Date, String)
	 */
	@Interceptors({ EvenementCreerInterceptor.class })
	public String creer(Utilisateur utilisateur, Plage plage, Niveau niveau,
			Date date, String titre, int nbPersonne) {
		// TODO Auto-generated method stub
		Evenement evenement = new Evenement(utilisateur, date, plage, niveau,
				titre, nbPersonne);
		evenement.setDuree(2);
		String req = "INSERT INTO evenement (MATRICULE, NUMPLAGE, NUMERO, NIVEAU, CONTENANCE, TITRE) VALUES " +
				"(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement prepared = con.prepareStatement(req);
			prepared.setString(1, utilisateur.getMatricule());
			prepared.setInt(2, plage.getNumPlage());
			prepared.setInt(3, date.getNumero());
			prepared.setInt(4, niveau.getNiveau());
			prepared.setInt(5, nbPersonne);
			prepared.setString(6, titre);
			prepared.execute();
			return "succes";
		} catch (SQLException e) {
			e.printStackTrace();
			return "fail";
		}
	}

	/**
	 * @see EvenementEJB#lister()
	 */
	@Override
	public java.util.List<Evenement> lister(Niveau niveau) {
		// TODO Auto-generated method stub
		String req = "SELECT MATRICULE, date.NUMERO, date.JOUR, date.DEBUT, date.FIN, plage.NUMPALGE, plage.JOUR, plage.DEBUT, " +
				"plage.FIN, plage.CODE, salle.CONTENANCE, NIVEAU, CONTENANCE, DESCRIPTION, DUREE, TITRE FROM evenement, plage," +
				"salle WHERE NIVEAU = ? AND (evenement.NUMPLAGE = plage.NUMPLAGE AND plage.CODE = salle.CODE) AND " +
				"evenement.NUMERO = date.NUMERO";
		java.util.List<Evenement> evenements = new ArrayList<>();
		try {
			PreparedStatement prepared = con.prepareStatement(req);
			prepared.setInt(1, niveau.getNiveau());
			ResultSet result = prepared.executeQuery();
			while (result.next()) {
				evenements.add(new Evenement(utilisateurEJB.chercher(result.getString("matricule")),
						new Date(result.getInt("numero"), result.getString("date.jour"),
						result.getString("date.debut"), result.getString("date.fin")),
						new Plage(result.getInt("numplage"), result.getString("jour"),
								result.getString("debut"), result.getString("fin"),
								new Salle(result.getString("plage.code"), result.getInt("contenance")))
						,new Niveau(result.getInt("niveau")), result.getString("titre"),
						result.getInt("contenance")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return evenements;
	}

	@Override
	public List<Evenement> lister(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		String req = "SELECT MATRICULE, date.NUMERO, date.JOUR, date.DEBUT, date.FIN, plage.NUMPLAGE, plage.JOUR, plage.DEBUT, " +
				"plage.FIN, plage.CODE, salle.CONTENANCE, NIVEAU, CONTENANCE, DESCRIPTION, DUREE, TITRE FROM evenement, plage," +
				"salle, date WHERE matricule = ? AND (evenement.NUMPLAGE = plage.NUMPLAGE AND plage.CODE = salle.CODE) AND " +
				"evenement.NUMERO = date.NUMERO";
		java.util.List<Evenement> evenements = new ArrayList<>();
		try {
			PreparedStatement prepared = con.prepareStatement(req);
			prepared.setString(1, utilisateur.getMatricule());
			ResultSet result = prepared.executeQuery();
			while (result.next()) {
				evenements.add(new Evenement(utilisateur, new Date(result.getInt("numero"), result.getString("date.jour"),
						result.getString("date.debut"), result.getString("date.fin")),
						new Plage(result.getInt("numplage"), result.getString("jour"),
								result.getString("debut"), result.getString("fin"),
								new Salle(result.getString("plage.code"), result.getInt("contenance")))
						,new Niveau(result.getInt("niveau")), result.getString("titre"),
						result.getInt("contenance")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return evenements;
	}

	@Override
	public List<Evenement> lister() {
		String req = "SELECT MATRICULE, date.NUMERO, date.JOUR, date.DEBUT, date.FIN, plage.NUMPALGE, plage.JOUR, plage.DEBUT, " +
				"plage.FIN, plage.CODE, salle.CONTENANCE, NIVEAU, CONTENANCE, DESCRIPTION, DUREE, TITRE FROM evenement, plage," +
				"salle WHERE (evenement.NUMPLAGE = plage.NUMPLAGE AND plage.CODE = salle.CODE) AND " +
				"evenement.NUMERO = date.NUMERO";
		java.util.List<Evenement> evenements = new ArrayList<>();
		try {
			PreparedStatement prepared = con.prepareStatement(req);
			ResultSet result = prepared.executeQuery();
			while (result.next()) {
				evenements.add(new Evenement(utilisateurEJB.chercher(result.getString("matricule")),
						new Date(result.getInt("numero"), result.getString("date.jour"),
						result.getString("date.debut"), result.getString("date.fin")),
						new Plage(result.getInt("numplage"), result.getString("jour"),
								result.getString("debut"), result.getString("fin"),
								new Salle(result.getString("plage.code"), result.getInt("contenance")))
						,new Niveau(result.getInt("niveau")), result.getString("titre"),
						result.getInt("contenance")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return evenements;
	}

	@Override
	public String annuler(Utilisateur utilisateur, Plage plage, Niveau niveau,
			Date date) {
		// TODO Auto-generated method stub
		String req = "DELETE FROM evenement WHERE MATRICULE = ? AND NUMPLAGE = ? AND NIVEAU = ? AND NUMERO = ?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = con.prepareStatement(req);
			preparedStatement.setString(1, utilisateur.getMatricule());
			preparedStatement.setInt(2, plage.getNumPlage());
			preparedStatement.setInt(3, niveau.getNiveau());
			preparedStatement.setInt(4, date.getNumero());
			preparedStatement.execute();
			return "succes";
		} catch (SQLException e) {
			e.printStackTrace();
			return "fail";
		}
	}
}
