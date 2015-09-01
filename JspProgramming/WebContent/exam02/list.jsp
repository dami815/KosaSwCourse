<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="dto.*, java.util.*" %>

<%
int pageNo = 1;
String strPageNo = request.getParameter("pageNo");
if(strPageNo != null) {
	pageNo = Integer.parseInt(strPageNo);
}
%>

<jsp:useBean 
id="productService" 
class="service.ProductService" 
scope="application"></jsp:useBean>

<%
List<Product> list = productService.getPage(1, 10); 
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Product Board</title>
		<style type="text/css">
			table {
				width: 100%;
				border-collapse: collapse;				
				text-align: center;				
			}
			table, th, td {
				border: 1px solid black;
			}
			th {
				background-color: #FF99CC;
			}
			#buttonGroup {
				margin: 10px;
				text-align: center;
			}
			#pager {
				margin: 5px;
				font-size: small;
				text-align: center;				
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
			<%for(Product product : list) {%>
			<tr>
				<td><%=product.getNo() %></td>
				<td><a href="detail.jsp?product_no=<%=product.getNo()%>"><%=product.getName() %></a></td>
				<td><%=product.getPrice() %></td>
			</tr>
			<%} %>
		</table>
		<div id="pager">
			<a href="#">[처음]</a>
			<a href="#">[이전]</a>
			<a href="#">[숫자]</a>
			<a href="#">[다음]</a>
			<a href="#">[맨끝]</a>
		</div>
		<div id="buttonGroup">
			<a href="write_form.jsp"><img src="../common/images/board/write.gif"/></a>			
		</div>	
	</body>
</html>