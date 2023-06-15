package com.mysqlQuery;
//1st step
import java.sql.*;
public class DmlQuery {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		String query1 ="insert into sudhisqljdbc.student values(7,'keertisuresh','design',2000.50);";
		String query2 = "update sudhisqljdbc.student set student_name='sudhakar',student_fees=24000 where student_id = 1;";
		String query3 = "delete from sudhisqljdbc.student where student_id=6;";
		try {
			//2ndstep
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class is loaded and registered");

			//3rd step
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/junejdbc?user=root&password=LordDattatreya1!");
			System.out.println("connected to database");
			
			//4th step
			stmt = con.createStatement();
			System.out.println("platform created");
			
			//5th step
			int a = stmt.executeUpdate(query1);
			System.out.println("Rows inserted = " + a);
			
			int b = stmt.executeUpdate(query2);
			System.out.println("Rows updated = " + b);
			
			int c = stmt.executeUpdate(query3);
			System.out.println("Rows Deleted = " + c);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
