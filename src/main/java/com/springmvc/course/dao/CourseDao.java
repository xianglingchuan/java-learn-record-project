package com.springmvc.course.dao;


import java.util.List;
import org.springframework.stereotype.Repository;

import com.springmvc.course.bean.Course;


@Repository
public interface CourseDao {

	public List<Course> findList();
	
}
