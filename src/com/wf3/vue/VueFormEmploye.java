package com.wf3.vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.wf3.controller.ControllerEmploye;
import com.wf3.model.Employe;
import com.wf3.model.EmployeModel;
import com.wf3.model.GestionDate;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JSpinner;



public class VueFormEmploye extends JPanel {


	private ControllerEmploye controllerEmploye;
	private JLabel labelNom;
	private JTextField nom;
	private JTextField prenom;
	private JTextField dateNaissance;
	private JTextField code;
	private JTextField quotite;
	private JTextField dateEmbauche;
	private JLabel labelPrenom;
	private JTextField textField;
	private VueAllEmployes vueAllEmployes;
	private JLayeredPane layeredPane;

	/**
	 * Create the frame.
	 */
	public VueFormEmploye(ControllerEmploye controllerEmploye, JLayeredPane layeredPane) {
		
		this.controllerEmploye = controllerEmploye;
		this.layeredPane = layeredPane;
		
		ButtonGroup Group = new ButtonGroup();
		
		JPanel panel_7 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(277)
					.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 365, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(175, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(244)
					.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(212, Short.MAX_VALUE))
		);
		panel_7.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		panel_7.add(panel);
		
		labelNom = new JLabel("Nom");
		
		nom = new JTextField();
		nom.setColumns(10);
		labelNom.setLabelFor(nom);
		
		labelPrenom = new JLabel("Prenom");
		
		JTextField prenom = new JTextField();
		prenom.setColumns(10);
		labelPrenom.setLabelFor(prenom);
		
		JPanel panel_1 = new JPanel();
		
		JLabel labelSexe = new JLabel("Sexe");
		JRadioButton homme = new JRadioButton("Homme");
		Group.add(homme);
		JRadioButton femme = new JRadioButton("Femme");
		Group.add(femme);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(24)
					.addComponent(labelSexe)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(homme)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(femme, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
					.addGap(47))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelSexe)
						.addComponent(homme)
						.addComponent(femme)))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		
		JLabel labelDateNaissance = new JLabel("Date de naissance");
		
		JTextField dateNaissance = new JTextField();
		dateNaissance.setColumns(10);
		labelDateNaissance.setLabelFor(dateNaissance);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(labelDateNaissance)
					.addGap(35)
					.addComponent(dateNaissance, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelDateNaissance)
						.addComponent(dateNaissance, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_3 = new JPanel();
		
		JLabel labelCode = new JLabel("Code");
		
		JTextField code = new JTextField();
		code.setColumns(10);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(82)
					.addComponent(labelCode)
					.addGap(24)
					.addComponent(code, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(8)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelCode)
						.addComponent(code, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		panel_3.setLayout(gl_panel_3);
		
		JPanel panel_4 = new JPanel();
		
		JLabel labelQuotite = new JLabel("Quotite");
		
		JTextField quotite = new JTextField();
		quotite.setColumns(10);
		labelQuotite.setLabelFor(quotite);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(76)
					.addComponent(labelQuotite)
					.addGap(19)
					.addComponent(quotite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(8)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelQuotite)
						.addComponent(quotite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		panel_4.setLayout(gl_panel_4);
		
		JPanel panel_5 = new JPanel();
		
		JLabel labelDateEmbauche = new JLabel("Date d'embauche");
		
		JTextField dateEmbauche = new JTextField();
		dateEmbauche.setColumns(10);
		labelDateEmbauche.setLabelFor(dateEmbauche);
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(24)
					.addComponent(labelDateEmbauche)
					.addGap(24)
					.addComponent(dateEmbauche, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelDateEmbauche)
						.addComponent(dateEmbauche, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		panel_5.setLayout(gl_panel_5);
		
		JPanel panel_6 = new JPanel();
		
		JButton btnNewButton = new JButton("Enregistrer");
		btnNewButton.setBackground(Color.GREEN);
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGap(97)
					.addComponent(btnNewButton))
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGap(5)
					.addComponent(btnNewButton))
		);
		panel_6.setLayout(gl_panel_6);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GestionDate gestion = new GestionDate();
				String nomE = nom.getText();
				String prenomE = prenom.getText();
				int sexeE = 0;
				if(homme.isSelected()) {
					sexeE = 1;
				} else {
					sexeE = 2;
				}
				Date dateNaissanceE = gestion.stringToDate(dateNaissance.getText());
				String codeE = code.getText();
				int quotiteE = Integer.parseInt(quotite.getText());
				Date dateEmbaucheE = gestion.stringToDate(dateEmbauche.getText());

				Employe employe = new Employe(nomE, prenomE, sexeE, dateNaissanceE, dateEmbaucheE, quotiteE, codeE);
				EmployeModel model = new EmployeModel();
				model.addEmploye(employe);
				JOptionPane.showMessageDialog(panel_1, "Employé créé");
				
				vueAllEmployes = new VueAllEmployes(layeredPane);
				switchScreen(vueAllEmployes);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addComponent(labelNom)
							.addGap(5)
							.addComponent(nom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(labelPrenom)
							.addGap(5)
							.addComponent(prenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(44)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(44)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(44)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(44)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(83, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(labelNom))
						.addComponent(nom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(labelPrenom))
						.addComponent(prenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(52))
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
		
	}
	
	public void switchScreen(JPanel panelToUpload) {
		this.removeAll();
		this.add(panelToUpload);
		this.repaint();
		this.revalidate();
	}
}

