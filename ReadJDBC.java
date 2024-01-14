package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadJDBC {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/College","root","root");
			
			String query="SELECT * FROM Student";
			
			Statement stmt=con.createStatement();
			ResultSet rset=stmt.executeQuery(query);
			
			while(rset.next()) {
				int roll=rset.getInt(1);
				String name=rset.getString(2);
				String city=rset.getString(3);
				String mark=rset.getString(4);
				String grade=rset.getString(5);
				
				System.out.println(roll+" "+name+" "+city+" "+mark+" "+grade);
				
			}
			
			rset.close();
			stmt.close();
			con.close();
		}
		catch(Exception e) {
			System.out.println("Connection is Not Successfully "+e);
		}
	}

}
