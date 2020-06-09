package test.com.request;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import test.com.request.VO.RequestVO;

// 상속을 명시하기 위해 클래스명칭을 아래처럼 정함
public class TestDAOimpl implements TestDAO {
	private static final Logger logger = LoggerFactory.getLogger(TestDAOimpl.class);
	
	@Override
	public int insert(RequestVO vo) {
		logger.info("insert() ... vo : {} ", vo);
		return 1;
	}

	@Override
	public RequestVO selectOne(RequestVO vo) {
		logger.info("selectOne() ... vo : {} ", vo);
		
		RequestVO requestVO = new RequestVO();
		requestVO.setNum(vo.getNum());
		requestVO.setName(vo.getName());
		requestVO.setTel(vo.getTel());
	
		return requestVO;
	}

	@Override
	public ArrayList<RequestVO> selectAll() {
		logger.info("selectAll() ... ");
		
		ArrayList<RequestVO> list = new ArrayList<RequestVO>();
		RequestVO vo = null;
		for(int i =0; i<4; i++) {
			vo = new RequestVO();
			vo.setNum(i);
			vo.setName("kim" + i);
			vo.setTel("tel " + i);
			list.add(vo);					
		}
		
		return list;
	}

	@Override
	public int delete(RequestVO vo) {
		logger.info("delete() ... vo : {} ", vo);
		return 1;
	}

	@Override
	public int update(RequestVO vo) {
		logger.info("update() ... vo : {} ", vo);
		return 1;
	}

}
