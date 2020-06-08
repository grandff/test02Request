package test.com.request.VO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import test.com.request.HomeController;

public class RequestVO {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	public RequestVO() {
		
	}
	
	private String name = "";
	private String tel = "";

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
}