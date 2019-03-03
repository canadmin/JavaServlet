package com.canyard.sessions.data;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");// t�rk�e karakter deste�i i�in ekledik
		try(PrintWriter pw=response.getWriter()){
			String name=request.getParameter("name");
			String title=request.getParameter("title");
			if(name!=null && title!=null) { 
				Person person=new Person(name.trim(), title.trim());//bo�luk olmas�n diye
				HttpSession session=request.getSession();//oturum bilgilerini tutuyor
				session.setAttribute("person", person);//put extra getextra
			}
			pw.println("<!DOCTYPE html>");
			pw.println("<html>");
			pw.println("<head>");
			pw.println("<title>Servlet SaveServlet</title>");
			pw.println("</head>");
			pw.println("<body>");
			pw.println("<h3> Your session object is now updated</h3>");
			pw.println("<h3>Session id :"+request.getSession().getId() +"</h3>");//her oturum i�in tutulan id yi yazd�r�yoruz
			pw.println("<a href=\"index.html\">Go to start</a>");
			pw.println("</body>");
			pw.println("</html>");

		}
		
			


	}
	}


