package com.revature.driver;

import com.revature.fun.Customer;
import com.revature.fun.Employee;

public class Application {
	
	public static void main(String[] args) {
		
	
	
	Customer cP = new Customer("Tyler Maurer", "01/28/2011", "pmaurer@gmail.com");
	
	Employee eP = new Employee(11115369);
	
	DataBase d = new DataBase();
	
	d.addCustomer(cP.toString(), eP.toString());
	
	d.showCustomers();
	
	}

}
