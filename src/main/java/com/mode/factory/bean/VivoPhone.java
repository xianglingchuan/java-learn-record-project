package com.mode.factory.bean;

public class VivoPhone  implements PhoneInterface{

	@Override
	public void call() {
		System.out.println("********Vivo phone call********");
	}

}
