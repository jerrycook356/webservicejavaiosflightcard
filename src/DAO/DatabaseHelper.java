package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHelper {
  
	public Connection getConnection(){
		  final String dbUrl = "jdbc:mysql://localhost/flightdatabase";
		    final String name = "root";
		    final String pass = "jerry111";
		Connection con = null;
		try{
			 Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(dbUrl,name,pass);
        
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}catch(SQLException e){
		e.printStackTrace();
	}
		return con;
	}	
}
