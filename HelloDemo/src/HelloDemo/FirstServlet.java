package HelloDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet") 
public class FirstServlet extends HttpServlet {
	   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		PrintWriter pw = response.getWriter();
//		pw.print("Welcome");
		
		
		//response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		 double sqroot = Math.sqrt(4.0);
		 
		 out.println("<html><body><h1 align='center'> Hello World Servlet"
				 + "<br> The Square Root is :"+ sqroot + 
				 "</body></html>");
		 
		 
		
	}

}
