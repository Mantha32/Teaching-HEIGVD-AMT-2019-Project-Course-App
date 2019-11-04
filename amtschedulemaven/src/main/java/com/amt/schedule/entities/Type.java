/**
 * 
 */
package com.amt.schedule.entities;

import java.io.Serializable;

/**
 * @author doriane kaffo
 * 
 */
public class Type implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String statut;

	java.util.List<Utilisateur> utilisateurs;

	public Type() {
		super();
	}

	public Type(String statut) {
		super();
		this.statut = statut;
	}

	public java.util.List<Utilisateur> getUsers() {
		return utilisateurs;
	}

	/**
	 * @return the statut
	 */
	public String getStatut() {
		return statut;
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
		result = prime * result + ((statut == null) ? 0 : statut.hashCode());
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
		if (!(obj instanceof Type))
			return false;
		Type other = (Type) obj;
		if (statut == null) {
			if (other.statut != null)
				return false;
		} else if (!statut.equals(other.statut))
			return false;
		return true;
	}
}
