package struts.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import struts.config.XmlBean;
import struts.form.ActionForm;



public interface Action {
	
	public String exec(ActionForm actionForm, Map<String, String> forwardMap);

}
