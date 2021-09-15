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
			
			String pg = req.getParameter("pg");
			
			// 페이지 처리
			int currentPage = getCurrentPageNum(pg);
			int total = ArticleDao.getInstance().selectCountTotal();
			int lastPageNum = getLastPageNum(total);
			int start = getLimitStart(currentPage);
			int pageStartNum = getPageStartNum(total, start);

			
			List<ArticleVo> articles = ArticleDao.getInstance().selectArticles(0);
			
			req.setAttribute("articles", articles);
			req.setAttribute("lastPageNum", lastPageNum);
			req.setAttribute("currentPage", currentPage);
			req.setAttribute("pageStartNum", pageStartNum);
			
			
			return "/list.jsp";
			
		}//if-else
	}//requestProc end
	
	
	//시작 페이지
	public int getCurrentPageNum(String pg) {
		
		if(pg == null){
			pg = "1";
		}
		
		return Integer.parseInt(pg);
		
	}
	//마지막페이지
	public int getLastPageNum(int total) {
		
		int lastPageNum = 0;
		
		if(total % 10 == 0){
			lastPageNum = total / 10;
		}else{
			lastPageNum = total / 10 + 1;
		}
		
		return lastPageNum;
	}
	
	public int getLimitStart(int currentPage) {
		return (currentPage - 1) * 10;
	}
	
	public int getPageStartNum(int total, int start) {
		return (total-start)+1;
	}
	
	
	
	
	
}
