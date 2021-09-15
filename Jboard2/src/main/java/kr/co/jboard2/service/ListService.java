package kr.co.jboard2.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.jboard2.dao.ArticleDao;
import kr.co.jboard2.vo.ArticleVo;
import kr.co.jboard2.vo.MemberVo;


// model : 
public class ListService implements CommonService{

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		
		HttpSession sess = req.getSession();
		MemberVo sessMember = (MemberVo) sess.getAttribute("sessMember");
		
		if(sessMember == null) {
			return "redirect:/user/login.do?success=102";
		}else {
			
			List<ArticleVo> articles = ArticleDao.getInstance().selectArticles(0);
			req.setAttribute("articles", articles);
			
			//ArticleVo vo = new ArticleVo();
			
			String pg = req.getParameter("pg");
			
			if(pg == null){
				pg = "1";
			}
			
			// 페이지 처리
			int start = 0;
			int currentPage = Integer.parseInt(pg);
			int total = ArticleDao.getInstance().selectCountTotal();
			int lastPageNum = 0;
			
			if(total % 10 == 0){
				lastPageNum = total / 10;
			}else{
				lastPageNum = total / 10 + 1;
			}	
			start = (currentPage - 1) * 10;
			
			int pageStartNum = total - start;
			int groupCurrent = (int)Math.ceil(currentPage / 10.0);
			int groupStart = (groupCurrent - 1) * 10 + 1;
			int groupEnd = groupCurrent * 10;
			
			if(groupEnd > lastPageNum){
				groupEnd = lastPageNum;
			}
			
			
			
			
			
			return "/list.jsp";
			
		}
		
		
	}
}
