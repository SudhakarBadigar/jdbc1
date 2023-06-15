package com.jdbc.Preparestmt.dynamic;
import java.sql.*;
import java.util.Scanner;
public class DynamicDeletePrstmt {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query ="delete from junejdbc.employee where(empno = ?);";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class is loaded and registered ");
			 
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/junejdbc?user=root&password=LordDattatreya1!");
			System.out.println("connection established");
			
			pstmt = con.prepareStatement(query);
			
			while(true) {
				System.out.println("Enter the empno to delete");
				Scanner scan = new Scanner(System.in);
				int a = scan.nextInt();
				pstmt.setInt(1, a);
				int e = pstmt.executeUpdate();
				System.out.println("preparestatement executed = " +e);
				System.out.println("Do you want to continue[yes/no]");
				String choice = scan.next();
			    if(choice.equalsIgnoreCase("no")) {
			    	break;
			    }				
			    scan.close();
			}
			
			
			System.out.println("congrats you have deleted the rows ");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("please enter yes or no only");
			e.printStackTrace();
		}
	}
}
