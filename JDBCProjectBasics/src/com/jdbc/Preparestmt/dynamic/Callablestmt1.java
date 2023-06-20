package com.jdbc.Preparestmt.dynamic;

import java.sql.*;
import java.util.Scanner;
public class Callablestmt1 {

	public static void main(String[] args) {
		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		String pquery = "{call junejdbc.getdetailsstoredprocedure(?)}";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class loaded");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/junejdbc?user=root&password=LordDattatreya1!");
			System.out.println("connection established");
			
			cstmt= con.prepareCall(pquery);
			Scanner scan = new Scanner(System.in);
			System.out.println("enter the empno you want to fetch?");	
			int emp = scan.nextInt();
			cstmt.setInt(1,emp);
			rs = cstmt.executeQuery();
			if(rs.next()) {
				int empNo = rs.getInt(1);
				String empName = rs.getString(2);
				double empsal = rs.getDouble(3);
				System.out.println("Empno is : " + empNo + "\nEmp Name is : " + empName+ "\nEmp salary is: " +empsal);
			}
			else {
				System.err.println("No such records");
			}
			scan.close();
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		finally {
				
			if(con!= null && cstmt!=null && rs!=null ) {
				try {
					con.close();
					cstmt.close();
					rs.close();
				System.err.println("All costly connections are closed ");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			}
		}
	}
}
