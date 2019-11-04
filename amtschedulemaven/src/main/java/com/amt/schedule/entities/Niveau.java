/**
 * 
 */
package com.amt.schedule.entities;

import java.io.Serializable;

/**
 * @author doriane kaffo
 * 
 */
public class Niveau implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int niveau;

	private java.util.List<Matiere> matieres;

	java.util.List<Evenement> evenements;

	public Niveau() {
		super();
	}

	public Niveau(int niveau) {
		super();
		this.niveau = niveau;
	}

	public int getNiveau() {
		return niveau;
	}

	public java.util.List<Evenement> getEvenement() {
		return evenements;
	}

	/**
	 * @return the matieres
	 */
	public java.util.List<Matiere> getMatieres() {
		return matieres;
	}

	/**
	 * @param matieres
	 *            the matieres to set
	 */
	public void setMatieres(Matiere matiere) {
		matieres.add(matiere);
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
		result = prime * result + niveau;
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
		if (!(obj instanceof Niveau))
			return false;
		Niveau other = (Niveau) obj;
		if (niveau != other.niveau)
			return false;
		return true;
	}
}
