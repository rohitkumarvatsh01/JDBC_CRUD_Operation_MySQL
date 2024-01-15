package CURD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CreateDataJdbc {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String urlDatabase="jdbc:mysql://localhost:3306/College";
			String userName="root";
			String password="Rohitkumar01@";
			Connection con=DriverManager.getConnection(urlDatabase, userName, password);
			System.out.println("Database is Connected Succesfully...");
			
			String query="INSERT INTO Student VALUES(10, 'Rani', 'Kolkata', 81, 'B')";
			PreparedStatement pstmt=con.prepareStatement(query);
			
			pstmt.execute();
			System.out.println("Inserting Data into Table is Succesfully");
			pstmt.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Something went wrong!");
		}
	}

}
