package com.jsp.servletProject;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OurServlet1 extends HttpServlet{

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String fname =  req.getParameter("fname");
		String lname =  req.getParameter("lname");
		String email = req.getParameter("email");
		String pwd =  req.getParameter("pwd");
		String phno =  req.getParameter("phno");
		String add = req.getParameter("add");
		PrintWriter out = resp.getWriter();
		out.println("<html><body bgcolor='FFA200'><h1>"
				+ "congrats your data is recorded successfully "+fname
						+ "\n" + lname 
						+ "\n" + email
						+ "\n" + pwd
						+ "\n" + phno
						+ "\n" + add
						+ "</h1></body></html>");
		out.flush();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String query ="insert into junejdbc.user values(?,?,?,?,?,?);";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver class loaded");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/junejdbc?user=root&password=LordDattatreya1!");
			System.out.println("connected to database");
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, fname);
			pstmt.setString(2, lname);
			pstmt.setString(3,email);
			pstmt.setString(4,pwd);
			pstmt.setString(5,phno);
			pstmt.setString(6,add);
			
			pstmt.execute();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				if(con!=null && pstmt!= null) {
				con.close();
				pstmt.close();
				System.out.println("All costly resources closed ");
				}
				else {
					System.out.println("please close all the costly resources");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
}
