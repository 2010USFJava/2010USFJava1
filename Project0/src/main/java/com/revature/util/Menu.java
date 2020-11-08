package com.revature.util;

import java.util.Scanner;

import com.revature.bean.Customer;
import com.revature.bean.TempUser;
import com.revature.bean.User;

public class Menu 
{
	static Scanner in = new Scanner(System.in);
	static Roster r = new Roster();
	static CheckData c = new CheckData();
	static String choice;
	
	public static void start()
	{		
		//ui				
		System.out.println("\n\n");
		System.out.println("\t\t\t\t*************************");
		System.out.println("\t\t\t\t*\tBank App\t*");
		System.out.println("\t\t\t\t*\t\t\t*");
		System.out.println("\t\t\t\t*************************");
		System.out.println("\n\n");

		System.out.println("User Id: ");
		String userId = in.nextLine();
		
		//check for user id if found send back user
		//and ask to enter password
		User u = new User(r.getUserByUserId(userId));
		
		System.out.println("\n\nHello, " + u.getUserId());
		System.out.print("\nPassword: ");
		String pw = in.nextLine();	
		
		if(c.checkPassword(pw, u))
		{
			welcome(u);
		}
		else
		{
			System.out.println("\n\nSorry, we are having trouble with your User Id or password...\n\n");
			System.out.println("Please re-enter your User Id and password: ");
			start();
		}
	}
	
	public static User userNotFound(String userId)
	{
		System.out.println("\n\nSorry, we are having trouble with your User Id or password... ");
		System.out.println("[Y] Would you like to re-enter your User Id? ");
		System.out.println("[N] If you are a new User and would like to apply please enter N for new, "
			+ "otherwise enter Y to try to enter your User Id again. Thank you!");
		choice = in.nextLine();
			
		if(choice.equalsIgnoreCase("y"))
		{
			start();
		}
		else if(choice.equalsIgnoreCase("n"))
		{
			//if not found ask to apply for an account
			return apply(userId);
		}
		else
		{
			userNotFound(userId);
		}
		return null;
		
	}
	
	public static void welcome(User u) 
	{
		System.out.println("in welcome");
		 
		System.out.println(u.toString());	
		
		System.out.println("why");

	}	
	
	public static User apply(String userId)
	{
		System.out.println("\n\nThank you, " + userId);
		System.out.println("Please enter the information below to apply.");
		
		System.out.print("Create a password: ");
		String pw = in.nextLine();
		
		System.out.print("Retype password: ");
		String pw2 = in.nextLine();		
		
		if(pw.equals(pw2))
		{
			System.out.print("Enter your first name: ");
			String fName = in.nextLine();
			//c.checkForNull(fName)
			
			System.out.print("Enter your last name: ");
			String lName = in.nextLine();
			
			System.out.print("Enter your social security number: ");
			String ss = in.nextLine();
			
			System.out.print("Enter your yearly income: ");
			String inc = in.nextLine();
			double income = Double.parseDouble(inc);
			
			System.out.print("Please enter the deposit ammount you would like to add to your account if approved: ");
			String dep = in.nextLine();
			double deposit = Double.parseDouble(dep);
			
			TempUser tU = new TempUser(userId, pw, fName, lName, ss, income, deposit);
			
			System.out.println("\n\nThank you for applying with Bank App we will email you within "
					+ "24 hours to let you know if you were approved\n");
			System.out.println(tU);
			start();
			return tU;
			
		}else
		{
			System.out.println("\nPASSWORDS DO NOT MATCH");
			
			apply(userId);			
		}		
		
		return null;			
	}
}