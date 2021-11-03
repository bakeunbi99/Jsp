package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// model 서비스 공통 부모 CommonService 
public interface CommonService {
	
	public String requestProc(HttpServletRequest req, HttpServletResponse resp);
	

}
