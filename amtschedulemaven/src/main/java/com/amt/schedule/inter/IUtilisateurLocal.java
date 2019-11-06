/**
 * 
 */
package com.amt.schedule.inter;

import javax.ejb.Local;

import com.amt.schedule.model.Utilisateur;
import com.amt.schedule.utility.InvalidCredentialsException;

/**
 * @author doriane kaffo
 * 
 */
@Local
public interface IUtilisateurLocal {
	public Utilisateur chercher(String key);

	public String creer(String matricule, String nom, String email,
                        boolean sexe, Type type, String password, String grade);

	public java.util.List<Utilisateur> lister(String type);

	public java.util.List<Utilisateur> lister();

	public Utilisateur login(String key, String password, Type type) throws InvalidCredentialsException;
}
