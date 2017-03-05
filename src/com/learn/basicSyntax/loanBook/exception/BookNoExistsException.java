package com.learn.basicSyntax.loanBook.exception;

public class BookNoExistsException extends Exception {

	
	public BookNoExistsException(){
		super();
	}
	
	public BookNoExistsException(String message){
		super(message);
	}
	
}
