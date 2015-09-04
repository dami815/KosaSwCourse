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
				var name = document.modifyForm.name;
				console.log(title);
				
				var price = document.modifyForm.price;
				console.log(content);
				
				if(name.value == "" || price.value == "") {
					alert("제목과 내용을 입력해주세요.")
					return;
				}
				//서버로 전송
				modifyForm.submit();
			}
		</script>
	</head>
	<body>
		<h4>상품 보기</h4>
				
		<form id="modifyForm" name="modifyForm" method="post" action="update">
			<span class="title">번호</span>
			<span class="content">${product.no}</span> <br/>
			<input type="hidden" name="no" value="${product.no}">
			
			<span class="title">품명</span> 
			<input id="title" type="text" name="title" value="${product.name}"> <br/>
									
			<span class="title">가격</span>
			<input id="price" type="number" name="price" value="${product.price}"> <br/>
		</form> 
		<div id="buttonGroup">			
			<a href="javascript:sendData()">수정</a>
			<a href="detail?productNo=${product.no}">취소</a>
		</div>	
	</body>
</html>