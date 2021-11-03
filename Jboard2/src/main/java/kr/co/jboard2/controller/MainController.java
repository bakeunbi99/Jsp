package kr.co.jboard2.controller;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
// 컨트롤러 서블릿 서비스 등록 -> web.xml
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jboard2.service.CommonService;
import kr.co.jboard2.vo.FileVo;

// 컨트롤러 : 클라이언트에 대한 요청을 처리하는 컴퍼넌트
public class MainController extends HttpServlet {
	/**
	 * 서블릿을 상속 받았기 때문에 구분하기 위한 시리얼 번호
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> instances = new HashMap<>(); //해시맵 구조체
	

	//init 초기 작업
	@Override
	public void init(ServletConfig config) throws ServletException {
		// 최초 요청시 실행되는 컨트롤러 초기화 메서드
		System.out.println("MainController init 실행!!!");
		// 액션주소 프로퍼티 파일 경로 구하기
		ServletContext ctx = config.getServletContext();
		String path = ctx.getRealPath("/WEB-INF") + "/urlMapping.properties";
		
		// 프로퍼티 파일 입력스트림 연결 후 프로퍼티 객체 생성 
		Properties prop = new Properties();
		//Map<String, String> map = new HashMap<>();
		
		try {
			FileInputStream fis = new FileInputStream(path);
			prop.load(fis);
			fis.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		// 프로퍼티 객체로 서비스 객체 생성
		Iterator iter = prop.keySet().iterator();
		
		while(iter.hasNext()) {
			
			String k = iter.next().toString();
			String v = prop.getProperty(k);
			
			try {
				Class obj = Class.forName(v); // 클래스 obj = model.HelloService
				Object instance = obj.newInstance(); //Object 타입으로 선언해서 instance 할당
				
				//put HelloService, .., greetingService
				instances.put(k, instance); //instances 만드는 이유 : 
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		} 
	} // init end ..
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestProc(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.setCharacterEncoding("utf-8"); -> 필터 적용
		requestProc(req, resp);
	}
	
	//요청 처리
	protected void requestProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 요청주소에서 key 구하기
		String path = req.getContextPath(); // Ch07 : 프로젝트 이름
		String uri = req.getRequestURI();	// hello.do : key값 
		String key = uri.substring(path.length()); // /hello.do
		
		
		// Map에서 Service 객체 꺼내기
		CommonService instance = (CommonService) instances.get(key); //부모 인터페이스를 만들어 사용 -> CommonService로 캐스팅
		//Object 타입으로 instance를 구현하기 위해  
		//HelloService service = (HelloService) instance; //하나하나 선택 할 수 없으니
				
		// Service 객체 실행 후 결과(View, 리다이렉트) 정보 받기
		String result = instance.requestProc(req, resp);
		
		
		//컨트롤러 기능 확장 -> 리다이렉트 기능 추가
		if(result.startsWith("redirect:") ) { // 만약 
			// 리다이렉트
			String redirecUrl = result.substring(9);
			resp.sendRedirect(path+redirecUrl);
		}else if(result.startsWith("json:")){ //"{'key':'value'}" 문자열에서 => {'key':'value'} Json 객체로 변환
			// Json 출력
			PrintWriter out = resp.getWriter();
			out.print(result.substring(5)); // 5부터 자르겠다.
			
		}else if(result.startsWith("file:")) { //result 서비스로 부터 리턴 받는 값 'file'
			
			// Service에서 저장한 FileVo 객체 Controller에서 꺼내기 ( 클라이언트로 파일 전송 )
			FileVo fvo = (FileVo) req.getAttribute("fvo");
			 
			// 파일 다운로드 response 헤더 수정
			resp.setContentType("application/octet-stream");
			resp.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode(fvo.getOriName(), "utf-8"));	
			resp.setHeader("Content-Transfer-Encoding", "binary");
			resp.setHeader("Pragma", "no-cache");
			resp.setHeader("Cache-Control", "private");
			
			
			// response 객체 파일 스트림 작업
			String filePath = req.getServletContext().getRealPath("/file");
			File file = new File(path+"/" + fvo.getNewName()); //년월일시분초_아이디
			
			// 데이터 이동
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
			BufferedOutputStream bos = new BufferedOutputStream(resp.getOutputStream());
			
			
			while(true) {
				int data = bis.read();
				
				// 더이상 읽을 데이터가 없을 경우
				if(data == -1) {
					break;
				}
				
				bos.write(data);
			}
			bos.close();
			bis.close();
		}else{
			// 해당 View로 forward 하기
			RequestDispatcher dispatcher = req.getRequestDispatcher(result);
			dispatcher.forward(req, resp);
		}
		
		
	}
	
}


