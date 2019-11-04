/**
 * 
 */
package com.amt.schedule.entities;

import java.io.Serializable;

/**
 * @author doriane kaffo
 * 
 */
public class Plage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int numplage = 0;

	private String jour;
	private String debut;
	private String fin;
	private int duree;
	private boolean valide = true;

	private Salle code;

	java.util.List<Cours> cours;

	java.util.List<Evenement> evenements;

	java.util.List<Appel> appels;

	public Plage() {
		super();
	}

	public Plage(int numplage, String jour, String debut, String fin, Salle code) {
		super();
		this.numplage = numplage;
		this.jour = jour;
		this.debut = debut;
		this.fin = fin;
		this.code = code;
	}

	public int getNumPlage() {
		return numplage;
	}

	public java.util.List<Evenement> getEvenement() {
		return evenements;
	}

	public java.util.List<Appel> getAppel() {
		return appels;
	}

	public java.util.List<Cours> getCours() {
		return cours;
	}

	/**
	 * @return the fin
	 */
	public String getFin() {
		return fin;
	}

	/**
	 * @param fin
	 *            the fin to set
	 */
	public void setFin(String fin) {
		this.fin = fin;
	}

	/**
	 * @return the debut
	 */
	public String getDebut() {
		return debut;
	}

	/**
	 * @param debut
	 *            the debut to set
	 */
	public void setDebut(String debut) {
		this.debut = debut;
	}

	/**
	 * @return the date
	 */
	public String getJour() {
		return jour;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setJour(String jour) {
		this.jour = jour;
	}

	/**
	 * @return the duree
	 */
	public int getDuree() {
		return duree;
	}

	/**
	 * @param duree
	 *            the duree to set
	 */
	public void setDuree(int duree) {
		this.duree = duree;
	}

	/**
	 * @return the code
	 */
	public Salle getSalle() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setSalle(Salle code) {
		this.code = code;
	}

	/**
	 * @return the valide
	 */
	public boolean isValide() {
		return valide;
	}

	/**
	 * @param valide
	 *            the valide to set
	 */
	public void setValide(boolean valide) {
		this.valide = valide;
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
		result = prime * result + ((debut == null) ? 0 : debut.hashCode());
		result = prime * result + duree;
		result = prime * result + ((fin == null) ? 0 : fin.hashCode());
		result = prime * result + ((jour == null) ? 0 : jour.hashCode());
		result = prime * result + numplage;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + (valide ? 1231 : 1237);
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
		if (!(obj instanceof Plage))
			return false;
		Plage other = (Plage) obj;
		if (debut == null) {
			if (other.debut != null)
				return false;
		} else if (!debut.equals(other.debut))
			return false;
		if (duree != other.duree)
			return false;
		if (fin == null) {
			if (other.fin != null)
				return false;
		} else if (!fin.equals(other.fin))
			return false;
		if (jour == null) {
			if (other.jour != null)
				return false;
		} else if (!jour.equals(other.jour))
			return false;
		if (numplage != other.numplage)
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (valide != other.valide)
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
		return "\n" + jour + " " + debut + " " + fin + " " + code.getCode()
				+ "]";
	}
}
