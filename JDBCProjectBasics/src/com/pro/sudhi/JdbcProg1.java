package com.pro.sudhi;
//1st step
import java.sql.*;
public class JdbcProg1 {
	public static void main(String[] args) {
		Connection con;
		//4th step
		Statement stmt;
		
		//2nd step
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class Loaded and Registered");
			//3rd step
			con =  DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=LordDattatreya1!");
			System.out.println("connection established b/w java Appl and Database");
			stmt = con.createStatement();
			System.out.println("Statement or platform created.");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
