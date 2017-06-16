package com.springmvc.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.course.bean.Course;
import com.springmvc.course.dao.ChapterDao;
import com.springmvc.course.dao.CourseDao;



@Service
public class ChapterService {

	@Autowired
	protected ChapterDao chapterDao;

	
	/**
	 * 查询列表数据
	 * 
	 * @param entity
	 * @return
	 */
//	public List<Course> findList(Course entity) {
//		return courseDao.findList();
//	}	
	
}
