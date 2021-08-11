<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%	
	// 전송 데이터 수신
	request.setCharacterEncoding("UTF-8");

	String uid   = request.getParameter("uid");
	String pass1 = request.getParameter("pass1");
	String name  = request.getParameter("name");
	String nick  = request.getParameter("nick");
	String email = request.getParameter("email");
	String hp    = request.getParameter("hp");
	String zip   = request.getParameter("zip");
	String addr1 = request.getParameter("addr1");
	String addr2 = request.getParameter("addr2");
	String regip = request.getRemoteAddr();
	// DB정보
	String host = "jdbc:mysql://54.180.160.240:3306/p57575777";
	String user = "p57575777";
	String pass = "1234";
	try{
		// 1단계
		Class.forName("com.mysql.jdbc.Driver");
		// 2단계
		Connection conn = DriverManager.getConnection(host, user, pass);
		//3단계 - SQL 실행객체 생성 (Prepare시 ?로 하나씩 매핑하여 쿼리문 완성)
		String sql = "INSERT INTO `Jboard_member` SET ";
		       sql += "`uid`=?,";
		       sql += "`pass`=PASSWORD(?),";
		       sql += "`name`=?,";
		       sql += "`nick`=?,";
		       sql += "`email`=?,";
		       sql += "`hp`=?,";
		       sql += "`zip`=?,";
		       sql += "`addr1`=?,";
		       sql += "`addr2`=?,";
		       sql += "`regip`=?,";
		       sql += "`rdate`=NOW();";
		       
		PreparedStatement psmt = conn.prepareStatement(sql);
		
		psmt.setString(1, uid);
		psmt.setString(2, pass1);
		psmt.setString(3, name);
		psmt.setString(4, nick);
		psmt.setString(5, email);
		psmt.setString(6, hp);
		psmt.setString(7, zip);
		psmt.setString(8, addr1);
		psmt.setString(9, addr2);
		psmt.setString(10, regip);
		
		out.print(sql);
		// 4단계
		psmt.executeUpdate();		
		// 5단계
		
		// 6단계
		psmt.close();
		conn.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}
	// 리다이렉트
	response.sendRedirect("/JBoard1/user/login.jsp");
%>