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
import java.awt.Color;

public class VueConges extends JFrame {

	private JFrame frame;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueConges frame = new VueConges();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VueConges() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GREEN);
		frame.setBounds(100, 100, 453, 215);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel labelConges = new JLabel("Conges");
		labelConges.setBounds(195, 11, 46, 14);
		frame.getContentPane().add(labelConges);
		
		JLabel labelDebutConges = new JLabel("Debut");
		labelDebutConges.setBounds(83, 44, 46, 14);
		frame.getContentPane().add(labelDebutConges);
		
		JTextField debutConges = new JTextField();
		labelDebutConges.setLabelFor(debutConges);
		debutConges.setBounds(185, 41, 86, 20);
		frame.getContentPane().add(debutConges);
		debutConges.setColumns(10);
		
		JLabel labelFinConges = new JLabel("Fin");
		labelFinConges.setBounds(83, 69, 46, 14);
		frame.getContentPane().add(labelFinConges);
		
		JTextField finConges = new JTextField();
		labelFinConges.setLabelFor(finConges);
		finConges.setBounds(185, 72, 86, 20);
		frame.getContentPane().add(finConges);
		finConges.setColumns(10);
		

		
		
		JButton btnNewButton = new JButton("Enregistrer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GestionDate gestion = new GestionDate();
				
				Date debutC = gestion.stringToDate(debutConges.getText());
				Date finC = gestion.stringToDate(finConges.getText());
				Conges conges = new Conges(debutC, finC);
				
				Conges tableauConges[] = {conges};
			
				
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
		btnNewButton.setBounds(139, 117, 102, 23);
		frame.getContentPane().add(btnNewButton);
	}

}
