package com.socket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServiceDemo2 {
	
	public static void main(String[] args) throws IOException {
		
		ServerSocket serviceSocket = new ServerSocket(9999);
		System.out.println("**************服务器即将启动，等待客户端联接**************");
		Socket socket = null;
		
		int clientCount = 0;
		//开始循环启动socket
		while (true) {
			socket = serviceSocket.accept();
			
			ServiceThread serviceThread = new ServiceThread(socket);
			serviceThread.start();		
			
			InetAddress inetAddress =   socket.getInetAddress();
			
			 String hostAddress = inetAddress.getHostAddress();
			
			
			
			clientCount++;
			System.out.println("当前共有"+clientCount+"位客户端链接.ip address:"+hostAddress);
		}
	}
}
