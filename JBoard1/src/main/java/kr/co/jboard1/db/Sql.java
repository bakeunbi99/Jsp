package kr.co.jboard1.db;

public class Sql {
	
	//이용약관 sql
	public static final String SELECT_TERMS = "SELECT * FROM `Jboard_terms`;";
	
	//회원ㄴ정보 찾기 sql
	public static final String SELECT_MEMBER = "SELECT * FROM `Jboard_member` where `uid` = ? AND `pass` = PASSWORD(?);";
	
	//회원가입 sql
	//3단계 - SQL 실행객체 생성(Prepare로 실행시 ?로 매핑)
	public static final String INSERT_MEMBER = "INSERT INTO `Jboard_member` SET "
		    + "`uid`=?,"
		    + "`pass`=PASSWORD(?),"
		    + "`name`=?,"
		    + "`nick`=?,"
		    + "`email`=?,"
		    + "`hp`=?,"
		    + "`zip`=?,"
		    + "`addr1`=?,"
		    + "`addr2`=?,"
		    + "`regip`=?,"
		    + "`rdate`=NOW();";
	
	//중복 체크 Sql
	public static final String SELECT_COUNT_UID = "SELECT COUNT(`uid`) FROM `Jboard_member` WHERE `uid` = ?;";
	public static final String SELECT_COUNT_NICK = "SELECT COUNT(`nick`) FROM `Jboard_member` WHERE `nick` = ?;";
	public static final String SELECT_COUNT_HP = "SELECT COUNT(`hp`) FROM `Jboard_member` WHERE `hp` = ?;";
	public static final String SELECT_COUNT_EMAIL = "SELECT COUNT(`email`) FROM `Jboard_member` WHERE `email` = ?;";
	

}
