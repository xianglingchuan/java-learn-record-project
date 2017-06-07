package com.learn.basicSyntax.collectionMap.util;

import java.io.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.apache.el.util.ConcurrentCache;
import org.eclipse.jdt.internal.compiler.ast.CompoundAssignment;
import org.ietf.jgss.Oid;

import com.learn.basicSyntax.collectionMap.bean.Course;
import com.learn.basicSyntax.collectionMap.bean.Student;

public class CourseSet {

	private Set courseSets;
	
	private Scanner scanner;
	
	public CourseSet(){
		courseSets = new HashSet<Course>();
		scanner = new Scanner(System.in);
	}
	
	public Set<Course> getCourseSets(){
		return courseSets;
	}
	
	
	/*
	 * 添加课程
	 * */
	public void add(){
		Course course = new Course(1,"大数据");
		courseSets.add(course);
		Course course2 = new Course(2,"Java编程思想");
		courseSets.add(course2);
		Course[] courses = {new Course(3,"javascription"), new Course(4,"数据结构")};
		courseSets.addAll(Arrays.asList(courses));
        Course[] courses2 = {new Course(5,"Object-c"), new Course(6,"Linux运维")};
		courseSets.addAll(Arrays.asList(courses2));
	    courseSets.addAll(Arrays.asList(courses2));
    }	
	
	
	/*
	 * 读取课程foreach
	 * 
	 * */
	public void getForeach(){
		System.out.println("课程列表如下：");
		for (Object object : courseSets) {
			Course course = (Course)object;
			System.out.println("课程id:"+course.getId()+" 名称:"+course.getName());
		}
	}	
	
	
	/*
	 * 循环学生选择的课程
	 * 
	 * */
	public void getForeachForSet(Student student){
		System.out.println(student.getName()+"选择课程如下：");
		for (Course course : student.getCourses()) {
			System.out.println("课程id:"+course.getId()+" 名称:"+course.getName());
		}
	}
	
    /*
     * 学生选择课程
     * 
     * */
	public void studentSelectedCourse(){
		Student student = new Student(1,"Mark");
		System.out.println("欢迎同学:"+student.getName()+",请选择课程：");
		int selectCourseNumber = 0;
		//创建一个Scanner对象，用来接收从键盘输入的课程ID
		Scanner scanner = new Scanner(System.in);
        while(selectCourseNumber<3){
        	System.out.print("请输入课程编号:");
        	String scannerId = scanner.next();
        	boolean isFindCourse = false;
        	for (Course course : this.getCourseSets()) {
        		int courseId = course.getId();
				if(String.valueOf(course.getId()).equals(scannerId)){
					student.getCourses().add(course);
					selectCourseNumber++; 
					isFindCourse = true;
				}
			}        	
        	if(!isFindCourse){
            	System.out.println("对不起，课程ID"+scannerId+",没有找到该课程，请重新输入。");        		
        	}
        }
        System.out.println("课程选择完成.");
        this.getForeachForSet(student);		
        this.findStudentForCourse(student);
	}
	
	/*
	 * 查询学生已选择的课程
	 * */
	public void findStudentForCourse(Student student){
		while (true) {
    		System.out.print("请输入学生已选课程ID:");
    		String courseId = scanner.next();
    		System.out.print("请输入学生已选课程名称:");
    		String courseName = scanner.next();
    		
    		Set<Course>  courses =  student.getCourses();
    		Course courseNew = new Course(Integer.valueOf(courseId), courseName);
    		if(!courses.contains(courseNew)){
    			System.out.println("对不起，课程"+courseNew.getName()+",学生没有选择该课程");
    			continue;
    		}else{
    			System.out.println("课程"+courseNew.getName()+"，学生已选择.");
    			break;   			
    		}
		}				
	}
	
	
	/*
	 * contains方法判断元素是否存在Set集合中
	 * 
	 * */
    public void contains(){
    	//获取第一个元素值
    	Course course = new Course(4,"数据结构");
    	if(courseSets.contains(course)){
    		System.out.println("课程："+course.getName()+"存在!");
    	}else{
    		System.out.println("课程："+course.getName()+"在集合没有找到.");
    	}
    }
    
    
    
	
	public static void main(String[] args) {
		CourseSet courseSet = new CourseSet();
		courseSet.add();
		courseSet.getForeach();
		courseSet.studentSelectedCourse();
		//courseSet.contains();
    }

}
