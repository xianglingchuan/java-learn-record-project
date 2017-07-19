package com.ioc.autowiring;


public class AutoWiringService {

	private AutoWiringDAO autoWiringDAO;
	
	
	public AutoWiringService(AutoWiringDAO autoWiringDAO){
		System.out.println("exeucte AutoWiringService");
		this.autoWiringDAO = autoWiringDAO;		
	}
	
	
	public AutoWiringDAO getAutoWiringDAO() {
		return autoWiringDAO;
	}


	public void setAutoWiringDAO(AutoWiringDAO autoWiringDAO) {
		System.out.println("exeucte setAutoWiringDAO");
		this.autoWiringDAO = autoWiringDAO;
	}


	public void say(String word){
		autoWiringDAO.say(word);
	}
	
	
}
