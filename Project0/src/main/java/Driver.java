import java.util.Scanner;

public class Driver 
{
	public static void main(String[] args) {
		
	
	Scanner in = new Scanner(System.in);	
	
	System.out.print("Enter your name: ");
	String name = in.nextLine();
	
	System.out.println("Name is: " + name);
	Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    System.out.println("Enter username");

    String userName = myObj.nextLine();  // Read user input
    System.out.println("Username is: " + userName);  // Output user input
	}

}
