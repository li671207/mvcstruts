package struts.form;

import java.lang.reflect.Field;

import javax.servlet.http.HttpServletRequest;

public class FullForm {
	
	
	public static Object full(HttpServletRequest request, String className){
		Object action = null;
		try {
			Class clazz = Class.forName(className);
			action = clazz.newInstance();
			Field[] fields = clazz.getDeclaredFields();
			for(Field field:fields){
				field.setAccessible(true);
				field.set(action, request.getParameter(field.getName()));
				field.setAccessible(false);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return action;
		
	}

}
