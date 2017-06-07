package com.learn.io.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectSerialDemo3 {

	public static void main(String[] args) throws IOException, Exception {
		
		String file = "demo/object11.txt";
		ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
		SmallDog smallDog = new SmallDog();
		outputStream.writeObject(smallDog);
		outputStream.flush();
		outputStream.close();
		
		System.out.println("==========进行反序列化============");
		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
		SmallDog smallDog2 = (SmallDog)inputStream.readObject();
		System.out.println(smallDog2);

		
		
	}
}
