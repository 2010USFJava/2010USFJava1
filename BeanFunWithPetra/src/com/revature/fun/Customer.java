package com.revature.fun;

public class Customer {
	private String name;
	private String birthday;
	private String email;
	
	public Customer(String name, String birthday, String email)
	{
		this.name = name;
		this.birthday = birthday;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

	@Override
	public String toString() {
		return "Customer [name=" + name + ", birthday=" + birthday + ", email=" + email + "]";
	}

}
