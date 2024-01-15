package CURD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteDataJdbc {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String urlDb="jdbc:mysql://localhost:3306/College";
			String userName="root";
			String password="Rohit";
			
			Connection con=DriverManager.getConnection(urlDb, userName, password);
			System.out.println("Connection is Successfully...");
			
			System.out.println("Enter the RollNo which want to Delete:- ");
			int rollNo=Integer.parseInt(sc.nextLine());
			
			String query="DELETE FROM Student WHERE RollNo=?";
			PreparedStatement pstmt=con.prepareStatement(query);
			
			pstmt.setInt(1, rollNo);
			
			int row=pstmt.executeUpdate();
			
			if(row>0) {
				System.out.println(rollNo+" row is Deleted Successfully");
			}
			else {
				System.out.println("Record is not Found");
			}
			
			
			
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Something went wrong");
			e.printStackTrace();
		}
		
	}
}
