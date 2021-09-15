package kr.co.jboard2.service.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.jboard2.dao.MemberDao;
import kr.co.jboard2.service.CommonService;
import kr.co.jboard2.vo.MemberVo;


// model : 
public class LoginService implements CommonService{

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		
		if(req.getMethod().equals("GET")) {
			
			String success = req.getParameter("success");
			req.setAttribute("success", success);
			
			
			return "/user/login.jsp";
			
		}else {
			// Database Access(처리 로직)
			String uid   = req.getParameter("uid");
			String pass = req.getParameter("pass");
			
			
			MemberVo vo = MemberDao.getInstance().selectMember(uid, pass); //NULL or VO객체 return
			
			if(vo != null) {
				// 회원이 맞을 경우 -> 사용자 정보 객체 세션저장 후 리스트 리다이렉트
				HttpSession sess = req.getSession();
				sess.setAttribute("sessMember", vo);
				
				
				return "redirect:/list.do";
				
			}else {
				// 회원이 아닐 경우 -> 사용자 정보객체 세션저장
				return "redirect:/user/login.do?success=100";
			}
			
		
			
			
			
		}
	}
	
}




