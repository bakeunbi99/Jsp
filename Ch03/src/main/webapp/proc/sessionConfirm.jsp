<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>sessionConfirm</title>
</head>
<body>
	<h3>현재 클라이언트 세션확인</h3>
	<%
		//Object를 String 타입으로 캐스팅
		String sid = session.getId(); //현재 클라이언트의 id(유일값), 중복되면 안되므로 유니버셜 아이디로 저장됨
		String uid = (String)session.getAttribute("uid");
		String pass = (String)session.getAttribute("pass");
	%>
	
	<p>
		클라이언트 세션아이디 : <%= sid %> <br>
		클라이언트 아이디 : <%= uid %> <br>
		클라이언트 비밀번호 : <%= pass %> <br>
	</p>

	<a href="../3_4_Session.jsp"> 로그인 하기 </a>
</body>
</html>




