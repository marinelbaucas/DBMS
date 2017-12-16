package projectpackage;

import java.sql.*;
import java.util.Scanner;
//import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class ProductMenu extends MainMenu{
	
	public ProductMenu(){
		
	}
	
	public static Scanner kbd = new Scanner(System.in);
	
	public static void processChoice(int menuOptions) {
    	switch (menuOptions) {
	    	case 1: // create product details
	    		createProduct();
	    		break;
	    	case 2: // Show product list
	    		viewProduct();
	    		break;
	    	case 3: // Delete a product from the list
	    		deleteProduct();
	    		break;
	    	case 4: // Edit product
	    		editProduct();
	    		break;
	    	case 5: // Exit the product menu option or exit program na??
	    		System.exit(0);
    	}
    }
	
	public static int productMenu() {    	
    	int choice = 0;
		do {
			
    		System.out.println("******************************");
            System.out.println("*    P R O D U C T M E N U   *");
            System.out.println("==============================");
            System.out.println("* 1. Enter product details   *");
            System.out.println("* 2. Show product list       *");
            System.out.println("* 3. Delete a product        *");
            System.out.println("* 4. Edit product details    *");
            System.out.println("* 5. Exit product menu       *");
            System.out.println("******************************");
            System.out.print("Please enter your choice: ");
            
            try {
            	
            	choice = Integer.parseInt(kbd.nextLine());
            	
            } catch (Exception e) {
            	
            	System.out.println("error: input a valid value...");
            	System.out.print("Press enter key to continue...");
            	kbd.nextLine();
            	
            }
            
        	System.out.println();
        	
    	} while (choice < 1 || choice > 5);
		
        return choice;
    }
	
	public static void createProduct(){
		
		try
		{
		  // create a java mysql database connection
		  String myDriver = "org.gjt.mm.mysql.Driver";
		  String myUrl = "jdbc:mysql://localhost/order_system";
		  Class.forName(myDriver);
		  Connection conn = DriverManager.getConnection(myUrl, "root", "");

		  // your prepstatements goes here...

		  conn.close();
		}
		catch (Exception e)
		{
		  System.err.println("Got an exception! ");
		  System.err.println(e.getMessage());
		}
		
		
	}
	
	public static void viewProduct(){
		
		
		
	}
	
	public static void deleteProduct(){
		
	}
	
	public static void editProduct(){
		
	}

}
