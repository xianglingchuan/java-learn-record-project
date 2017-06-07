package com.learn.basicSyntax.collectionMap.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.learn.basicSyntax.collectionMap.bean.Student;
import com.learn.basicSyntax.collectionMap.bean.StudentComparator;

/*
 * 集合的排序练习
 * 
 * */
public class CollectionsSort {

	
	/*
	 * 对泛型Integer类型进行排序
	 * */
	public void sortInteger(){
		//定义保存integerList集合
		List<Integer> integerList = new ArrayList<Integer>();
		//生成100以内的随机数10个
		int key = 0;
		for(int i=0; i<10; i++){
			Random random = new Random();
			//判断该key值是否在integerList中存在
			do{
			   key = random.nextInt(100);				
			}while(integerList.contains(key));
			integerList.add(key);
		}
		System.out.println("-----------排序前------------");
		int i=0;
		for (Integer value : integerList) {
			System.out.println("顺序值:"+i+"  "+value);
			i++;
		}
		Collections.sort(integerList);
		System.out.println("-----------排序后------------");
		int j=0;
		for (Integer value : integerList) {
			System.out.println("顺序值:"+j+"  "+value);
		}	
	}
	
	
	/*
	 * 对泛型String类型进行排序
	 * */
	public void sortString(){
		List<String> stringList = new ArrayList<String>();
		stringList.add("microsoft");
		stringList.add("google");
		stringList.add("lenovo");
		stringList.add("mark");
		stringList.add("jack");
		System.out.println("-----------排序前------------");
		int i=0;
		for (String value : stringList) {
			System.out.println("顺序值:"+i+"  "+value);
			i++;
		}
		Collections.sort(stringList);
		System.out.println("-----------排序后------------");
		int j=0;
		for (String value : stringList) {
			System.out.println("顺序值:"+j+"  "+value);
		}		
	}	
	
	
	/**
	        练习：利用Collections.sort()方法对泛型为String的List进行排序版本2：
	         1、创建完List<String>之后，往其中添加十条随机字符串
	         2、每条字符串的长度为10以内的随机整数
	         3、每条字符串的每个字符都为随机生成的字符，字符可以重复，
	         4、每条随机字符串不可以重复
	 */	
	public void sortRandomString(){
		List<String> stringList = new ArrayList<String>();
		String string = "";
		for(int i=0; i<10; i++){
			do {
				string = markRandomString();
			} while (stringList.contains(string));
			stringList.add(string);			
		}
		System.out.println("-----------排序前------------");
		int i=0;
		for (String value : stringList) {
			System.out.println("顺序值:"+i+"  "+value);
			i++;
		}
		Collections.sort(stringList);
		System.out.println("-----------排序后------------");
		int j=0;
		for (String value : stringList) {
			System.out.println("顺序值:"+j+"  "+value);
		}		
	}
	
	
	/*
	 * 生成随机字符串
	 * */
	private String markRandomString(){
		String c = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		Random random = new Random();
		int strLength = random.nextInt(10);
		String randomString = "";
		//System.out.println("strLength:"+strLength);
		for(int i=0; i<=strLength; i++){
			Character character = c.charAt(random.nextInt(c.length()));
			randomString+=character.toString();
		}
		//System.out.println("randomString:"+randomString);			
		return randomString;
	}
	
	
	/*
	 * 对泛型Student进行排序操作
	 * 
	 * */
	public void sortStudent(){
		//先创建一个用StuentList集合
		List<Student> students = new ArrayList<Student>();
		//生成随机并且唯的学生ID号插入到List中去
		Random random = new Random();
		int studentId =  0;
	    String[] studentNames = {"Tom","Mark", "Angle"};
		for(int i=0; i<3; i++){
			//判断该值是否存在List中
			Student student;
			do {
				studentId = random.nextInt(4);
				student = new Student(studentId,studentNames[i]);
			} while (students.contains(student));		
			students.add(student);	
//			System.out.println("studentId="+studentId);					
		}
		System.out.println("--------------排序前---------------");
		for (Student student : students) {
			System.out.println("学生:"+student.getId()+":"+student.getName());
		}
		//开始排序Student,使用Comparable进行默认排序定义
		Collections.sort(students);
		System.out.println("--------------排序后---------------");
		for (Student student : students) {
			System.out.println("学生:"+student.getId()+":"+student.getName());
		}
		
		//开始排序Students使用Comparator进行临时排序操作
		System.out.println("--------------使用按姓名排序前---------------");
		for (Student student : students) {
			System.out.println("学生:"+student.getId()+":"+student.getName());
		}
		System.out.println("--------------使用按姓名排序后---------------");
		Collections.sort(students, new StudentComparator());
		for (Student student : students) {
			System.out.println("学生:"+student.getId()+":"+student.getName());
		}		
	}
	
	
	public static void main(String[] args) {
		CollectionsSort collectionsSort = new CollectionsSort();
		//collectionsSort.sortInteger();
		//collectionsSort.sortString();
		//collectionsSort.sortRandomString();
		collectionsSort.sortStudent();
	}

}
