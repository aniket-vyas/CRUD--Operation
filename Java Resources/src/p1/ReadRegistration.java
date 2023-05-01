package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/read")
public class ReadRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ReadRegistration() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("hello"); //these 2 lines i used for servlet to write to html
		// run this java file hello will be print on the webpage
		
		out.println("name <input type='text'/> "); //it will print same as it is
		//but I need to use this as html code , then use response.getContentType
		
		//this is for header because this is only one
		out.println("<table border='1'>");
		out.println("<tr>");
		
		out.println("<th>");
		out.println("name");
		out.println("</th>");
		
		out.println("<th>");
		out.println("city");
		out.println("</th>");
		
		out.println("<th>");
		out.println("email");
		out.println("</th>");
		
		out.println("<th>");
		out.println("mobile");
		out.println("</th>");
		
		out.println("</tr>");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_app_1","root","root");
			Statement stmnt = con.createStatement();
			ResultSet result = stmnt.executeQuery("SELECT * FROM registration");
			while(result.next()) {
				
				//this is for table data in while because of too many records
				out.println("<tr>");
				
				out.println("<td>");
				out.println(result.getString(1));
				out.println("</td>");
				
				out.println("<td>");
				out.println(result.getString(2));
				out.println("</td>");
				
				out.println("<td>");
				out.println(result.getString(3));
				out.println("</td>");
				
				out.println("<td>");
				out.println(result.getString(4));
				out.println("</td>");
				
				out.println("</tr>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		out.println("</table>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do post");
	}

}
