package com.learn.xml;

import java.io.IOException;
 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class DocumentTest {
	
	public static void main(String[] args) {
		//1、创建一个DocumentBuilderFactory的对象
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		try {
			//2、创建一个DocumentBuilder对象
			DocumentBuilder dBuilder = documentBuilderFactory.newDocumentBuilder();
			//3、通过DocumentBuilder对象的parse方法加载books.xml文件到当前项目下
			//注意导入Document对象时，要导入org.w3c.dom.Document包下的
			Document document = dBuilder.parse("demo/books.xml");
			//获取所有book节点的集合
			NodeList bookList = document.getElementsByTagName("book");
			//通过bookList.getLength()方法可以获取bookList的长度
			System.out.println("一共有"+bookList.getLength()+"本书");
			for(int i=0; i<bookList.getLength(); i++){
				System.out.println("====开始遍历第"+(i+1)+"本书的内容====");
				//通过item(i)方法 获取一个book节点，nodelist的索引值从0开始
				Node book = bookList.item(i);
				//获取book节点的所有属性集合
				NamedNodeMap attrs = book.getAttributes();
				System.out.println("========本图书一共有"+attrs.getLength()+"个属性========");
				for(int j=0; j<attrs.getLength(); j++){
					Node attr = attrs.item(j);
					String attrName = attr.getNodeName();
					String attrValue = attr.getNodeValue();
					System.out.println("================属性值为:"+attrName+"="+attrValue+"================");
				}
				//如果前提条件知道book节点有且只有一个id属性
				Element book1 = (Element)bookList.item(0);
				String bookId = book1.getAttribute("id");
				System.out.println("========本书ID号为:"+bookId);
				
				//解析book节点的子节点
				NodeList childNodes = book.getChildNodes();
				System.out.println("========本书有"+childNodes.getLength()+"个节点========");
				for(int k=0; k<childNodes.getLength(); k++){
					//区分出text类型的node以及element类型的node
					if(childNodes.item(k).getNodeType() == Node.ELEMENT_NODE){
					     //获取了element类型节点的节点名
						String nodeName = childNodes.item(k).getNodeName();
						String nodeValue = childNodes.item(k).getTextContent();
						System.out.println("================节点名称和值是:"+nodeName+"="+nodeValue+"================");
						NamedNodeMap childAttrs =  childNodes.item(k).getAttributes();
						for (int v = 0; v < childAttrs.getLength(); v++) {
							Node childAttr = childAttrs.item(v);
							String childAttrName = childAttr.getNodeName();
							String childAttrValue = childAttr.getNodeValue();
							System.out.println("====================节点的属性"+childAttrName+"="+childAttrValue+"====================");
						}
					}
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}