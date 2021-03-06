package kr.co.farmstory3.service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.farmstory3.dao.MemberDao;
import kr.co.farmstory3.service.CommonService;
import kr.co.farmstory3.vo.TermsVo;

public class TermsService implements CommonService {

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		
		TermsVo vo = MemberDao.getInstance().selectTrems();
		req.setAttribute("vo", vo); //
		
		return "/member/terms.jsp";
		
		
	}

}
