package com.jsp.servletProject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginServlet extends GenericServlet{	

	public LoginServlet() {
		//1stphase of servlet life cycle
		System.out.println("servlet object is created.");
		}
	
	
	public void init(ServletConfig conf) {
		//2nd phase of servlet life cycle
		System.out.println("servlet object is configure and initialized");
	}
	
	public void service(ServletRequest req, ServletResponse resp) throws IOException {
		//3rd phase of servlet life cycle
		System.out.println("Running phase..!");
		String email = req.getParameter("email");
		String password = req.getParameter("pwd");
		PrintWriter out = resp.getWriter();
		out.print("<html><body bgcolor='purple'><h1> congrats for loging in  ..!"+email+"</h1></body></html>");
		out.flush();
		
	}
	
	public void destroy() {
		//4th phase of servlet life cycle 
		System.out.println("object is not destroyed but all the costly resources are closed");
	}
	

}
