package com.mode.factory.person;


public class NewYearFactory implements PersonFactory {

	@Override
	public Boy getBoy() {
		return new NewYearBoy();
	}

	@Override
	public Girl getGirl() {
		return new NewYearGirl();
	}

	

}
