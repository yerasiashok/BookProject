package com.ProjectBook;

import java.sql.*;

public class Connection {
	String driver = "com.mysql.jdbc.Driver";
	String connectionUrl = "jdbc:mysql://localhost:3306/";
	String database = "Book";
	String userid = "root";
	String password = "password";
	String sql = "";
	String id = "";
	Get get = new Get();
	Controller cont = new Controller();

	public Get createConnection() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		AutoCloseable connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DriverManager.getConnection(connectionUrl + database,
					userid, password);
			statement = ((com.ProjectBook.Connection) connection)
					.createStatement();
			if (cont.name != null) {
				cont.name = ((char) 34 + cont.name + (char) 34);
				sql = "select * from Books where BOOK_NAME=" + cont.name;
			} else if (cont.author != null) {
				cont.author = ((char) 34 + cont.author + (char) 34);
				sql = "select * from Books where BOOK_AUTHOR=" + cont.author;
			} else if (cont.price != null) {
				sql = "select * from Books where BOOK_PRICE=" + cont.price;
			} else if ((cont.name != null) && (cont.author != null)) {
				cont.name = ((char) 34 + cont.name + (char) 34);
				sql = "select * from Books where BOOK_NAME=" + cont.name;
			} else if ((cont.author != null) && (cont.price != null)) {
				cont.author = ((char) 34 + cont.author + (char) 34);
				sql = "select * from Books where BOOK_AUTHOR=" + cont.author;
			} else if ((cont.price != null) && (cont.name != null)) {
				cont.name = ((char) 34 + cont.name + (char) 34);
				sql = "select * from Books where BOOK_NAME=" + cont.name;
			} else {
				cont.name = ((char) 34 + cont.name + (char) 34);
				sql = "select * from Books where BOOK_NAME=" + cont.name;
			}
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				get.setId(resultSet.getString("BOOK_ID"));
				get.setName(resultSet.getString("BOOK_NAME"));
				get.setAuthor(resultSet.getString("BOOK_AUTHOR"));
				get.setPrice(resultSet.getString("BOOK_PRICE"));
			}

			connection.close();
			statement.close();
			resultSet.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return get;
	}

	private Statement createStatement() {
		// TODO Auto-generated method stub
		return null;
	}
}
