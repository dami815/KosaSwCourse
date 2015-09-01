<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="dto.*" %>

<%
int boardNo = Integer.parseInt(request.getParameter("board_no"));
%>

<jsp:useBean id="boardService" class="service.BoardService" scope="application"/>

<%
//조회수 증가
boardService.addHitcount(boardNo); 

//게시물 가져오기
Board board = boardService.getBoard(boardNo); 
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			span {
				display: inline-block;
				margin: 3px;
			}
			span.title {
				border: 1px solid #FFFFFF;
				background: #FF99CC;
				width: 70px;
				text-align: center;
				font-weight: bold;
			}
			pre {
				margin: 10px;
				border: 1px solid darkgray;
				padding: 10px;
				height: 80px;
				width: 500px;
				background-color: #FFFFFF;
				overflow: scroll;
			}
			#part1 {
				display: flex;				
			}
			
			#part1_1 {
				flex: 1;
			}
			
			#part1_2 {
				width: 120;
				text-align: center;
				margin-right: 10px;
			}
			
			#part1_2 img {
				display: block;
				padding: 10px;
			}
			
			#part1_2 button {
				font-size: smaller;
				background-color: #FF99CC;
			}
			
			#buttonGroup {
				text-align: center;
			}
		</style>
	</head>
	<body>
		<h4>게시물 보기</h4>
		<div id="part1">
			<div id="part1_1">
				<span class="title">번호</span> 
				<span class="content"><%=board.getNo() %></span> <br/>
				
				<span class="title">제목</span> 
				<span class="content"><%=board.getTitle() %></span> <br/>
				
				<span class="title">글쓴이</span> 
				<span class="content"><%=board.getWriter() %></span> <br/>	
					
				<span class="title">날짜</span> 
				<span class="content"><%=board.getDate() %></span> <br/>
				
				<span class="title">조회수</span> 
				<span class="content"><%=board.getHitcount() %></span> <br/>
				
				<span class="title">첨부</span> 
				<span class="content"><%=board.getOriginalFileName() %></span> <br/>
			</div>
			
			<div id="part1_2">
				<img src="../uploadfiles/<%=board.getFilesystemName()%>" width="100px" height="100px"/>
				<button>DOWNLOAD</button>
			</div>
		</div>
		
		<div id="part2">
			<span class="title">내용</span> <br/>
			<pre><%=board.getContent() %></pre>
		</div>
		<div id="buttonGroup">
			<a href="list.jsp"><img src="../common/images/board/list.gif"/></a>
			<a href="modify_form.jsp?board_no=<%=board.getNo()%>"><img src="../common/images/board/modify.gif"/></a>
			<a href="delete.jsp?board_no=<%=board.getNo()%>"><img src="../common/images/board/delete.gif"/></a>
		</div>	
	</body>
</html>