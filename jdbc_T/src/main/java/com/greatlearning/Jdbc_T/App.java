package com.greatlearning.Jdbc_T;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class App {

	public static void main(String[] args) throws SQLException {
		Savepoint savepoint = null;
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop", "root", "admin");
		try {
			Statement stmt = conn.createStatement();
			conn.setAutoCommit(false);
		
			savepoint = conn.setSavepoint("Savepoint1");
			System.out.println("Save Point 1");
			
			String sql = "insertinto books (id,title,author,price,qty) values (1007,'Best IaaC Tool : Terraform','xyz',22.5,5)";
			stmt.executeUpdate(sql);
			
			/*
			 * Savepoints do not work, if you have committed your transaction, the below
			 * line will fail the rollback, since with below line of code, you commit the
			 * transaction
			 */
			// conn.commit();

			// correct insert statement below
//			sql = "insert into books (id,title,author,price,qty) values (1008"
//					+ ",'Best IaaC Tool : Terraform','xyz',22.5,5)";

			// Wrong insert statement bellow to demo rollback
			sql = "inserted into books (id,title,author,price,qty) values (1008"
					+ ",'Best IaaC Tool : Terraform','xyz',22.5,5)";
			savepoint = conn.setSavepoint("Savepoint2");
			System.out.println("Save Point 2");
			stmt.executeUpdate(sql);
			conn.commit();
			conn.close();
		} catch (Exception e) {
			System.out.println("Roll back");
			conn.rollback(savepoint);
		}

	}
}
