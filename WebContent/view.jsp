<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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

<body>
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


</body>



</html>