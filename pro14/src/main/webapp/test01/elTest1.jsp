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
	<h1>표현 언어로 여러가지 데이터 출력하기</h1>
	<h1>
		\${100 }: ${100 }<br>
		\${"안녕하세요" }: ${ "안녕하세요" }<br>
		\${10+1 }: ${10+1 }<br>
		\${"10"+1 }: ${"10"+1 }<br>		
		
		<%-- \${null+10 }: ${null+10 }<br> --%>
	 	<%-- \${"안녕"+11 }: ${"안녕"+1 }<br> --%>
		<%-- \${"hello"+11 }: ${"hello"+1 }<br> --%>
		
	</h1>
</body>
</html>