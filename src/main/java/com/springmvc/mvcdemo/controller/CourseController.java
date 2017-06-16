package com.springmvc.mvcdemo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.springmvc.mvcdemo.model.CourseDemo;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.catalina.connector.Request;
//import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.log4j.Logger;
import org.apache.commons.io.FileUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/course")
//对应的路径应该是/course/**
public class CourseController {
	
	//分析两个日志jar包的不同之处我相同之处
	//private static Logger logger =  LoggerFactory.getLogger(CourseController.class);
	
	private static Logger log = Logger.getLogger(CourseController.class);
	
	
	
	/*
	 * 本方法将处理/courses/view?courseId=321格式
	 */
	@RequestMapping(value="/view", method=RequestMethod.GET) //@RequestParam("courseId") Integer courseId, 
	//目前测试来看如果加上@RequestParam("courseId")设置传入参数时如果传入的值为空，那么将程序报错
	//错误信息如下：Required Integer parameter 'courseId' is not present
	//如果去掉，传入参数为空也可以
	public String viewCourse(@RequestParam("courseId") Integer courseId,  Model model){
		System.out.println("courseId:"+courseId);
		//logger.debug("logger In viewCourse, courseId = {}", courseId);
		log.debug("logger2 In viewCourse, courseId = "+courseId);
		CourseDemo course = new CourseDemo();
		if(courseId!=null && courseId>=1){
			//course = courseService.getCourseById(courseId);
		}
		model.addAttribute("course",course);
		return "springmvc/mvcdemo/view";
	}
	
	
	/*
	 * 本方法测试依次传入四个参数，第一个和第四个为必须传入，二、三参数为可选
	 * 
	 */
	@RequestMapping(value="/info", method=RequestMethod.GET) //@RequestParam("courseId") Integer courseId, 
	public String infoCourse(@RequestParam("courseId") Integer courseId, Integer offset, Integer limit, 
			@RequestParam("page") Integer page,  Model model){
		log.debug("In infoCourse, courseId = "+courseId);
		log.debug("In infoCourse, offset = "+offset);
		log.debug("In infoCourse, limit = "+limit);
		log.debug("In infoCourse, page = "+page);
		CourseDemo course = new CourseDemo();
		if(courseId!=null && courseId>=1){
			//course = courseService.getCourseById(courseId);
		}
		model.addAttribute("course",course);
		return "springmvc/mvcdemo/view";
	}
	
	
	/*
	 * 本方法将测试访问URL为: /courses/detail/123
	 * 这种路径传入的参数不能为空，如果为空将报错
	 */
	@RequestMapping("/detail/{courseId}")
	public String detailCourse(@PathVariable("courseId") Integer courseId, Map<String, Object> model){
		log.debug("In detailCourse, courseId = "+courseId);
		CourseDemo course = new CourseDemo();
		if(courseId!=null && courseId>=1){
			//course = courseService.getCourseById(courseId);
		}	
		model.put("course", course);
		return "springmvc/mvcdemo/view";
	}
	
	/*
	 * 本方法将测试访问URL为: /courses/detail/123/1/10/10
	 * 测试传入多个参数情况
	 */
	@RequestMapping("/details/{courseId}/{page}/{offset}/{limit}")
	public String detailsCourse(@PathVariable("courseId") Integer courseId, @PathVariable("page") Integer page, 
			@PathVariable("offset") Integer offset, @PathVariable("limit") Integer limit, Map<String, Object> model){
		log.debug("In detailsCourse, courseId = "+courseId);
		log.debug("In detailsCourse, offset = "+offset);
		log.debug("In detailsCourse, limit = "+limit);
		log.debug("In detailsCourse, page = "+page);
		CourseDemo course = new CourseDemo();
		if(courseId!=null && courseId>=1){
			//course = courseService.getCourseById(courseId);
		}	
		model.put("course", course);
		return "springmvc/mvcdemo/view";
	}
	
	/*
	 * 本方法将测试访问URL为: /courses/show?courseId=11
	 * 测试使用传统的方式HttpRequestServlet传入
	 */
	@RequestMapping("/show")
	public String showCourse(HttpServletRequest request){
		Integer courseId = 0;
		if(request.getParameter("courseId")!=null && !request.getParameter("courseId").equals("")){
			courseId = Integer.valueOf(request.getParameter("courseId"));
		}
		log.debug("In showCourse, courseId = "+courseId);
		return "springmvc/mvcdemo/view";
	}
	

	/*
	 * 添加方法测试 
	 */
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String formCourse(Model model){
		return "springmvc/mvcdemo/form";
	}
	
	/*
	 * 保存方法测试
	 * 这里使不使用@ModelAttribute方法都可以绑定相应的内容
	 */
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveCourse(@ModelAttribute CourseDemo course){
		log.debug("In saveCourse");
		course.setCourseId(321);
		//log.debug("course Info:"+ReflectionToStringBuilder.toString(course));
		//将请求重新定向某个方法上
		//return "redirect:view?courseId="+course.getCourseId();
		//将请求转发到frowardSave方法中,这里的请求转发并没有将course.setCournseId(321)给带到另外一个界面
		return "forward:forwardSave";
	}
	
	
	/*
	 * 测试请求转发内容
	 */
	@RequestMapping(value="/forwardSave", method=RequestMethod.POST)
	public String forwardSaveCourse(@ModelAttribute CourseDemo course){
		log.debug("In forwardSaveCourse");
		course.setCourseId(456);
		//log.debug("course Info:"+ReflectionToStringBuilder.toString(course));		
		return "redirect:view?courseId="+course.getCourseId();
	}
	
	
	
	/*
	 * 文件上传请求
	 */
	@RequestMapping("/uploadFile")
	public String uploadFile(){
		return "springmvc/mvcdemo/uploadFile";
	}
	
	
	/*
	 * 保存上传文件
	 * 也可以不用RequestParam绑定参数
	 */
	@RequestMapping(value="/doUploadFile", method=RequestMethod.POST)
	public String doUploadFile(@RequestParam("file") MultipartFile file) throws IOException{
		log.debug("In doUploadFile");
		if(!file.isEmpty()){
			log.debug("copyInputStreamToFile");
			String path = "/Users/xianglingchuan/Documents/work/learnWorkspace/learn/src/main/webapp/resources/files/";
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path+System.currentTimeMillis()+file.getOriginalFilename()));			
		}
		return "springmvc/mvcdemo/message";
	}
	
	
}






















