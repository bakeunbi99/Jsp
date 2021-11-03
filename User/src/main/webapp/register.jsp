<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>register</title>
	<!-- 
		날짜 : 2021-09-08 09:49
		내용 : MVC
	 -->
</head>
<body>
	<h3>User 등록</h3>

	<form action="/Ch07/user/register.do" method="post">
		<table border="1">
			<tr>
				<td> 아이디 </td>
				<td> <input type="text" name="uid"/> </td>
			</tr>
		
			<tr>
				<td> 이름 </td>
				<td> <input type="text" name="name"/> </td>
			</tr>
			
			<tr>
				<td> 휴대폰 </td>
				<td> <input type="text" name="hp"/> </td>
			</tr>
			<tr>
				<td> 나이 </td>
				<td> <input type="text" name="age"/> </td>
			</tr>
			<tr>
				<td colspan = "2" aling="right">
					<input type="submit" value="등록"/>
			</tr>
		</table>
		
	</form>
	
</body>
</html>