package kr.co.farmstory1.db;

public class Sql {

	// 사용자 관련
	public static final String SELECT_TERMS = "SELECT * FROM `Jboard_terms`;";
	public static final String SELECT_MEMBER = "SELECT * FROM `Jboard_member` WHERE `uid`=? AND `pass`=PASSWORD(?);";  
	public static final String INSERT_MEMBER = "INSERT INTO `Jboard_member` SET "
												    +"`uid`=?,"
												    +"`pass`=PASSWORD(?),"
												    +"`name`=?,"
												    +"`nick`=?,"
												    +"`email`=?,"
												    +"`hp`=?,"
												    +"`zip`=?,"
												    +"`addr1`=?,"
												    +"`addr2`=?,"
												    +"`regip`=?,"
												    +"`rdate`=NOW();";

	public static final String SELECT_COUNT_UID   = "SELECT COUNT(`uid`)   FROM `Jboard_member` WHERE `uid`=?;";
	public static final String SELECT_COUNT_NICK  = "SELECT COUNT(`nick`)  FROM `Jboard_member` WHERE `nick`=?;";
	public static final String SELECT_COUNT_HP    = "SELECT COUNT(`hp`)    FROM `Jboard_member` WHERE `hp`=?;";
	public static final String SELECT_COUNT_EMAIL = "SELECT COUNT(`email`) FROM `Jboard_member` WHERE `email`=?;";


	// 게시판 관련
	public static final String SELECT_COUNT_TOTAL = "SELECT COUNT(`seq`) FROM `Jboard_article` WHERE `parent`=0;";
	public static final String SELECT_ARTICLE = "SELECT * FROM `Jboard_article` AS a "
											  + "LEFT JOIN `Jboard_file` AS b "
											  + "ON a.seq = b.parent "
											  + "WHERE `seq`=?;";

	public static final String SELECT_ARTICLES = "SELECT a.*, b.nick FROM `Jboard_article` AS a "
												+ "JOIN `Jboard_member` AS b "
												+ "ON a.uid = b.uid "
												+ "WHERE `parent`=0 "
												+ "ORDER BY `seq` DESC "
												+ "LIMIT ?, 10;";

	public static final String SELECT_COMMENTS = "SELECT a.*, b.nick FROM `Jboard_article` AS a "
			                                    + "JOIN `Jboard_member` AS b "
			                                    + "ON a.uid = b.uid "
			                                    + "WHERE `parent`=? "
			                                    + "ORDER BY `seq` ASC;";


	public static final String SELECT_MAX_SEQ = "SELECT MAX(`seq`) FROM `Jboard_article`;";

	public static final String INSERT_ARTICLE = "INSERT INTO `Jboard_article` SET "
												+ "`title`=?,"
												+ "`content`=?,"
												+ "`file`=?,"
												+ "`uid`=?,"
												+ "`regip`=?,"
												+ "`rdate`=NOW();";

	public static final String INSERT_FILE = "INSERT INTO `Jboard_file` SET "
											+ "`parent`=?,"
											+ "`oriName`=?,"
											+ "`newName`=?,"
											+ "`rdate`=NOW();";

	public static final String INSERT_COMMENT = "INSERT INTO `Jboard_article` SET "
											  + "`parent`=?,"
											  + "`content`=?,"
											  + "`uid`=?,"
											  + "`regip`=?,"
											  + "`rdate`=NOW();";


	public static final String UPDATE_ARTICLE_HIT = "UPDATE `Jboard_article` SET `hit` = `hit` + 1 "
												  + "WHERE `seq`=?;";

	// 댓글 수 카운트
	public static final String UPDATE_COMMENT_COUNT_PLUS = "";
	public static final String UPDATE_COMMENT_COUNT_MINUS = "";
	
	
	public static final String UPDATE_COMMENT = "UPDATE `Jboard_article` SET `content`=? WHERE `seq`=?";
	
	
	
	public static final String SELECT_COUNT_COMMENT = "SELECT COUNT(*) FROM `Jboard_article` AS a JOIN `Jboard_article` b ON a.seq = b.parent WHERE a.seq = ?;";
	
	
	//댓글 삭제
	public static final String DELETE_COMMENT = "DELETE FROM `Jboard_article` WHERE `seq` = ?;";	
	

}


