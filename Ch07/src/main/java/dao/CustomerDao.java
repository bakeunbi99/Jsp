package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vo.CustomerVo;
import vo.MemberVo;
import vo.UserVo;

//database 처리 로직
public class CustomerDao {
	
	// 싱글톤 객체
	private static CustomerDao instance = new CustomerDao();
	
	public static CustomerDao getInstance() {
		return instance;
	}
	
	public CustomerDao() {}; //UserDao dao = new UserDao()로 생성하지 못하게
	
	
	private final String HOST = "jdbc:mysql://192.168.56.101:3306/p57575777";
	private final String USER = "p57575777";
	private final String PASS = "1234";
		
	
		/*=================================
			customer insert
		=================================*/
		public void insertCustomer(CustomerVo vo) {
			try {
				//1단계
				Class.forName("com.mysql.jdbc.Driver");
				//2단계
				Connection conn = DriverManager.getConnection(HOST, USER, PASS);
				//3단계
				String sql = "INSERT INTO `Customer`(`name`, `address`, `phone`) VALUES(?, ?, ?);";
				
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, vo.getName());
				psmt.setString(2, vo.getAddress());
				psmt.setString(3, vo.getPhone());
				
				//4단계
				psmt.executeUpdate();
				
				//5단계
				//6단계
				psmt.close();
				conn.close();
			
				
			}catch (Exception e) {
				System.out.print("입력 오류");
				e.printStackTrace();
			}
		}
		
		
		/*=================================
			customer select
		=================================*/
		public CustomerVo selectCustomer(String uid) {
			
			CustomerVo vo = null;
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection(HOST, USER, PASS);
				
				PreparedStatement psmt = conn.prepareStatement("SELECT * FROM `Customer` WHERE `custid`=?");
				psmt.setString(1, uid);
				
				ResultSet rs = psmt.executeQuery();
				
				if(rs.next()) {
					vo = new CustomerVo();
					vo.setCustid(rs.getString(1));
					vo.setName(rs.getString(2));
					vo.setAddress(rs.getString(3));
					vo.setPhone(rs.getString(4));
				}
				
				rs.close();
				psmt.close();
				conn.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}		
			
			return vo;
			
		}
		
		
		/*=================================
			customer list select
		=================================*/
		public List<CustomerVo> selectCustomers() {
			
			List<CustomerVo> customers = new ArrayList<>();
			
			try {
				//1단계
				Class.forName("com.mysql.jdbc.Driver");
				//2단계
				Connection conn = DriverManager.getConnection(HOST, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM `Customer`");
				
				while(rs.next()) {
					CustomerVo vo = new CustomerVo();
					vo.setCustid(rs.getString(1));
					vo.setName(rs.getString(2));
					vo.setAddress(rs.getString(3));
					vo.setPhone(rs.getString(4));
					
					customers.add(vo);
					
				}
				
				rs.close();
				stmt.close();
				conn.close();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			return customers;
			
		}
		
		
		/*=================================
			customer update
		=================================*/
		public void updateCustomer(CustomerVo vo) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection(HOST, USER, PASS);
				
				String sql = "UPDATE `Customer` SET `name`=?, `address`=?, `phone`=? WHERE `custid`=?";
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, vo.getName());
				psmt.setString(2, vo.getAddress());
				psmt.setString(3, vo.getPhone());
				
				psmt.executeUpdate();
				psmt.close();
				conn.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		/*=================================
			customer delete
		=================================*/
		public void deleteCustomer(String uid) {
			try {
				//1단계
				Class.forName("com.mysql.jdbc.Driver");
				//2단계
				Connection conn = DriverManager.getConnection(HOST, USER, PASS);
				//3단계
				String sql = "DELETE FROM `Customer` WHERE `custid`=?";
				
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
