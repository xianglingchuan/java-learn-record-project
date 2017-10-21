package com.springmvc.mvcdemo.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloMvcController {
     
	
	@Resource(name="currentDate")
	private Date currentDate;
	
	public Date getCurrentDate() {
		return currentDate;
	}



	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}



	@RequestMapping("mvc")
	public String helloMvc(){
		System.out.println("currentDate"+this.getCurrentDate());
		return "springmvc/mvcdemo/home";
	}
}
