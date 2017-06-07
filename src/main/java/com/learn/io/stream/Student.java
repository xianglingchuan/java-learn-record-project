package com.learn.io.stream;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

class Student implements Serializable {

	private int id;
	private String name;
	private int age;

	private transient String className; // transient关键字，该元素不会进行jvm默认的序列化
	// 但也可以自己完成这个元素的序列化,查看ArrayList源码

	public Student() {
		super();
	}

	public Student(int id, String name, int age, String className) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.className = className;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	// 使用该方法进行手动序列化
	private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
		s.defaultWriteObject(); // 把jvm能默认序列化的元素进行序列化操作
		s.writeObject(className); // 自己完成属性的序列化操作
	}

	// 使用该方法进行手动反序列化操作
	private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
		s.defaultReadObject();
		this.className = (String)s.readObject(); //自己完成属性的反序列化操作
		
		
	}

}
