package kr.co.farmstory3.service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import kr.co.farmstory3.dao.MemberDao;
import kr.co.farmstory3.service.CommonService;


// model : 
public class CheckUidService implements CommonService{

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		
		String uid = req.getParameter("uid");
		
		int count = MemberDao.getInstance().selectCountUid(uid);
		
		//Json 타입의 데이터 생성
		JsonObject json = new JsonObject();
		json.addProperty("result", count); //{'result':1'}, {'result':0'}
		
		//Json 타입의 문자열 생성		
		return "json:"+json.toString(); //"json:{'result':1}"
		
		
	}
	
	
}