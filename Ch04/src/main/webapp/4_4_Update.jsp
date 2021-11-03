<%@page import="bean.User1Bean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");

	String uid = request.getParameter("uid");	

	//DB 정보
	//String host="jdbc:mysql://54.180.160.240:3306/p57575777";
	String host="jdbc:mysql://3.38.95.56:3306/p57575777";
	String user = "p57575777";
	String pass = "1234";
	
	User1Bean ub = new User1Bean();
	
	try{
		//1단계
		Class.forName("com.mysql.jdbc.Driver");
		//2단계 - 데이터 베이스 접속
		Connection conn =  DriverManager.getConnection(host, user, pass);
		//3단계 - SQL 실행 객체 생성
		Statement stmt = conn.createStatement();
	
		//4단계
		String sql = "select * from `USER1` WHERE `uid` = '" + uid + "'; ";

		ResultSet rs = stmt.executeQuery(sql);

		
		//out.println( ub.setUid(rs.getString(1)) );
		
		//5단계
		if( rs.next() ){
			
			ub.setUid(rs.getString(1));
			ub.setName(rs.getString(2));
			ub.setHp(rs.getString(3));
			ub.setAge(rs.getInt(4));
		};
		
		
		//6단계
		rs.close();
		stmt.close();
		conn.close();
		
	
	}catch(Exception e){
		e.printStackTrace();
	}


%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>4_1_Insert</title>
	<%--
		일자 : 2021-08-06 10:53
		이름 : 박은비
		내용 : Database Insert
		
	 --%>
</head>
<body>
	<h3>4.JSP Update 실습하기</h3>
	
	<h4>User 수정</h4>

	<form action="./proc/updateProc.jsp" method="post">
		<table border="1">
			<tr>
				<td> 아이디 </td>
				<td> <input type="text" name="uid" readonly value="<%= ub.getUid() %>" /> </td>
			</tr>
		
			<tr>
				<td> 이름 </td>
				<td> <input type="text" name="name" value="<%= ub.getName() %>" /> </td>
			</tr>
			
			<tr>
				<td> 휴대폰 </td>
				<td> <input type="text" name="hp" value="<%= ub.getHp() %>" /> </td>			</tr>
			<tr>
				<td> 나이 </td>
				<td> <input type="text" name="age" value="<%= ub.getAge() %>"/> </td>			</tr>
			<tr>
				<td colspan = "2" aling="right">
					<input type="submit" value="수정하기"/>
			</tr>
		</table>
		
	</form>
	
</body>
</html>

