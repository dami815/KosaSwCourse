<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			body {
				font-size: small;
				color:black;
			}
			
		</style>
	</head>
	
	<body>
		<h4>웹 브라우저의 종류</h4>
		<hr/>
		<%
		String userAgent = (String)request.getAttribute("userAgent");
		%>
		
		<%if(userAgent.indexOf("Chrome") != -1 && userAgent.indexOf("Edge") == -1) {%>
			Chrome
		<%}else if(userAgent.indexOf("Edge") != -1) {%>
			Edge
		<%}else{ %>
			IE 혹은 Safari
		<%}%>
	</body>
</html>