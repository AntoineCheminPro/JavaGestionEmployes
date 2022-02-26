package com.wf3.vue;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.wf3.controller.Controller;
import com.wf3.controller.ControllerAdresse;

import com.wf3.model.Adresse;
import com.wf3.model.AdresseModel;
import com.wf3.model.Employe;
import com.wf3.model.EmployeModel;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class VueFormAdresse extends JPanel {

	public JPanel panel;
	private ControllerAdresse controllerAdresse;
	private JLayeredPane layeredPane;
	private Employe employe;
	private Adresse adresse;
	private VueAllEmployes vueAllEmployes;

	
	public VueFormAdresse(Employe employe, JLayeredPane layeredPane) {
		this.layeredPane = layeredPane;
				
		this.employe = employe;
		AdresseModel adresseModel = new AdresseModel();
		adresse = adresseModel.verifAdresse(employe);

		
		panel = new JPanel();
		panel.setBackground(Color.MAGENTA);
	
		
		//rue
		JLabel labelRue = new JLabel("Rue");
		JTextField rue = new JTextField();
		labelRue.setLabelFor(rue);
		rue.setColumns(10);

		//ville
		JLabel labelVille = new JLabel("Ville");
		JTextField ville = new JTextField();
		labelVille.setLabelFor(ville);
		ville.setColumns(10);

		//code postal
		JLabel labelPostal = new JLabel("Code postal");
		JTextField postal = new JTextField();
		labelPostal.setLabelFor(postal);
		postal.setColumns(10);
	
		AdresseModel model = new AdresseModel();
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		//bouton
		JButton btnNewButton;
		if(adresse == null)
		{
		btnNewButton = new JButton("Enregistrer");
		}
		else {
		rue.setText(adresse.getRue());
		ville.setText(adresse.getVille());
		postal.setText(adresse.getPostal());
		btnNewButton = new JButton("Mettre à jour");
		}
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String rueE = rue.getText();
				String postalE = postal.getText();
				String villeE = ville.getText();
				
			
				if(adresse == null ) {
					
					adresse = new Adresse(rueE, postalE, villeE);
					adresse.setId_employe(employe.getId());
					JOptionPane.showMessageDialog(panel, "Adresse enregistrée");
					model.addAdresse(adresse, employe);
				}
				else {
					adresse = new Adresse(rueE, postalE, villeE);
					adresse.setId_employe(employe.getId());
					JOptionPane.showMessageDialog(panel, "Adresse mise à jour");
					model.editAdresse(adresse);
				}
				
//				vueAllEmployes = new VueAllEmployes(layeredPane);
				Controller.reload();
				
			
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
		
		//groupLayout
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

	
	public void switchScreen(JPanel panelToUpload) {
		this.removeAll();
		this.add(panelToUpload);
		this.repaint();
		this.revalidate();
	}
}
