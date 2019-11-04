package com.amt.schedule.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.amt.schedule.inter.NiveauEJB;
import com.amt.schedule.utility.DB;

import javax.ejb.Stateless;
import com.amt.schedule.entities.Niveau;

/**
 * Session Bean implementation class Niveau
 */
@Stateless(name = "NiveauImpl")
public class NiveauDAO implements NiveauEJB {

	private Connection con = DB.connection();

	public NiveauDAO() throws Exception {
	}

	@Override
	public Niveau chercher(int niveau) throws SQLException {
		// TODO Auto-generated method stub
		String req = "SELECT * FROM niveau WHERE NIVEAU = " + niveau;
		PreparedStatement preparedStatement = con.prepareStatement(req);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.first())
			return new Niveau(resultSet.getInt("niveau"));
		return null;
	}

	@Override
	public List<Niveau> lister() throws SQLException {
		// TODO Auto-generated method stub
		String req = "SELECT * FROM niveau";
		java.util.List<Niveau> niveaux = new ArrayList<>();
		PreparedStatement preparedStatement = con.prepareStatement(req);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			niveaux.add(new Niveau(resultSet.getInt("niveau")));
		}
		return niveaux;
	}

}
