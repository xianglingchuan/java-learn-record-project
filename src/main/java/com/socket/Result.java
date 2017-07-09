package com.socket;

import java.io.Serializable;

public class Result implements Serializable {
	
	private int code;
	
	private String message;
	
	
	public Result(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	

}
