package com.learn.basicSyntax.cardWash.bean;

import java.util.HashSet;
import java.util.Set;

/*
 * 玩家Bean对象
 * 
 * */
public class Person {
	private int id;      //玩家ID
	private String name; //玩家姓名
	

	private Set<Card> cards; //玩家的扑克牌信息
	
	public int getId() {
		return id;
	}
	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		cards = new HashSet<Card>();
	}
	
    public Person(){
    	super();
    	cards = new HashSet<Card>();
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
	public Set<Card> getCards() {
		return cards;
	}
	public void setCards(Set<Card> cards) {
		this.cards = cards;
	}
}
