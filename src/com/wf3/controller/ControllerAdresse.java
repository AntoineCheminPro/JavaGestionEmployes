package com.wf3.controller;
import com.wf3.model.Adresse;
import com.wf3.model.AdresseModel;
import com.wf3.vue.VueFormAdresse;


public class ControllerAdresse  extends Controller {
	
	private VueFormAdresse vueAdresse ;
	protected AdresseModel adresseModel;
	
	public void createAdresse(Adresse adresse, int employe_id){
		adresseModel.addAdresse(adresse, employe_id);
	}
	
	public ControllerAdresse() {
		super();
		adresseModel = new AdresseModel();
	}

}
