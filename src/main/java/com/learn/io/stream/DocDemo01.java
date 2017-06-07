package com.learn.io.stream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class DocDemo01 {

	public static void main(String[] args) throws Exception {
		
		String file = "demo/doc.txt";
		DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
		dataOutputStream.writeInt(100);
		dataOutputStream.writeLong(10l);
		dataOutputStream.writeDouble(1.11);
		dataOutputStream.writeInt(-100);
        //采用utf-8编码写入		
		dataOutputStream.writeUTF("中国人民共合国");
		//采用java默认编码utf-16be编码写入
		dataOutputStream.writeChars("深圳");
		dataOutputStream.close();
		
		IOUtil.printHex(file);
		
		DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
		String str = dataInputStream.readUTF();
		System.out.println("str:"+str);
		

	}
	
	
	
	

}
