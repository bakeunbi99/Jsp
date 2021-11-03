<%@page import="bean.CustomerBean"%>
<%@page import="bean.User1Bean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");

	String custid = request.getParameter("custid");	

	//DB 정보
	String host="jdbc:mysql://3.38.95.56:3306/p57575777";
	String user = "p57575777";
	String pass = "1234";
	
	CustomerBean cb = new CustomerBean();
	
	try{
		//1단계
		Class.forName("com.mysql.jdbc.Driver");
		//2단계 - 데이터 베이스 접속
		Connection conn =  DriverManager.getConnection(host, user, pass);
		//3단계 - SQL 실행 객체 생성
		Statement stmt = conn.createStatement();
	
		//4단계
		String sql = "select * from `Customer` WHERE `custid` = " + custid + "; ";
		out.print(sql);
		
		ResultSet rs = stmt.executeQuery(sql);

		
		//5단계
		if( rs.next() ){
			
			cb.setCustid(rs.getInt(1));
			cb.setName(rs.getString(2));
			cb.setAddress(rs.getString(3));
			cb.setPhone(rs.getString(4));
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
	<title>update</title>
</head>
<body>
	<h3>4.JSP Update 실습하기</h3>
	
	<h4>User 수정</h4>
	<!-- ./proc/UpdateProc.jsp -->
	<form action="./proc/UpdateProc.jsp " method="post">
		<table border="1">

			<tr>
				<td> 아이디 </td>
				<td> <input type="text" name="custid" readonly value="<%= cb.getCustid() %>" /> </td>
			</tr>
			<tr>
				<td> 이름 </td>
				<td> <input type="text" name="name" value="<%= cb.getName() %>" /> </td>
			</tr>
			
			<tr>
				<td> 주소 </td>
				<td> <input type="text" name="address" value="<%= cb.getAddress() %>"/> </td>
			</tr>
			<tr>
				<td> 휴대폰 </td>
				<td> <input type="text" name="phone" value="<%= cb.getPhone() %>"/> </td>
			</tr>
			<tr>
				<td colspan = "2" aling="right">
					<input type="submit" value="수정하기"/>
			</tr>
		</table>

	</form>
	
</body>
</html>

