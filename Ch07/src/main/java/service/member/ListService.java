package service.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import model.CommonService;
import vo.MemberVo;

// model : 
public class ListService implements CommonService{

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		
		
		// 데이터 조회
		List<MemberVo> members = MemberDao.getInstance().selectMembers();
				
		// 컴포넌트간의 데이터 공유 (View에서 해당 list를 참조해서 출력해야하기 때문에)
		req.setAttribute("members", members);
				
				
		return "/member/list.jsp";
	
	}
	
}
