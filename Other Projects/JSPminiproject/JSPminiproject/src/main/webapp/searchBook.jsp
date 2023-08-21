<%@page import="Model.BookPojo"%>
<%@page import="Model.BookDao"%>
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
if(b!=null)
	out.print("Book found<br>)"+b);
	else
		out.print("Book not found...");
%>
<a href="showAll.jsp">Home page</a>
</body>
</html>