package com.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPClient {

    public static void main(String[] args) {
    	
    	
    	try {
			//1、定义发送内容
			String string = "username:admin,passwprd:123456";
			byte[] data = string.getBytes();
			InetAddress address = InetAddress.getByName("localhost");
			int prot = 8888;
			
			//2、创建DatagramPacket,饮食将要发送的信息,包含发送的ip地址和端口号
			DatagramPacket packet = new DatagramPacket(data,data.length,address,prot);
			
			//3、创建DatagramSocket
			DatagramSocket socket = new DatagramSocket();
			
			//4、发送报文内容
			socket.send(packet);
			System.out.println("*******I am is Client, send success.*******");
			
			
			
			
			//接收服务端返回的消息内容
			//1、创建接收的Socket
			//DatagramSocket socket2 = new DatagramSocket(socket.getLocalPort());
			//2、创建接收的pcket
			byte[] replyData = new byte[1024];			
			DatagramPacket packet2 = new DatagramPacket(replyData,replyData.length);
			
			socket.receive(packet2);
			String info  = new String(replyData, 0, replyData.length);
			System.out.println("Server reply content:"+info);
			
			
			
			
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}
