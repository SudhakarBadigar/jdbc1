package com.jdbc.Preparestmt.dynamic;
import java.sql.*;
public class DynamicCRUD {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		String inquery="insert into junejdbc.employee values(?,'?',?);";
		String upquery="update junejdbc.employee set ename=? where empno = ?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class loaded and registered");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/junejdbc?user=root&password=LordDattatreya1!");
			System.out.println("connection established");
			
			pstmt = con.prepareStatement(inquery);
			System.out.println("platform created");
			
			pstmt.setInt(1, 9);
			pstmt.setString(2,"killbill");
			pstmt.setDouble(3, 1230.09);
			int e = pstmt.executeUpdate();
			System.out.println("Row inserted " +e );
			
			pstmt1 = con.prepareStatement(upquery);
			pstmt1.setString(1,"raju");
			pstmt1.setInt(2, 3);
			int e1=pstmt1.executeUpdate();
			System.out.println("Row updated " +e1);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
