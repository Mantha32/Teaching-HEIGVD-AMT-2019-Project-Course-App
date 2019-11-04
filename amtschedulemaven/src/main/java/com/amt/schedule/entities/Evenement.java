/**
 * 
 */
package com.amt.schedule.entities;

import java.io.Serializable;

/**
 * @author doriane kaffo
 * 
 */
public class Evenement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Utilisateur matricule;

	private Date numero;

	private Plage numplage;

	private Niveau niveau;

	private String titre;
	private int contenance;
	private int duree;
	private String description;

	public Evenement() {
		super();
	}

	public Evenement(Utilisateur matricule, Date numero, Plage numplage,
			Niveau niveau, String titre, int contenance) {
		super();
		this.matricule = matricule;
		this.numero = numero;
		this.numplage = numplage;
		this.niveau = niveau;
		this.titre = titre;
		this.contenance = contenance;
	}

	public Utilisateur getUtilisateur() {
		return matricule;
	}

	public Niveau getNiveau() {
		return niveau;
	}

	public Date getDate() {
		return numero;
	}

	public Plage getPlage() {
		return numplage;
	}

	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * @param titre
	 *            the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * @return the contenance
	 */
	public int getContenance() {
		return contenance;
	}

	/**
	 * @param contenance
	 *            the contenance to set
	 */
	public void setContenance(int contenance) {
		this.contenance = contenance;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
		result = prime * result + contenance;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + duree;
		result = prime * result + ((niveau == null) ? 0 : niveau.hashCode());
		result = prime * result + ((numplage == null) ? 0 : numplage.hashCode());
		result = prime * result + ((titre == null) ? 0 : titre.hashCode());
		result = prime * result
				+ ((matricule == null) ? 0 : matricule.hashCode());
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
		if (!(obj instanceof Evenement))
			return false;
		Evenement other = (Evenement) obj;
		if (contenance != other.contenance)
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (duree != other.duree)
			return false;
		if (niveau == null) {
			if (other.niveau != null)
				return false;
		} else if (!niveau.equals(other.niveau))
			return false;
		if (numplage == null) {
			if (other.numplage != null)
				return false;
		} else if (!numplage.equals(other.numplage))
			return false;
		if (titre == null) {
			if (other.titre != null)
				return false;
		} else if (!titre.equals(other.titre))
			return false;
		if (matricule == null) {
			if (other.matricule != null)
				return false;
		} else if (!matricule.equals(other.matricule))
			return false;
		return true;
	}

}
