package com.revature.bean;

public interface Bank 
{
	boolean deposit(double d);
	boolean withdrawal(double w);
	boolean transfer(double t, Customer c);
}
