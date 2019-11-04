package com.amt.schedule.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.amt.schedule.inter.PlageEJB;
import com.amt.schedule.entities.Plage;
import com.amt.schedule.entities.Salle;
import com.amt.schedule.inter.SalleEJB;
import com.amt.schedule.utility.DB;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class PlageDAO
 */
@Stateless(name = "PlageImpl")
public class PlageDAO implements PlageEJB {

	private Connection con = DB.connection();

	@EJB
	private SalleEJB salleEJB;

	public PlageDAO() throws Exception {
	}

	@Override
	public String creer(String jour, String debut, String fin, Salle salle) {
		// TODO Auto-generated method stub
		String req = "INSERT INTO plage (JOUR, DEBUT, FIN, CODE) VALUES (?,?,?,?)";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = con.prepareStatement(req);
			preparedStatement.setString(1, jour);
			preparedStatement.setString(2, debut);
			preparedStatement.setString(3, fin);
			preparedStatement.setString(4, salle.getCode());
			preparedStatement.executeQuery();
			return "succes";
		} catch (SQLException e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public List<Plage> lister(Salle salle) {
		// TODO Auto-generated method stub
		String req = "SELECT * FROM plage";
		java.util.List<Plage> plages = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = con.prepareStatement(req);
			ResultSet result = preparedStatement.executeQuery();
			while(result.next()){
				plages.add(new Plage(result.getInt("numplage"), result.getString("jour"),
						result.getString("debut"), result.getString("fin"), salleEJB.chercher(result.getString("code"))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return plages;
	}

	@Override
	public String modifier(Plage plage, String jour, String debut, String fin) throws SQLException {
		// TODO Auto-generated method stub
		Plage traineau = chercher(plage.getNumPlage());
		if(traineau != null) {
			PreparedStatement preparedStatement = con.prepareStatement("UPDATE traineau SET JOUR = ?, DEBUT = ?, FIN = ? WHERE NUMPLAGE = ?");
			preparedStatement.setString(1, jour);
			preparedStatement.setString(2, debut);
			preparedStatement.setString(3, fin);
			preparedStatement.setInt(4, plage.getNumPlage());
			preparedStatement.executeUpdate();
			return "succes";
		}
		return "fail";
	}

	@Override
	public String supprimer(Plage plage) {
		// TODO Auto-generated method stub
		String req = "DELETE FROM plage WHERE NUMERO = ?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = con.prepareStatement(req);
			preparedStatement.setInt(1, plage.getNumPlage());
			preparedStatement.execute();
			return "succes";
		} catch (SQLException e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public List<Plage> libre() throws SQLException {
		// TODO Auto-generated method stub
		String req = "select * from plage where plage.NUMPLAGE not in(select cours.NUMPLAGE from cours) and VALIDE = 1";
		java.util.List<Plage> plages = new ArrayList<>();
		PreparedStatement preparedStatement = con.prepareStatement(req);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			plages.add(new Plage(resultSet.getInt("numplage"), resultSet.getString("jour"),
					resultSet.getString("debut"), resultSet.getString("fin"),
					salleEJB.chercher(resultSet.getString("code"))));
		}
		return plages;
	}

	@Override
	public Plage chercher(int key) throws SQLException {
		// TODO Auto-generated method stub
		String req = "SELECT * FROM plage WHERE NUMPLAGE = ?";
		PreparedStatement preparedStatement = con.prepareStatement(req);
		preparedStatement.setInt(1, key);
		ResultSet result = preparedStatement.executeQuery();
		if(result.first()){
			return new Plage(result.getInt("numplage"), result.getString("jour"),
					result.getString("debut"), result.getString("fin"),
					salleEJB.chercher(result.getString("code")));
		}
		return null;
	}

	@Override
	public List<Plage> libre(String jour, String debut, String fin) throws SQLException {
		// TODO Auto-generated method stub
		String req = "select * from plage where plage.NUMPLAGE not in(select cours.NUMPLAGE from cours) and (plage.JOUR = '"
				+ jour
				+ "' and plage.DEBUT = '"
				+ debut
				+ "' and plage.FIN = '" + fin + "') and plage.VALIDE = 1";
		java.util.List<Plage> plages = new ArrayList<>();
		PreparedStatement preparedStatement = con.prepareStatement(req);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			plages.add(new Plage(resultSet.getInt("numplage"), resultSet.getString("jour"),
					resultSet.getString("debut"), resultSet.getString("fin"),
					salleEJB.chercher(resultSet.getString("code"))));
		}
		return plages;
	}

	@Override
	public List<Plage> libreEv(String jour, String debut, String fin,
			int contenance) throws SQLException {
		// TODO Auto-generated method stub
		String req = "select NUMPLAGE, JOUR, DEBUT, FIN, salle.CODE, CONTENANCE from plage, salle where plage.NUMPLAGE not in(select cours.NUMPLAGE froms cours) and plage.NUMPLAGE not in(select evenement.NUMPLAGE from evenement) and (plage.JOUR = '"
				+ jour
				+ "' and plage.DEBUT = '"
				+ debut
				+ "' and plage.FIN = '"
				+ fin
				+ "' ) and salle.CONTENANCE = '"
				+ contenance
				+ "' and plage.VALIDE = 1 AND salle.CODE = plage.CODE";
		java.util.List<Plage> plages = new ArrayList<>();
		PreparedStatement preparedStatement = con.prepareStatement(req);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			plages.add(new Plage(resultSet.getInt("numplage"), resultSet.getString("jour"),
					resultSet.getString("debut"), resultSet.getString("fin"),
					salleEJB.chercher(resultSet.getString("code"))));
		}
		return plages;
	}

}
