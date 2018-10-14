package com.ProjectBook;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connection {
	String driver = "com.mysql.jdbc.Driver";
	String connectionUrl = "jdbc:mysql://localhost:3306/";
	String database = "Book";
	String userid = "root";
	String password = "password";
	String sql="";
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	Get model = new Get();
		public void createConnection() {
	try {
		Class.forName(driver);
		connection = (Connection) DriverManager.getConnection(connectionUrl + database, userid, password);
		System.out.println("Connected");
		
		
		if (model.name!=null){
			
			model.name=((char)34+model.name+(char)34);
			sql = "select * from BookStore where BOOK_NAME="+model.name;
			
		} else if (model.author!=null) {
			
			model.author=((char)34+model.author+(char)34);
			sql = "select * from BookStore where BOOK_AUTHOR="+model.author;
			
		} else if (model.price!=null) {
			
			sql = "select * from BookStore where BOOK_PRICE=" + model.price;
		} 
		statement = ((java.sql.Connection) connection).createStatement();
		resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
		model.setId(resultSet.getString("BOOK_ID"));
		model.setName(resultSet.getString("BOOK_NAME"));
		model.setAuthor(resultSet.getString("BOOK_AUTHOR"));
		model.setPrice(resultSet.getString("BOOK_PRICE"));
	}
		((Connection) connection).close();
		statement.close();
		resultSet.close();
		System.out.println("Disconnected");
	} catch (Exception e) {
		e.printStackTrace();
	}
}
		private void close() {
			// TODO Auto-generated method stub
			
		}
	}
