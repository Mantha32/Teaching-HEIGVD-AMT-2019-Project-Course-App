/**
 * 
 */
package com.amt.schedule.impl;

import javax.ejb.Stateless;

import com.amt.schedule.entities.Niveau;
import com.amt.schedule.inter.MatiereEJB;
import com.amt.schedule.entities.Matiere;
import com.amt.schedule.utility.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author doriane kaffo
 * 
 */
@Stateless(name = "MatiereImpl")
public class MatiereDAO implements
        MatiereEJB {

	private Connection con = DB.connection();

	public MatiereDAO() throws Exception {
	}

	@Override
	public Matiere chercher(String key) throws SQLException {
		// TODO Auto-generated method stub
		String req = "SELECT * FROM matiere WHERE CODE = ?";
		PreparedStatement preparedStatement = con.prepareStatement(req);
		preparedStatement.setString(1, key);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.first()) {
			return new Matiere(resultSet.getString("code"), resultSet.getString("intitule"),
					new Niveau(resultSet.getInt("niveau")));
		} return null;
	}

}
