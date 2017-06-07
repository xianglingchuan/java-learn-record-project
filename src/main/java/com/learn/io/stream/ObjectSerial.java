package com.learn.io.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectSerial {

	public static void main(String[] args) throws Exception{
	
		String file = "demo/object.txt";
		/*ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
		Student student = new Student(11,"李四",35);
		outputStream.writeObject(student);
		outputStream.flush();
		outputStream.close();*/
		
		
		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
		Student student = (Student) inputStream.readObject();
		System.out.println(student.toString());
		student.setName("张三");
		System.out.println(student.getName());

	}

}
