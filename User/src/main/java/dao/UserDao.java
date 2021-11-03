package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vo.UserVo;

//database 처리 로직
public class UserDao {
	
	// 싱글톤 객체
	private static UserDao instance = new UserDao();
	
	public static UserDao getInstance() {
		return instance;
	}
	
	public UserDao() {}; //UserDao dao = new UserDao()로 생성하지 못하게
	
	
	private final String HOST = "jdbc:mysql://192.168.56.101:3306/p57575777";
	private final String USER = "p57575777";
	private final String PASS = "1234";
		
		/*=================================
			user insert
		=================================*/
		public void insertUser(UserVo vo) {
			
			try {
				//1단계
				Class.forName("com.mysql.jdbc.Driver");
				//2단계
				Connection conn = DriverManager.getConnection(HOST, USER, PASS);
				//3단계
				String sql = "INSERT INTO `USER1` VALUES(?, ?, ?, ?);";
				
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, vo.getUid());
				psmt.setString(2, vo.getName());
				psmt.setString(3, vo.getHp());
				psmt.setInt(4, vo.getAge());
				
				//4단계
				psmt.executeUpdate();
				
				//5단계
				//6단계
				psmt.close();
				conn.close();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		/*=================================
			user select
		=================================*/
		public void selectUser(String uid) {
			
			try {
				//1단계
				Class.forName("com.mysql.jdbc.Driver");
				//2단계
				Connection conn = DriverManager.getConnection(HOST, USER, PASS);
				//3단계
				String sql = "SELECT * FROM `USER1` where `uid`=?";
				
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, uid);
				
				//4단계
				psmt.executeQuery();
				
				//5단계
				//6단계
				psmt.close();
				conn.close();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		/*=================================
			user list select
		=================================*/
		public List<UserVo> selectUsers() {
			
			List<UserVo> users = new ArrayList<>();
			
			try {
				//1단계
				Class.forName("com.mysql.jdbc.Driver");
				//2단계
				Connection conn = DriverManager.getConnection(HOST, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM `USER1`");
				
				while(rs.next()) {
					UserVo vo = new UserVo();
					vo.setUid(rs.getString(1));
					vo.setName(rs.getString(2));
					vo.setHp(rs.getString(3));
					vo.setAge(rs.getInt(4));
					
					users.add(vo);
					
				}
				
				rs.close();
				stmt.close();
				conn.close();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			return users;
			
		}
		
		
		
		public void updatetUser() {}
		
		
		/*=================================
			user delete
		=================================*/
		public void deleteUser(String uid) {
			try {
				//1단계
				Class.forName("com.mysql.jdbc.Driver");
				//2단계
				Connection conn = DriverManager.getConnection(HOST, USER, PASS);
				//3단계
				String sql = "DELETE FROM `USER1` WHERE `uid`=?";
				
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, uid);
				
				//4단계
				psmt.executeUpdate();
				
				//5단계
				//6단계
				psmt.close();
				conn.close();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
}
