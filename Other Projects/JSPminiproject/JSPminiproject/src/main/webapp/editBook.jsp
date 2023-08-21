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
<jsp:useBean id="b" class="model.BookPojo"></jsp:useBean>
<jsp:setProperty property="*" name="b"/>
<%
BookDao dao=new BookDao();
boolean r=dao.updateBook(b);
if(r)
	out.print("Record Updated..");
else
	out.print("Record not Found..");
%><br>
<a href="showAll.jsp">Home Page</a>
</body>
</html>