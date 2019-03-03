package com.canyard.sessions.data;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name="TitleServlet",urlPatterns= {"/TitleServlet"})
public class TitleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public TitleServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		try(PrintWriter pw=response.getWriter()){
			String title=request.getParameter("title");
			try {
				title=((Person)request.getSession().getAttribute("person")).getTitle();
			}catch (Exception ex) {
				title=ex.toString();
			}
			pw.println("<!DOCTYPE html>");
			pw.println("<html>");
			pw.println("<head>");
			pw.println("<title>Name Servlet</title>");
			pw.println("</head>");
			pw.println("<body>");
			pw.println("<h1>Name</h1>");
			pw.println("<h3>Session id :"+title+"</h3>");//her oturum için tutulan id yi yazdýrýyoruz
			pw.println("<a href=\"index.html\">Go to start</a>");
			pw.println("</body>");
			pw.println("</html>");
		}	
		}

}
