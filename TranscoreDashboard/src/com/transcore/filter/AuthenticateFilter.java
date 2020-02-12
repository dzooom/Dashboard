package com.transcore.filter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;

import com.transcore.dao.LoginDAO;
import com.transcore.entity.User;

import javax.servlet.ServletContext;


public class AuthenticateFilter implements Filter {
  
    public AuthenticateFilter() {
        
    }

	
    public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
			
			System.out.println("Filter invoked");		
		
			HttpServletRequest httpRequest = (HttpServletRequest)request;
			HttpServletResponse httpResponse = (HttpServletResponse)response;
			
			HttpSession session = httpRequest.getSession(false);
			User user = null;
			
			if(session != null) {
				 user = (User)session.getAttribute("user");
			}
			
			String requestedUrl = httpRequest.getRequestURI();
			int lastIndex = requestedUrl.lastIndexOf("/");
			lastIndex++;
			String url = requestedUrl.substring(lastIndex);
			
			if(user != null || url.equalsIgnoreCase("login")) {
				chain.doFilter(httpRequest, httpResponse);
			}
			else{
				
				httpResponse.sendRedirect(httpRequest.getContextPath() +  "/index.jsp");
			}		
	}


	public void init(FilterConfig fConfig) throws ServletException {
		
		System.out.println("log filter");
	}

}
