package com.wf3.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdresseModel extends Model {

	private Employe employe;
	private int id;
	
	public void addAdresse(Adresse adresse, Employe employe) {
	     
		try {
        Connection connexion = DriverManager.getConnection(url, user, password);
        id = employe.getId();
        if ( connexion != null) { 
	    	
	    	PreparedStatement statement = connexion.prepareStatement (
	    			"INSERT INTO adresse(rue, postal, ville, employe_id) "
	    			+ "VALUES (?,?,?,?)");
	    	
	    	statement.setString(1, adresse.getRue());
	    	statement.setString(2, adresse.getPostal());
	    	statement.setString(3, adresse.getVille());
	    	statement.setInt(4, id);
	    	statement.executeUpdate();
	    	
	    	statement.close();
	    	
	    	

        }
	    } catch(SQLException e1) {
	    	System.out.println("JDBC probleme de connexion" + e1);
	    	
	    }


	}
        
	public void editAdresse() {
		
	}	

}
