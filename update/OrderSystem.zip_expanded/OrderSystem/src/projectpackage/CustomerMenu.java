package projectpackage;


import java.sql.*;
import java.util.Scanner;



public class CustomerMenu {    
		
		public static Scanner kb= new Scanner(System.in);
		
	    public void processChoice(int menuOptions) {
	    	switch (menuOptions) {
		    	case 1: // Create customer
		    		createCustomer();
		    		break;
		    	case 2: // View Customer
		    		viewCustomer();    		
		    		break;
		    	case 3://delete customer
		    		deleteCustomer();
		    		break;
		    	case 4: // Edit Customer
		    		editCustomer();
		    		break;
		    	case 5: //exit
		    		System.exit(0);
	    	}
	    }
	    
	    public static int customerMenu(){
	    int choice = 0;
			do {
	    		System.out.println("+----------------------------+");
	            System.out.println("|   M E N U  O P T I O N S   |");
	            System.out.println("+----------------------------+");
	            System.out.println("| 1. Create Customer         |");
	            System.out.println("| 2. View Customer           |");
	            System.out.println("| 3. Delete Customer         |");
	            System.out.println("| 4. Edit Customer		     |");
	            System.out.println("| 5. Exit program            |");
	            System.out.println("+----------------------------+");
	            System.out.print("Enter your choice: ");
	            try {
	            	choice = Integer.parseInt(kb.nextLine());
	            } catch (Exception e) {
	            	System.out.println("error: input a valid value...");
	            	System.out.print("Press enter key to continue...");
	            	kb.nextLine();
	            }
	        	System.out.println();
	    	} while (choice < 1 || choice > 5);
	        return choice;
	    }
	          
	    public static void createCustomer() {
	    	
	    }
	    
	    public static void viewCustomer() {
	    	
	    }
	    
	    public static void deleteCustomer() {
	    	try { 
	    			String myDriver = "org.gjt.mm.mysql.Driver";
	    			  String myUrl = "jdbc:mysql://localhost/order_system";
	    			  Class.forName(myDriver);
	    			  Connection conn = DriverManager.getConnection(myUrl, "root", "");
	    					    	
	    		     
	    		      // create the mysql delete statement
	    			String sql="DELETE FROM customer WHERE customer_id = ?";
	    			PreparedStatement preparedStmt = conn.prepareStatement(sql);
				    // execute the preparedstatement
				        preparedStmt.execute();
				        
				        conn.close();
	      }
	      catch (Exception e)
	      {
	        System.err.println("Got an exception! ");
	        System.err.println(e.getMessage());
	      }
	    }
	    public static void editCustomer() {
	    	
	    	
	    	
	    }
	    
}