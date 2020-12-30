<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
a:visited{
color: blue;
}
a{
text-decoration: none;
}
</style>
</head>
<body>
	
	<h2> ${mid}님 반갑습니다~</h2>
	<h3> <a href="memberUpdate?id=${mid}">정보수정</a></h3>
	<c:if test="${mid eq 'ADMIN'}">
	<h3> <a href="memberList">회원 목록 보기</a></h3>
	</c:if>
</body>
</html>