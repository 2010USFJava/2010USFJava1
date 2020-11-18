package com.revature.bean;

public class Transaction
{
	private int id;
	private double deposit;
	private double withdrawal;
	private double balance;
	
	public Transaction()
	{
		super();
	}
	
	public Transaction(int id, double deposit, double withdrawal, double balance) {
		super();
		this.id = id;
		this.deposit = deposit;
		this.withdrawal = withdrawal;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getDeposit() {
		return deposit;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}

	public double getWithdrawal() {
		return withdrawal;
	}

	public void setWithdrawal(double withdrawal) {
		this.withdrawal = withdrawal;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double checkAndMakeDeposit(double d, double b) //throw exception
	{
		if(d > 0)
		{
			return d + b;
			
		}else
		{
			return 0;			
		}		
	}
	
	public double checkAndMakeWithdrawal(double w, double b) //throw exception
	{
		if(w > 0)
		{
			if(w <= b)
			{
				return b - w;
			}else
			{
				return 0;
			}
		}else
		{
			return 0;
		}
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", deposit=" + deposit + ", withdrawal=" + withdrawal + ", balance=" + balance
				+ "]";
	}
}