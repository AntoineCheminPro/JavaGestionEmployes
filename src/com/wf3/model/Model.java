package com.wf3.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Model {
	
	final String url = "jdbc:mysql:///gestionemploye";
    final String user = "root";
    final String password = "";
    
    
    public Connection dbConnect () {
    
    try {
    	 
        Connection connexion = DriverManager.getConnection(url, user, password);
        
        if (connexion != null) {
            System.out.println("Connected");
            return connexion;
          
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
	return null;
	
    }
}