package com.learn.myString;

public class Student {

	private boolean isstudent;

	private Integer uid;

	private String uname;

	private String upwd;

	private Integer number;

	public boolean isIsstudent() {
		return isstudent;
	}

	public void setIsstudent(boolean isstudent) {
		this.isstudent = isstudent;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Student [isstudent=" + isstudent + ", uid=" + uid + ", uname=" + uname + ", upwd=" + upwd + ", number="
				+ number + "]";
	}

}
