
package com.transcore.util;

import java.sql.*;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class DBConnectionUtil  {

	private static final String URL = "jdbc:sqlserver://localhost;databaseName=dbDTS";
	private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String USER = "sa";
	private static final String PASSWORD = "Transcore#123";
	
	public static Connection getConnection() throws ClassNotFoundException,SQLException{
		
		// 1 - register driver
		Class.forName(DRIVER);
		
		// 2 - get connection using connection manager
		return DriverManager.getConnection(URL,USER,PASSWORD);		
		
	}
	
}
