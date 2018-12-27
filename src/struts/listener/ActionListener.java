package struts.listener;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import struts.config.StrutsConfig;
import struts.config.XmlBean;

public class ActionListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("销毁......");

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		ServletContext context = arg0.getServletContext();
		String strutsPath = context.getInitParameter("struts-config");
		System.out.println(strutsPath);
		String realPath = context.getRealPath("\\");
		System.out.println(realPath);
		Map<String, XmlBean> xml = StrutsConfig.getXml(realPath+strutsPath);
		context.setAttribute("struts", xml);
	}

}
