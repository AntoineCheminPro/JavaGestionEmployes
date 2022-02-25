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
public class ModelDynamiqueEmploye extends AbstractTableModel {
    private final List<Employe> employes;
 
    private final String[] entetes = {"ID", "Code", "Prénom", "Nom", "Sexe", 
    						"Date de naissance", "Date embauche", "Quotite"};
 
    public ModelDynamiqueEmploye(ArrayList<Employe> employes) {
        super();
        this.employes = employes;
    }
 
    public int getRowCount() {
    	return employes.size();
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
	            return employes.get(rowIndex).getId();
            case 1:
                return employes.get(rowIndex).getCode();
            case 2:
                return employes.get(rowIndex).getPrenom();
            case 3:
                return employes.get(rowIndex).getNom();
            case 4:
                return employes.get(rowIndex).getSexe() == 1 ? "Homme" : "Femme";
            case 5:
                return dateFormat.format(employes.get(rowIndex).getDateDeNaissance());
            case 6:
                return dateFormat.format(employes.get(rowIndex).getDateEmbauche());
            case 7:
                return employes.get(rowIndex).getQuotite();
            default:
                return null; //Ne devrait jamais arriver
        }
    }
 
    public void addEmploye(Employe employe) {
        employes.add(employe);
        fireTableRowsInserted(employes.size() -1, employes.size() -1);
    }
 
    
    public void removeEmployeFromTable(int rowIndex) {
        employes.remove(rowIndex);
 
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
