package test.com.request;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import test.com.request.VO.RequestVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class RequestController {	
	private static final Logger logger = LoggerFactory.getLogger(RequestController.class);
	// service 호출
	TestService ts = new TestService();
	
	// 등록 페이지 이동
	@RequestMapping(value = "/insert.do", method = RequestMethod.GET)
	public String insertPage() {
		logger.info("insert on");
						
		return "/jsp/insert";
	}
	
	// 목록 페이지 이동
	@RequestMapping(value = "/selectAll.do", method = RequestMethod.GET)
	public String selectPage(Model model) {
		logger.info("select on");
		
		/* DAO 사용 전에는 직접 선언했으나 DAO 생성 후에는 DAO에 로직을 추가해놨음
		ArrayList<RequestVO> list = new ArrayList<RequestVO>();
		RequestVO vo = null;
		for(int i =0; i<4; i++) {
			vo = new RequestVO();
			vo.setName("kim" + i);
			vo.setTel("tel " + i);
			list.add(vo);					
		}*/
		
		// service의 selectAll를 호출해서 list에 담음
		ArrayList<RequestVO> list = ts.selectAll();
		model.addAttribute("list", list);
						
		return "/jsp/selectAll";
	}
	
	// 등록 액션
	//@ResponseBody
	@RequestMapping(value = "/insertOK2.do", method = RequestMethod.POST)		// post 전송으로 맞춰줌
	public String insertOK2() {
		logger.info("insertOK on");		
		
		try {			
			
		}catch(NullPointerException e) {
			
		}catch(Exception e) {
			
		}				
						
		return "redirect:selectAll.do";		// redirect로 페이지 이동
	}

	// Httpservletrequest는 예전에 쓰던 방법임
	@RequestMapping(value = "/selectOne_old.do", method = RequestMethod.GET)
	public String selectOneOld(HttpServletRequest request, Model model) {			
		logger.info("selectOne on");
		
		try {			
			String name = request.getParameter("name");
			String tel = request.getParameter("tel");			
			
			model.addAttribute("name", name);
			model.addAttribute("tel", tel);
		}catch(NullPointerException e1) {
			model.addAttribute("name", "null error");
			model.addAttribute("tel", "200");
		}catch(Exception e) {
			model.addAttribute("name", e.toString());
			model.addAttribute("tel", "201");
		}				
						
		return "/jsp/selectOne";		
	}
	
	// String tel 등 변수를 매개변수 안에 선언해서 바로 사용
	@RequestMapping(value = "/selectOne.do", method = RequestMethod.GET)
	public String selectOne( Model model, RequestVO vo, String name, String tel) {				// 매개변수 안에 바로 넣어줌. vo만 넣어줘도 됨.		
		logger.info("selectOne on ! vo : {}", vo);
		
		RequestVO requestVO = ts.selectOne(vo);
		
		try {												
			model.addAttribute("model", requestVO);			
		}catch(NullPointerException e1) {
			
		}catch(Exception e) {
			
		}				
						
		return "/jsp/selectOne";		
	}
	
	// 위의 selectone과 또다른 방법임
	@SuppressWarnings("finally")
	@RequestMapping(value = "/insertOK.do", method = RequestMethod.POST)		
	public String insertOK(RequestVO vo) {			// 바로 vo를 입력해줌
		logger.info("insertOK on");
		logger.info("vo :: {}", vo);					// vo에 설정한 파라미터값이 출력됨
		int result = 0;						
		try {						
			result = ts.insert(vo);
			
		}catch(NullPointerException e) {
			
		}catch(IndexOutOfBoundsException e) {
			
		}catch(Exception e) {
			
		}finally {
			if(result == 1) return "redirect:selectAll.do";
			else return "redirect:insert.do";
		}	
	}
	
	@RequestMapping(value = "/deleteOK.do", method = RequestMethod.GET)		
	public String deleteOK(RequestVO vo) {			
		logger.info("deleteOK on");
		
		int result = ts.delete(vo);						
		try {						
						
		}catch(NullPointerException e) {
			
		}catch(IndexOutOfBoundsException e) {
			
		}catch(Exception e) {
			
		}finally {
			
		}	
		
		if(result == 1) return "redirect:selectAll.do";
		else return "redirect:insert.do";
	}
	
}
