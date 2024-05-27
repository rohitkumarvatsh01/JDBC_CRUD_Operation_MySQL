package com.jdbc.crud.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	
	public static Connection databaseConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String urlDb="jdbc:mysql://localhost:3306/Project";
			String userNameDb="root";
			String passwordDb="Rohitkumar01@";
			
			con=DriverManager.getConnection(urlDb, userNameDb, passwordDb);			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}