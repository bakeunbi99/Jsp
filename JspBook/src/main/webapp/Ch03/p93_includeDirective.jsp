<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="p93_color.jsp" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body bacolor = "<%=bodyback_c %>">
	
	<form action="">
		<dl>
			<dd>
				<lable for="id"> 아이디 </lable>
				<input id="id" type="email" placeholder="example@aaaa.com" required>
			</dd>
			<dd>
				<lable for="pass"> 비밀번호 </lable>
				<input id="pass" type="password" placeholder="비밀번호" required>
			</dd>
			<dd>
				<lable for="name"> 이름 </lable>
				<input id="name" type="text" placeholder="홍길동" required>
			</dd>
			<dd>
				<input type="submit" value="등록">
			</dd>
		</dl>
		
		
	</form>

</body>
</html>