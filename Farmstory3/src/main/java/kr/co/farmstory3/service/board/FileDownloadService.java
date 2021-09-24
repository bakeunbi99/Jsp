package kr.co.farmstory3.service.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.farmstory3.service.CommonService;
import kr.co.farmstory3.dao.ArticleDao;
import kr.co.farmstory3.vo.FileVo;

// model : 
public class FileDownloadService implements CommonService{

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		
		String fseq = req.getParameter("fseq");
		
		//파일 다운로드 카운트 +1
		
		//파일정보 가져오기
		FileVo fvo = ArticleDao.getInstance().selectFile(fseq);

		// Controller에서 파일 객체 참조하기 위해 여기서 저장
		req.setAttribute("fvo", fvo); //request 객체로 셋팅
		
		
		
		// Controller에서 파일 다운로드 기능 실행을 위한 문자열 
		return "file:"; //파일 전송을 컨트롤러가 해줘야 함.
		
		
	}
	
}// class end


