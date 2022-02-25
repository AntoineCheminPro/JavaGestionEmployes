package com.wf3.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
					.prepareStatement("INSERT INTO adresse(rue, postal, ville, id_employe) " + "VALUES (?,?,?,?)");

			statement.setString(1, adresse.getRue());
			statement.setString(2, adresse.getPostal());
			statement.setString(3, adresse.getVille());
			statement.setInt(4, id);
			statement.executeUpdate();

			statement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Adresse verifFonction(Employe employe) {

		Connection connexion = dbConnect();

		try {
			id = employe.getId();
			Statement statement1 = connexion.createStatement();

			String query = "SELECT rue, postal, ville FROM adresse WHERE id_employe=" + id;

			ResultSet resultat = statement1.executeQuery(query);

			if (resultat.next()) {
				fonction = new Fonction(resultat.getString("rue"), resultat.getString("postal"),
						resultat.getString("ville"));

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
