package service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDao;
import dao.MemberDao;
import dao.UserDao;
import model.CommonService;
import vo.CustomerVo;
import vo.MemberVo;
import vo.UserVo;

// model : 
public class RegisterService implements CommonService{

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		
		if(req.getMethod().equals("GET")) {
			
			return "/customer/register.jsp";
			
		}else {
			// Database Access(처리 로직)
			String custid   = req.getParameter("custid");
			String name  = req.getParameter("name");
			String address    = req.getParameter("address");
			String phone   = req.getParameter("phone");
			
			CustomerVo vo = new CustomerVo();
			vo.setCustid(custid);
			vo.setName(name);
			vo.setAddress(address);
			vo.setPhone(phone);
			
			// Dao 실행
			CustomerDao.getInstance().insertCustomer(vo);
			
			return "redirect:/customer/list.do";
			
		}
		

	}
	
}



