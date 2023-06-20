//Not completed yet this program is half finished.
package com.jdbc.callablestmt;
import java.sql.*;

public class InsertCallablestmt {
   public static void main(String[] args) {
	   Connection con = null;
	   CallableStatement cstmt = null;
	   String query="{call getdetails(?)}";
	   ResultSet rs = null;
	   
	   try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver classes loaded and registered");
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sudhisqljdbc?user=root&password=LordDattatreya1!");
		System.out.println("Connection established for java application and database");
		
		cstmt= con.prepareCall(query);
		
		
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
}
	
}
