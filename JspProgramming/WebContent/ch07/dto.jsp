<%@ page contentType="text/html; charset=UTF-8"%>

<%@ page import="dto.*"%>
<% 
Board board1 = new Board(); 
board1.setTitle("오늘은 일찍 가는 날1");
board1.setContent("푹 쉬고, 복습 많이 해야지1");
%>

<jsp:useBean id="board2" class="dto.Board"/>
<jsp:setProperty property="title" name="board2" value="오늘은 일찍 가는 날2"/>
<jsp:setProperty property="content" name="board2" value="푹 쉬고, 복습 많이 해야지2"/>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		board1-title: <%=board1.getTitle() %> <br/>
		board1-content: <%=board1.getContent() %> <br/>
		board2-title: <jsp:getProperty property="title" name="board2"/> <br/>
		board2-content: <jsp:getProperty property="content" name="board2"/> <br/>
	</body>
</html>