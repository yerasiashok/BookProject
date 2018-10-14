
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>


<%
	String driver = "com.mysql.jdbc.Driver";
	String connectionUrl = "jdbc:mysql://localhost:3306/";
	String database = "Book";
	String userid = "root";
	String password = "password";
	String sql = "";
	String name = "";
	try {
		Class.forName(driver);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Data</title>
</head>
<style>
body {
	background-color: powderblue;
}

h1 {
	color: SlateBlue;
}

.main {

	margin: auto;
	width: 50%;
	border: 3px solid green;
	padding: 10px 10px 100px 10px;
}

p {
	font-size: 30px;
}
</style>


<h1 align="center">Welcome to BookStore!!!</h1>
	<div class="main">
		<form action="book.jsp">
			<div class="sub">
				Retrieve data by name: <select name="nameLis">
					<option selected disabled>Book</option>
					<option value="Servlets">Servlets</option>
					<option value="JSP">JSP</option>
					<option value="MYSQL">MYSQL</option>
				</select>
			</div>
			<br>
			<div class="sub">
				Retrieve data by author: <select name="authorLis">
					<option selected disabled>Name</option>
					<option value="Sudhanshu">Sudhanshu</option>
					<option value="Shankar">Shankar</option>
					<option value="Anna">Anna</option>
				</select>
			</div>
			<br>
			<div class="sub">
				Retrieve data by price: <select name="priceLis">
					<option selected disabled>Price</option>
					<option value="47">47</option>
					<option value="52">52</option>
					<option value="60">60</option>
				</select>
			</div>
			<br>
			<div class="sub">
				<input type="submit" />
			</div>
		</form>
	</div>


<body>
	<div class="main">
		<h1 align="center">Retrieved data from database in jsp</h1>
		<table border="1" align="center">
			<tr>
				<td>BOOK_ID</td>
				<td>BOOK_NAME</td>
				<td>BOOK_AUTHOR</td>
				<td>BOOK_PRICE</td>
			</tr>
			<%
				try {
					{
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
			%>
			<tr>
				<td><%=resultSet.getString("BOOK_ID")%></td>
				<td><%=resultSet.getString("BOOK_NAME")%></td>
				<td><%=resultSet.getString("BOOK_AUTHOR")%></td>
				<td><%=resultSet.getString("BOOK_PRICE")%></td>
			</tr>

			<%
				}
					connection.close();
					statement.close();
					resultSet.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			%>
		</table>
	</div>
</body>
</html>
