package com.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlDemo2 {
	
	
	public static void main(String[] args) throws MalformedURLException {
		
		//定义URL地址
		URL url = new URL("http://www.sina.com.cn");
		//通过url.openStream方法获取字节流
		   try {
		   InputStream iStream	= url.openStream();
		   //将字节输入流换转成字符输入流
		   InputStreamReader inputStreamReader = new InputStreamReader(iStream);
		   //创建字符流缓冲区
		   BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		   String data = bufferedReader.readLine(); //读取一行数据
		   while (data!=null) {
			  System.out.println(data);
			  data = bufferedReader.readLine();
		   }
		   //关闭相关操作
		   bufferedReader.close();
		   inputStreamReader.close();
		   iStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
