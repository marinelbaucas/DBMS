package createcustomer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTest {  
   public static void main(String[] args) {
      try (
        
         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/order_system?autoReconnect=true&useSSL=false", "root","");      
            Statement st = conn.createStatement ();
 

      ) 
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

      }