<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Board Writing</title>
	</head>
	<body>
		<form method="post" action="database.jsp">
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
			<input type="reset" value="다시 작성"/>
		</form>
	</body>
</html>


