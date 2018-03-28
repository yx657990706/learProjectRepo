package citic.cgb.xmlmsg.service.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import citic.base.annotations.BusiTx;
import citic.base.utils.DtUtils;
import citic.cgb.xmlmsg.domain.Afp008Dto;
import citic.core.service.CodeService;

@Service("afp008")
public class AFP008InterfaceService extends AFPService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5745141039520766877L;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CodeService codeService;
	
	/** map命名空间 */
	private String namespace = "citic.cgb.xmlmsg.mapper.busi.Afp007DtoMapper.";
	//交易代码【6位接口编号】
	private final String TRANS_OCDE = "AFP008";
	private final String senderId = "AFPM";//客户端系统标识
	private final String SUCCEED = "0000";//0000：成功  其他代码：失败
	private Set<String> set = null;//请求字段set
	
	/**
	 * 构造接口输入字段的set<br>
	 * 若接口变更，此处需要变更
	 */
	private AFP008InterfaceService() {
		set = new HashSet<String>();
		set.add("bdhm");//控制请求单号
		set.add("xh");//序号
		set.add("status");//任务状态  N-未处理 ; F-处理失败
		set.add("dealstatus");//处理方式  H-线上处理；S-线下处理；R-拒绝
		set.add("khzh");//被执行人账号
		set.add("glzhhm");//被执行人账号子账号
		set.add("issxzh");//本行收息账户 
		set.add("sxzh");//收息账号
		set.add("sxzhmc");//收息账户名
		set.add("sxzhkhhh");//收息账户开户行号
		set.add("sxzhkhhmc");//收息账户开户行名称
		set.add("skje");//实控金额
		set.add("dealing_time");//实控日期
		set.add("beiz");//回执备注信息
		set.add("wnkzyy");//未能控制原因
		set.add("userid");//操作员
		set.add("checkuserid");//复合员
	}
	
	/**
	 * 请求扣划数据查询<br>
	 * 1.解析报文，获取所有数据<br>
	 * 2.封装请求数据（处理分页等）<br>
	 * 3.生成响应报文
	 * 
	 * @param Msg
	 * @return
	 * @author yinxiong
	 * @date 2017年6月20日 下午20:45:20
	 */
	@Override
	public String messageReceived(String Msg) {
		String re_msg = "";
		try {
			//解析xml，获取查询对象
			Afp008Dto request = this.getUnkMsgByAFP008(Msg);
			if (!SUCCEED.equals(request.getErrorcode())) {
				//获取异常报文的body
				String err_body = getBodyStrByAFP008(request);
				//组装异常报文
				re_msg = getResponseMsgRes(senderId, request.getSenderId(), TRANS_OCDE, request.getSenderSN(), err_body);
			} else {
				//处理数据
				Afp008Dto response = this.getDtoFromDB(request);
				//生成报文body
				String body = this.getBodyStrByAFP008(response);
				//组装响应报文
				re_msg = this.getResponseMsgRes(senderId, request.getSenderId(), TRANS_OCDE, request.getSenderSN(), body);
			}
		} catch (Exception e) {
			logger.error("报文解析异常：" + e.getMessage(), e);
		}
		
		return re_msg;
	}
	
	/**
	 * 解析AFP008接口请求数据
	 * 
	 * @param msg
	 * @return
	 * @throws Exception
	 * @author yinxiong
	 * @date 2017年6月20日 下午5:16:05
	 */
	private Afp008Dto getUnkMsgByAFP008(String msg) throws Exception {
		Afp008Dto request = null;
		try {
			//解析xml，获取查询信息
			request = this.getRequestMsg(msg);
			//校验查询条件
			request = this.validateRequestMsg(request);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new Exception("报文截取转换过程发生异常，请检查报文数据");
		}
		
		return request;
	}
	
	/**
	 * 获取报文body
	 * 
	 * @param response
	 * @return
	 * @author yinxiong
	 * @date 2017年4月13日 下午3:23:21
	 */
	private String getBodyStrByAFP008(Afp008Dto response) {
		//生成body
		StringBuffer buff = new StringBuffer();
		buff.append("<soapenv:Body>");
		buff.append("<gateway:NoAS400>");
		buff.append(getGatewayTag("errorcode", response.getErrorcode()));
		buff.append(getGatewayTag("errormsg", response.getErrormsg()));
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
	private Afp008Dto getRequestMsg(String soapXML) {
		Afp008Dto request = new Afp008Dto();
		try {
			SOAPMessage msg = this.formatSoapString(soapXML);
			//解析header的数据
			SOAPHeader header = msg.getSOAPHeader();
			Iterator<SOAPElement> it_header = header.getChildElements();
			parseHeader(it_header, request);
			//解析body的数据
			SOAPBody body = msg.getSOAPBody();
			Iterator<SOAPElement> it_body = body.getChildElements();
			parseBody(it_body, request, set);
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return request;
	}
	
	/**
	 * 更新数据状态<br>
	 * 
	 * @param request
	 * @return
	 */
	@BusiTx
	private Afp008Dto getDtoFromDB(Afp008Dto request) {
		Afp008Dto response = new Afp008Dto();
		response.setErrorcode(SUCCEED);
		try {
			busiDao.update(namespace + "updateBr31_kzzhByInterface", request);
			//线下或者拒绝，需要更新info表
			if(!"H".equals(request.getDealstatus())){
				busiDao.update(namespace + "updateBr31_kzcl_infoByInterface", request);
			}
			//插入task2任务
			String key = codeService.getSequenceValus("SEQ_MC21_TASK_FACT2");//取序列
			request.setTaskkey("T2_GF_"+key);
			request.setDatatime(DtUtils.getNowTime());
			request.setServerid("");
			busiDao.insert(namespace + "insertMc21_task_fact2ByInterface", request);
		} catch (Exception e) {
			response.setErrorcode("DB02");
			response.setErrormsg("扣划参数存在不符合接口规范的字段！");
			logger.error(e.getMessage(), e);
		}
		return response;
	}
	
	/**
	 * 请求数据校验
	 * 
	 * @param request
	 * @return
	 * @author yinxiong
	 * @date 2017年5月18日 上午10:05:48
	 */
	private Afp008Dto validateRequestMsg(Afp008Dto request) {
		
		if (StringUtils.isBlank(request.getBdhm())) {//控制请求单号
			request.setErrorcode("K001");
			request.setErrormsg("bdhm必输");
			return request;
		}
		if (StringUtils.isBlank(request.getXh())) {//序号
			request.setErrorcode("K002");
			request.setErrormsg("xh必输");
			return request;
		}
		if (StringUtils.isBlank(request.getStatus())) {//任务状态
			request.setErrorcode("K003");
			request.setErrormsg("status必输");
			return request;
		}
		if (StringUtils.isBlank(request.getDealstatus())) {//处理方式
			request.setErrorcode("K004");
			request.setErrormsg("dealstatus必输");
			return request;
		}
		if (StringUtils.isBlank(request.getKhzh())) {//被执行人账号
			request.setErrorcode("K005");
			request.setErrormsg("khzh必输");
			return request;
		}
//		if (StringUtils.isBlank(request.getGlzhhm())) {//被执行人账号子账号
//			request.setErrorcode("K006");
//			request.setErrormsg("glzhhm必输");
//			return request;
//		}
		if (StringUtils.isBlank(request.getIssxzh())) {//本行收息账户
			request.setErrorcode("K007");
			request.setErrormsg("issxzh必输");
			return request;
		}
		if (StringUtils.isBlank(request.getUserid())) {//操作员
			request.setErrorcode("K016");
			request.setErrormsg("userid必输");
			return request;
		}
		if (StringUtils.isBlank(request.getCheckuserid())) {//复合员
			request.setErrorcode("K017");
			request.setErrormsg("checkuserid必输");
			return request;
		}
		//定期账户校验收息户(0-无；1-本行；2-行外)		
		if (!"0".equals(request.getIssxzh())) {
			if (StringUtils.isBlank(request.getSxzh())) {//收息账号
				request.setErrorcode("K008");
				request.setErrormsg("sxzh必输");
				return request;
			}
			if("2".equals(request.getIssxzh())){
				if (StringUtils.isBlank(request.getSxzhmc())) {//收息账户名
					request.setErrorcode("K009");
					request.setErrormsg("sxzhmc必输");
					return request;
				}
				if (StringUtils.isBlank(request.getSxzhkhhh())) {//收息账户开户行号
					request.setErrorcode("K010");
					request.setErrormsg("sxzhkhhh必输");
					return request;
				}
			}
		}
		
		//处理状态控制
		if("F".equals(request.getStatus())){
			if(!"S".equals(request.getDealstatus())&&!"R".equals(request.getDealstatus())){
				request.setErrorcode("K011");
				request.setErrormsg("status为F时，dealstatus的值只能取S或者R");
				return request;
			}
		}
        //处理未能控制原因
		if("R".equals(request.getDealstatus())){
			//未能控制原因
			if (StringUtils.isBlank(request.getWnkzyy())) {
				request.setErrorcode("K015");
				request.setErrormsg("wnkzyy必输");
				return request;
			}
		}
		if("S".equals(request.getDealstatus())){
			//实控金额
			if (StringUtils.isBlank(request.getSkje())) {
				request.setErrorcode("K016");
				request.setErrormsg("线下处理，skje必输");
				return request;
			}
			//清空未能控制原因
			request.setWnkzyy("");
		}
		
		request.setErrorcode(SUCCEED);
		request.setErrormsg("");
		return request;
	}
	
}
