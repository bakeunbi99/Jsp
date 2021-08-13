package kr.co.jboard1.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//싱글톤(으로 만들려면 private를 만들어 줘야함.) 
public class DBConfig {
	// 싱클톤 (본인객체를 본인 클래스 내에서 생성)
	// 클래스 변수
	private static DBConfig instance = new DBConfig();
	
	//캡슐화 - 외부에서 객체 생성하지 못하도록 private
	private DBConfig() {}
	
	//instance를 외부에 사용하기 위하여 static
	//클래스 메서드
	public static DBConfig getInstance() {
		
		return instance;
	}

	
	// DB정보 (final가 선언되면 대문자로 선언)
	private final String HOST = "jdbc:mysql://54.180.160.240:3306/p57575777";
	private final String USER = "p57575777";
	private final String PASS = "1234";
	
	
	//메서드 정의
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		// 1단계
		Class.forName("com.mysql.jdbc.Driver");
		// 2단계
		Connection conn = DriverManager.getConnection(HOST, USER, PASS);
		
		return conn;
	}
}


