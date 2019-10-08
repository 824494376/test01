package com.function.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class XmlToJava {
	public static void transferXmlToJava() throws Exception{
		JAXBContext context  = JAXBContext.newInstance(User.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		File file = new File("F:/test1.xml");
		User user = (User)unmarshaller.unmarshal(file);
		System.out.println("userName:" + user.getName());
		System.out.println("Id:" + user.getId());
		System.out.println("age:" + user.getAge());
		System.out.println("sex:" + user.getSex());
		
	}

}
