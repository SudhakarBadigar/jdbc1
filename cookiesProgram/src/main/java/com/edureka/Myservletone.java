package com.edureka;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class MyServletone extends HttpServlet{
	
	public void doGet(HttpServletRequest req,HttpServletResponse resp) {
		resp.setContentType("text/html");
		try {
			PrintWriter out =  resp.getWriter();
			
		 String	username =req.getParameter("username");
		 String password = req.getParameter("password");
		 
		 out.print("Hello here" + username);
		 out.println("your password is "+password);
		 
		 //creating objects of two cookies
		 Cookie c1 = new Cookie("username", username);
		 Cookie c2 = new Cookie("password", password);
		 
		 //add the cookie to the response header
		 resp.addCookie(c1);
		 resp.addCookie(c2);
		 
		 
		 out.print("<br><a href='welcomehere'>View Details</a>");
		 out.flush();
		 
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		
	}

}
