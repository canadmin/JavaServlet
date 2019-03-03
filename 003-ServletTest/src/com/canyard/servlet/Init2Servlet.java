package com.canyard.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Init2",urlPatterns={"/Init2"},initParams= {@WebInitParam(name="owner",value="Can data")})
public class Init2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Init2Servlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
    	try(PrintWriter out=response.getWriter()) {
    		out.println("<!DOCTYPE html>");
    		out.println("<html>");
    		out.println("<head>");
    		out.println("<title>Servlet TimeServlet </title>");
    		out.println("</head>");
    		out.println("<body>");
    		out.println("<h1> Greeting from 	"
    					+getServletConfig().getInitParameter("owner")+" 2"+"</h1>");
    			
    		out.println("</body>");
    		out.println("</html>");
    	}
	}
}


	
