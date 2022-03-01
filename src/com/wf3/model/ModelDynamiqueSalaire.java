package com.wf3.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class ModelDynamiqueSalaire extends AbstractTableModel {
    private final List<Salaire> salaires;
 
    private final String[] entetes = {"Identifant", "date de debut", "date de fin", "charges patronales", "charges salariales", 
    						"brut", "identifiant employé"};
 
    public ModelDynamiqueSalaire(ArrayList<Salaire> salaires) {
        super();
        this.salaires = salaires;
    }
 
    public int getRowCount() {
    	return salaires.size();
    }
 
    public int getColumnCount() {
        return entetes.length;
    }
 
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }
 
    public Object getValueAt(int rowIndex, int columnIndex) {
    	DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
    
        switch(columnIndex){
	        case 0:
	            return salaires.get(rowIndex).getId();
            case 1:
                return dateFormat.format(salaires.get(rowIndex).getDateDebut());
            case 2:
                return dateFormat.format(salaires.get(rowIndex).getDateFin());
            case 3:
                return salaires.get(rowIndex).getChargesPatronales();
            case 4:
                return salaires.get(rowIndex).getChargesSalariales();
            case 5:
                return salaires.get(rowIndex).getBrut();
            case 6:
                return salaires.get(rowIndex).getId_employe();
           default:
                return null; //Ne devrait jamais arriver
        }
    }
 
    public void addSalaire(Salaire salaire) {
        salaires.add(salaire);
        fireTableRowsInserted(salaires.size() -1, salaires.size() -1);
    }
 
    
    public void removeSalaireFromTable(int rowIndex) {
        salaires.remove(rowIndex);
 
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
    
    
    
    public Date formatDateToStr(String s) {
		try {
			return new SimpleDateFormat("yyyy-mm-dd").parse(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
