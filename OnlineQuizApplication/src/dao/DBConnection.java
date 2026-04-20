package dao;

import java.sql.*;
//import java.sql.DriverManager;
//import com.sun.jdi.connect.spi.Connection;

public class DBConnection {
	 public static Connection getConnection() {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            return DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/quiz_app",
	                "root",
	                "system"
	            );
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }


}
