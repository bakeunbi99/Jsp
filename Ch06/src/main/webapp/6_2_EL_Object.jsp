<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>6_2_EL2</title>
	<!-- 
		날짜 : 2021/09/06 10:00
		내용 : JSP 표현언어(Expression Language) 내장객체 실습하기
	 -->
</head>
<body>

	<h3>표현언어 내장객체</h3>
	
	<%
		pageContext.setAttribute("name", "김유신");
		request.setAttribute("name", "김춘추");
		session.setAttribute("name", "장보고");
		application.setAttribute("name", "강감찬");
	%>
	
	<h4>표현언어</h4>
	<p><!-- 내장객체 지정 -->
		pageContext name : ${pageScope.name} <br />
		request name : ${requestScope.name} <br />
		session name : ${sessionScope.name} <br />
		application name : ${applicationScope.name} <br />
	</p>
	

</body>
</html>

