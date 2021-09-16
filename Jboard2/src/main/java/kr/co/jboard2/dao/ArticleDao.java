package kr.co.jboard2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.jboard2.db.DBConfig;
import kr.co.jboard2.db.Sql;
import kr.co.jboard2.vo.ArticleVo;
import kr.co.jboard2.vo.FileVo;

public class ArticleDao {
	
	private static ArticleDao instance = new ArticleDao();
	public static ArticleDao getInstance() {
		return instance;
	}
	private ArticleDao() {}
	
	/*========================
		글작성 insert
	========================*/	
	public int insertArticle(ArticleVo vo) {
		
		try {
			Connection conn = DBConfig.getInstance().getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.INSERT_ARTICLE);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContent());
			psmt.setInt(3, vo.getFile());
			psmt.setString(4, vo.getUid());
			psmt.setString(5, vo.getRegip());
			
			// executeUpdate의 리턴 값은? 1?
			int result = psmt.executeUpdate();
			
			psmt.close();
			conn.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return selectMaxSeq();
		
	}
	/*========================
		파일 첨부 시 파일 insert
	========================*/	
	public void insertFile(int seq, String oriName, String newName) {
		try{
			Connection conn = DBConfig.getInstance().getConnection();
			
			PreparedStatement psmt = conn.prepareStatement(Sql.INSERT_FILE);
			psmt.setInt(1, seq);
			psmt.setString(2, oriName);
			psmt.setString(3, newName);
			
			psmt.executeUpdate();
			
			psmt.close();
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();	
		}
	}
	
	/* ========================
		글 목록 총 개수
	======================== */	
	public int selectCountTotal() {
		
		int total = 0;
		
		try{
			Connection conn = DBConfig.getInstance().getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(Sql.SELECT_COUNT_TOTAL);


			if(rs.next()) {
				total = rs.getInt(1);
			}

			rs.close();
			stmt.close();
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return total;
		
	}


	/*========================
		최신 글 번호 가져오기.
	========================*/	
	public int selectMaxSeq() {
		int seq = 0;
		
		try {
			Connection conn = DBConfig.getInstance().getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(Sql.SELECT_MAX_SEQ);
			if(rs.next()){
				seq = rs.getInt(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return seq;
	}
	
	/*========================
		글 상세보기
	========================*/
	public ArticleVo selectArticle(String seq) {
		
		ArticleVo vo = null;
		FileVo fvo = null;
		
		try{
			Connection conn = DBConfig.getInstance().getConnection();

			PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_ARTICLE);
			psmt.setString(1, seq);

			ResultSet rs = psmt.executeQuery();

			if(rs.next()) {
				vo = new ArticleVo();
				
				vo.setSeq(rs.getInt(1));
				vo.setParent(rs.getInt(2));
				vo.setComment(rs.getInt(3));
				vo.setCate(rs.getString(4));
				vo.setTitle(rs.getString(5));
				vo.setContent(rs.getString(6));
				vo.setFile(rs.getInt(7));
				vo.setHit(rs.getInt(8));
				vo.setUid(rs.getString(9));
				vo.setRegip(rs.getString(10));
				vo.setRdate(rs.getString(11));

				// 파일 정보
				fvo = new FileVo();
				fvo.setFseq(rs.getInt(12));
				fvo.setParent(rs.getInt(12));
				fvo.setOriName(rs.getString(14));
				fvo.setNewName(rs.getString(15));
				fvo.setDownload(rs.getInt(16));
				fvo.setRdate(rs.getString(17));
//				
				vo.setFb(fvo);
				
			}

			rs.close();
			psmt.close();
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return vo;
	}
	
	/*========================
		글 목록들
	========================*/
	public List<ArticleVo> selectArticles(int start) {
		
		List<ArticleVo> articles = new ArrayList<>();
		
		try{
			Connection conn = DBConfig.getInstance().getConnection();

			PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_ARTICLES);
			psmt.setInt(1, start);

			ResultSet rs = psmt.executeQuery();

			while(rs.next()){
				
				ArticleVo vo = new ArticleVo();
				
				vo.setSeq(rs.getInt(1));
				vo.setParent(rs.getInt(2));
				vo.setComment(rs.getInt(3));
				vo.setCate(rs.getString(4));
				vo.setTitle(rs.getString(5));
				vo.setContent(rs.getString(6));
				vo.setFile(rs.getInt(7));
				vo.setHit(rs.getInt(8));
				vo.setUid(rs.getString(9));
				vo.setRegip(rs.getString(10));
				vo.setRdate(rs.getString(11).substring(2, 10));
				vo.setNick(rs.getString(12));
				
				articles.add(vo);
				
			}

			rs.close();
			psmt.close();
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return articles;
		
	}
	
	

	/*========================
	
	========================*/
	public void updateArticle() {}
	
	/*========================
	
	========================*/
	public void deleteArticle() {}
	
	
	
}
