package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.CommonService;
import vo.UserVo;

// model : 
public class RegisterService implements CommonService{

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		
		if(req.getMethod().equals("GET")) {
			
			return "/register.jsp";
			
		}else {
			// Database Access(처리 로직)
			String uid  = req.getParameter("uid");
			String name = req.getParameter("name");
			String hp   = req.getParameter("hp");
			String age  = req.getParameter("age");
			
			UserVo vo = new UserVo();
			vo.setUid(uid);
			vo.setName(name);
			vo.setHp(hp);
			vo.setAge(age);
			
			// Dao 실행
			UserDao.getInstance().insertUser(vo);
			
			return "redirect:/list.do";
			
		}
		

	}
	
}



