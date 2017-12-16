package createOrder;
import java.sql.*;
import java.util.*;

public class CreateOrder {
    public static void main(String[] args) {
   
        Scanner kbd = new Scanner (System.in);
            System.out.println("Enter Date: ");
            String order_date = kbd.nextLine();
            System.out.println("Enter Product Code: ");
            String product_code = kbd.nextLine();
        
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/order_item?autoReconnect=true&useSSL=false", "root","");      
            Statement st = conn.createStatement ();
            String query = "insert into order_item (order_date, product_code," + "values('"+order_date+"','"+product_code+");";
            st.executeUpdate(query);
            
     
        } catch (SQLException e){
        } 
       
      
    }
    
}
