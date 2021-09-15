package kr.co.jboard2.service.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import kr.co.jboard2.dao.MemberDao;
import kr.co.jboard2.service.CommonService;


// model : 
public class CheckEmailService implements CommonService{

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		
		String email = req.getParameter("email");
		
		int count = MemberDao.getInstance().selectCountEmail(email);
		
		//Json 타입의 데이터 생성
		JsonObject json = new JsonObject();
		json.addProperty("result", count); //{'result':1'}, {'result':0'}
		
		//Json 타입의 문자열 생성		
		return "json:"+json.toString(); //"json:{'result':1}"
		
		
	}
	
	
}
