package test.com.request;

import java.util.ArrayList;

import test.com.request.VO.RequestVO;

// dao impl과 유사한 역할이나 중간다리 기능을 한다고 보면 됨
public class TestService {
	// 아래의 메서드를 접근하려면 service 객체의 함수로 접근해야함
	// service객체에는 로직을 넣으면 안되고 연결만 해줘야함
	
	// dao 객체 생성
	private TestDAO dao = new TestDAOimpl();
	
	public int insert(RequestVO vo) {
		return dao.insert(vo);
	}
	
	public RequestVO selectOne(RequestVO vo) {
		return dao.selectOne(vo);
	}
	
	public ArrayList<RequestVO> selectAll(){
		return dao.selectAll();
	}

	public int delete(RequestVO vo) {
		// TODO Auto-generated method stub
		return dao.delete(vo);
	}

}
