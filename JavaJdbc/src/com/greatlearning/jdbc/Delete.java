package com.greatlearning.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {

	public static void main(String[] args) {
		String dbURL = "jdbc:mysql://localhost:3306/JDBC_Demo";
		String username = "root";
		String password = "admin";

		// String sql1 = "DELETE FROM users WHERE username=?";

		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {

			String sql = "DELETE FROM users WHERE username=?";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, "abac");

			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("A user was deleted successfully!");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}