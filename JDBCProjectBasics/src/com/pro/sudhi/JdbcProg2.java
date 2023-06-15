package com.pro.sudhi;
//1st step
import java.sql.*;

public class JdbcProg2 {
	public static void main(String[] args) {
		Connection con;
		Statement stmt;
		String query = "insert into junejdbc.employee values(4,'ganesha',1436.64)";
		String query1 = "insert into junejdbc.employee values(5,'shiva',2236.66)";
	try {
		//2nd step
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver class loaded and registration done");
		//3rd step
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/junejdbc?user=root&password=LordDattatreya1!");
		System.out.println("connected to local host mysql database");
		//4thstep
		 stmt = con.createStatement();
		 System.out.println("created statement or platform to write the query");
		//5th step
		 //boolean b = stmt.execute("insert into junejdbc.employee values(121,'Rama',4000.04)");
		 int b = stmt.executeUpdate(query);
		 int c = stmt.executeUpdate(query1);
		 System.out.println("insertion to the employee tab = "  +b);
		 System.out.println("insertion to the employee tab = "  +c);
		 
		 System.out.println("Query executed");
		 
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	}

}
