/*
 * =============================================
 * Copyright (c) 2014-2015 by CITIC All rights reserved.
 * Created [2017-04-12]
 * =============================================
 */

package citic.cgb.xmlmsg.service.impl;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import citic.base.utils.DtUtils;
import citic.cgb.xmlmsg.domain.Afp006Dto;

/**
 * @author yinxiong
 * @date 2017年5月16日 下午3:52:27
 */
@Service("afp006")
public class AFP006InterfaceService extends AFPService {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 6386258000208963465L;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/** map命名空间 */
	private String namespace = "citic.cgb.xmlmsg.mapper.busi.Afp006DtoMapper.";

	private final String TRANS_OCDE = "AFP006";//交易代码【6位接口编号】
	private final String senderId = "AFPM";//客户端系统标识
	private final String SUCCEED = "0000";//0000：成功  其他代码：失败
	private Set<String> set = null;//请求字段set
	
	/**
	 * 构造接口输入字段的set<br>
	 * 若接口变更，此处需要变更
	 */
	private AFP006InterfaceService() {
		set = new HashSet<String>();
		set.add("tx_organkey");//交易机构
		set.add("acct_organkey");//账户归属机构
		set.add("tx_time");//交易时间
		set.add("party_id");//客户号
		set.add("party_class_cd");//客户类型
		set.add("party_name");//客户名称
		set.add("cust_id_no");//客户证件号码
		set.add("sys_ind");//系统标识
		set.add("channel");//涉及渠道标识
		set.add("tx_acctnum");//交易账户
		set.add("curr_cd");//交易币种
		set.add("amt");//交易金额
		set.add("biz_type");//交易种类
		set.add("opp_acct_organkey");//交易对手行所名称
		set.add("opp_party_class_cd");//交易对手类型
		set.add("opp_tx_acctnum");//交易对手账号
		set.add("opp_party_name");//交易对手姓名
		set.add("opp_cust_id_no");//交易对手证件号码
		set.add("rt_typ");//阻断类型
	}
		
    /**
     * 执行入口
     */
	@Override
	public String messageReceived(String Msg) {
		String re_msg = "";
		try {
			//解析xml，获取请求对象
			Afp006Dto request = getUnkMsgByAFP006(Msg);
			request.setTx_result("0");//0:放行 1：阻断
			if (!SUCCEED.equals(request.getErrorcode())) {
				//获取异常报文的body
				String err_body = getBodyStr(request);
				//组装异常报文
				re_msg = getResponseMsgRes(senderId,request.getSenderId(), TRANS_OCDE, request.getSenderSN(), err_body);
			} else {
				//进行名单匹配,找出最近日期的一条名单数据
				Afp006Dto md_res = this.checkHitStatusByDb(request);
				//名单为新增，即有效，视为命中
				if("+".equals(md_res.getAct_status())){
					request.setSan_name(md_res.getSan_name_type());//名单细类 F001~F004
					request.setCreate_time(DtUtils.getNowTime());//写入时间
					//设置默认值
					request.setTx_result("已阻断");
					request.setAlert_reason("客户主体触发的涉恐名单");//预警原因
					request.setAlert_type("2");//1:交易拒绝 2：开户拒绝 默认为2
					request.setSend_flag("0");//0:待发送 1:已发送 9：中间状态
					//交易时间14转19
					request.setTx_time(DtUtils.toStrTimeStamp(request.getTx_time()));
					//插入预警信息
					Afp006Dto in_res = this.InsertWarnLog(request);
					//处理插入异常
					request.setErrorcode(in_res.getErrorcode());
					request.setErrormsg(in_res.getErrormsg());
				}
				//生成报文body
				String body = this.getBodyStr(request);
				//组装响应报文
				re_msg = this.getResponseMsgRes(senderId,request.getSenderId(), TRANS_OCDE, request.getSenderSN(), body);
				
			}
		} catch (Exception e) {
			logger.error("报文解析异常：" + e.getMessage(), e);
		}
		return re_msg;
	}
	/**
	 * 解析AFP006接口请求数据
	 * 
	 * @param msg
	 * @return
	 * @throws Exception
	 * @author yinxiong
	 * @date 2017年5月17日 下午5:15:41
	 */
	private Afp006Dto getUnkMsgByAFP006(String msg) {
		Afp006Dto request = null;
		try {
			//解析xml，获取查询信息
			request = this.getRequestMsg(msg);
			//校验请求信息
			request = validateRequestMsg(request);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return request;
	}
	
	
	private String getBodyStr(Afp006Dto response) {
		//生成body
		StringBuffer buff = new StringBuffer();
		buff.append("<soapenv:Body>");
		buff.append("<gateway:NoAS400>");
		buff.append(getGatewayTag("errorcode", response.getErrorcode()));//处理结果 0：无结果 1：成功
		buff.append(getGatewayTag("errormsg", response.getErrormsg()));//备注
		buff.append(getGatewayTag("tx_result", StringUtils.equals("已阻断", response.getTx_result())?"1":"0"));//交易结果
		buff.append(getGatewayTag("alert_reason", response.getAlert_reason()));//预警原因
		buff.append(getGatewayTag("san_name", response.getSan_name()));//名单细类
		buff.append(getGatewayTag("alert_type", response.getAlert_type()));//预警类型
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
	private Afp006Dto getRequestMsg(String soapXML) {
		Afp006Dto request = new Afp006Dto();
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
			logger.error(e.getMessage(), e);
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
	private void parseBody(Iterator<SOAPElement> iterator, Afp006Dto resultBean) throws Exception {
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
	
	/**
	 * 
	 * @param request
	 * @return
	 * 
	 * @author yinxiong
	 * @date 2017年5月17日 上午11:13:28
	 */
	private Afp006Dto checkHitStatusByDb(Afp006Dto request) {
		Afp006Dto response= null;
		try {
			 response = busiDao.selectOne(namespace + "selectBb11_aml_listByInterface", request);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			response.setErrorcode("Q001");
			response.setErrormsg("查询异常");//
		}
		if(response==null){
			response = new Afp006Dto();
		}
		return response;
	}
	/**
	 * 插入上报数据
	 * 
	 * @param request
	 * @return
	 * @author yinxiong
	 * @date 2017年5月17日 下午17:06:56
	 */
	private Afp006Dto InsertWarnLog(Afp006Dto request) {
		Afp006Dto response = new Afp006Dto();
		response.setErrorcode(SUCCEED);
		try {
			busiDao.insert(namespace + "InsertBb11_aml_warn_logByInterface", request);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			response.setErrorcode("I001");
			response.setErrormsg("预警信息非法，数据入库失败");//
		}
		return response;
	}
	
	/**
	 * 请求数据校验
	 * @param request
	 * @return
	 * 
	 * @author yinxiong
	 * @date 2017年5月18日 上午10:05:48
	 */
	private Afp006Dto validateRequestMsg(Afp006Dto request){
		
		if(StringUtils.isBlank(request.getTx_organkey())&&StringUtils.isBlank(request.getAcct_organkey())){
			request.setErrorcode("C001");
			request.setErrormsg("tx_organkey和acct_organkey二选一必输");//
			return request;
		}
		if(StringUtils.isBlank(request.getTx_time())){
			request.setErrorcode("C002");
			request.setErrormsg("tx_time必输");//
			return request;
		}
		if(StringUtils.isBlank(request.getParty_class_cd())){
			request.setErrorcode("C003");
			request.setErrormsg("party_class_cd必输");//
			return request;
		}
		if(StringUtils.isBlank(request.getCust_id_no())){
			request.setErrorcode("C004");
			request.setErrormsg("cust_id_no必输");//
			return request;
		}
		if(StringUtils.isBlank(request.getSys_ind())){
			request.setErrorcode("C005");
			request.setErrormsg("sys_ind必输");//
			return request;
		}
		if(StringUtils.isBlank(request.getChannel())){
			request.setErrorcode("C006");
			request.setErrormsg("channel必输");//
			return request;
		}
		if(StringUtils.isBlank(request.getRt_typ())){
			request.setErrorcode("C007");
			request.setErrormsg("rt_typ必输");//
			return request;
		}
		//去掉金额前多余的0，若为空，金额给0【金额是实际的100倍】
		String amt = request.getAmt().replaceAll("^(0+)", "");
		amt = StringUtils.isBlank(amt)?"0":amt;
		if(!NumberUtils.isNumber(amt)||!NumberUtils.isDigits(amt)){
			request.setErrorcode("C008");
			request.setErrormsg("交易金额amt应该是真实数据*100后的整数");//
			return request;
		}else{
			request.setAmt(amt);
		}
		request.setErrorcode(SUCCEED);
		request.setErrormsg("");
		return request;
	}

}
