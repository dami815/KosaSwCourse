<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Product Board</title>
		<style type="text/css">
			h4 {
				color: black;
			}
			table {
				width: 100%;
				border-collapse: collapse;				
				text-align: center;				
			}
			table, th, td {
				border: 1px solid black;
				color: black;
			}
			th {
				background-color: #800000;
				color: white;
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
			
			#pager {
				margin: 5px;
				font-size: small;
				text-align: center;				
			}
			
			#pager a {
				text-decoration: none;
				color: black;
			}
			
			#pager a:hover {
				color: #800000;
			}
			
			#pager a.pageNo.selected {
				font-weight: bold;
				color: #800000;
			}
			
			.title {
				text-decoration: none;
				color: black;
			}
			
			.title:hover {
				color: #800000;
			}
			
		</style>
	</head>
	<body>
		<h4>상품 목록</h4>
		
		<table>
			<tr>
				<th style="width:50px">번호</th>
				<th>상품명</th>
				<th style="width:90px">가격</th>				
			</tr>
			
			<c:forEach var="product" items="${list}">
				<tr>
					<td>${product.no}</td>
					<td><a class="title" href="detail?productNo=${product.no}">${product.name}</a></td>
					<td>${product.price}</td>
				</tr>
			</c:forEach>
			
		</table>
		
		<div id="pager">			
			<a href="list?pageNo=1">[처음]</a>
			
			<c:if test="${groupNo>1}">
				<a href="list?pageNo=${startPageNo-pagesPerGroup}">[이전]</a>	
			</c:if>					
			
			<c:forEach var="i" begin="${startPageNo}" end="${endPageNo}">
				<a class="pageNo <c:if test="${pageNo==i}">selected</c:if>" href="list?pageNo=${i}">${i}</a>
			</c:forEach>			
			
			<c:if test="${groupNo<totalGroupNo}">
				<a href="list?pageNo=${endPageNo+1}">[다음]</a>	
			</c:if>	
					
			<a href="list?pageNo=${totalPageNo}">[맨끝]</a>
		</div>
				
		<div id="buttonGroup">
			<a href="writeForm">상품 등록</a>			
		</div>	
	</body>
</html>