<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");

	String uid = request.getParameter("uid");
	String name = request.getParameter("name");
	String hp = request.getParameter("hp");
	String age = request.getParameter("age");

	//DB 정보
	//String host="jdbc:mysql://54.180.160.240:3306/p57575777";
	String host="jdbc:mysql://3.38.95.56:3306/p57575777";
	String user = "p57575777";
	String pass = "1234";
	
	try{
		// 1단계 - JDBC 드라이버 로드
		Class.forName("com.mysql.jdbc.Driver");	
		// 2단계 - 데이터베이스 접속
		Connection conn = DriverManager.getConnection(host, user, pass);   
		// 3단계 - SQL 실행객체 생성
		Statement stmt = conn.createStatement();		
		
		// 4단계 - SQL 실행
		String sql = "INSERT INTO `USER1` "+
					 "VALUES('"+ uid +"', '" + name + "', '"+ hp +"', "+age+"); ";
		stmt.executeUpdate(sql);
					 
		// 5단계 - 결과 처리(SELECT일 경우)
		
		
		// 6단계 - 데이터베이스 종료
		stmt.close();
		conn.close();
		
		
	}catch(Exception e){
		out.print("오 류");
		e.printStackTrace();
	}finally{
		
	}
	
	//리다이렉트
	response.sendRedirect("../4_2_Select.jsp");
	
	


%>

