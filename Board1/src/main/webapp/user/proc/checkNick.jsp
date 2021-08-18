<%@page import="kr.co.jboard1.db.Sql"%>
<%@page import="kr.co.jboard1.db.DBConfig"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page contentType="application/json;charset=UTF-8" pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");

	//전송 데이터 수신
	String nick = request.getParameter("nick");

	
	//Json 출력
	int result = 0;
	
	try{
		//1, 2단계
		Connection conn = DBConfig.getInstance().getConnection();
		
		//3단계
			
		PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_COUNT_NICK);
		//PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, nick);
		//4단계
		ResultSet rs = psmt.executeQuery();
		//5단계
		
		if(rs.next()){
			result = rs.getInt(1); //0 또는 1
		}
		//6단계
		rs.close();
		psmt.close();
		conn.close();
			
		//Json 출력
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		out.print(json);
		
		
		
		
	}catch(Exception e){
		e.printStackTrace();
	}



%>
