package com.wf3.model;

import java.time.DateTimeException;
import java.util.Arrays;
import java.util.Date;

public class Employe extends Personne {

	private int id;
	private Date dateEmbauche;
	private int quotite;
	private Adresse adresse;
	private Fonction fonction;
	private Salaire salaire;
	private Conges[] conges;
	private String code;
	
	   

	public Employe(String nom, String prenom, int sexe, Date dateDeNaissance, Date dateEmbauche, int quotite,
			Adresse adresse, Fonction fonction, Salaire salaire, Conges[] conges, String code) {
		super(nom, prenom, sexe, dateDeNaissance);
		this.dateEmbauche = dateEmbauche;
		this.quotite = quotite;
		this.adresse = adresse;
		this.fonction = fonction;
		this.salaire = salaire;
		this.conges = conges;
		this.code = code;
	}

	public Employe(String nom, String prenom, int sexe, Date dateDeNaissance, Date dateEmbauche, int quotite,String code)
	{
		super(nom, prenom, sexe, dateDeNaissance);
		this.dateEmbauche = dateEmbauche;
		this.quotite = quotite;
		this.code = code;
	}



	public int congesRestants() {
		return this.congesTotaux() - this.congesPris();
	}

	public int congesTotaux() {
		int congeTotaux = 0;

		for (Conges conge : this.conges) {

			congeTotaux += conge.nbJours();

		}
		return congeTotaux;
	}

	public int congesPris() {
		int congePris = 0;

		for (Conges conge : this.conges) {

			if (conge.isPassed(conge.dateFin)) {

				congePris += conge.nbJours();
			}
		}
		return congePris;
	}

	public void prendreConges(Date debut, Date fin) {

		conges = Arrays.copyOf(conges, conges.length + 1);
		try {
			conges[conges.length - 1] = new Conges(debut, fin);
		} catch (DateTimeException e) {
			System.out.println("Attention, le format des dates " + debut + " " + fin + " n'est pas valide !");
		}

	}

	public void changerSalaire(float brut, float chargesP, float chargesS) {

		// teste si le brut est bien positif
		try {
			if (brut < 0) {
				throw new Exception();
			} else {
				this.salaire.setBrut(brut);
				System.out.println("le nouveau salaire brut est de : " + brut);
			}
		} catch (Exception exception) {
			System.out.println("Le brut ne peut être négatif");
		}

		// teste si les chages patronales sont bien positives
		try {
			if (chargesP < 0) {
				throw new Exception();
			} else {
				this.salaire.setChargesPatronales(chargesP);
				System.out.println("Le nouveau montant des charges Patronales est de : " + chargesP);
			}
		} catch (Exception exception) {
			System.out.println("Les charges Patronales ne peuvent être négatives");
		}

		// teste si les charges salariales sont bien positives
		try {
			if (chargesS < 0) {
				throw new Exception();
			} else {
				this.salaire.setChargesSalariales(chargesS);
				System.out.println("le nouveau montant des charges Salariales est de : " + chargesS);
			}
		} catch (Exception exception) {
			System.out.println("Les charges Salariales ne peuvent être négatives");
		}
	}

	public Date getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	public int getQuotite() {
		return quotite;
	}

	public void setQuotite(int quotite) {
		this.quotite = quotite;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Fonction getFonction() {
		return fonction;
	}

	public void setFonction(Fonction fonction) {
		this.fonction = fonction;
	}

	public Salaire getSalaire() {
		return salaire;
	}

	public void setSalaire(Salaire salaire) {
		this.salaire = salaire;
	}

	public Conges[] getConges() {
		return conges;
	}

	public void setConges(Conges[] conges) {
		this.conges = conges;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
