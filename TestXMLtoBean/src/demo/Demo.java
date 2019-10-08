package demo;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Demo {

	public static void main(String[] args) throws DocumentException {
		  Demo d=new Demo();
		  SAXReader reader = new SAXReader();
		  Document document = reader.read(new File("F:/test.xml"));
		  Element rootElm = document.getRootElement();
		  d.getNodes(rootElm);
//		  List<Element> le=rootElm.elements();
//		  for(Element e:le) {
//			  d.getNodes(e);
//		  }
	}
	
	
	    /**
	 * 从指定节点开始,递归遍历所有子节点
	 * @author chenleixing
	 */
	public void getNodes(Element node){
	    System.out.println("--------------------");
	    
	    //当前节点的名称、文本内容和属性
	    System.out.println("当前节点名称："+node.getName());//当前节点名称
	    if(node.getName().equals("tt")) {
	    	System.out.println("===="+node.getPath());
	    }
	    
	    System.out.println("当前节点的内容："+node.getTextTrim());//当前节点名称
	    List<Attribute> listAttr=node.attributes();//当前节点的所有属性的list
	    for(Attribute attr:listAttr){//遍历当前节点的所有属性
	        String name=attr.getName();//属性名称
	        String value=attr.getValue();//属性的值
	        System.out.println("属性名称："+name+"属性值："+value);
	    }
	    
	    //递归遍历当前节点所有的子节点
	    List<Element> listElement=node.elements();//所有一级子节点的list
	    for(Element e:listElement){//遍历所有一级子节点
	        this.getNodes(e);//递归
	    }
	}
}
