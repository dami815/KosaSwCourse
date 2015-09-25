<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			body{
				font-size: small;
				color: black;
			}
			a{
				color: black;				
			}
			
			a:hover{
				color: #FF6666;
			}
		</style>
	</head>
	<body>
		<h3>Chap07. 스프링 MVC</h3>
		<hr/>
		<div>
			<h4>Command Object</h4>
			<ul>
				<li><a href="commandObject">/commandObject</a></li>
			</ul>
		</div>
		
		<div>
			<h4>@ModelAttribute</h4>
			<ul>
				<li><a href="modelAttribute1">/modelAttribute1</a></li>
				<li><a href="modelAttribute2">/modelAttribute2</a></li>
			</ul>
		</div>
		
		<div>
			<h4>@CookieValue, @RequestHeader</h4>
			<ul>
				<li>
					<a href="cookieValueSet">/cookieValueSet</a>
					<a href="cookieValueGet">/cookieValueGet</a>
				</li>
				<li><a href="requestHeader">/requestHeader</a></li>
			</ul>
		</div>
	</body>
</html>