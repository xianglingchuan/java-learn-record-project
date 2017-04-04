package com.learn.basicSyntax.collectionMap.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.learn.basicSyntax.collectionMap.bean.Course;

/*
 * 默认课程选择类
 * 
 * */
public class CourseList {

	
	private List coursetList;
	
	private Scanner scanner;
	
	public CourseList(){
		coursetList = new ArrayList();
		scanner = new Scanner(System.in);
	}
	
	/*
	 * 添加课程
	 * */
	public void add(){
		//插入课程到list中
		Course course = new Course(1,"大数据");
		coursetList.add(course);
		//读取刚刚插入的课程
		Course temp =(Course) coursetList.get(0);
		System.out.println("取出的课程为:"+temp.getId()+":"+temp.getName());
		
		//插入课程到List开头
		Course course2 = new Course(2,"Java编程思想");
		coursetList.add(0, course2);
		Course temp2 =(Course) coursetList.get(0);
		System.out.println("取出的课程为:"+temp2.getId()+":"+temp2.getName());
		
		//插入下标大于List长度的对象
		Course course3 = new Course(1,"Payth");
		//coursetList.add(4, course2); //这里只能插入List长度的范围之内的下标，不然会造成数组下标越界
		coursetList.add(1, course3);
		
		for (Object object : coursetList) {
			Course tempCourse = (Course)object;
			System.out.println("取出的课程为:"+tempCourse.getId()+":"+tempCourse.getName());
		}
		
		Course[] courses = {new Course(3,"javascription"), new Course(4,"数据结构")};
        coursetList.addAll(Arrays.asList(courses));
        Course temp3 = (Course)coursetList.get(3);
        Course temp4 = (Course)coursetList.get(4);
        System.out.println("添加的两门课程为："+temp3.getId()+":"+temp3.getName()+", "+temp4.getId()+":"+temp4.getName());
		
        
		Course[] courses2 = {new Course(5,"Object-c"), new Course(6,"Linux运维")};
        coursetList.addAll(3, Arrays.asList(courses2));
        Course temp5 = (Course)coursetList.get(3);
        Course temp6 = (Course)coursetList.get(4);
        System.out.println("添加的两门课程为："+temp5.getId()+":"+temp5.getName()+", "+temp6.getId()+":"+temp6.getName());
    }
	
    /*
     * 读取课程for
     * 
     * */
	public void getFor(){
		System.out.println("默认课程列表如下：");
		for(int i=0; i<coursetList.size(); i++){
			Course course =(Course)coursetList.get(i);
			System.out.println("课程id:"+course.getId()+" 名称:"+course.getName());
		}
	}
	
	/*
	 * 读取课程foreach
	 * 
	 * */
	public void getForeach(){
		System.out.println("默认课程列表如下：");
		for (Object object : coursetList) {
			Course course = (Course)object;
			System.out.println("课程id:"+course.getId()+" 名称:"+course.getName());
		}
	}
	
	/*
	 * 读取课程iterator
	 * 
	 * */
	public void getIterator(){
		Iterator<Course> iterator = coursetList.iterator();
		System.out.println("默认课程列表如下：");
		while(iterator.hasNext()){
			Course course = iterator.next();
			System.out.println("课程id:"+course.getId()+" 名称:"+course.getName());
		}
	}
	
	/*
	 * 修改指定元素方法
	 * @param int Index
	 */
	public void modify(int index){
		//指有合法的下标才能被修改
		if(index >=0 && index<coursetList.size()){
			coursetList.set(index, new Course(10,"C语言"));					
		}else{
			System.out.println("你要modify的下标:"+index+"不存在。");
		}
	}
	
	
	/*
	 * 删除元素-按指定下标
	 * 
	 * */
	public void remove(int index){
		if(index >=0 && index<coursetList.size()){
			Course course = (Course)coursetList.get(index);
			System.out.println(course.getId()+":"+course.getName()+",即将被删除！");
			coursetList.remove(index);
		}else{
			System.out.println("你要remove的下标:"+index+"不存在。");
		}		
	}
	
	/*
	 * 删除元素-按对象
	 * */
	public void remove2(){
		//Course course = new Course(1,"payth"); //错误,必须要是从List中取出的对象
	    Course course = (Course)coursetList.get(1);		
		System.out.println(course.getId()+":"+course.getName()+",即将被删除！");
		coursetList.remove(course);		
	}
	
	/*
	 * 删除元素-按集合
	 * */
    public void removeAll(){
    	//Course[] courses = {new Course(10,"C语言"),new Course(3,"javascription")};
    	Course[] courses = {(Course)coursetList.get(2), (Course)coursetList.get(5)};
    	coursetList.removeAll(Arrays.asList(courses));
    	//coursetList.get(0);
    }
    
    /*
     * contains判断课程是否存在列表中
     * 
     * */
    public void contains(){
    	//先取出第一个元素进行判断
    	Course course =(Course) coursetList.get(0);
    	//判断该元素是否存在List中
    	//System.out.println("课程："+course.getName()+",是否存在列表中:"+coursetList.contains(course));
    	
    	//修改一下用户的名称在看一下是否存在
    	//修改课程及名称以后还是已经存在的，证明这里是只判断内存地址是否一样
    	//course.setName("Mysql精通");
    	//course.setId(100);
    	//System.out.println("课程："+course.getName()+",是否存在列表中:"+coursetList.contains(course));
    	
    	//重新创建对象以后就不存在了
    	//Course course2 = new Course(course.getId(),course.getName());
    	//System.out.println("课程："+course2.getName()+",是否存在列表中:"+coursetList.contains(course2));
    	
    	//如果这里想让只用name进行判断需要重新Course中的equeas方法,
    	//contains的原理也是调用方法中的equeas方法，每个属性进行判断
    	
    	while (true) {
    		System.out.print("请输入要查询的课程ID:");
    		String courseId = scanner.next();
    		System.out.print("请输入要查询的课程名称:");
    		String courseName = scanner.next();
    		Course courseNew = new Course(Integer.valueOf(courseId), courseName);
    		if(!coursetList.contains(courseNew)){
    			System.out.println("对不起，课程"+courseNew.getId()+","+courseNew.getName()+"没有找到,请重新输入课程信息查找！");
    			continue;
    		}else{
    			System.out.println("课程"+courseNew.getId()+","+courseNew.getName()+"已经找到！!");
    			
    			int Index = coursetList.indexOf(courseNew);
    			System.out.println("课程所在的索引值为："+Index);
    			
    			break;   			
    		}
		}
    }
	
    
	/*
	 * 判断一个集合是否在List中存在
	 * 
	 * */
    public void containsAll(){
		Course[] courses = {new Course(3,"javascription"), new Course(4,"数据结构")};
		if(coursetList.containsAll(Arrays.asList(courses))){
			System.out.println("找到相关的信息"+courses.toString());
		}else{
			System.out.println("没有找到相关的集合!");
		}
    }
    
	public static void main(String[] args){
		CourseList courseList = new CourseList();
		courseList.add();
		courseList.getIterator();
		//courseList.getFor();
		//courseList.getForeach();	
		//courseList.modify(1);
		//courseList.getForeach();
		//courseList.modify(-1);
	    //courseList.remove(2);
		//courseList.getForeach();
		//courseList.remove2();
		//courseList.getForeach();
		//courseList.getForeach();
		//courseList.removeAll();
		//courseList.getForeach();
		
		courseList.contains();		
		//courseList.containsAll();
		
	}
	
}







