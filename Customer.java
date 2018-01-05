/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;

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
public class Customer {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
       
        boolean rpt = true;
        while(rpt){
        Scanner kbd = new Scanner (System.in);
        System.out.println("Choose what to execute:");
        System.out.println("-------------------------------------");
        System.out.println("1.Create Customer");
        System.out.println("2.Retrieve Customer");
        System.out.println("3.Update Customer");
        System.out.println("4.Delete Customer");
        System.out.println("5.Exit");
        System.out.println("-------------------------------------");
        
        
        int choice = kbd.nextInt();
        switch(choice){
            case 1: createCustomer() ; 
                    break ;
            case 2: retrieveCustomer(); 
                    break;
            case 3: updateCustomer(); 
                    break ;
            case 4: deleteCustomer(); 
                    break;
            case 5: System.exit(0); 
                    break;
            
            default: 
                System.out.println("Please enter a valid command");
        }
       }    
   }   
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

        } catch (SQLException e) {
            
        }
} //end of createCustomer
    
    
   
    //Retrieve Customer
    public static void retrieveCustomer() {        
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/order_system?autoReconnect=true&useSSL=false", "root","");      
            Statement st = conn.createStatement ();
     
       String strSelect = "select * from customer";
       System.out.println("The SQL query is: " + strSelect); // Echo For debugging
       System.out.println();
            
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
            
            System.out.println(customer_Id + ", " + last_name + ", " + first_name + ", " + address + "," + phone_num);
            ++rowCount;
            System.out.println();
         }
         System.out.println("Total number of records = " + rowCount);
         System.out.println();
       
       
         } catch(SQLException ex) {
      }
  } //End of Retrieve method.
       
    
    
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
         
    } catch (SQLException e) {
           
        }
    
    }//end of updateCustomer
    
    
    
    public static void deleteCustomer() {
   
    Scanner kbd = new Scanner (System.in);
    System.out.print("Enter the product code you want to delete: " );
    String customerID = kbd.nextLine();
        
    try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/order_system?autoReconnect=true&useSSL=false", "root","");
        Statement st = conn.createStatement ();         
       
        String sqlDelete = ("delete from customer where customer_id = " + customerID);
         st.executeUpdate(sqlDelete);
         
    } catch (SQLException e) {
    
        }
    }
    
}

   

    
    
    
    


