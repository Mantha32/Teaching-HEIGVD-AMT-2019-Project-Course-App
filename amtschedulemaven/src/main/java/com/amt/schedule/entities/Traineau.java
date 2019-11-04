/**
 * 
 */
package com.amt.schedule.entities;

import java.io.Serializable;

/**
 * @author doriane kaffo
 * 
 */
public class Traineau implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int numero = 0;

	private String jour;
	private String debut;
	private String fin;
	private int duree;

	private Utilisateur matricule;

	public Traineau() {
		super();
	}

	public Traineau(int num, String jour, String debut, String fin,
			Utilisateur matricule) {
		super();
		this.numero = num;
		this.jour = jour;
		this.debut = debut;
		this.fin = fin;
		this.matricule = matricule;
	}

	public int getNumero() {
		return numero;
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
	 * @return the matricule
	 */
	public Utilisateur getUtilisateur() {
		return matricule;
	}

	/**
	 * @param matricule
	 *            the matricule to set
	 */
	public void setEnseignant(Utilisateur matricule) {
		this.matricule = matricule;
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
		result = prime * result
				+ ((matricule == null) ? 0 : matricule.hashCode());
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
		if (!(obj instanceof Traineau))
			return false;
		Traineau other = (Traineau) obj;
		if (debut == null) {
			if (other.debut != null)
				return false;
		} else if (!debut.equals(other.debut))
			return false;
		if (duree != other.duree)
			return false;
		if (matricule == null) {
			if (other.matricule != null)
				return false;
		} else if (!matricule.equals(other.matricule))
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
		return "Traineau [numero=" + numero + ", jour=" + jour + ", debut="
				+ debut + ", fin=" + fin + ", duree=" + duree
				+ ", matricule=" + matricule + "]";
	}
}
