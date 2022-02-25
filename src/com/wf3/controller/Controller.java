package com.wf3.controller;


public class Controller {

	public Controller() {
		
	}

	public static void main(String[] args) {
		new ControllerEmploye();
		new ControllerAdresse();
	}
	
	public static void reload() {
		new ControllerEmploye();
	}
}


