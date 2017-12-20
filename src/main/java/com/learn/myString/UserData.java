package com.learn.myString;

import java.util.Arrays;

public class UserData {
	private Student student;
	private String name;
	private Boolean verified;
	private int[] marks;

	public UserData() {
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getVerified() {
		return verified;
	}

	public void setVerified(Boolean verified) {
		this.verified = verified;
	}

	public int[] getMarks() {
		return marks;
	}

	public void setMarks(int[] marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "UserData [student=" + student + ", name=" + name + ", verified=" + verified + ", marks="
				+ Arrays.toString(marks) + "]";
	}

}
