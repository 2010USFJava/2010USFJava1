package com.revature.bean;

import com.revature.util.Data;
import com.revature.util.Roster;

public class Customer extends User
{
	private String accountNumber;
	private double balance;
	
	Customer(String uId, String pw, String fN, String lN, String ss, String accountNumber, double balance)
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
	public String toString() {
		return "Customer [accountNumber=" + accountNumber + ", balance=" + balance + ", toString()=" + super.toString()
				+ "]";
	}
}
