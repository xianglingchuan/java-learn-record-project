package com.springmvc.course.bean;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class Student {
	
	
	/**
	 * 用户姓名
	 */
	//@Size(min=3, max=30,message="用户姓名长度必须大小3,小于30位")
	@NotNull(message = "firstName 不能为空")
	private String firstName;
	
	/**
	 * 用户姓
	 */
	@Size(min=3,max=30)
	private String lastName;
	
	/**
	 * 用户性别
	 */
	@NotEmpty
	private String sex;
	
	/**
	 * 用户性别
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Past @NotNull
	private Date brithday;
	
	/**
	 * 用户邮箱
	 */
	@Email @NotEmpty
	private String email;
	
	
	/**
	 * 部门
	 */
	@NotEmpty
	private String section;
	
	/**
	 * 国籍
	 */	
	@NotEmpty
	private String country;
	
	/**
	 * 是否优秀
	 */	
	@NotEmpty
	private boolean isGood;
	
	
	/**
	 * 学课
	 */	
	@NotEmpty
	private List<String> subjects = new ArrayList<String>();
		
	
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public Date getBrithday() {
		return brithday;
	}


	public void setBrithday(Date brithday) {
		this.brithday = brithday;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSection() {
		return section;
	}


	public void setSection(String section) {
		this.section = section;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public boolean isGood() {
		return isGood;
	}


	public void setGood(boolean isGood) {
		this.isGood = isGood;
	}


	public List<String> getSubjects() {
		return subjects;
	}


	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}


	public Student() {
		super();
	}


	@Override
	public String toString() {
		return "StudentDao [firstName=" + firstName + ", lastName=" + lastName + ", sex=" + sex + ", brithday="
				+ brithday + ", email=" + email + ", section=" + section + ", country=" + country + ", isGood=" + isGood
				+ ", subjects=" + subjects + "]";
	}
}









