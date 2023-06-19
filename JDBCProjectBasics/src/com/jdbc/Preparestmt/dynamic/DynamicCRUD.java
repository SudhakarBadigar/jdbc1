package com.jdbc.Preparestmt.dynamic;
import java.sql.*;
import java.util.Scanner;
public class DynamicCRUD {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		String inquery="insert into junejdbc.employee values(?,?,?);";
		String upquery="update junejdbc.employee set ename=? where empno = ?;";
		String delquery = "delete from junejdbc.employee where empno = ?;";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class loaded and registered");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/junejdbc?user=root&password=LordDattatreya1!");
			System.out.println("connection established");
			
			pstmt = con.prepareStatement(inquery);
			System.out.println("platform created");

			pstmt1 = con.prepareStatement(upquery);
			System.out.println("platform created");
			
			pstmt2 = con.prepareStatement(delquery);
			System.out.println("platform created");
			
			while(true) {
			
			
				System.err.println("Enter 1.Insert\n2.Update\n3.Delete");
				Scanner scan = new Scanner(System.in);
				int choice = scan.nextInt();
				
			switch(choice) {
			
			case 1:
			{
				System.out.println("please enter the empno you want to insert");
				int insert1 = scan.nextInt();
				pstmt.setInt(1, insert1);
				
				System.out.println("please enter the empname ");
				String insert2 = scan.next();
				pstmt.setString(2,insert2);
				
				System.out.println("please enter the salary");
				Double insert3 = scan.nextDouble();
				pstmt.setDouble(3, insert3);
				
				int e = pstmt.executeUpdate();
				System.out.println("Row inserted " +e );
				break;
			}
			
			case 2:
			{
				System.out.println("enter the empname you want to update");
				String update1 = scan.next();
				pstmt1.setString(1,update1);

				System.out.println("enter the empno id");
				int update2 = scan.nextInt();
				pstmt1.setInt(2, update2);
				
				int e1=pstmt1.executeUpdate();
				System.out.println("Row updated " +e1);
				break;
			}
			case 3:
			{
				pstmt2 = con.prepareStatement(delquery);
				System.out.println("enter the empno id that you want to delete");
				int del = scan.nextInt();
				pstmt2.setInt(1,del);
				int e2 = pstmt2.executeUpdate();
				System.out.println("Rows Deleted :" + e2);
				break;
			}
			default:{
				System.out.println("please enter the choice 1,2 or 3");
		        	}
	    	}
			
			System.out.println("Do you want to continue[yes/no]");
			String ans = scan.next();
			if(ans.equalsIgnoreCase("no")) {
				break;
			}
			scan.close();
    	}
   }
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			if(con!=null && pstmt1!=null && pstmt1!= null && pstmt2 !=null) {
				try {
					con.close();
					pstmt.close();
					pstmt1.close();
					pstmt2.close();
					System.out.println("All costly resources are closed.");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
	}
}













