package com.springmvc.course.bean;


/*
 * 课程章节模型 
 */
public class Chapter {

	/*
	 * 自增长ID 
	 */
	private Integer id;
	
	/*
	 * 课程ID号
	 */
	private Integer courseId;
	
	/*
	 * 章节排序
	 */
	private Integer order;
	
	
	/*
	 * 章节标题
	 */	
	private String title;
	
	
	/*
	 * 章节描述
	 */		
	private String descr;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

}
