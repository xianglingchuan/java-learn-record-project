package com.springmvc.course.bean;

import org.hibernate.validator.constraints.NotEmpty;

public class ValidatorBook {

	@NotEmpty(message="图书标题不能为空")
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
	
	
	
	
}
