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
boolean res=dao.deleteBook(bid);
if(res)
	out.print("Record Deleted..");
else
	out.print("Record not found..");
%>
<br>
<a href="showAll.jsp">Home Page</a>
</body>
</html>