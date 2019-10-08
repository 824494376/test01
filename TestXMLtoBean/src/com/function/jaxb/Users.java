package com.function.jaxb;



import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="group")
@XmlAccessorType(XmlAccessType.FIELD)
public class Users {
	@XmlAttribute(name="id")
	private int id;
	@XmlElementWrapper(name="userInfos")
	@XmlElement(name="userInfo")
	private List<User> users;
	public Users(){
		this.users = new ArrayList<User>();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	

}
