package com.wf3.vue;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.wf3.controller.ControllerEmploye;
import com.wf3.model.Employe;

import javax.swing.JLayeredPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;


public class VueGenerale extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPane;
	private VueFormEmploye vueFormEmploye;
	private VueAllEmployes vueAllEmployes;
	private ControllerEmploye controllerEmploye;
	private JPanel formEmploye;
	private JPanel panel_1;
	/**
	 * Create the frame.
	 */
	public VueGenerale(ControllerEmploye controllerEmploye) {
		
		this.controllerEmploye = controllerEmploye;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 891, 761);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(21, 77, 781, 428);
		
		vueFormEmploye = new VueFormEmploye(controllerEmploye, layeredPane);
		layeredPane.setLayer(vueFormEmploye, 0);
		vueFormEmploye.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		 vueAllEmployes = new VueAllEmployes(layeredPane);
		 vueAllEmployes.setBounds(50, 50, 294, 234);
		 layeredPane.setLayer(vueAllEmployes, 1);
		 vueAllEmployes.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel = new JPanel();
		panel.setBounds(21, 11, 781, 56);
		panel.setBackground(Color.PINK);
		
		JButton nouvelEmploye = new JButton("nouvel employ\u00E9");
		nouvelEmploye.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchScreen(vueFormEmploye);
			}
		});
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel.add(nouvelEmploye);
		
		JButton employes = new JButton("Employes");
		employes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchScreen(vueAllEmployes);
			}
		});
		contentPane.setLayout(null);
		panel.add(employes);
		contentPane.add(panel);
		contentPane.add(layeredPane);
		defaultPanel();
	
	}
	
	public VueGenerale() {
		// TODO Auto-generated constructor stub
	}

	public void defaultPanel() {
		layeredPane.removeAll();
	    layeredPane.setLayout(new BorderLayout(0, 0));
	    layeredPane.add(vueAllEmployes);
	    layeredPane.repaint();
	    layeredPane.revalidate();
	}
	
	public void switchScreen(JPanel panel) {
	    layeredPane.removeAll();
	    layeredPane.add(panel);
	    layeredPane.repaint();
	    layeredPane.revalidate();
	}
	
}
