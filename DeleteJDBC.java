package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteJDBC {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String urlDB="jdbc:mysql://localhost:3306/College";
			String userName="root";
			String password="Rohitkumar01@";
			
			Connection con=DriverManager.getConnection(urlDB, userName, password);
			
			System.out.println("Enter the RollNo:- ");
			int rollNo=Integer.parseInt(sc.nextLine());
			String query="DELETE FROM Student WHERE RollNo = ?";
			
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setInt(1, rollNo);
			int row=pstmt.executeUpdate();
			
			if(row>0) {
				System.out.println(rollNo+" Row is Deleted Successfully");
			}
			else {
				System.out.println("No records found with RollNo "+rollNo);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
}
