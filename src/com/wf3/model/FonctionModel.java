package com.wf3.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FonctionModel extends Model {

	private Employe employe;
	private int id;
	private Fonction fonction;

	public void addFonction(Fonction fonction, Employe employe) {

		Connection connexion = dbConnect();
		PreparedStatement statement;
		try {

			id = employe.getId();
			statement = connexion
					.prepareStatement("INSERT INTO fonction(date, titre, departement, niveau, rtt, id_employe) " 
			+ "VALUES (?,?,?,?,?)");

			statement.setDate(1, new java.sql.Date(fonction.getDate().getTime()));
			statement.setString(2, fonction.getTitre());
			statement.setString(3, fonction.getDepartement());
			statement.setInt(4, fonction.getNiveau());
			statement.setInt(5, fonction.getRtt());
			statement.setInt(6, id);
			statement.executeUpdate();

			statement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Fonction verifFonction(Employe employe) throws ParseException {

		Connection connexion = dbConnect();

		try {
			id = employe.getId();
			Statement statement1 = connexion.createStatement();

			//date, titre, departement, niveau, rtt
			String query = "SELECT date, titre, departement, "
					+ "niveau, rtt FROM fonction WHERE id_employe=" + id;

			ResultSet resultat = statement1.executeQuery(query);

			if (resultat.next()) {
				fonction = new Fonction(new SimpleDateFormat("yyyy-mm-dd")
						.parse(resultat.getString("date")),
						resultat.getString("titre"),
						resultat.getString("departement"),
						resultat.getInt("niveau"),
						resultat.getInt("rtt"));

				return fonction;

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;

	}

	public void editAdresse(Adresse adresse) {

		Connection connexion = dbConnect();

		PreparedStatement statement;
		try {

			id = adresse.getId_employe();
			

			statement = connexion.prepareStatement
				("UPDATE adresse SET " + "Rue=?, Postal=?, Ville=?" 
						+ "WHERE id_employe=" + id);

			statement.setString(1, adresse.getRue());
			System.out.println(adresse.getRue());
			statement.setString(2, adresse.getPostal());
			statement.setString(3, adresse.getVille());

			statement.executeUpdate();

			statement.close();

		} catch (SQLException e1) {
			System.out.println("JDBC probleme de connexion" + e1);

		}

	}

}
