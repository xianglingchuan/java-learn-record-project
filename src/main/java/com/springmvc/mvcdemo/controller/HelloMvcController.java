package com.springmvc.mvcdemo.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")
public class HelloMvcController {

	@Resource(name = "currentDate")
	private Date currentDate;

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	@RequestMapping("mvc")
	public String helloMvc() {
		System.out.println("currentDate" + this.getCurrentDate());
		return "springmvc/mvcdemo/home";
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(Model model) {
		String str = "asbd123";
		// 这里会报NumberFormatException异常,然后spring会自动捕捉这个异常
		int a = Integer.parseInt(str);
		return "hello";
		
		
	}

}
