<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
a{
text-decoration: none;
font-size: 20px;
font-weight: bold;
color: gray;
}
a:visited{
	color: gray;
}
a:hover{
color: lightgray;
}
table, tr, td ,th{
	text-align: center;
	margin: auto;
	border: 1px solid black;
	border-collapse: collapse;
	padding: 10px;
}
body {
	text-align: center;
}
</style>
<body>

	<form action="boardsearch" method="get" name="searchform">
	<select name="searchtype">
	<option value="searchtitle">제목 </option>
	<option value="searchwriter">작성자 </option>
	</select> 
	 <input type="text" name="keyword" placeholder="검색...">
	 <button>검색</button>
	</form>

<table>
<tr> <th> 글번호 </th>  <th> 제목  </th> <th> 작성자 </th> <th>작성일자 </th> <th> 조회수 </th> <th> 삭제 </th> </tr>
	<c:forEach var="i" items="${list}">
	<tr> <td> ${i.bnum} </td>
	 <td> <a href="boardDetail?bnum=${i.bnum}&page=${paging.page}">${i.btitle}</a>  </td>
	  <td> ${i.bwriter} </td> 
	  <td> ${i.bdate} </td> 
	  <td> ${i.bhits} </td> 
	  <td> <a href="BoardDelete?bnum=${i.bnum}">삭제</a> </td> 
	  </tr>
	</c:forEach>
</table>

		<c:if test="${paging.page<=1}">
	[이전]&nbsp;
	</c:if>
	
	<c:if test="${paging.page>1}">
		<a href="pagingPage?page=${paging.page-1}">[이전]</a>&nbsp;
	</c:if>
	
	<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i" step="1">
		<c:choose>
			<c:when test="${i eq paging.page}">
			${i}
			</c:when>
			<c:otherwise>
				<a href="pagingPage?page=${i}">${i}</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>

	<c:if test="${paging.page>=paging.maxPage}">
		[다음]
	</c:if>
	
	<c:if test="${paging.page<paging.maxPage}">
		<a href="pagingPage?page=${paging.page+1}">[다음]</a>
	</c:if>
	

<br>
<a href="./">메인으로</a>
</body>
</html>














