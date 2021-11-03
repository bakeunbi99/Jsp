<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="bean.User1Bean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%
	//DB 정보
	//String host="jdbc:mysql://54.180.160.240:3306/p57575777";
	String host="jdbc:mysql://3.38.95.56:3306/p57575777";
	String user = "p57575777";
	String pass = "1234";
	
	List<User1Bean> users = new ArrayList<>();
	

	try{
		//1단계
		Class.forName("com.mysql.jdbc.Driver");
		//2단계 - 데이터 베이스 접속
		Connection conn =  DriverManager.getConnection(host, user, pass);
		//3단계 - SQL 실행 객체 생성
		Statement stmt = conn.createStatement();
		
		//4단계 - SQL 실행
		String sql = "select * from `USER1`;";
		ResultSet rs = stmt.executeQuery(sql);
		
		//*매우 중요*
		//5단계 - 결과셋 처리( select일 경우. )
		while(rs.next()){
			User1Bean ub = new User1Bean();
			ub.setUid(rs.getString(1));
			ub.setName(rs.getString(2));
			ub.setHp(rs.getString(3));
			ub.setAge(rs.getInt(4));
			
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
	<title>4_1_Insert</title>
	<%--
		일자 : 2021-08-05 17:42
		이름 : 박은비
		내용 : Database Insert
		
	 --%>
</head>

<style>
	
	#trHeader {
		height: 30px;
		background-color : #FFFFcc;
		
	}
	#hp{
		width: 150px;
	}

	td{
		width : 80px;
	}

</style>

<body>
	<h3>2.JSP Select 실습하기</h3>
	
	<h3>User 등록</h3>
	<a href="./4_1_Insert.jsp">사용자 등록</a>
	<h4>사용자 목록</h4>

	<table border="1">
		<tr id = "trHeader">
			<th>아이디</th>
			<th>이름</th>
			<th id="hp">휴대폰</th>
			<th>나이</th>
			<th>관리</th>
		</tr>
		
		<%
			for(User1Bean ub : users) {
		%>
		<tr>
			<td><%= ub.getUid() %></td>
			<td><%= ub.getName() %></td>
			<td><%= ub.getHp() %></td>
			<td><%= ub.getAge() %></td>
			<td>
				<a href="./4_4_Update.jsp?uid=<%= ub.getUid() %>"> 수정 </a>
				<a href="./4_3_Delete.jsp?uid=<%= ub.getUid() %>"> 삭제 </a>
			</td>
		</tr>
		
				
		<%	
			}
		%>
		

		
		
	</table>
</body>
</html>

