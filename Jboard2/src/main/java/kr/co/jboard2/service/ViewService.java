package kr.co.jboard2.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jboard2.dao.ArticleDao;
import kr.co.jboard2.vo.ArticleVo;

// model : 
public class ViewService implements CommonService{

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {


		String seq = req.getParameter("seq");
		ArticleVo vo = ArticleDao.getInstance().selectArticle(seq);
		req.setAttribute("vo", vo);
		
		
		return "/view.jsp";

	}
	
}



