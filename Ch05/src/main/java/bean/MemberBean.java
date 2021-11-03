package bean;

public class MemberBean {
	
	private String uid;
	private String name;
	private String hp;
	private String pos;
	private int    dep;
	private String rdate;
	
	
	//아이디
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	//이름
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//휴대폰
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	//직급
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	//부서
	public int getDep() {
		return dep;
	}
	public void setDep(int dep) {
		this.dep = dep;
	}
	//생성일자
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	

}
