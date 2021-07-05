<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="insert.do" method="post">
<table border="1">
	<tr>
		<td>이메일</td>
		<td><input type="text" name="email" value=""></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input type="text" name="mname" value=""></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="pwd"></td>
	</tr>
	<tr>
		<td colspan="2">
			<table>
				<tr>
					<td>학교명</td><td>졸업년도</td>
				</tr>
				<tr>
					<td><input type="text" name="school"></td>
					<td><input type="text" name="year"></td>
				</tr>
				<tr>
					<td><input type="text" name="school"></td>
					<td><input type="text" name="year"></td>
				</tr>
				<tr>
					<td><input type="text" name="school"></td>
					<td><input type="text" name="year"></td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="등록">
		</td>
	</tr>
</table>
</form>
</body>
</html>