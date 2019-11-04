/**
 * 
 */
package com.amt.schedule.entities;

import java.io.Serializable;

/**
 * @author doriane kaffo
 * 
 */
public class Date implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int numero = 0;

	private String jour;
	private String debut;
	private String fin;

	java.util.List<Evenement> evenements;

	public Date() {
		super();
	}

	public Date(int numero, String jour, String debut, String fin) {
		super();
		this.numero = numero;
		this.jour = jour;
		this.debut = debut;
		this.fin = fin;
	}

	public java.util.List<Evenement> getEvenement() {
		return evenements;
	}

	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @return the jour
	 */
	public String getJour() {
		return jour;
	}

	/**
	 * @param jour
	 *            the jour to set
	 */
	public void setJour(String jour) {
		this.jour = jour;
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
		result = prime * result + ((fin == null) ? 0 : fin.hashCode());
		result = prime * result + ((jour == null) ? 0 : jour.hashCode());
		result = prime * result + numero;
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
		if (!(obj instanceof Date))
			return false;
		Date other = (Date) obj;
		if (debut == null) {
			if (other.debut != null)
				return false;
		} else if (!debut.equals(other.debut))
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
		if (numero != other.numero)
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
		return "Date [jour=" + jour + ", debut=" + debut + ", fin=" + fin + "]";
	}
}
