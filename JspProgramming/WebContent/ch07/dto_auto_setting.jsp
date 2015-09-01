<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="dto.*" %>
<%String method = request.getMethod(); %>

<%if(method.equals("GET")) {%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Board Writing</title>
	</head>
	<body>
		<form method="post" action="dto_auto_setting.jsp">
			<table id="form_table">
				<tr>
					<td>제목</td>
					<td><input type="text" name="title"/></td>
				</tr>
				<tr>
					<td>글쓴이</td>
					<td><input type="text" name="writer"/></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea rows="5" cols="50" name="content"></textarea></td>				
				</tr>
			</table>
			<input type="submit" value="게시물 작성"/>
			<input type="image" src="../common/images/board/write.gif"/>
			<input type="reset" value="다시 작성"/>
		</form>
	</body>
</html>
<%} else if(method.equals("POST")) {%>
	<%
	Board board1 = new Board();
	board1.setTitle(request.getParameter("title"));
	board1.setWriter(request.getParameter("writer"));
	board1.setContent(request.getParameter("content"));	
	%>
	
	title: <%=board1.getTitle() %> <br/>
	writer: <%=board1.getWriter() %> <br/>
	content: <%=board1.getContent() %> <br/>
	
	
	<jsp:useBean id="board2" class="dto.Board">
		<jsp:setProperty name="board2" property="*"/> 
	</jsp:useBean>
	
	title: <%=board2.getTitle() %> <br/>
	writer: <%=board2.getWriter() %> <br/>
	content: <%=board2.getContent() %> <br/>
<% } %>

