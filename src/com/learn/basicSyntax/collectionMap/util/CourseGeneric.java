package com.learn.basicSyntax.collectionMap.util;

import java.util.ArrayList;
import java.util.List;

import com.learn.basicSyntax.collectionMap.bean.ChildCourse;
import com.learn.basicSyntax.collectionMap.bean.Course;

/*
 * 课程管理 - 定义为泛型
 * 
 * */
public class CourseGeneric {

	private List<Course> courses;
	
	public CourseGeneric() {
		courses = new ArrayList<Course>();
	}
	
	/*
	 * 添加对象
	 * */
	public void add(){
		Course course = new Course(1,"高数");
	    courses.add(course);
	    //因为定义了泛型，只能插入泛型对象及其子类，其它的类型插入不进去了
	    //courses.add("插入字符串类型");
	}
	
	/*
	 * 添加泛型对象的子类
	 * 
	 * */
	public void addChild(){
		ChildCourse childCourse = new ChildCourse(3, "高等数学-补习班");
		courses.add(childCourse);
	}
	
	
	/*
	 * 循环对象
	 * */
	public void getForeach(){
		for (Course course : courses) {
			System.out.println("课程内容:"+course.getId()+":"+course.getName());
		}
	}
	
	public static void main(String[] args) {
		CourseGeneric courseGeneric = new CourseGeneric();
		courseGeneric.add();
		courseGeneric.addChild();
		courseGeneric.getForeach();
	}

}
