package com.function.grneral;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;

public class CONPropFileElement {
 private String filename = "";
 private String totalPorpType = "";
 private String totalPorpTypeName = "";
 private List propTypeLst = new ArrayList();

 //将propFileList全部都添加到game的list中去
 public void initPropElement(Element elem, List propFileLst,
   CONPropFileElement conPropeFile) {
  conPropeFile.setFilename(elem.attribute(CONRootElement.XML_FILENAME)
    .getValue());
  conPropeFile.setTotalPorpType(elem.attribute(
    CONRootElement.XML_TOTALPROPTYPE).getValue());
  conPropeFile.setTotalPorpTypeName(elem.attribute(
    CONRootElement.XML_TOTALPROPNAME).getValue());
  List itemLst = elem.elements();
  for (int i = 0; i < itemLst.size(); i++) {
   Element chidelem = (Element) itemLst.get(i);
   if (chidelem.getName().equals(CONRootElement.XML_PROPTYPE)) {
    CONPropTypeElement prope = new CONPropTypeElement();
    prope
      .initPropElement(chidelem, conPropeFile.propTypeLst,
        prope);
   }
  }
  propFileLst.add(conPropeFile);
 }

 public String getFilename() {
  return filename;
 }

 public void setFilename(String filename) {
  this.filename = filename;
 }

 public String getTotalPorpType() {
  return totalPorpType;
 }

 public void setTotalPorpType(String totalPorpType) {
  this.totalPorpType = totalPorpType;
 }

 public String getTotalPorpTypeName() {
  return totalPorpTypeName;
 }

 public void setTotalPorpTypeName(String totalPorpTypeName) {
  this.totalPorpTypeName = totalPorpTypeName;
 }

 public List getPropTypeLst() {
  return propTypeLst;
 }

 public void setPropTypeLst(List propTypeLst) {
  this.propTypeLst = propTypeLst;
 }

}
