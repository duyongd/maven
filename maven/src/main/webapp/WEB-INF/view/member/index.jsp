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
<div>
<c:if test="${!empty memberInfo}">
<input id="logoutBtn" type="button" value="로그아웃" onclick="location.href='logout.do';">
<input id="logoutBtn" type="button" value="마이페이지" onclick="location.href='mypage.do';">
</c:if>
<c:if test="${empty memberInfo}">
<input id="loginBtn" type="button" value="로그인" onclick="location.href='form.do';"> 
</c:if>
</div>

<c:forEach var="member" items="${list}">
${member.mno} ${member.mname }, ${member.email}<br>
</c:forEach>
<hr>
<%@ page import="chap07.*" %>
<%@ page import="java.util.*" %>
<%
List<MemberVo> list =(List<MemberVo>)request.getAttribute("list");
%>
<% for(int i=0; i<list.size(); i++) { %>
<%=list.get(i).getMno() %> <%=list.get(i).getEmail()%> <%= list.get(i).getMname()%><br>
<%} %>
</body>
</html>