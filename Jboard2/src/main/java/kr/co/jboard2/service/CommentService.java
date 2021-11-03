package kr.co.jboard2.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.jboard2.dao.ArticleDao;
import kr.co.jboard2.vo.ArticleVo;
import kr.co.jboard2.vo.MemberVo;


// model : 
public class CommentService implements CommonService{

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		
		String parent = req.getParameter("parent");
		String content = req.getParameter("content");
		String uid = req.getParameter("uid");
		
		String regip = req.getRemoteAddr();
				
		ArticleVo vo = new ArticleVo();
		vo.setParent(parent);
		vo.setContent(content);
		vo.setUid(uid);
		vo.setRegip(regip);
		
		ArticleDao.getInstance().insertComment(vo);
		
		return "redirect:/view.do?seq="+parent;
		
	}
	
}// class end




