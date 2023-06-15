package com.jdbc.Preparestmt.dynamic;
import java.sql.*;
import java.util.Scanner;

public class DynamicUpdatePrstmt {

	public static void main(String[] args) {
	        Connection con = null;
	        PreparedStatement pstmt = null;
	        String query = "update junejdbc.employee set ename=?,esal=? where empno = ?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class loaded and registered");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/junejdbc?user=root&password=LordDattatreya1!");
			System.out.println("connection established");
			
			pstmt = con.prepareStatement(query);
			while(true) {
				System.out.println("Enter the values to update");
				Scanner scan = new Scanner(System.in);				
				System.err.println("enter the Name to update ");
				String a = scan.next();
				System.err.println("Enter the salary to update ");
				Double b = scan.nextDouble();
				System.err.println("enter the row(pk) you want to update");
				int c = scan.nextInt();
				pstmt.setString(1, a);
				pstmt.setDouble(2, b);
				pstmt.setInt(3, c);
				int e = pstmt.executeUpdate();
				System.out.println("Executed " +e);
		 						
				System.out.println("Do you want to continue[yes/no]");
				String choice = scan.next();
				if(choice.equalsIgnoreCase("no")) {
					break;
				}
//				scan.close();
				}
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			if(con!=null && pstmt!=null) {
				try {
					con.close();
					pstmt.close();
					System.out.println("All costly resources are closed");
				} catch (SQLException e) {
					e.printStackTrace();
				}		
				
			}
		}
	}
}












