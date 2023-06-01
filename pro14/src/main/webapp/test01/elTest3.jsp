<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현 언어로 여러 가지 데이터 출력하기</title>
</head>
<body>
	<h1>여러가지 비교 연산자</h1>
	<h2>
		\${10==10}: ${10==10}<br>
		\${10 eq 10}: ${10 eq 10}<br>
		\${"hello"=="hello"}: ${"hello"=="hello"}<br>
		\${"hello" eq "hello"}: ${"hello" eq "hello"}<br>
		
		\${20!=10}: ${20!=10}<br>		
		<%-- \${20 ne 10}: ${20 ne 10}<br><br> --%>
		
		\${"hello"!="hello"}: ${"hello"!="hello"}<br>
		<%-- \${"hello"! ne "hello"}: ${"hello" ne "hello"}<br><br> --%>
		
		\${10 < 10}: ${10 < 10}<br>
		\${10 lt 10}: ${10 lt 10}<br><br>
		
		\${10 > 10}: ${10 > 10}<br>
		\${10 gt 10}: ${10 gt 10}<br><br>
		
		\${100 > 10}: ${100 > 10}<br>
		\${100 le 10}: ${100 le 10}<br><br>
		
		\${100 <= 10}: ${100 <= 10}<br>
		\${100 le 10}: ${100 le 10}<br><br>
		
		\${100 >= 10}: ${100 >= 10}<br>
		\${100 ge 10}: ${100 ge 10}<br><br>
	</h2>
</body>
</html>