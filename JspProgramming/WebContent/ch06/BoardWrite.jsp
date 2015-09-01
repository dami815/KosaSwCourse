<%@ page contentType="text/html; charset=UTF-8"%>

<%
request.setCharacterEncoding("UTF-8");
String title = request.getParameter("title");
String writer = request.getParameter("writer");
String content = request.getParameter("content");
String sex = request.getParameter("sex");
String password = request.getParameter("password");
String checkpublic = request.getParameter("checkpublic");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>What You Wrote in the Board</title>
	</head>
	<body>
		title: <%=title %> <br/>
		writer: <%=writer %> <br/>
		content: <%=content %> <br/>
		sex: <%=sex %> <br/>
		password: <%=password %> </br>
		checkpublic: <%=checkpublic %>
	</body>
</html>