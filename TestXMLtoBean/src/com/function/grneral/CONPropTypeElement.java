package com.function.grneral;

import java.util.List;

import org.dom4j.Element;

public class CONPropTypeElement {
	 private String type = "";
	 private String cname = "";
	 private String ename = "";

	 public void initPropElement(Element chidelem, List propTypeLst,
	   CONPropTypeElement prope) {
	  prope.setType(chidelem.attribute(CONRootElement.XML_TYPE).getValue());
	  prope.setCname(chidelem.attribute(CONRootElement.XML_CNAME).getValue());
	  prope.setEname(chidelem.attribute(CONRootElement.XML_ENAME).getValue());
	  propTypeLst.add(prope);
	 }

	 public String getType() {
	  return type;
	 }
	
	 public void setType(String type) {
	  this.type = type;
	 }
	
	 public String getCname() {
	  return cname;
	 }
	
	 public void setCname(String cname) {
	  this.cname = cname;
	 }
	
	 public String getEname() {
	  return ename;
	 }
	
	 public void setEname(String ename) {
	  this.ename = ename;
	 }

}
