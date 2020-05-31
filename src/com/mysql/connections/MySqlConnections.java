package com.mysql.connections;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnections {
	public Connection connections() throws Exception{
	Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection(  
	"jdbc:mysql://localhost:3306/nitin","root","root");  
	return con;
	
	}

}
