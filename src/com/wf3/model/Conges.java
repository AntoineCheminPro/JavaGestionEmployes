package com.wf3.model;

import java.util.Date;

public class Conges extends GestionDate {

	protected Date dateDebut;
	protected Date dateFin;

	public int NbJours() {
		return 0;
	}

	public Conges(Date dateDebut, Date dateFin) {

		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	public int nbJours() {
		int nBjours = diffDays(this.dateDebut, this.dateFin);
		return nBjours;
		
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

}
