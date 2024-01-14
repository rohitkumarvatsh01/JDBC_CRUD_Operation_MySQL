package Jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateJDBC {
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/College","root","root");
			Statement stmt=con.createStatement();
			
			System.out.println("Inserting the Value in Database");
			
			String query="Insert into Student values(10, 'Rohan', 'Bihar', 70, 'D')";
			stmt.execute(query);
			
			con.close();
			stmt.close();
			
		}
		catch(Exception e) {
			System.out.println("Connection is Not Successfully "+e);
		}
	}
}
