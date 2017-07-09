package com.socket;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

public class InetAddressDemo {

	public static void main(String[] args) throws UnknownHostException {

		InetAddress address = InetAddress.getLocalHost();
		System.out.println("计算机名称:" + address.getHostName());
		System.out.println("计算机IP:" + address.getHostAddress());
		//获取ip地址的字节数组
		byte[] bytes = address.getAddress();
		System.out.println("计算机IP:"+Arrays.toString(bytes));
		System.out.println("address:"+address);
		
		//根据计算机名称或ip地址获取InetAddress实例
		InetAddress address2 = InetAddress.getByName("XLC-MacBook-Pro.local");
		System.out.println("计算机名称:" + address2.getHostName());
		System.out.println("计算机IP:" + address2.getHostAddress());
		
		
		String ipAddress = "127.0.0.1";
		
		System.out.println("计算机IP.bytes:"+Arrays.toString(ipAddress.getBytes()));
		
		InetAddress address3 = InetAddress.getByAddress(bytes);
		System.out.println("计算机名称:" + address3.getHostName());
		System.out.println("计算机IP:" + address3.getHostAddress());
	}

}
