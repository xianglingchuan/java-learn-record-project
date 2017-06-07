package com.learn.io.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectSerialDemo2 {

	public static void main(String[] args) throws IOException, Exception {
		
		String file = "demo/object10.txt";
		ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
		Foot3 foot3 = new Foot3();
		outputStream.writeObject(foot3);
		outputStream.flush();
		outputStream.close();
		
		System.out.println("==========进行反序列化============");
		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
		Foot3 foot31 = (Foot3)inputStream.readObject();
		System.out.println(foot31);

		
		
	}
}
