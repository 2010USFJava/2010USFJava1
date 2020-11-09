package com.revature.bean;

import com.revature.util.Data;
import com.revature.util.Roster;

public class Customer extends User implements Bank
{
	private String accountNumber;
	private double balance;
	
	public Customer(String uId, String pw, String fN, String lN, String ss, String accountNumber, double balance)
	{
		super(uId, pw, fN, lN, ss);
		this.accountNumber = accountNumber;
		this.balance = balance;	
		Roster.customerList.add(this);
		Data.writeCustomerData(Roster.customerList);
		//LogThis.logIt("info", "Welcome little... " + this.firstName + " " + this.lastName);
	}	

	public Customer(Customer u) 
	{
		super(u);
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@Override
	public boolean deposit(double d) 
	{
		if(d > 0)
		{
			this.setBalance(balance =+ d);
			//LogThis.logIt("info", this.firstName + " " + this.lastName " has made a transfer of " + t
			//+ "to " + c.getFirstName() + " account";
			return true;
		}
		else
		{
			System.out.println("\n\nPlease enter an amount greater then 0."
					+ "Please try again...\n\n");
			return false;
		}
	}

	@Override
	public boolean withdrawal(double w) 
	{
		if(w <= balance)
		{
			this.setBalance(balance=- w);
			//LogThis.logIt("info", this.firstName + " " + this.lastName " has withdrew " + w;
			return true;
		}	
		else
		{
			System.out.println("\n\nPlease enter an amount greater then or equal to"
					+ " your balance. Please try again...\n\n");
			return false;
		}		
	}

	@Override
	public boolean transfer(double t, Customer c) 
	{
		if(t <= balance)
		{
			this.setBalance(balance=-t);
			c.deposit(t);
			//LogThis.logIt("info", this.firstName + " " + this.lastName " has made a transfer of " + t
					//+ "to " + c.getFirstName() + " account";	
			return true;
		}else
		{
			System.out.println("\n\nPlease enter an amount less then or equal to"
					+ " your balance. Please try again...\n\n");
			return false;			
		}	
	}
	
	@Override
	public String toString() {
		return "Customer [accountNumber=" + accountNumber + ", balance=" + balance + ", toString()=" + super.toString()
				+ "]";
	}
}