/**========================================================
 * Copyright (c) 2014-2015 by CITIC All rights reserved.
 * Created Date : 2015年8月20日 下午9:10:18
 * Description: 
 * 
 *=========================================================
 */
package citic.aml.sso.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author gaojianxin
 *
 */
public class SsoINterceptor  extends HandlerInterceptorAdapter{
	/** 日志记录器 */
	private  final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String loginUrl = "/cas_login";

		response.setHeader("Pragma", "no-cache");
		response.addHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		
	   String loginname = (String) request.getSession().getAttribute("loginname");
	    if( loginname != null) {   
	    	logger.debug("用户["+loginname+"]已登录...");
	        return super.preHandle(request, response, handler);  
	    }   else{
	    	logger.debug("用户未登录或session超时...");
	    }
	    if(request.getServletPath().startsWith(loginUrl)) {   
		       return true;   
		   }   
	           
	    response.sendRedirect(request.getContextPath() + loginUrl);   
	    return false; 
	}

}
