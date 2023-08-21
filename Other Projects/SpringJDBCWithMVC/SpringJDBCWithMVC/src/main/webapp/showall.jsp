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
<table border="1">
<tr>
<td>Book Id</td>
<td> Book Name</td>
<td> Author</td>
<td>price</td>
</tr>
<c:forEach var="b" items="${blist}">
<tr>
<td>${b.getBid()}</td>
<td>${b.getBname()}</td>
<td>${b.getAuthor()}</td>
<td>${b.getPrice()}</td>
</tr>
</c:forEach>
</table>
<a href="index.jsp">Home page</a>
</body>
</html>