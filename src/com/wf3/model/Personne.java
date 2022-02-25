package com.wf3.model;

import java.util.Calendar;
import java.util.Date;

public abstract class Personne extends GestionDate {
	protected String nom;
	protected String prenom;
	protected int sexe;
	protected Date dateDeNaissance;

	public int age() {

		// créé deux formats de date
		Calendar dateDuJour = Calendar.getInstance();
		Calendar naissance = Calendar.getInstance();

		// mets la date de naissance dans le paramétre naissance
		naissance.setTime(dateDeNaissance);

		// calcul la différence de d'années
		int age = dateDuJour.get(Calendar.YEAR) - naissance.get(Calendar.YEAR);
		dateDuJour.add(Calendar.YEAR, -age);

		// vérifie si l'anniversaire est passé ou non
		if (naissance.after(dateDuJour)) {
			age = age - 1;
		}
		return age;
	}

	public Personne(String nom, String prenom, int sexe, Date dateDeNaissance) {
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getSexe() {
		return sexe;
	}

	public void setSexe(int sexe) {
		this.sexe = sexe;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe + ", dateDeNaissance=" + dateDeNaissance
				+ "]";
	}

}
