package com.revature.util;

import java.util.Scanner;

import com.revature.beans.Baby;

public class Menu 
{
	static Scanner in = new Scanner(System.in);
	
	public static void start()
	{
		String fName;
		String lName;
		double weight;
		double height;
		
		System.out.println("Please enter the babys first name");
		fName=in.nextLine();
		
		System.out.println("Please enter a the babys last name");
		lName = in.nextLine();
		
		System.out.println("Please enter the babys weight");
		String w = in.nextLine();
		weight= Double.parseDouble(w);
		
		System.out.println("Please enter the babys height");
		String h = in.nextLine();
		height= Double.parseDouble(h);
		
		System.out.println("If the babys information is correct please enter y for yes.");
		String choice = in.nextLine();
		
		if(choice.equalsIgnoreCase("y"))
		{
			Baby b = new Baby(fName, lName, weight, height);
		}
		else
		{
			start();
		}	
	}
}