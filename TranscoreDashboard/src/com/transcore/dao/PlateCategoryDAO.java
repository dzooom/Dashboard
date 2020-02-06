package com.transcore.dao;

import com.transcore.entity.*;
import com.transcore.util.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlateCategoryDAO {

	public List<PlateCategory> getPlateCategoryList(){
		
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
				categoryObject.setPlateCategoryArbDesc(categoryDescArb);
				categoryObject.setPlateCategoryID(id);
				
				plateCategoryList.add(categoryObject);		
			}
		}
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		catch (ClassNotFoundException e) {
			e.printStackTrace();
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
}
