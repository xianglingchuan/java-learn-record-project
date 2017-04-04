package com.learn.basicSyntax.collectionMap.util;

import java.util.ArrayList;
import java.util.List;

import com.learn.basicSyntax.collectionMap.bean.Course;
import com.learn.basicSyntax.collectionMap.bean.Student;

public class CourseGeneric02 {

	private List lists;
	
	public CourseGeneric02() {
		lists = new ArrayList();
	}
	
	/*
	 * 添加对象
	 * */
	public void add(){
		Course course = new Course(1,"高数");
		lists.add(course);
	    //因为没有定义泛型，其它的类型也能插入进去
		lists.add("插入字符串类型");
		lists.add(new Student(1,"王老师"));		
	}
	
	
	/*
	 * 循环对象
	 * */
	public void getForeach(){
		for (Object object : lists) {
			//循环没有定义泛型的List对象最好用instanceof进行判断
			if(object instanceof Course){
				Course course = (Course)object;
				System.out.println("课程内容:"+course.getId()+":"+course.getName());				
			}else if(object instanceof Student){
				Student student = (Student)object;
				System.out.println("老师信息:"+student.getId()+":"+student.getName());								
			}else if(object instanceof String){
				String string = (String)object;
				System.out.println("字符串:"+string);
			}
		}
	}
		
	public static void main(String[] args) {
		CourseGeneric02 courseGeneric02 = new CourseGeneric02();
		courseGeneric02.add();
		courseGeneric02.getForeach();

	}
}
