<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="send.do" method="post">
이름 : <input type="text" name="name" value="${memberVo.name}"><br>
이메일 : <input type="text" name="email"><br>
취미 : <input type="checkbox" name="hobby" value="1">독서
<input type="checkbox" name="hobby" value="2">게임
<input type="checkbox" name="hobby" value="3">영화
<input type="checkbox" name="hobby" value="4">등산
<input type="hidden" name="no" value="10">
<input type="submit" value="전송"/>
</form>
</body>
</html>