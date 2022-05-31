package com.laptrinhjava.utils;

import javax.servlet.http.HttpServletRequest;

public class Session {

	private static Session session = null;
	public static Session getInstance() {
		if(session == null) {
			session = new Session();
			//Khoi tao session util cap vung nho khi khoi tao lan dau
		}
		return session;
		//neu da co nguoi khoi tao roi thi return session do
	}
	
	 public void putValue(HttpServletRequest request, String key, Object value) {
	        request.getSession().setAttribute(key, value);
	    }

	    public Object getValue(HttpServletRequest request, String key) {
	        return request.getSession().getAttribute(key);
	    }

	    public void removeValue(HttpServletRequest request, String key) {
	        request.getSession().removeAttribute(key);
	    }
}
