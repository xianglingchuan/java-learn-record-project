package com.springmvc.mvcdemo.service;


import org.springframework.stereotype.Service;

import com.springmvc.mvcdemo.model.Course;


@Service
public interface CourseService {

	 public Course getCourseById(Integer courseId);

}
