package com.transcore.dao;

import com.transcore.entity.*;
import com.transcore.util.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PlateCategoryDAO {

	public static List<PlateCategory> getPlateCategoryList() throws SQLException,ClassNotFoundException{
		
		List<PlateCategory> plateCategoryList = new ArrayList<PlateCategory>();	
		
		Connection connection = null;
		Statement statement = null;
		ResultSet recordSet = null;
		
		try {
			
			// 1 - get connection
			connection = DBConnectionUtil.getConnection();
			
			// 2 - create statement			
			statement = connection.createStatement();
			
			// 3 - create and execute query 			
			recordSet =  statement.executeQuery("SELECT * FROM stbPlateCateg");	
			
			while(recordSet.next()) {
				
				short id = recordSet.getShort("tiPlateCategID");
				String categoryDesc = recordSet.getString("vcPlateCategDesc");
				short displayOrder = recordSet.getShort("tiDisplayOrder");
				String categoryDescArb = recordSet.getString("nvcPlateCategArbDesc");
				
				PlateCategory categoryObject = new PlateCategory();
				
				categoryObject.setDisplayOrder(displayOrder);
				categoryObject.setPlateCategoryDesc(categoryDesc);
				categoryObject.setPlateCategArbDesc(categoryDescArb);
				categoryObject.setPlateCategoryId(id);
				
				plateCategoryList.add(categoryObject);		
			}
		}
		
		finally {
						
			try {
				connection.close();
				statement.close();
				recordSet.close();
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return plateCategoryList;
	}
	
	private static Short getLastInsertedID(Statement statement) throws SQLException, ClassNotFoundException {
		
		try(ResultSet result = statement.executeQuery("SELECT max(tiPlateCategID) as MaxId FROM stbPlateCateg");)
		{
			result.next();	
			
			Short maxID = result.getShort("MaxId");
			
			return maxID;	
			
		}			
	}
	
	public static void addCategory(PlateCategory category) throws SQLException, ClassNotFoundException {
		
		
		try(Connection connection = DBConnectionUtil.getConnection();
				Statement statement = connection.createStatement())
		{
			
			Short lastId =  getLastInsertedID(statement);
			String query = String.format("INSERT INTO stbPlateCateg (tiPlateCategID,vcPlateCategDesc,tiDisplayOrder,nvcPlateCategArbDesc) "
					+ "VALUES (%d,'%s',%d,'%s')", 
					++lastId,category.getPlateCategoryDesc(),category.getDisplayOrder(),category.getPlateCategArbDesc());
			statement.executeUpdate(query);
		}	
				
	}
}
