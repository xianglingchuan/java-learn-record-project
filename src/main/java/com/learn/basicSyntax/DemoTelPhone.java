package com.learn.basicSyntax;

import com.learn.basicSyntax.bean.TelPhone;

public class DemoTelPhone {
	
	
	public static void main(String[] args) {

		TelPhone telPhone = new TelPhone();
		telPhone.setCup(1.5f);
		telPhone.setMemory(8);
		telPhone.setSize(5.4f);

		TelPhone telPhone2 = new TelPhone();
		telPhone2.setCup(1.5f);
		telPhone2.setMemory(8);
		telPhone2.setSize(5.4f);
		
		if(telPhone.equals(telPhone2)){
			System.out.println("两个telPhone类相同");
		}else{
			System.out.println("两个telPhone类不相同");
		}

		
		
	}
}
