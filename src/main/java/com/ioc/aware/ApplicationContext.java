package com.ioc.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContext implements ApplicationContextAware  {

	@Override
	public void setApplicationContext(org.springframework.context.ApplicationContext applicationContext)
			throws BeansException {
	
		System.out.println("applicationContext:"+applicationContext.getBean("applicationContext").hashCode());
	}

}
