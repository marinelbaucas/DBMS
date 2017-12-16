import java.util.*;
import java.sql.*;

public class UpdateeProduct {

	public static void main(String[] args) {

		Scanner kbd = new Scanner(System.in);
		System.out.println("****************************");
		System.out.println("Enter product name: ");
			String pName = kbd.nextLine();
		System.out.println("Enter product description: ");
			String desc = kbd.nextLine();
		System.out.println("Enter product quantity: ");
			int qty = kbd.nextInt();
		System.out.println("****************************");

		System.out.println("Enter the product code to be edited: ");
			int pCode = kbd.nextInt();

		System.out.println("===================================");

		int choice = 0;

		do {

			System.out.println("        Choose what to update      ");
            System.out.println("===================================");
            System.out.println("* 1. Product Name                 *");
            System.out.println("* 2. Product Description          *");
            System.out.println("* 3. Product Quantity             *");
            System.out.println("* 4. Cancel Update                *");
            System.out.println("===================================");
            System.out.print("Please enter your choice:            ");
            choice = kbd.nextInt();

			try {

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/order_item?autoReconnect=true&useSSL=false", "root","");
            Statement st = conn.updateProduct();

    		switch (choice) {
        	case 1:
        		System.out.println("Enter new product name: ");
        		 String newPname = kbd.nextLine();

        		 //insert update query
        		 //UPDATE product set product_name = 'asdkad' where product_code = 2; ==sample
        		break;
        	case 2:
        		System.out.println("Enter new product description: ");
       		 		String newPdesc = kbd.nextLine();
       		 	try {
       		        
       	         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/order_system?autoReconnect=true&useSSL=false", "root","");      
       	            Statement st = conn.createStatement ();
       	 

       	      }
       	       {
       	         
       	         String strUpdate = "";
       	         System.out.println("The SQL query is: " + strUpdate);  // Echo for debugging
       	         int countUpdated = stmt.executeUpdate(strUpdate);
       	      
       	 
       	        
       	         String strSelect = "select * from customer";
       	         System.out.println("The SQL query is: " + strSelect);  // Echo for debugging
       	         
       	         ResultSet rset = stmt.executeQuery(strSelect);
       	         while(rset.next()) {   // Move the cursor to the next row
       	           String customer_Id = rset.getString("customer_id");
       	            String last_name = rset.getString("last_name");
       	            String first_name   = rset.getString("first_name");
       	            String address    = rset.getString("address");
       	            String phone_num  = rset.getString("phone_num");

       	            System.out.println(customer_Id + ", " + last_name + ", " + first_name + ", " + address + "," + phone_num);
       	            ++rowCount;
       	         }
       	      } catch(SQLException ex) {
        		break;
        	case 3:
        		System.out.println("Enter new product quantity: ");
        		int newPqty = kbd.nextInt();
//insert upadte query
        		break;

        	case 5:
        		System.exit(0);
        		break;
    	}

            try {

            	choice = Integer.parseInt(kbd.nextLine());

            } catch (Exception e) {

            	System.out.println("error: input a valid value...");
            	System.out.print("Press enter key to continue...");
            	kbd.nextLine();

            }

        	System.out.println();

    	} catch (SQLException e){
			System.out.println("cant connect sql.");



		}
		}while (choice < 1 || choice > 4);

	}

}
