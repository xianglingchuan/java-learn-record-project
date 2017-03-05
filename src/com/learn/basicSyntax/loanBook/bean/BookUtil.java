package com.learn.basicSyntax.loanBook.bean;

import java.util.ArrayList;

/*
 * 图书查询
 * 
 * */
public class BookUtil {

	private ArrayList<Book> books = null;
	
    public BookUtil(){
    	
    }
    
    public BookUtil(ArrayList<Book> newBooks){
    	 books = newBooks;    	
    }
    
    
    /*
     * 按序号查询
     * 
     * */
    public Book findBookByIndex(int index){
    	if(books.size()>=1){
    		for (Book book : books) {
				if(book.getIndex()==index){
					return book;
				}
			}
    	}
    	return null;
    }
    
    
    /*
     * 按书名称查询
     * 
     * */
    public Book findBookByTitle(String title){
    	if(books.size()>=1){
    		for (Book book : books) {
			    if(book.getTitle().equals(title)){
			    	return book;
			    }	
			}
    	}
    	return  null;
    }

    
	
}
