package com.jdbc.crud;
import java.util.Scanner;

import com.jdbc.crud.operation.CRUDOperation;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		boolean exit=false;
		
		while(exit==false) {
			System.out.println("*************************");
			System.out.println("*WELCOME TO OUR DATABASE*");
			System.out.println("*************************");
			System.out.println("* Choose operation:-    *");
			System.out.println("* 1. Create Database.   *");
			System.out.println("* 2. Create Table.      *");
			System.out.println("* 3. Insert Data.       *");
			System.out.println("* 4. Read Data.         *");
			System.out.println("* 5. Update Data.       *");
			System.out.println("* 6. Delete Data.       *");
			System.out.println("* 7. Exit.              *");
			System.out.println("*************************");
			System.out.print("Choice: ");
			int choice=sc.nextInt();
		
			switch(choice) {
				case 1:
					CRUDOperation.createDatabase();
					break;
				
				case 2:
					CRUDOperation.createTable();
					break;
				
				case 3:
					CRUDOperation.insertData();
					break;
				
				case 4:
					CRUDOperation.readData();
					break;
				
				case 5:
					CRUDOperation.updateData();
					break;
				
				case 6:
					CRUDOperation.deleteData();
					break;
				
				case 7:
					System.out.println("Exiting program...");
					exit=false;
					break;
                
				default:
					System.out.println("Invalid choice. Exiting program...");
			}
			
			System.out.println("*************************");
			System.out.println("*THANK YOU FOR VISITING *");
			System.out.println("*************************");
			System.out.println();
		}
	}
}
