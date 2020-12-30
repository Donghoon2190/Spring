<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table,td,tr,th{
border: 1px solid black;
text-align: center;
margin: auto;
border-collapse: collapse;
padding: 10px;
}
</style>
</head>
<body>
<table>
<tr> <th> 아이디 </th>  <th> 비밀번호 </th> <th> 이름 </th> <th> 핸드폰번호 </th> <th> 이메일 </th> <th> 생년월일 </th></tr>
<tr> <td>  ${member.mid} </td> <td>  ${member.mpwd} </td> <td> ${member.mname} </td> <td>${member.mphone}</td> <td>${member.memail}</td> <td>${member.mbirth}</td> </tr>
</table>
</body>
</html>