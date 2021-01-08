<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Example</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link href="./resources/css/main.css" rel="stylesheet">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<style type="text/css">
.aa:hover {
	background-color: #3e4068;
}

.aa {
	height: 100px;
}
</style>
</head>
<body style="background-color: lightgoldenrodyellow;">
${value}
	<div class="container contact">
		<div class="row">
			<div class="col-md-3">
				<div class="contact-info">
					<img src="https://image.ibb.co/kUASdV/contact-image.png"
						alt="image" />
					<h2>Welcome</h2>
					<h4>member !</h4>
					<br>
					<div class="form-group">
						<div class="contact-form">
							<div class="col-sm-offset-2 col-sm-10">
								<button class="btn btn-default aa" onclick="location.href='LoginPage'"
									style="width: 100%; height: 50px;">Log Out!</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-9">
				<div class="contact-form">
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button class="btn btn-default aa" onclick="myPage()">MyInfo</button>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button class="btn btn-default aa">Writing</button>
						</div>
					</div>
					<c:if test="${id eq 'ADMIN'}">
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button class="btn btn-default aa" onclick="location.href='getUserList'">UserList</button>
							</div>
						</div>
					</c:if>
				<br>

			</div>
		</div>

	</div>
	<div id="here"></div>
</div>


</body>
<script type="text/javascript">
	function myPage() {
		let userid = '${id}';
		console.log(userid);
		$.ajax({
			data : {
				"uid" : userid
			},
			type : 'post',
			dataType : 'JSON',
			url : "myPage",
			success : function(data) {
				reply(data);
			},
			error : function() {
				alert('다시시도해주셈');
			}

		});

	}

	function reply(data) {
		let out = "";
		out += '<div class="col-md-9" style=" text-align: center;  margin: auto; margin-top: 4%; border-radius: 0.5rem; padding: 1%;">';
		out += "<table style='width: 100%;text-align: center;'>";
		out += "<colgroup width='20%'>"
		out += "<colgroup width='10%'>"
		out += "<colgroup width='15%'>"
		out += "<colgroup width='20%'>"
		out += "<colgroup width='20%'>"
		out += "<colgroup width='15%'>"
		out += "<tr> <th>Id</th>  <th>Name</th>  <th>Birth</th>  <th>Email</th>  <th>Address</th> <th>Phone</th></tr>"
		out += "<tr> <th>"
				+ data.uid
				+ "</th>  <th>"
				+ data.uname
				+ "</th>  <th>"
				+ data.ubirth
				+ "</th><th>"
				+ data.uemail
				+ "</th>  <th>"
				+ data.uadd
				+ "</th> <th>"
				+ data.uphone
				+ "</th><th><button class='btn btn-default aa' "
				+ "onclick="
				+ "location.href='modifyPage'"
				+ " style=' background: #25274d; color: #fff; font-weight: 600; width: 100%; height: 45px;'>Modify</button></th></tr>"
		out += "</table>"
		out +="<button class='btn btn-default aa' style=' background: #25274d; color: #fff; font-weight: 600; width: 20%; height: 45px;' onclick="+"$('#here').html(\"\")>"+"Close</button>";
		out += '</div>';

		console.log(out);
		$('#here').html(out);

	}
</script>

</html>










