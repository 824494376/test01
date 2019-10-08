package com.function.grneral;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
/**
 * 这是一种采用java类的方式进行解析xml到实体类的关系，
 * @author chen
 *
 */
public class XmlFileUnit {

 /**
  * @param args
  */
 public static void main(String[] args) {
  XmlFileUnit xfu = new XmlFileUnit();
  try {
      xfu.getConRootInstan(new File("F:/test.xml"));
  } catch (DocumentException e) {
     e.printStackTrace();
  }

 }

  private void getConRootInstan(File file) throws DocumentException {
  SAXReader reader = new SAXReader();
  Document document = reader.read(file);
  Element rootElm = document.getRootElement();
  CONRootElement rel = new CONRootElement();
  if (rootElm.getName().equals(CONRootElement.XML_ROOT)) {
   rel.newRootElement(rootElm, rel);
   CONGameElement c=(CONGameElement) rel.getPropLst().get(0);
   System.out.println(c.getId());
   System.out.println((CONGameElement) rel.getPropLst().get(0));
  }

 }

}
