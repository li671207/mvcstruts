package struts.config;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class StrutsConfig {
	/**
	 * 解析struts-config.xml文件
	 * @return
	 */
	public static Map<String, XmlBean> getXml(String xmlPath) {
		Map<String, XmlBean> xmlMap = new HashMap<String, XmlBean>();
		try {
			SAXBuilder builder = new SAXBuilder();
			Document document = builder.build(new File(xmlPath));
			Element rootElement = document.getRootElement();
			Element actionform = rootElement.getChild("formbeans");
			Element actionMapping = rootElement.getChild("action-mapping");
			List<Element> actions = actionMapping.getChildren();
			for(Element action:actions){
				XmlBean xmlBean = new XmlBean();
				String path = action.getAttributeValue("path");
				List<Element> beans = actionform.getChildren();
				String beanName = action.getAttributeValue("name");
				xmlBean.setBeanName(beanName);
				for(Element bean:beans){
					if(beanName.equals(bean.getAttributeValue("name"))){
						xmlBean.setFormClass(bean.getAttributeValue("class"));
						break;
					}
				}
				xmlBean.setActionType(action.getAttributeValue("type"));
				xmlBean.setPath(path);
				
				List<Element> forwards = action.getChildren();
				Map<String, String> fMap = new HashMap<String,String>();
				for(Element forward:forwards){
					fMap.put(forward.getAttributeValue("name"), forward.getAttributeValue("value"));
				}
				xmlBean.setForwardMap(fMap);
				
				xmlMap.put(path, xmlBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return xmlMap;
	}

	public static void main(String[] args) {
		System.out.println(getXml("WebContent/WEB-INF/struts-config.xml"));
	}
}
