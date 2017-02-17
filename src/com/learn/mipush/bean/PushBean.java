package com.learn.mipush.bean;

import org.json.simple.JSONObject;

public class PushBean {

	private String title;
	private String content;
	
	
	public PushBean(String title, String content, JSONObject jsonObjectPayload){
		this.title = title;
		this.content = content;	
		this.jsonObjectPayload = jsonObjectPayload;
	}
	
	public void buildMessage(String title, String content, JSONObject jsonObjectPayload){
		this.title = title;
		this.content = content;	
		this.jsonObjectPayload = jsonObjectPayload;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public JSONObject getJsonObjectPayload() {
		return jsonObjectPayload;
	}

	public void setJsonObjectPayload(JSONObject jsonObjectPayload) {
		this.jsonObjectPayload = jsonObjectPayload;
	}
	private JSONObject jsonObjectPayload;

}
