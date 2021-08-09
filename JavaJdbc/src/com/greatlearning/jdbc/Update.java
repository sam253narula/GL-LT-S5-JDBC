package com.greatlearning.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {

	public static void main(String[] args) {
		String dbURL = "jdbc:mysql://localhost:3306/JDBC_Demo";
		String username = "root";
		String password = "admin";

		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
			
			String sql = "UPDATE Users SET password=?, fullname=?, email=? WHERE username=?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, "password");
			statement.setString(2, "Aman 2 Singh");
			statement.setString(3, "aman@google.org");
			statement.setString(4, "abac");

			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("An existing user was updated successfully!");
			}


		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}