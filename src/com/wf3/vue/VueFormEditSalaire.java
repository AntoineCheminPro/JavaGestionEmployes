package com.wf3.vue;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;

import com.wf3.controller.Controller;
import com.wf3.controller.ControllerAdresse;
import com.wf3.model.Adresse;
import com.wf3.model.AdresseModel;
import com.wf3.model.Employe;
import com.wf3.model.GestionDate;
import com.wf3.model.Salaire;
import com.wf3.model.SalaireModel;

public class VueFormEditSalaire extends JPanel {
	public JPanel panel;
	
	private JLabel labelDateDebut;
	private JTextField DateDebut;
	
	private JLabel labelDateFin;
	private JTextField DateFin;
	private VueAllSalairesForOneEmploye vueAllSalairesForOneEmploye;
	private JLayeredPane layeredPane;
	private Employe employe;
	private Salaire salaire;
	/**
	 * Create the panel.
	 */
	public VueFormEditSalaire( Employe employe, Salaire salaire, JLayeredPane layeredPane) {

		this.layeredPane = layeredPane;
		this.employe = employe;
		this.salaire = salaire;
		
		JPanel panel_7 = new JPanel();
		
		//date du début
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		labelDateDebut = new JLabel("DateDebut");
		DateDebut = new JTextField();
		labelDateDebut.setLabelFor(DateDebut);
		DateDebut.setColumns(10);
		
		//date de fin
		labelDateFin = new JLabel("DateFin");
		DateFin = new JTextField();
		DateFin.setColumns(10);
		labelDateFin.setLabelFor(DateFin);
		ButtonGroup Group = new ButtonGroup();
		
		
		// charges salariales
		JPanel panel_2 = new JPanel();
		JLabel labelChargesSalariales = new JLabel("Charges Salariales");
		JTextField chargesSalariales = new JTextField();
		chargesSalariales.setColumns(10);
		labelChargesSalariales.setLabelFor(chargesSalariales);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(labelChargesSalariales)
					.addGap(35)
					.addComponent(chargesSalariales, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelChargesSalariales)
						.addComponent(chargesSalariales, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		panel_2.setLayout(gl_panel_2);
		
		// charges patronales
		JPanel panel_3 = new JPanel();
		JLabel labelChargesPatronales = new JLabel("Charges Patronales");
		JTextField ChargesPatronales = new JTextField();
		ChargesPatronales.setColumns(10);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(labelChargesPatronales)
					.addGap(18)
					.addComponent(ChargesPatronales, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(78))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(8)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelChargesPatronales)
						.addComponent(ChargesPatronales, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		panel_3.setLayout(gl_panel_3);
		
		
		//brut
		JPanel panel_4 = new JPanel();
		JLabel labelBrut = new JLabel("Brut");
		JTextField brut = new JTextField();
		brut.setColumns(10);
		labelBrut.setLabelFor(brut);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(76)
					.addComponent(labelBrut)
					.addGap(19)
					.addComponent(brut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(8)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelBrut, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
						.addComponent(brut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		panel_4.setLayout(gl_panel_4);
		
		
		// button enregistrer
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
		
		
		// action listement bouton enregistrer
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GestionDate gestion = new GestionDate();
				Date dateDebutE = gestion.stringToDate(DateDebut.getText());
				Date dateFinE = gestion.stringToDate(DateFin.getText());
				Float chargesPatronalesE = Float.parseFloat(ChargesPatronales.getText());
				Float chargesSalarialesE = Float.parseFloat(chargesSalariales.getText());
				Float brutE = Float.parseFloat(brut.getText());
				int id_employeE = employe.getId();

				Salaire salaire = new Salaire(dateDebutE, dateFinE, chargesPatronalesE, chargesSalarialesE, brutE);
				salaire.setId_employe(id_employeE);
				SalaireModel model = new SalaireModel();
				model.addSalaire(salaire, employe);
				JOptionPane.showMessageDialog(panel, "Salaire créé");
				
				vueAllSalairesForOneEmploye = new VueAllSalairesForOneEmploye(employe, layeredPane);
				switchScreen(vueAllSalairesForOneEmploye);
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(75)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
					.addGap(91)
					.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 365, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(244)
							.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(110)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(labelDateDebut)
							.addGap(42)
							.addComponent(DateDebut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(labelDateFin)
							.addGap(57)
							.addComponent(DateFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
							.addComponent(panel_6, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(8)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(labelDateDebut))
						.addComponent(DateDebut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(6)
							.addComponent(labelDateFin))
						.addComponent(DateFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(gl_panel);
		panel_7.setLayout(new GridLayout(1, 0, 0, 0));
		setLayout(groupLayout);
		
	}
	
	public void switchScreen(JPanel panelToUpload) {
		this.removeAll();
		this.add(panelToUpload);
		this.repaint();
		this.revalidate();
	}
}
