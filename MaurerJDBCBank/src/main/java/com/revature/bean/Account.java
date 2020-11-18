package com.revature.bean;

public class Account 
{
	private int acctId;
	private String acctType;
	private double balance;
	
	public Account(int acctId, double balance) {
		super();
		this.acctId = acctId;
		this.balance = balance;
	}
	
	public Account(int acctId, String acctType, double balance) {
		super();
		this.acctId = acctId;
		this.acctType = acctType;
		this.balance = balance;
	}
	
	public int getAcctId() {
		return acctId;
	}
	public void setAcctId(int acctId) {
		this.acctId = acctId;
	}
	public String getAcctType() {
		return acctType;
	}
	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [acctId=" + acctId + ", acctType=" + acctType + ", balance=" + balance + "]";
	}
	
	
	
	
}
