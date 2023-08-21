<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="Model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="bobj" class="Model.BookPojo"></jsp:useBean>
<jsp:setProperty property="*" name="bobj"/>
<%
out.print(bobj);
BookDao dao=new BookDao();
boolean res=dao.insertBook(bobj);
if(res)
	out.print("Insertion Sucessful...");
%>
</body>
</html>