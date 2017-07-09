package com.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientDemo {
	
	public static void main(String[] args) {
		
		try {
			Socket socket = new Socket("127.0.0.1",9999);
			
			OutputStream outputStream = socket.getOutputStream();
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
			PrintWriter printWriter = new PrintWriter(outputStreamWriter);
			printWriter.write("username:admin,password:123456");
			printWriter.flush();
			//关闭输出流
			socket.shutdownOutput();

			
			//接收服务端的回复信息
		    InputStream inputStream = socket.getInputStream();
		    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		    String data = null;
		    while((data=bufferedReader.readLine()) !=null){
		    	System.out.println("I am Client，Server say:"+data);
		    }	
		    //关闭输入流
		    socket.shutdownInput();
		    
		    bufferedReader.close();
		    inputStreamReader.close();
		    inputStream.close();
		    
			printWriter.close();
			outputStreamWriter.close();
			outputStream.close();
		    
		    socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
