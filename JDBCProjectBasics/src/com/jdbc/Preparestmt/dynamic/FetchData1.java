package com.jdbc.Preparestmt.dynamic;
//1st step
import java.sql.*;
 
public class FetchData1 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String fetchQuery ="select * from junejdbc.employee";
		try 
		{
			//2nd step
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver classes loaded and registered");
			//3rd step
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/junejdbc?user=root&password=LordDattatreya1!");
			System.out.println("Connection established between java app and database");
			//4th step
			pstmt = con.prepareStatement(fetchQuery);
			
			//5th step
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int eNo= rs.getInt("empno");
				String eName = rs.getString(2);
				double eSal  = rs.getDouble(3);
				System.err.println("\nDetails of EmployeeId: " + eNo + "\nName of the Employee: " + eName + "\nsalary: " +eSal); 
			}
		//	System.out.println("No such records");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				if(con != null && pstmt != null && rs != null);
				System.out.println("All costly resource closed");	
			}catch(Exception ex) {
				ex.printStackTrace();
			}	
		}
	}
}
