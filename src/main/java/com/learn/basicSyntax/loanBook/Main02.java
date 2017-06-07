package com.learn.basicSyntax.loanBook;

import java.util.ArrayList;
import java.util.Scanner;

import com.learn.basicSyntax.loanBook.bean.Book;
import com.learn.basicSyntax.loanBook.bean.BookUtil;

public class Main02 {

	//定入一个Sacnner类
	private static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
	
		Main02 main02 = new Main02();
		main02.test();
	}
	
	
	
	public void test(){		
		
		ArrayList<Book> list = new ArrayList<Book>();
		Book book1 = new Book(11, "Java编程思想", 58.9f);
		Book book2 = new Book(22, "php编程思想", 48.9f);
		Book book3 = new Book(33, "大数据分析", 99.9f);
		list.add(book1);
		list.add(book2);
		list.add(book3);
		//开始一个while循环
		while(true){
			System.out.println("输入命令：1-按照名称查找图书；2-按照序号查找图书"); 
			int command = inputCommand();
			try{
				Book findBook = new Book();
				switch (command) {
					case 1:			
						System.out.println("查询到的图书名称为："+findBookByName(list));
						break;
					case 2:
						System.out.println("查询到的图书名称为："+findBookByIndex(list));
						break;
					case -1:
						System.out.println("命令输入错误！请根据提示输入数字命令！");
						continue;
					default:
						System.out.println("命令输入错误！");
						continue;
				}
				break;//输出程序		
			}catch(Exception e){
				System.out.println("exception.getMessage()="+e.getMessage());
				continue;
			}
			
		}
	}
	
	
	//从控制台输入命令，用于输入命令和输入图书序号
	private int inputCommand(){
		int command;
		try{
			command = console.nextInt();
			return command;			
		}catch(Exception e){
			console = new Scanner(System.in);
			return -1;
		}
	}
	
	
	
	private String findBookByName(ArrayList<Book> list) throws Exception{
		System.out.println("请输入图书名称:");
		BookUtil bookUtil = new BookUtil(list);
		String keyword  = console.next();
		Book book = bookUtil.findBookByTitle(keyword);	
		if(book!=null){
			return book.getTitle();
		}
		throw new Exception("图书不存在!");
	}
	
	
	private String findBookByIndex(ArrayList<Book> list) throws Exception{
		System.out.println("请输入图书序号:");
		BookUtil bookUtil = new BookUtil(list);
		int index = inputCommand();
		Book book = bookUtil.findBookByIndex(index);	
		if(book!=null){
			return book.getTitle();
		}
		throw new Exception("图书不存在!");
	}
	
	
	
	
}
