/**
 * 
 */
package com.amt.schedule.inter;

import javax.ejb.Local;

import com.amt.schedule.entities.Dispenser;
import com.amt.schedule.entities.Matiere;
import com.amt.schedule.entities.Utilisateur;

/**
 * @author doriane kaffo
 * 
 */
@Local
public interface DispenserEJB {
	public java.util.List<Dispenser> lister(Utilisateur utilisateur);

	public java.util.List<Dispenser> select(Utilisateur utilisateur);

	public String occuper(Utilisateur utilisateur, Matiere matiere);

	public String liberer(Utilisateur utilisateur, Matiere matiere);

	public Dispenser chercher(Utilisateur utilisateur, Matiere matiere);
}
