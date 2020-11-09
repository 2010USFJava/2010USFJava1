package com.revature.bean;

import java.util.Scanner;

import com.revature.util.Data;
import com.revature.util.Roster;

public class Employee extends User
{
	private static final long serialVersionUID = 4331182211325437499L;
	
	private String employeeId;
	
	public Employee(Employee u) 
	{
		super(u);
		this.employeeId = u.employeeId;
		
	}

	public Employee(String userId, String password, String firstName, String lastName, String ss, String id) {
		super(userId, password, firstName, lastName, ss);
		this.employeeId = id;
		
		Roster.emplUserList.add(this);
		Data.writeEmployeeData(Roster.emplUserList);
		//LogThis.logIt("info", "added employee... " + this.firstName + " " + this.lastName);		
	}
	
	public void approveOrDeny(TempUser tU)
	{
		String acctNum;
		
		if(tU.getIncome() >= 30000)
		{
			System.out.println("Please enter the customers account Number: ");
			acctNum = new Scanner(System.in).nextLine();
			
			//create a new customer
			Customer c = new Customer(tU.getUserId(), tU.getPassword(), tU.getFirstName(), 
					tU.getLastName(), tU.getSS(), acctNum, tU.getDeposit());
			
		}else if(tU.getIncome() < 20000 && tU.getDeposit() < 10000)
		{
			tU.setApproved("deny");
			//store this back in the list??????
		}
	}

}
