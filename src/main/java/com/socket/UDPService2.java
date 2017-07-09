package com.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;


public class UDPService2 {

	
	public static void main(String[] args) throws IOException {
		
		DatagramSocket socket = new DatagramSocket(8888);
	    DatagramPacket packet = null;		
		int count = 0;
		System.out.println("******I am is Service, wait Client input.******");
		
		while (true) {
			
			byte[] data = new byte[1024];
			packet = new DatagramPacket(data, data.length);
			//此方法在接收到数据报之前会一直
			socket.receive(packet);
			
			UDPServiceThread thread = new UDPServiceThread(socket,packet);
			thread.setPriority(4);//设置线程的优先级，范围为[0,19],默认值为5
			thread.start();
			
			count++;
			System.out.println("当前是第"+count+"位客户端创建链接..");			
		}

	}

}
