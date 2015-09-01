<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="dto.*" %>

<%
int productNo = Integer.parseInt(request.getParameter("product_no"));
%>

<jsp:useBean id="productService" class="service.ProductService" scope="application"/>

<%Product product = productService.getProduct(productNo); %>

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
				background: lightgray;
				width: 70px;
				text-align: center;
			}
		</style>
		
		<script type="text/javascript">
			function sendData() {
				var modifyForm = document.modifyForm;
				
				var title = document.modifyForm.title;
				
				var price = document.modifyForm.price;
				
				if(title.value == "" || price.value == 0) {
					alert("상품명과 가격을 입력해주세요.")
					return;
				}
				
				modifyForm.submit();
			}
		</script>
	</head>
	<body>
		<h4>상품 수정</h4>
		
		<form id="modifyForm" name="modifyForm" method="post" action="modify.jsp">
			<span class="title">번호</span>
			<span class="content"><%=product.getNo() %></span> <br/>
			<input type="hidden" name="no" value="<%=product.getNo()%>">
			
			<span class="title">상품명</span>
			<input id="title" type="text" name="title" value="<%=product.getName()%>"> <br/>
			
			<span class="title">가격</span>
			<input id="price" type="number" name="price" value="<%=product.getPrice()%>"> <br/>
			
		</form>
		<div>
			<a href="javascript:sendData()">[수정]</a>
			<a href="detail.jsp?product_no=<%=product.getNo()%>">[취소]</a>
		</div>
	</body>
</html>		
