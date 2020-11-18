package com.revature.bean;

public class Employee 
{
	private int id;
	private String email;
	private String password;
	private String fName;
	private String lName;
	private String ssn;
	private String address;
	private String city;
	private String state;
	private String zip;
	
	public Employee(Employee e) {
		super();
		this.id = e.id;
		this.email = e.email;
		this.password = e.password;
		this.fName = e.fName;
		this.lName = e.lName;
		this.ssn = e.ssn;
		this.address = e.address;
		this.city = e.city;
		this.state = e.state;
		this.zip = e.zip;
	}
	
	public Employee(int id, String email, String password, String fName, String lName, String ssn, String address,
			String city, String state, String zip) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.fName = fName;
		this.lName = lName;
		this.ssn = ssn;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", email=" + email + ", password=" + password + ", fName=" + fName + ", lName="
				+ lName + ", ssn=" + ssn + ", address=" + address + ", city=" + city + ", state=" + state + ", zip="
				+ zip + "]";
	}
	
	
	
	

}
