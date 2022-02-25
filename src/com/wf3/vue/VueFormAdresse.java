package com.wf3.vue;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.wf3.controller.ControllerAdresse;

import com.wf3.model.Adresse;
import com.wf3.model.AdresseModel;
import com.wf3.model.Employe;
import com.wf3.model.EmployeModel;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;

@SuppressWarnings("serial")
public class VueFormAdresse extends JPanel {

	public JPanel panel;
	private ControllerAdresse controllerAdresse;
	private JLayeredPane layeredPane;
	private Employe employe;

	/**
	 * @wbp.nonvisual location=100,369
	 */

	/**
	 * Create the panel.
	 */
	public VueFormAdresse(Employe employe, JLayeredPane layeredPane) {
		this.layeredPane = layeredPane;
		
		this.employe = employe;

		panel = new JPanel();
		panel.setBackground(Color.MAGENTA);
		

		JLabel labelRue = new JLabel("Rue");

		JTextField rue = new JTextField();
		labelRue.setLabelFor(rue);
		rue.setColumns(10);

		JLabel labelVille = new JLabel("Ville");

		JTextField ville = new JTextField();
		labelVille.setLabelFor(ville);
		ville.setColumns(10);

		JLabel labelPostal = new JLabel("Code postal");

		JTextField postal = new JTextField();
		labelPostal.setLabelFor(postal);
		postal.setColumns(10);

		//if(adresse !exist) {
		JButton btnNewButton = new JButton("Enregistrer");
		//}
//		else {
//		JButton btnNewButton = new JButton("Mettre à jour");
//		}
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String rueE = rue.getText();
				String postalE = postal.getText();
				String villeE = ville.getText();
				Adresse adresse = new Adresse(rueE, postalE, villeE);
				AdresseModel model = new AdresseModel();
				//if(adresse !exist) {
				model.addAdresse(adresse, employe);
				//}
//				else {
				//***renseigner les données
//				model.editAdresse(adresse, employe);
//				}
//				switchToEditAdressScreen(employe, layeredPane);
//				
			}
		});

		JLabel lblNewLabel = new JLabel("Adresse");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(146).addComponent(lblNewLabel,
						GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup().addGap(83)
						.addComponent(labelRue, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE).addGap(66)
						.addComponent(rue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup().addGap(83)
						.addComponent(labelVille, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE).addGap(84)
						.addComponent(ville, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup().addGap(83)
						.addComponent(labelPostal, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
						.addGap(10).addComponent(postal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup().addGap(100).addComponent(btnNewButton,
						GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addGap(11).addComponent(lblNewLabel).addGap(25)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(labelRue).addComponent(rue,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(5)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(labelVille).addComponent(ville,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(5)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(labelPostal).addComponent(postal,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(30).addComponent(btnNewButton)));
		panel.setLayout(gl_panel);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(82)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(5)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
		);
		
		
		setLayout(groupLayout);
		
	}

	public int getEmployeIdFromRow(JTable table) {
		int row = table.getSelectedRow();
		String id = table.getModel().getValueAt(row, 0).toString();
		return Integer.parseInt(id);
	}

	public void editAdresse(Employe employe) {

		employe = this.employe;
		// switchToEditAdressScreen(employe);
	}
}
