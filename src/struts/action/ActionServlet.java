package struts.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import struts.config.XmlBean;
import struts.form.ActionForm;
import struts.form.FullForm;

public class ActionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3137831652369054389L;
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Map<String, XmlBean> xml = (Map<String, XmlBean>) this.getServletContext().getAttribute("struts");
		
		String path = req.getServletPath().split("\\.")[0];
		
		XmlBean xmlBean = xml.get(path);
		
		ActionForm actionForm = (ActionForm) FullForm.full(req, xmlBean.getFormClass());
		
		Action action = (Action) FullForm.full(req, xmlBean.getActionType());
		
		System.out.println(action.exec(actionForm,xmlBean.getForwardMap()));
		
		req.getRequestDispatcher(action.exec(actionForm,xmlBean.getForwardMap())).forward(req, resp);
	}

}
