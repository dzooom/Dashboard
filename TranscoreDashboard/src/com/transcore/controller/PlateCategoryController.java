package com.transcore.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.transcore.dao.*;
import com.transcore.entity.*;
import com.transcore.util.DBConnectionUtil;


public class PlateCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public PlateCategoryController() {
        
    }
    
    
    
    
    @Override
    public void init(ServletConfig config) 
    {
    	
    	
    	try 
    	{
    		super.init(config);
    		
    		ServletContext ctx = getServletContext();
        	String dbUrl = ctx.getInitParameter("DTSDB");
        	PlateCategoryDAO.setDbUrl(dbUrl);
    	}
    	catch(Exception e) 
    	{
    		e.printStackTrace();
    	}
    	
    	
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
				getPlateCategory(request,response);					
			break;
			
			case "delete":
				deletePlateCategory(request, response);					
			break;
			
			default:
				getPlateCategoryList(request,response);
				
		}	
				
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		addUpdatePlateCategory(request, response);
		
	}
	
	public void getPlateCategoryList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
				
		List<PlateCategory> plateCategoryList;
		String categoryDesc =  request.getParameter("categoryen");		
		String displayOrder = request.getParameter("displayorder");		
		short page = 1;
		short pageSize = 10;
		
		try {
			 page = Short.parseShort(request.getParameter("page"));
			 pageSize = Short.parseShort(request.getParameter("pagesize"));
		}
		catch(NumberFormatException e) {
			
		}	
				
		
		Map<String,String> queryParams = new HashMap<String, String>();
		
		if(categoryDesc != null && !categoryDesc.trim().equals("")) {
			categoryDesc =  java.net.URLDecoder.decode(categoryDesc);
			queryParams.put("vcPlateCategDesc", categoryDesc);
		}
		
		if(displayOrder != null && !displayOrder.trim().equals("")) {
			queryParams.put("tiDisplayOrder", displayOrder);
		}
		
		try 
		{
			plateCategoryList = PlateCategoryDAO.getList(queryParams , pageSize, page);			
			request.setAttribute("data", plateCategoryList);		
			RequestDispatcher dispatcher =  request.getRequestDispatcher("/views/category.jsp");
			dispatcher.forward(request, response);
		}
		catch (ClassNotFoundException | SQLException e)
		{	
			e.printStackTrace();
		}		
	}
	
	public void getPlateCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String sId = request.getParameter("categoryid");
		
		if(sId == null && sId.trim().equals("")) 
		{
			response.sendRedirect("views/add-category.jsp");
			return;
		}
		else
		{
			try 
			{
				short id = Short.parseShort(sId);
				PlateCategory category = PlateCategoryDAO.getCategory(id);
				request.setAttribute("category", category);
				request.setAttribute("action", "edit");				
				RequestDispatcher dispacher = request.getRequestDispatcher("/views/add-category.jsp");
				dispacher.forward(request, response);
			}
			catch(NumberFormatException e)
			{
				response.sendRedirect("views/add-category.jsp");
				return;
			} 
			catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} 
			catch (SQLException e) {
				
				e.printStackTrace();
			} 
			catch (Exception e) {
				
				e.printStackTrace();
			}
		}
	}

	public void deletePlateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String categoryId = request.getParameter("categoryid");		
		Short id = null ;
		
		try 
		{
			id = Short.parseShort(categoryId);
			PlateCategoryDAO.deleteCategory(id);
			response.sendRedirect("plate-category");
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(NumberFormatException ex) 
		{
			response.sendRedirect("plate-category");
		}			
	}

	public void addUpdatePlateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1 - get form parameters
		String descEn = request.getParameter("categorydesc");
		Short displayOrder = Short.valueOf(request.getParameter("displayorder"));
		String descAr = request.getParameter("categorydescar");
		String action = request.getParameter("hidaction");
		
		
		PlateCategory category = new PlateCategory();
		category.setPlateCategoryDesc(descEn);
		category.setDisplayOrder(displayOrder);
		category.setPlateCategArbDesc(descAr);
				
		try
		{
			if(action.equals("edit"))
			{
				Short categoryId = Short.parseShort(request.getParameter("hidcategoryid"));
				category.setPlateCategoryId(categoryId);
				
				PlateCategoryDAO.updateCategory(category);
			}
			else
			{				
				PlateCategoryDAO.addCategory(category);
			}		
			
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			
			e.printStackTrace();	
		}
		
		getPlateCategoryList(request, response);
				
	}

}












