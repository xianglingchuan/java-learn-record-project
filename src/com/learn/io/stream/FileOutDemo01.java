package com.learn.io.stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutDemo01 {

	public static void main(String[] args) throws IOException {
		//如果该文件不存在就直接创建，如果存在，删除后在创建
		FileOutputStream out = new FileOutputStream("demo/out.dat");
		//如果该文件不存在就直接创建，如果存在，内容就追加上去
		FileOutputStream out2 = new FileOutputStream("demo/out.dat",true);
		
		out.write('A'); //写出了'A'的低八位
		out.write('B'); //写出了'B'的低八位
		int a= 10;  //write只能写八位，那么写一个int需要写4次8位
		out.write(a >>> 24);
		out.write(a >>> 16);
		out.write(a >>> 8);
		out.write(a);
		byte[] string = "中国".getBytes("utf-8");
		out.write(string);
		out.close();
		
		
		IOUtil.printHex("demo/out.dat");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
