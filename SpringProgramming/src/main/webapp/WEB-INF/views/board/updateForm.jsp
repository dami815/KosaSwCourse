<%@ page contentType="text/html; charset=UTF-8"%>

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
				border: 1px solid darkgray;
				background: #800000;
				width: 70px;
				text-align: center;
				color: white;
			}
			pre {
				margin: 10px;
				border: 1px solid darkgray;
				padding: 10px;
				height: 80px;
				width: 450px;
				background-color: #FFFFFF
			}
			
			#buttonGroup {
				margin: 10px;
				text-align: center;
			}
			
			#buttonGroup a {
				display:inline-block;
				width: 70px;
				line-height: 30px;
				text-decoration: none;
				font-size: small;
				color: black;
				border: 1px solid darkgray;
				background-color: gray;
				font-weight: bold;
			}
			
			#buttonGroup a:hover {
				color: black;
				background-color: lightgray;
			}
			
		</style>
		
		<script type="text/javascript">
			function sendData() {
				//값의 유효성 검사
				//var form = document.querySelector("#modifyForm");
				var modifyForm = document.modifyForm;
				console.log(modifyForm);
				
				//var title = document.querySelector("#title");
				var title = document.modifyForm.title;
				console.log(title);
				
				var content = document.modifyForm.content;
				console.log(content);
				
				if(title.value == "" || content.value == "") {
					alert("제목과 내용을 입력해주세요.")
					return;
				}
				//서버로 전송
				modifyForm.submit();
			}
		</script>
	</head>
	<body>
		<h4>게시물 보기</h4>
				
		<form id="modifyForm" name="modifyForm" method="post" action="update">
			<span class="title">번호</span>
			<span class="content">${board.no}</span> <br/>
			<input type="hidden" name="no" value="${board.no}">
			
			<span class="title">제목</span> 
			<input id="title" type="text" name="title" value="${board.title}"> <br/>
			
			<span class="title">글쓴이</span> 
			<span class="content">${board.writer}</span> <br/>		
			
			<span class="title">날짜</span> 
			<span class="content">${board.date}</span> <br/>
			
			<span class="title">조회수</span> 
			<span class="content">${board.hitcount}</span> <br/>
			
			<span class="title">내용</span> <br/>
			<textarea name="content" cols="30" rows="5">${board.content}</textarea>
		</form> 
		<div id="buttonGroup">			
			<a href="javascript:sendData()">수정</a>
			<a href="detail?boardNo=${board.no}">취소</a>
		</div>	
	</body>
</html>