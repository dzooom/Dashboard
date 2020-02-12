package com.transcore.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.transcore.entity.User;
import com.transcore.util.DBConnectionUtil;

public class LoginDAO {

	private static String dbUrl;
	
	public static void setDBUrl(String dbUrl) {
		LoginDAO.dbUrl = dbUrl;
	}
	
	public static boolean IsValid(User login) throws SQLException, ClassNotFoundException 
	{	
		String query = String.format("SELECT * FROM tblUser WHERE vcUserName='%s' and vcPassword= '%s'"
				,login.getUserName(),login.getPassword());
		
		// 1 - get connection object
		
		try(Connection connection =  DBConnectionUtil.getConnection(dbUrl);
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(query))
		{
			return result.next();
		}
	}
}
