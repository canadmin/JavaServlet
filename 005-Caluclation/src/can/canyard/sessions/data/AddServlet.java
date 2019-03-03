package can.canyard.sessions.data;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="AddServlet",urlPatterns= {"/AddServlet"})
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet AddServlet</title>");
			out.println("</head>");
			out.println("<body>");
			try {
				String a = request.getParameter("numbera");
				String b = request.getParameter("numberb");
				double s = Double.parseDouble(a) + Double.parseDouble(b);
				out.println("<p>" + a + " + " + b + " = " + s + "</p>");
			} catch (Exception ex) {
				out.println("<p>Illegal arguments</p>");
			}
			out.println("<a href=\"index.html\">Back to start</a>");
			out.println("</body>");
			out.println("</html>");
	}
}

}
