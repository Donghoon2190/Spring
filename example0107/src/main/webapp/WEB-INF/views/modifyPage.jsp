<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
<div class="container contact">
	<div class="row">
		<div class="col-md-3">
			<div class="contact-info">
				<img src="https://image.ibb.co/kUASdV/contact-image.png" alt="image"/>
				<h2>Modify</h2>
				<h4>Your Info!</h4>
				<br>
				<div class="form-group">     
				<div class="contact-form">   
				  <div class="col-sm-offset-2 col-sm-10">
					<button class="btn btn-default aa" style="width: 100%; height: 50px" onclick="location.href='Main'">Main</button>
				  </div>
				  </div>
				</div>
			</div>
		</div>
		<div class="col-md-9" >
			<div class="contact-form">
			<form action="modify" method="post" enctype="multipart/form-data">
				<input type="hidden" name="uid" value="${id}">
				<div class="form-group">
				  <label class="control-label col-sm-2" for="lname">Pass:</label> 
				  <div class="col-sm-10">          
					<input required type="password" class="form-control" placeholder="Enter PassWord" name="upwd">
				  </div>
				</div>
				
				<div class="form-group">        
				   <label class="control-label col-sm-2" for="comment">Email:</label>
				   <div class="col-sm-offset-2 col-sm-10">
					<input type="email" class="form-control" name="uemail">
				  </div>
				</div>
				
				<div class="form-group">        
				   <label class="control-label col-sm-2" for="comment">Phone:</label>
				   <div class="col-sm-offset-2 col-sm-10">
					<input type="text" maxlength="11" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" class="form-control" name="uphone">
				  </div>
				</div>
				<div class="form-group">        
				   <label class="control-label col-sm-2" for="comment">Profile:</label>
				   <div class="col-sm-offset-2 col-sm-10">
					<input type="file" value="파일 선택" name="file">
				  </div>
				</div>
				
				<br>
				<div class="form-group">        
				  <div class="col-sm-offset-2 col-sm-10">
					<button class="btn btn-default aa">Submit</button>
				  </div>
				</div>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>