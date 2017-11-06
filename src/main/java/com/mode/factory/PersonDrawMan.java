package com.mode.factory;

import com.mode.factory.person.Boy;
import com.mode.factory.person.CmFactory;
import com.mode.factory.person.Girl;
import com.mode.factory.person.NewYearFactory;
import com.mode.factory.person.PersonFactory;

public class PersonDrawMan {
	
	public static void main(String[] args) {
		
		PersonFactory factory = new NewYearFactory();
		Boy boy = factory.getBoy();
		boy.drawMan();
		
        
		PersonFactory factory2 = new CmFactory();
		Girl girl = factory2.getGirl();
		girl.drawMan();
		
		
		
	}

}
