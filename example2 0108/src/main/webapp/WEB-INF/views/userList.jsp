<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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

a {
	text-decoration: none;
}
</style>
</head>
<body style="background-color: lightgoldenrodyellow;">
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
								<button class="btn btn-default" onclick="location.href='Main'"
									style="width: 100%; height: 50px;">Main</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-9" style="text-align: center;">
				<div class="contact-form">

					<table
						style="margin:10% auto 20px auto; text-align: center;">
						<colgroup>
							<col width="10%">
							<col width="25%">
							<col width="25%">
							<col width="20%">
							<col width="20%">
						</colgroup>
						<tr> <th>Id</th> <th>Name</th> <th>Address</th> <th>Detailed View</th> <th>Delete</th> </tr>
						<c:forEach var="i" items="${jlist}">
							<tr>
								<td>${i.uid}</td>
								<td>${i.uname}</td>
								<td>${i.uadd}</td>
								<td><a href="#return false" onclick="userDetail('${i.uid}')"> Detailed View </a></td>
								<td><a href="UserDelete?uid=${i.uid}">Delete</a></td>
							</tr>
						</c:forEach>
					</table>
					<c:if test="${paging.page<=1}">
	[이전]&nbsp;
	</c:if>

					<c:if test="${paging.page>1}">
						<a href="getUserList?page=${paging.page-1}">[이전]</a>&nbsp;
	</c:if>

					<c:forEach begin="${paging.startPage}" end="${paging.endPage}"
						var="i" step="1">
						<c:choose>
							<c:when test="${i eq paging.page}">
			${i}
			</c:when>
							<c:otherwise>
								<a href="getUserList?page=${i}">${i}</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>

					<c:if test="${paging.page>=paging.maxPage}">
		[다음]
	</c:if>

					<c:if test="${paging.page<paging.maxPage}">
						<a href="getUserList?page=${paging.page+1}">[다음]</a>
					</c:if>
				</div>
			</div>
		</div>
	</div>
	<div id="here"></div>
</body>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	function userDetail(data) {

		let list = ${jlist};

		for (var i = 0; i < list.length; i++) {
			if (list[i].uid === data) {
				let out = "";
				out += '<div class="col-md-9" style=" text-align: center;  margin: auto; margin-top: 4%; border-radius: 0.5rem; padding: 1%;">';
				out += "<table style='width: 100%; text-align: center;'>";
				out += "<colgroup width='20%'>"
				out += "<colgroup width='10%'>"
				out += "<colgroup width='15%'>"
				out += "<colgroup width='20%'>"
				out += "<colgroup width='20%'>"
				out += "<colgroup width='15%'>"
				out += "<tr> <th>Id</th>  <th>Name</th>  <th>Birth</th>  <th>Email</th>  <th>Address</th> <th>Phone</th></tr>"
				out += "<tr> <th>" + list[i].uid + "</th>  <th>" + list[i].uname + "</th>  <th>" + list[i].ubirth + "</th><th>" + list[i].uemail + "</th>  <th>" + list[i].uadd + "</th> <th>" + list[i].uphone
				+ "</th><th><button class='btn btn-default aa' " + "onclick=" + "location.href='modifyPage?+'" + " style=' background: #25274d; color: #fff; font-weight: 600; width: 100%; height: 45px;'>Modify</button></th></tr>"
				out += "</table>"
				out += "<button class='btn btn-default aa' style=' background: #25274d; color: #fff; font-weight: 600; width: 20%; height: 45px;' onclick="
						+ "$('#here').html(\"\")>" + "Close</button>";
				out += '</div>';
				$('#here').html(out);

			}
		}

	}
</script>
</html>













