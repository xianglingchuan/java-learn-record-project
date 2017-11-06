package com.mode.factory.person;

public class CmFactory implements PersonFactory {

	@Override
	public Boy getBoy() {
		return new CmBoy();
	}

	@Override
	public Girl getGirl() {
		return new CmGirl();
	}

}
