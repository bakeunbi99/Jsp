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
	public void selectMember() {};
	
	/*==========================
	유저들 확인 (select)
	==========================*/
	public void selectMembers() {};
	
	/*==========================
	회원 업데이트 (update)
	==========================*/
	public void updateMember() {};
	
	/*==========================
	회원 삭제 (delete)
	==========================*/
	public void deletetMember() {};
	
	
	
	
}
