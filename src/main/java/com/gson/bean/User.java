package com.gson.bean;

import com.google.gson.annotations.SerializedName;

public class User {

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getAge() {
		return age;
	}

	public void setAge(float age) {
		this.age = age;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public boolean isCar() {
		return car;
	}

	public void setCar(boolean car) {
		this.car = car;
	}

	public boolean isHouse() {
		return house;
	}

	public void setHouse(boolean house) {
		this.house = house;
	}

	public String[] getMajor() {
		return major;
	}

	public void setMajor(String[] major) {
		this.major = major;
	}

	public String[] getOffice_city() {
		return office_city;
	}

	public void setOffice_city(String[] office_city) {
		this.office_city = office_city;
	}

	public UserExpand getExpand() {
		return expand;
	}

	public void setExpand(UserExpand expand) {
		this.expand = expand;
	}

	
	private String name;
	
	private float age;
	
	private String birthday;
	
	private boolean car;
	
	private boolean house;
	
	private String[] major;
	
	@SerializedName("officeCity")
	private String[] office_city;
	
	private UserExpand expand;
	
	
	public String getIgnore() {
		return ignore;
	}

	public void setIgnore(String ignore) {
		this.ignore = ignore;
	}


	private transient String ignore;
}
