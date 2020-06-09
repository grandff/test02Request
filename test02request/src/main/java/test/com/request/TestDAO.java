package test.com.request;

import java.util.ArrayList;

import test.com.request.VO.RequestVO;

public interface TestDAO {
	public int insert(RequestVO vo);
	public RequestVO selectOne(RequestVO vo);
	public ArrayList<RequestVO> selectAll();
	public int delete(RequestVO vo);
}
