package com.socket;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class UDPClientObject {

	public static void main(String[] args) throws ClassNotFoundException {

    	try {
    		
    		User user = new User("admin","123456");
    		//此类实现了一个输出流，其中的数据被写入一个 byte 数组。缓冲区会随着数据的不断写入而自动增长。
    		//可使用 toByteArray() 和 toString() 获取数据
    		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    		
    		ObjectOutputStream stream = new ObjectOutputStream(byteArrayOutputStream);
    		stream.writeObject(user);
    		stream.flush();
    		stream.close();
    		
    		byte[] data = new byte[1024];
    		data = byteArrayOutputStream.toByteArray();
    		byteArrayOutputStream.close();
    		
    		//创建DatagramPacket,饮食将要发送的信息,包含发送的ip地址和端口号
			InetAddress address = InetAddress.getByName("localhost");
			int prot = 8888;
			DatagramPacket packet = new DatagramPacket(data,data.length,address,prot);
    		
    		//创建DatagramSocket
			DatagramSocket socket = new DatagramSocket();
			
			//发送报文内容
			socket.send(packet);
			System.out.println("*******I am is Client, send success.*******");
			
			//接收服务端返回的响应内容
			//System.out.println("port1:"+packet.getPort()+", port2:"+socket.getPort()+",port3:"+socket.getLocalPort());
			//创建接收的pcket
			byte[] replyData = new byte[1024];	
			DatagramPacket packet2 = new DatagramPacket(replyData,replyData.length);
			
			socket.receive(packet2);
			//System.out.println("=====" + new String(packet2.getData()));
			
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(replyData);
			ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
			Result result = (Result)objectInputStream.readObject();
			System.out.println("Service say code:"+result.getCode()+",message:"+result.getMessage());
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
