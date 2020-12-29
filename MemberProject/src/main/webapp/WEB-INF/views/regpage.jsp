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
}
</style>
<body>

<form action="regmember" method="post">
<table>
<tr> <td> 아이디  </td>  <td> <input type="text" name="mid"> </td> </tr>
<tr> <td> 비밀번호  </td>  <td> <input type="password" name="mpassword"> </td> </tr>
<tr> <td> 이름  </td>  <td> <input type="text" name="mname"> </td> </tr>
<tr> <td> 전화번호  </td>  <td> <input type="text" name="mphone"> </td> </tr>
<tr> <td> 이메일  </td>  <td> <input type="email" name="memail"> </td> </tr>
<tr> <td> 생년월일  </td>  <td> <input type="date" name="mbirth"> </td> </tr>
<tr> <td colspan="2"> <input type="submit" value="회원가입"> </td> </tr>
</table>
</form>
</body>
</html>