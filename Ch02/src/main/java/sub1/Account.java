package sub1;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;

public class Account {
	//private ĸ��ȭ ����
	private String bank;
	private String id;
	private String name;
	private int money;
	
//	public void Accout() {}
	public Account(String bank, String id, String name, int money) {
		this.bank = bank;
		this.id = id;
		this.name = name;
		this.money = money;
	}
	
	
	public void deposit(int money) {
		this.money += money;
	}
	
	public void withdraw(int money) {
		this.money -= money;
	}
	
	//JspWriter ��°�ü Ÿ��
	public void show(JspWriter out) throws IOException{
		out.println("<p>");
		out.println("����� : " + this.bank + "<br>");
		out.println("���¹�ȣ : " + this.id + "<br>");
		out.println("�Ա��� : " + this.name + "<br>");
		out.println("���� �ܾ� : " + this.money + "<br>");
		out.println("</p>");
	}


}
