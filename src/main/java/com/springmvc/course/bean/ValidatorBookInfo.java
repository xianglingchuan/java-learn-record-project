package com.springmvc.course.bean;

public class ValidatorBookInfo {

	public ValidatorBook getValidatorBook() {
		return validatorBook;
	}

	public void setValidatorBook(ValidatorBook validatorBook) {
		this.validatorBook = validatorBook;
	}

	public ValidatorStudent getValidatorStudent() {
		return validatorStudent;
	}

	public void setValidatorStudent(ValidatorStudent validatorStudent) {
		this.validatorStudent = validatorStudent;
	}

	private ValidatorBook validatorBook;
	
	private ValidatorStudent validatorStudent;
	
	
}
