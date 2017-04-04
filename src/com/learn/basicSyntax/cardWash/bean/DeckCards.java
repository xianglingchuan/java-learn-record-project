package com.learn.basicSyntax.cardWash.bean;

import java.util.ArrayList;
import java.util.List;

/*
 * 一副牌的Bean对象
 * 
 * */
public class DeckCards {
	
	private List<Card> cards;
	
	public DeckCards(List<Card> cards) {
		super();
		this.cards = cards;
	}
	
	public DeckCards(){
		super();
		cards = new ArrayList<Card>();
	}
	

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	
}
