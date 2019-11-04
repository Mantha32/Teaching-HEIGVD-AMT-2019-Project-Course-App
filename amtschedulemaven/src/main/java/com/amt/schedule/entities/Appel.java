/**
 * 
 */
package com.amt.schedule.entities;

import java.io.Serializable;

/**
 * @author doriane kaffo
 * 
 */
public class Appel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Utilisateur matricule;

	private Plage numplage;

	private String restLink;

	public Appel() {
		super();
	}

	public Appel(Utilisateur matricule, Plage numplage, String restLink) {
		super();
		this.matricule = matricule;
		this.numplage = numplage;
		this.restLink = restLink;
	}

	/**
	 * @return the matricule
	 */
	public Utilisateur getUtilisateur() {
		return matricule;
	}

	/**
	 * @return the numplage
	 */
	public Plage getPlage() {
		return numplage;
	}

	/**
	 * @return the restLink
	 */
	public String getRestLink() {
		return restLink;
	}

	/**
	 * @param restLink
	 *            the restLink to set
	 */
	public void setRestLink(String restLink) {
		this.restLink = restLink;
	}
}
