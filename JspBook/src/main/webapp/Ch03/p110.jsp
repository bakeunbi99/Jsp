<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>선언문 예제 - 메소드선언</title>
</head>
<body>
	<h2>선언문 예제 - 메소드선언</h2>
	<!-- 멤버 변수 id와 메소드 getId()를 선언하는 부분 -->
	<%!
		String id = "Kingdora";
		
		public String getId() {
			return id;
		}
	%>
	<!-- id 변수의 내용과 getId() 메소드의 실행 결과를 출력하는 부분 -->
	결과 : <%=id %> <br>
	getId() 메소드 실행결과 : <%= getId() %>
	
	
	
</body>
</html>