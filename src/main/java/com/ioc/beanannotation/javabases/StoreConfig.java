package com.ioc.beanannotation.javabases;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Configuration
public class StoreConfig {


	@Bean(name="store",initMethod="init",destroyMethod="destory")
	public StoreInterface getStore(){
		return new BreadStore();
	}
	
	
	@Bean(name="breadStore")
	@Scope(value="prototype")
	public StoreInterface breadStore(){
		return new BreadStore();
	}
	
	
}


