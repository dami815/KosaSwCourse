<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			body {
				font-size: small;				
			}
		</style>
	</head>
	<body>
		<h4>로그인</h4>
		<hr/>
		<form:form commandName="login">
			memberId:
			<form:input path="memberId" size="20"/>
			<form:errors path="memberId"/>
			<br/>
			memberPW:
			<form:input path="memberPW" size="20"/>
			<form:errors path="memberPW"/>
			<br/>
			
			<input type="submit" value="LOGIN"/>
		</form:form>
	</body>
</html>