
package customerservice;
import java.sql.*;
import java.util.*;
public class createCustomer {
    public static void main(String[] args) {
   
        Scanner kbd = new Scanner (System.in);
        int count;
        for (count = 0; count <= 5; count++) {
        System.out.println("Enter your Last Name: ");
        String lastN = kbd.nextLine();
        System.out.println("Enter your First Name: ");
        String firstN = kbd.nextLine();
        System.out.println("Enter your Address: ");
        String adds = kbd.nextLine();
        System.out.println("Enter your Contact Number: ");
        String phoneN = kbd.nextLine();
        try {
            
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/order_system?autoReconnect=true&useSSL=false", "root","root");      
            Statement st = conn.createStatement ();
            String query = "insert into customer (last_name, first_name, address, phone_num) " + "values ('"+lastN+"','"+firstN+"','"+adds+"','"+phoneN+"');";
            st.executeUpdate(query);

        } catch (SQLException e) {
            
        
        }
}
}
}