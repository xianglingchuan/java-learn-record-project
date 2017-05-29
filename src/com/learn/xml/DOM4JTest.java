package com.learn.xml;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.dom4j.Element;

public class DOM4JTest {
	
    public static void main(String[] args) {
    	//解析Books.xml文件
    	//创建SAXReader的对象reader
    	SAXReader reader = new SAXReader();
    	
    	
    	//通过reader对象的read方法加载books.xml文件，获取document对象
    	try {
			Document document = reader.read(new File("demo/books.xml"));
			//通过document对象获取根节点bookstore
			org.dom4j.Element bookStore =document.getRootElement();
			//通过element对象的elementIteraor方法获取迭代器
			Iterator iterator = bookStore.elementIterator();
			while(iterator.hasNext()){
				System.out.println("====开始遍历某一本书====");
				Element book = (Element)iterator.next();
				//获取book的属性名及属性值
				List<Attribute> bookAttrs = book.attributes();
				for(Attribute attribute : bookAttrs){
					String attrName = attribute.getName();
					String attrValue = attribute.getValue();
					System.out.println("属性名:"+attrName+",属性值:"+attrValue);
				}
				//解析子节点的信息
				Iterator iterator2 = book.elementIterator();
				while (iterator2.hasNext()) {
					Element bookChild = (Element)iterator2.next();
					String childName = bookChild.getName();
					String childValue = bookChild.getText();
					System.out.println("子节点名称:"+childName+",子节点属性:"+childValue);
				}
				System.out.println("====结束遍历某一本书====");				
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}





