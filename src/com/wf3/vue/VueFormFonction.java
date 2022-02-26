package com.wf3.vue;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.wf3.controller.Controller;
import com.wf3.controller.ControllerFonction;
import com.wf3.model.Adresse;
import com.wf3.model.AdresseModel;
import com.wf3.model.Conges;
import com.wf3.model.Employe;
import com.wf3.model.Fonction;
import com.wf3.model.FonctionModel;
import com.wf3.model.GestionDate;
import com.wf3.model.Salaire;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;

public class VueFormFonction extends JPanel {

	private JPanel panel;
	private Fonction fonction;
	private Employe employe;
	private ControllerFonction controllerFonction;
	private VueAllEmployes vueAllEmployes;
	private JLayeredPane layeredPane;
	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public VueFormFonction(Employe employe, JLayeredPane layeredPane) throws ParseException {
		this.layeredPane = layeredPane;
				
		this.employe = employe;
		FonctionModel fonctionModel = new FonctionModel();
		fonction = fonctionModel.verifFonction(employe);
		
		panel = new JPanel();
		panel.setBounds(100, 100, 351, 317);
				
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.CYAN);
		
				// Fonction
				JLabel labelFonction = new JLabel("Fonction");
				JPanel panel_1 = new JPanel();
				
				//date
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
				
				//titre
				JPanel panel_2 = new JPanel();
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
				
				// departement
				JPanel panel_3 = new JPanel();
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
				
				
				// niveau
				JPanel panel_4 = new JPanel();
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
				
				// RTT
				JPanel panel_5 = new JPanel();
				JLabel labelRttFonction = new JLabel("RTT");
				panel_5.add(labelRttFonction);
				JTextField rttFonction = new JTextField();
				panel_5.add(rttFonction);
				rttFonction.setColumns(10);
				labelRttFonction.setLabelFor(rttFonction);
				
				// bouton
				JButton btnNewButton;
				if(fonction == null)
				{
				btnNewButton = new JButton("Enregistrer");
				}
				else {
				GestionDate gestion = new GestionDate();
				dateFonction.setText(gestion.dateToString(fonction.getDate()));
				titreFonction.setText(fonction.getTitre());
				departementFonction.setText(fonction.getDepartement());
				niveauFonction.setText(String.valueOf(fonction.getNiveau()));
				rttFonction.setText(String.valueOf(fonction.getRtt()));
				btnNewButton = new JButton("Mettre à jour");
				}
				
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						GestionDate gestion = new GestionDate();
					
						Date dateF = gestion.stringToDate(dateFonction.getText());
						String titreF = titreFonction.getText();
						String departementF = departementFonction.getText();
						int niveauF = Integer.parseInt(niveauFonction.getText());
						int rttF = Integer.parseInt(rttFonction.getText());
						
						if(fonction == null ) {
							
							fonction = new Fonction(dateF, titreF, departementF, niveauF, rttF);
							fonction.setId_employe(employe.getId());
							
							JOptionPane.showMessageDialog(panel, "Fonction enregistrée");
							fonctionModel.addFonction(fonction, employe);
						}
						else {
							fonction = new Fonction(dateF, titreF, departementF, niveauF, rttF);
							fonction.setId_employe(employe.getId());
							JOptionPane.showMessageDialog(panel, "Fonction mise à jour");
							fonctionModel.editFonction(fonction);
						}
						
//						vueAllEmployes = new VueAllEmployes(layeredPane);
						Controller.reload();
						
					
					}
				});
				
				
				GroupLayout gl_panel_6 = new GroupLayout(panel_6);
				gl_panel_6.setHorizontalGroup(
					gl_panel_6.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_6.createSequentialGroup()
							.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_panel_6.createSequentialGroup()
										.addGap(71)
										.addComponent(labelFonction, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panel_6.createSequentialGroup()
										.addGap(50)
										.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE))
									.addGroup(gl_panel_6.createSequentialGroup()
										.addGap(50)
										.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGroup(gl_panel_6.createSequentialGroup()
										.addGap(15)
										.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGroup(gl_panel_6.createSequentialGroup()
										.addGap(29)
										.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGroup(gl_panel_6.createSequentialGroup()
										.addGap(40)
										.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addGroup(gl_panel_6.createSequentialGroup()
									.addGap(121)
									.addComponent(btnNewButton)))
							.addContainerGap(68, Short.MAX_VALUE))
				);
				gl_panel_6.setVerticalGroup(
					gl_panel_6.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_6.createSequentialGroup()
							.addGap(11)
							.addComponent(labelFonction)
							.addGap(11)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton)
							.addGap(72))
				);
				panel_6.setLayout(gl_panel_6);
				
				//groupLayout
				GroupLayout gl_panel = new GroupLayout(panel);
				gl_panel.setHorizontalGroup(
					gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(295, Short.MAX_VALUE))
				);
				gl_panel.setVerticalGroup(
					gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(134, Short.MAX_VALUE))
				);
				panel.setLayout(gl_panel);
				
				//groupLayout
				GroupLayout groupLayout = new GroupLayout(this);
				groupLayout.setHorizontalGroup(
					groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(82)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 634, GroupLayout.PREFERRED_SIZE))
				);
				groupLayout.setVerticalGroup(
					groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 501, GroupLayout.PREFERRED_SIZE))
				);
					
				
				
			
				
				setLayout(groupLayout);
				
				
	}
}
