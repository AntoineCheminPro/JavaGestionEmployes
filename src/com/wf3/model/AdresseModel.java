package com.wf3.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.swing.JTable;

public class AdresseModel extends Model {

	private Employe employe;
	private int id;
	private Adresse adresse;

	public void addAdresse(Adresse adresse, Employe employe) {

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

	public Adresse verifAdresse(Employe employe) {

		Connection connexion = dbConnect();

		try {
			id = employe.getId();
			Statement statement1 = connexion.createStatement();

			String query = "SELECT rue, postal, ville FROM adresse WHERE id_employe=" + id;

			ResultSet resultat = statement1.executeQuery(query);

			if (resultat.next()) {
				adresse = new Adresse(resultat.getString("rue"), resultat.getString("postal"),
						resultat.getString("ville"));

				return adresse;

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("rien " + adresse);
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
