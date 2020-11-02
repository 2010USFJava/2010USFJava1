package com.revature.util;

public class Driver 
{
	static {Data.readBabyData();}
	
	public static void main(String[] args) 
	{
		Menu.start();
		
		System.out.println(Roster.babyList.toString());
	}
}