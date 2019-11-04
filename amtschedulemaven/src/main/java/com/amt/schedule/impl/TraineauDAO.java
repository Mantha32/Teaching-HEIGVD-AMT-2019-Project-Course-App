/**
 * 
 */
package com.amt.schedule.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import com.amt.schedule.entities.Utilisateur;
import com.amt.schedule.entities.Traineau;
import com.amt.schedule.inter.TraineauEJB;
import com.amt.schedule.inter.UtilisateurEJB;
import com.amt.schedule.utility.DB;

/**
 * @author doriane kaffo
 * 
 */
@Stateless(name = "TraineauImpl")
public class TraineauDAO implements
        TraineauEJB {

	private Connection con = DB.connection();

	@EJB
	private UtilisateurEJB utilisateurEJB;

	public TraineauDAO() throws Exception {
	}

	@Override
	public Traineau chercher(int num) throws SQLException {
		// TODO Auto-generated method stub
		String req = "SELECT * FROM plage WHERE NUMPLAGE = ?";
		PreparedStatement preparedStatement = con.prepareStatement(req);
		preparedStatement.setInt(1, num);
		ResultSet result = preparedStatement.executeQuery();
		if (result.first())
			return new Traineau(result.getInt("numero"), result.getString("jour"), result.getString("debut"),
					result.getString("fin"), utilisateurEJB.chercher(result.getString("matricule")));
		return null;
	}

	@Interceptors({ TraineauCreerInterceptor.class })
	@Override
	public String creer(String jour, String debut, String fin,
			Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		String req = "INSERT INTO traineau (JOUR, DEBUT, FIN, MATRICULE) VALUES (?,?,?,?)";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = con.prepareStatement(req);
			preparedStatement.setString(1, jour);
			preparedStatement.setString(2, debut);
			preparedStatement.setString(3, fin);
			preparedStatement.setString(4, utilisateur.getMatricule());
			preparedStatement.execute();
			return "succes";
		} catch (SQLException e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public List<Traineau> lister(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		String req = "SELECT * FROM traineau WHERE MATRICULE = ?";
		PreparedStatement preparedStatement = null;
		java.util.List<Traineau> traineaux = new ArrayList<>();
		try {
			preparedStatement = con.prepareStatement(req);
			preparedStatement.setString(1, utilisateur.getMatricule());
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				traineaux.add(new Traineau(resultSet.getInt("numero"), resultSet.getString("jour"),
						resultSet.getString("debut"), resultSet.getString("fin"),
						utilisateur));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  traineaux;
	}

	@Override
	public Traineau modifier(int numTraineau, String jour, String debut,
			String fin) throws SQLException {
		// TODO Auto-generated method stub
		Traineau traineau = chercher(numTraineau);
		if(traineau != null) {
			PreparedStatement preparedStatement = con.prepareStatement("UPDATE traineau SET JOUR = ?, DEBUT = ?, FIN = ? WHERE NUMERO = ?");
			preparedStatement.setString(1, jour);
			preparedStatement.setString(2, debut);
			preparedStatement.setString(3, fin);
			preparedStatement.setInt(4, numTraineau);
			preparedStatement.executeUpdate();
		}
		return traineau;
	}

	@Interceptors({ TraineauSupprimerInterceptor.class })
	@Override
	public String supprimer(int num) {
		// TODO Auto-generated method stub
		String req = "DELETE FROM traineau WHERE NUMERO = ?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = con.prepareStatement(req);
			preparedStatement.setInt(1, num);
			preparedStatement.execute();
			return "succes";
		} catch (SQLException e) {
			e.printStackTrace();
			return "fail";
		}
	}

}
