package com.learn.myJsp.viewlist.entity;

/*
 * 产品实体类
 * 
 * */
public class Items {

	private int id; // 产品自增长ID号
	private String name; // 产品名称
	private String city; // 产品产生
	private int price; // 产品的价格
	private int number;// 产品的数量
	private String picture; // 产品的图片

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

}
