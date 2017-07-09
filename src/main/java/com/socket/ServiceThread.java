package com.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 
 * Socket服务端线程类
 * 
 * 
 */
public class ServiceThread extends Thread {

	Socket socket = null;

	public ServiceThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {

		// 接收客户端上传的内容
		InputStream inputStream=null;
		InputStreamReader inputStreamReader=null;
		BufferedReader bufferedReader=null;
		// 服务端回复客户端一些内容
		OutputStream outputStream=null;
		OutputStreamWriter outputStreamWriter=null;
		PrintWriter printWriter=null;

		try {
			inputStream = socket.getInputStream();
			inputStreamReader = new InputStreamReader(inputStream);
			bufferedReader = new BufferedReader(inputStreamReader);
			String data = null;
			while ((data = bufferedReader.readLine()) != null) {
				System.out.println("我是服务器，客户端对我说:" + data);
				System.out.println("this is ServiceThread ID:"+this.getId());
				
			}
			socket.shutdownInput();

			outputStream = socket.getOutputStream();
			outputStreamWriter = new OutputStreamWriter(outputStream);
			printWriter = new PrintWriter(outputStreamWriter);
			printWriter.write("欢迎你跟我说话...");
			printWriter.flush();
			socket.shutdownOutput();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bufferedReader!=null){
					bufferedReader.close();					
				}
				if(inputStreamReader!=null){
					inputStreamReader.close();					
				}
				if(inputStream!=null){
					inputStream.close();					
				}
				if(printWriter!=null){
					printWriter.close();					
				}
				if(outputStreamWriter!=null){
					outputStreamWriter.close();					
				}
				if(outputStream!=null){
					outputStream.close();					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
