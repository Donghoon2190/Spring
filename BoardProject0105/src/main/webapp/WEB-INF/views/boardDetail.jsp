<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
table, tr, td ,th{
   text-align: center;
   margin: auto;
   border: 1px solid black;
   border-collapse: collapse;
   padding: 10px;
}

body {
   text-align: center;
}
a{
text-decoration: none;
font-size: 20px;
font-weight: bold;
color: gray;
}
a:visited{
	color: gray;
}
a:hover{
color: lightgray;
}
</style>
<body>

      <table>
         <tr>
            <td>제목</td>
            <td>${board.btitle}</td>
         </tr>
         <tr>
            <td>글번호</td>
            <td>${board.bnum}</td>
         </tr>
         <tr>
            <td>작성자</td>
            <td>${board.bwriter}</td>
         </tr>
         <tr>
            <td>글조회수</td>
            <td>${board.bhits}</td>
         </tr>
         <tr>
            <td>작성날짜</td>
            <td>${board.bdate}</td>
         </tr>
         <tr>
            <td colspan="2" style="padding: 0"><textarea rows="15" cols="40" style="resize: none;" name="bcontents">${board.bcontents}</textarea></td>
         </tr>
<tr>
            <td colspan="2"> <img alt="ergergbres" width="300" height="200" src="resources/uploadFile/${board.bfilename}"> </td>
         </tr>
      </table>
      <br>
      <button onclick="location.href='pagingPage?page=${page}'">목록</button>
   <button onclick="location.href='Modifypage?bnum=${board.bnum}&btitle=${board.btitle}&bcontents=${board.bcontents}'">수정</button>
   <button onclick="location.href='BoardDelete?bnum=${board.bnum}'">삭제</button>
   <a href="./">홈으로가기</a>
   <br><br>
   작성자 : <input type="text" id="cwriter"> <br><br>
  &nbsp;&nbsp; &nbsp; 내용 :   &nbsp;&nbsp;&nbsp;<textarea style="resize: none;" rows="3" cols="15" name="breply" id="breply" ></textarea>
   <button onclick="replyreg()">댓글작성</button>
   
   
   <div id="here"></div>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript">

$(document).ready(()=>{
	let cbnumber = ${board.bnum};
	$.ajax({
		data : {'cbnumber' : cbnumber},
		type : 'post',
		dataType :'JSON',
		url : 'comment/getcomment',
		success : function (data) {
			console.log(data);
			reply(data);
		},
		error : function (data) {
			alert('에러')
		}
		
		
	});
})

function replyreg() {
	
	let breply = $('#breply').val();
	let cwriter = $('#cwriter').val();
	$.ajax({
		data : {'cbnumber':${board.bnum},'ccontents':breply,'cwriter':cwriter},
		type : 'post',
		dataType : 'JSON',
		url : 'comment/commentwrite',
		
		success : function(data) {
			reply(data)
			$('#breply').val("");
			$('#cwriter').val("");
		},
		error : function() {
			alert('오류')
		}
		
		
	});
}
function reply(data){
	console.log(data)
    let out = "";
    out += '<table>';
    out += '<tr> <th>작성자</th>';   
    out += '<th>내용</th></tr>';
    for (var i = 0; i < data.length; i++) {
       out += '<tr>';   
       out += '<td>';
       out += data[i].cwriter;
       out += '</td>';
       out += '<td>';
       out += data[i].ccontents;
       out += '</td>';
       out += '<tr>';
    }

    out += '</table>';
    $('#here').html(out);
 }
</script>
</html>

























