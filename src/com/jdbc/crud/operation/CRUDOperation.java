package com.jdbc.crud.operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.jdbc.crud.db.DatabaseConnection;

public class CRUDOperation {
	static Scanner sc=new Scanner(System.in);
	
	//Create Database
	public static void createDatabase() {
		Connection con=null;
		try {
			
			System.out.println("Enter the Name of Database: ");
			String name=sc.nextLine();
			
			con=DatabaseConnection.databaseConnection();
			
			Statement stmt=con.createStatement();
			String query="CREATE DATABASE IF NOT EXISTS "+name;
			
			stmt.executeUpdate(query);
			
			System.out.println("New Database "+name+" is Created.");
			
			stmt.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Create a Table in Database
	public static void createTable() {
		Connection con=null;
		try {
			System.out.println("Enter the Table Name:");
			String tableName=sc.nextLine();
			
			con=DatabaseConnection.databaseConnection();
			
			Statement stmt=con.createStatement();
			String query="CREATE TABLE IF NOT EXISTS "+tableName+" (RollNo INT PRIMARY KEY, Name VARCHAR(20), Age INT)";
			stmt.execute(query);
			
			System.out.println("New Table "+tableName+" is Created.");
			
			stmt.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	//Insert Data in Table
	public static void insertData() {
		Connection con=null;
		try {
			System.out.println("Insert Data in Table:");

			System.out.println("Enter the RollNo: ");
			int rollNo=sc.nextInt();
			
			sc.nextLine();
			
			System.out.println("Enter the Name: ");
			String name=sc.nextLine();
			
			System.out.println("Enter the Age: ");
			int age=sc.nextInt();
			
			con=DatabaseConnection.databaseConnection();
			String query="INSERT INTO StudentJdbc (RollNo, Name, Age) VALUES(?, ?, ?)";
			PreparedStatement pstmt=con.prepareStatement(query);
			
			pstmt.setInt(1, rollNo);
			pstmt.setString(2, name);
			pstmt.setInt(3, age);
			
			pstmt.executeUpdate();
			
			System.out.println("RollNo "+rollNo+" is Inserted.");
			
			pstmt.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	//Read the Record of Data from Table
	public static void readData() {
		Connection con=null;
		try {
			System.out.println("Read Data from Table:");

			con=DatabaseConnection.databaseConnection();
			
			Statement stmt=con.createStatement();
			
			String query="SELECT * FROM StudentJdbc";
			
			ResultSet rset=stmt.executeQuery(query);
			
			System.out.println("*************************");
			System.out.println("*RollNo     Name     Age*");
			System.out.println("*************************");
			while(rset.next()) {
				System.out.print(rset.getInt("RollNo")+"  "+rset.getString("Name")+"  "+ rset.getInt("Age"));
				System.out.println();
				System.out.println("*************************");
			}
			
			System.out.println("All Records...");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	//Update the Data in Table
	public static void updateData() {
		Connection con=null;
		try {
			
			System.out.println("Update the Record in Table:");
			System.out.println("Enter the RollNo: ");
			int rollNo=sc.nextInt();
			sc.nextLine();
			
			System.out.println("Enter the Name: ");
			String name=sc.nextLine();
			
			System.out.println("Enter the Age: ");
			int age=sc.nextInt();
			
			con=DatabaseConnection.databaseConnection();
			String query="UPDATE StudentJdbc SET Name=?, Age=? WHERE RollNo=?";
			PreparedStatement pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setInt(3, rollNo);
			
			int rowAffected=pstmt.executeUpdate();
			if(rowAffected>0) {
				System.out.println("RollNo "+rollNo+" is Updated Successful.");
			}
			else {
				System.out.println("RollNo "+rollNo+" is Not Found.");
			}
			
			pstmt.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Delete the Record from Table
	public static void deleteData() {
		Connection con=null;
		try {
			System.out.println("Delete Data from Table:");
			System.out.println("Enter the RollNo: ");
			int rollNo=sc.nextInt();
			
			con=DatabaseConnection.databaseConnection();
			
			String query="DELETE FROM StudentJdbc WHERE RollNo=?";
			PreparedStatement pstmt=con.prepareStatement(query);
			
			pstmt.setInt(1, rollNo);
			
			int rowAffected=pstmt.executeUpdate();
			if(rowAffected>0) {
				System.out.println("RollNo "+rollNo+" is Deleted.");
			}
			else {
				System.out.println("RollNo "+rollNo+" is Not Found.");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
