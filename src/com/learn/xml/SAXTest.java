package com.learn.xml;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.eclipse.jdt.internal.compiler.apt.model.Factory;
import org.xml.sax.SAXException;
import com.learn.xml.bean.Book;

public class SAXTest {
	
    public static void main(String[] args) throws IOException {
		//1、获取一个SAXParserFactory的实例对象
    	SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
    	//2、通过factory的newSAXParser()方法获取一个AXParser类的对象
    	try {
			SAXParser parser = saxParserFactory.newSAXParser();
			SAXParserHandler handler = new SAXParserHandler();
			parser.parse("demo/books.xml", handler);
			System.out.println("共有"+handler.getBookList().size()+"本书");
			
			for(Book book : handler.getBookList()){
				System.out.println("ID:"+book.getId());
				System.out.println("Name:"+book.getName());
				System.out.println("Author:"+book.getAuthor());
				System.out.println("Language:"+book.getLanguage());
				System.out.println("Price:"+book.getPrice());
				System.out.println("Year"+book.getYear());
			}			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}

}
