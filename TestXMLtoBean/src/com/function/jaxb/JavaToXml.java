package com.function.jaxb;

import javax.swing.text.MaskFormatter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

/**
 *Java实体类转化成为xml
 * @author chen
 *
 */
public class JavaToXml {
	
	public static void transferBeantoXml(User user)throws Exception{
		JAXBContext context = JAXBContext.newInstance(User.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "gb2312");
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);
		marshaller.marshal(user, System.out);
		
		
	}
	public static void transferBeantoXml(Users user)throws Exception{
		JAXBContext context = JAXBContext.newInstance(Users.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "gb2312");
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);
		marshaller.marshal(user, System.out);
		
		
	}

}
