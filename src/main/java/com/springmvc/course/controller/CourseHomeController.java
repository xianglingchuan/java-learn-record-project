package com.springmvc.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.course.bean.Course;
import com.springmvc.course.bean.SysConf;
import com.springmvc.course.service.CourseService;

@Controller
@RequestMapping("/coursehome")
public class CourseHomeController {
	
	@Autowired
    private CourseService courseService;
	
    @RequestMapping(value="/index",method=RequestMethod.GET)
    public String home(Model model){
    	Course entity = new Course();
    	List<Course> books = courseService.findList(entity);
    	System.out.println(books.toString());    	
    	for(int i=0; i<books.size(); i++){
    		System.out.println("name:"+books.get(i).getTitle());
    	}
        return "springmvc/course/index";
    }
    
    
    @RequestMapping(value="/view",method=RequestMethod.GET)
    public String view(Model model){
    	
    	SysConf sysconf = new SysConf();
    	System.out.println("development:"+sysconf.getTest());
    	
    	
    	return "springmvc/course/index";
    }
    
	
}
