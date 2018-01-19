/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordersystem;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author MelChoco
 */
public class OrderSystem {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
       
        boolean rpt = true;
        while(rpt){
        Scanner kbd = new Scanner (System.in);
        System.out.println("Choose what to execute:");
        System.out.println("-------------------------------------");
        System.out.println("1.Product");
        System.out.println("2.Customer");
        System.out.println("3.Order");
        System.out.println("4.Retrieve the List of Customers who purchased a specific product");
        System.out.println("5.Retrieve Orders from a Specific Date");
        System.out.println("6.Search)");
        System.out.println("7.Exit");
        System.out.println("-------------------------------------");
        
        
        int choice = kbd.nextInt();
        switch(choice){
            case 1: 
                    System.out.println("1.Create Product");
                    System.out.println("2.Retrieve Product");
                    System.out.println("3.Update Product");
                    System.out.println("4.Delete Product");
                    System.out.println("5.Exit");
                    System.out.println("-------------------------------------");
                    int choice1 = kbd.nextInt();
                    switch(choice1){
                        case 1: createProduct();
                            break;
                        case 2: retrieveProduct();
                            break;
                        case 3: updateProduct();
                            break;    
                        case 4: deleteProduct();
                            break;
                        case 5: System.exit(0);
                            break;
                        default: 
                            System.out.println("Please enter a valid command");
                    } break;             
                   
            case 2: 
                    System.out.println("1.Create Customer");
                    System.out.println("2.Retrieve Customer");
                    System.out.println("3.Update Customer");
                    System.out.println("4.Delete Customer");
                    System.out.println("5.Exit");
                    System.out.println("-------------------------------------");
                    int choice2 = kbd.nextInt();
                    switch(choice2){
                        case 1: createCustomer();
                            break;
                        case 2: retrieveCustomer();
                            break;
                        case 3: updateCustomer();
                            break;    
                        case 4: deleteCustomer();
                            break;
                        case 5: System.exit(0);
                            break;
                        default: 
                            System.out.println("Please enter a valid command");
                    } break;             
            case 3: System.out.println("1.Create Order");
                    System.out.println("2.Retrieve Order");
                    System.out.println("3.Delete Order");
                    System.out.println("4.Exit");
                    System.out.println("-------------------------------------");
                    int choice3 = kbd.nextInt();
                    switch(choice3){
                        case 1: createOrder();
                            break;
                        case 2: retrieveOrder();
                            break; 
                        case 3: deleteOrder();
                            break;
                        case 4: System.exit(0);
                            break;
                        default: 
                            System.out.println("Please enter a valid command");
                    } break;
            case 4: retrieveListProduct();
                    break;
            case 5: retrieveOrderFromTo();
                    break;
            case 6: searchCustomer();
                    break;
            case 7: System.exit(0); 
                    break;
            
            default: 
                System.out.println("Please enter a valid command");
        }
       }    
   }
   
    private static java.sql.Date getCurrentDate() {
    java.util.Date today = new java.util.Date();
    return new java.sql.Date(today.getTime());
   }
   
   //Retrieve Customer
    public static void searchCustomer() {     
    	
    	System.out.println("Search for?");
    	System.out.println("-------------------------------------");
    	System.out.println("1. Customer");
    	System.out.println("2. Product");
    	System.out.println("3. Exit");
    	System.out.println("-------------------------------------");
    	Scanner kbd = new Scanner(System.in);
   		int choice = kbd.nextInt();
        switch(choice){
            case 1: 
                    System.out.println("Enter First Name or Last Name");
                    System.out.println("-------------------------------------");
                    String a = kbd.next();
                    
                    try {
				       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/order_system?autoReconnect=true&useSSL=false", "root","");      
				       Statement st = conn.createStatement ();
				       System.out.println("-------------------------------------");
				       String strSelect = "select * from customer join product WHERE first_name LIKE '" + a + "%' OR last_name LIKE '" + a + "%'";
				       System.out.println("Searching for: " + a); // Echo For debugging
				       System.out.println();
				            
				       ResultSet rset = st.executeQuery(strSelect);
				            
				        System.out.println("The results are:");
				        System.out.println();
				         int rowCount = 0;
				         
				         while(rset.next()) {   // Move the cursor to the next row, return false if no more row
				            String customer_Id = rset.getString("customer_id");
				            String last_name   = rset.getString("last_name");
				            String first_name  = rset.getString("first_name");
				            String address     = rset.getString("address");
				            String phone_num   = rset.getString("phone_num");				           
				            
				            System.out.print(" -------- \n Customer ID: " +customer_Id + "\n Customer Name: " + last_name + ", " + first_name + "\n Customer Address: " + address + "\n Phone Number: " + phone_num + "\n --------");
				            ++rowCount;
				            System.out.println();
				         }
				         System.out.println("Total number of records = " + rowCount);
				         System.out.println();
				       
				       
				         } catch(SQLException ex) {
				             System.out.print("Failed to search customer\n" + ex.toString());
				      }
                    
                    break;
                   
            case 2: 
                    System.out.println("Enter Product Name");
                    System.out.println("-------------------------------------");
                    String aa = kbd.next();
                    
                    try {
				       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/order_system?autoReconnect=true&useSSL=false", "root","");      
				       Statement st = conn.createStatement ();
				       System.out.println("-------------------------------------");
				       String strSelect = "select * from customer join product WHERE first_name LIKE '" + aa + "%";
				       System.out.println("Searching for: " + aa); // Echo For debugging
				       System.out.println();
				            
				       ResultSet rset = st.executeQuery(strSelect);
				            
				        System.out.println("The results are:");
				        System.out.println();
				         int rowCount = 0;
				         
				         while(rset.next()) {   // Move the cursor to the next row, return false if no more row
				            String customer_Id = rset.getString("customer_id");
				            String last_name   = rset.getString("last_name");
				            String first_name  = rset.getString("first_name");
				            String address     = rset.getString("address");
				            String phone_num   = rset.getString("phone_num");
				            
				            String product_code = rset.getString("product_code");
				            String product_name   = rset.getString("product_name");
				            String description  = rset.getString("description");
				            
				            System.out.print(customer_Id + ", " + last_name + ", " + first_name + ", " + address + "," + phone_num + "," + product_code + "," + "," + product_name + "," + "," + description + ",");
				            ++rowCount;
				            System.out.println();
				         }
				         System.out.println("Total number of records = " + rowCount);
				         System.out.println();
				       
				       
				         } catch(SQLException ex) {
				             System.out.print("Failed to search customer\n" + ex.toString());
				      }
                    
            case 3: System.exit(0); 
                    break;
            
            default: 
                System.out.println("Please enter a valid command");
        }
       }   
    
    	
    	
    	   
        
   //End of retrieveCustomer method.
       
    //Create Customer
      public static void createCustomer() {
   
        Scanner kbd = new Scanner (System.in);
 
        System.out.println("Enter your Last Name: ");
        String lastN = kbd.nextLine();
        System.out.println("Enter your First Name: ");
        String firstN = kbd.nextLine();
        System.out.println("Enter your Address: ");
        String adds = kbd.nextLine();
        System.out.println("Enter your Contact Number: ");
        String phoneN = kbd.nextLine();
        try {     
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/order_system?autoReconnect=true&useSSL=false", "root","");      
           
            String query = "insert into customer (last_name, first_name, address, phone_num) " +  "values (?,?,?,?);";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, lastN);
            st.setString(2, firstN);
            st.setString(3, adds);
            st.setString(4, phoneN);
            st.addBatch();
            st.executeBatch();
            System.out.print("Customer have been successfully created\n");
        } catch (SQLException e) {
            System.out.print("Failed to add customer\n");
        }
} //end of createCustomer
    
    public static void createProduct() {
        Scanner kbd = new Scanner (System.in);
 
        System.out.println("Enter your Product Name: ");
        String prodName = kbd.nextLine();
        System.out.println("Enter your description ");
        String prodDesc = kbd.nextLine();
        System.out.println("Enter your Add the Quantity");
        String prodQty = kbd.nextLine();
        try {     
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/order_system?autoReconnect=true&useSSL=false", "root","");      
           
            String query = "insert into product (product_name, description, quantityInStock) " +  "values (?,?,?);";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, prodName);
            st.setString(2, prodDesc);
            st.setString(3, prodQty);
            st.addBatch();
            st.executeBatch();
            System.out.print("Product have been successfully added\n");
        } catch (SQLException e) {
            System.out.print("Failed to add product\n");
        }// end of createProduct
    }   
    public static void createOrder() {
        Scanner kbd = new Scanner (System.in);
 
        System.out.println("Enter the Id of the customer ");
        String orderCust = kbd.nextLine();
        System.out.println("Enter the product code ");
        String orderProd = kbd.nextLine();
        System.out.println("Enter the quantity");
        String orderQty = kbd.nextLine();
        System.out.println("Enter the ordered date [2018-01-02]");
        String dateOrdered = kbd.nextLine();
        try {     
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/order_system?autoReconnect=true&useSSL=false", "root","");      
           
            String query = "insert into order_details (customer_id, product_code, quantityOrdered, dateOrdered) " +  "values (?,?,?,?);";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, orderCust);
            st.setString(2, orderProd);
            st.setString(3, orderQty);
            st.setString(4, dateOrdered);
            st.addBatch();
            st.executeBatch();
            System.out.print("Order have been successfully added\n");
        } catch (SQLException e) {
            System.out.print("Failed to add order\n");
        }
    }   // end of createOrder
    
    
    
    
    
    
 //Retrieve Customer
    public static void retrieveCustomer() {        
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/order_system?autoReconnect=true&useSSL=false", "root","");      
            Statement st = conn.createStatement ();
       System.out.println("-------------------------------------");
       String strSelect = "select * from customer";
       //System.out.println("The SQL query is: " + strSelect); // Echo For debugging
       //System.out.println();
            
       ResultSet rset = st.executeQuery(strSelect);
            
        System.out.println("The records selected are:");
        System.out.println();
         int rowCount = 0;
         while(rset.next()) {   // Move the cursor to the next row, return false if no more row
            String customer_Id = rset.getString("customer_id");
            String last_name   = rset.getString("last_name");
            String first_name  = rset.getString("first_name");
            String address     = rset.getString("address");
            String phone_num   = rset.getString("phone_num");
            
            System.out.print(" -------- \n Customer ID: " +customer_Id + "\n Customer Name: " + last_name + ", " + first_name + "\n Customer Address: " + address + "\n Phone Number: " + phone_num + "\n --------");
            ++rowCount;
            System.out.println();
         }
         System.out.println("Total number of records = " + rowCount);
         System.out.println();
       
       
         } catch(SQLException ex) {
             System.out.print("Failed to retrieve customer\n");
      }
  } //End of retrieveCustomer method.
       
 
    
     //Retrieve Product
    public static void retrieveProduct() {        
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/order_system?autoReconnect=true&useSSL=false", "root","");      
            Statement st = conn.createStatement ();
       System.out.println("-------------------------------------");
       String strSelect = "select * from product";
       //System.out.println("The SQL query is: " + strSelect); // Echo For debugging
       //System.out.println();
            
       ResultSet rset = st.executeQuery(strSelect);
            
        System.out.println("The records selected are:");
        System.out.println();
         int rowCount = 0;
         while(rset.next()) {   // Move the cursor to the next row, return false if no more row
            String product_code = rset.getString("product_code");
            String product_name   = rset.getString("product_name");
            String description  = rset.getString("description");
            String quantityInStock     = rset.getString("quantityInStock");
   
            
            System.out.print(" ---------- \n Product Code: " + product_code + "\n Product Name: " + product_name  + "\n Product Description: " + description + "\n Quantity in Stock: " + quantityInStock + "\n --------");
            ++rowCount;
            System.out.println();
         }
         System.out.println("Total number of records = " + rowCount);
         System.out.println();
       
       
         } catch(SQLException ex) {
             System.out.print("Failed to retrieve product\n");
      }
  } //End of retrieveProduct method.
       
    
    
    
    
     //Retrieve Order
    public static void retrieveOrder() {        
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/order_system?autoReconnect=true&useSSL=false", "root","");      
            Statement st = conn.createStatement ();
       System.out.println("-------------------------------------");
       String strSelect = "SELECT * from order_details";
       //System.out.println("The SQL query is: " + strSelect); // Echo For debugging
       //System.out.println();
            
       ResultSet rset = st.executeQuery(strSelect);
            
        System.out.println("The records selected are:");
        System.out.println();
         int rowCount = 0;
         while(rset.next()) {   // Move the cursor to the next row, return false if no more row
            String order_dID = rset.getString("order_dID");
            String customer_id   = rset.getString("customer_id");
            String product_code  = rset.getString("product_code");
            String quantityOrdered     = rset.getString("quantityOrdered");
            String dateOrdered     = rset.getString("dateOrdered");   
                      
            System.out.print(" -------- \n Order ID: " + order_dID + "\n Customer ID: " + customer_id  + "\n Product Code: " + product_code + "\n Quantity Ordered: " + quantityOrdered + "\n Date Ordered: " + dateOrdered + "\n --------");
            ++rowCount;
            System.out.println();
         }
         System.out.println("Total number of records = " + rowCount);
         System.out.println();
       
       
         } catch(SQLException ex) {
              System.out.print("Failed to retrieve order\n");
      }
  } //End of retrieveOrder method.
       
      public static void retrieveListProduct() {
        Scanner kbd = new Scanner(System.in);
        System.out.println("Enter the name of the product: ");
        String product = kbd.nextLine();
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/order_system?autoReconnect=true&useSSL=false", "root","");      
            Statement st = conn.createStatement ();
       System.out.println("-------------------------------------");
       String strSelect = "SELECT a.first_name, a.last_name, c.product_name, b.quantityOrdered FROM customer a JOIN order_details b JOIN product c ON a.customer_id = b.customer_ID AND b.product_code = c.product_code WHERE product_name='"+product+"'";
       //System.out.println("The SQL query is: " + strSelect); // Echo For debugging
       //System.out.println();
            
       ResultSet rset = st.executeQuery(strSelect);
            
        System.out.println("The records selected are:");
        System.out.println();
         int rowCount = 0;
         while(rset.next()) {   // Move the cursor to the next row, return false if no more row
            String product_code = rset.getString("first_name");
            String product_name   = rset.getString("last_name");
            String description  = rset.getString("product_name");
            String quantityInStock     = rset.getString("quantityOrdered");
   
            
            System.out.print(" ------------- \n Customer Name: " + product_code + " " + product_name  + "\n Product Ordered: " + description + "\n Quantity Ordered: " + quantityInStock + "\n -------------");
            ++rowCount;
            System.out.println();
         }
         System.out.println("Total number of records = " + rowCount);
         System.out.println();
       
       
         } catch(SQLException ex) {
              System.out.print("Failed to retrieve list of products purchased\n");
      }
  } //End of retrieveProduct method.  
    public static void retrieveOrderFromTo() {
        Scanner kbd = new Scanner(System.in);  
        System.out.print("Enter a date(e.g: YYYY-MM-DD)\n");
       System.out.print("From: ");
       String date1 = kbd.next();
       System.out.print("To: ");
       String date2 = kbd.next();
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/order_system?autoReconnect=true&useSSL=false", "root","");      
            Statement st = conn.createStatement ();
       
       System.out.println("-------------------------------------");
       String strSelect = "SELECT * from order_details where dateOrdered BETWEEN '"+date1+"' AND '"+date2+"' ";
       //System.out.println("The SQL query is: " + strSelect); // Echo For debugging
       //System.out.println();
            
       ResultSet rset = st.executeQuery(strSelect);
            
        System.out.println("The records selected are:");
        System.out.println();
         int rowCount = 0;
         while(rset.next()) {   // Move the cursor to the next row, return false if no more row
            String order_dID = rset.getString("order_dID");
            String customer_id   = rset.getString("customer_id");
            String product_code  = rset.getString("product_code");
            String quantityOrdered     = rset.getString("quantityOrdered");
            String dateOrdered     = rset.getString("dateOrdered");   
                      
            System.out.print(" -------- \n Order ID: " + order_dID + "\n Customer ID: " + customer_id  + "\n Product Code: " + product_code + "\n Quantity Ordered: " + quantityOrdered + "\n Date Ordered: " + dateOrdered +"\n --------");
            ++rowCount;
            System.out.println();
         }
         } catch(SQLException ex) {
              System.out.print("Failed to retrieve order\n");
      }
  } //End of retrieveOrder method.
       
   //updateCustomer 
    public static void updateCustomer() {
      Scanner kbd = new Scanner (System.in);
 
        System.out.println("Enter the ID of the customer you want to update: ");
        String customerID = kbd.nextLine();
        System.out.println("Enter your Last Name: ");
        String lastN = kbd.nextLine();
        System.out.println("Enter your First Name: ");
        String firstN = kbd.nextLine();
        System.out.println("Enter your Address: ");
        String addrs = kbd.nextLine();
        System.out.println("Enter your Contact Number: ");
        String phoneN = kbd.nextLine();
     
        try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/order_system?autoReconnect=true&useSSL=false", "root","");
        Statement st = conn.createStatement ();         
       
        String sqlUpdate = "update customer set last_name ='"+lastN+"',first_name = '"+firstN+"',address ='"+addrs+"',phone_num ='"+phoneN+ "' where customer_id='" + customerID+"'";
        st.executeUpdate(sqlUpdate);
          System.out.print("Customer have been successfully updated\n");
    } catch (SQLException e) {
           System.out.print("Failed to update customer\n");
        }
    }//end of updateCustomer
    
    
    
    
    
    //updateProduct
    public static void updateProduct() {
      Scanner kbd = new Scanner (System.in);
 
        System.out.println("Enter the ID of the Product you want to update: ");
        String product_code = kbd.nextLine();
        System.out.println("Enter the Product name: ");
        String product_name = kbd.nextLine();
        System.out.println("Enter the Description: ");
        String description = kbd.nextLine();
        System.out.println("Enter the Quantity in stock: ");
        String quantityInStock = kbd.nextLine();
  
     
        try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/order_system?autoReconnect=true&useSSL=false", "root","");
        Statement st = conn.createStatement ();         
       
        String sqlUpdate = "update product set product_name ='"+product_name+"',description = '"+description+"',quantityInStock ='"+quantityInStock+"' where product_code='" + product_code+"'";
        st.executeUpdate(sqlUpdate);
         System.out.print("Product(s) have been successfully updated\n");
    } catch (SQLException e) {
           System.out.print("Failed to update product(s)\n");
        }
    }//end of updateProduct
    
    
    //delete Customer
    public static void deleteCustomer() {
   
    Scanner kbd = new Scanner (System.in);
    System.out.print("Enter the ID of the customer you want to delete: " );
    String customerID = kbd.nextLine();
        
    try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/order_system?autoReconnect=true&useSSL=false", "root","");
        Statement st = conn.createStatement ();         
       
        String sqlDelete = ("delete from customer where customer_id = " + customerID);
         st.executeUpdate(sqlDelete);
         System.out.print("Customer have been successfully deleted\n");
    } catch (SQLException e) {
            System.out.print("Failed to delete customer\n");
        }
    } //end of delete customer
    
    //delete Product
    public static void deleteProduct() {
   
    Scanner kbd = new Scanner (System.in);
    System.out.print("Enter the product code you want to delete: " );
    String product_code = kbd.nextLine();
        
    try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/order_system?autoReconnect=true&useSSL=false", "root","");
        Statement st = conn.createStatement ();         
       
        String sqlDelete = ("delete from product where product_code = " + product_code);
         st.executeUpdate(sqlDelete);
         System.out.print("Product(s) have been successfully deleted\n");
    } catch (SQLException e) {
                System.out.print("Failed to delete product(s)\n");
        }
    } //end of delete Product
    
    
    
    //delete Order
    public static void deleteOrder() {
   
    Scanner kbd = new Scanner (System.in);
    System.out.print("Enter the order id of the order you want to delete: " );
    String order_dID = kbd.nextLine();
        
    try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/order_system?autoReconnect=true&useSSL=false", "root","");
        Statement st = conn.createStatement ();         
       
        String sqlDelete = ("delete from order_details where order_dID = " + order_dID);
         st.executeUpdate(sqlDelete);
         System.out.print("Order(s) have been successfully deleted\n");
    } catch (SQLException e) {
                System.out.print("Failed to delete order(s)\n");
        }
    } //end of delete Order
}