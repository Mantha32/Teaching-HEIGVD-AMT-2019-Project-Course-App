/**
 * 
 */
package com.amt.schedule.entities;

import java.io.Serializable;

/**
 * @author doriane kaffo
 * 
 */
public class Cours implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Utilisateur matricule;

	private Plage numplage;

	private Matiere code;

	private String type;

	public Cours() {
		super();
	}

	public Cours(Utilisateur matricule, Matiere code, Plage numplage,
			String type) {
		super();
		this.matricule = matricule;
		this.code = code;
		this.numplage = numplage;
		this.type = type;
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
	 * @return the code
	 */
	public Matiere getMatiere() {
		return code;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((matricule == null) ? 0 : matricule.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((numplage == null) ? 0 : numplage.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Cours))
			return false;
		Cours other = (Cours) obj;
		if (matricule == null) {
			if (other.matricule != null)
				return false;
		} else if (!matricule.equals(other.matricule))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (numplage == null) {
			if (other.numplage != null)
				return false;
		} else if (!numplage.equals(other.numplage))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cours [matricule=" + matricule + ", numplage="
				+ numplage + ", code=" + code + ", type=" + type + "]";
	}
}
