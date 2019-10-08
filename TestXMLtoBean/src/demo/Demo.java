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
	 * ��ָ���ڵ㿪ʼ,�ݹ���������ӽڵ�
	 * @author chenleixing
	 */
	public void getNodes(Element node){
	    System.out.println("--------------------");
	    
	    //��ǰ�ڵ�����ơ��ı����ݺ�����
	    System.out.println("��ǰ�ڵ����ƣ�"+node.getName());//��ǰ�ڵ�����
	    if(node.getName().equals("tt")) {
	    	System.out.println("===="+node.getPath());
	    }
	    
	    System.out.println("��ǰ�ڵ�����ݣ�"+node.getTextTrim());//��ǰ�ڵ�����
	    List<Attribute> listAttr=node.attributes();//��ǰ�ڵ���������Ե�list
	    for(Attribute attr:listAttr){//������ǰ�ڵ����������
	        String name=attr.getName();//��������
	        String value=attr.getValue();//���Ե�ֵ
	        System.out.println("�������ƣ�"+name+"����ֵ��"+value);
	    }
	    
	    //�ݹ������ǰ�ڵ����е��ӽڵ�
	    List<Element> listElement=node.elements();//����һ���ӽڵ��list
	    for(Element e:listElement){//��������һ���ӽڵ�
	        this.getNodes(e);//�ݹ�
	    }
	}
}
