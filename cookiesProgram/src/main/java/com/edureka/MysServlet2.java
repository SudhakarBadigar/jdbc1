package com.edureka;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/welcomehere")
public class MysServlet2 extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse resp) {
	try {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		//Reading cookies
		Cookie[] c = req.getCookies();
		
		//displaying username value from cookie
		out.print("Name Here" +c[0].getValue());
		out.print("password" +c[1].getValue());
		
		out.flush();
	}
	catch(Exception e) {
		System.out.println(e);
	}
	
		
		
	}

}
