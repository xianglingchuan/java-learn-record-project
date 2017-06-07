package com.learn.io.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IODemo04 {

	public static void main(String[] args) throws Exception {
		//获取文件字符流
		FileInputStream fileInputStream = new FileInputStream("demo/file.txt");
		
		//如果不给定编码格式，那么默认读取项目设置的编码格式
		//FileInputStream fileInputStream = new FileInputStream("demo/file.txt", "utf-8");
		
		
		InputStreamReader reader = new InputStreamReader(fileInputStream);
		/*int ichar;
		while ((ichar = reader.read())!=-1) {
			System.out.print((char)ichar);
		}*/
		
		char[] achar = new char[1024];
		int ichar;
		//批量读取，放入buffer这个字符数组，从第0个位置开始放置，最多放buffer.length长度
		//返回的是读到的字符个数
		while((ichar=reader.read(achar,0,achar.length))!=-1){
			//System.out.println(achar);
			String string = new String(achar, 0, ichar);
			System.out.println("string:"+string);
		}
	}

}














