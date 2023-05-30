<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    request.setCharacterEncoding("utf-8");
    %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인창</title>
</head>
<body>
<h1>아이디를 입력해주숑</h1>
 <form name="frmLogin" method="post" action="result.jsp">
 	아이디:<input type="text" name="userID"><br>
 	비밀번호:<input type="password" name="userPw"><br>
 	<input type="submit" value="로그인">
 	<input type="reset" value="다시 입력">
 </form>
</body>
</html>