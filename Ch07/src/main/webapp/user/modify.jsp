<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>modify</title>
	<!-- 
		날짜 : 2021-09-08 09:49
		내용 : MVC
	 -->
</head>
<body>
	<h3>User 수정</h3>

	<form action="#" method="post">
		
		<table border="1">
			<tr>
				<td> 아이디 </td>
				<td> <input type="text" name="uid" readonly value="${user.getUid() }" /> </td>
			</tr>
		
			<tr>
				<td> 이름 </td>
				<td> <input type="text" name="name" value="${user.getName() }"/> </td>
			</tr>
			
			<tr>
				<td> 휴대폰 </td>
				<td> <input type="text" name="hp" value="${user.getHp() }"/> </td>
			</tr>
			<tr>
				<td> 나이 </td>
				<td> <input type="text" name="age" value="${user.getAge() }"/> </td>
			</tr>
			
			<tr>
				<td colspan = "2" aling="right">
					<input type="submit" value="등록"/>
			</tr>
			
		</table>
		
	</form>
</body>
</html>