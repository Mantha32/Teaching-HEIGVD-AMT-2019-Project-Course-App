/**
 * 
 */
package com.amt.schedule.inter;

import javax.ejb.Local;

import com.amt.schedule.entities.Date;
import com.amt.schedule.entities.Utilisateur;
import com.amt.schedule.entities.Evenement;
import com.amt.schedule.entities.Niveau;
import com.amt.schedule.entities.Plage;

/**
 * @author doriane kaffo
 * 
 */
@Local
public interface EvenementEJB {
	public String creer(Utilisateur utilisateur, Plage plage, Niveau niveau,
			Date date, String titre, int nbPersonne);

	public String annuler(Utilisateur utilisateur, Plage plage, Niveau niveau,
			Date date);

	public java.util.List<Evenement> lister();

	public java.util.List<Evenement> lister(Niveau niveau);

	public java.util.List<Evenement> lister(Utilisateur utilisateur);
}
