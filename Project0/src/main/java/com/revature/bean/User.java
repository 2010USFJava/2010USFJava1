package com.revature.bean;

import java.io.Serializable;

public class User implements Serializable
{
	private static final long serialVersionUID = -8841519815704640491L;
	
	private String userId;
	private String password;
	private String firstName;
	private String lastName;
	private String ss;
	//private String type;
	//private String email;//shouldve have used as userid
	//private String address;
	//private String zip;
	
	public User()
	{
		super();
	}
	
	public User(User u)
	{
		super();
		this.userId = u.userId;
		this.password = u.password;
		this.firstName = u.firstName;
		this.lastName = u.lastName;
		this.ss = u.ss;
		
	}
	
	public User(String userId, String password, String firstName, String lastName, String ss) 
	{
		super();
		this.userId = userId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.ss = ss;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSS() {
		return ss;
	}

	public void setSS(String ss) {
		this.ss = ss;
	}
	
	@Override
	public String toString() {
		return "[userId=" + userId + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", ss=" + ss + " ";
	}
	
}