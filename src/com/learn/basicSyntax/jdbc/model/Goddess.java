package com.learn.basicSyntax.jdbc.model;

import java.sql.Date;

import javax.xml.crypto.Data;

public class Goddess {

	 private Integer id;
	 private String userName;
	 private Integer sex;
	 private Integer age;
	 private Date birthday;
	 private String email;
	 private String mobile;
	 private String createUser;
	 private Date createDate;
	 private String updateUser;
	 private Date  updateDate;
	 private Integer isdel;	
	
	 public Goddess() {
		super();
	}
	 

	public Goddess(Integer id, String userName, Integer sex, Integer age, Date birthday, String email, String mobile,
			String createUser, Date createDate, String updateUser, Date updateDate, Integer isdel) {
		super();
		this.id = id;
		this.userName = userName;
		this.sex = sex;
		this.age = age;
		this.birthday = birthday;
		this.email = email;
		this.mobile = mobile;
		this.createUser = createUser;
		this.createDate = createDate;
		this.updateUser = updateUser;
		this.updateDate = updateDate;
		this.isdel = isdel;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Integer getIsdel() {
		return isdel;
	}
	public void setIsdel(Integer isdel) {
		this.isdel = isdel;
	}
	
	 public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}	

	
	@Override
	public String toString() {
		return "Goddess [id=" + id + ", userName=" + userName + ", sex=" + sex + ", age=" + age + ", email=" + email
				+ ", mobile=" + mobile + ", createUser=" + createUser + ", createDate=" + createDate + ", updateUser="
				+ updateUser + ", updateDate=" + updateDate + ", isdel=" + isdel + "]";
	}
	
	
}
