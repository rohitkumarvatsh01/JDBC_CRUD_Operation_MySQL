package CURD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadDataJdbc {
	public static void main(String[] args){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String urlDB="jdbc:mysql://localhost:3306/College";
			String userName="root";
			String password="Rohit";
			
			Connection con=DriverManager.getConnection(urlDB, userName, password);
			System.out.println("Database Connected Succesfully");
			
			String query="SELECT * FROM Student";
			
			Statement stmt=con.createStatement();
			ResultSet rset=stmt.executeQuery(query);
			
			System.out.println("Reading Data From Database...");
			
			while(rset.next()) {
				int rollNo=rset.getInt(1);
				String name=rset.getString(2);
				String city=rset.getString(3);
				int marks=rset.getInt(4);
				String grade=rset.getString(5);
				
				System.out.println(rollNo+" "+name+" "+city+" "+marks+" "+grade);
			}
		
		} catch (ClassNotFoundException e) {
			System.out.println("Something went wrong");
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
