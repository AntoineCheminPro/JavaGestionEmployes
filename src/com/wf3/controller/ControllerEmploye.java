package com.wf3.controller;
import com.wf3.model.EmployeModel;
import com.wf3.vue.VueFormEmploye;
import com.wf3.vue.VueGenerale;

import java.text.ParseException;
import java.util.ArrayList;
import com.wf3.model.*;

public class ControllerEmploye extends Controller{
	
	private VueGenerale vueGenerale ;
	protected EmployeModel db;
	
	public void createEmploye(Employe employe){
		db.addEmploye(employe);
	}
	
	public ControllerEmploye () {
		super();
		db = new EmployeModel();
		vueGenerale = new VueGenerale(this);
		vueGenerale.setVisible(true);
	}
	
	public ArrayList<Employe> getAll(){
		
		try {
			return db.getAllEmploye();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
