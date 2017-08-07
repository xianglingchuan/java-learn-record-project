package com.jms.topic;


import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;


public class AppProducer {
	
	private static final String url = "tcp://127.0.0.1:61616";
	private static final String topicName = "topic-test";
	
	
	public static void main(String[] args) {
		
		try {
			//1. 创建ConnectionFactory
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
			//2、创建Connection			
			Connection connection = connectionFactory.createConnection();
			System.out.println("I am Producer start.");
			//3、启动会话
			connection.start();
			//4、创建会话
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			//5、创建一个目标
			Destination destination = session.createTopic(topicName);
			//6、创建一个生产者
			MessageProducer producer = session.createProducer(destination);
			for(int i=0; i<100; i++){
				//7、创建消息
				TextMessage textMessage = session.createTextMessage("hello test"+i);
				producer.send(textMessage);
				System.out.println("producer send "+textMessage.getText());
			}
			//8、关闭
			connection.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
