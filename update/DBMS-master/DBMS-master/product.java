/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createcustomer;
import java.sql.*;
import java.util.*;

public class product {
        public static void main(String[] args) {
        Scanner kbd = new Scanner (System.in);
            System.out.println("Enter the product code: ");
            String product_code = kbd.nextLine();
            System.out.println("Enter the product name: ");
            String product_name = kbd.nextLine();
            System.out.println("Enter the description product: ");
            String description = kbd.nextLine();
            System.out.println("Enter the quantity in stock: ");
            int quantityInStock = kbd.nextInt();
        
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/order_system?autoReconnect=true&useSSL=false", "root","");      
            Statement st = conn.createStatement ();
            String query = "insert into product (product_name, description, quantityInStock) " + "values('"+product_name+"','"+description+"'.'"+quantityInStock+"');";
            st.executeUpdate(query);
            
     
        } catch (SQLException e){
        }  
}
}
