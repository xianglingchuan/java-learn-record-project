package com.ioc.beanannotation.javabases;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:jdbc_dev.xml")
public class DeviceManagerConfig {
	
	@Value("${dev_url}")
	private String dbUrl;
	
	@Value("${dev_jdbc.username}")
	private String dbUsername;
	
	@Value("${dev_jdbc.password}")
	private String dbPassword;
	
	
	@Bean(name="myDeviceManager")
	public MyDeviceManager getMyDeviceManager(){
		return new MyDeviceManager(dbUrl, dbUsername, dbPassword);
	}
}
