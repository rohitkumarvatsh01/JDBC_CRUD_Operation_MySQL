package Jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateJDBC {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/College","root","root");
			
			String query="UPDATE Student SET Name=?, City=? WHERE RollNo=?";
			
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Enter the New Name:- ");
			String name=br.readLine();
			
			System.out.println("Enter the New City Name:- ");
			String city=br.readLine();
			
			System.out.println("Enter  the RollNo:- ");
			int roll=Integer.parseInt(br.readLine());
			
			PreparedStatement pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, name);
			pstmt.setString(2, city);
			pstmt.setInt(3, roll);
			
			pstmt.executeUpdate();
			
			System.out.println("Update is Successfully");
			
			pstmt.close();
			con.close();
		}
		catch(Exception e) {
			System.out.println("Something went wrong "+e);
		}
	}

}
