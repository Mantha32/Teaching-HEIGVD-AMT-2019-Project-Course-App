/**
 * 
 */
package com.amt.schedule.entities;

import java.io.Serializable;

/**
 * @author doriane kaffo
 * 
 */
public class Salle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String code;

	private int contenance;

	private java.util.List<Plage> plages;

	public Salle() {
		super();
	}

	public Salle(String code, int contenance) {
		super();
		this.code = code;
		this.contenance = contenance;
	}

	public String getCode() {
		return code;
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
	 * @return the plages
	 */
	public java.util.List<Plage> getPlages() {
		return plages;
	}

	/**
	 * @param plages
	 *            the plages to set
	 */
	public void setPlages(Plage plage) {
		plages.add(plage);
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
		result = prime * result + contenance;
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
		if (!(obj instanceof Salle))
			return false;
		Salle other = (Salle) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (contenance != other.contenance)
			return false;
		return true;
	}
}
