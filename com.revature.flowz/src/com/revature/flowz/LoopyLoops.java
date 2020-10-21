package com.revature.flowz;

public class LoopyLoops {

	public static void main(String[] args)
	{
		String userId, userId2;
		userId = "pmaurer";
		userId2 = "tmaurer";	
		
		ifMethod(userId, userId2);
		
		switchStatements("purple");
		
		floops();

	}
	
	//call inside method make static to put in main without calling
	//belongs to class
	public static void ifMethod(String a, String b)
	{
		if(a.equalsIgnoreCase(b)) {
			System.out.println("true");
		}
		else if(a.equalsIgnoreCase("pmaurer"))
		{
			System.out.println("user name is correct");
		}
		else
		{
			System.out.println("false");
		}
	}
	
	public static void switchStatements(String color)
	{
		switch(color)
		{
		case "green":
			System.out.println("green");
			break;
		case "blue":
			System.out.println("blue");
			break;
		case "black":
			System.out.println("black");
			break;
		default:
			System.out.println("thats not a color option");
		
		}
	}
	
	//iterating
	public static void floops()
	{
		for(int x = 0; x < 5; x++)
		{
			System.out.println("going for the " + x + " time");
		}
	}

}
