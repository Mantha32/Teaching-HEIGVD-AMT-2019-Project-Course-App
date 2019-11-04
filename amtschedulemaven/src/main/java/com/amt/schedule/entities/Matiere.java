/**
 * 
 */
package com.amt.schedule.entities;

import java.io.Serializable;

/**
 * @author doriane kaffo
 * 
 */
public class Matiere implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String code;

	private String intitule;

	private Niveau niveau;

	java.util.List<Dispenser> dispenser;

	java.util.List<Cours> cours;

	public Matiere() {
		super();
	}

	public Matiere(String code, String intitule, Niveau niveau) {
		super();
		this.code = code;
		this.intitule = intitule;
		this.niveau = niveau;
	}

	/**
	 * @return the intitule
	 */
	public String getIntitule() {
		return intitule;
	}

	public java.util.List<Cours> getCours() {
		return cours;
	}

	public java.util.List<Dispenser> getDispensers() {
		return dispenser;
	}

	/**
	 * @param intitule
	 *            the intitule to set
	 */
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getCode() {
		return code;
	}

	/**
	 * @return the niveau
	 */
	public Niveau getNiveau() {
		return niveau;
	}

	/**
	 * @param niveau
	 *            the niveau to set
	 */
	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
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
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result
				+ ((intitule == null) ? 0 : intitule.hashCode());
		result = prime * result + ((niveau == null) ? 0 : niveau.hashCode());
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
		if (!(obj instanceof Matiere))
			return false;
		Matiere other = (Matiere) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (intitule == null) {
			if (other.intitule != null)
				return false;
		} else if (!intitule.equals(other.intitule))
			return false;
		if (niveau == null) {
			if (other.niveau != null)
				return false;
		} else if (!niveau.equals(other.niveau))
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
		return "[" + code + "-" + niveau.getNiveau() + "\n";
	}
}
