<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>2_5_Include.jsp</title>
	<%--
		일자 : 2021-08-04 10:51
		이름 : 박은비
		내용 : JSP Include 지시자 실습하기
	 --%>
	
</head>
<body>
	<!-- %@ : 선언문 -->
	<h3>5. JSP Include 지시자</h3>
	
	
	<%@ include file="./inc/_header.jsp" %>
	
	<main>
		<h1>메인 영역 입니다.</h1>
	</main>
	
	<%@ include file="./inc/_footer.jsp" %>
	

</body>
</html>