package com.socket;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.imageio.stream.FileImageOutputStream;

public class UDPServiceFile {

	public static void main(String[] args) {
		try {
			// 创建服务端DatagramSocket并指定接口
			DatagramSocket socket = new DatagramSocket(8888);

			// 创建数据报，用于接收从客户端发送过来的数据
			byte[] data = new byte[1024*1024];
			DatagramPacket datagramPacket = new DatagramPacket(data, data.length);
			System.out.println("******I am is Service, wait Client input.******");

			// 接收客户端发送的数据
			socket.receive(datagramPacket);
			
			
			File file = new File("new.jpg");
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			System.out.println("length:"+datagramPacket.getLength());
			System.out.println("datagramPacket.getData()"+datagramPacket.getData().length);
			fileOutputStream.write(datagramPacket.getData(),0,datagramPacket.getLength());
			fileOutputStream.close();
			
			System.out.println("client update img save success.");
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
