package com.revature.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.revature.bean.Admin;
import com.revature.bean.Customer;
import com.revature.bean.Employee;
import com.revature.bean.TempUser;
import com.revature.bean.User;

public class Data 
{
	public static final String customerFile="customerList.txt";
	public static final String tempUserFile="tempUserList.txt";
	public static final String emplUserFile="emplUserList.txt";
	public static final String adminUserFile="adminUserList.txt";
	//ObjectOutputStream out; do i want to change out to static??
	
	//write method
	public static void writeTempUserData(List<TempUser>tUList)
	{
		try 
		{
			ObjectOutputStream out;
			out = new ObjectOutputStream(new FileOutputStream(tempUserFile));
			out.writeObject(tUList);
			out.close();			
		} catch (IOException e) 
		{
			e.printStackTrace();
		}	
	}
	
	//read method
	public static void readTempUserData()
	{
		try
		{
			ObjectInputStream in;
			in = new ObjectInputStream(new FileInputStream(tempUserFile));
			Roster.tempUserList=(List<TempUser>)in.readObject();//why is this using list??
		}catch (IOException | ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	
	//write method
	public static void writeEmployeeAdminData(List<Admin>aUList)
	{
		try 
		{
			ObjectOutputStream out;
			out = new ObjectOutputStream(new FileOutputStream(adminUserFile));
			out.writeObject(aUList);
			out.close();			
		} catch (IOException e) 
		{
			e.printStackTrace();
		}	
	}
						
	//read method		
	public static void readEmployeeAdminData()
	{
		try
		{
			ObjectInputStream in;
			in = new ObjectInputStream(new FileInputStream(adminUserFile));
			Roster.adminUserList=(List<Admin>)in.readObject();//why is this using list??
		}catch (IOException | ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
			
	//write method
	public static void writeCustomerData(List<Customer>custList)
	{
		try 
		{
			ObjectOutputStream out;
			out = new ObjectOutputStream(new FileOutputStream(customerFile));
			out.writeObject(custList);
			out.close();			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}		
	}
	
	//read method
	public static void readCustomerData()
	{
		try
		{
			ObjectInputStream in;
			in = new ObjectInputStream(new FileInputStream(customerFile));
			Roster.customerList=(List<Customer>)in.readObject();
		}
		catch (IOException | ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	
	
		
	
	
	//write method
		public static void writeEmployeeData(List<Employee>eUList)
		{
			try 
			{
				ObjectOutputStream out;
				out = new ObjectOutputStream(new FileOutputStream(emplUserFile));
				out.writeObject(eUList);
				out.close();			
			} catch (IOException e) 
			{
				e.printStackTrace();
			}	
		}
			
		//read method
		public static void readEmployeeData()
		{
			try
			{
				ObjectInputStream in;
				in = new ObjectInputStream(new FileInputStream(emplUserFile));
				Roster.emplUserList=(List<Employee>)in.readObject();//why is this using list??
			}catch (IOException | ClassNotFoundException e) 
			{
				e.printStackTrace();
			}
		}
		
		
}