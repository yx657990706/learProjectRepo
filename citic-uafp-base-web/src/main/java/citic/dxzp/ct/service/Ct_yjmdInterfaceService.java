package citic.dxzp.ct.service;

import java.util.Iterator;

import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import citic.base.utils.DtUtils;
import citic.cgb.xmlmsg.service.impl.AFPService;
import citic.dxzp.ct.domain.Ct_request_log;
import citic.dxzp.ct.domain.Ct_yjmd_request;
import citic.dxzp.ct.domain.Ct_yjmd_response;

@Service
public class Ct_yjmdInterfaceService extends AFPService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7404289570149931439L;
	
	private final Logger logger = LoggerFactory.getLogger(Ct_yjmdInterfaceService.class);
	
	@Autowired
	private Ct_yjmdService ct_yjmdService;
	private final String senderId = "AFPN";//系统标识，此处必须为AFPN
	/** 客户类型 01：个人客户 02：企业客户 */
	private final String PERSON = "01";
	private final String UNIT = "02";
	//交易代码【6位接口编号】
	private final String TRANS_OCDE = "AFP002";
	
	/**
	 * 消息接收入口 <br>
	 * 1.反欺诈系统解析报文［非标准的soap形式的xml］ <br>
	 * 2.反欺诈解析出报文中查询条件，根据条件分别查询个人或单位银监黑名单 <br>
	 * 3.组装响应报文，返回数据报文给调用系统
	 */
	@Override
	public String messageReceived(String msg) {
		String re_msg = "";
		try {
			//解析xml，获取查询对象
			Ct_yjmd_request request = this.getUnkMsg(msg);
			if (!StringUtils.isBlank(request.getCode())) {
				Ct_yjmd_response response = new Ct_yjmd_response();
				//获取异常报文的body
				String err_body = getERRBodyStr(request, response);
				//组装异常报文
				re_msg = getResponseMsgRes(senderId,request.getSenderId(),TRANS_OCDE,request.getSenderSN(),err_body);
			} else {
				//查询数据
				Ct_yjmd_response response = this.getDtoFromDB(request);
				String cust_type = response.getCustomertype();
				if (!StringUtils.isBlank(cust_type)) {//存在记录
					response.setErrorcode("0000");//“0000“表示请求处理成功
					response.setErrormsg("");
					response.setIsexists("1");//0:不存在 1：存在
				} else {
					response.setErrorcode("0000");
					response.setErrormsg("");
					response.setIsexists("0");
				}
				//生成报文body
				String body = this.getBodyStr(response);
				//组装响应报文
				re_msg = this.getResponseMsgRes(senderId,request.getSenderId(),TRANS_OCDE,request.getSenderSN(),body);
				
			}
		} catch (Exception e) {
			logger.error("报文解析异常：" + e.getMessage(),e);
		}
		
		return re_msg;
	}
	
	/**
	 * 解析报文并处理
	 * 
	 * @param msg
	 * @return
	 * @throws Exception
	 * @author yinxiong
	 * @date 2016年10月18日 下午2:30:46
	 */
	private Ct_yjmd_request getUnkMsg(String msg) throws Exception {
		Ct_yjmd_request request = new Ct_yjmd_request();
		Ct_request_log log = null;
		try {
			//解析xml，获取查询信息
			request = this.getRequestMsg(msg);
			//获取访问系统的系统标识
			String sys_code = request.getSenderId();
			//查询条件
			String customertype = request.getCustomertype(); 
			String customername = request.getCustomername();
			String certtype = request.getCerttype();
			String certid = request.getCertid();
			//记录接口访问日志
			log = new Ct_request_log();
			StringBuffer buff = new StringBuffer();
			log.setSys_code(sys_code);//请求来源系统
			log.setTrans_code(TRANS_OCDE);//交易代码
			log.setQuery_time(DtUtils.getNowTime());//查询时间
			
			if (PERSON.equals(customertype)) {//个人客户
				if (StringUtils.isBlank(certtype)) {
					request.setCode(customertype + "01");//0101：个人客户证件类型缺失
					request.setCode_msg("个人客户证件类型缺失");
				} else if (StringUtils.isBlank(certid)) {
					request.setCode(customertype + "02");//0102：个人客户证件号码缺失
					request.setCode_msg("个人客户证件号码缺失");
				} else if (StringUtils.isBlank(customername)) {
					request.setCode(customertype + "02");//0102：个人客户名称缺失
					request.setCode_msg("个人客户名称缺失");
				}
				buff.append("customertype").append(":").append(PERSON).append(",");
				buff.append("certtype").append(":").append(certtype).append(",");
				buff.append("certid").append(":").append(certid).append(",");
				buff.append("customername").append(":").append(customername);
				log.setQuery_condition(buff.toString());
				log.setRemark(request.getCode() + request.getCode_msg());
			} else if (UNIT.equals(customertype)) {//单位客户
				if (StringUtils.isBlank(customername)) {
					request.setCode(customertype + "03");//0103：企业客户名称缺失
					request.setCode_msg("企业客户名称缺失");
				}
				buff.append("customertype").append(":").append(UNIT).append(",");
				buff.append("customername").append(":").append(customername);
				log.setQuery_condition(buff.toString());
				log.setRemark(request.getCode() + request.getCode_msg());
			} else {
				request.setCode("0001");//0001：客户类型不正确
				request.setCode_msg("客户类型不正确");
				buff.append("customertype").append(":").append(customertype);
				log.setQuery_condition(buff.toString());
				log.setRemark(request.getCode() + request.getCode_msg());
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			throw new Exception("报文截取转换过程发生异常，请检查报文数据");
		}
		
		//日志入库
		ct_yjmdService.insertCt_request_log(log);
		
		return request;
	}
	
	/**
	 * 查询数据库
	 * 
	 * @param request
	 * @return
	 */
	private Ct_yjmd_response getDtoFromDB(Ct_yjmd_request request) {
		Ct_yjmd_response response = null;
		if (PERSON.equals(request.getCustomertype())) {//个人客户
			response = ct_yjmdService.getCt_yjmd_responseByPerson(request);
		} else {//企业客户
			response = ct_yjmdService.getCt_yjmd_responseByUnit(request);
		}
		return response;
	}
	

	/**
	 * 生成正常报文体body
	 * 
	 * @param response
	 * @return
	 */
	private String getBodyStr(Ct_yjmd_response response) {
		//生成body
		StringBuffer buff = new StringBuffer();
		buff.append("<soapenv:Body>");
		buff.append("<gateway:NoAS400>");
		buff.append(getGatewayTag("errorcode", response.getErrorcode()));//错误代码
		buff.append(getGatewayTag("errormsg", response.getErrormsg()));//证件种类
		buff.append(getGatewayTag("isexists", response.getIsexists()));//证件号码
		buff.append(getGatewayTag("customertype", response.getCustomertype()));//编号
		buff.append(getGatewayTag("customername", response.getCustomername()));//地址
		buff.append(getGatewayTag("certtype", response.getCerttype()));//证件种类
		buff.append(getGatewayTag("certid", response.getCertid()));//证件号码
		buff.append(getGatewayTag("recordid", response.getRecordid()));//编号
		buff.append(getGatewayTag("address", response.getAddress()));//地址
		buff.append(getGatewayTag("duetype", response.getDuetype()));//违约类型
		buff.append(getGatewayTag("duedays", response.getDuedays()));//违约天数
		buff.append(getGatewayTag("occurtime", response.getOccurtime()));//数据时点
		buff.append(getGatewayTag("valid_date", response.getValid_date()));//数据有效期
		buff.append("</gateway:NoAS400>");
		buff.append("</soapenv:Body>");
		
		return buff.toString();
	}
	
	/**
	 * 异常响应报文body
	 * 
	 * @param request
	 * @return
	 */
	  private String getERRBodyStr(Ct_yjmd_request request, Ct_yjmd_response response) {
		
		//生成body
		StringBuffer buff = new StringBuffer();
		buff.append("<soapenv:Body>");
		buff.append("<gateway:NoAS400>");
		buff.append(getGatewayTag("errorcode", request.getCode()));//错误代码
		buff.append(getGatewayTag("errormsg", request.getCode_msg()));//错误消息
		buff.append(getGatewayTag("isexists", response.getIsexists()));//是否存在于名单
		buff.append(getGatewayTag("customertype", response.getCustomertype()));//编号
		buff.append(getGatewayTag("customername", response.getCustomername()));//地址
		buff.append(getGatewayTag("certtype", response.getCerttype()));//证件种类
		buff.append(getGatewayTag("certid", response.getCertid()));//证件号码
		buff.append(getGatewayTag("recordid", response.getRecordid()));//编号
		buff.append(getGatewayTag("address", response.getAddress()));//地址
		buff.append(getGatewayTag("duetype", response.getDuetype()));//违约类型
		buff.append(getGatewayTag("duedays", response.getDuedays()));//违约天数
		buff.append(getGatewayTag("occurtime", response.getOccurtime()));//数据时点
		buff.append(getGatewayTag("valid_date", response.getValid_date()));//数据有效期
		buff.append("</gateway:NoAS400>");
		buff.append("</soapenv:Body>");
		
		return buff.toString();
	}
	  		
	/**
	 * 解析soapXML <br>
	 * soapXML字符串中不能出现中文，中文应该是StringEscapeUtils.escapeHtml转换过的
	 * 
	 * @param soapXML
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Ct_yjmd_request getRequestMsg(String soapXML) {
		Ct_yjmd_request request = new Ct_yjmd_request();
		try {
			SOAPMessage msg = this.formatSoapString(soapXML);
			//解析header的数据
			SOAPHeader header = msg.getSOAPHeader();
			Iterator<SOAPElement> it_header = header.getChildElements();
			parseHeader(it_header, request);
			//解析body的数据
			SOAPBody body = msg.getSOAPBody();
			Iterator<SOAPElement> it_body = body.getChildElements();
			parseBody(it_body, request);
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		return request;
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
	private void parseBody(Iterator<SOAPElement> iterator, Ct_yjmd_request resultBean) {
		while (iterator.hasNext()) {
			SOAPElement element = iterator.next();
			if ("gateway:NoAS400".equals(element.getNodeName())) {
				Iterator<SOAPElement> it = element.getChildElements();
				SOAPElement el = null;
				while (it.hasNext()) {
					el = it.next();
					String attrname = el.getAttribute("name");//标签的属性值
					String val = el.getValue();
					if ("customertype".equals(attrname)) {//客户类型
						resultBean.setCustomertype(val==null?"":val.trim());
					} else if ("customername".equals(attrname)) {//客户名称
						resultBean.setCustomername(val==null?"":val.trim());
					} else if ("certtype".equals(attrname)) {//证件类型
						resultBean.setCerttype(val==null?"":val.trim());
					} else if ("certid".equals(attrname)) {//证件号码
						resultBean.setCertid(val==null?"":val.trim());
					}
				}
			} else if (null == element.getValue() && element.getChildElements().hasNext()) {
				parseBody(element.getChildElements(), resultBean);
			}
		}
	}

	
}
