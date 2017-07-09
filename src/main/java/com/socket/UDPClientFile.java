package com.socket;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.imageio.stream.FileImageInputStream;

import com.sun.org.apache.bcel.internal.classfile.StackMapEntry;

public class UDPClientFile {

	public static void main(String[] args) throws IOException {
		//1、定义发送内容
		InetAddress address = InetAddress.getByName("localhost");
		int prot = 8888;
		
		//注意这里是容易出错的地方
		byte[] data = new byte[1024]; //这里会通过byteArrayOutputStream重新赋值		
		FileInputStream inputStream = new FileInputStream("a.jpg");
		//用于存放输出流的byte数组对象
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		byte[] tmp = new byte[1024]; //循环读取文件内容，每次读取1024
		int numBytesRead = 0;
		while( (numBytesRead=inputStream.read(tmp))!=-1 ){
			System.out.println("numBytesRead==="+numBytesRead);
			byteArrayOutputStream.write(tmp, 0, numBytesRead);
		}
		data = byteArrayOutputStream.toByteArray();
		byteArrayOutputStream.close();
		inputStream.close();
		System.out.println("data.length:"+data.length);
		System.out.println("====="+new String(data));
		
		
		
		//2、创建DatagramPacket,饮食将要发送的信息,包含发送的ip地址和端口号
		DatagramPacket packet = new DatagramPacket(data,data.length,address,prot);
		
		//3、创建DatagramSocket
		DatagramSocket socket = new DatagramSocket();
		
		//4、发送报文内容
		socket.send(packet);
		System.out.println("*******I am is Client, send success.*******");
	}
	
	
}
