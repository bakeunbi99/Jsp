<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="bean.MemberBean"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@ page contentType="application/json;charset=UTF-8" pageEncoding="UTF-8"%>
<%

	//DB 정보
	String host="jdbc:mysql://54.180.160.240:3306/p57575777";
	String user = "p57575777";
	String pass = "1234";

	List<MemberBean> members = new ArrayList<>();
		
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
			MemberBean mb = new MemberBean();
			mb.setUid(rs.getString(1));
			mb.setName(rs.getString(2));
			mb.setHp(rs.getString(3));
			mb.setPos(rs.getString(4));
			mb.setDep(rs.getInt(5));
			mb.setRdate(rs.getString(6));
			
			members.add(mb); //객체 추가
			
		}
		
		//6단계
		rs.close();
		stmt.close();
		conn.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	//list를 Json 변환
	Gson gson = new Gson();
	String jsonData = gson.toJson(members);
	
	//Json 출력(client로 전송)	
	out.print(jsonData);
	
%>




