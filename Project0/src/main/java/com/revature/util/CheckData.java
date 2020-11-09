package com.revature.util;

import com.revature.bean.User;

public class CheckData 
{
	public boolean checkPassword(String pw, User u)
	{
		if(pw.equals(u.getPassword()))
		{
			return true;
		}
		else
		{
			return false;
		}		
	}
	
	public static boolean checkForNull(String s)
	{
		if(s.isBlank() || s.isEmpty())
		{
			return false;
		}
		
		return true;
	}
	
	
}
