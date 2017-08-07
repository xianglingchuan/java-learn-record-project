package com.jms.consumer.topic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppConsumer {
	
	public static void main(String[] args) {
		System.out.println("AppConsumer...main");
		ApplicationContext context = new ClassPathXmlApplicationContext("jms-consumer-topic.xml");
	}

}
