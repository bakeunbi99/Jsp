<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title> 선언문 예제 - 선언문과 스크립트릿에서 선언된 변수의 차이 </title>
</head>
<body>
	<h2>선언문 예제 - 선언문과 스크립트릿에서 선언된 변수의 차이</h2>
	
	<!-- 선언문에서 멤버 변수 str1을 선언해서 값을 할당 -->
	<%
		String str1 = "선언문에서 선언한 변수"; //멤버 변수
	%>
	<!-- 스크립트릿에서 지역 변수 str2를 선언해서 값을 할당 -->
	<%
		String str2 = "스크립트릿에서 선언한 변수"; //지역 변수
	%>
	
	
	
</body>
</html>