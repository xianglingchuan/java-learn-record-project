package com.learn.xml;

import java.util.ArrayList;

import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.learn.xml.bean.Book;

public class SAXParserHandler extends DefaultHandler {

	// 设置全局变量，用来记录是第几本书
	int bookIndex = 0;

	String value = null;
	Book book = null;
	private ArrayList<Book> bookList = new ArrayList<Book>();

	public ArrayList<Book> getBookList() {
		return bookList;
	}

	public void setBookList(ArrayList<Book> bookList) {
		this.bookList = bookList;
	}

	// 用来标识解析开始
	public void startDocument() throws SAXException {
		super.startDocument();
		System.out.println("SAX解析开始");
	}

	// 用来标识解析结束
	public void endDocument() throws SAXException {
		super.endDocument();
		System.out.println("SAX解析结束");
	}

	// 用来遍历xml文件的开始标签
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// 调用DefaultHandler类的startElement方法
		super.startElement(uri, localName, qName, attributes);
		if (qName.equals("book")) {
			// 创建一个book对象
			book = new Book();
			// 开始解析book元素属性
			int num = attributes.getLength();
			for (int i = 0; i < num; i++) {
				String name = attributes.getQName(i);
				String value = attributes.getValue(i);
				System.out.println("book元素的属性是" + name + "==" + value);
				if (name.equals("id")) {
					book.setId(value);
				}
			}
		} else if (!qName.equals("book") && !qName.equals("bookstore")) {
			System.out.println("节点名是:" + qName);
		}
	}

	// 用户遍历xml文件的结束标签
	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);
		// 判断是否针对一本书已经遍历结束
		if (qName.equals("book")) {
			bookList.add(book); // 在清空book对象之前先保存
			book = null; // 把book清空，方便解析下一个book节点
			System.out.println("========结束遍历第" + bookIndex + "本书的内容========");
		} else if (qName.equals("name")) {
			book.setName(value);
		} else if (qName.equals("author")) {
			book.setAuthor(value);
		} else if (qName.equals("year")) {
			book.setYear(value);
		} else if (qName.equals("price")) {
			book.setPrice(value);
		} else if (qName.equals("language")) {
			book.setLanguage(value);
		}
	}

	/*
	 * 获取文本 重写charaters()方法时 String(byte[] bytes, int offset, int length)
	 * 去除解析时多余空格
	 */
	public void characters(char[] ch, int start, int length) throws SAXException {

		/**
		 * ch 代表节点中的所有内容，即每次遇到一个标签调用characters方法时，数组ch实际都是整个XML文档的内容
		 * 如何每次去调用characters方法时我们都可以获取不同的节点属性？这时就必须结合start（开始节点）和length（长度）
		 */
		super.characters(ch, start, length);
		
		//value获取的是文本(开始和结束标签之间的文本)
		value = new String(ch, start, length);
		System.out.println(value); //输出时会多出两个空格，是因xml文件中空格与换行字符被看成为一个文本节点
		if(!value.trim().equals("")){   
			System.out.println("节点值是:"+value);
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
