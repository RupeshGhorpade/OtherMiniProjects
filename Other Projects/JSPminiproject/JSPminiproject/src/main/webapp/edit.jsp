<%@page import="Model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
int bid=Integer.parseInt(request.getParameter("bid"));
BookDao dao=new BookDao();
BookPojo b=dao.Search(bid);
%>
<h1>Enter data to update</h1>
<form action="editBook.jsp">
Id:<input type="hidden" name="bid" value="<%=b.getBid()%>">
Name:<input type="text" name="bname" value="<%=b.getBname()%>"><br>
Author:<input type="text" name="author" value="<%=b.getAuthor()%>">
Price:<input type="text" name="price" value="<%=b.getPrice()%>">
<input type="submit" value="edit">

</form>

</body>
</html>