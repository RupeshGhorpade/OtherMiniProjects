<%@page import="Model.BookPojo"%>
<%@page import="java.util.List"%>
<%@page import="Model.BookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
BookDao dao=new BookDao();
List<BookPojo>blist=dao.showAll();
request.setAttribute("blist", blist);
%>
<table>
<tr>
<td>BookId</td>
<td>BookName</td>
<td>Author</td>
<td>Price</td>
</tr>
<c:forEach var="b" items="${blist}">
<tr>
<td>${b.getBid()}</td>
<td>${b.getBname()}</td>
<td>${b.getAuthor()}</td>
<td>${b.getPrice()}</td>
<td><a href="delete.jsp?bid=${b.getBid()}">delete</a>
</td>
<td><a href="edit.jsp?bid=${b.getBid()}">edit</a>
</td>
</tr>
</c:forEach>
</table>
<a href="index.jsp">Add New Book</a>
<a href="search.jsp">Search Book</a>

</body>
</html>