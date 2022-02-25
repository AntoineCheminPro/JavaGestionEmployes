package com.wf3.controller;
import com.wf3.model.Adresse;
import com.wf3.model.AdresseModel;
import com.wf3.vue.VueFormAdresse;


public class ControllerAdresse  extends Controller {
	private VueFormAdresse vueAdresse ;
	protected AdresseModel db;
	public void createAdresse(Adresse adresse, int employe_id){
		db.addAdresse(adresse, employe_id);
	}
	public ControllerAdresse() {
		super();
		db = new AdresseModel();
//		vueAdresse = new VueFormAdresse(this);
//		vueAdresse.frame.setVisible(true);
	}

}
