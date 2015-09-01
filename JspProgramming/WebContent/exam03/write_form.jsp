<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Board Writing</title>
		<style type="text/css">
			body {
				font-size: small;
			}
			input {
				font-size: 12px;
			}			
		</style>
	</head>
	<body>
		<h4>게시물 작성하기</h4>
		<form method="post" action="../mvc/board?action=write" enctype="multipart/form-data">
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
				<tr>
					<td>첨부</td>
					<td><input type="file" name="attach"/></td>				
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;">
						<br/>
						<input type="submit" value="게시물 작성"/>			
						<input type="reset" value="다시 작성"/>
					</td>
				</tr>
			</table>			
		</form>
	</body>
</html>


