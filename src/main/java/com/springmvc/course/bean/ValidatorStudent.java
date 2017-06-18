package com.springmvc.course.bean;

import org.hibernate.validator.constraints.NotEmpty;

public class ValidatorStudent {

	@NotEmpty(message="老师名称不能为空")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
