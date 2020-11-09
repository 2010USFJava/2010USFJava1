package com.revature.bean;

import java.util.Scanner;
import com.revature.util.Data;
import com.revature.util.Roster;

public class Admin extends User 
{
	private static final long serialVersionUID = 4906608776562416811L;
	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Admin(Admin u) 
	{
		super(u);
		this.id = u.getId();
	}
	
	public Admin(String userId, String password, String firstName, String lastName, String ss, String id) 
	{
		//super(userId, password, firstName, lastName, ss, id);
		super(userId, password, firstName, lastName, ss);		
		this.id = id;
		
		Roster.adminUserList.add(this);
		Data.writeEmployeeAdminData(Roster.adminUserList);		
		//LogThis.logIt("info", "Added admin" this.firstName + " " + this.lastName);
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
			
		}else if(tU.getIncome() >= 20000 && tU.getDeposit() >= 10000)
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
	
	@Override
	public String toString() {
		return "Admin " + super.toString() + "id=" + id + "]";
	}
}