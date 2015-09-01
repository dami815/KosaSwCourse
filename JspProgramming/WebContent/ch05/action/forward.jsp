<%@ page contentType="text/html; charset=UTF-8"%>

<%
request.setCharacterEncoding("UTF-8");
String email = request.getParameter("email");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>		
			forward.jsp
	</body>
</html>

<jsp:forward page="forwardForm.jsp">
	<jsp:param value="fall" name="id"/>
	<jsp:param value="삼겹살" name="name"/>
</jsp:forward>