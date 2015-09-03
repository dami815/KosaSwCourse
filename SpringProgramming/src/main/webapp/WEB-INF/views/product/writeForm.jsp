<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Board Writing</title>
		<style type="text/css">
			body {
				font-size: small;
				color: black;
			}
			input {
				font-size: 12px;
			}
		</style>
	</head>
	<body>
		<form method="post" action="write" enctype="multipart/form-data">
			<table id="form_table">
				<tr>
					<td>품명</td>
					<td><input type="text" name="name"/></td>
				</tr>
				<tr>
					<td>가격</td>
					<td><input type="text" name="price"/></td>
				</tr>
				<tr>
					<td>사진</td>
					<td><input type="file" name="attach"/></td>				
				</tr>				
			</table>
			<input type="submit" value="등록하기"/>			
			<input type="reset" value="다시등록"/>
		</form>
	</body>
</html>


