package projectpackage;

import java.awt.color.CMMException;
//import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.Scanner;
//import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class MainMenu{
	
	public static DBconnection con;
	public static Scanner kbd = new Scanner(System.in);
	public static CustomerMenu cm = new CustomerMenu();
	public static OrderMenu om = new OrderMenu();
	public static ProductMenu pm = new ProductMenu();
	
	public static void main (String[] args){
		mainMenu();
	}
	
	public static void processChoice(int menuOptions) {
    	switch (menuOptions) {
	    	case 1:
	    		cm.customerMenu();
	    		break;
	    	case 2:
	    		pm.productMenu();
	    		break;
	    	case 3:
	    		//
	    		break;
	    	case 4: 
	    		System.exit(0);
	    		break;
    	}
    }

	public static int mainMenu(){
    	int choice = 0;
		do {
			
    		System.out.println("**********************");
            System.out.println("*   M A I N M E N U  *");
            System.out.println("======================");
            System.out.println("* 1. Customer Menu   *");
            System.out.println("* 2. Product Menu    *");
            System.out.println("* 3. Order Menu      *");
            System.out.println("* 4. Exit main menu  *");
            System.out.println("**********************");
            System.out.print("Please enter your choice: ");
            
            try {
            	
            	choice = Integer.parseInt(kbd.nextLine());
            	processChoice(choice);
            	
            } catch (Exception e) {
            	
            	System.out.println("error: input a valid value...");
            	System.out.print("Press enter key to continue...");
            	kbd.nextLine();
            	
            }
            
        	System.out.println();
        	
    	} while (choice < 1 || choice > 5);
		
        return choice;
	}
	

}
