package com.socket;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlDemo {
	
	
	public static void main(String[] args) throws MalformedURLException {
		
		//创建一个URL实例
		URL url = new URL("http://www.baidu.com");
		//可以在源有的URL基础之上创建新的URL
		URL url2 = new URL(url, "/index.html?username=tom#direct_url");
		System.out.println("协议:"+url2.getProtocol());
		System.out.println("主机:"+url2.getHost());
		//如果未指定端口号，则使用默认的端口号，此时getPort()方法返回值为-1
		System.out.println("端口"+url2.getPort());
		System.out.println("文件路径:"+url2.getPath());
		System.out.println("文件名:"+url2.getFile());
		System.out.println("相对路径:"+url2.getRef());
		System.out.println("请求参数:"+url2.getQuery());
	}

}
