package com.exeception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyExceptionResolver implements HandlerExceptionResolver {

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		System.out.println("==============异常开始=============");
		ex.printStackTrace();
		System.out.println("==============异常结束=============");
		// 设置返回页面为error.jsp
		ModelAndView mv = new ModelAndView("message/frontend/error/error");
		mv.addObject("exception", ex.toString().replaceAll("\n", "<br/>"));
		return mv;
	}
}
