
package com.transcore.util;

import java.sql.*;

public class DBConnectionUtil  {

	private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=dbDTS";
	private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String USER = "sa";
	private static final String PASSWORD = "Transcore#123";
	
	static  {
		
		try {
			
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		} 
		catch (Exception e) {	
			
			throw new RuntimeException("Sql Driver Failed To Register");			
		}
	}
	
	public static Connection getConnection() throws ClassNotFoundException,SQLException{
				
		// 2 - get connection using connection manager
		return DriverManager.getConnection(URL,USER,PASSWORD);
	}	
}
