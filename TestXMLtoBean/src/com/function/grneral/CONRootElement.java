package com.function.grneral;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;

public class CONRootElement {
 private List propLst = new ArrayList();

 public void newRootElement(Element rootElm, CONRootElement rel) {
	  List itemLst = rootElm.elements();//得到根节点的子节点个数
	  for (int i = 0; i < itemLst.size(); i++) {
		   Element elem = (Element) itemLst.get(i);
		   if (elem.getName().equals(XML_GAME)) {//game节点
			    CONGameElement prope = new CONGameElement();
			    prope.initPropElement(elem, rel.propLst, prope);
		   }
	  }
 }

 public List getPropLst() {
  return propLst;
 }

 public void setPropLst(List propLst) {
  this.propLst = propLst;
 }
/**
 * 更节点root
 */
 public static String XML_ROOT = "root";
 /**Game节点*/
 public static String XML_GAME = "Game";
 /**Game节点的属性id*/
 public static String XML_ID = "id";
 /**PropFile节点*/
 public static String XML_PROPFILE = "PropFile";
 /**PropFile节点的属性fileName*/
 public static String XML_FILENAME = "fileName";
 /**PropFile节点totalPropType属性*/
 public static String XML_TOTALPROPTYPE = "totalPropType";
 /**PropFile节点totalPropTypeName属性*/
 public static String XML_TOTALPROPNAME = "totalPropTypeName";
 /**PropType节点*/
 public static String XML_PROPTYPE = "PropType";
 /**PropType节点的type属性*/
 public static String XML_TYPE = "type";
 /**PropType节点cname属性*/
 public static String XML_CNAME = "cname";
 /**PropType节点ename属性*/
 public static String XML_ENAME = "ename";

}