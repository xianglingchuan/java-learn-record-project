package com.mode.cor;

import com.mode.cor.handler.CEO;
import com.mode.cor.handler.Director;
import com.mode.cor.handler.Manager;
import com.mode.cor.handler.PriceHandler;
import com.mode.cor.handler.Sales;
import com.mode.cor.handler.VicePresident;

public class PriceHandlerFactory {

	public static PriceHandler createPriceHandler() {
		
		Sales sales = new Sales();
		Manager manager = new Manager();
		Director director = new Director();
		VicePresident vicePresident = new VicePresident();
		CEO ceo = new CEO();
		
		sales.setSuccessor(manager);
		manager.setSuccessor(director);
		director.setSuccessor(vicePresident);
		vicePresident.setSuccessor(ceo);
		return sales;
	}

}
