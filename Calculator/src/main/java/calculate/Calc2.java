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
@WebServlet("/Calc2")
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
		response.setContentType("text/html");
		
		int sum1 =Integer.parseInt(request.getParameter("sum1").trim());
		int sum2 =Integer.parseInt(request.getParameter("sum2").trim());
		
		int pro1 =Integer.parseInt(request.getParameter("pro1").trim());
		int pro2 =Integer.parseInt(request.getParameter("pro2").trim());
		System.out.println(1);
		
		String sum="";
		String product="";
		//sum=sum1+sum2;
		System.out.println(sum);
		
		if(request.getParameter("sum1")!=null || request.getParameter("sum2")!=null){
			sum=""+(sum1+sum2);
			}
		else{
			
			sum= "";
			System.out.println(sum);
		}
		
		if(request.getParameter("pro1")!=null || request.getParameter("pro2")!=null){
			product= ""+(pro1 *pro2);
			}
		else{
			product= "";
			System.out.println(product);
		}
		
		PrintWriter pw= response.getWriter();
		pw.write("<html>");
		pw.write("<body>");
		pw.write("<title>");
		pw.write("Sum");
		pw.write("</title>");
		pw.write("<input type='text' name='sum1' value=' " + sum1 + "'> +");
		pw.write("<input type='text' name='sum2' value='" +sum2 +"'> =");
		pw.write("<input type='text' name='totalsum' value='"+sum+"'>");
		pw.write("<br>");
		pw.write("<input type='text' name='pro1' value=' " + pro1 + "'> +");
		pw.write("<input type='text' name='pro2' value='" +pro2 +"'> =");
		pw.write("<input type='text' name='totalproduct' value='"+product+"'>");
		pw.write("</title>");
		pw.write("</body>");
		pw.write("</html>");
		System.out.println(2);
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
