/**========================================================
 * Copyright (c) 2014-2015 by CITIC All rights reserved.
 * Created Date : 2015年9月7日
 * Description: 
 * 
 *=========================================================
 */
package citic.aml.sso.service;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

import org.apache.commons.lang3.StringUtils;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

import citic.aml.system.domain.Mp02_user;
import lombok.Getter;
import lombok.Setter;

/**
 * @author gaojx
 *
 */
public class DtoEncoder implements ProtocolEncoder {

	/** 编码 */
	/** 编码 */
	@Getter @Setter
	private Charset charset;
	
	/* (non-Javadoc)
	 * @see org.apache.mina.filter.codec.ProtocolEncoder#dispose(org.apache.mina.core.session.IoSession)
	 */
	@Override
	public void dispose(IoSession arg0) throws Exception {
	}

	/* (non-Javadoc)
	 * @see org.apache.mina.filter.codec.ProtocolEncoder#encode(org.apache.mina.core.session.IoSession, java.lang.Object, org.apache.mina.filter.codec.ProtocolEncoderOutput)
	 */
	@Override
	public void encode(IoSession session, Object message, ProtocolEncoderOutput out) throws Exception {
		CharsetEncoder encoder = charset.newEncoder();
		String tmpStr = message.toString();
		int len = tmpStr.length();//取报文长度
		System.out.println("＝＝＝＝＝＝＝＝＝＝＝＝报文总长："+len);
		System.out.println("＝＝＝＝＝＝＝＝＝＝＝＝报文内容："+tmpStr);
		IoBuffer buffer = IoBuffer.allocate(1024).setAutoExpand(true);
		buffer.putInt(len);
		buffer.putString(tmpStr, encoder);
		buffer.flip();
		out.write(buffer);
		
	}
	


}
