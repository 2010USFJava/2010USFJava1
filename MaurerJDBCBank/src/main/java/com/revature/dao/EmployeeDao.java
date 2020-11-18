package com.revature.dao;

import com.revature.bean.Employee;

public interface EmployeeDao 
{
	public Employee getEmployeeByUserName(String email);
}
