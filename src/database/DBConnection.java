package database;

import java.sql.*;

public class DBConnection {
	private static Connection connection;

    public static Connection getConnection() {
    	if (connection == null) {
           try {
        	          	   
        	   String url = "jdbc:mysql://localhost:3306/Bangtandb";
        	   String username = "root";
        	   String password = "root";
              connection = DriverManager.getConnection(url, username, password);
           } 
           catch (Exception e) {
              e.printStackTrace();
              
           }
        }
    	return connection;
    }
}
