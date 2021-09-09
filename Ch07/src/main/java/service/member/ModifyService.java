package service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CommonService;

// model : 
public class ModifyService implements CommonService{

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return "/member/modify.jsp";
	}
	
	
}
