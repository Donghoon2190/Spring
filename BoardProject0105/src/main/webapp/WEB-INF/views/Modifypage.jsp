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
   <form action="BoardModify" method="post">
      <table>
         <tr>
            <td>제목</td>
            <td> <input type="text" name="btitle" placeholder="${btitle}" required> </td>
         </tr>
         <tr>
            <td>비밀번호</td>
            <td> <input type="password" name="bpwd" required> </td>
         </tr>
         <tr>
            <td colspan="2" style="padding: 0"><textarea required rows="15" cols="40" style="resize: none;" name="bcontents" placeholder="${bcontents}"></textarea></td>
         </tr>
      </table>
      <input type="hidden" name="bnum" value="${bnum}">
       <button>수정</button> <a href="./">홈으로가기</a>
   </form>
  
   
</body>
</html>












