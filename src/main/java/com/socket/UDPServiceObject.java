package com.socket;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPServiceObject {
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		try {
			//创建服务端DatagramSocket并指定接口
			DatagramSocket socket = new DatagramSocket(8888);
			
			//创建数据报，用于接收从客户端发送过来的数据
			byte[] data = new byte[1024];
			DatagramPacket datagramPacket = new DatagramPacket(data, data.length);
			System.out.println("******I am is Service, wait Client input.******");
			
			//接收客户端发送的数据
			socket.receive(datagramPacket);

			//System.out.println("=====" + new String(datagramPacket.getData()));
			ByteArrayInputStream bInputStream = new ByteArrayInputStream(data);
			
			ObjectInputStream oStream =new ObjectInputStream(bInputStream);
			User user =  (User) oStream.readObject();
			System.out.println("client say username:"+user.getUsername()+", password:"+user.getPassword());
			
			
			//回复客户端对象
			//组装回复的数据
			ByteArrayOutputStream bOutputStream = new ByteArrayOutputStream();
			ObjectOutputStream outputStream = new ObjectOutputStream(bOutputStream);
			Result result = new Result(1, "login sucess.");
			
			outputStream.writeObject(result);
			
			byte[] outputData = new byte[1024];
			outputData = bOutputStream.toByteArray();
			outputStream.close();
			bOutputStream.close();
			
			//回复客户端消息
			//System.out.println("hostAddress:"+socket.getInetAddress());
			InetAddress address = datagramPacket.getAddress();
			int port = datagramPacket.getPort();
			System.out.println("address:"+address.getHostName()+",port:"+port);
			DatagramPacket packet = new DatagramPacket(outputData, outputData.length, address, port);
			
			//发送回复内容
			socket.send(packet);
			System.out.println("reply Client success.");			
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
