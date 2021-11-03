<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>4_1_Insert</title>
	<%--
		일자 : 2021-08-05 16:52
		이름 : 박은비
		내용 : Database Insert
		
	 --%>
</head>
<body>
	<h3>1.JSP Insert 실습하기</h3>
	
	<h4>User 등록</h4>

	<form action="./proc/insertProc.jsp" method="post">
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

