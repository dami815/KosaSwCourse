<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JSP PROGRAMMING</title>
		<style type="text/css">
			* {
				margin: 0px;
				padding:0px;				
			}
			body {
				width: 800px;
				margin: 0 auto;
				background-image: url('sakura.jpg');
				/* background-color: #E6E6E6; */
			}
			#page-wrapper {
				background-color: #FFFFFF;
				margin: 40px 0px;
				padding: 10px 20px;
				border-radius: 35px;
			}
			header {
				margin-bottom: 10px;
				text-shadow: 5px 5px 10px #B89470;
			}
			nav {
				border-top: 1px solid #C8C8C8;
				border-bottom: 1px solid #C8C8C8;
				display: flex;
				flex-direction: row;
				border-radius: 35px;
				background-color: #A37547;
				color: #FFFFFF;
			}
			.menu {
				flex: 1;
				margin: 5px;				
				width: 100px;
				text-align: center;				
			}
			#content {
				height: 500px;
				display: flex;				
				flex-direction: row;
			}			
			aside {
				height: 500px;
				width: 200px;
				border-right: 1px solid #C8C8C8;
				border-radius: 35px 0px 0px 35px;				
				background-color: #FFEBFF;
				overflow-y: scroll; 
			}
			.font_bold { font-weight: bold; }
			.font_center { text-align: center; }
			#category .chapter {
				height: 20px;
				background-color: #FFEBFF;
				border-radius: 35px 0px 0px 0px; 
			}			
			#category > a:hover { background-color: #FF33CC }			
			#category > a {
				/* height: 20px; */
				background-color: #FF99CC;
				color: #FFFFFF;
				border: 1px solid #FFFFFF;
				border-radius: 35px;				
				display: block;
			}
			a { text-decoration: none; }
			
			section {
				height: 500px;
				background-color: #FFEBFF; 
				border-radius: 0px 35px 35px 0px;
				flex: 1;
			}
			iframe {
				border: 0px solid white;
			}
			footer {				
				height: 50px;
				border-top: 1px solid #C8C8C8;
			}			
		</style>
	</head>
	<body>
		<div id="page-wrapper">
			<header>
				<h1 class="font_bold font_center">JSP PROGRAMMING</h1>				
			</header>		
			<nav>
				<div class="menu">Menu1</div>
				<div class="menu">Menu2</div>
				<div class="menu">Menu3</div>
				<div class="menu">Menu4</div>
				<div class="menu">Menu5</div>
			</nav>
			<div id="content">
				<aside>					
					<div id="category">
						<p class="chapter font_bold font_center">[Ch04: 서블릿]</p>
						<a  href="HelloWorldServlet" class="font_bold font_center" target="iframe">3.0 방식으로 등록</a>
						<a  href="HelloWorldServlet2" class="font_bold font_center" target="iframe">이전 방식으로 등록</a>
						<a  href="HelloWorldServlet3" class="font_bold font_center" target="iframe">load on startup</a>
						<a  href="HelloWorldServlet4" class="font_bold font_center" target="iframe">외부 정보 받기</a>
						<a  href="ch04/service_get_post.jsp" class="font_bold font_center" target="iframe">요청 방식별 처리</a>
						<a  href="LoginServlet" class="font_bold font_center" target="iframe">요청처리 및 응답보내기</a>
						
						<p class="chapter font_bold font_center">[Ch05: JSP 기초 문법]</p>
						<a  href="ch05/comment.jsp" class="font_bold font_center" target="iframe">주석</a>
						<a  href="ch05/directives.jsp" class="font_bold font_center" target="iframe">지시어</a>
						<a  href="ch05/action/index.jsp" class="font_bold font_center" target="iframe">표준액션</a>
						<a  href="ch05/dec_express/scriptlet1.jsp" class="font_bold font_center" target="iframe">스트립트릿1</a>
						<a  href="ch05/dec_express/scriptlet2.jsp" class="font_bold font_center" target="iframe">스트립트릿2</a>
						<a  href="ch05/dec_express/calc3.jsp" class="font_bold font_center" target="iframe">선언문</a>
						
						<p class="chapter font_bold font_center">[Ch06: JSP 내장 객체]</p>
						<a href="ch06/builtin_object.jsp" class="font_bold font_center" target="iframe">JSP 내장 객체 개요</a>
						<a href="ch06/request/index.jsp" class="font_bold font_center" target="iframe">request</a>
						<a href="ch06/response/index.jsp" class="font_bold font_center" target="iframe">response</a>
						<a href="ch06/cookie/index.jsp" class="font_bold font_center" target="iframe">cookie</a>
						<a href="ch06/session/index.jsp" class="font_bold font_center" target="iframe">session</a>
						<a href="ch06/application/index.jsp" class="font_bold font_center" target="iframe">application</a>
						<a href="ch06/exercise1/login.jsp" class="font_bold font_center" target="iframe">기본실습1 - 상품 주문</a>
						<a href="ch06/exercise2/twitter_login.jsp" class="font_bold font_center" target="iframe">응용실습 - 트위터</a>
						
						<p class="chapter font_bold font_center">[Ch07: JSP와 자바 빈즈]</p>
						<a href="ch07/dto.jsp" class="font_bold font_center" target="iframe">DTO 이용 방법</a>
						<a href="ch07/dto_auto_setting.jsp" class="font_bold font_center" target="iframe">DTO 값 저장</a>
						<a href="ch07/bean_scope.jsp" class="font_bold font_center" target="iframe">빈의 사용 범위</a>
						<a href="ch07/dao.jsp" class="font_bold font_center" target="iframe">DAO 이용 방법</a>	
						<a href="ch07/service.jsp" class="font_bold font_center" target="iframe">Service 이용 방법</a>
						<a href="ch07/database_form.jsp" class="font_bold font_center" target="iframe">데이터베이스 연동</a>
						
						<p class="chapter font_bold font_center">[Ch10: 표현 언어]</p>
						
						<p class="chapter font_bold font_center">[Ch11: JSTL]</p>
						<a href="ch11/forEach.jsp" class="font_bold font_center" target="iframe">&lt;c:forEach&gt;</a>
						
						<p class="chapter font_bold font_center">[실습01: 게시판]</p>
						<a href="exam01/list.jsp" class="font_bold font_center" target="iframe">게시판 목록</a>											
						<a href="exam02/list.jsp" class="font_bold font_center" target="iframe">상품 목록</a>
						
						<p class="chapter font_bold font_center">[실습02: MVC 게시판]</p>
						<a href="mvc/board?action=list" class="font_bold font_center" target="iframe">게시판 목록</a>								
					</div>
				</aside>
				<section>
					<iframe name="iframe" width="100%" height="100%"></iframe>
				</section>
			</div>
			<footer>Created by Dami Kim</footer>
		</div>		
	</body>
</html>