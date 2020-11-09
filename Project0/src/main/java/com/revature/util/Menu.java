package com.revature.util;

import java.io.IOException;
import java.util.Scanner;

import com.revature.bean.Admin;
import com.revature.bean.Customer;
import com.revature.bean.Employee;
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
		displayLogo();

		System.out.println("User Id: ");
		String userId = in.nextLine();
		
		//check for user id if found send back a temp user
		//and ask to enter password
		User holdUser = new User(r.getUserByUserId(userId));
		
		displayLogo();		
		System.out.println("\n\nHello, " + holdUser.getUserId());	
		
		//get password
		System.out.print("\nPassword: ");
		String pw = in.nextLine();	
		
		//if passwords match pull up account if not keep going to start
		if(c.checkPassword(pw, holdUser))
		{
			//create user and call user welcome page
			r.createUserByType(holdUser.getUserId());
		}
		else
		{
			displayLogo();
			System.out.println("\n\nSorry, we are having trouble with your User Id or password...\n\n");
			System.out.println("Please re-enter your User Id and password: ");
			start();
		}
	}
	
	public static void userNotFound(String userId)
	{
		displayLogo();
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
			apply(userId);
		}
		else
		{
			userNotFound(userId);
		}		
	}
	
	public static void welcome(TempUser u) 
	{
		displayLogo();
		
		if(u.getApproved().equalsIgnoreCase("deny"))
		{
			System.out.println("Hello, " + u.getFirstName() + " " + u.getLastName() +
					", unfortanely we were not able to approve your account at this time.");
		}else
		{
			System.out.println(" Hello, " + u.getFirstName() + " " + u.getLastName() + ", we are still working on approving your"
					+ " application. We will email you when you have been approved or denied.\n\n "
					+ "Thank you for applying with Bank App! "
					+ "Have a nice day.\n\n" + u.toString());
		}
		
		do 
		{
			choice = logOut();
		}while(choice != "l" || choice != "L");	
	}
	
	public static void welcome(Customer u) 	
	{
		boolean check = false;
		String back = "n";
	
			displayLogo();		
			System.out.println("Hello, " + u.getFirstName() + " " + u.getLastName());					
	
			System.out.println("Please pick a Menu Option below:"				
				+ "\n\t[B]: Balance"									
				+ "\n\t[D]: Deposit"
				+ "\n\t[T]: Transfer"
				+ "\n\t[W]: Withdrawal"
				+ "\n\n\t[L]: Log Out");
			choice = in.nextLine();			
		
			switch(choice) 
			{
			case "B":
				System.out.println(u);
			
				break;
			
			case "D":
				do
				{
					System.out.println("What is the amount you would like to depoist: ");
					String d = in.nextLine();
					
					check = u.deposit(Double.parseDouble(d));
				
					System.out.println(u);
				
					LogThis.logIt("info", u.getFirstName() + " " + u.getLastName() + 
						" made a deposit");
				}while(check == false);				
		    
				break;
		    
			case "T":
				do
				{
					System.out.println("What is the amount you would like to transfer: ");
					String t = in.nextLine();
				 
					System.out.println("What is the user id of the person you would like to transfer to?");
					String userId = in.nextLine();
			
					Customer transferCustomer = new Customer((Customer)r.getUserByUserId(userId));
					check = u.transfer(Double.parseDouble(t), transferCustomer);
			
					LogThis.logIt("info", u.getFirstName() + " " + u.getLastName() + 
							" made a transfer for to " + transferCustomer.getFirstName());
			    } while(check == false);
			
				break;
		    
			case "W":
				 do
				 {
					 System.out.println("What is the amount you would like to withdrawal: ");
					 String w = in.nextLine();
			
					 check = u.withdrawal(Double.parseDouble(w));
					 
					 System.out.println(u);
				
					 LogThis.logIt("info", u.getFirstName() + " " + u.getLastName() + 
							 " made a withdrawal" );
				 }while(check == false);
			
				 break;
				  
			case "L":
				start();
	    	 
				break;
	    	 
			default:
				welcome(u);
			}
			
		welcome(u);
     }
	
	public static void welcome(Employee u) 
	{
		boolean check = false;
		String back = "n";
		
		do
		{
			displayLogo();		
			System.out.println("Hello, " + u.getFirstName() + " " + u.getLastName() +
					", we appreciate your work everyday!\n\n");		
		
			System.out.println("Please pick a Menu Option below:"
					+ "\n\t[A]: Approve or Deny Accounts"
					+ "\n\t[B]: Balance"
					+ "\n\n\t[L]: Log Out");
		choice = in.nextLine();			
			
		switch(choice) 
		{
			case "A":
				System.out.println("Please enter the customers' User Id: ");
				String userId = in.nextLine();
				
				System.out.println("\nAlways make sure to verify customers' account information");
				
				TempUser tU = new TempUser((TempUser)r.getUserByUserId(userId));
				
				u.approveOrDeny(tU);
				
				break;
				
			case "B":
				System.out.println(getCustomer().toString());
				
				break;

			case "L":
		    	 start();
		    	 
		    	 break;
		    	 
		     default:
			  welcome(u);
			}
		
		System.out.println("Would you like to go back to the main menu?\n"
				+ "Enter y for yes and any other key for no");
		back = in.nextLine();
		}while(back != "y" || back != "Y");
	}
	
	public static void welcome(Admin u) 
	{
		boolean check = false;
		String back = "n";
		
		do
		{
			displayLogo();		
			System.out.println("Hello, " + u.getFirstName() + " " + u.getLastName() +
					", we appreciate your work everyday!\n\n");		
		
			System.out.println("Please pick a Menu Option below:"
					+ "\n\t[A]: Approve or Deny Accounts"
					+ "\n\t[B]: Balance"
					+ "\n\t[C]: Cancel Accounts"					
					+ "\n\t[D]: Deposit"
					+ "\n\t[E]: Add Employee"
					+ "\n\t[T]: Transfer"
					+ "\n\t[W]: Withdrawal"
					+ "\n\n\t[L]: Log Out");
		choice = in.nextLine();			
			
		switch(choice) 
		{
			case "A":
				System.out.println("Please enter the customers' User Id: ");
				String userId = in.nextLine();
				
				System.out.println("\nAlways make sure to verify customers' account information");
				
				TempUser tU = new TempUser((TempUser)r.getUserByUserId(userId));
				
				u.approveOrDeny(tU);
				
				break;
				
			case "B":
				System.out.println(getCustomer().toString());
				
				break;
				
			case "C":
				// will delete account from list.....
				System.out.println("Are you sure you want to delete this account?\n\n"
						+ "Please enter y for yes or any other key for no...");
				choice = in.nextLine();
				
				if(choice.equalsIgnoreCase("y"))
				{
					//Customer customer = new Customer(getCustomer());
					System.out.println("delete account" + getCustomer().toString());
					//delete this account
				}
				
				break;
				
			case "D":
				do
				{
					Customer customer = new Customer(getCustomer());
					System.out.println("What is the amount you would like to depoist: ");
					String d = in.nextLine();
				
					check = customer.deposit(Double.parseDouble(d));
					
					System.out.println(customer.toString());
					
					LogThis.logIt("info", u.getFirstName() + " " + u.getLastName() + 
							" made a deposit for " + customer.toString());
				}while(check == false);				
			    
			    break;
			    
			 case "E":
				  addEmployee();
				  
				  break;
				  
			case "T":
			     do
				 {
			    	 Customer customer = new Customer(getCustomer());

					 System.out.println("What is the amount you would like to transfer: ");
					 String t = in.nextLine();
					 
					 System.out.println("What is the user id of the person you would like to transfer to?");
					 userId = in.nextLine();
				
					Customer transferCustomer = new Customer((Customer)r.getUserByUserId(userId));
					check = customer.transfer(Double.parseDouble(t), transferCustomer);
				
					LogThis.logIt("info", u.getFirstName() + " " + u.getLastName() + 
					" made a transfer for " + customer + " to " + transferCustomer.getFirstName());
				    
				 } while(check == false);
				
			     break;
			    
		    case "W":
			    do
				{
					Customer customer = new Customer(getCustomer());

					System.out.println("What is the amount you would like to withdrawal: ");
					String w = in.nextLine();
				
					check = customer.withdrawal(Double.parseDouble(w));
					
					LogThis.logIt("info", u.getFirstName() + " " + u.getLastName() + 
					" made a withdrawal for " + customer );
				}while(check == false);
				
			    
			    break;		    
		    
		     case "L":
		    	 start();
		    	 
		    	 break;
		    	 
		     default:
			  welcome(u);
			}
		
		System.out.println("Would you like to go back to the main menu?\n"
				+ "Enter y for yes and any other key for no");
		back = in.nextLine();
		}while(back != "y" || back != "Y");
	}
	
	//temporary user display prompts to apply/create a temporary user
	public static void apply(String userId)
	{
		displayLogo();

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
			
			System.out.print("Would you like to make this a joint account? \n\n Please enter Y for yes"
					+ " and any other key for no: ");
			choice = in.nextLine();
			
			String jointName;
			
			if(choice.equalsIgnoreCase("y"))
			{
				System.out.println("\n\nPlease enter the joint account holders name you would like to add:");
				jointName = in.nextLine();
			}
			else
			{
				jointName = null;
			}
						
			TempUser tU = new TempUser(userId, pw, fName, lName, ss, income, deposit);
			
			displayLogo();

			System.out.println("\n\n Thank you for applying with Bank App we will email you within "
					+ "24 hours to let you know if you were approved\n");
			//System.out.println(tU);
			
			logOut();
						
		}else
		{
			System.out.println("\nPASSWORDS DO NOT MATCH");
			
			apply(userId);			
		}					
	}
	
	//temporary user display prompts to apply/create a temporary user
	public static void addEmployee()
	{
			displayLogo();

			System.out.println("\n\nPlease create the employees User Id: ");
			String userId = in.nextLine();
			
			System.out.println("\n\nCreate a temporary password for the user. Remind "
					+ "them to change it after siging in the first time.");
			System.out.print("\nCreate a password: ");
			String pw = in.nextLine();
			
			System.out.print("\nRetype password: ");
			String pw2 = in.nextLine();		
			
			if(pw.equals(pw2))
			{
				System.out.print("Enter the employees first name: ");
				String fName = in.nextLine();
				//c.checkForNull(fName)
				
				System.out.print("Enter the employees last name: ");
				String lName = in.nextLine();
				
				System.out.print("Enter the employees social security number: ");
				String ss = in.nextLine();
				
				System.out.print("Enter their Employee Id: ");
				String eId = in.nextLine();
						
				Employee e = new Employee(userId, pw, fName, lName, ss, eId);
				
				displayLogo();

				System.out.println("\n\n Thank you for adding the new employee. Please print off their badge...\n");
				//System.out.println(tU);
				
				logOut();
							
			}else
			{
				System.out.println("\nPASSWORDS DO NOT MATCH");
				
				addEmployee();			
			}					
		}
	public static Customer getCustomer()
	{
		System.out.println("Please enter the customers' User Id: ");
		String userId = in.nextLine();
		
		System.out.println("\nAlways make sure to verify customers' account information");
		
		Customer customer = new Customer((Customer)r.getUserByUserId(userId));
		
		return customer;
	}
	
	public static void displayLogo()
	{
		//ui				
		System.out.println("\n\n");
		System.out.println("\t\t\t\t\t\t\t*************************");
		System.out.println("\t\t\t\t\t\t\t*\tBank App\t*");
		System.out.println("\t\t\t\t\t\t\t*\t\t\t*");
		System.out.println("\t\t\t\t\t\t\t*************************");
		System.out.println("\n\n");
	}
	
	public static String logOut()
	{
		System.out.println("\n\nPlease press L to log out when ready...");
		choice = in.nextLine();
	
		if(choice.equalsIgnoreCase("l"))
		{
			start();
		}
		return choice;
	}
}