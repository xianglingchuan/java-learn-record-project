package com.learn.basicSyntax.polymorphic.telphone;
import com.learn.basicSyntax.polymorphic.telphone.TelPhone;

public class CellPhone extends TelPhone {

	@Override
	public void call() {
		System.out.println("通过键盘打电话.");		
	}

	@Override
	public void message() {
		System.out.println("通过键盘发短信.");		
	}
}
