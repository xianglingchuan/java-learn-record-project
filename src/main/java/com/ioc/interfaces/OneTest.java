package com.ioc.interfaces;

public class OneTest {

	public static void main(String[] args) {
		
		OneInterfaces interfaces = new OneInterfacesImpl();
		System.out.println(interfaces.myPrint("java ioc"));
	}

}
