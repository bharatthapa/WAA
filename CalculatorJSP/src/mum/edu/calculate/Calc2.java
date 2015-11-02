package mum.edu.calculate;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class calc
 */
@WebServlet("/calc2")
public class Calc2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calc2() {
        super();
        // TODO Auto-generated constructor stub
    }
    
 
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 System.out.println("Inside Calc2");
		
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/calculate.jsp");
			requestDispatcher.forward(request, response);
		 
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Came after Calcuate.jsp");
		int int1 = Integer.parseInt(request.getParameter("sumint1"));
		int int2 = Integer.parseInt(request.getParameter("sumint2"));
		int sum = int1+int2;
		
		int pro1 = Integer.parseInt(request.getParameter("proint1"));
		int pro2 = Integer.parseInt(request.getParameter("proint2"));
		int product = pro1*pro2;
		
		request.setAttribute("IntegerSum",sum );
		request.setAttribute("IntegerProduct",product);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/result.jsp");
		rd.forward(request, response);
		
	}

}
