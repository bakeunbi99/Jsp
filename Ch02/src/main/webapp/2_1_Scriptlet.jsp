<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>2_1_scriptlet</title>
	<!-- 
		일자 : 2021-08-03 pm13:16
		이름 : 박은비
		내용 : JSP 스크립트릿(Scriptlet) 실습하기 교재 p106
		
		스크립트릿(Scriptlet)
			- JSP 문서에서 자바 프로그래밍이 실행되는 코드영역
			- 모델1에서 사용되는 동적 실행 영역
			
		표현식(Expression)
			- 스크립트릿에서 선언된 변수를 참조하여 출력하는 출력 구문
			
		
	 -->
</head>
<body>
	<h3> 1.Scriptlet 기본 </h3>
	
	<%
		//Scriptlet(프로그래밍 영역)
		int var1 = 1;
		boolean var2 = true;
		double var3 = 3.14;
		String var4 = "Hello";
		
		/* java의 출력 개체 out.print, 동적 태그 */
		out.print("<h4> var1 : " + var1 + "</h4>");
		out.print("<h4> var1 : " + var2 + "</h4>");
	
	%>
	
	<%-- 표현식(Expression) 출력 --%>
	<!-- 정적 태그 사이 표현식 문법으로 출력 -->
	<hr>
	<h4>Var3 : <%= var3 %></h4>
	<h4>Var4 : <%= var4 %></h4>
	
	
	
	
	
</body>
</html>



