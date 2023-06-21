package com.jdbc.tcl;

	
	import java.sql.*;
	import java.util.Scanner;
	public class Savepointex {

		public static void main(String[] args) {
			Connection con = null;
			PreparedStatement pstmt1 = null;
			PreparedStatement pstmt2 = null;
			Savepoint sp = null;
			
			String stquery1 ="insert into junejdbc.student1 values (?,?,?);";
			String stquery2 ="insert into junejdbc.student2 values (?,?,?);";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver classess are loaded and registered ");
				
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/junejdbc?user=root&password=LordDattatreya1!");
				System.out.println("connection established between java application and database");
			
				//1st step of transaction auto commit to disable			
				con.setAutoCommit(false);
				pstmt1= con.prepareStatement(stquery1);
				System.err.println("enter student1 table details");
				Scanner scan = new Scanner(System.in);

				System.out.println("enter the usn");
				int s1usn = scan.nextInt();
				
				System.out.println("enter the Name of the student");
				String s1name = scan.next();
				
				System.out.println("enter the marks of the student ");
				double s1marks = scan.nextDouble();
				
				pstmt1.setInt(1, s1usn);
				pstmt1.setString(2, s1name);
				pstmt1.setDouble(3, s1marks);
				pstmt1.execute();
				
				
				sp=con.setSavepoint();
				System.out.println(".............................");
				System.err.println("enter student2 table details");
				pstmt2 = con.prepareStatement(stquery2);

				System.out.println("enter usn of the student");
				int s2usn = scan.nextInt();
				
				System.out.println("enter name of the student");
				String s2name = scan.next();
				
				System.out.println("enter the marks of the student");
				double s2marks = scan.nextDouble();
				
				pstmt2.setInt(1, s2usn);
				pstmt2.setString(2, s2name);
				pstmt2.setDouble(3, s2marks);			
				pstmt2.execute();
				con.commit();
				scan.close();
			} catch (ClassNotFoundException | SQLException e) {
				try {
					con.rollback(sp);
					con.commit();
					System.out.println("rollback Data Rolled out..because one operation success and another operation unsucess");
				    }
				catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
			
			finally {
				try {
					if(con!=null &&pstmt1!=null &&pstmt2!=null &&sp!=null) {
						con.close();
						pstmt1.close();
						pstmt2.close();
						
						
						System.out.println("All costly resources are closed ");
					}
					else {
						System.out.println("please close all costly resources..");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
	}



