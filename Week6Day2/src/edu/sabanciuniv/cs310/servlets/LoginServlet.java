package edu.sabanciuniv.cs310.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String u = request.getParameter("uname");
		
		String p = request.getParameter("pass");
		
		System.out.println("GET Request --> "+ u + "  --  " +p);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String u = request.getParameter("uname");
		
		String p = request.getParameter("pass");
		
		System.out.println("POST Request --> "+ u + "  --  " +p);
		
		
		try 
		{
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/cs310", "root","1997");
			PreparedStatement ps =  con.prepareStatement("select * from user where username=? and password=?");
			ps.setString(1, u);
			ps.setString(2, p);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				System.out.println("User exists");
				response.sendRedirect("secure.html");
				request.getSession().setAttribute("loggedin","true" );
				
			}
			else
			{
				System.out.println("User does not exist!!!!!!");
				response.sendRedirect("error.html");
			}
			
	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
