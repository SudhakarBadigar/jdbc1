//WAP to delete the rows in the table
package com.pro.sudhi;
//1st step
import java.sql.*;
public class Jdbcprog4 {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		String query = "delete from junejdbc.employee where empno in(120,121)";
		
		try {
			//2nd step
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class loaded and registered");
			
			//3rd step
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/junejdbc?user=root&password=LordDattatreya1!");
			System.out.println("connected to the database");
			
			//4th step
			stmt = con.createStatement();
			System.out.println("platform created");
			
			//5th 
			int i = stmt.executeUpdate(query);
			System.out.println("Execute update = " +i);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
