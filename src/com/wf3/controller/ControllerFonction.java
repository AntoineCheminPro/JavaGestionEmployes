package com.wf3.controller;



import com.wf3.model.AdresseModel;
import com.wf3.model.Fonction;
import com.wf3.model.FonctionModel;

import com.wf3.vue.VueFormFonction;

public class ControllerFonction {
	
	private VueFormFonction vueFormFonction ;
	protected FonctionModel fonctionModel;
	
		public void createAdresse(Fonction fonction, int employe_id){
			fonctionModel.addFonction(fonction, employe_id);
		}
		
		public ControllerFonction() {
			super();
			fonctionModel = new FonctionModel();
		}
		
		

	}