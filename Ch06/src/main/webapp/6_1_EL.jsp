<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>6_1_EL</title>
	<!-- 
		날짜 : 2021/09/06 09:30
		내용 : JSP 표현언어(Expression Language) 실습하기
	 -->
</head>
<body>
	<h3>1. 표현언어</h3>
	<%
		String name = "홍길동";
		int num1 = 1;
		int num2 = 2;
		
		// 표현식으로 출력하기 위해 JSP 내장객체로 저장 한 뒤 출력해야 함.
		pageContext.setAttribute("name", name);
		request.setAttribute("num1", num1);
		session.setAttribute("num2", num2);
		
	%>
	
	<h4>표현식</h4>
	<p>
		name : <%= name %><br />
		num1 : <%= num1 %><br />
		num2 : <%= num2 %><br />
		sum : <%= num1+num2 %><br />
	</p>
	<h4>표현언어</h4>
	<p>
		name : ${name} <br />
		num1 : ${num1} <br />
		num2 : ${num2} <br />
		sum : ${num1+num2} <br />
	</p>


</body>
</html>


