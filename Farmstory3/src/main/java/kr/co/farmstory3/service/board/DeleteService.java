package kr.co.farmstory3.service.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.farmstory3.service.CommonService;
import kr.co.farmstory3.dao.ArticleDao;
import kr.co.farmstory3.vo.ArticleVo;

public class DeleteService implements CommonService {

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		
		
		return "/board/view.jsp";
	}

}
