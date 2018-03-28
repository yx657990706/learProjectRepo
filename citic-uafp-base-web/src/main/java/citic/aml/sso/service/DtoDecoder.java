/**========================================================
 * Copyright (c) 2014-2015 by CITIC All rights reserved.
 * Created Date : 2015年4月16日 下午7:38:54
 * Description: 
 * 
 *=========================================================
 */
package citic.aml.sso.service;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

import lombok.Getter;
import lombok.Setter;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.AttributeKey;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author gaojianxin 将ESB传输过来的数据，装换为JAVA对象
 * 
 */
public class DtoDecoder extends CumulativeProtocolDecoder {
	final static Logger logger = LoggerFactory.getLogger(DtoDecoder.class);
	private final AttributeKey CONTEXT = new AttributeKey(getClass(), "context");

	/** 报文长度 */
	private final int msgLen = 4;

	/** 编码 */
	@Getter @Setter
	private Charset charset;

	@Override
	protected boolean doDecode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {
		IoBuffer buffer = IoBuffer.allocate(5120).setAutoExpand(true);;
		String msgStr = "";
		CharsetDecoder decode = charset.newDecoder();
		if (in.prefixedDataAvailable(msgLen)) {
			int length = in.getInt();
			buffer.flip();
			msgStr = in.getString(length, decode);
			logger.debug("decode msg:"+msgStr);
			out.write(msgStr);
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 处理
	 * @param msgStr 去掉了长度统计的纯报文
	 * @return
	 */
//	private String getMsgBody(String msgStr){
////        String body = ;//去报文头
//		System.out.println("＝＝＝＝＝＝＝＝响应报文:"+msgStr);
//        System.out.println("＝＝＝＝＝＝＝＝响应报文头:"+msgStr.substring(0,76));
//        System.out.println("＝＝＝＝＝＝＝＝响应报文体:"+msgStr.substring(76));
//		return msgStr;
//	}

	private Context getContext(IoSession session) {
		Context context = (Context) session.getAttribute(CONTEXT);
		if (context == null) {
			context = new Context();
			session.setAttribute(CONTEXT, context);
		}
		return context;
	}

	private class Context {
		private final IoBuffer innerBuffer;
		@Setter
		@Getter
		private String msgLen = "";
		@Setter
		@Getter
		private String msgStr = "";
		@Setter
		@Getter
		private int matchCount = 0;
		@Setter
		@Getter
		private boolean isHead = true;

		public Context() {
			innerBuffer = IoBuffer.allocate(1024).setAutoExpand(true);
		}

		public void reset() {
			this.innerBuffer.clear();
			this.msgStr = "";
			this.msgLen = "";
			this.matchCount = 0;
			this.isHead = true;
		}
	}
}
