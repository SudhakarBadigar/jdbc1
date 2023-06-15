package com.pro.sudhi;
import java.sql.*;
public class JdbcPreparedStatement {

	public static void main(String[] args) {
		Connection con= null;
		PreparedStatement pstmt = null;
		String query ="insert into junejdbc.employee values(?,?,?);";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class loaded and registered");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/junejdbc?user=root&password=LordDattatreya1!");
			System.out.println("connetion established ");
			
			pstmt = con.prepareStatement(query);
			System.out.println("platform created and executed");
			System.out.println("setting the values for placeholder");
			pstmt.setInt(1,7);
			pstmt.setString(2,"madhava");
			pstmt.setDouble(3,1234.34);
			
			boolean b = pstmt.execute();
			System.out.println("Rows affected = " +b);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
