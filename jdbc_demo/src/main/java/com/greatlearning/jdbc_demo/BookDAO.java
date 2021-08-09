package com.greatlearning.jdbc_demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookDAO {

	public void getAllBooks(Statement stmt) throws SQLException {
		String str = "select title,price,qty from books";
		ResultSet rs = stmt.executeQuery(str);
		int rowCounter = 0;
		while (rs.next()) {
			String title = rs.getString("title");
			double price = rs.getDouble("price");
			int qty = rs.getInt("qty");
			System.out.println("The Data =");
			System.out.println("title = " + title);
			System.out.println("price = " + price);
			System.out.println("qty = " + qty);
			++rowCounter;
		}
		System.out.println("Count of records: " + rowCounter);
	}

	public void saveData(Connection con) throws SQLException {
		if (con != null && !con.isClosed()) {
			String str = "insert into books (id,title,author,price,qty) values (?,?,?,?,?)";
			PreparedStatement preparedStatement = con.prepareStatement(str);
			preparedStatement.setInt(1, 5006);
			preparedStatement.setString(2, "Scala for beginners");
			preparedStatement.setString(3, "Light Bend Website");
			preparedStatement.setFloat(4, 100.5f);
			preparedStatement.setInt(5, 40);
			int row = preparedStatement.executeUpdate();
		}

	}

	public void deleteBook(Statement stmt) throws SQLException {
		String sql = "delete from books where id >=3000 and id <6000";
		int counter = stmt.executeUpdate(sql);
		System.out.println("The delete recorded:- " + counter);
	}

	public void updateBook(Statement stmt) throws SQLException {
		String sql = "update books set price = price*1.07 where id=1001";
		int counter = stmt.executeUpdate(sql);
		System.err.println(counter);
	}
}
