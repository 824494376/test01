package com.function.jaxb;

public class Test {
	public static void main(String[] args) throws Exception{
		//xmlת��Ϊ����
		//testXmlToJava();
		//java����ת��Ϊxml
		//testJavaToXml();
		//����ת��
		testJavaToXml1();
		
		
	}
	public static void testJavaToXml() throws Exception{
		User user = new User();
		user.setId("001");
		user.setAge(1);
		user.setName("admin");
		user.setSex("��");
		JavaToXml.transferBeantoXml(user);
	}
	public static void testXmlToJava() throws Exception{
		XmlToJava.transferXmlToJava();
	}
	public static void testJavaToXml1()throws Exception{
		Users users = new Users();
		User user = new User();
		user.setId("001");
		user.setAge(12);
		user.setName("admin");
		user.setSex("man");
		users.getUsers().add(user);
		JavaToXml.transferBeantoXml(users);
	}

}
