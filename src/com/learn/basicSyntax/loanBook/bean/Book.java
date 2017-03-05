package com.learn.basicSyntax.loanBook.bean;

public class Book {

	private String title;
	private float price;
	private int index;
	
	public Book(){
		
	}
	
	public Book(int index, String title, float price) {
		super();
		this.title = title;
		this.price = price;
		this.index = index;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	

	
}
