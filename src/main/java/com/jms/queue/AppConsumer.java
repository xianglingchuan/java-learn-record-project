package com.jms.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class AppConsumer {

	//private static final String url = "tcp://127.0.0.1:61616";
	//测试集群配置方案
	private static final String url = "failover:(tcp://127.0.0.1:61616,tcp://127.0.0.1:61617,tcp://127.0.0.1:61618)?randomize=true";
	
	
	private static final String queueName = "queue-test";
	
	public static void main(String[] args) {
		try {
			//1. 创建ConnectionFactory
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
			//2、创建Connection			
			Connection connection = connectionFactory.createConnection();
			System.out.println("I am Consumer start.");
			//3、启动会话
			connection.start();
			//4、创建会话
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			//5、创建一个目标
			Destination destination = session.createQueue(queueName);
			//6、创建一个消费者
			MessageConsumer consumer = session.createConsumer(destination);
			//7、创建一个监听器
			consumer.setMessageListener(new MessageListener() {
				
				@Override
				public void onMessage(Message message) {
					TextMessage textMessage = (TextMessage) message;
				    try {
						System.out.println("Consumer receive data:"+textMessage.getText());
					} catch (JMSException e) {
						e.printStackTrace();
					}
				}
			});
		
			//8、关闭
			//connection.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
}
