package com.utility;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="users")
public class Users {
	private List<User>userList;
	
	public List<User> getUserList(){
		return userList;
		
	}
	@XmlElement(name="user")
	public void setUserList(List<User> userList)
	{
		this.userList = userList;
	}

}
