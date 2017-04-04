package com.learn.basicSyntax.cardWash;

import com.learn.basicSyntax.cardWash.util.DeckCardUtil;

public class Main {

    
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeckCardUtil deckCardUtil = new DeckCardUtil();
		deckCardUtil.createDeckCards();
		deckCardUtil.forEacherDeckCards();
		deckCardUtil.washCard();
		deckCardUtil.forEacherDeckCards();
		deckCardUtil.createPerson();
		deckCardUtil.sendCardPerson();
		deckCardUtil.showCardForPerson();

	}

}
