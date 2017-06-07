package com.learn.io.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectSerialDemo1 {

	public static void main(String[] args) throws Exception{
	
		String file = "demo/object1.txt";
		ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
		Student student = new Student(11,"李四",35,"高三一班");
		outputStream.writeObject(student);
		outputStream.flush();
		outputStream.close();
		
		
		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
		Student student2 = (Student) inputStream.readObject();
		System.out.println(student2.toString());
		System.out.println(student2.getClassName());

	}

}
