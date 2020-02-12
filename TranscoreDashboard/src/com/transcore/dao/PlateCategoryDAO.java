package com.transcore.dao;

import com.transcore.entity.*;
import com.transcore.util.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PlateCategoryDAO {
	
	private static String dbUrl;
	
	public static void setDbUrl(String url) {
		dbUrl = url;
	}

	public static List<PlateCategory> getList() throws SQLException,ClassNotFoundException{
		
		List<PlateCategory> plateCategoryList = new ArrayList<PlateCategory>();	
		
		Connection connection = null;
		Statement statement = null;
		ResultSet recordSet = null;
		
		try {
			
			// 1 - get connection
			connection = DBConnectionUtil.getConnection(dbUrl);
			
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
		
		finally{
			connection.close();
			statement.close();
			recordSet.close();
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
	
	public static boolean addCategory(PlateCategory category) throws SQLException, ClassNotFoundException {
		
		int rowsEffected = 2;
		
		try(Connection connection = DBConnectionUtil.getConnection(dbUrl);
				Statement statement = connection.createStatement())
		{
			
			Short lastId =  getLastInsertedID(statement);
			String query = String.format("INSERT INTO stbPlateCateg (tiPlateCategID,vcPlateCategDesc,tiDisplayOrder,nvcPlateCategArbDesc) "
					+ "VALUES (%d,'%s',%d,'%s')", 
					++lastId,category.getPlateCategoryDesc(),category.getDisplayOrder(),category.getPlateCategArbDesc());
			rowsEffected = statement.executeUpdate(query);
		}	
			
		return rowsEffected == 1;
	}
	
	public static PlateCategory getCategory(short id) throws ClassNotFoundException, SQLException, Exception {
		
		String query =  String.format("SELECT * FROM stbPlateCateg WHERE tiPlateCategID = %d", id);		
		
		try(Connection connection = DBConnectionUtil.getConnection(dbUrl);
				Statement statetment = connection.createStatement();
				ResultSet row = statetment.executeQuery(query)){	
			
			if(row.next()) 
			{
				String desc = row.getString("vcPlateCategDesc");
				short displayOrder = row.getShort("tiDisplayOrder");
				String descAr = row.getString("nvcPlateCategArbDesc");
				short categoryId = row.getShort("tiPlateCategID");
				
				PlateCategory category = new PlateCategory();
				category.setPlateCategoryDesc(desc);
				category.setDisplayOrder(displayOrder);
				category.setPlateCategArbDesc(descAr);
				category.setPlateCategoryId(categoryId);
				return category ;
				
			}
			
			throw new Exception(String.format("plate category with id = %d does not exist",id));
		}
	}
	
	public static boolean updateCategory(PlateCategory plateCategory) throws ClassNotFoundException, SQLException {
		
		try(Connection connection = DBConnectionUtil.getConnection(dbUrl);
				Statement statement = connection.createStatement())
		{
			String query = String.format("UPDATE stbPlateCateg SET vcPlateCategDesc = '%s', tiDisplayOrder = %d, nvcPlateCategArbDesc = '%s'"
					+ "  WHERE tiPlateCategID = %d " , plateCategory.getPlateCategoryDesc(),plateCategory.getDisplayOrder(),plateCategory.getPlateCategArbDesc(),plateCategory.getPlateCategoryId());			
			
			int rowsEffected = statement.executeUpdate(query);	
			
			return rowsEffected == 1;
		}	
	}
	
	public static boolean deleteCategory(short plateCategoryId) throws ClassNotFoundException, SQLException {
		
		try(Connection connection = DBConnectionUtil.getConnection(dbUrl);Statement statement = connection.createStatement())
		{
			String query = String.format("DELETE FROM stbPlateCateg WHERE tiPlateCategID = %d " , plateCategoryId);			
			
			int rowsEffected = statement.executeUpdate(query);	
			
			return rowsEffected == 1;
		}		
		
	}
}
