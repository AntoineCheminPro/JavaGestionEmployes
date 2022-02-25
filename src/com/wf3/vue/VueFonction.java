package com.wf3.vue;

import java.awt.EventQueue;
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

public class VueFonction extends JFrame {

	private JFrame frame;

	

	/**
	 * Create the frame.
	 */
	public VueFonction() {
		frame = new JFrame();
		frame.setBounds(100, 100, 453, 725);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel labelFonction = new JLabel("Fonction");
		labelFonction.setBounds(10, 299, 63, 14);
		frame.getContentPane().add(labelFonction);
		
		JLabel labelDateFonction = new JLabel("Date");
		labelDateFonction.setBounds(83, 299, 28, 14);
		frame.getContentPane().add(labelDateFonction);
		
		JTextField dateFonction = new JTextField();
		labelDateFonction.setLabelFor(dateFonction);
		dateFonction.setBounds(195, 296, 86, 20);
		frame.getContentPane().add(dateFonction);
		dateFonction.setColumns(10);
		
		JLabel labelTitreFonction = new JLabel("Titre");
		labelTitreFonction.setBounds(83, 324, 46, 14);
		frame.getContentPane().add(labelTitreFonction);
		
		JTextField titreFonction = new JTextField();
		labelTitreFonction.setLabelFor(titreFonction);
		titreFonction.setBounds(195, 321, 86, 20);
		frame.getContentPane().add(titreFonction);
		titreFonction.setColumns(10);
		
		JLabel labelDepartementFonction = new JLabel("Departement");
		labelDepartementFonction.setBounds(83, 349, 106, 14);
		frame.getContentPane().add(labelDepartementFonction);
		
		JTextField departementFonction = new JTextField();
		labelDepartementFonction.setLabelFor(departementFonction);
		departementFonction.setBounds(195, 346, 86, 20);
		frame.getContentPane().add(departementFonction);
		departementFonction.setColumns(10);
		
		JLabel labelNiveauFonction = new JLabel("Niveau");
		labelNiveauFonction.setBounds(83, 374, 46, 14);
		frame.getContentPane().add(labelNiveauFonction);
		
		JTextField niveauFonction = new JTextField();
		labelNiveauFonction.setLabelFor(niveauFonction);
		niveauFonction.setBounds(195, 371, 86, 20);
		frame.getContentPane().add(niveauFonction);
		niveauFonction.setColumns(10);
		
		JLabel labelRttFonction = new JLabel("RTT");
		labelRttFonction.setBounds(83, 399, 46, 14);
		frame.getContentPane().add(labelRttFonction);
		
		JTextField rttFonction = new JTextField();
		labelRttFonction.setLabelFor(rttFonction);
		rttFonction.setBounds(195, 396, 86, 20);
		frame.getContentPane().add(rttFonction);
		rttFonction.setColumns(10);
		
		
		JButton btnNewButton = new JButton("Enregistrer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionDate gestion = new GestionDate();
				
				
				Date dateF = gestion.stringToDate(dateFonction.getText());
				String titreF = titreFonction.getText();
				String departementF = departementFonction.getText();
				int niveauF = Integer.parseInt(niveauFonction.getText());
				int rttF = Integer.parseInt(rttFonction.getText());
				Fonction fonction = new Fonction(dateF, titreF, departementF, niveauF, rttF);
				
				
				
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
