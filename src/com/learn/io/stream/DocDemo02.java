package com.learn.io.stream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

import com.mysql.jdbc.log.Log;

public class DocDemo02 {

	public static void main(String[] args) throws Exception {
//		String file = "demo/doc.txt";
//		
//		DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
//        int a = dataInputStream.readInt();	
//        System.out.println(a);
//		long b = dataInputStream.readLong();
//		System.out.println(b);
//		double c = dataInputStream.readDouble();
//		System.out.println(c);
//		a = dataInputStream.readInt();
//		System.out.println(a);
//		
//		String string = dataInputStream.readUTF();
//		System.out.println(string);
//		
//		char char1 = dataInputStream.readChar();
//		char char2 = dataInputStream.readChar();
//		System.out.println(char1+""+char2);
//		
		Random random = new Random();
		int sceneIndex=random.nextInt(2);
		System.out.println("sceneIndex:"+sceneIndex);
		
		
	}

}
