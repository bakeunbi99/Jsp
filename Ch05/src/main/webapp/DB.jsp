<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="application/json;charset=UTF-8" pageEncoding="UTF-8"%>
<%

	//DB 정보
	String host="jdbc:mysql://54.180.160.240:3306/p57575777";
	String user = "p57575777";
	String pass = "1234";

	
		
	try{
		//1단계
		Class.forName("com.mysql.jdbc.Driver");
		//2단계
		Connection conn = DriverManager.getConnection(host, user, pass);
		//3단계
		Statement stmt = conn.createStatement();
		//4단계
		String sql = "select * from `MEMBER`;";
		ResultSet rs = stmt.executeQuery(sql);//DB에서 조회 결과를 가져와 rs객체를 만든다.
		
		
		//5단계
		while(rs.next()){
		}
		
		//6단계
		rs.close();
		stmt.close();
		conn.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}

%>




