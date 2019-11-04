/**
 * 
 */
package com.amt.schedule.impl;

import javax.ejb.Stateless;

import com.amt.schedule.inter.DateEJB;
import com.amt.schedule.entities.Date;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.amt.schedule.utility.DB;

/**
 * @author doriane kaffo
 * 
 */
@Stateless(name = "DateImpl")
public class DateDAO implements DateEJB {

	private Connection con = DB.connection();

	public DateDAO() throws Exception {
	}

	@Override
	public String creer(String jour, String debut, String fin) {
		// TODO Auto-generated method stub

		String req = "INSERT INTO utilisateur (JOUR, DEBUT, FIN) VALUES (?,?,?)";
		try {
			PreparedStatement prepared = con.prepareStatement(req);
			prepared.setString(1, jour);
			prepared.setString(2, debut);
			prepared.setString(3, fin);
			prepared.execute();
			return "succes";
		} catch(SQLException e) {
			return "fail";
		}
	}

	@Override
	public Date lastDate() {
		// TODO Auto-generated method stub
		String req = "SELECT * FROM date ORDER BY NUMERO";
		Date date = null;
		try {
			PreparedStatement prepared = con.prepareStatement(req);
			ResultSet result = prepared.executeQuery();
			while (result.next()) {
				date = new Date(result.getInt("numero"), result.getString("jour"),
						result.getString("debut"), result.getString("fin"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  date;
	}

}
