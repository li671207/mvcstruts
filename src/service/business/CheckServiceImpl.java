package service.business;


import java.util.HashMap;
import java.util.Map;

import service.business.CheckService;
import service.vo.MessageVO;

public class CheckServiceImpl implements CheckService {

	@Override
	public Map<String, MessageVO> getVO(String attribute) {
		MessageVO messageVO = new MessageVO();
		Map<String, MessageVO> map = new HashMap<String, MessageVO>();
		
		if(isSure(attribute)){
			messageVO.setMsg(attribute);
			messageVO.setMsg1("success");
			messageVO.setMsg2("sssss");
			messageVO.setName("admin");
			map.put("/view/success.jsp", messageVO);
		}else{
			messageVO.setMsg(attribute);
			messageVO.setMsg1("failed");
			messageVO.setMsg2("fffff");
			messageVO.setName("guest");
			map.put("/view/failed.jsp", messageVO);
		}
		
		return map;
	}
	public boolean isSure(String attribute) {
		if("admin".equals(attribute)){
			return true;
		}else{
			return false;
		}
	}
}
