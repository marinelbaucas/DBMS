package projectpackage;

import java.util.*;
import java.sql.*;

public class UpdateeProduct {

	public static void main(String[] args) {

		Scanner kbd = new Scanner(System.in);
//		System.out.println("****************************");
//		System.out.println("Enter product name: ");
//			String pName = kbd.nextLine();
//		System.out.println("Enter product description: ");
//			String desc = kbd.nextLine();
//		System.out.println("Enter product quantity: ");
//			int qty = kbd.nextInt();
//		System.out.println("****************************");
//
//		System.out.println("Enter the product code to be edited: ");
//			int pCode = kbd.nextInt();
//
//		System.out.println("===================================");
//
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

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/order_system?autoReconnect=true&useSSL=false", "root","");
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String stSel = "SELECT * FROM product";
			ResultSet rs = stmt.executeQuery(stSel);

    		switch (choice) {
        	case 1:
//        		rs.beforeFirst();
//                System.out.printf("%2s %10s %21s %26s", "product code", "product name", "description", "quantity\n");
//
//                while (rs.next()){
//                    int prodCode = rs.getInt(1);
//                    String prodName = rs.getString("title");
//                    String desc = rs.getString("duration");
//                    int qty = rs.getInt("album_no");
//
//                    System.out.printf("%-10d %-20s %25s %-15s\n", prodCode,
//                        prodName, desc, qty);
//                        kbd.close();
//                }
        		 System.out.println("Column Number: ");
                 int columnNumber = kbd.nextInt();
                 System.out.println("Row Number: ");
                 int rowNumber = kbd.nextInt();
                 String originalContent = kbd.nextLine();
                 System.out.println("New Content: ");
                 String newContent = kbd.nextLine();
                 rs.first();
                 rs.updateString(columnNumber, originalContent); //Select the row
                 rs.absolute(rowNumber); //Change the number to the corresponding row
                 rs.updateString(columnNumber, newContent); //Change the selected row
                 rs.updateRow();

        		 //insert update query
        		 //UPDATE product set product_name = 'asdkad' where product_code = 2; ==sample
        		break;
        	case 2:
        		System.out.println("Enter new product description: ");
       		 		String newPdesc = kbd.nextLine();
       		 	
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
