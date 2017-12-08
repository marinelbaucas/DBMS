/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 
package createcustomer;
import java.sql.*;
import java.util.*;
/**
 *
 * @author OJOJ YNEL DELA CRUZ
 */
public class CreateCustomer {
 //      private static final String USERNAME= "root";
    //   private static final String PASSWORD= "";
       
    public static void main(String[] args) {
   
        Scanner kbd = new Scanner (System.in);
        System.out.println("Enter your Last Name: ");
        String lastN = kbd.nextLine();
        System.out.println("Enter your First Name: ");
        String firstN = kbd.nextLine();
        System.out.println("Enter your Address: ");
        String adds = kbd.nextLine();
        System.out.println("Enter your Contact Number: ");
        int contact = kbd.nextInt();
        
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/order_system?autoReconnect=true&useSSL=false", "root","");      
            Statement st = conn.createStatement ();
            String query = "insert into customer" + "values('"+lastN+"','"+firstN+"','"+adds+"'.'"+contact+");";
            st.executeUpdate(query);
            
     
        } catch (SQLException e){
        }  
       
      
    }
    
}

