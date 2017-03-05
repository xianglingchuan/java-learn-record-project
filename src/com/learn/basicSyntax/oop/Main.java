package com.learn.basicSyntax.oop;

import com.learn.basicSyntax.oop.baen.AmericanProson;
import com.learn.basicSyntax.oop.baen.ChainProson;
import com.learn.basicSyntax.oop.baen.Person;

public class Main {

	public static void main(String[] args) {
		
		Person chainPerson = new ChainProson("Bloack", "yellow");
		Person maericanPerson = new AmericanProson("Yellow", "white");
		chainPerson.say();
		maericanPerson.say();
	}

}
