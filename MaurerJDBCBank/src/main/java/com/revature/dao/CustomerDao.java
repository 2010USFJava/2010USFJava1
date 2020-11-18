package com.revature.dao;

import java.sql.SQLException;

import com.revature.bean.Customer;

public interface CustomerDao 
{
	public void createCustomer(Customer c);
	public Customer getCustomerByUserName(String email) throws SQLException;
}
