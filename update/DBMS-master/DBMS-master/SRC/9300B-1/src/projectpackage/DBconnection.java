package projectpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBconnection {

	    private Connection connection;
	    private Statement statement;
	    private PreparedStatement ps;
	    private ResultSet resultSet;
//	    private String sql;
	    
	    public void dbaseConnect(String url, String user, String pass) throws Exception {
	        Class.forName("com.mysql.jdbc.Driver");
	        connection = DriverManager.getConnection(url, user, pass);
	    }
		
		public void close() {
	        try {
	            if (resultSet != null) {
	                resultSet.close();
	            }
	            if (statement != null) {
	                statement.close();
	            }
	            if (ps != null) {
	            	ps.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (Exception e) {

	        }
	    }
		
	}
