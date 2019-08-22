package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHelper {
  
	public Connection getConnection(){
		//connection for amazon db on aws
		//final String dbUrl = "jdbc:mysql://aaujb4l0dvq9sp.cmwbilivfjmx.us-east-2.rds.amazonaws.com/flightdatabase";
        // final String name = "admin";
	   // final String pass = "password";
	    
	    //connection for local mysql
	    
		/*final String dbUrl = "jdbc:mysql://localhost/flightdatabase";
		   
		  final String name = "root";
		  final String pass = "jerry111"; */
		
		//connection for new aws db
		final String dbUrl = "jdbc:mysql://aa13kbi76svxb3c.cwmcpyvel2fx.us-east-2.rds.amazonaws.com/flightdatabase";
		final String name = "admin";
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
