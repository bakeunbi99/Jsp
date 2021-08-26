package kr.co.farmstory1.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConfig {

	// �̱��� ��ü
	private static DBConfig instance = new DBConfig();
	
	private DBConfig() {}
	
	public static DBConfig getInstance() {
		return instance;
	}
	
	// DB����
	private final String HOST = "jdbc:mysql://54.180.160.240:3306/p57575777";
	private final String USER = "p57575777";
	private final String PASS = "1234";
	
	public Connection getConnection() throws Exception {
		// 1�ܰ�
		Class.forName("com.mysql.jdbc.Driver");
		// 2�ܰ�
		Connection conn = DriverManager.getConnection(HOST, USER, PASS);
		
		return conn;
	}
}









