package com.learn.basicSyntax.collectionMap.bean;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/*
 * 学生类
 * 
 * */
public class Student implements Comparable<Student> {
	

	private int id;  //学生ID
	private String name; //学生名称
	private Set<Course> courses; //学生课程
	
	public Student(int id, String name, Set courses) {
		super();
		this.id = id;
		this.name = name;
		this.courses = courses;
	}	
	
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.courses = new HashSet<Course>();
	}	
	
	public Student() {
		super();
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

	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Student))
			return false;
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public int compareTo(Student o) {
		//return this.name.compareTo(o.name); //按姓名进行排序
		String id = String.valueOf(this.id);
		return id.compareTo(String.valueOf(o.id)); //按id进行排序
	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (!(obj instanceof Student))
//			return false;
//		Student other = (Student) obj;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		return true;
//	}	
	
	
	
}
