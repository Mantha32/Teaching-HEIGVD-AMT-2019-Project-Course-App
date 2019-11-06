/**
 * 
 */
package com.amt.schedule.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author doriane kaffo
 * 
 */


public class Utilisateur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String matricule;

	private boolean sexe;
	private String nom;
	private String password;
	private String email;
	private String grade;

	private java.util.List<Traineau> traineaux;

	java.util.List<Cours> cours;

	java.util.List<Dispenser> dispenser;

	java.util.List<Evenement> evenements;

	java.util.List<Appel> appels;

	private Type statut;

	public Utilisateur() {
		super();
	}

	public Utilisateur(String matricule, String nom, String email,
			boolean sexe, Type statut) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.sexe = sexe;
		this.email = email;
		this.statut = statut;
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

	public java.util.List<Dispenser> getDispensers() {
		return dispenser;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the sexe
	 */
	public boolean getSexe() {
		return sexe;
	}

	/**
	 * @param sexe
	 *            the sexe to set
	 */
	public void setSexe(boolean sexe) {
		this.sexe = sexe;
	}

	public String getMatricule() {
		return matricule;
	}

	/**
	 * @return the traineaux
	 */
	public java.util.List<Traineau> getTraineaux() {
		return traineaux;
	}

	/**
	 * @param traineaux
	 *            the traineaux to set
	 */
	public void setTraineaux(Traineau traineau) {
		traineaux.add(traineau);
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the statut
	 */
	public Type getType() {
		return statut;
	}

	/**
	 * @param statut
	 *            the statut to set
	 */
	public void setType(Type statut) {
		this.statut = statut;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Utilisateur)) return false;
		Utilisateur that = (Utilisateur) o;
		return sexe == that.sexe &&
				matricule.equals(that.matricule) &&
				nom.equals(that.nom) &&
				password.equals(that.password) &&
				email.equals(that.email) &&
				grade.equals(that.grade) &&
				statut.equals(that.statut);
	}

	@Override
	public int hashCode() {
		return Objects.hash(matricule, sexe, nom, password, email, grade, statut);
	}

	@Override
	public String toString() {
		return "Utilisateur{" +
				"matricule='" + matricule + '\'' +
				", sexe=" + sexe +
				", nom='" + nom + '\'' +
				", password='" + password + '\'' +
				", email='" + email + '\'' +
				", grade='" + grade + '\'' +
				", statut=" + statut +
				'}';
	}
}
