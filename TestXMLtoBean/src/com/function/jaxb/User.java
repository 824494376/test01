package com.function.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 一个用户信息
 * @author chen
 *
 */
@XmlRootElement(name="userInfo")
@XmlAccessorType(XmlAccessType.FIELD)//将字段添加进去
public class User {
	@XmlAttribute(name="userId")
	private String id;
	@XmlElement(name="userName")
	private String name;
	@XmlElement(name="userSex")
	private String sex;
	@XmlElement(name="userAge")
	private int age;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
