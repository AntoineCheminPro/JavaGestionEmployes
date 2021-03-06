package com.wf3.model;

public class Adresse {

	private String rue;
	private String postal;
	private String ville;
	private int id_employe;

	public Adresse(String rue, String postal, String ville) {

		this.rue = rue;
		this.postal = postal;
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Adresse [rue=" + rue + ", postal=" + postal + ", ville=" + ville + "]";
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getId_employe() {
		return id_employe;
	}

	public void setId_employe(int id_employe) {
		this.id_employe = id_employe;
	}

}
