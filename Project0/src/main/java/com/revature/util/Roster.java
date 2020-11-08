package com.revature.util;

import java.util.ArrayList;
import java.util.List;

import com.revature.bean.Customer;
import com.revature.bean.Employee;
import com.revature.bean.TempUser;
import com.revature.bean.User;

public class Roster 
{
	public static List<Customer> customerList = new ArrayList<Customer>();
	public static List<TempUser> tempUserList = new ArrayList<TempUser>();
	public static List<Employee> employeeUserList = new ArrayList<Employee>();
	
	
	public User getUserByUserId(String userId)
	{
		for(int i = 0; i< tempUserList.size(); i++)
		{
			String n = tempUserList.get(i).getUserId();
			
			if(userId.equals(n)) {
				return new TempUser(tempUserList.get(i));
			}
		}
		
		for(int i = 0; i< customerList.size(); i++)
		{
			String n = customerList.get(i).getUserId();
			
			if(userId.equals(n)) {
				return new Customer(customerList.get(i));
			}
		}
		
		for(int i = 0; i< employeeUserList.size(); i++)
		{
			String n = employeeUserList.get(i).getUserId();
			
			if(userId.equals(n))
			{
				return new Employee(employeeUserList.get(i));
			}
		}		
		
		System.out.println("User not found");
				
		return Menu.userNotFound(userId);
	}
}