package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vo.MemberVo;
import vo.UserVo;

//database 처리 로직
public class MemberDao {
	
	// 싱글톤 객체
	private static MemberDao instance = new MemberDao();
	
	public static MemberDao getInstance() {
		return instance;
	}
	
	public MemberDao() {}; //UserDao dao = new UserDao()로 생성하지 못하게
	
	
	private final String HOST = "jdbc:mysql://192.168.56.101:3306/p57575777";
	private final String USER = "p57575777";
	private final String PASS = "1234";
		
	
		/*=================================
			member insert
		=================================*/
		public void insertMember(MemberVo vo) {
			try {
				//1단계
				Class.forName("com.mysql.jdbc.Driver");
				//2단계
				Connection conn = DriverManager.getConnection(HOST, USER, PASS);
				//3단계
				String sql = "INSERT INTO `MEMBER` VALUES(?, ?, ?, ?, ?, NOW());";
				
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, vo.getUid());
				psmt.setString(2, vo.getName());
				psmt.setString(3, vo.getHp());
				psmt.setString(4, vo.getPos());
				psmt.setInt(5, vo.getDep());
				
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
			member select
		=================================*/
		public void selectUser() {}
		
		
		/*=================================
			member list select
		=================================*/
		public List<MemberVo> selectMembers() {
			
			List<MemberVo> members = new ArrayList<>();
			
			try {
				//1단계
				Class.forName("com.mysql.jdbc.Driver");
				//2단계
				Connection conn = DriverManager.getConnection(HOST, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM `MEMBER`");
				
				while(rs.next()) {
					MemberVo vo = new MemberVo();
					vo.setUid(rs.getString(1));
					vo.setName(rs.getString(2));
					vo.setHp(rs.getString(3));
					vo.setPos(rs.getString(4));
					vo.setDep(rs.getInt(5));
					vo.setRdate(rs.getString(6));
					
					members.add(vo);
					
				}
				
				rs.close();
				stmt.close();
				conn.close();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			return members;
			
		}
		
		
		
		public void updatetUser() {}
		
		
		/*=================================
			member delete
		=================================*/
		public void deleteMember(String uid) {
			try {
				//1단계
				Class.forName("com.mysql.jdbc.Driver");
				//2단계
				Connection conn = DriverManager.getConnection(HOST, USER, PASS);
				//3단계
				String sql = "DELETE FROM `MEMBER` WHERE `uid`=?";
				
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
