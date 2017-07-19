package com.ioc.beanannotation.javabases;

public class MyDeviceManager {

	private String url;
	
	private String username;
	
	private String password;

	
	public MyDeviceManager(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	
	public void print(){
		System.out.println("url:"+this.url+",username:"+this.username+",password:"+this.password);
	}
	
	
	
}
