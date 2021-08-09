package com.greatlearning.jdbc_demo;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;


/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		BookDAO bookDAO  = new BookDAO();
		try {
			//Creating the connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop","root", "admin");
			// Access a Statement
			Statement stmt = connection.createStatement();
			int input;
			do {
				System.out.println("Book DAO");
				System.out.println("1.Display");
				System.out.println("2. Insert");
				System.out.println("3. Modify");
				System.out.println("4. Delete");
				Scanner scan = new Scanner(System.in);
				input = scan.nextInt();
				switch (input) {
				case 1:
					bookDAO.getAllBooks(stmt);
					break;
				case 2:
					bookDAO.saveData(connection);
					break;
				case 3:
					bookDAO.updateBook(stmt);
					break;
				case 4:
					bookDAO.deleteBook(stmt);
					break;
					
				default:
					break;
				}
			} while(input >0);
			stmt.close();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
