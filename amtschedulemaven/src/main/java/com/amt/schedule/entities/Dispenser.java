/**
 * 
 */
package com.amt.schedule.entities;

import java.io.Serializable;

/**
 * @author doriane kaffo
 * 
 */
public class Dispenser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Utilisateur matricule;

	private Matiere code;

	private String type;

	private boolean occp;

	public Dispenser() {
		super();
	}

	public Dispenser(Utilisateur matricule, Matiere code) {
		this.matricule = matricule;
		this.code = code;
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

	/**
	 * @return the code
	 */
	public Matiere getMatiere() {
		return code;
	}

	public Utilisateur getUtilisateur() {
		return matricule;
	}

	/**
	 * @return the occp
	 */
	public boolean isOccp() {
		return occp;
	}

	/**
	 * @param occp
	 *            the occp to set
	 */
	public void setOccp(boolean occp) {
		this.occp = occp;
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
		result = prime * result + (occp ? 1231 : 1237);
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
		if (!(obj instanceof Dispenser))
			return false;
		Dispenser other = (Dispenser) obj;
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
		if (occp != other.occp)
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
		return "Dispenser [matricule=" + matricule
				+ ", code=" + code + ", type=" + type + ", occp=" + occp
				+ "]";
	}

}
