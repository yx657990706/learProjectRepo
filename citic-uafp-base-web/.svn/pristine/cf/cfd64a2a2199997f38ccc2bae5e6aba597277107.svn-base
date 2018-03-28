package citic.cgb.xmlmsg.service.impl;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.Iterator;
import java.util.Set;

import javax.annotation.Resource;
import javax.sql.DataSource;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPMessage;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import citic.base.BaseDao;
import citic.base.utils.DtUtils;
import citic.cgb.xmlmsg.domain.CommonHead;
import citic.cgb.xmlmsg.service.AFPServiceInterface;
import citic.das.AppSqlExec;

/**
 * AFPN对外接口公共类 <br>
 * 有权机关查控应用从AFP002接口开始，采用soap的xml报文对外提供查询接口,在网关处注册的系统标识位AFPN <br>
 * 所有的接口的表头（header）基本一致，只是个别参数不同；身体（body）部分视具体的接口而定。 <br>
 * 1.该类提供动态生成head的方法 2.提供动态生成整个报文的方法 3.提供解析报文头的方法 <br>
 * 对body的处理需要各子类自己实现
 * 
 * @author yinxiong
 * @date 2016年11月2日 下午3:21:52
 */
public abstract class AFPService implements Serializable, AFPServiceInterface {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2682600861584426489L;
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	/** 数据库类型名称 */
	private String dbName = null;
	/** 业务库dao */
	@Resource
	protected BaseDao busiDao;
	/** 管理库应用执行器 */
	@Autowired
	@Qualifier("mng")
	protected AppSqlExec mngAppExec;
	/** 业务库数据源 */
	@Resource(name = "busiDataSource")
	private DataSource dataSource;
	
	/**
	 * 生成通用报文头（响应）
	 * 
	 * @param senderId   本系统标识
	 * @param receiverId 对端的系统标识
	 * @param tradeCode 交易标识（6位接口代码如AFP002）
	 * @param senderSN 发起方流水
	 * @return
	 * @author yinxiong
	 * @date 2016年11月2日 下午3:38:21
	 */
	protected String getHeadStrRes(String senderId,String receiverId, String tradeCode, String senderSN) {
		StringBuffer buf = new StringBuffer();
		
		buf.append("<?xml version=\"1.0\" encoding=\"GB18030\"?>");
		buf.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:gateway=\"http:// www.agree.com.cn /GDBGateway\">");
		buf.append("<soapenv:Header>");
		buf.append("<gateway:HeadType>");
		buf.append("<gateway:versionNo>1</gateway:versionNo>");// versionNo 版本号 标识当前数据包的格式版本，目前该版本号为1，默认填“1”
		buf.append("<gateway:toEncrypt>0</gateway:toEncrypt>");// 1-toEncrypt 密押标识 表示数据报文是否压缩格式，目前不使用，默认填“0”
		buf.append("<gateway:commCode>510001</gateway:commCode>");// 6-commCode 通讯代码 请求填“500001" 响应填“510001”
		buf.append("<gateway:commType>0</gateway:commType>");// 1-commType 通讯类型 0--同步请求(等待接收方返回业务处理结果)；1--异步请求(接收方不返回结果,由网关返回给请求方通讯回执)
		buf.append("<gateway:receiverId>").append(receiverId).append("</gateway:receiverId>");// 4-receiverId 接收方标识--柜面
		buf.append("<gateway:senderId>").append(senderId).append("</gateway:senderId>");//4-senderId 发起方标识--反欺诈（xml模式：AFPN；定长模式：AFPS）
		String time = DtUtils.getNowDate("yyyyMMddHHmmss");
		buf.append("<gateway:senderSN>").append(senderSN).append("</gateway:senderSN>");// 22-senderSN 发起方流水
		buf.append("<gateway:senderDate>").append(time.substring(0, 8)).append("</gateway:senderDate>");// 8-senderDate 发起方日期
		buf.append("<gateway:senderTime>").append(time.substring(8)).append("</gateway:senderTime>");// 6-senderTime 发起方时间
		buf.append("<gateway:tradeCode>").append(tradeCode).append("</gateway:tradeCode>");// 6-tradeCode 交易代码 柜员签到交易(990001)， 查询柜员信息交易(990002)
		buf.append("<gateway:gwErrorCode>01</gateway:gwErrorCode>");//2-gwErrorCode 网关错误标识 网关用于表示是否处理过程发生错误。发起方填空01:成功 00 :错误
		buf.append("<gateway:gwErrorMessage></gateway:gwErrorMessage>");// 7-gwErrorMessage 网关错误代码 用于表示具体错误内容的七位的半角字符串，发起方填空
		buf.append("<gateway:gwEncoding>G</gateway:gwEncoding>");//1-gwEncoding U:UTF-8 g:GBK G或空:GB18030
		buf.append("<gateway:resendFlag>N</gateway:resendFlag>");// 1-resendFlag 重发标志 Y：重发 其他：非重发
		buf.append("<gateway:reserved1></gateway:reserved1>");// 6-reserved1 保留位 空格填充
		buf.append("</gateway:HeadType>");
		buf.append("</soapenv:Header>");
		
		return buf.toString();
	}
	
	/**
	 * 生成通用报文头（请求）
	 * 
	 * @param receiverId
	 * @param tradeCode
	 * @param senderSN
	 * @param encoding  服务方的编码格式
	 * @return
	 * @author yinxiong
	 * @date 2017年4月20日 下午7:24:08
	 */
	protected String getHeadStrReq(String senderId,String receiverId, String tradeCode,String encoding) {
		StringBuffer buf = new StringBuffer();
		
		buf.append("<?xml version=\"1.0\" encoding=\"").append(encoding).append("\"?>");
		buf.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:gateway=\"http:// www.agree.com.cn /GDBGateway\">");
		buf.append("<soapenv:Header>");
		buf.append("<gateway:HeadType>");
		buf.append("<gateway:versionNo>1</gateway:versionNo>");// versionNo 版本号 标识当前数据包的格式版本，目前该版本号为1，默认填“1”
		buf.append("<gateway:toEncrypt>0</gateway:toEncrypt>");// 1-toEncrypt 密押标识 表示数据报文是否压缩格式，目前不使用，默认填“0”
		buf.append("<gateway:commCode>500001</gateway:commCode>");// 6-commCode 通讯代码 请求填“500001" 响应填“510001”
		buf.append("<gateway:commType>0</gateway:commType>");// 1-commType 通讯类型 0--同步请求(等待接收方返回业务处理结果)；1--异步请求(接收方不返回结果,由网关返回给请求方通讯回执)
		buf.append("<gateway:receiverId>").append(receiverId).append("</gateway:receiverId>");// 4-receiverId 接收方标识--柜面
		buf.append("<gateway:senderId>").append(senderId).append("</gateway:senderId>");//4-senderId 发起方标识--反欺诈（xml模式：AFPN；定长模式：AFPS）
		String time = DtUtils.getNowDate("yyyyMMddHHmmss") + (int) ((Math.random() * 9 + 1) * 10000000);//日期＋随机数的22位流水号
		buf.append("<gateway:senderSN>").append(time).append("</gateway:senderSN>");// 22-senderSN 发起方流水
		buf.append("<gateway:senderDate>").append(time.substring(0, 8)).append("</gateway:senderDate>");// 8-senderDate 发起方日期
		buf.append("<gateway:senderTime>").append(time.substring(8, 14)).append("</gateway:senderTime>");// 6-senderTime 发起方时间
		buf.append("<gateway:tradeCode>").append(tradeCode).append("</gateway:tradeCode>");// 6-tradeCode 交易代码
		buf.append("<gateway:gwErrorCode>01</gateway:gwErrorCode>");//2-gwErrorCode 网关错误标识 网关用于表示是否处理过程发生错误。发起方填空01:成功  00:错误
		buf.append("<gateway:gwErrorMessage></gateway:gwErrorMessage>");// 7-gwErrorMessage 网关错误代码 用于表示具体错误内容的七位的半角字符串，发起方填空
		buf.append("<gateway:gwEncoding>G</gateway:gwEncoding>");//1-gwEncoding U:UTF-8 g:GBK G或空:GB18030
		buf.append("<gateway:resendFlag>N</gateway:resendFlag>");// 1-resendFlag 重发标志 Y：重发 其他：非重发
		buf.append("<gateway:reserved1></gateway:reserved1>");// 6-reserved1 保留位 空格填充
		buf.append("</gateway:HeadType>");
		buf.append("</soapenv:Header>");
		
		return buf.toString();
	}
	
	/**
	 * 生成整个报文（响应）
	 * 
	 * @param receiverId 对端的系统标识
	 * @param transcode 交易标识（6位接口代码如AFP002）
	 * @param body 报文的body部分
	 * @return
	 * @author yinxiong
	 * @date 2016年11月2日 下午3:45:54
	 */
	protected String getResponseMsgRes(String senderId,String receiverId, String transcode, String sendsn, String body) {
		StringBuffer re_msg = new StringBuffer();
		re_msg.append(this.getHeadStrRes(senderId,receiverId, transcode, sendsn));//报文头部
		re_msg.append(body);// <soapenv:Body>...</soapenv:Body>这部分
		re_msg.append("</soapenv:Envelope>");//闭合标签
		return re_msg.toString();
	}
	
	/**
	 * 生成整个报文（请求）
	 * 
	 * @param receiverId
	 * @param transcode
	 * @param body
	 * @return
	 * @author yinxiong
	 * @date 2017年4月20日 下午7:30:58
	 */
	protected String getResponseMsgReq(String senderId,String receiverId, String transcode, String body,String encoding) {
		StringBuffer re_msg = new StringBuffer();
		re_msg.append(this.getHeadStrReq(senderId,receiverId, transcode,encoding));//报文头部
		re_msg.append(body);// <soapenv:Body>...</soapenv:Body>这部分
		re_msg.append("</soapenv:Envelope>");//闭合标签
		return re_msg.toString();
	}
	
	/**
	 * soap的xml的报文头解析 <br>
	 * 目前只是解析了访问系统的系统标志，后续若有需要其他字段，可在此基础上扩展
	 * 
	 * @param iterator
	 * @param resultBean
	 * @author yinxiong
	 * @date 2016年11月2日 下午3:52:43
	 */
	@SuppressWarnings("unchecked")
	protected void parseHeader(Iterator<SOAPElement> iterator, CommonHead resultBean) {
		while (iterator.hasNext()) {
			SOAPElement element = iterator.next();
			if ("gateway:HeadType".equals(element.getNodeName())) {
				Iterator<SOAPElement> it = element.getChildElements();
				SOAPElement el = null;
				while (it.hasNext()) {
					el = it.next();
					String val = el.getValue();
					if ("gateway:senderId".equals(el.getTagName())) {
						resultBean.setSenderId(val == null ? "" : val.trim());//访问系统的系统标志（如零售系统的PRCS）
					}
					if ("gateway:senderSN".equals(el.getTagName())) {
						resultBean.setSenderSN(val == null ? "" : val.trim());//发起方流水
					}
				}
			} else if (null == element.getValue() && element.getChildElements().hasNext()) {
				parseHeader(element.getChildElements(), resultBean);
			}
		}
	}
	
	/**
	 * 将xmlstring转为SOAPMessage
	 * 
	 * @param soapString
	 * @return
	 * @author yinxiong
	 * @date 2016年11月2日 下午4:07:25
	 */
	protected SOAPMessage formatSoapString(String soapString) {
		MessageFactory msgFactory;
		try {
			msgFactory = MessageFactory.newInstance();
			SOAPMessage reqMsg = msgFactory.createMessage(new MimeHeaders(), new ByteArrayInputStream(soapString.getBytes()));
			reqMsg.saveChanges();
			return reqMsg;
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return null;
		}
	}
	
	/**
	 * 生成body的属性
	 * 
	 * @param property
	 * @param value
	 * @return
	 */
	protected String getGatewayTag(String property, String value) {
		StringBuffer bf = new StringBuffer();
		bf.append("<gateway:field name=\"").append(property).append("\">").append(value).append("</gateway:field>");
		return bf.toString();
	}
	
	public String getSequenceValus(String seqname) throws Exception {
		String seqNextV = "";
		String sql = "";
		Connection conn = null;
		try {
			if (StringUtils.isEmpty(this.dbName)) {
				conn = dataSource.getConnection();
				this.dbName = conn.getMetaData().getDatabaseProductName();
			}
			if (StringUtils.indexOfIgnoreCase(dbName, "oracle") >= 0) {
				sql = "select " + seqname.toUpperCase() + ".Nextval  from dual";
			} else if (StringUtils.indexOfIgnoreCase(dbName, "db2") >= 0) {
				sql = " select NEXTVAL FOR " + seqname.toUpperCase() + " from sysibm.sysdummy1 ";
			} else {
				throw new Exception("不支持此数据库！");
			}
			seqNextV = mngAppExec.queryOneString(sql);
			if (StringUtils.isEmpty(seqNextV)) {
				throw new Exception("获取主键失败！");
			}
		} catch (Exception e) {
			throw e;
		} finally {
			DbUtils.closeQuietly(conn);
		}
		
		return seqNextV;
	}
	
	/**
	 * soapXML中的body的解析
	 * 
	 * @param iterator
	 * @param resultBean
	 * @author yinxiong
	 * @date 2016年11月2日 下午2:16:52
	 */
	@SuppressWarnings("unchecked")
	protected void parseBody(Iterator<SOAPElement> iterator, Object obj,Set<String> set) throws Exception {
		while (iterator.hasNext()) {
			SOAPElement element = iterator.next();
			if ("gateway:NoAS400".equals(element.getNodeName())) {
				Iterator<SOAPElement> it = element.getChildElements();
				SOAPElement el = null;
				while (it.hasNext()) {
					el = it.next();
					String attrname = el.getAttribute("name").toLowerCase();//标签的属性值 （转换为小写，增强兼容性）
					String val = el.getValue() == null ? "" : el.getValue().trim();//标签的值		
					//利用java反射机制赋值
					if (set.contains(attrname)) {
						Field field = obj.getClass().getDeclaredField(attrname);
						field.setAccessible(true);//解除访问限制
						field.set(obj, val);
					}
				}
			} else if (null == element.getValue() && element.getChildElements().hasNext()) {
				parseBody(element.getChildElements(), obj,set);
			}
		}
	}
	/**
	 * xml处理入口 <br>
	 * 将从网关接收的xml解析并进行处理，最后返回响应报文 <br>
	 * 子类根据需要实现自己的方法
	 * 
	 * @param Msg
	 * @return
	 * @author yinxiong
	 * @date 2016年11月2日 下午4:26:55
	 */
	public abstract String messageReceived(String xml);
	
}
