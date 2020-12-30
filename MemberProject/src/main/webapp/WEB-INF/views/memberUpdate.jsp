<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<form action="memberModify" method="post">
<table>
<tr> <th colspan="2"> 변경 전</th> <th>변경할 데이터</th> </tr>
<tr> <th> 아이디 </th> <td>  ${member.mid} </td> <td> <input type="hidden" name="mid" value="${member.mid}"></td> </tr>
<tr><th> 비밀번호 </th> <td>  ${member.mpwd} </td> <td> <input type="password" name="mpwd"> </td> </tr>
<tr><th> 이름 </th> <td> ${member.mname} </td> <td><input type="text" name="mname"> </td> </tr>
<tr><th> 핸드폰번호 </th><td>${member.mphone}</td> <td><input type="text" name="mphone">  </td> </tr>
 <tr><th> 이메일 </th><td>${member.memail}</td> <td> <input type="email" name="memail"> </td> </tr>
 <tr><th> 생년월일 </th><td>${member.mbirth}</td> <td> <input type="date" name="mbirth"> </td> </tr>
 <tr> <td colspan="3"> <input type="submit" value="수정"> </td> </tr>
</table>
</form>
</body>
</html>











