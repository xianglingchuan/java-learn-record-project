package com.ioc.beanannotation.javabases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class CarConfig {

	
	@Autowired
	private CarInterface<String> s1;
	
	@Autowired
	private CarInterface<Integer> s2;
	
	
	@Bean
	public StringCar stringCar(){
		return new StringCar();
	}
	
	@Bean
	public IntegerCar integerCar(){
		return new IntegerCar();
	}
	
	
	@Bean(name="stringCarTest")
	public CarInterface stringCarTest(){
		System.out.println("s1:"+s1.getClass().getName());
		//System.out.println("s2:"+s2.getClass().getName());
		return new StringCar();
	}
	
	
}







