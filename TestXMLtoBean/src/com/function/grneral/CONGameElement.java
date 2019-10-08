package com.function.grneral;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;

public class CONGameElement {
	private String id = "";
	private List propFileLst = new ArrayList();
 //elem是game节点，propList则是gamelist
	 public void initPropElement(Element elem, List propLst, CONGameElement prope) {
		 prope.setId(elem.attribute(CONRootElement.XML_ID).getValue());
		 List itemLst = elem.elements();//得到PropFile  节点集合
		 for (int i = 0; i < itemLst.size(); i++) {
			 Element chidelem = (Element) itemLst.get(i);//propFile节点
			 	if (chidelem.getName().equals(CONRootElement.XML_PROPFILE)) {
			 		CONPropFileElement conPropeFile = new CONPropFileElement();
			 		//将propFile节点全部都添加到game的list中去
			 		conPropeFile.initPropElement(chidelem, prope.propFileLst, conPropeFile);
			 	}
	     }
	  //将game节点全部都添加到root的list中
	  propLst.add(prope);
	 }

	 public String getId() {
	  return id;
	 }
	
	 public void setId(String id) {
	  this.id = id;
	 }

}