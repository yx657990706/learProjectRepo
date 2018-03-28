/**========================================================
 * Copyright (c) 2014-2015 by CITIC All rights reserved.
 * Created Date : 2015年9月7日
 * Description: 
 * 
 *=========================================================
 */
package citic.aml.sso.service;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * @author gaojx
 * 柜员处理类
 */
public class SsoHandler extends IoHandlerAdapter {
	private final Logger logger = LoggerFactory.getLogger(SsoHandler.class);
	
	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		logger.error("处理时出现异常...");
		logger.error(cause.getMessage());
		session.close(true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.mina.core.service.IoHandlerAdapter#messageReceived(org.apache
	 * .mina.core.session.IoSession, java.lang.Object)
	 */
	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		logger.debug("client accept data:" + message.toString());
	}
	
	@Override
	public void sessionClosed(IoSession session) throws Exception {
		logger.warn("session 关闭 ...");
		session.close(true);
	}
	
}
