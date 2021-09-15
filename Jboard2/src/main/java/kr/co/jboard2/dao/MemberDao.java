package kr.co.jboard2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import kr.co.jboard2.db.DBConfig;
import kr.co.jboard2.db.Sql;
import kr.co.jboard2.vo.MemberVo;
import kr.co.jboard2.vo.TermsVo;

public class MemberDao {
	//싱글톤 객체
	private static MemberDao instance = new MemberDao();
	
	public static MemberDao getInstance() {
		return instance;
	};
	
	private MemberDao() {}
	
	
	/*==========================
		회원 가입 (insert)
	==========================*/
	public void insertMember(MemberVo vo) {
		
		try {

			Connection conn = DBConfig.getInstance().getConnection();
			
			PreparedStatement psmt = conn.prepareStatement(Sql.INSERT_MEMBER);
			psmt.setString(1, vo.getUid());
			psmt.setString(2, vo.getPass());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getNick());
			psmt.setString(5, vo.getEmail());
			psmt.setString(6, vo.getHp());
			psmt.setString(7, vo.getZip());
			psmt.setString(8, vo.getAddr1());
			psmt.setString(9, vo.getAddr2());
			psmt.setString(10, vo.getRegip());
			
			psmt.executeUpdate();
			
			psmt.close();
			conn.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	};
	
	/*==========================
	이용약관 (select) 
	==========================*/
	public TermsVo selectTrems() {
		
		TermsVo vo = null;
		
		try{
			// 1,2단계
			Connection conn= DBConfig.getInstance().getConnection();

			// 3단계 - SQL 실행객체 생성
			Statement stmt = conn.createStatement();		

			// 4단계 - SQL 실행
			ResultSet rs = stmt.executeQuery(Sql.SELECT_TERMS);
			
			// 5단계 - 결과셋 처리(SELECT문 경우)
			if(rs.next()){
				vo = new TermsVo();
				vo.setTerms(rs.getString(1));
				vo.setPrivacy(rs.getString(2));			
			}
			
			// 6단계 - 데이터베이스 종료
			rs.close();
			stmt.close();
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return vo;
		
	};
	
	/*==========================
	유저 확인 (select)
	==========================*/
	public MemberVo selectMember(String uid, String pass) {
		
		MemberVo  vo = null;
		
		try{
			Connection conn = DBConfig.getInstance().getConnection();
			
			PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_MEMBER);
			psmt.setString(1, uid);
			psmt.setString(2, pass);
			
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()) {
				vo = new MemberVo();
				
				vo.setUid(rs.getString(1));
				vo.setPass(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setNick(rs.getString(4));
				vo.setEmail(rs.getString(5));
				vo.setHp(rs.getString(6));
				vo.setGrade(rs.getInt(7));
				vo.setZip(rs.getString(8));
				vo.setAddr1(rs.getString(9));
				vo.setAddr2(rs.getString(10));
				vo.setRegip(rs.getString(11));
				vo.setRdate(rs.getString(12));
			}
			
			rs.close();
			psmt.close();
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return vo;
		
	};
	
	
	
	/*==========================
	유저들 확인 (select)
	==========================*/
	public void selectMembers() {};
	
	/*==========================
	Uid 중복 체크확인 (select)
	==========================*/
	public int selectCountUid(String uid) {
		
		int count = 0;
		
		try {
			Connection conn = DBConfig.getInstance().getConnection();
			PreparedStatement psmt =  conn.prepareStatement(Sql.SELECT_COUNT_UID);
			psmt.setString(1, uid);
			
			ResultSet rs = psmt.executeQuery();			
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return count;
		
	};
	
	/*==========================
	Nick 중복 체크확인 (select)
	==========================*/
	public int selectCountNick(String nick) {
		
		int count = 0;
		
		try {
			Connection conn = DBConfig.getInstance().getConnection();
			PreparedStatement psmt =  conn.prepareStatement(Sql.SELECT_COUNT_NICK);
			psmt.setString(1, nick);
			
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return count;
		
	};
	
	/*==========================
	Email 중복 체크확인 (select)
	==========================*/
	public int selectCountEmail(String email) {
		
		int count = 0;
		
		try {
			Connection conn = DBConfig.getInstance().getConnection();
			PreparedStatement psmt =  conn.prepareStatement(Sql.SELECT_COUNT_EMAIL);
			psmt.setString(1, email);
			
			ResultSet rs = psmt.executeQuery();			
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return count;
		
	};
	
	/*==========================
	Hp 중복 체크확인 (select)
	==========================*/
	public int selectCountHp(String hp) {
		
		int count = 0;
		
		try {
			Connection conn = DBConfig.getInstance().getConnection();
			PreparedStatement psmt =  conn.prepareStatement(Sql.SELECT_COUNT_HP);
			psmt.setString(1, hp);
			
			ResultSet rs = psmt.executeQuery();			
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return count;
		
	};
	
	/*==========================
	회원 업데이트 (update)
	==========================*/
	public void updateMember() {};
	
	/*==========================
	회원 삭제 (delete)
	==========================*/
	public void deletetMember() {};
	
	
	
	
}
