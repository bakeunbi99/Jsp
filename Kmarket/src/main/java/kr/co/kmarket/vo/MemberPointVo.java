package kr.co.kmarket.vo;

import lombok.Data;

@Data
public class MemberPointVo {
	private int pointid;
	private String uid;
	private int productCode;
	private int price;
	private int point;
	private String rdate;
}
