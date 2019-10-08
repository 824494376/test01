package com.function.grneral;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;

public class CONRootElement {
 private List propLst = new ArrayList();

 public void newRootElement(Element rootElm, CONRootElement rel) {
	  List itemLst = rootElm.elements();//�õ����ڵ���ӽڵ����
	  for (int i = 0; i < itemLst.size(); i++) {
		   Element elem = (Element) itemLst.get(i);
		   if (elem.getName().equals(XML_GAME)) {//game�ڵ�
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
 * ���ڵ�root
 */
 public static String XML_ROOT = "root";
 /**Game�ڵ�*/
 public static String XML_GAME = "Game";
 /**Game�ڵ������id*/
 public static String XML_ID = "id";
 /**PropFile�ڵ�*/
 public static String XML_PROPFILE = "PropFile";
 /**PropFile�ڵ������fileName*/
 public static String XML_FILENAME = "fileName";
 /**PropFile�ڵ�totalPropType����*/
 public static String XML_TOTALPROPTYPE = "totalPropType";
 /**PropFile�ڵ�totalPropTypeName����*/
 public static String XML_TOTALPROPNAME = "totalPropTypeName";
 /**PropType�ڵ�*/
 public static String XML_PROPTYPE = "PropType";
 /**PropType�ڵ��type����*/
 public static String XML_TYPE = "type";
 /**PropType�ڵ�cname����*/
 public static String XML_CNAME = "cname";
 /**PropType�ڵ�ename����*/
 public static String XML_ENAME = "ename";

}