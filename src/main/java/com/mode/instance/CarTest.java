package com.mode.instance;

public class CarTest {
	
	public static void main(String[] args) {
		
		Car car = Car.getInstance();
		Car car2 = Car.getInstance();
		if(car == car2){
			System.out.println("car与car2相等");
		}else{
			System.out.println("car与car2不相等");
		}
		
		System.out.println("**********************************");
		
		BusCar busCar = BusCar.getInstance();
		BusCar busCar2 = BusCar.getInstance();
		if(busCar == busCar2){
			System.out.println("busCar与busCar2相等");
		}else{
			System.out.println("busCar与busCar2不相等");
		}
		
		
		
		
		
	}

}
