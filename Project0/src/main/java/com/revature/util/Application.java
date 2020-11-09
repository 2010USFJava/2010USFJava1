package com.revature.util;
/*shouldve used get class
 * tried to use get instance of
 */

import com.revature.bean.Admin;

public class Application 
{
	static {Data.readTempUserData();}
	static {Data.readEmployeeAdminData();}
	//static {Data.readEmployeeData();}
	static {Data.readCustomerData();}
	
	public static void main(String[] args) 
	{
		//Admin admin = new Admin("admin", "password", "Admin", "Istrator", "592334652", "A111565");
		
		
		//System.out.println(Roster.adminUserList.toString());
		//System.out.println(Roster.emplUserList.toString());
		//System.out.println(Roster.tempUserList.toString());

		
		Menu.start();
		//System.out.println(Roster.tempUserList.toString());
	}
}
