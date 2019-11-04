/**
 * 
 */
package com.amt.schedule.inter;

import javax.ejb.Local;

import com.amt.schedule.entities.Traineau;
import com.amt.schedule.entities.Utilisateur;

import java.sql.SQLException;

/**
 * @author doriane kaffo
 * 
 */
@Local
public interface TraineauEJB {
	public String creer(String jour, String debut, String fin,
			Utilisateur utilisateur);

	public java.util.List<Traineau> lister(Utilisateur enseignant);

	public Traineau modifier(int numTraineau, String jour, String debut,
			String fin) throws SQLException;

	public Traineau chercher(int num) throws SQLException;

	public String supprimer(int num);
}
