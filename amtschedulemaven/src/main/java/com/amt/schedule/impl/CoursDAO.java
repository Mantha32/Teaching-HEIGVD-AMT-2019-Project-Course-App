package com.amt.schedule.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.amt.schedule.inter.CoursEJB;
import com.amt.schedule.entities.Cours;
import com.amt.schedule.entities.Utilisateur;
import com.amt.schedule.entities.Matiere;
import com.amt.schedule.entities.Niveau;
import com.amt.schedule.entities.Plage;
import com.amt.schedule.entities.Salle;
import com.amt.schedule.entities.Traineau;
import com.amt.schedule.inter.MatiereEJB;
import com.amt.schedule.inter.PlageEJB;
import com.amt.schedule.inter.UtilisateurEJB;
import com.amt.schedule.utility.DB;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class CoursDAO
 */
@Stateless(name = "CoursImpl")
public class CoursDAO implements CoursEJB {

	private Connection con = DB.connection();

	@EJB
	private MatiereEJB matiereEJB;

	@EJB
	private PlageEJB plageEJB;

	@EJB
	private UtilisateurEJB utilisateurEJB;

	public CoursDAO() throws Exception {
	}

	/**
	 * @see CoursEJB#lister(Utilisateur)
	 */
	public java.util.List<Cours> lister(Utilisateur utilisateur) throws SQLException {
		// TODO Auto-generated method stub
		java.util.List<Cours> cours = new ArrayList<>();
		if (utilisateur == null)
			return cours;
		String req = "select * from cours where matricule = ?";
		PreparedStatement preparedStatement = con.prepareStatement(req);
		preparedStatement.setString(1, utilisateur.getMatricule());
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			cours.add(new Cours(utilisateur, matiereEJB.chercher(resultSet.getString("code")),
					plageEJB.chercher(resultSet.getInt("numplage")), resultSet.getString("type")));
		} return cours;
	}

	/**
	 * @see CoursEJB#lister(Niveau)
	 */
	public java.util.List<Cours> lister(Niveau niveau) throws SQLException {
		// TODO Auto-generated method stub
		String req = "select MATRICULE, cours.CODE, TYPE, NUMPLAGE from cours where cours.CODE = matiere.CODE AND matiere.NIVEAU = ?";
		java.util.List<Cours> cours = new ArrayList<>();
		PreparedStatement preparedStatement = con.prepareStatement(req);
		preparedStatement.setInt(1, niveau.getNiveau());
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			cours.add(new Cours(utilisateurEJB.chercher(resultSet.getString("matricule")), matiereEJB.chercher(resultSet.getString("code")),
					plageEJB.chercher(resultSet.getInt("numplage")), resultSet.getString("type")));
		} return cours;
	}

	@Override
	public List<Cours> lister(Salle salle) throws SQLException {
		// TODO Auto-generated method stub
		String req = "Cours cours, plage where cours.NUMPLAGE = plage.NUMPLAGE AND plage.CODE = ?";
		java.util.List<Cours> cours = new ArrayList<>();
		PreparedStatement preparedStatement = con.prepareStatement(req);
		preparedStatement.setString(1, salle.getCode());
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			cours.add(new Cours(utilisateurEJB.chercher(resultSet.getString("matricule")), matiereEJB.chercher(resultSet.getString("code")),
					plageEJB.chercher(resultSet.getInt("numplage")), resultSet.getString("type")));
		} return cours;
	}

	/**
	 * @see CoursEJB#creer(Utilisateur, Matiere, Plage)
	 */
	public String creer(Utilisateur utilisateur, Matiere matiere, Plage plage,
			String type) {
		// TODO Auto-generated method stub
		String req = "INSERT INTO cours VALUES (?,?,?,?)";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = con.prepareStatement(req);
			preparedStatement.setString(1, utilisateur.getMatricule());
			preparedStatement.setString(2, matiere.getCode());
			preparedStatement.setInt(3, plage.getNumPlage());
			preparedStatement.setString(4, type);
			preparedStatement.execute();
			return "succes";
		} catch (SQLException e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public Cours supprimer(Traineau traineau) throws SQLException {
		// TODO Auto-generated method stub
		String req = "DELETE FROM cours WHERE cours.NUMPLAGE in (SELECT NUMPLAGE FROM plage WHERE JOUR = ?, DEBUT = ?," +
				" FIN = ?)";
		PreparedStatement preparedStatement = con.prepareStatement(req);
		preparedStatement.setString(1, traineau.getJour());
		preparedStatement.setString(2, traineau.getDebut());
		preparedStatement.setString(3, traineau.getFin());
		preparedStatement.execute();
		return null;
	}

}
