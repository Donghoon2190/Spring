<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
table,tr,td{
text-align:center;
margin :auto;
border: 1px solid black;
border-collapse: collapse;
padding: 7px;
}


</style>
<body style="text-align: center;">
<form action="logincontroll" method="post">
<table>
<tr> <td> 아이디  </td>  <td> <input type="text" name="mid"> </td> </tr>
<tr> <td> 비밀번호  </td>  <td> <input type="password" name="mpwd"> </td> </tr>
<tr> <td colspan="2"> <input type="button" value="메인으로" onclick="location.href='./'"> <input type="submit" value="로그인">  </td> </tr>
</table>
<span>${value}</span>
</form>
</body>
</html>