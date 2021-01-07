<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page session="false" %>
<html>
<head>
	<title>Example</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="./resources/css/main.css" rel="stylesheet">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<style type="text/css">
.aa:hover{
background-color: #3e4068;
}
</style>
</head>
<body style="background-color: lightgoldenrodyellow;">
${value}
<div class="container contact">
	<div class="row">
		<div class="col-md-3">
			<div class="contact-info">
				<img src="https://image.ibb.co/kUASdV/contact-image.png" alt="image"/>
				<h2>Welcome</h2>
				<h4>member !</h4>
				<br>
				<div class="form-group">   
				<div class="contact-form">        
				  <div class="col-sm-offset-2 col-sm-10">
					<button class="btn btn-default" onclick="location.href='./'" style="width: 100% ; height: 50px;">Sign Up!</button>
				  </div>
				    </div>
				</div>
			</div>
		</div>
		<div class="col-md-9" >
			<div class="contact-form">
			<form action="Login" method="post">
				<div class="form-group">
				  <label class="control-label col-sm-2" for="fname">Id:</label>  <span style="color: red;">${id}</span>
				  <div class="col-sm-10">          
					<input required type="text" class="form-control"  placeholder="Enter Id" name="uid">
				  </div>
				</div>
				
				<div class="form-group">
				  <label class="control-label col-sm-2" for="lname">Pass:</label> <span style="color: red;">${pwd}</span> 
				  <div class="col-sm-10">          
					<input required type="password" class="form-control"placeholder="Enter PassWord" name="upwd">
				  </div>
				</div>
				<div class="form-group">        
				  <div class="col-sm-offset-2 col-sm-10">
					<button class="btn btn-default">Login</button>
				  </div>
				</div>
				
				</form>
				<br>
				
				
			</div>
		</div>
	</div>
</div>
</body>
</html>