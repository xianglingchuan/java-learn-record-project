package com.learn.basicSyntax.loanBook;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.learn.basicSyntax.loanBook.bean.Book;
import com.learn.basicSyntax.loanBook.bean.BookUtil;
import com.learn.basicSyntax.loanBook.exception.ErrorCommandException;

public class Main {

	private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	
	
	private static Scanner input = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main main = new Main();
		try {
			main.test();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void test() throws IOException {
		ArrayList<Book> list = new ArrayList<Book>();
		Book book1 = new Book(11, "Java编程思想", 58.9f);
		Book book2 = new Book(22, "php编程思想", 48.9f);
		Book book3 = new Book(33, "大数据分析", 99.9f);
		list.add(book1);
		list.add(book2);
		list.add(book3);

		System.out.println("输入命令:1-按照名称查找图书;2-按照序号查找图书");
		boolean isCommandStatus = false;
		int command = 0;
		while (!isCommandStatus) {
			try {
				command = new Integer(bufferedReader.readLine());
				if (command == 1 || command == 2) {
					System.out.println("command:" + command);
					isCommandStatus = true;
				} else {
					ErrorCommandException errorCommandException = new ErrorCommandException("命令错误，请根据提示输入命令信息!");
					System.out.println(errorCommandException.getMessage());
				}
			} catch (NumberFormatException e) {
				ErrorCommandException errorCommandException = new ErrorCommandException("命令错误，请根据提示输入命令信息!");
				System.out.println(errorCommandException.getMessage());
			} catch (IOException e) {
				ErrorCommandException errorCommandException = new ErrorCommandException("命令错误，请根据提示输入命令信息!");
				System.out.println(errorCommandException.getMessage());
			}
		}
		
		
		try{
			Book findBook = findBook(list, command);	
			System.out.println(findBook.getTitle());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
//		System.out.println("命令收集完成，开始下一步操作");
//		int bookIndex = -1;
//		String bookTitle = "";
		
//		boolean isFindBookStatus = false;
//		while(!isFindBookStatus){
//			//开始查询图书
//			BookUtil bookUtil = new BookUtil(list);
//			Book book = null;
//			if(command==1){
//				System.out.println("请输入图书名称:");
//				bookTitle = bufferedReader.readLine();
//				book = bookUtil.findBookByTitle(bookTitle);					
//			}else if(command==2){
//				System.out.println("请输入图书序号:");
//				bookIndex = new Integer(bufferedReader.readLine());
//				book = bookUtil.findBookByIndex(bookIndex);
//			}
//			try{
//				System.out.println("查询到图书："+book.getTitle());
//				isFindBookStatus = true;
//			}catch(Exception e){				
//				ErrorCommandException errorCommandException = new ErrorCommandException("图书不存在!");
//				System.out.println(errorCommandException.getMessage());				
//			}			
//		}	
	}
	
	
	private Book findBook(ArrayList<Book> list, int command) throws Exception{
		BookUtil bookUtil = new BookUtil(list);
		Book book = null;
		if(command==1){
			System.out.println("请输入图书名称:");
			book = bookUtil.findBookByTitle(input.next());					
		}else if(command==2){
			System.out.println("请输入图书序号:");
			book = bookUtil.findBookByIndex(new Integer(input.nextInt()));
		}
		if(book!=null){
			return book;
		}
		throw new Exception("查询图书不存在."); 
	}
	
	
	
	
	

	
}
