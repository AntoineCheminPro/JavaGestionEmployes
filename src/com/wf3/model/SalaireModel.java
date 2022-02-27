package com.wf3.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Statement;

public class SalaireModel extends Model {

	public int addSalaire(Salaire salaire) {

		Connection connexion = dbConnect();

		PreparedStatement statement;
		try {
			if (connexion != null) {

				statement = connexion.prepareStatement(
						"INSERT INTO salaire " + "(dateDebut, dateFin, chargesPatronales, chargesSalariales, brut) "
								+ "VALUES (?, ?, ?, ?, ?, ?)");

				statement.setDate(1, new java.sql.Date(salaire.getDateDebut().getTime()));
				statement.setDate(2, new java.sql.Date(salaire.getDateFin().getTime()));
				statement.setFloat(4, salaire.getChargesPatronales());
				statement.setFloat(5, salaire.getChargesSalariales());
				statement.setFloat(6, salaire.getBrut());

				statement.executeUpdate();

				statement.close();
				connexion.close();

				return 1;
			}

		} catch (SQLException e1) {
			System.out.println("JDBC probleme" + e1);
		}

		return 0;
	}

	public int editSalaire(Salaire salaire) {

		Connection connexion = dbConnect();

		PreparedStatement statement;
		try {
			statement = connexion.prepareStatement("UPDATE salaire SET "
					+ "dateDabut=?, dateFin=?, chargesPatronales=?, chargesSalariales=?, brut=?" + "WHERE id="
					+ salaire.getId());
			
			statement.setDate(1, new java.sql.Date(salaire.getDateDebut().getTime()));
			statement.setDate(2, new java.sql.Date(salaire.getDateFin().getTime()));
			statement.setFloat(3, salaire.getChargesPatronales());
			statement.setFloat(3, salaire.getChargesSalariales());
			statement.setFloat(3, salaire.getBrut());
			statement.executeUpdate();

			statement.close();
			connexion.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 1;

	}

	public int deleteSalaire(int id) throws ParseException {

		Connection connexion = dbConnect();

		PreparedStatement statement;
		try {
			statement = connexion.prepareStatement("DELETE FROM salaire WHERE id=" + id);
				statement.executeUpdate();

				statement.close();
				connexion.close();

			

		} catch (SQLException e1) {
			System.out.println("JDBC probleme" + e1);
		}

		return 0;
	}

	public ArrayList<Salaire> getAllSalaires() throws ParseException {
		Connection connexion = dbConnect();

		PreparedStatement statement;
		try {

			if (connexion != null) {
				// create JDBC statement object
				Statement st = connexion.createStatement();

				// prepare SQL query
				String query = "SELECT id, dateDebut, dateFin, chargesPatronales, chargesSalariales, brut"
						+ " FROM salaire";
				ResultSet resultat = st.executeQuery(query);

				ArrayList<Salaire> salaires = new ArrayList<Salaire>();

				while (resultat.next()) {
					
					Salaire salaire = new Salaire(new SimpleDateFormat("yyyy-mm-dd").parse(resultat.getString("dateDebut")),
							new SimpleDateFormat("yyyy-mm-dd").parse(resultat.getString("dateFin")),
							resultat.getFloat("chagesPatronales"), resultat.getFloat("chargesSalariales"), resultat.getFloat("brut"));
					salaire.setId(resultat.getInt("id"));
					salaires.add(salaire);
				}

				resultat.close();
				st.close();
				connexion.close();

				return salaires;

			}

		} catch (SQLException e1) {
			System.out.println("JDBC connection is not established" + e1);
			// e1.printStackTrace();
		}

		return null;
	}

	public Salaire OneSalaireeById(int choosen_id) throws ParseException {

		Connection connexion = dbConnect();

		Statement statement;
		try {

			

			if (connexion != null) {
				// create JDBC statement object
				statement = connexion.createStatement();

				// prepare SQL query
				String query = "SELECT id, dateDebut, dateFin, chargesPatronales, chargesSalariales, brut"
						+ " FROM salaire "
						+ "WHERE id= "+ choosen_id;
				ResultSet resultat = statement.executeQuery(query);

				
				while (resultat.next()) {
					
					Salaire salaire = new Salaire(new SimpleDateFormat("yyyy-mm-dd").parse(resultat.getString("dateDebut")),
							new SimpleDateFormat("yyyy-mm-dd").parse(resultat.getString("dateFin")),
							resultat.getFloat("chagesPatronales"), resultat.getFloat("chargesSalariales"), resultat.getFloat("brut"));
					salaire.setId(choosen_id);
					return salaire;
				}

				resultat.close();
				statement.close();
				connexion.close();

				
			}

		} catch (SQLException e1) {
			System.out.println("JDBC connection is not established" + e1);
//e1.printStackTrace();
		}

		return null;
	}
}
