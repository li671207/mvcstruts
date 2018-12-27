package struts.action;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import service.business.CheckService;
import service.business.CheckServiceImpl;
import service.vo.MessageVO;
import struts.config.StrutsConfig;
import struts.config.XmlBean;
import struts.form.ActionForm;
import struts.form.CheckForm;

public class CheckActionImpl implements Action {

	@Override
	public String exec(ActionForm actionForm,Map<String, String> forwardMap) {

		CheckForm checkForm = (CheckForm) actionForm;
		System.out.println(checkForm);
		
		if("admin".equals(checkForm.getText())){
			return forwardMap.get("success");
		}else {
			return forwardMap.get("failed");
		}
	}

}
