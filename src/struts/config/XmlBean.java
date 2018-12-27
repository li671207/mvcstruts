package struts.config;

import java.util.Map;

public class XmlBean {
	
	private String beanName;
	private String formClass;
	private String actionType;
	
	private String path;
	private Map<String, String> forwardMap;
	
	public String getBeanName() {
		return beanName;
	}
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
	public String getFormClass() {
		return formClass;
	}
	public void setFormClass(String formClass) {
		this.formClass = formClass;
	}
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Map<String, String> getForwardMap() {
		return forwardMap;
	}
	public void setForwardMap(Map<String, String> forwardMap) {
		this.forwardMap = forwardMap;
	}
	
	@Override
	public String toString() {
		return "XmlBean [beanName=" + beanName + ", formClass=" + formClass
				+ ", actionType=" + actionType + ", path=" + path
				+ ", forwardMap=" + forwardMap + "]";
	}
	
}
