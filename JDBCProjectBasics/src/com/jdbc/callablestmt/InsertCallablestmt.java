//Not completed yet this program is half finished.
package com.jdbc.callablestmt;
import java.sql.*;
import java.util.Scanner;

public class InsertCallablestmt {
   public static void main(String[] args) {
	   Connection con = null;
	   CallableStatement cstmt = null;
	   ResultSet rs = null;
	   String query="{call getdetails(?,?,?,?)}";
	   
	   try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver classes loaded and registered");
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sudhisqljdbc?user=root&password=LordDattatreya1!");
		System.out.println("Connection established for java application and database");
		
		cstmt= con.prepareCall(query);
		Scanner scan = new Scanner(System.in);
		System.out.println("enter student id");
		int id1 = scan.nextInt();
		cstmt.setInt(1, id1);
		
		System.out.println("enter the student name");
		String sname = scan.next();
		cstmt.setString(2, sname);
		
		System.out.println("enter the student course");
		String scourse = scan.next();
		cstmt.setString(3, scourse);
		
		System.out.println("enter the course fees");
		double sfees = scan.nextDouble();
		cstmt.setDouble(4, sfees);
		rs = cstmt.executeQuery();
		if(rs != null && rs.next()) {
			int stid = rs.getInt(1);
			String stname = rs.getString(2);
			String stcourse = rs.getString(3);
			double stfees = rs.getDouble(4);
			//System.out.println("items inserted");
			System.out.println("student id:" +stid+ "\nstudent name:  " + stname+ "\nstudent course :" + stcourse+ "\nstudent fees:" +stfees);
		}
		else {
			System.out.println("no such insertion");
		}
		scan.close();
		
		
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	   
	   finally {
		   try {
			if(con!=null && cstmt!=null && rs!=null) {
					con.close();
					cstmt.close();
					rs.close();
					System.out.println("All costly resources are closed");
			}
			else {
				System.out.println("Resources not closed");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		   
	   }
}
	
}
