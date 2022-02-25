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

public class EmployeModel extends Model {
	

public int addEmploye(Employe employe) {
		
		try {
	        Connection connexion = DriverManager.getConnection(url, user, password);

	        if ( connexion != null) {
	        	
        	PreparedStatement statement = connexion.prepareStatement (
        			"INSERT INTO employes "
        			+ "(nom, prenom, sexe, date_naissance, date_embauche, code, quotite) "
        			+ "VALUES (?, ?, ?, ?, ?, ?, ?)");
        	statement.setString(1, employe.getNom()); 
        	statement.setString(2, employe.getPrenom()); 
        	statement.setInt(3, employe.getSexe()); 
        	statement.setDate(4, new java.sql.Date(employe.getDateDeNaissance().getTime()));
        	statement.setDate(5, new java.sql.Date(employe.getDateEmbauche().getTime()));
        	statement.setString(6, employe.getCode()); 
        	statement.setInt(7, employe.getQuotite()); 
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

public int editEmploye(Employe employe) {
	
	Connection connexion = dbConnect();
        	
    	PreparedStatement statement;
		try {
			statement = connexion.prepareStatement (
					"UPDATE employes SET "
					+ "nom=?, prenom=?, sexe=?, date_naissance=?, date_embauche=?, code=?, quotite=? "
				 			+ "WHERE id="+employe.getId());
			statement.setString(1, employe.getNom()); 
	    	statement.setString(2, employe.getPrenom()); 
	    statement.setInt(3, employe.getSexe()); 
	    	statement.setDate(4, new java.sql.Date(employe.getDateDeNaissance().getTime()));
	    	statement.setDate(5, new java.sql.Date(employe.getDateEmbauche().getTime()));
	    	statement.setString(6, employe.getCode()); 
	    	statement.setInt(7, employe.getQuotite()); 
	    	statement.executeUpdate();
	  
	    	statement.close();
		    connexion.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	    return 1;
    


}

public int deleteEmploye(int id) throws ParseException {
	
	try {
        Connection connexion = DriverManager.getConnection(url, user, password);

        if ( connexion != null) {
        	
    	PreparedStatement statement = connexion.prepareStatement (
    			"DELETE FROM employes WHERE id="+id);
    	statement.executeUpdate();
    	
    	statement.close();
	    connexion.close();
	    
  }

} catch (SQLException e1) {
    System.out.println("JDBC probleme" + e1);
    }

	return 0;
}


	
public ArrayList<Employe> getAllEmploye() throws ParseException {
			try {
			Connection con = DriverManager.getConnection(url, user, password);
			
			
			if ( con != null) {
				// create JDBC statement object
		     Statement st = con.createStatement();
		     
		     // prepare SQL query
		      String query = "SELECT id, nom, prenom, sexe, date_naissance, "
		      		+ "date_embauche, quotite, code  FROM employes";
		      
		      ResultSet resultat = st.executeQuery(query);
		      
		      ArrayList<Employe> employes = new ArrayList<Employe>();
		      
		      while (resultat.next()) {
		    	  //String nom, String prenom, int sexe, Date dateDeNaissance, Date dateEmbauche, int quotite,
				//	Adresse adresse, Fonction fonction, Salaire salaire, Conges[] conges, String code
		         Employe employe = new Employe( 
		        		 resultat.getString("nom"), 
		        		 resultat.getString("prenom"), 
		        		 resultat.getInt("sexe"), 
		        		 new SimpleDateFormat("yyyy-mm-dd").parse(resultat.getString("date_naissance")), 
		        		 new SimpleDateFormat("yyyy-mm-dd").parse(resultat.getString("date_embauche")), 
		        		 resultat.getInt("quotite"),
		        		 resultat.getString("code"));
		         			employe.setId(resultat.getInt("id"));
		         employes.add(employe);
		      }
		      
		      
		      resultat.close();
		      st.close();
		      con.close();
		      
		     return employes;
		     
		}
	      
	} catch (SQLException e1) {
		System.out.println("JDBC connection is not established" + e1);
		//e1.printStackTrace();
		}
		
		return null;
	}
	
public Employe OneEmployeById(int choosen_id) throws ParseException {
		
try {
	Connection con = DriverManager.getConnection(url, user, password);
	
	 ArrayList<Employe> employes = new ArrayList<Employe>();
	
	if ( con != null) {
		// create JDBC statement object
		Statement statement = con.createStatement();
 
		// prepare SQL query
		String query = "SELECT id, nom, prenom, sexe, date_naissance, date_embauche, quotite, code  FROM employes WHERE id="+choosen_id;
  
		ResultSet resultat = statement.executeQuery(query);
  
		      
		if (resultat.next()) {
			//String nom, String prenom, int sexe, Date dateDeNaissance, Date dateEmbauche, int quotite,
			//	Adresse adresse, Fonction fonction, Salaire salaire, Conges[] conges, String code
			Employe employe = new Employe(resultat.getString("nom"), resultat.getString("prenom"), resultat.getInt("sexe"), new SimpleDateFormat("yyyy-mm-dd").parse(resultat.getString("date_naissance")), new SimpleDateFormat("yyyy-mm-dd").parse(resultat.getString("date_embauche")), 
					resultat.getInt("quotite"),resultat.getString("code"));
			employe.setId(choosen_id);
	         return employe;
	         
	      }
	      
	      resultat.close();
	      statement.close();
	      con.close();
 
	}
      
} catch (SQLException e1) {
	System.out.println("JDBC connection is not established" + e1);
//e1.printStackTrace();
}

return null;
	}
}


