<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>


<%
	request.setCharacterEncoding("UTF-8");

	String uid = request.getParameter("uid");

	//DB 정보
	String host="jdbc:mysql://3.38.95.56:3306/p57575777";
	String user = "p57575777";
	String pass = "1234";
	

	try{
		//1단계
		Class.forName("com.mysql.jdbc.Driver");
		//2단계 - 데이터 베이스 접속
		Connection conn =  DriverManager.getConnection(host, user, pass);
		//3단계 - SQL 실행 객체 생성
		Statement stmt = conn.createStatement();
		
		//4단계
		String sql = "DELETE FROM `MEMBER` WHERE `uid` = '" + uid + "';";
		out.print(sql);
		stmt.executeUpdate(sql);
		
		//5단계
		//6단계
		stmt.close();
		conn.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	//리다이렉트
	response.sendRedirect("../Select.jsp");
	
	
%>



