<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<table border="1" align="center">
			<tr>
				<td>BOOK_ID</td>
				<td>BOOK_NAME</td>
				<td>BOOK_AUTHOR</td>
				<td>BOOK_PRICE</td>
			</tr>


<tr>
				<td><%=request.getAttribute("BOOK_ID")%></td>
				<td><%=request.getAttribute("BOOK_NAME")%></td>
				<td><%=request.getAttribute("BOOK_AUTHOR")%></td>
				<td><%=request.getAttribute("BOOK_PRICE")%></td>
			</tr>
			</table></body>
			</html>