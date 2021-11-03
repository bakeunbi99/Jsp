<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title> register </title>
	
</head>
<body>
	<h3>직원등록</h3>

	<form action="./proc/registerProc.jsp" method="post">
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
				<td> 직급 </td>
				<td> <input type="text" name="pos"/> </td>
			</tr>
			
			<tr>
				<td> 부서코드 </td>
				<td> <input type="text" name="dep"/> </td>
			</tr>
			
			<tr>
				<td colspan = "2" aling="right">
					<input type="submit" value="등록"/>
			</tr>
		</table>
	</form>

</body>
</html>


