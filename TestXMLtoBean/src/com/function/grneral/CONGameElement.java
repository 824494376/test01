package com.function.grneral;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;

public class CONGameElement {
	private String id = "";
	private List propFileLst = new ArrayList();
 //elem��game�ڵ㣬propList����gamelist
	 public void initPropElement(Element elem, List propLst, CONGameElement prope) {
		 prope.setId(elem.attribute(CONRootElement.XML_ID).getValue());
		 List itemLst = elem.elements();//�õ�PropFile  �ڵ㼯��
		 for (int i = 0; i < itemLst.size(); i++) {
			 Element chidelem = (Element) itemLst.get(i);//propFile�ڵ�
			 	if (chidelem.getName().equals(CONRootElement.XML_PROPFILE)) {
			 		CONPropFileElement conPropeFile = new CONPropFileElement();
			 		//��propFile�ڵ�ȫ������ӵ�game��list��ȥ
			 		conPropeFile.initPropElement(chidelem, prope.propFileLst, conPropeFile);
			 	}
	     }
	  //��game�ڵ�ȫ������ӵ�root��list��
	  propLst.add(prope);
	 }

	 public String getId() {
	  return id;
	 }
	
	 public void setId(String id) {
	  this.id = id;
	 }

}