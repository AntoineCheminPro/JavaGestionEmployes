package com.wf3.model;

import java.util.Calendar;
import java.util.Date;

public class Salaire {

	private Date dateDebut;
	private Date dateFin;
	private float chargesPatronales;
	private float chargesSalariales;
	private float brut;
	private int id;
	private int id_employe;

	public float salaireCharge() {
		float chargesTotales = this.chargesPatronales + this.chargesSalariales;
		return chargesTotales;
	}

	public float salaireNet() {
		float chargeTotales = this.salaireCharge();
		return this.brut - chargeTotales;
	}

	public boolean salaireEnCours() {
		Calendar dateDuJour = Calendar.getInstance();
		Calendar dateDeFin = Calendar.getInstance();
		dateDeFin.setTime(this.getDateFin());
		if (dateDuJour.after(dateDeFin)) {
			return false;
		}
		return true;
	}

	public Salaire(Date dateDebut, Date dateFin, float chargesPatronales, float chargesSalariales, float brut) {
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.chargesPatronales = chargesPatronales;
		this.chargesSalariales = chargesSalariales;
		this.brut = brut;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public float getChargesPatronales() {
		return chargesPatronales;
	}

	public void setChargesPatronales(float chargesPatronales) {
		this.chargesPatronales = chargesPatronales;
	}

	public float getChargesSalariales() {
		return chargesSalariales;
	}

	public void setChargesSalariales(float chargesSalariales) {
		this.chargesSalariales = chargesSalariales;
	}

	public float getBrut() {
		return brut;
	}

	public void setBrut(float brut) {
		this.brut = brut;
	}

	public int getId_employe() {
		return id_employe;
	}

	public void setId_employe(int id_employe) {
		this.id_employe = id_employe;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
