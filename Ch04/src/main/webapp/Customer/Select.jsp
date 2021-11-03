<%@page import="bean.CustomerBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%
	//DB 정보
	String host="jdbc:mysql://3.38.95.56:3306/p57575777";
	String user = "p57575777";
	String pass = "1234";
	
	List<CustomerBean> users = new ArrayList<>();
	

	try{
		//1단계
		Class.forName("com.mysql.jdbc.Driver");
		//2단계 - 데이터 베이스 접속
		Connection conn =  DriverManager.getConnection(host, user, pass);
		//3단계 - SQL 실행 객체 생성
		Statement stmt = conn.createStatement();
		
		//4단계 - SQL 실행
		String sql = "SELECT * FROM `Customer`; ";
		ResultSet rs = stmt.executeQuery(sql);
		
		//*매우 중요*
		//5단계 - 결과셋 처리( select일 경우. )
		while(rs.next()){
			CustomerBean ub = new CustomerBean();
			ub.setCustid(rs.getInt(1));
			ub.setName(rs.getString(2));
			ub.setAddress(rs.getString(3));
			ub.setPhone(rs.getString(4));
			
			users.add(ub);
		}
		
		
		//6단계 - 데이터 베이스 종료
		rs.close();
		stmt.close();
		conn.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
	}
	

%>



<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Customer_Select</title>
	
</head>

<body>
	<h3>회원 리스트</h3>
	
	<h3>회원 등록</h3>
	<a href="./register.jsp">회원 등록</a>
	
	<h4>회원 목록</h4>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>휴대폰</th>
			<th>나이</th>
			<th>관리</th>
		</tr>
		
		<%
			for(CustomerBean ub : users) {
		%>
		<tr>
			<td><%= ub.getCustid() %></td>
			<td><%= ub.getName() %></td>
			<td><%= ub.getAddress() %></td>
			<td><%= ub.getPhone() %></td>
			<td>
				<a href="./Update.jsp?custid=<%= ub.getCustid() %>"> 수정 </a>
				<a href="./proc/Delete.jsp?custid=<%= ub.getCustid() %>"> 삭제 </a>
			</td>
		</tr>
		
				
		<%	
			}
		%>
		
	</table>
</body>
</html>

