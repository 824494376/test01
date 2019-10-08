package com.xm.xml.jdom;
 
import java.io.File;
import java.io.IOException;
import java.util.List;
 
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
 
/**
 * java jdom解析xml
 * @author ouyangjun
 */
public class ParseJDOM {
 
	public static void main(String[] args) {
		
		// 调用jdom解析xml方法
		parseJDOM(new File("E:\\jdom.xml"));
	}
	
	public static void parseJDOM(File file){
		try {
			// 创建sax解析器
			SAXBuilder saxBuilder = new SAXBuilder();
 
			// 获取Document
			Document document = saxBuilder.build(file);
			System.out.println("Root element :" + document.getRootElement().getName());
 
			Element classElement = document.getRootElement();
			// 递归读取xml节点信息
			parseElement(classElement);
			
		}catch(JDOMException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void parseElement(Element classElement){
		List<Element> elementList = classElement.getChildren();
		
		Element element;
		for (int temp = 0; temp < elementList.size(); temp++) {    
			element = elementList.get(temp);
			
			System.out.println("Current Element Name :" + element.getName());
			if (element.hasAttributes()) {
				Attribute attribute =  element.getAttribute("attr");
	            System.out.println("Current Element Attr Value : " + attribute.getValue());
			}
			System.out.println("Current Element Text : " + element.getText());
            
            if( element.getChildren() != null){
            	parseElement(element);
            }
            
         }
	}
 
}