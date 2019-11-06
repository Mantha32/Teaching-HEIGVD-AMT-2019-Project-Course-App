/**
 * 
 */
package com.amt.schedule.inter;

import javax.ejb.Local;

import com.amt.schedule.model.Utilisateur;

import java.sql.SQLException;

/**
 * @author doriane kaffo
 * 
 */
@Local
public interface ICoursLocal {
	public String creer(Utilisateur enseignant, Matiere matiere, Plage plage,
			String type);

	public java.util.List<Cours> lister(Niveau niveau) throws SQLException;

	public java.util.List<Cours> lister(Utilisateur utilisateur) throws SQLException;

	public java.util.List<Cours> lister(Salle salle) throws SQLException;

	public Cours supprimer(Traineau traineau) throws SQLException;
}
