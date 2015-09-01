<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="dto.*" %>

<%
int productNo = Integer.parseInt(request.getParameter("product_no"));
%>

<jsp:useBean id="productService" class="service.ProductService" scope="application"/>

<%
Product product = productService.getProduct(productNo);
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
				border: 1px solid darkgray;
				background: lightgray;
				width: 70px;
				text-align: center;
			}
		</style>
	</head>
	<body>
		<h4>상품 목록 보기</h4>
		
		<span class="title">번호</span>
		<span class="content"><%=product.getNo() %></span> <br/>
		<span class="title">상품명</span>
		<span class="content"><%=product.getName() %></span> <br/>
		<span class="title">가격</span>
		<span class="content"><%=product.getPrice() %></span>
		
		<div id="buttonGroup">
			<a href="list.jsp"><img src="../common/images/board/list.gif"/></a>
			<a href="modify_form.jsp?product_no=<%=product.getNo()%>"><img src="../common/images/board/modify.gif"/></a>
			<a href="delete.jsp?product_no=<%=product.getNo()%>"><img src="../common/images/board/delete.gif"/></a>
		</div>
	</body>
</html>