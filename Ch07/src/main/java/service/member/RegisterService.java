package service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import dao.UserDao;
import model.CommonService;
import vo.MemberVo;
import vo.UserVo;

// model : 
public class RegisterService implements CommonService{

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		
		if(req.getMethod().equals("GET")) {
			
			return "/member/register.jsp";
			
		}else {
			// Database Access(처리 로직)
			String uid   = req.getParameter("uid");
			String name  = req.getParameter("name");
			String hp    = req.getParameter("hp");
			String pos   = req.getParameter("pos");
			String dep      = req.getParameter("dep");
			
			MemberVo vo = new MemberVo();
			vo.setUid(uid);
			vo.setName(name);
			vo.setHp(hp);
			vo.setPos(pos);
			vo.setDep(dep);
			
			// Dao 실행
			MemberDao.getInstance().insertMember(vo);
			
			return "redirect:/member/list.do";
			
		}
		

	}
	
}



