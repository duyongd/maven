<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>HttpServletRequest</h3>
이름 : ${name1}<br>
이메일 : ${email1}<br>
<h3>@RequestParam</h3>
이름 : ${name2}<br>
이메일 : ${email2}<br>
번호 : ${no}<br>
<h3>request.getParameter</h3>
이름 : ${param.name}<br>
이메일 : ${param.email}<br>

<h3>커맨드객체(request set)</h3>
이름 : ${vo.name}<br>
이메일 : ${vo.email}<br>
번호: ${vo.no }<br>
<h3>커맨드객체(request set 없이)</h3>
이름 : ${memberVo.name}<br>
이메일 : ${memberVo.email}<br>
번호: ${memberVo.no }<br>
</body>
</html>