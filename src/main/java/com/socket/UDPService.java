package com.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPService {
	
	
	public static void main(String[] args) {
		
		
		try {
			
			//1、创建服务端DatagramSocket并指定接口
			DatagramSocket socket = new DatagramSocket(8888);
			
			//2、创建数据报，用于接收从客户端发送过来的数据
			byte[] data = new byte[1024];
			DatagramPacket datagramPacket = new DatagramPacket(data, data.length);
			
			System.out.println("******I am is Service, wait Client input.******");
			
			//3、接收客户端发送的数据
			socket.receive(datagramPacket);
			
			//4、读取数据
			String info = new String(data, 0, data.length);
			System.out.println("i am is Service, client is say:"+info);
			
			
			//回复客户端消息
			//DatagramSocket socket = new DatagramSocket();
			//1、创建回复内容Welcomes
			String replyData = "Welcome to Service";
			byte[] replyByte = replyData.getBytes();
			
			System.out.println("hostAddress:"+socket.getInetAddress());
			InetAddress address = InetAddress.getByName("localhost");
			DatagramPacket packet = new DatagramPacket(replyByte, replyByte.length, address, 9999);
		    
			//2、发送内容
			//socket.send(packet);
			DatagramSocket socket2 = new DatagramSocket();
			socket2.send(packet);
			System.out.println("reply Client success.");
			
		
			
			
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
