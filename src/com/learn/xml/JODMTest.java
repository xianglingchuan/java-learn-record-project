package com.learn.xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.Element;
import com.learn.xml.bean.Book;

public class JODMTest {

	private static ArrayList<Book> booksList = new ArrayList<Book>();

	public static void main(String[] args) {
		//1、创建一个SAXBuilder的对象
		SAXBuilder saxBuilder = new SAXBuilder();
		InputStream inputStream;
		
		//2 创建一个输入流，将xml文件加载到输入流中
		try {
			inputStream = new FileInputStream("demo/books.xml");
			//合用包装流InputStreamReader进行读取编码的指定，防止乱码
			InputStreamReader iStreamReader = new InputStreamReader(inputStream,"UTF-8");
			
			//3 通过saxBuilder的build方法，将输入流加载到saxBuilder中
			Document document = saxBuilder.build(iStreamReader);
			//4 通过document对象获取xml文件根节点
			org.jdom2.Element rootElement = document.getRootElement();
			//5 获取根节点下的子节点的List集合
			List<org.jdom2.Element> bookList = rootElement.getChildren();
			for(Element book:bookList){
				Book bookEntity = new Book();
				System.out.println("==开始解析第"+(bookList.indexOf(book)+1)+"==");
				//开始解决book的属性
				List<Attribute> attributeList = book.getAttributes();
				for(Attribute attr:attributeList){
					String attrName = attr.getName();
					String attrValue = attr.getValue();
					System.out.println("====属性名:"+attrName+",属性值:"+attrValue);
					if(attrName.equals("id")){
						bookEntity.setId(attrValue);
					}
				}
				
				
				//开始循环子节点内容
				List<Element> bookChildList = book.getChildren();
				for(Element child : bookChildList){
					String childName = child.getName();
					String childValue = child.getValue();
					System.out.println("========子节点名称:"+childName+",子节点值:"+childValue);
					if(childName.equals("name")){
						bookEntity.setName(childValue);
					}
					if(childName.equals("author")){
						bookEntity.setAuthor(childValue);
					}
					if(childName.equals("language")){
						bookEntity.setLanguage(childValue);
					}
					if(childName.equals("price")){
						bookEntity.setPrice(childValue);
					}
					if(childName.equals("year")){
						bookEntity.setYear(childValue);
					}
					
					List<Attribute> childAttributeList =  child.getAttributes();
					for(int j=0; j<childAttributeList.size(); j++){
						String childAttributeName = childAttributeList.get(j).getName();
						String childAttributeValue = childAttributeList.get(j).getValue();
						System.out.println("================子节点属性："+childAttributeName+",值："+childAttributeValue);
					}
				}
				booksList.add(bookEntity);
				bookEntity = null;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}













