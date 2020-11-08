package com.revature.bean;

public class Employee extends User
{
	private static final long serialVersionUID = 4331182211325437499L;
	
	private String employeeId;
	
	public Employee(Employee u) 
	{
		super(u);
		this.employeeId = u.employeeId;
	}

}
