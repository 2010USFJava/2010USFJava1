package com.revature.bean;

import com.revature.util.Data;
import com.revature.util.Roster;

public class TempUser extends User
{
	private static final long serialVersionUID = -4002170932250109500L;
	
	private double income;
	private double deposit = 0;
	private String approved;
	
	public TempUser(TempUser u) 
	{
		super(u);
		this.income = u.income;
		this.deposit = u.deposit;
		approved = u.approved;		
	}
		
	public TempUser(String uId, String pw, String fN, String lN, String ss, double income, double deposit)
	{
		super(uId, pw, fN, lN, ss);
		this.income = income;
		this.deposit = deposit;
		approved = "waiting";
		
		Roster.tempUserList.add(this);
		Data.writeTempUserData(Roster.tempUserList);
		//LogThis.logIt("info", "Added temp user " + this.firstName + " " + this.lastName);
	}



	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}
	
	public double getDeposit() {
		return deposit;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}

	public String getApproved() {
		return approved;
	}

	public void setApproved(String approved) {
		this.approved = approved;
	}

	@Override
	public String toString() {
		return "TempUser " +  super.toString() + "income=" + income + " deposit=" 
				+ deposit+ ", approved=" + approved + "]";
		
	}	
}
