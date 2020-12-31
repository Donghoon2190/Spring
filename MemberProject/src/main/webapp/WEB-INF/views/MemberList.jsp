<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table,tr,td,th{
margin: auto;
text-align: center;
border: 1px solid black;
border-collapse: collapse;
padding: 10px;
}
a{
text-decoration: none;
}
a:visited{
color: blue;
}
body {
	text-align: center;
}
</style>
</head>

<body>
<table>
<tr> <th> 아이디 </th>  <th> 비밀번호 </th> <th> 이름 </th> <th> 핸드폰번호 </th> <th> 이메일 </th> <th> 생년월일 </th> <th> 조회 </th><th> 수정 </th> <th> 삭제 </th></tr>
<c:forEach var="i" items="${memberList}">
<tr> <td>  ${i.mid}</td> <td> ${i.mpwd} </td> <td>${i.mname}</td>  <td>${i.mphone}</td> <td> ${i.memail}</td> <td> ${i.mbirth}</td> <td> <a href="memberdetail?id=${i.mid}"> <strong> 상세조회</strong></a> <br> <a href='#return false' onclick="ajaxdetail('${i.mid}')"> <strong>ajax상세조회</strong> </a>
</td><td> <a href="memberUpdate?id=${i.mid}"> <strong> 수정</strong></a> </td><td> <a href="memberdelete?id=${i.mid}"> <strong> 회원삭제</strong></a> </td></tr>
</c:forEach>
</table>

<br> <input type="button" value="메인으로" onclick="location.href='main'">
<br><br>
<div id="memberviewdiv"></div>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript">

function ajaxdetail(mid) {
	console.log(mid)
	
	$.ajax({
		type : "post",
		url : "ajaxdetail",
		data : {mid : mid},
		dataType : "json",
		success : function(result) {
			var output = "<table border='1'>";
			output += "<tr><th>ID</th> <th>PASSWORD</th> <th>NAME</th>";
			output += "<th>PHONE</th> <th>EMAIL</th> <th>BIRTH</th></tr>";
			output += "<tr>";
			output += "<td>"+result.mid+"</td>";
			output += "<td>"+result.mpassword+"</td>";
			output += "<td>"+result.mname+"</td>";
			output += "<td>"+result.mphone+"</td>";
			output += "<td>"+result.memail+"</td>";
			output += "<td>"+result.mbirth+"</td>";
			output += "</tr>";
			output += "</table>";
			
			$("#memberviewdiv").html(output);

		},
		error : function() {
			alert("데이터를 불러오는데 실패했습니다.")
		}
		
	});
} 
</script>
</html>



















