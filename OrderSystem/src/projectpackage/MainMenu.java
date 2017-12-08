package projectpackage;

//import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.Scanner;
//import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class MainMenu{
	
	public static DBconnection con;
	public static Scanner kbd = new Scanner(System.in);
	
	public static void main (String[] args){
		
	}
	
	public static void processChoice(int menuOptions) {
    	switch (menuOptions) {
	    	case 1: // go to customer menu

	    		break;
	    	case 2: // go to product menu
//	    		productMenu();
	    		break;
	    	case 3: // go to order menu

	    		break;
	    	case 4: // Exit the product menu option or exit program na??
	    		break;
	    	case 5: 
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
            System.out.println("* 5. Exit main menu  *");
            System.out.println("**********************");
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
	

}
