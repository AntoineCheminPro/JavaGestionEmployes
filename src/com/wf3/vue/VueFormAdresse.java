package com.wf3.vue;

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
import javax.swing.JTable;

@SuppressWarnings("serial")
public class VueFormAdresse extends JFrame {

	public JFrame frame;
	private ControllerAdresse controllerAdresse;
	private JLayeredPane layeredPane ;
	
	/**
	 * Create the frame.
	 * @param controllerAdresse 
	 */
		public VueFormAdresse(ControllerAdresse controllerAdresse, Employe employe, JLayeredPane layeredPane) {
			this.layeredPane = layeredPane;
			this.controllerAdresse = controllerAdresse;
			initializeAdresse(employe.getId());
		}
	
		public void initializeAdresse(int employe_id) {
		frame = new JFrame();
		frame.setBounds(100, 100, 318, 227);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel labelRue = new JLabel("Rue");
		labelRue.setBounds(83, 50, 46, 14);
		frame.getContentPane().add(labelRue);
		
		JTextField rue = new JTextField();
		labelRue.setLabelFor(rue);
		rue.setBounds(195, 50, 86, 20);
		frame.getContentPane().add(rue);
		rue.setColumns(10);
		
		JLabel labelVille = new JLabel("Ville");
		labelVille.setBounds(83, 75, 28, 14);
		frame.getContentPane().add(labelVille);
		
		JTextField ville = new JTextField();
		labelVille.setLabelFor(ville);
		ville.setBounds(195, 75, 86, 20);
		frame.getContentPane().add(ville);
		ville.setColumns(10);
		
		JLabel labelPostal = new JLabel("Code postal");
		labelPostal.setBounds(83, 100, 102, 14);
		frame.getContentPane().add(labelPostal);
		
		JTextField postal = new JTextField();
		labelPostal.setLabelFor(postal);
		postal.setBounds(195, 100, 86, 20);
		frame.getContentPane().add(postal);
		postal.setColumns(10);
	

	
	JButton btnNewButton = new JButton("Enregistrer");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			String rueE = rue.getText();
			String postalE = postal.getText();
			String villeE = ville.getText();
			Adresse adresse = new Adresse(rueE, postalE, villeE);
			AdresseModel model = new AdresseModel();
			
			
			
			
			
			switchToEditScreen(employe);
			
			
			model.addAdresse(adresse, employe);  
	}});
	btnNewButton.setBounds(100, 150, 102, 23);
	frame.getContentPane().add(btnNewButton);
	
	JLabel lblNewLabel = new JLabel("Adresse");
	lblNewLabel.setBounds(146, 11, 46, 14);
	frame.getContentPane().add(lblNewLabel);
}
		public int getEmployeIdFromRow(JTable table) {
			 int row = table.getSelectedRow();
			 String id = table.getModel().getValueAt(row, 0).toString();
			 return Integer.parseInt(id);
		}
		public void switchToEditAdressScreen(Employe employe) {
			
			VueFormEditEmploye vueFormEditEmploye = new VueFormEditEmploye(employe, layeredPane);
		    layeredPane.removeAll();
		    layeredPane.add(vueFormEditEmploye);
		    layeredPane.repaint();
		    layeredPane.revalidate();
		}
		
		
		
}
