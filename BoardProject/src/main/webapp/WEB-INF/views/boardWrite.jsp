<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
table, tr, td {
	text-align: center;
	margin: auto;
	border: 1px solid black;
	border-collapse: collapse;
	padding: 10px;
}
body {
	text-align: center;
}
.b{
color: gray;
}
.b:hover{
color: white;
}
</style>
<body>
<form action="boardWriter" method="post">
<table>
<tr> <td> 제목 </td> <td> <input type="text" name="btitle"> </td> </tr>
<tr> <td> 작성자 </td> <td> <input type="text" name="bwriter"> </td> </tr>
<tr> <td> 글비밀번호 </td> <td> <input type="password" name="bpwd"> </td> </tr>
<tr> <td colspan="2" style="padding: 0"> <textarea rows="15" cols="40" style="resize: none;" name="bcontents"></textarea> </td> </tr>
<tr> <td colspan="2"> <input class="b" style="width: 100px; height: 40px;font-weight: bold; font-size: 17px;" type="button" onclick="location.href='./'" value="메인으로"> &nbsp;&nbsp;&nbsp; 
<button class="b"  style="width: 100px; height: 40px;font-weight: bold;font-size: 17px;">글 작성</button> </td> </tr>
</table>
</form>
</body>
</html>














