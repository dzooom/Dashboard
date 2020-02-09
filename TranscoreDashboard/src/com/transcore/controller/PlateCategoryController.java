package com.transcore.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.transcore.dao.*;
import com.transcore.entity.*;


public class PlateCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public PlateCategoryController() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		String action = request.getParameter("action");
		if(action == null) {
			action = "list";
		}
		
		switch(action)
		{
			case "list":
				getPlateCategoryList(request, response);
			break;
			
			case "edit":
			break;
			case "delete":
			break;
		}	
			
		
		getPlateCategoryList(request,response);		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		// 1 - get form parameters
		String descEn = request.getParameter("categorydesc");
		Short displayOrder = Short.valueOf(request.getParameter("displayorder"));
		String descAr = request.getParameter("categorydescar");
		
		PlateCategory category = new PlateCategory();
		category.setPlateCategoryDesc(descEn);
		category.setDisplayOrder(displayOrder);
		category.setPlateCategArbDesc(descAr);
				
		try
		{
			PlateCategoryDAO.addCategory(category);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			
			e.printStackTrace();	
		}
		
		getPlateCategoryList(request, response);
	}
	
	public void getPlateCategoryList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
				
		List<PlateCategory> plateCategoryList;
		
		try 
		{
			plateCategoryList = PlateCategoryDAO.getPlateCategoryList();			
			request.setAttribute("data", plateCategoryList);		
			RequestDispatcher dispatcher =  request.getRequestDispatcher("/views/category.jsp");
			dispatcher.forward(request, response);
		}
		catch (ClassNotFoundException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
