<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>session 객체 예제 - 세션 설정 및 무효화</title>
	
</head>
<body>

	<% if(session.getAttribute("id") == null) { %>
	<form action="p159.jsp" method="post">
		<div id="unauth">
			<dl>
				<dd>
					<lable for="id">아이디</lable>
					<input type="text" id="id" name="id" placeholder="kingdora" autofocus required>
				</dd>
				
				<dd>
					<label for="pass">비밀번호</label>
					<input type="password" id="pass" name="pass" placeholder="1234" required>
				</dd>
				
				<dd>
					<input type="submit" value="로그인">
				</dd>
			</dl>
		</div>
	</form>
	<%}else { %>
	<form action="p160.jsp" method="post">
		<div id="auth">
			<dl>
				<dd>
					<%=session.getAttribute("id") %>님 오셨구려..
				</dd>
				<dd>
					<input type="submit" value="로그아웃">
				</dd>
				
			</dl>
		</div>
	</form>
	
	<%} %>
	

	

</body>
</html>