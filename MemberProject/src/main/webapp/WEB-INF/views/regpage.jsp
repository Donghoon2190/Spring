<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript">
function CheckId() {
	var id = $("#mid").val();
	console.log(id);
	
	$.ajax({
		data : {mid:id},
		url : "CheckId",
		type : "post",
		dataType : "text",
		success : function(data) {
			console.log(data);
			if (data==1) {
				$("#result").css('color','red');
				$("#result").html("이미 사용중인 아이디입니다.");
			}else{
				$("#result").css('color','blue');
				$("#result").html("사용 가능한 아이디입니다.");
			}
		},
		error : function() {
			alert("데이터를 불러오는데 실패했습니다.")
		}
	});
}

</script>
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
</style>
<body>

	<form action="regmember" method="post">
	<span id="result"></span>
		<table>
			<tr><td>아이디  </td>
				<td><input type="text" name="mid" id="mid" onchange="CheckId()"> </td>
			</tr>
			<tr><td>비밀번호</td>
				<td><input type="password" name="mpwd"></td>
			</tr>
			<tr><td>이름</td>
				<td><input type="text" name="mname"></td>
			</tr>
			<tr><td>전화번호</td>
				<td><input type="text" name="mphone"></td>
			</tr>
			<tr><td>이메일</td>
				<td><input type="email" name="memail"></td>
			</tr>
			<tr><td>생년월일</td>
				<td><input type="date" name="mbirth"></td>
			</tr>
			<tr>
				<td colspan="2"> <input type="button" value="메인으로" onclick="location.href='./'"> <input type="submit" value="회원가입">  </td>
			</tr>
		</table>
	</form>
</body>
</html>