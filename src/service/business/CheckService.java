package service.business;


import java.util.Map;

import service.vo.MessageVO;

public interface CheckService {
	
	public Map<String, MessageVO> getVO(String attribute);

}
