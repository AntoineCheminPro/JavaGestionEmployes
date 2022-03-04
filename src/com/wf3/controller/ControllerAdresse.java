package com.wf3.controller;
import com.wf3.model.Adresse;
import com.wf3.model.AdresseModel;
import com.wf3.model.Employe;
import com.wf3.vue.VueFormAdresse;


public class ControllerAdresse  extends Controller {
	
	private VueFormAdresse vueAdresse ;
	protected AdresseModel adresseModel;
	
	public void createAdresse(Adresse adresse, Employe employe){
		adresseModel.addAdresse(adresse, employe);
	}
	
	public ControllerAdresse() {
		super();
		adresseModel = new AdresseModel();
	}

}
