/**
 * 
 */
package com.amt.schedule.inter;

import javax.ejb.Local;

import com.amt.schedule.entities.Niveau;
import com.amt.schedule.entities.Utilisateur;
import com.amt.schedule.entities.Matiere;
import com.amt.schedule.entities.Plage;
import com.amt.schedule.entities.Cours;
import com.amt.schedule.entities.Salle;
import com.amt.schedule.entities.Traineau;

import java.sql.SQLException;

/**
 * @author doriane kaffo
 * 
 */
@Local
public interface CoursEJB {
	public String creer(Utilisateur enseignant, Matiere matiere, Plage plage,
			String type);

	public java.util.List<Cours> lister(Niveau niveau) throws SQLException;

	public java.util.List<Cours> lister(Utilisateur utilisateur) throws SQLException;

	public java.util.List<Cours> lister(Salle salle) throws SQLException;

	public Cours supprimer(Traineau traineau) throws SQLException;
}
