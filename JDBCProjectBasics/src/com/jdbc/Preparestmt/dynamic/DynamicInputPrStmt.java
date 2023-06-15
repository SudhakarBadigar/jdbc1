package com.jdbc.Preparestmt.dynamic;
import java.sql.*;
import java.util.Scanner;
public class DynamicInputPrStmt {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "insert into junejdbc.employee values(?,?,?);";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class loaded and registered");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/junejdbc?user=root&password=LordDattatreya1!");
			System.out.println("connection established b/w java app and database");
			
			pstmt = con.prepareStatement(query);
			System.out.println("platform created");
			while(true) {
				System.out.println("Setting the value for placeholders");
				System.out.println("..................................");
				Scanner scan = new Scanner(System.in);
				
				System.out.println("Enter the empno ");
				int a = scan.nextInt();
				
				System.out.println("Enter the ename ");
				String b = scan.next();
				
				System.out.println("Enter the esal ");
				Double c = scan.nextDouble();
				
				pstmt.setInt(1, a);
				pstmt.setString(2, b);
				pstmt.setDouble(3,c);
				
				int e = pstmt.executeUpdate();
				System.out.println("Rows affected " +e);
				System.out.println("Do you want to enter more rows: [yes/no]");
				String choice = scan.next();
				if(choice.equalsIgnoreCase("no")) {
					break;
					}
				scan.close();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
