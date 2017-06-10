package com.springmvc.mvcdemo.service.impl;

import org.springframework.stereotype.Service;

import com.springmvc.mvcdemo.model.Course;
import com.springmvc.mvcdemo.service.CourseService;


@Service("courseService")
public class CourseServiceImpl implements CourseService {

	@Override
	public Course getCourseById(Integer courseId) {
		
		Course course = new Course();
		return course;
	}

}
