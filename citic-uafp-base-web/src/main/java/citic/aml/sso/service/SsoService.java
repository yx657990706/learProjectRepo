/**========================================================
 * Copyright (c) 2014-2015 by CITIC All rights reserved.
 * Created Date : 2015年3月31日 下午1:26:15
 * Description: 
 * 
 *=========================================================
 */
package citic.aml.sso.service;

import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.future.ReadFuture;
import org.apache.mina.core.future.WriteFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.SocketSessionConfig;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import citic.aml.system.domain.Mp02_user;
import citic.base.utils.DtUtils;
import citic.base.utils.MD5;
import citic.base.utils.StrUtils;

/**
 * @author gaojianxin a.用户登录，将用户名和密码按要求封装为定长的字符串 
 * b.发送字符串到网关，等待响应并获取响应结果［定长字符串］
 *  c.截取code＋flag，进行判断，做对应处理
 */
public class SsoService {
	final static Logger logger = LoggerFactory.getLogger(SsoService.class);

	@Setter
	@Getter
	private int prot = 9123;
	@Setter
	@Getter
	private long timeout = 30 * 1000L; // 30 seconds
	@Setter
	@Getter
	private String host = "localhost";
	@Setter@Getter
	private String mainsysId = "99";//柜面分配的系统标识

	private IoConnector connector = null;

	public void init() {
		connector = new NioSocketConnector();
		connector.setConnectTimeoutMillis(timeout);
		ProtocolCodecFactory codeFactory = new DtoCodecFactory("GBK");
		connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(codeFactory));

		SocketSessionConfig sessionConfig = (SocketSessionConfig) connector.getSessionConfig();
		sessionConfig.setUseReadOperation(true);

		connector.setHandler(new SsoHandler());
		connector.setDefaultRemoteAddress(new InetSocketAddress(host, prot));

	}

	public void close() {
		if (null != connector) {
			connector.dispose();
		}
	}

	/**
	 * @param args
	 */
	public Mp02_user trans(Mp02_user mp02_user) {
		String message = "";
		IoSession session = null;
		ConnectFuture future = null;

		try {
			// 进行消息传输
			future = connector.connect();
			future.awaitUninterruptibly();
			session = future.getSession();
			// 组装定长报文
			String sendMgs = getSendMgs(mp02_user);
			logger.info("请求报文：" + sendMgs);
			// 发送报文
			WriteFuture writeF = session.write(sendMgs);
			writeF.awaitUninterruptibly();
			if (writeF.isWritten()) {
				// 准备读操作
				ReadFuture readF = session.read();
				// 等待消息响应
				readF.awaitUninterruptibly();
				if (readF.isRead()) {
					// 接收到消息，进行业务处理
					message = (String) readF.getMessage();
				}
			}

		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		} finally {
			if (null != session) {
				session.close(true);
				session = null;
			}
		}
		return getChkRslt(message);
	}

	/**
	 * 组装要发送的定长报文［不包含前四位长度统计］
	 * 
	 * @param message
	 * @return
	 */
	private String getSendMgs(Mp02_user mp02_user) {

		StringBuffer mgsbuf = new StringBuffer();
		String headStr = this.getHeadStr("990001");// 柜员签到交易报文头部
		mgsbuf.append(headStr);
		String tellerno = mp02_user.getLoginname().trim();// 用户名
		String tellernoPwd = mp02_user.getPassword().trim();// 统一柜员密码为8-20位，必须是字母和数字的组合。
		String verifyRandom = RandomStringUtils.randomAlphanumeric(20);// ;//六位随机数左补0到20位
		// 密码检查 (统一柜员号+统一柜员密码)使用md5算出摘要值(必须是大写字母)，再用(随机数+摘要值)使用md5算出摘要值。
		tellernoPwd = getPsswordByMD5(verifyRandom, tellerno, tellernoPwd);
		// 拼装报文体
		mgsbuf.append(StringUtils.rightPad(tellerno, 10, ' '));// 10-tellerno
																// 统一柜员号
		mgsbuf.append(StringUtils.rightPad(tellernoPwd, 60, ' '));// //60-tellernoPwd
																	// 统一柜员密码
		mgsbuf.append(verifyRandom);// 20-verifyRandom 随s机数
		mgsbuf.append(StringUtils.rightPad(mainsysId, 4, ' '));// 4-mainsysId 系统标志 柜面分配的2位数
		mgsbuf.append("000005");// 6-templateCodeName 交易模版
		mgsbuf.append("990001");// 6-G_TRANSCODE 交易代码

		return mgsbuf.toString();
	}

	/**
	 * 解析获取的定长报文
	 * 
	 * 根据约定，报文头长80 ＝长度统计［4］＋其他［76］ 其中长度统计在解码时已经处理了，这里的message ＝head［76］＋body
	 * 报文体长度为106
	 * 
	 * "0000"表示成功，其他表示失败。 其中需要单独判断情况：当密码过期的时候，errorCode为0000，pwdmodFlag为1。
	 * 外围系统考虑此种情况，提示柜员修改密码，并不允许登录系统。此时不会返回柜员其他基本信息。
	 * 
	 * 返回码定义 A0000:成功 A0001:需要修改密码 A0002:失败
	 * 
	 * @param message
	 * @return
	 */
	private Mp02_user getChkRslt(String message) {
		Mp02_user mp02_user = new Mp02_user();
		String msgcode = "A0000";
		// String tradeCode = StrUtils.subStr(message, 53, 59);//交易代码
		String errorCode = StrUtils.subStr(message, 77, 7).trim();// 返回码长7，实际4，去空格
		String pwdmodFlag = StrUtils.subStr(message, 144, 1);// 密码修改标志
		if ("0000".equals(errorCode)) {
			if ("1".equals(pwdmodFlag)) {
				msgcode = "A0001";
			}
		} else {
			msgcode = "A0002";
		}
		mp02_user.setMsgcode(msgcode);
		String organkey = StrUtils.subStr(message, 154, 6);// 机构编号
		mp02_user.setOrgankey(organkey);
		String isAdmin = StrUtils.subStr(message, 160, 2);// 是否为管理员
		if ("01".equals(isAdmin)) {
			mp02_user.setIsadmin("1");
		} else {
			mp02_user.setIsadmin("0");
		}
		String tellerLevel = StrUtils.subStr(message, 162, 1);// 柜员级别
		if ("0".equals(tellerLevel)) {// 总行用户
			mp02_user.setIshead("1");// 总行级别
		} else {
			mp02_user.setIsadmin("0");
		}
		String realName = StrUtils.subStr(message, 163, 60).trim();// 真实姓名
		mp02_user.setRealname(realName);						
		return mp02_user;
	}

	/**
	 * 生成通用报文头
	 * 
	 * @param tradeCode
	 *            交易代码
	 * @return
	 */
	private String getHeadStr(String tradeCode) {
		StringBuffer buf = new StringBuffer();
		buf.append("1");// 1-versionNo 版本号 标识当前数据包的格式版本，目前该版本号为1，默认填“1”
		buf.append("0");// 1-toEncrypt 密押标识 表示数据报文是否压缩格式，目前不使用，默认填“0”
		buf.append("500001");// 6-commCode 通讯代码 请求填“500001" 响应填“510001”
		buf.append("0");// 1-commType 通讯类型
						// 0--同步请求(等待接收方返回业务处理结果)；1--异步请求(接收方不返回结果,由网关返回给请求方通讯回执)
		buf.append("TELE");// 4-receiverId 接收方标识--柜面
		buf.append("AFPS");// 4-senderId 发起方标识--反欺诈
		String time = DtUtils.getNowDate("yyyyMMddHHmmss") + (int) ((Math.random() * 9 + 1) * 10000000);// 日期＋随机数的22位流水号
		buf.append(time);// 22-senderSN 发起方流水
		buf.append(time.substring(0, 8));// 8-senderDate 发起方日期
		buf.append(time.substring(8, 14));// 6-senderTime 发起方时间
		buf.append(tradeCode);// 6-tradeCode 交易代码 柜员签到交易(990001)，
								// 查询柜员信息交易(990002)
		buf.append(StringUtils.rightPad("", 2, " "));// 2-gwErrorCode 网关错误标识
														// 网关用于表示是否处理过程发生错误。发起方填空01
														// ---- 成功 00 ---- 错误
		buf.append(StringUtils.rightPad("", 7, " "));// 7-gwErrorMessage 网关错误代码
														// 用于表示具体错误内容的七位的半角字符串，发起方填空
		buf.append("G");// 1-gwEncoding U:UTF-8 g:GBK G或空:GB18030
		buf.append("N");// 1-resendFlag 重发标志 Y：重发 其他：非重发
		buf.append(StringUtils.rightPad("", 6, " "));// 6-reserved1 保留位 空格填充
		return buf.toString();
	}

	/**
	 * 处理字节长度问题
	 * 
	 * @param str
	 *            源字符串
	 * @param length
	 *            指定长度
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	private static String rightPad(String str, int length) {
		int len = 0;
		try {
			len = str.getBytes("GBK").length;
			if (len >= length) {
				return str;
			}
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage(),e);
		}
		return str + StringUtils.rightPad("", length - len, ' ');
	}

	/**
	 * 获取密码摘要 (统一柜员号+统一柜员密码)使用md5算出摘要值(必须是大写字母)，再用(随机数+摘要值)使用md5算出摘要值。
	 * 
	 * @param verifyRandom
	 *            随机数
	 * @param tellerno
	 *            柜员号
	 * @param tellernoPwd
	 *            密码
	 * @return
	 */
	private String getPsswordByMD5(String verifyRandom, String tellerno, String tellernoPwd) {
		MD5 md = new MD5();
		String password1 = md.toDigest(tellerno + tellernoPwd).toUpperCase();// 首次加密，统一柜员号+统一柜员密码
																				// 算出摘要值
																				// 转换为大写
		String password = md.toDigest(verifyRandom + password1);// 二次加密 随机数＋摘要值
																// 算出最后的摘要值
		return password;
	}

	public static void main(String[] args) {
		SsoService c1 = new SsoService();
//		c1.setHost("21.96.164.120");// ----开发_网关KA环境
		c1.setHost("21.96.164.234");//----开发_网关KB环境
		c1.setProt(8112);// 网关定长端口
		c1.init();

		Mp02_user user = new Mp02_user();
		user.setLoginname("20007145");
//		user.setLoginname("10001004");
		user.setPassword("1");
		String s = c1.trans(user).getMsgcode();

		System.out.println("========服务器响应信息:" + s);

		c1.close();

	}

}
