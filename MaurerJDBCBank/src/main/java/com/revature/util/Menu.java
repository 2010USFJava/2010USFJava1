package com.revature.util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.reavture.daoimpl.AccountDaoImpl;
import com.reavture.daoimpl.CustomerDaoImpl;
import com.reavture.daoimpl.EmployeeDaoImpl;
import com.reavture.daoimpl.TransactionDaoImpl;
import com.revature.bean.Account;
import com.revature.bean.Customer;
import com.revature.bean.Employee;
import com.revature.bean.Transaction;
import com.revature.dao.CustomerDao;

//Menu is used as a gui to get and display data 
public class Menu 
{
	//get input from user
	static Scanner in = new Scanner(System.in);
	static CustomerDaoImpl cdi = new CustomerDaoImpl();
	//static TransactionDaoImpl tdi = new TransactionDaoImpl();
	//static AccountDaoImpl adi = new AccountDaoImpl();
	static String choice;
		
	//display base menu based on user
	public static void mainMenu() 
	{
		String userId;
		String pw;
		String fwd;
		
		displayLogo();
		
		System.out.println("Please pick a Menu Option below:\n"				
				+ "\n\t[1]: Customer Log In"
				+ "\n\t[2]: Employee Log In"
				+ "\n\t[3]: Open Account");
		System.out.println("\nMenu Option:");
		choice = in.nextLine();			
		
		switch(choice) 
		{
		case "1":			
			System.out.println("\n\nUser Id: ");
			userId = in.nextLine();			
			
			try 
			{
				Customer c = new Customer(cdi.getCustomerByUserName(userId));
								
				if(c.getEmail().equalsIgnoreCase(null))
				{
					System.out.println("there was an issue with user id...");
					fwd = in.nextLine();
					
					mainMenu();
				}
				
				//get password
				System.out.print("\nPassword: ");
				pw = in.nextLine();	
				
				//if passwords match pull up account if not keep going to start
				if(checkPassword(pw, c.getPassword()))
				{
					LogThis.logIt("info", c.toString() + "logged in");
		
					welcome(c);
				}else
				{
					displayLogo();
					System.out.println("\n\nSorry, we are having trouble with your User Id or password...\n\n");
					System.out.println("Please re-enter your User Id and password: ");
					mainMenu();
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}					
			
			break;
			
		case "2":
			System.out.println("\n\nEmployee email: ");
			userId = in.nextLine();			
			
			try 
			{
				EmployeeDaoImpl edi = new EmployeeDaoImpl();
				Employee e = new Employee(edi.getEmployeeByUserName(userId));
								
				if(e.getEmail().equalsIgnoreCase(null))
				{
					System.out.println("there was an issue with user id...");
					fwd = in.nextLine();
					
					mainMenu();
				}
				
				//get password
				System.out.print("\nPassword: ");
				pw = in.nextLine();	
				
				//if passwords match pull up account if not keep going to start
				if(checkPassword(pw, e.getPassword()))
				{
					LogThis.logIt("info", e.toString() + "logged into work");
		
					welcome(e);
				}else
				{
					displayLogo();
					System.out.println("\n\nSorry, we are having trouble with your User Id or password...\n\n");
					System.out.println("Please re-enter your User Id and password: ");
					mainMenu();
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
				
			break;
		case "3":
			
			apply();
			
			
			break;
		
		default:
			
			mainMenu();
		}
	}
	
	//temporary user display prompts to apply/create a temporary user
	public static void apply()
	{
		displayLogo();

		System.out.println("Please enter the information below to apply.");
					
		System.out.print("Enter your email: ");
		String email = in.nextLine();
					
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
						
			System.out.print("Enter your street address: ");
			String address = in.nextLine();
			
			System.out.print("Enter your city: ");
			String city = in.nextLine();
			
			System.out.print("Enter your state: ");
			String state = in.nextLine();
			
			System.out.print("Enter your zip: ");
			String zip = in.nextLine();
						
			System.out.print("Would you like to create a checking or savings account today?"
					+ "\nPlease enter c for checking and s for savings: ");
			String account = in.nextLine();
			
			System.out.println("\n\nPlease verify the information if everything is corret and you are ready to "
					+ "go back to the main menu press b for back.\nIf you see any issues or want to change any"
					+ " information press r to refresh and re-apply");
			choice = in.nextLine();
			
			if(choice.equalsIgnoreCase("b"))
			{
				CustomerDaoImpl cdi = new CustomerDaoImpl();
				AccountDaoImpl adi = new AccountDaoImpl();
				
				Customer c = new Customer(email, pw, fName, lName, ss, address, city, state, zip);
				
				cdi.createCustomer(c);
				
				
				try 
				{
					Customer c1 = new Customer(cdi.getCustomerByUserName(c.getEmail()));
					adi.createNewAccount(c1, account);
				} catch (SQLException e) 
				{
					e.printStackTrace();
				}	
				
				if(account.equalsIgnoreCase("c"))
				{
					System.out.println("\n\nThank you, " + fName + " " + lName +
							" we appreciate your business your checking account is ready.\n"
							+ "If you would like to make a deposit into your new checking account"
							+ " please log in to get started...\nHave a great day!");
					
				}else if(account.equalsIgnoreCase("s"))
				{
					System.out.println("\n\nThank you, " + fName + " " + lName +
							" we appreciate your business your savings account is ready.\n"
							+ "If you would like to make a deposit into your new checking account"
							+ " please log in to get started...\nHave a great day!");
				}else
				{
					System.out.println("im sorry an error has occured please re-enter your information....");
					apply();
				}
				mainMenu();
			}else if(choice.equalsIgnoreCase("r"))
			{
				apply();
			}			
		}else
		{
			System.out.println("\nPASSWORDS DO NOT MATCH");
			apply();			
		}					
	}
			
	public static boolean checkPassword(String pw, String s )
	{
		if(pw.equals(s))
		{
			return true;
		}else
		{
			return false;
		}		
	}
	
	public static void welcome(Customer c) 	
	{
		displayLogo();		
		System.out.println("Hello, " + c.getfName() + " " + c.getlName());	
		
		System.out.println("\nPlease enter the account number that you"
				+ " wish to view or make changes in...\n ");
		
		AccountDaoImpl adi = new AccountDaoImpl();
		List<Account> acctList = new ArrayList<>();
		
		
		
		acctList = adi.getAcctsByCustId(c.getId());
		
		for(int i = 0; i < acctList.size(); i++)
		{
			System.out.println("[" + acctList.get(i).getAcctId() + "]: " +
					acctList.get(i).getAcctType() + " " + 
					acctList.get(i).getBalance());
		}

		//get account number
		System.out.println("\n\naccount number: ");
		String acctNum = in.nextLine();
		int num = Integer.parseInt(acctNum);
		
		//display account page
		System.out.println("\n\n\nHello, " + c.getfName() + " " + c.getlName());
		System.out.println("\n\nDate	 Deposit Witdrawal Balance" );
		System.out.println("-------------------------------------");
		
		//get list of transactions from database
		TransactionDaoImpl tdi = new TransactionDaoImpl();
		
		List<Transaction> transList = new ArrayList<>();		
		transList = tdi.getTransactions(num);		
		
		//display transactions		
		for(int i = 0; i < transList.size(); i++)
		{
			System.out.println("|11/" + transList.get(i).getId() + "/2020|" 
					+ transList.get(i).getDeposit() + "    "  
					+ "|" + transList.get(i).getWithdrawal() + "   " 
					+ "|" + transList.get(i).getBalance() + "|");					
		}
		
		System.out.println("\n\nPlease pick a Menu Option below:"
			+ "\n\t[1]: Make a deposit"
			+ "\n\t[2]: Make a withdrawal"
			+ "\n\t[3]: Create new account"
			+ "\n\t[4]: Cancel account"
			+ "\n\n\t[0]: Log Out");
		System.out.println("Menu Option: ");
		choice = in.nextLine();			
			
		switch(choice) 
		{
		case "1":
			
			try 
			{
				System.out.println("What is the amount you would like to depoist: ");
				String d = in.nextLine();
				double deposit = Double.parseDouble(d);
				
				Transaction t = new Transaction();
				double balance = adi.getBalanceById(num);
								
				double newBalance = t.checkAndMakeDeposit(deposit, balance);				
				
				if( newBalance > 0)
				{
					tdi.makeDeposit(deposit, newBalance, num);
					adi.updateBalance(newBalance, num);
				}else
				{
					System.out.println("an error has occured you can not enter a negative amount to deposit...\n"
							+ "Please try again....");
					String moveFwd = in.nextLine();
				}
				
				welcome(c);
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}		
				
			break;
			
		case "2":
			
			try 
			{
				System.out.println("What is the amount you would like to withdrawal: ");
				String w = in.nextLine();
				double withdrawal = Double.parseDouble(w);
			
				Transaction t = new Transaction();
				double balance = adi.getBalanceById(num);
							
				double newBalance = t.checkAndMakeWithdrawal(withdrawal, balance);				
			
			if( newBalance > 0)
			{
				tdi.makeWithdrawal(withdrawal, newBalance, num);
				adi.updateBalance(newBalance, num);
			}else
			{
				System.out.println("an error has occured you can not enter a negative amount"
						+ " to witdrawal or take out more then what is in your account...\n"
						+ "Please try again....");
				String moveFwd = in.nextLine();
			}
			
			welcome(c);
		} catch (SQLException e) 
		{
			System.out.println("error making withdrawal");
			e.printStackTrace();
		}		
			welcome(c);
			
			break;
			
		case "3":
			apply(c);
			welcome(c);
								
			break;
			
		case "4":
			System.out.println("Are you sure you want to cancel this account?"
					+ "\n[Y] YES"+ "\n[N] NO");
			choice = in.nextLine();
			
			if(choice.equalsIgnoreCase("y"))
			{
				//try 
				//{
					//if(adi.getBalanceById(num) == 0)
					//{
						adi.deleteAccount(num);
					//}else
					//{
					//	System.out.println("In order to cancel your account you must have a 0 balance ");
					//	String movefwd =in.nextLine();	
					//}
				//} catch (SQLException e) 
				//{
				//	e.printStackTrace();
				//}
			}
					
			welcome(c);
				
			break;
			
		case "0":
			mainMenu();
		    	 
			break;
		    	 
		default:
			System.out.println("PLease try again...");
			welcome(c);
				
			break;
		}
	}
	
	public static void welcome(Employee e) throws SQLException 	
	{
		displayLogo();		
		System.out.println("Hello, " + e.getfName() + " " + e.getlName());	
		
		System.out.println("\nPlease enter the customers email you want to work with...");
		System.out.println("Customer email: ");
		String email = in.nextLine();
		
		Customer c = new Customer(cdi.getCustomerByUserName(email));		
		
		if(c.getEmail().equalsIgnoreCase(null))
		{
			System.out.println("there was an issue with user id...");
			String fwd = in.nextLine();
			
			welcome(e);
		}		
		
		System.out.println("\n\nVerify the customers information:\n" + c.getfName() + " " + c.getlName() 
				+ "\n" + c.getZip() + "\nDid customer validate their name and zip?\n"
						+ "y for yes or n for no:\nVerfication Passed: ");
		choice = in.nextLine();
		
		if(choice.equalsIgnoreCase("y"))
		{
			System.out.println("\nPlease enter the account number that you"
				+ " wish to view or make changes in...\n ");
		
			AccountDaoImpl adi = new AccountDaoImpl();
			List<Account> acctList = new ArrayList<>();		
		
			acctList = adi.getAcctsByCustId(c.getId());
		
			for(int i = 0; i < acctList.size(); i++)
			{
				System.out.println("[" + acctList.get(i).getAcctId() + "]: " +
					acctList.get(i).getAcctType() + " " + 
					acctList.get(i).getBalance());
			}

			//get account number
			System.out.println("\n\naccount number: ");
			String acctNum = in.nextLine();
			int num = Integer.parseInt(acctNum);
		
			//display account page
			System.out.println("\n\nDate	 Deposit Witdrawal Balance" );
			System.out.println("-------------------------------------");
		
			//get list of transactions from database
			TransactionDaoImpl tdi = new TransactionDaoImpl();
		
			List<Transaction> transList = new ArrayList<>();		
			transList = tdi.getTransactions(num);		
		
			//display transactions		
			for(int i = 0; i < transList.size(); i++)
			{
				System.out.println("|11/" + transList.get(i).getId() + "/2020|" 
					+ transList.get(i).getDeposit() + "    "  
					+ "|" + transList.get(i).getWithdrawal() + "   " 
					+ "|" + transList.get(i).getBalance() + "|");					
			}
		
			System.out.println("\n\nPlease pick a Menu Option below:"
					+ "\n\t[1]: Make a deposit"
					+ "\n\t[2]: Make a withdrawal"
					+ "\n\t[3]: Create new account"
					+ "\n\t[4]: Cancel account"
					+ "\n\n\t[0]: Log Out");
			System.out.println("Menu Option: ");
			choice = in.nextLine();			
			
			switch(choice) 
			{
			case "1":
			
			try 
			{
				System.out.println("What is the amount you would like to depoist: ");
				String d = in.nextLine();
				double deposit = Double.parseDouble(d);
				
				Transaction t = new Transaction();
				double balance = adi.getBalanceById(num);
								
				double newBalance = t.checkAndMakeDeposit(deposit, balance);				
				
				if( newBalance > 0)
				{
					tdi.makeDeposit(deposit, newBalance, num);
					adi.updateBalance(newBalance, num);
				}else
				{
					System.out.println("an error has occured you can not enter a negative amount to deposit...\n"
							+ "Please try again....");
					String moveFwd = in.nextLine();
				}
				
				welcome(c);
			} catch (SQLException ex) 
			{
				ex.printStackTrace();
			}		
				
			break;
			
		case "2":
			
			try 
			{
				System.out.println("What is the amount you would like to withdrawal: ");
				String w = in.nextLine();
				double withdrawal = Double.parseDouble(w);
			
				Transaction t = new Transaction();
				double balance = adi.getBalanceById(num);
							
				double newBalance = t.checkAndMakeWithdrawal(withdrawal, balance);				
			
			if( newBalance > 0)
			{
				tdi.makeWithdrawal(withdrawal, newBalance, num);
				adi.updateBalance(newBalance, num);
			}else
			{
				System.out.println("an error has occured you can not enter a negative amount"
						+ " to witdrawal or take out more then what is in your account...\n"
						+ "Please try again....");
				String moveFwd = in.nextLine();
			}
			
			welcome(e);
		} catch (SQLException ex) 
		{
			System.out.println("error making withdrawal");
			ex.printStackTrace();
		}		
			welcome(e);
		
			
			break;
			
		case "3":
			apply(c);
			welcome(c);
								
			break;
			
		case "4":
			System.out.println("Are you sure you want to cancel this account?"
					+ "\n[Y] YES"+ "\n[N] NO");
			choice = in.nextLine();
			
			if(choice.equalsIgnoreCase("y"))
			{
				try 
				{
					if(adi.getBalanceById(num) == 0)
					{
						adi.deleteAccount(num);
					}else
					{
						System.out.println("In order to cancel your account you must have a 0 balance ");
						String movefwd =in.nextLine();	
					}
				} catch (SQLException ex) 
				{
					ex.printStackTrace();
				}
			}
					
			welcome(c);
				
			break;
			
		case "0":
			mainMenu();
		    	 
			break;
		    	 
		default:
			System.out.println("PLease try again...");
			welcome(c);
				
			break;
			}
			
		}else
		{
			welcome(e);
		}
	}
	
	//apply for new account
	public static void apply(Customer c)
	{
		displayLogo();

		System.out.println("Hello, " + c.getfName() + " " + c.getlName());
		
		System.out.println("Please enter the information below to apply for another account.");
					
		System.out.print("Would you like to create a checking or savings account today?"
					+ "\nPlease enter c for checking and s for savings: ");
		String account = in.nextLine();
			
		if(account.equalsIgnoreCase("c"))
		{
			System.out.println("\n\nThank you, " + c.getfName() + " " + c.getlName() +
						"we appreciate your business your checking account is ready.\n"
						+ "If you would like to make a deposit into your new checking account"
						+ " please log in to get started...\nHave a great day!");
		}else if(account.equalsIgnoreCase("s"))
		{
			System.out.println("\n\nThank you, " + c.getfName() + " " + c.getlName() +
						"we appreciate your business your savings account is ready.\n"
						+ "If you would like to make a deposit into your new checking account"
						+ " please log in to get started...\nHave a great day!");
		}else
		{
			System.out.println("im sorry an error has occured please re-enter your information....");
				apply(c);
		}			
						
		System.out.println("Please verify the information if everything is corret and you are ready to "
					+ "go back to the main menu press b for back.\nIf you see any issues or want to change any"
					+ " information press r to refresh and re-apply");
		choice = in.nextLine();
			
		if(choice.equalsIgnoreCase("b"))
		{
				AccountDaoImpl adi = new AccountDaoImpl();
				
				adi.addAccount(c.getId(), account);
				mainMenu();
		}else if(choice.equalsIgnoreCase("r"))
		{
			apply(c);
		}
	}
	
	public static void displayLogo()
	{
		//ui				
		System.out.println("\n\n");
		System.out.println("\t\t\t\t************************");
		System.out.println("\t\t\t\t* Thriving Banking App *");
		System.out.println("\t\t\t\t*\t\t       *");
		System.out.println("\t\t\t\t************************");
		System.out.println("\n\n");
	}
		
}