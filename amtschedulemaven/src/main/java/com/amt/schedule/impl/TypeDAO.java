package com.amt.schedule.impl;

import com.amt.schedule.entities.Type;
import com.amt.schedule.inter.TypeEJB;
import com.amt.schedule.utility.DB;

import javax.ejb.Stateless;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Session Bean implementation class TypeDAO
 */
@Stateless(name = "TypeImpl")
public class TypeDAO implements TypeEJB {

	private Connection con = DB.connection();

	public TypeDAO() throws Exception {
	}

	/**
	 * @see TypeEJB#chercher(String)
	 */
	public Type chercher(String statut) throws SQLException {
		// TODO Auto-generated method stub
		String req = "SELECT * FROM type WHERE STATUT = ?";
		PreparedStatement preparedStatement = con.prepareStatement(req);
		preparedStatement.setString(1, statut);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.first()) {
			return new Type(resultSet.getString("statut"));
		} return null;
	}

	/**
	 * @see TypeEJB#lister()
	 */
	public java.util.List<Type> lister() throws SQLException {
		// TODO Auto-generated method stub
		String req = "SELECT * FROM type";
		java.util.List<Type> types = new ArrayList<>();
		PreparedStatement preparedStatement = con.prepareStatement(req);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			types.add(new Type(resultSet.getString("statut")));
		} return types;
	}

	/**
	 * @see TypeEJB#creer(String)
	 */
	public String creer(String statut) {
		// TODO Auto-generated method stub
		return "succes";
	}

}
