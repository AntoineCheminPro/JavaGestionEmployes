package com.wf3.vue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.wf3.controller.ControllerEmploye;
import com.wf3.model.Adresse;
import com.wf3.model.AdresseModel;
import com.wf3.model.Employe;
import com.wf3.model.EmployeModel;
import com.wf3.model.ModelDynamiqueEmploye;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VueAllEmployes extends JPanel {

	private ModelDynamiqueEmploye modelDynEmploye;
	private ControllerEmploye controllerEmploye;
	private VueFormEmploye vueFormEmploye;
	private JTable table;
	private JLayeredPane layeredPane;
	private Adresse adresse;

	
	public VueAllEmployes(JLayeredPane layeredPane) {
		this.layeredPane = layeredPane;
		modelDynEmploye = new ModelDynamiqueEmploye(getAllEmployes());
		
		JPanel panel_1 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 633, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(48, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(43, Short.MAX_VALUE)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JPanel panel = new JPanel();
		
		JButton btnNewButton = new JButton("supprimer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteEmploye();
			}
				
		});
		btnNewButton.setBackground(Color.RED);
		
		JButton btnNewButton_1 = new JButton("Editer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectionModel().isSelectionEmpty()) {
					JOptionPane.showMessageDialog(layeredPane, "Selectionnez une ligne svp", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
				editEmploye();
				}
			}
		});
		btnNewButton_1.setBackground(Color.YELLOW);
		
		JButton btnNewButton_2 = new JButton("Adresse");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectionModel().isSelectionEmpty()) {
					JOptionPane.showMessageDialog(layeredPane, "Selectionnez une ligne svp", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					
					EmployeModel employeMod = new EmployeModel();
					Employe employe;
										
					try {
						employe = employeMod.OneEmployeById(getEmployeIdFromRow());
						AdresseModel adresseModel = new AdresseModel();
						adresse = adresseModel.verifAdresse(employe);
					
						switchToEditAdressScreen(employe, layeredPane);
					} catch (ParseException e1) {
						JOptionPane.showMessageDialog(layeredPane, "Aucun employé selectionné", "Error", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}
					
					}
			}
		});
		btnNewButton_2.setBackground(Color.GREEN);	
		
		JButton btnNewButton_3 = new JButton("fonction");
		btnNewButton_3.setBackground(Color.GREEN);
		
		JButton btnNewButton_4 = new JButton("Cong\u00E9s");
		btnNewButton_4.setBackground(Color.GREEN);
		
		JButton btnNewButton_5 = new JButton("Salaires");
		btnNewButton_5.setBackground(Color.GREEN);
		table = new JTable(modelDynEmploye);
		table.setBackground(Color.WHITE);
		JScrollPane scroll = new JScrollPane(table);
		table.setVisible(true);
		scroll.setViewportView(table);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(10)
							.addComponent(scroll, GroupLayout.PREFERRED_SIZE, 612, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 603, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(11, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(scroll, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel.add(btnNewButton);
		panel.add(btnNewButton_1);
		panel.add(btnNewButton_2);
		panel.add(btnNewButton_3);
		panel.add(btnNewButton_4);
		panel.add(btnNewButton_5);
		panel_1.setLayout(gl_panel_1);
		setLayout(groupLayout);
	}
	
	

	public ArrayList<Employe> getAllEmployes(){
		EmployeModel employeMod = new EmployeModel();
		
		try {
			return employeMod.getAllEmploye();
			} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return null;
	}
	
	public int getEmployeIdFromRow() {
		 int row = table.getSelectedRow();
		 String id = table.getModel().getValueAt(row, 0).toString();
		 return Integer.parseInt(id);
	}
	
	public void editEmploye() {
		EmployeModel employeMod = new EmployeModel();
		Employe employe;
		
		try {
			employe = employeMod.OneEmployeById(getEmployeIdFromRow());
			switchToEditScreen(employe);
			
			} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void switchToEditScreen(Employe employe) {
		
		VueFormEditEmploye vueFormEditEmploye = new VueFormEditEmploye(employe, layeredPane);
	    layeredPane.removeAll();
	    layeredPane.add(vueFormEditEmploye);
	    layeredPane.repaint();
	    layeredPane.revalidate();
	}
	
	public void switchToEditAdressScreen(Employe employe, JLayeredPane layeredPane) {
		
		VueFormAdresse vueFormAdresse = new VueFormAdresse(employe, layeredPane);
	    layeredPane.removeAll();
	    layeredPane.add(vueFormAdresse);
	    layeredPane.repaint();
	    layeredPane.revalidate();
	}
	
	public void deleteEmploye() {
	   
	    EmployeModel employeMod = new EmployeModel();
	    int row = table.getSelectedRow();
	    try {
			employeMod.deleteEmploye(getEmployeIdFromRow());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    modelDynEmploye.removeEmployeFromTable(row);
	    JOptionPane.showMessageDialog(layeredPane, "Bien effacé de la bdd");
	}
}
