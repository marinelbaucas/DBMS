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
*/

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
   
    //    Scanner kbd = new Scanner (System.in);
   //     System.out.println("Enter your Last Name: ");
  //      String lastN = kbd.nextLine();
    //    System.out.println("Enter your Last Name: ");
    //    String firstN = kbd.nextLine();
   //     System.out.println("Enter your Address: ");
    //    int adds = kbd.nextInt();
        
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/order_system?autoReconnect=true&useSSL=false", "root","");      
            Statement st = conn.createStatement ();
            //String query = "insert into test " + "values('"+lastN+"','"+firstN+"','"+adds+"');";
           // st.executeUpdate(query);
     
       String strSelect = "select * from customer";
       System.out.println("The SQL query is: " + strSelect); // Echo For debugging
       System.out.println();
            
       ResultSet rset = st.executeQuery(strSelect);
            
        System.out.println("The records selected are:");
         int rowCount = 0;
         while(rset.next()) {   // Move the cursor to the next row, return false if no more row
            String customer_Id = rset.getString("customer_id");
            String last_name = rset.getString("last_name");
            String first_name   = rset.getString("first_name");
            String address    = rset.getString("address");
            String phone_num  = rset.getString("phone_num");
            
            System.out.println(customer_Id + ", " + last_name + ", " + first_name + ", " + address + "," + phone_num);
            ++rowCount;
         }
         System.out.println("Total number of records = " + rowCount);
       
       
         } catch(SQLException ex) {
      }
       
      
    }
    
}
