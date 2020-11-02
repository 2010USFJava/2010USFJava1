package com.revature.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Baby;

public class Data 
{
public static final String babyFile="babyList.txt";
	
	//write method
	public static void writeBabyData(List<Baby>bList)
	{
		try 
		{
			ObjectOutputStream objectOut;
			objectOut = new ObjectOutputStream(new FileOutputStream(babyFile));
			objectOut.writeObject(bList);
			objectOut.close();			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}		
	}
	
	//read method
	public static void readBabyData()
	{
		try
		{
			ObjectInputStream objectIn;
			objectIn = new ObjectInputStream(new FileInputStream(babyFile));
			Roster.babyList=(ArrayList<Baby>)objectIn.readObject();
		}
		catch (IOException | ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
}