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
		return 0;
	}

	@Override
	public RequestVO selectOne(RequestVO vo) {
		logger.info("selectOne() ... vo : {} ", vo);
		return null;
	}

	@Override
	public ArrayList<RequestVO> selectAll() {
		logger.info("selectAll() ... ");
		return null;
	}

}
