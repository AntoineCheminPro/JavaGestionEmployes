package com.wf3.model;

import java.util.Date;

public class Fonction {
	protected String titre;
	private int rtt;
	private Date date;
	private int niveau;
	private String departement;

	public Fonction(String titre, int rtt, Date date, int niveau, String departement) {
		this.titre = titre;
		this.rtt = rtt;
		this.date = date;
		this.niveau = niveau;
		this.departement = departement;
	}

	public float salaireCharge() {
		return 0;

	}

	public float salaireNet() {
		return 0;

	}

	public boolean salaireEnCours() {
		return false;

	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getRtt() {
		return rtt;
	}

	public void setRtt(int rtt) {
		this.rtt = rtt;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

}
