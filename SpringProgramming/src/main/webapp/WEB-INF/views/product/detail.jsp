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
				border: 1px solid #FFFFFF;
				background: #800000;
				color: white;
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
				color: white;
				background-color: #800000;
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
	</head>
	<body>
		<h4>상품 보기</h4>
		<div id="part1">
			<div id="part1_1">
				<span class="title">번호</span> 
				<span class="content">${product.no}</span> <br/>
				
				<span class="title">품명</span> 
				<span class="content">${product.name}</span> <br/>
				
				<span class="title">가격</span> 
				<span class="content">${product.price}</span> <br/>	
												
				<span class="title">사진</span> 
				<span class="content">${product.originalFileName}</span> <br/>
			</div>
			
			<div id="part1_2">				
				<img src="${pageContext.request.contextPath}/resources/uploadfiles/${product.filesystemName}" width="100px" height="100px"/>
				<button>DOWNLOAD</button>
			</div>
		</div>		
		
		<div id="buttonGroup">
			<a href="list">목록</a>
			<a href="updateForm?productNo=${product.no}">수정</a>
			<a href="delete?productNo=${product.no}">삭제</a>
		</div>	
	</body>
</html>