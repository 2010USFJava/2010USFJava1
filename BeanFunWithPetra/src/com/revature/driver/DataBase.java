package com.revature.driver;

import java.util.ArrayList;

import com.revature.fun.Customer;
import com.revature.fun.Employee;

public class DataBase {
	
	ArrayList<String> data = new ArrayList<String>(); 

	public void addCustomer(String c, String e)
	{
		String cE = c + e;
		//add customer to database with employee id
		data.add(cE);		
	}
	
	public void showCustomers() {
		
		for(int x = 0; x < data.size(); x++)
		{
			System.out.println(data.get(x));
			
		}
	}
}
