<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="login.do" method="post">
<table border="1">
	<tr>
		<td>이메일</td>
		<td>
			<input type="text" name="email" value="${memberVo.email }"><br>
			<input type="checkbox" name="checkEmail" value="check" <c:if test="${memberVo.checkEmail == 'check'}">checked</c:if>>이메일 저장
		</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="pwd"></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="로그인">
		</td>
	</tr>
</table>
</form>
</body>
</html>