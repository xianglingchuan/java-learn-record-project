package com.learn.basicSyntax.collectionMap.util;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.learn.basicSyntax.collectionMap.bean.Student;

public class StudentMap {

	
	/*
	 * 
	 * 将学生信息保存在Map中
	 * 
	 * */
	private Map<String, Student> students;
	
	
	/*
	 * 构造函数
	 * 
	 * */
    public StudentMap(){
    	students = new HashMap<String,Student>();
    }
    
    /*
     * 添加学生信息
     * 
     * */
    public void put(){
    	//循环添加三位学生信息，需要保存学生ID在Map中是否存在，不存在添加，存在提示
    	Scanner  scanner = new Scanner(System.in);
    	int inputSutdentNumber = 0;
    	while(inputSutdentNumber<3){
    		System.out.print("请输入学生ID号：");
    		String studentId = scanner.next();
    		if(studentId!=null){
    			//判断学生ID在map中是否存在
    			Student student = students.get(studentId);
    			if(student==null){
    				//开始创建学生
    				System.out.print("请输入学生姓名：");
    				String studentName = scanner.next();
    				students.put(studentId, new Student(Integer.valueOf(studentId), studentName));
    				System.out.println("学生"+students.get(studentId).getName()+"添加成功!");
    				inputSutdentNumber++;
    				continue;
    			}else{
    				System.out.println("学生ID:"+studentId+"已经存在.");
    			}
    		}else{
    			System.out.println("学生ID号不能为空.");
    		}    		
    	}
    }
    
    
    /*
     * 循环学生信息
     * 
     * */
    public void keySet(){
    	Set<String> studentIds = students.keySet();
    	System.out.println("学生总数为:"+students.size()+"名");
    	for (String studentId : studentIds) {
			Student student = students.get(studentId);
			if(!student.equals(null)){
			   System.out.println("学生信息:"+student.getId()+":"+student.getName());	
			}
		}
    }
    
    
    /*
     * 通过values()显示Map中的信息
     * */
    public void values(){
    	 Collection<Student> students1 = ((AbstractMap<String,Student>)students).values();
    	 for (Student student : students1) {
			System.out.println(student.getName());
		}
    }
    
    /*
     * 通过Entry显示map中的信息
     * */    
    public void Entry(){
       System.out.println("通过Entry读取");
       Set<java.util.Map.Entry<String, Student>> students1 = students.entrySet();
       System.out.println("学生数量为:"+students1.size()+"名");
       for (java.util.Map.Entry<String, Student> entry : students1) {
    	   Student student = entry.getValue();
    	   System.out.println("学生姓名："+student.getName());
	   }
    }
    
    
    /*
     * 删除Map集合中的内容
     * 
     * */
    public void remove(){
    	Scanner scanner = new Scanner(System.in);
    	while(true){
    		System.out.println("请输入要删除学生的ID:");
    		String studentId = scanner.next();
    		Student student = students.get(studentId);
    		if(student==null){
    			System.out.println("要删除的学生信息不存在!");
    			continue;
    		}
    		students.remove(studentId);
    		System.out.println("学生"+student.getName()+"被删除成功！");
    		break;
    	}    	
    }
    
    /*
     * 修改Map中的学生信息
     * */
    public void modify(){
    	Scanner scanner = new Scanner(System.in);
    	while(true){
    		System.out.println("请输入要修改的学生ID号：");
    		String studentId = scanner.next();
    		Student student = students.get(studentId);
    		if(student==null){
    			System.out.println("你输入的学生ID信息不存在.");
    			continue;
    		}
    		System.out.println("当前学生姓名为："+student.getName());
    		System.out.println("请输入新的学生姓名：");
    		String studentName = scanner.next();
    		student.setName(studentName);
    		break;
    	}
    }
    
    
    /*
     * 测试Map中是否包含某个Key值或者某个Value值
     * */
    public void containsKeyOrValue(){
    	//提示输入学生ID
    	//在Map中，用containsKey()方法，来判断是否饮食某个key值，用containsValue方法，来判断是否包含某个Value值。
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("输入你要查询学生的ID号：");
    	String studentId = scanner.next();
    	//使用containsKey查询学生ID是否存在
    	System.out.println("你输入的学生ID:"+studentId+",在学生列表中是否存在："+students.containsKey(studentId));
    	if(students.containsKey(studentId)){
    		System.out.println("学生ID:"+students.get(studentId).getId()+", 学生姓名："+students.get(studentId).getName());
    	}else{
    		System.out.println("学生ID"+studentId+"在学生列表中没有找到.");
    	}
    	System.out.println("输入你要查询的学生姓名：");
    	String studentName = scanner.next();
    	//使用containsValue方法来判断某个学生是否存在
    	//这里需要重亲Student类的equals方法
    	System.out.println("你输入的学生姓名:"+studentName+",在学生表中是否存在："+students.containsValue(new Student(0,studentName)));
    	if(students.containsValue(new Student(0,studentName))){
    		System.out.println("学生姓名："+studentName+"已经找到");    		
    	}else{
    		System.out.println("学生姓名："+studentName+"没有找到");    		    		
    	}
    }
    
    
	
	public static void main(String[] args) {
		StudentMap studentMap = new StudentMap();
		studentMap.put();
		studentMap.keySet();
		//studentMap.values();
		//studentMap.Entry();
		//studentMap.remove();
		//studentMap.Entry();		
		//studentMap.modify();
		//studentMap.Entry();
		studentMap.containsKeyOrValue();
		
	}

}














