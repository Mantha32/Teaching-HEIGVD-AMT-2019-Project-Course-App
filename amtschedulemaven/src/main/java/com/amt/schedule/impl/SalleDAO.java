package com.amt.schedule.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.amt.schedule.inter.SalleEJB;
import com.amt.schedule.entities.Salle;
import com.amt.schedule.utility.DB;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class SalleDAO
 */
@Stateless(name = "SalleImpl")
public class SalleDAO implements SalleEJB {

	private Connection con = DB.connection();

	public SalleDAO() throws Exception {
	}

	@Override
	public String creer(String code, int contenance) {
		// TODO Auto-generated method stub
		String req = "INSERT INTO VALUES (?,?)";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = con.prepareStatement(req);
			preparedStatement.setString(1, code);
			preparedStatement.setInt(2, contenance);
			preparedStatement.execute();
			return "succes";
		} catch (SQLException e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public List<Salle> lister() {
		// TODO Auto-generated method stub
		String req = "SELECT * FROM salle";
		java.util.List<Salle> salles = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = con.prepareStatement(req);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()){
				salles.add(new Salle(result.getString("code"), result.getInt("contenance")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return salles;
	}

	@Override
	public Salle chercher(String key) {
		// TODO Auto-generated method stub
		String req = "SELECT * FROM salle WHERE CODE = ?";
		Salle salle = null;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(req);
			preparedStatement.setString(1, key);
			ResultSet result = preparedStatement.executeQuery();
			if (result.first()){
				salle = new Salle(result.getString("code"), result.getInt("contenance"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return salle;
	}

	@Override
	public String modifier(Salle salle, int contenance) {
		// TODO Auto-generated method stub
		String req = "UPDATE salle SET CONTENACE = ? WHERE CODE = ?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = con.prepareStatement(req);
			preparedStatement.setInt(1, contenance);
			preparedStatement.setString(2, salle.getCode());
			preparedStatement.executeUpdate();
			return "succes";
		} catch (SQLException e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public String supprimer(Salle salle) {
		// TODO Auto-generated method stub
		String req = "DELETE FROM salle WHERE CODE = ?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = con.prepareStatement(req);
			preparedStatement.setString(1, salle.getCode());
			preparedStatement.executeUpdate();
			return "succes";
		} catch (SQLException e) {
			e.printStackTrace();
			return "fail";
		}
	}

}
