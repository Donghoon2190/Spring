<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Example</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="./resources/css/main.css" rel="stylesheet">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
</head>
<body style="background-color: lightgoldenrodyellow;">
<div class="container contact">
	<div class="row">
		<div class="col-md-3">
			<div class="contact-info">
				<img src="https://image.ibb.co/kUASdV/contact-image.png" alt="image"/>
				<h2>Sign up</h2>
				<h4>as a member !</h4>
			</div>
		</div>
		<div class="col-md-9" >
			<div class="contact-form">
			<form action="userReg" method="post" name="formN" enctype="multipart/form-data">
				<div class="form-group">
				  <label class="control-label col-sm-2" for="fname">Id:</label>  <span id="confirmId"></span>
				  <div class="col-sm-10">          
					<input required type="text" onchange="CheckId()" class="form-control" id="uid" placeholder="Enter Id" name="uid">
				  </div>
				</div>
				
				<div class="form-group">
				  <label class="control-label col-sm-2" for="lname">Pass:</label><span id="confirmPw" ></span> 
				  <div class="col-sm-10">          
					<input required type="password" class="form-control" id="upwd" placeholder="Enter PassWord" name="upwd">
				  </div>
				</div>
				
				<div class="form-group">
				  <label class="control-label col-sm-2" for="lname">Check Pass:</label><span id="result"  ></span>
				  <div class="col-sm-10">          
					<input required type="password" onkeyup="CheckPw()" class="form-control" id="checkpwd" placeholder="One More PassWord">
				  </div>
				</div>
				
				<div class="form-group">
				  <label class="control-label col-sm-2" for="email">Name:</label>
				  <div class="col-sm-10">
					<input required type="email" class="form-control" id="uname" placeholder="Enter Name" name="uname">
				  </div>
				</div>
				<div class="form-group">
				  <label class="control-label col-sm-2" for="email" style="width: 80px">Gender:</label>
				 남 &nbsp;&nbsp;<input type="radio" name="ugender" value="남자">
				 여 &nbsp;&nbsp;<input type="radio" name="ugender" value="여자">
				</div>
				<div class="form-group">
				  <label class="control-label col-sm-2" for="comment">Birth:</label>
				  <div class="col-sm-10">
					<input required type="date" style=" width: 170px;" class="form-control" id="ubirth" placeholder="Enter Birth" name="ubirth">
				  </div>
				</div>
				<div class="form-group">
				  <label class="control-label col-sm-2" for="comment">Email:</label>
				  <div class="col-sm-10">
					<input required type="email" class="form-control" id="uemail" placeholder="Enter Email" name="uemail">
				  </div>
				</div>
				<div class="form-group">
				  <label class="control-label col-sm-2" for="comment">Location:</label>
				  <div class="col-sm-10">
					<input required type="text" class="form-control" id="uadd" placeholder="Enter Location" name="uadd">
				  </div>
				</div>
				<div class="form-group">
				  <label class="control-label col-sm-2" for="comment">Phone:</label> <span id="confirmPhone"></span>
				  <div class="col-sm-10">
					<input required type="text" onkeyup="phoneConfirm()" class="form-control" maxlength="11" id="uphone" placeholder="Enter Phone Number" name="uphone">
				  </div>
				</div>
				<div class="form-group">        
				   <label class="control-label col-sm-2" for="comment">Profile:</label>
				   <div class="col-sm-offset-2 col-sm-10">
					<input type="file" value="파일 선택" name="file">
				  </div>
				</div>
				</form>
				<br>
				<div class="form-group">        
				  <div class="col-sm-offset-2 col-sm-10">
					<button class="btn btn-default" onclick="gosubmit()">Submit</button>
				  </div>
				</div>
				
			</div>
		</div>
	</div>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript">
var pass = document.getElementById("upwd");
var idCheck = false;
var pwd = false;
var pwdCheck = false;
var phone = false;
upwd.addEventListener('keyup',()=>{
	CheckPw();
	pwConfirm();
})

function CheckId() {
	
	var userid = document.getElementById("uid").value; 
		$.ajax({
			type : "post" ,
			url : "CheckId" ,				
			data : { "uid" : userid } ,		
			dataType : "text" ,
			success : function(result){
				console.log("result : " + result);
				if(result=="null"||result==""){
					if (userid!="") {
						idCheck=true;
						confirmId.style.color = "#0000ff";
						confirmId.innerHTML = userid + "은(는) 사용 가능한 아이디입니다.";
					}else {
						idCheck=false;
						confirmId.style.color = "#ff0000";
						confirmId.innerHTML = "아이디를 입력해주세요.";
					}
					
				} else {
					idCheck=false;
					confirmId.style.color = "#ff0000";
					confirmId.innerHTML = userid + "은(는) 사용중인 아이디입니다.";
				}
			},	
			error : function() {
				alert('다시 시도해 주세요.')
			}		
		});
	
}
function phoneConfirm(){
	var uphone = document.getElementById("uphone").value;
	var confirmPhone = document.getElementById("confirmPhone");

	if(/\D/.exec(uphone)){
		phone=false;
		confirmPhone.style.color = "#ff0000";
		confirmPhone.innerHTML = "숫자만 입력해주세요!";
	}else {
		phone=true;
		confirmPhone.innerHTML = "";
	}
}
function pwConfirm(){
	var userPw = document.getElementById("upwd").value;
	var confirmPw = document.getElementById("confirmPw");
	
	var num = userPw.search(/[0-9]/g);
	var eng = userPw.search(/[a-z]/ig);
	var spe = userPw.search(/[`~!@@#$%^&*|₩₩₩'₩';:₩/?]/gi);
	
	if(userPw.search(/\s/)!=-1){
		pwd=false;
		confirmPw.style.color = "#ff0000";
		confirmPw.innerHTML = "비밀번호는 공백 없이 입력해주세요!";
	} else if (userPw.length < 8 || userPw.length > 20){
		pwd=false;
		confirmPw.style.color = "#ff0000";
		confirmPw.innerHTML = "8자리 ~ 20자리 이내로 입력해주세요!";
	} else if( num < 0 || eng < 0 || spe < 0 ){
		pwd=false;
		confirmPw.style.color = "#ff0000";
		confirmPw.innerHTML = "영문, 숫자, 특수문자를 혼합하여 입력해주세요!";
	} else {
		pwd=true;
		confirmPw.style.color = "#0000ff";
		confirmPw.innerHTML = "적절한 비밀번호 입니다!";
	}
}
function CheckPw() {
	var userPw = document.getElementById("upwd").value;
	var userPw2 = document.getElementById("checkpwd").value;
	var result = document.getElementById("result");
	if (userPw==userPw2) {
		if (userPw!="") {
			pwdCheck=true;
			result.style.color = "blue";
			result.innerHTML = "비밀번호가 일치합니다";
		}else {
			pwdCheck=false;
			result.style.color = "red";
			result.innerHTML = "비밀번호를 입력해주세요.";
		}
	}else {
		pwdCheck=false;
		result.style.color = "red";
		result.innerHTML = "비밀번호가 일치하지 않습니다.";
	}
}
function gosubmit() {
	if (idCheck==true) {
		if (pwd==true) {
			if (pwdCheck==true) {
				if (phone==true) {
					formN.submit();
				}else {
					alert("핸드폰번호에 숫자만 입력하세요");
					uphone.focus();
				}
				
			}else {
				alert("비밀번호가 일치하지 않습니다.");
				checkpwd.focus();
			}
		}else {
			alert("비밀번호 양식을 맞춰주세요.");
			upwd.focus();
		}
	}else {
		alert("아이디를 확인해주세요.");
		uid.focus();
	}
	
}
</script>
</html>











