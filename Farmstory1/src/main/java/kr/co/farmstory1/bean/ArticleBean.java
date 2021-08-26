package kr.co.farmstory1.bean;

public class ArticleBean {

	private int seq;		//시퀀스
	private int parent;		//부모 글 번호
	private int comment;	//댓글
	private String cate;	//
	private String title;	//글제목
	private String content;	//글내용
	private int file;		//파일
	private int hit;		//조회수
	private String uid;		//아이디
	private String regip; 	//등록ip
	private String rdate; 	//등록일
	
	// 추가필드
	private String nick; 	//닉네임
	
	private FileBean fb; 	//FileBean을 멤버변수로 초기화
	

	
	public FileBean getFb() {
		return fb;
	}
	public void setFb(FileBean fb) {
		this.fb = fb;
	}
	
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	

	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	public void setParent(String parent) {
		this.parent = Integer.parseInt(parent);
	}
	
	public int getComment() {
		return comment;
	}
	public void setComment(int comment) {
		this.comment = comment;
	}
	
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public int getFile() {
		return file;
	}
	public void setFile(int file) {
		this.file = file;
	}
	
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	public String getRegip() {
		return regip;
	}
	public void setRegip(String regip) {
		this.regip = regip;
	}
	
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	
	
}
