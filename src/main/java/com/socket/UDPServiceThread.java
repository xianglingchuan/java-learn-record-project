package com.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

public class UDPServiceThread extends Thread{
	
	
	public DatagramSocket socket;
	
	public DatagramPacket packet;
	
	
	public UDPServiceThread(DatagramSocket socket,DatagramPacket packet){
		this.socket = socket; 
		this.packet = packet;
	}
	
	
	@Override
	public void run(){
//		try {
			String info = new String(packet.getData(), 0, packet.getData().length);
			System.out.println("客户端对我说:"+info);
			
			
			InetAddress address = packet.getAddress();
			int port = packet.getPort();
			System.out.println("address:"+address+", port:"+port);
            //port = packet.getPort();
            byte[] data2 = "我在响应你！".getBytes();
            DatagramPacket   packet2 = new DatagramPacket(data2, data2.length, address, port);
            //DatagramSocket socket2 = new DatagramSocket();
            try {
				socket.send(packet2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			
			
			/*
			 * 回复客户端消息
			 */
			//1、创建回复内容Welcomes
//			String replyData = "Welcome to Service";
//			byte[] replyByte = replyData.getBytes();
//			System.out.println("hostAddress:"+socket.getInetAddress());
//			InetAddress address = InetAddress.getByName("localhost");
//			DatagramPacket packet = new DatagramPacket(replyByte, replyByte.length, address, 9999);
//			//2、发送内容
//			DatagramSocket socket2 = new DatagramSocket();
//			socket2.send(packet);
//			System.out.println("reply Client success.");
			
//		} catch (UnknownHostException e) {
//			e.printStackTrace();
//		} catch (SocketException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		
	}

}
