package com.revature.util;
/*too much need to study generics more and switching through type*/

import java.util.ArrayList;
import java.util.List;
import com.revature.bean.Admin;
import com.revature.bean.Customer;
import com.revature.bean.Employee;
import com.revature.bean.TempUser;
import com.revature.bean.User;

public class Roster 
{
	public static List<Customer> customerList = new ArrayList<Customer>();
	public static List<TempUser> tempUserList = new ArrayList<TempUser>();
	public static List<Employee> emplUserList = new ArrayList<Employee>();
	public static List<Admin> adminUserList = new ArrayList<Admin>();
		
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
		
		for(int i = 0; i< emplUserList.size(); i++)
		{
			String n = emplUserList.get(i).getUserId();
			
			if(userId.equals(n))
			{
				return new Employee(emplUserList.get(i));
			}
		}
		
		for(int i = 0; i< adminUserList.size(); i++)
		{
			String n = adminUserList.get(i).getUserId();
			
			if(userId.equals(n)) {
				return new Admin(adminUserList.get(i));
			}
		}
		
		System.out.println("User not found");
		
		Menu.userNotFound(userId);
		return null;		
	}
	
	public void createUserByType(String userId)
	{
		for(int i = 0; i< tempUserList.size(); i++)
		{
			String n = tempUserList.get(i).getUserId();
			
			if(userId.equals(n)) 
			{				
				Menu.welcome(new TempUser(tempUserList.get(i)));
			}
		}
		
		for(int i = 0; i< customerList.size(); i++)
		{
			String n = customerList.get(i).getUserId();
			
			if(userId.equals(n)) 
			{
				Menu.welcome(new Customer(customerList.get(i)));
			}
		}
		
		for(int i = 0; i< emplUserList.size(); i++)
		{
			String n = emplUserList.get(i).getUserId();
			
			if(userId.equals(n))
			{
				Menu.welcome(new Employee(emplUserList.get(i)));
			}
		}
		
		for(int i = 0; i< adminUserList.size(); i++)
		{
			String n = adminUserList.get(i).getUserId();
			
			if(userId.equals(n)) 
			{				
				Menu.welcome(new Admin(adminUserList.get(i)));
			}
		}
	}
}