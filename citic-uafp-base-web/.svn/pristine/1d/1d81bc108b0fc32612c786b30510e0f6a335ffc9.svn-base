/**========================================================
 * Copyright (c) 2014-2015 by CITIC All rights reserved.
 * Created Date : 2015年9月7日
 * Description: 
 * 
 *=========================================================
 */
package citic.aml.sso.service;

import java.nio.charset.Charset;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

/**
 * @author gaojx
 *
 */
public class DtoCodecFactory implements ProtocolCodecFactory {

	private Charset charset;
	
	public DtoCodecFactory(String charsetName) {
		this.charset = Charset.forName(charsetName);
	}

	/* (non-Javadoc)
	 * @see org.apache.mina.filter.codec.ProtocolCodecFactory#getDecoder(org.apache.mina.core.session.IoSession)
	 */
	@Override
	public ProtocolDecoder getDecoder(IoSession session) throws Exception {
		DtoDecoder decoder = new DtoDecoder();
		decoder.setCharset(charset);
		return decoder;
	}

	/* (non-Javadoc)
	 * @see org.apache.mina.filter.codec.ProtocolCodecFactory#getEncoder(org.apache.mina.core.session.IoSession)
	 */
	@Override
	public ProtocolEncoder getEncoder(IoSession session) throws Exception {
		DtoEncoder encoder = new DtoEncoder();
		encoder.setCharset(charset);
		return encoder;
	}

}
