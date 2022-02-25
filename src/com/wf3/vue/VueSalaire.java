package com.wf3.vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.wf3.model.Adresse;
import com.wf3.model.Conges;
import com.wf3.model.Employe;
import com.wf3.model.Fonction;
import com.wf3.model.GestionDate;
import com.wf3.model.Salaire;

public class VueSalaire extends JFrame {

	private JFrame frame;

	

	/**
	 * Create the frame.
	 */
	public VueSalaire() {
		frame = new JFrame();
		frame.setBounds(100, 100, 453, 725);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

		JLabel labelSalaire = new JLabel("Salaire");
		labelSalaire.setBounds(10, 430, 46, 14);
		frame.getContentPane().add(labelSalaire);
		
		JLabel labelDebutSalaire = new JLabel("Debut");
		labelDebutSalaire.setBounds(83, 430, 46, 14);
		frame.getContentPane().add(labelDebutSalaire);
		
		JTextField debutSalaire = new JTextField();
		labelDebutSalaire.setLabelFor(debutSalaire);
		debutSalaire.setBounds(195, 427, 86, 20);
		frame.getContentPane().add(debutSalaire);
		debutSalaire.setColumns(10);
		
		JLabel labelFinSalaire = new JLabel("Fin");
		labelFinSalaire.setBounds(83, 455, 46, 14);
		frame.getContentPane().add(labelFinSalaire);
		
		JTextField finSalaire = new JTextField();
		labelFinSalaire.setLabelFor(finSalaire);
		finSalaire.setBounds(195, 452, 86, 20);
		frame.getContentPane().add(finSalaire);
		finSalaire.setColumns(10);
		
		JLabel labelChargesP = new JLabel("Charges patronales");
		labelChargesP.setBounds(83, 480, 119, 14);
		frame.getContentPane().add(labelChargesP);
		
		JTextField chargesPSalaire = new JTextField();
		labelChargesP.setLabelFor(chargesPSalaire);
		chargesPSalaire.setBounds(195, 477, 86, 20);
		frame.getContentPane().add(chargesPSalaire);
		chargesPSalaire.setColumns(10);
		
		JLabel labelChargesS = new JLabel("Charges salariales");
		labelChargesS.setBounds(83, 505, 119, 14);
		frame.getContentPane().add(labelChargesS);
		
		JTextField chargesSSalaire = new JTextField();
		labelChargesS.setLabelFor(chargesSSalaire);
		chargesSSalaire.setBounds(195, 502, 86, 20);
		frame.getContentPane().add(chargesSSalaire);
		chargesSSalaire.setColumns(10);
		
		JLabel labelBrut = new JLabel("Brut");
		labelBrut.setBounds(83, 536, 46, 14);
		frame.getContentPane().add(labelBrut);
		
		JTextField brutSalaire = new JTextField();
		labelBrut.setLabelFor(brutSalaire);
		brutSalaire.setBounds(195, 533, 86, 20);
		frame.getContentPane().add(brutSalaire);
		brutSalaire.setColumns(10);

		JButton btnNewButton = new JButton("Enregistrer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionDate gestion = new GestionDate();
				
				Date debutS = gestion.stringToDate(debutSalaire.getText());
				Date finS = gestion.stringToDate(finSalaire.getText());
				int chargesPS = Integer.parseInt(chargesPSalaire.getText());
				int chargesSS = Integer.parseInt(chargesSSalaire.getText());
				int brutS = Integer.parseInt(brutSalaire.getText());
				Salaire salaire = new Salaire(debutS, finS, chargesPS, chargesSS, brutS);
				
				
				final String url = "jdbc:mysql:///gestionemploye";
			    final String user = "root";
			    final String password = "";
		    
			    try {
			    	Connection con = DriverManager.getConnection(url, user, password);
			    	PreparedStatement insert = con.prepareStatement("INSERT INTO employes(nom, prenom, sexe, date_naissance, code, quotite, date_embauche) VALUES (?,?,?,?,?,?,?)");
			    	insert.setString(1, nomE);
			    	insert.setString(2, prenomE);
			    	insert.setInt(3, sexeE);
			    	insert.setDate(4, new java.sql.Date(dateNaissanceE.getTime()));
			    	insert.setString(5, codeE);
			    	insert.setInt(6, quotite);
			    	insert.setDate(7, new java.sql.Date(dateEmbaucheE.getTime()));
			    	insert.executeUpdate();
			    	
			    	insert.close();
			    	
			    } catch(SQLException e1) {
			    	System.out.println("JDBC probleme de connexion" + e1);
			    }
			}
		});
		btnNewButton.setBounds(169, 652, 102, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
