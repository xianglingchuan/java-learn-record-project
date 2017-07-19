package com.ioc.resource;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;

public class MyResource implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public void readResource() {
		try {
			//Resource resource = applicationContext.getResource("classpath:common.properties");
			//Resource resource = applicationContext.getResource("file:/Users/xianglingchuan/Documents/work/learnWorkspace/learn/src/main/resources/common.properties");
			Resource resource = applicationContext.getResource("url:http://mvnrepository.com/search?q=hibernate-validator");
			//Resource resource = applicationContext.getResource("common.properties");
			
			System.out.println("fileName: "+resource.getFilename());
			System.out.println("URL: "+resource.getURL());
			System.out.println("contentLength: "+resource.contentLength());
			
			
			
			
			InputStream inputStream =  resource.getInputStream();
			byte[] data = new byte[23907];
			inputStream.read(data);
			String string = new String(data);
			System.out.println("data: "+string);
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
