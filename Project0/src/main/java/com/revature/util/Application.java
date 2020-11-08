package com.revature.util;

public class Application 
{
	static {Data.readTempUserData();}
	
	public static void main(String[] args) 
	{
		Menu.start();
		//System.out.println(Roster.tempUserList.toString());
	}
}
