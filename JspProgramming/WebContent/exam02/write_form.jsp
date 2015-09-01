<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Board Writing</title>
	</head>
	<body>
		<form method="post" action="write.jsp">
			<table id="form_table">
				<tr>
					<td>상품명</td>
					<td><input type="text" name="name"/></td>
				</tr>
				<tr>
					<td>가격</td>
					<td><input type="text" name="price"/></td>
				</tr>				
			</table>
			<input type="submit" value="작성하기"/>			
			<input type="reset" value="다시작성"/>
		</form>
	</body>
</html>


