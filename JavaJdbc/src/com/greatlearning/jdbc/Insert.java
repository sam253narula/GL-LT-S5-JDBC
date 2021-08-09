package com.greatlearning.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Insert {

	public static void main(String[] args) {
		String dbURL = "jdbc:mysql://localhost:3306/JDBC_Demo";
		String username = "root";
		String password = "admin";
		//String sql = "some sql";
		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
			
			String sql = "INSERT INTO Users (username, password, fullname, email) VALUES (?, ?, ?, ?)";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, "abac");
			statement.setString(2, "password");
			statement.setString(3, "abc Singh");
			statement.setString(4, "abc@gmail.com");
			
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new user was inserted successfully!");
			}

			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}		
	}
}