package com.springmvc.mvcdemo.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.mvcdemo.service.CourseService;

@Controller
@RequestMapping("/admincourse")
public class AdminController {

	
	private static Logger log = Logger.getLogger(CourseController.class);
	
	private CourseService courseService;
	
	//自动装载该Server对接
	@Autowired
	public void setCourseService(CourseService courseService){
		this.courseService = courseService;
	}	
	
	/*
	 * 添加编辑课程表单方法
	 * 
	 */
	public String formCourse(){
		
		return "springmvc/mvcdemo/form";
	}
	
	public String saveCourse(){
		return "springmvc/mvcdemo/form";
	}
	
	
}
