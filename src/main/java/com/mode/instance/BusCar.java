package com.mode.instance;

//单例模式 - 懒汉模式
public class BusCar {

	private static BusCar busCar;
	
	public static BusCar getInstance(){
		if(busCar==null){
			busCar =  new BusCar();
		}
		return busCar;
	}
}
