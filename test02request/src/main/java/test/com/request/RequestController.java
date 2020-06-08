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
		
		ArrayList<RequestVO> list = new ArrayList<RequestVO>();
		RequestVO vo = null;
		for(int i =0; i<4; i++) {
			vo = new RequestVO();
			vo.setName("kim" + i);
			vo.setTel("tel " + i);
			list.add(vo);					
		}
		model.addAttribute("list", list);
						
		return "/jsp/selectAll";
	}
	
	// 등록 액션
	//@ResponseBody
	@RequestMapping(value = "/insertOK.do", method = RequestMethod.POST)		// post 전송으로 맞춰줌
	public String insertOK() {
		logger.info("insertOK on");
		
		String result = "";
		String resultMsg = "";
		
		try {			
			
		}catch(NullPointerException e1) {
			result = "500";
		}catch(Exception e) {
			result = "600";
		}				
						
		return "redirect:selectAll.do";		// redirect로 페이지 이동
	}
	
	@RequestMapping(value = "/selectOne.do", method = RequestMethod.GET)		
	public String selectOne(HttpServletRequest request, Model model) {
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
	
}
