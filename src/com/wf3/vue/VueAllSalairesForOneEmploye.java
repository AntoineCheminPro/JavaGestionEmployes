package com.wf3.vue;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;

import com.wf3.model.Adresse;
import com.wf3.model.Employe;
import com.wf3.model.EmployeModel;
import com.wf3.model.Fonction;
import com.wf3.model.ModelDynamiqueEmploye;
import com.wf3.model.ModelDynamiqueSalaire;
import com.wf3.model.Salaire;
import com.wf3.model.SalaireModel;

public class VueAllSalairesForOneEmploye extends JPanel {

	private ModelDynamiqueSalaire modelDynSalaire;
	private JTable table;
	private JLayeredPane layeredPane;
	private Adresse adresse;
	private Fonction fonction;
	private Salaire salaire;
	private Employe employe;
	/**
	 * Create the panel.
	 */
	public VueAllSalairesForOneEmploye(Employe employe, JLayeredPane layeredPane) {
		this.layeredPane = layeredPane;
		this.employe = employe;
		
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
		
		modelDynSalaire = new ModelDynamiqueSalaire(getAllSalairesForOneEmploye(employe));
		table = new JTable(modelDynSalaire);
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
		

		// bouton ajouter salaire
//		JButton btnNewButton = new JButton("ajouter");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				addSalaire();
//			}
//				
//		});
//		btnNewButton.setBackground(Color.GREEN);
		
		// bouton éditer salaire
		JButton btnNewButton_1 = new JButton("Editer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectionModel().isSelectionEmpty()) {
					JOptionPane.showMessageDialog(layeredPane, "Selectionnez une ligne svp", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
				editSalaire();
				}
			}
		});
		btnNewButton_1.setBackground(Color.YELLOW);
		
	
	
	// bouton éditer salaire
			JButton btnNewButton_2 = new JButton("supprimer");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(table.getSelectionModel().isSelectionEmpty()) {
						JOptionPane.showMessageDialog(layeredPane, "Selectionnez une ligne svp", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else {
					deleteSalaire();
					}
				}
			});
			btnNewButton_1.setBackground(Color.RED);
			
//			panel.add(btnNewButton);
			panel.add(btnNewButton_1);
			panel.add(btnNewButton_2);

			panel_1.setLayout(gl_panel_1);
			setLayout(groupLayout);
		}

	
	public ArrayList<Salaire> getAllSalairesForOneEmploye(Employe employe){
		
		int id_employe = employe.getId();
	
		SalaireModel salaireMod = new SalaireModel();
		
		
		try {
			return salaireMod.getAllSalaires(id_employe);
			} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return null;
	}
	
	public int getSalaireIdFromRow() {
		 int row = table.getSelectedRow();
		 String id = table.getModel().getValueAt(row, 0).toString();
		 return Integer.parseInt(id);
	}
	
	public void deleteSalaire() {
		   
	    SalaireModel salaireMod = new SalaireModel();
	    int row = table.getSelectedRow();
	    try {
			salaireMod.deleteSalaire(getSalaireIdFromRow());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    modelDynSalaire.removeSalaireFromTable(row);
	    JOptionPane.showMessageDialog(layeredPane, "Bien effacé de la bdd");
	}
	
	public void editSalaire() {
		SalaireModel salaireMod = new SalaireModel();
		Salaire salaire;
		
		try {
			salaire = salaireMod.OneSalaireById(getSalaireIdFromRow());
			switchToEditSalaireScreen(employe, salaire);
			
			} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
public void switchToEditSalaireScreen(Employe employe, Salaire salaire) {
		
		VueFormEditSalaire vueFormEditSalaire = new VueFormEditSalaire(employe, salaire, layeredPane);
	    layeredPane.removeAll();
	    layeredPane.add(vueFormEditSalaire);
	    layeredPane.repaint();
	    layeredPane.revalidate();
	}
}
