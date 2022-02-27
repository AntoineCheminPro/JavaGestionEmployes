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
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.wf3.controller.ControllerEmploye;
import com.wf3.model.Adresse;
import com.wf3.model.Conges;
import com.wf3.model.Employe;
import com.wf3.model.Fonction;
import com.wf3.model.GestionDate;
import com.wf3.model.Salaire;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class VueFormSalaire extends JPanel {

	private JPanel panel;
	private ControllerSalaire controllerSalaire;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	

	/**
	 * Create the frame.
	 */
	public VueFormSalaire(ControllerSalaire controlleSalaire, JLayeredPane layeredPane) {
		this.controllerSalaire = controllerSalaire;
		this.layeredPane = layeredPane;
		
		panel = new JPanel();
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.YELLOW);
		panel.add(panel_3);
		
		JPanel panel_1 = new JPanel();
		
		JLabel labelSalaire = new JLabel("Salaire");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 216, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(92)
					.addComponent(labelSalaire))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 35, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addComponent(labelSalaire))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		
		JLabel labelDebutSalaire = new JLabel("Debut");
		
		textField = new JTextField();
		textField.setColumns(10);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 216, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(48)
					.addComponent(labelDebutSalaire)
					.addGap(5)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 26, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(8)
					.addComponent(labelDebutSalaire))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(5)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_2_1 = new JPanel();
		
		JLabel labelFinSalaire = new JLabel("Fin");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		GroupLayout gl_panel_2_1 = new GroupLayout(panel_2_1);
		gl_panel_2_1.setHorizontalGroup(
			gl_panel_2_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 216, Short.MAX_VALUE)
				.addGroup(gl_panel_2_1.createSequentialGroup()
					.addGap(55)
					.addComponent(labelFinSalaire)
					.addGap(5)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_2_1.setVerticalGroup(
			gl_panel_2_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 26, Short.MAX_VALUE)
				.addGroup(gl_panel_2_1.createSequentialGroup()
					.addGap(8)
					.addComponent(labelFinSalaire))
				.addGroup(gl_panel_2_1.createSequentialGroup()
					.addGap(5)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		panel_2_1.setLayout(gl_panel_2_1);
		
		JPanel panel_2_2 = new JPanel();
		
		JLabel labelChargesP = new JLabel("Charges patronales");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		GroupLayout gl_panel_2_2 = new GroupLayout(panel_2_2);
		gl_panel_2_2.setHorizontalGroup(
			gl_panel_2_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 216, Short.MAX_VALUE)
				.addGroup(gl_panel_2_2.createSequentialGroup()
					.addGap(15)
					.addComponent(labelChargesP)
					.addGap(5)
					.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_2_2.setVerticalGroup(
			gl_panel_2_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 26, Short.MAX_VALUE)
				.addGroup(gl_panel_2_2.createSequentialGroup()
					.addGap(8)
					.addComponent(labelChargesP))
				.addGroup(gl_panel_2_2.createSequentialGroup()
					.addGap(5)
					.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		panel_2_2.setLayout(gl_panel_2_2);
		
		JPanel panel_2_2_1 = new JPanel();
		
		JLabel labelChargesS = new JLabel("Charges salariales");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		GroupLayout gl_panel_2_2_1 = new GroupLayout(panel_2_2_1);
		gl_panel_2_2_1.setHorizontalGroup(
			gl_panel_2_2_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 216, Short.MAX_VALUE)
				.addGroup(gl_panel_2_2_1.createSequentialGroup()
					.addGap(19)
					.addComponent(labelChargesS)
					.addGap(5)
					.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_2_2_1.setVerticalGroup(
			gl_panel_2_2_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 26, Short.MAX_VALUE)
				.addGroup(gl_panel_2_2_1.createSequentialGroup()
					.addGap(8)
					.addComponent(labelChargesS))
				.addGroup(gl_panel_2_2_1.createSequentialGroup()
					.addGap(5)
					.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		panel_2_2_1.setLayout(gl_panel_2_2_1);
		
		JPanel panel_2_2_1_1 = new JPanel();
		
		JLabel labelBrut = new JLabel("Brut");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		GroupLayout gl_panel_2_2_1_1 = new GroupLayout(panel_2_2_1_1);
		gl_panel_2_2_1_1.setHorizontalGroup(
			gl_panel_2_2_1_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 216, Short.MAX_VALUE)
				.addGroup(gl_panel_2_2_1_1.createSequentialGroup()
					.addGap(52)
					.addComponent(labelBrut)
					.addGap(5)
					.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_2_2_1_1.setVerticalGroup(
			gl_panel_2_2_1_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 26, Short.MAX_VALUE)
				.addGroup(gl_panel_2_2_1_1.createSequentialGroup()
					.addGap(8)
					.addComponent(labelBrut))
				.addGroup(gl_panel_2_2_1_1.createSequentialGroup()
					.addGap(5)
					.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		panel_2_2_1_1.setLayout(gl_panel_2_2_1_1);
		
		JPanel panel_2_2_1_1_1 = new JPanel();
		
		JButton btnNewButton = new JButton("Enregistrer");
		GroupLayout gl_panel_2_2_1_1_1 = new GroupLayout(panel_2_2_1_1_1);
		gl_panel_2_2_1_1_1.setHorizontalGroup(
			gl_panel_2_2_1_1_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 216, Short.MAX_VALUE)
				.addGroup(gl_panel_2_2_1_1_1.createSequentialGroup()
					.addGap(65)
					.addComponent(btnNewButton))
		);
		gl_panel_2_2_1_1_1.setVerticalGroup(
			gl_panel_2_2_1_1_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 26, Short.MAX_VALUE)
				.addGroup(gl_panel_2_2_1_1_1.createSequentialGroup()
					.addGap(5)
					.addComponent(btnNewButton))
		);
		panel_2_2_1_1_1.setLayout(gl_panel_2_2_1_1_1);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 377, Short.MAX_VALUE)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(83)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(83)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(83)
					.addComponent(panel_2_1, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(83)
					.addComponent(panel_2_2, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(79)
					.addComponent(panel_2_2_1, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(79)
					.addComponent(panel_2_2_1_1, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(79)
					.addComponent(panel_2_2_1_1_1, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 307, Short.MAX_VALUE)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(25)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(panel_2_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(panel_2_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(panel_2_2_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(panel_2_2_1_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(panel_2_2_1_1_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
		);
		panel_3.setLayout(gl_panel_3);
	}
}
