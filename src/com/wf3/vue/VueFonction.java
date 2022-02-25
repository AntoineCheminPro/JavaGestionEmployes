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
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.wf3.model.Adresse;
import com.wf3.model.Conges;
import com.wf3.model.Employe;
import com.wf3.model.Fonction;
import com.wf3.model.GestionDate;
import com.wf3.model.Salaire;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;

public class VueFonction extends JPanel {

	private JPanel panel;
	private Fonction fonction;
	

	/**
	 * Create the frame.
	 */
	public VueFonction() {
		panel = new JPanel();
		panel.setBounds(100, 100, 351, 317);
		panel.setLayout(null);
				
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.CYAN);
		panel_6.setBounds(43, 11, 237, 295);
		panel.add(panel_6);
				panel_6.setLayout(null);
		
				JLabel labelFonction = new JLabel("Fonction");
				labelFonction.setBounds(71, 11, 111, 14);
				panel_6.add(labelFonction);
				
				JPanel panel_1 = new JPanel();
				panel_1.setBounds(50, 36, 152, 40);
				panel_6.add(panel_1);
				
				JLabel labelDateFonction = new JLabel("Date");
				
				JTextField dateFonction = new JTextField();
				dateFonction.setColumns(10);
				labelDateFonction.setLabelFor(dateFonction);
				GroupLayout gl_panel_1 = new GroupLayout(panel_1);
				gl_panel_1.setHorizontalGroup(
					gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(16)
							.addComponent(labelDateFonction)
							.addGap(5)
							.addComponent(dateFonction, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
				gl_panel_1.setVerticalGroup(
					gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(8)
							.addComponent(labelDateFonction))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(5)
							.addComponent(dateFonction, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
				panel_1.setLayout(gl_panel_1);
				
				JPanel panel_2 = new JPanel();
				panel_2.setBounds(50, 87, 152, 34);
				panel_6.add(panel_2);
				
				JLabel labelTitreFonction = new JLabel("Titre");
				
				JTextField titreFonction = new JTextField();
				titreFonction.setColumns(10);
				GroupLayout gl_panel_2 = new GroupLayout(panel_2);
				gl_panel_2.setHorizontalGroup(
					gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(16)
							.addComponent(labelTitreFonction)
							.addGap(5)
							.addComponent(titreFonction, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
				gl_panel_2.setVerticalGroup(
					gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(8)
							.addComponent(labelTitreFonction))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(5)
							.addComponent(titreFonction, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
				panel_2.setLayout(gl_panel_2);
				
				JPanel panel_3 = new JPanel();
				panel_3.setBounds(15, 132, 187, 36);
				panel_6.add(panel_3);
				
				JLabel labelDepartementFonction = new JLabel("Departement");
				
				JTextField departementFonction = new JTextField();
				departementFonction.setColumns(10);
				labelDepartementFonction.setLabelFor(departementFonction);
				GroupLayout gl_panel_3 = new GroupLayout(panel_3);
				gl_panel_3.setHorizontalGroup(
					gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(13)
							.addComponent(labelDepartementFonction)
							.addGap(5)
							.addComponent(departementFonction, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
				gl_panel_3.setVerticalGroup(
					gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(8)
							.addComponent(labelDepartementFonction))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(5)
							.addComponent(departementFonction, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
				panel_3.setLayout(gl_panel_3);
				
				JPanel panel_4 = new JPanel();
				panel_4.setBounds(29, 179, 173, 30);
				panel_6.add(panel_4);
				
				JLabel labelNiveauFonction = new JLabel("Niveau");
				
				JTextField niveauFonction = new JTextField();
				niveauFonction.setColumns(10);
				labelNiveauFonction.setLabelFor(niveauFonction);
				GroupLayout gl_panel_4 = new GroupLayout(panel_4);
				gl_panel_4.setHorizontalGroup(
					gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(28)
							.addComponent(labelNiveauFonction)
							.addGap(5)
							.addComponent(niveauFonction, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
				gl_panel_4.setVerticalGroup(
					gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(8)
							.addComponent(labelNiveauFonction))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(5)
							.addComponent(niveauFonction, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
				panel_4.setLayout(gl_panel_4);
				
				JPanel panel_5 = new JPanel();
				panel_5.setBounds(40, 220, 162, 30);
				panel_6.add(panel_5);
				
				JLabel labelRttFonction = new JLabel("RTT");
				panel_5.add(labelRttFonction);
				
				JTextField rttFonction = new JTextField();
				panel_5.add(rttFonction);
				rttFonction.setColumns(10);
				labelRttFonction.setLabelFor(rttFonction);
				
				
				JButton btnNewButton = new JButton("Enregistrer");
				btnNewButton.setBounds(71, 261, 85, 23);
				panel_6.add(btnNewButton);
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						GestionDate gestion = new GestionDate();
					
						Date dateF = gestion.stringToDate(dateFonction.getText());
						String titreF = titreFonction.getText();
						String departementF = departementFonction.getText();
						int niveauF = Integer.parseInt(niveauFonction.getText());
						int rttF = Integer.parseInt(rttFonction.getText());
						fonction = new Fonction(dateF, titreF, departementF, niveauF, rttF);
						
						
					    
					}
				});
	}
}
