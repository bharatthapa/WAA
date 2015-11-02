package main.java.calculate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class calc
 */
@WebServlet("/calc")
public class Calc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		int sum1 = Integer.parseInt(request.getParameter("sum1"));
		int sum2 = Integer.parseInt(request.getParameter("sum2"));
		
		int total1 = sum1 + sum2;
		
		int pro1 = Integer.parseInt(request.getParameter("pro1"));
		int pro2 = Integer.parseInt(request.getParameter("pro2"));
		
		int total2 = pro1 * pro2;
		
		PrintWriter pw = response.getWriter();
		pw.write("<html><body>" + "<h6> Sum :" + total1 +"</h6>"
				+ "<h6> Muliplication : " + total2 +"</h6>"
				);
		
	}


}
