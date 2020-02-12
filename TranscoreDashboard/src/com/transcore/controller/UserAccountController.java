package com.transcore.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.transcore.dao.LoginDAO;
import com.transcore.entity.User;



public class UserAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UserAccountController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("logout")) {
			request.getSession(false).invalidate();
			response.sendRedirect("views/index.jsp");
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("username").toString();
		String password = request.getParameter("password").toString();
		User user = new User(userName, password);
		
		ServletContext ctx = request.getServletContext();
		String dbUrl = ctx.getInitParameter("testDB");
		LoginDAO.setDBUrl(dbUrl);
		try {
			
			boolean isValid = LoginDAO.IsValid(user);
			
			if(isValid) {
				
				HttpSession session = request.getSession(true);
				session.setAttribute("user", user);
				response.sendRedirect("plate-category");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("doPost of login");
		
	}

}
