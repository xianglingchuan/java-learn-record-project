package com.learn.basicSyntax.cardWash.bean;

/*
 * 一张牌的对象
 * 
 * */
public class Card {

	private String number;  //扑克牌号
	private String flowerColor; //扑克的花色
	
	
	public Card(String number, String flowerColor) {
		super();
		this.number = number;
		this.flowerColor = flowerColor;
	}
	
	public Card(){
		super();
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getFlowerColor() {
		return flowerColor;
	}
	public void setFlowerColor(String flowerColor) {
		this.flowerColor = flowerColor;
	}


}
