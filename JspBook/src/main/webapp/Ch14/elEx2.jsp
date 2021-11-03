<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>표현 언어의 표현식 사용 예제 - 내장 객체 사용</title>
</head>
<body>
	<form action="elEx2.jsp" method="post">
		<ul>
			<li><label for="name">이름</label>
			<input type="text" id="name" name="name" value="${param['name'] }" >
			<input type="submit" value="확인"></li>
			<li><p>이름 : ${param.name }</p></li>
		</ul>
	</form>

</body>
</html>