/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createcustomer;
import java.sql.*;
/**
 *
 * @author OJOJ YNEL DELA CRUZ
 */
public class CreateCustomer {
       private static final String USERNAME= "root";
       private static final String PASSWORD= "";
       private static final String path = "jdbc:mysql://localhost/order_system";
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(path,USERNAME,PASSWORD);
            
        } catch (SQLException e){
        }  
    }
    
}
