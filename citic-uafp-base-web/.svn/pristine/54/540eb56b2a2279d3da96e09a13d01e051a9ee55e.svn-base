package citic.cgb.face.service;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPMessage;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import citic.cgb.face.domain.Cgb_face_data;
import citic.cgb.face.domain.Cgb_face_data_AFP;
import citic.cgb.tools.HttpUtils;
import citic.cgb.xmlmsg.service.impl.AFPService;

/**
 * 连接人脸识别系统
 * 
 * @author yinxiong
 * @date 2017年4月19日 下午2:07:29
 */

public class Cgb_face_dataHmdSendService extends AFPService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5145177991576152911L;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Setter
	@Getter
	private String wg_url = "http://10.2.104.167:8133";//网关URL "http://21.96.164.234:8113
	@Setter
	@Getter
	private String url = "http://21.2.202.25:9080/api/service";//对端URL
	@Setter
	@Getter
	private String receiverId = "RLSB";//服务端系统标识:人脸识别系统
	@Setter
	@Getter
	private String senderId = "AFPM";//客户端系统标识
	@Setter
	@Getter
	private String encoding = "GBK";//服务端编码格式
	
	private Set<String> set = null;//请求字段set
	
	/**
	 * 构造需要解析的字段set
	 * <br>若接口变更，此处需要变更
	 */
	public Cgb_face_dataHmdSendService() {
		set = new HashSet<String>();
		set.add("suspect_img_id");//嫌疑人图像ID
		set.add("victim_img_id");//受害人图像ID
		set.add("suspect_img");//嫌疑人图像base64
		set.add("victim_img");//受害人图像base64
		set.add("similarity_id_1");//相似图像ID_1
		set.add("similarity_img_1");//相似图像_1_base64
		set.add("similarity_lwhc_img_1");//相似图片_1的联网核查照
		set.add("similarity_id_2");//相似图像ID_2
		set.add("similarity_img_2");//相似图像_2_base64
		set.add("similarity_lwhc_img_2");//相似图片_1的联网核查照
		set.add("similarity_id_3");//相似图像ID_3	
		set.add("similarity_img_3");//相似图像_3_base64
		set.add("similarity_lwhc_img_3");//相似图片_1的联网核查照
		set.add("similarity_id_4");//相似图像ID_4
		set.add("similarity_img_4");//相似图像_4_base64
		set.add("similarity_lwhc_img_4");//相似图片_1的联网核查照
		set.add("similarity_id_5");//相似图像ID_5
		set.add("similarity_img_5");//相似图像_5_base64
		set.add("similarity_lwhc_img_5");//相似图片_1的联网核查照
		set.add("result");//处理结果
		set.add("message");//结果描述
	}

	
	/**
	 * HMD002--手工新增数据推送给人脸识别系统
	 * <br>直连的方式,根据业务办理渠道选择五位码
	 * vtm(003)：02003 柜面(004)：02004  有权机关(016)：03001 
	 * @param request
	 * @return
	 * @throws Exception
	 * 
	 * @author yinxiong
	 * @date 2017年4月19日 下午7:11:27
	 */
	public Cgb_face_data_AFP sendHMD002ReqMsg(Cgb_face_data request){
		//根据响应做处理 解析并判断
		Cgb_face_data_AFP dto = null;
		try {
			//处理业务办理类型问题,若无，默认为柜面
			if("003".equals(request.getBusi_way())){
				request.setOperatetype("02003");//固定值
			}else{
				request.setBusi_way("004");
				request.setOperatetype("02004");
			}
//			else{//人脸识别给有权机关分配的号码
//				request.setBusi_way("016");
//				request.setOperatetype("03001");
//			}
			//生成报文 生成头部，生成body，封装
			String tradeCode = "HMD002";//6位交易代码 例如：AFP004
			String body = getBodyStrByHMD002(request);
			//组装请求报文
			String msg = this.getResponseMsgReq(senderId,receiverId, tradeCode, body,encoding);
			logger.info("请求报文：" + msg);
			//调用http发送方法
			String responseXml = HttpUtils.sendXmlStrByEncoding(msg, url,encoding);
			logger.info("响应报文：" + responseXml);
			dto = getRequestMsg(responseXml);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		if(dto==null){
			dto = new Cgb_face_data_AFP();
		}
		return dto;
	}
	
	/**
	 * HMD003--柜面/VTM上送数据推送给人脸识别系统
	 * <br>走网关的方式
	 * @param request
	 * @return
	 * 
	 * @author yinxiong
	 * @throws Exception 
	 * @date 2017年4月20日 下午9:31:09
	 */
	public Cgb_face_data_AFP sendHMD003ReqMsg(Cgb_face_data request){
		//根据响应做处理 解析并判断
		Cgb_face_data_AFP dto = null;
		try {
			//处理业务办理类型问题,若无，默认为柜面
			if("003".equals(request.getBusi_way())){
				request.setOperatetype("02003");//固定值
			}else{
				request.setBusi_way("004");
				request.setOperatetype("02004");
			}
			//生成报文 生成头部，生成body，封装
			String tradeCode = "HMD003";//6位交易代码 例如：AFP004
			String body = getBodyStrByHMD003(request);
			//组装请求报文--网关编码为GB18030
			String msg = this.getResponseMsgReq(senderId,receiverId, tradeCode, body,encoding);
			logger.info("请求报文：" + msg);
			//调用httpclient发送
			String responseXml = HttpUtils.sendXmlStrByEncoding(msg, wg_url,encoding);
			logger.info("响应报文：" + responseXml);
			dto = getRequestMsg(responseXml);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		if(dto==null){
			dto = new Cgb_face_data_AFP();
		}
		return dto;
	}

	/**
	 * HMD004--照片获取
	 * <br>直连的方式
	 * <br>一次最多能取7张图片，id选填
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 * 
	 * @author yinxiong
	 * @date 2017年4月19日 下午7:12:40
	 */
	public Cgb_face_data_AFP sendHMD004ReqMsg(Cgb_face_data request) throws Exception {
		//根据响应做处理 解析并判断
		Cgb_face_data_AFP dto = null;
		try {
			//生成报文 生成头部，生成body，封装
			String tradeCode = "HMD004";//6位交易代码 例如：AFP004
			String body = getBodyStrByHMD004(request);
			//组装请求报文
			String msg = this.getResponseMsgReq(senderId,receiverId, tradeCode, body,encoding);
			logger.info("请求报文：" + msg);
			//调用http发送方法
			String responseXml = HttpUtils.sendXmlStrByEncoding(msg, url,encoding);
			logger.info("响应报文：" + responseXml);
			dto = getRequestMsg(responseXml);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		if(dto==null){
			dto = new Cgb_face_data_AFP();
		}
		return dto;
	}
	
	public Cgb_face_data_AFP sendHMD006ReqMsg(Cgb_face_data request) throws Exception {
		//根据响应做处理 解析并判断
		Cgb_face_data_AFP dto = null;
		try {
			//生成报文 生成头部，生成body，封装
			String tradeCode = "HMD006";//6位交易代码 例如：AFP006
			String body = getBodyStrByHMD006(request);
			//组装请求报文
			String msg = this.getResponseMsgReq(senderId,receiverId, tradeCode, body,encoding);
			logger.info("请求报文：" + msg);
			//调用http发送方法
			String responseXml = HttpUtils.sendXmlStrByEncoding(msg, url,encoding);
			logger.info("响应报文：" + responseXml);
			dto = getRequestMsg(responseXml);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		if(dto==null){
			dto = new Cgb_face_data_AFP();
		}
		return dto;
	}
	
	@Override
	public String messageReceived(String Msg) {
		return null;
	}
	
	/**
	 * 生成HMD002报文body
	 * 
	 * @param response
	 * @return
	 * @author yinxiong
	 * @date 2017年4月19日 下午2:47:10
	 */
	private String getBodyStrByHMD002(Cgb_face_data response) {
		//生成body
		StringBuffer buff = new StringBuffer();
		buff.append("<soapenv:Body>");
		buff.append("<gateway:NoAS400>");
		buff.append(getGatewayTag("group_id", response.getGroup_id()));//嫌疑人图像ID
		buff.append(getGatewayTag("suspect_img_base64", response.getImg_base64()));//受害人图像base64编码
		buff.append(getGatewayTag("fullname", StringEscapeUtils.escapeXml(response.getVictim_name())));//受害人姓名
		buff.append(getGatewayTag("identifytype", response.getVictim_card_type()));//受害人证件类型
		buff.append(getGatewayTag("identifycard", response.getVictim_card_num()));//受害人证件号码
		buff.append(getGatewayTag("effectime", response.getVictim_card_validity()));//受害人证件有效期
		buff.append(getGatewayTag("risk_type", response.getRisk_type()));//风险类型
		buff.append(getGatewayTag("busi_website", response.getBusi_website()));//业务办理网点
		buff.append(getGatewayTag("busi_teller_num", response.getBusi_teller_num()));//业务办理柜员号
		buff.append(getGatewayTag("busi_time", response.getBusi_time()));//业务办理时间
		buff.append(getGatewayTag("busi_type", response.getBusi_type()));//业务办理类型(6位或者4位)
		buff.append(getGatewayTag("operatetype", response.getOperatetype()));//业务办理类型(5位固定值，人脸识别用)
		buff.append(getGatewayTag("channel", response.getBusi_way()));//业务办理渠道
		buff.append(getGatewayTag("mobile", response.getTelephone()));//联系电话
		buff.append(getGatewayTag("address", StringEscapeUtils.escapeXml(response.getAddress())));//联系地址
		buff.append(getGatewayTag("assist_card_type", response.getAssist_card_type()));//辅助证件类型
		buff.append(getGatewayTag("assist_card_num", response.getAssist_card_num()));//辅助证件号码
		buff.append(getGatewayTag("assist_img_id", response.getAssist_card_num()));//辅助证件图像ID
		buff.append("</gateway:NoAS400>");
		buff.append("</soapenv:Body>");
		
		return buff.toString();
	}
	/**
	 * 生成HMD003报文body
	 * 
	 * @param response
	 * @return
	 * @author yinxiong
	 * @date 2017年4月19日 下午2:47:10
	 */
	private String getBodyStrByHMD003(Cgb_face_data request) {
		//生成body
		StringBuffer buff = new StringBuffer();
		buff.append("<soapenv:Body>");
		buff.append("<gateway:NoAS400>");
		buff.append(getGatewayTag("group_id", request.getGroup_id()));//嫌疑人图像ID
		buff.append(getGatewayTag("suspect_img_id", request.getSuspect_img_id()));//suspect_img_id
		buff.append(getGatewayTag("fullname", StringEscapeUtils.escapeXml(request.getVictim_name())));//受害人姓名
		buff.append(getGatewayTag("identifytype", request.getVictim_card_type()));//受害人证件类型
		buff.append(getGatewayTag("identifycard", request.getVictim_card_num()));//受害人证件号码
		buff.append(getGatewayTag("effectime", request.getVictim_card_validity()));//受害人证件有效期
		buff.append(getGatewayTag("risk_type", request.getRisk_type()));//风险类型
		buff.append(getGatewayTag("busi_website", request.getBusi_website()));//业务办理网点
		buff.append(getGatewayTag("busi_teller_num", request.getBusi_teller_num()));//业务办理柜员号
		buff.append(getGatewayTag("busi_time", request.getBusi_time()));//业务办理时间
		buff.append(getGatewayTag("busi_type", request.getBusi_type()));//业务办理类型(6位或者4位)
		buff.append(getGatewayTag("operatetype", request.getOperatetype()));//业务办理类型(5位固定值，人脸识别用)
		buff.append(getGatewayTag("channel", request.getBusi_way()));//业务办理渠道
		buff.append(getGatewayTag("mobile", request.getTelephone()));//联系电话
		buff.append(getGatewayTag("address", StringEscapeUtils.escapeXml(request.getAddress())));//联系地址
		buff.append(getGatewayTag("assist_card_type", request.getAssist_card_type()));//辅助证件类型
		buff.append(getGatewayTag("assist_card_num", request.getAssist_card_num()));//辅助证件号码
		buff.append(getGatewayTag("assist_img_id", request.getAssist_card_num()));//辅助证件图像ID
		buff.append(getGatewayTag("similarity_id_1", request.getSimilarity_id_1()));//相似图像ID_1
		buff.append(getGatewayTag("similarity_id_2", request.getSimilarity_id_2()));//相似图像ID_2
		buff.append(getGatewayTag("similarity_id_3", request.getSimilarity_id_3()));//相似图像ID_3
		buff.append(getGatewayTag("similarity_id_4", request.getSimilarity_id_4()));//相似图像ID_4
		buff.append(getGatewayTag("similarity_id_5", request.getSimilarity_id_5()));//相似图像ID_5
		buff.append("</gateway:NoAS400>");
		buff.append("</soapenv:Body>");
		
		return buff.toString();
	}
	/**
	 * 生成HMD004报文body
	 * @param response
	 * @return
	 * 
	 * @author yinxiong
	 * @date 2017年4月19日 下午6:47:39
	 */
	private String getBodyStrByHMD004(Cgb_face_data response) {
		//生成body
		StringBuffer buff = new StringBuffer();
		buff.append("<soapenv:Body>");
		buff.append("<gateway:NoAS400>");
		buff.append(getGatewayTag("suspect_img_id", response.getSuspect_img_id()));//嫌疑人图像ID
		buff.append(getGatewayTag("victim_img_id", response.getVictim_img_id()));//受害人图像ID
		buff.append(getGatewayTag("similarity_id_1", response.getSimilarity_id_1()));//相似图像ID_1
		buff.append(getGatewayTag("similarity_id_2", response.getSimilarity_id_2()));//相似图像ID_2
		buff.append(getGatewayTag("similarity_id_3", response.getSimilarity_id_3()));//相似图像ID_3
		buff.append(getGatewayTag("similarity_id_4", response.getSimilarity_id_4()));//相似图像ID_4
		buff.append(getGatewayTag("similarity_id_5", response.getSimilarity_id_5()));//相似图像ID_5
		buff.append("</gateway:NoAS400>");
		buff.append("</soapenv:Body>");
		
		return buff.toString();
	}
	
	/**
	 * 生成HMD006报文body
	 * @param response
	 * @return
	 * 
	 * @author yinxiong
	 * @date 2017年6月28日 下午2:59:02
	 */
	private String getBodyStrByHMD006(Cgb_face_data response) {
		//生成body
		StringBuffer buff = new StringBuffer();
		buff.append("<soapenv:Body>");
		buff.append("<gateway:NoAS400>");
		buff.append(getGatewayTag("suspect_img_id", response.getSuspect_img_id()));//嫌疑人图像ID
		buff.append(getGatewayTag("similarity_id_1", response.getSimilarity_id_1()));//相似图像ID_1
		buff.append(getGatewayTag("similarity_id_2", response.getSimilarity_id_2()));//相似图像ID_2
		buff.append(getGatewayTag("similarity_id_3", response.getSimilarity_id_3()));//相似图像ID_3
		buff.append(getGatewayTag("similarity_id_4", response.getSimilarity_id_4()));//相似图像ID_4
		buff.append(getGatewayTag("similarity_id_5", response.getSimilarity_id_5()));//相似图像ID_5
		buff.append("</gateway:NoAS400>");
		buff.append("</soapenv:Body>");
		
		return buff.toString();
	}
	@SuppressWarnings("unchecked")
	private Cgb_face_data_AFP getRequestMsg(String soapXML) {
		Cgb_face_data_AFP response = new Cgb_face_data_AFP();
		try {
			SOAPMessage msg = this.formatSoapString(soapXML);
			//          直连，暂不解析头部信息			
			//			//解析header的数据
			//			SOAPHeader header = msg.getSOAPHeader();
			//			Iterator<SOAPElement> it_header = header.getChildElements();
			//			parseHeader(it_header, request);
			//解析body的数据
			SOAPBody body = msg.getSOAPBody();
			Iterator<SOAPElement> it_body = body.getChildElements();
			parseBody(it_body, response);
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return response;
	}
	
	@SuppressWarnings("unchecked")
	private void parseBody(Iterator<SOAPElement> iterator, Cgb_face_data_AFP resultBean) throws Exception {
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
						Field field = resultBean.getClass().getDeclaredField(attrname);
						field.setAccessible(true);//解除访问限制
						field.set(resultBean, val);
					}
				}
			} else if (null == element.getValue() && element.getChildElements().hasNext()) {
				parseBody(element.getChildElements(), resultBean);
			}
		}
	}
	
	
}
