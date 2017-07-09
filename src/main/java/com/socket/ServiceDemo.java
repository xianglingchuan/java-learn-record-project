package com.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.xml.crypto.Data;

public class ServiceDemo {
	
	
	public static void main(String[] args) {
		
		try {
			
			ServerSocket serverSocket = new ServerSocket(9999);
			System.out.println("**************服务器即将启动，等待客户端联接**************");
			Socket socket = serverSocket.accept();
			
			//接收客户端上传的内容
		    InputStream inputStream = socket.getInputStream();
		    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		    String data = null;
		    while((data=bufferedReader.readLine()) !=null){
		    	System.out.println("我是服务器，客户端对我说:"+data);
		    }
		    socket.shutdownInput();
		    
		    
		    //服务端回复客户端一些内容
		    OutputStream outputStream = socket.getOutputStream();
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
			PrintWriter printWriter = new PrintWriter(outputStreamWriter);
			printWriter.write("欢迎你跟我说话...");
			printWriter.flush();
			socket.shutdownOutput();
			
			
			
			printWriter.close();
			outputStreamWriter.close();
			outputStream.close();
			
			
			
		    bufferedReader.close();
		    inputStreamReader.close();
		    inputStream.close();		    
		    
		     //关闭输入流
		    
		    
		    socket.close();
		    
		    serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
