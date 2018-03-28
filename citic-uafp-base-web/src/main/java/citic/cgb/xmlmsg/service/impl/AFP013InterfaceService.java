package citic.cgb.xmlmsg.service.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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

import citic.base.Page;
import citic.cgb.xmlmsg.domain.Afp013Dto;
import citic.cgb.xmlmsg.domain.Afp013QueryDto;

@Service("afp013")
public class AFP013InterfaceService extends AFPService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2648984472388506024L;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/** map命名空间 */
	private String namespace = "citic.cgb.xmlmsg.mapper.busi.Afp007DtoMapper.";
	//交易代码【6位接口编号】
	private final String TRANS_OCDE = "AFP013";
	private final String senderId = "AFPM";//客户端系统标识
	private final String SUCCEED = "0000";//0000：成功  其他代码：失败
	private final int COUNT = 10;//默认每页行数
	private Set<String> set = null;//请求字段set
	
	/**
	 * 构造接口输入字段的set<br>
	 * 若接口变更，此处需要变更
	 */
	private AFP013InterfaceService() {
		set = new HashSet<String>();
		set.add("bdhm");//请求单号
		set.add("begindate");//任务开始日期
		set.add("enddate");//任务结束日期
		set.add("xm");//被查询人姓名
		set.add("zjlx");//证件类型
		set.add("dsrzjhm");//被查询人证件/组织机构号码
		set.add("fydm");//法院代码
		set.add("fymc");//法院名称
		set.add("wsbh");//文书编号
		set.add("currpage");//当前页码
		set.add("currcount");//每页输出行数
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
			Afp013Dto request = this.getUnkMsgByAFP010(Msg);
			if (!SUCCEED.equals(request.getErrorcode())) {
				//获取异常报文的body
				String err_body = getBodyStrByAFP010(request);
				//组装异常报文
				re_msg = getResponseMsgRes(senderId, request.getSenderId(), TRANS_OCDE, request.getSenderSN(), err_body);
			} else {
				//查询数据
				Afp013Dto response = this.getDtoFromDB(request);
				//生成报文body
				String body = this.getBodyStrByAFP010(response);
				//组装响应报文
				re_msg = this.getResponseMsgRes(senderId, request.getSenderId(), TRANS_OCDE, request.getSenderSN(), body);
			}
		} catch (Exception e) {
			logger.error("报文解析异常：" + e.getMessage(), e);
		}
		
		return re_msg;
	}
	
	/**
	 * 解析AFP013接口请求数据
	 * 
	 * @param msg
	 * @return
	 * @throws Exception
	 * @author yinxiong
	 * @date 2017年6月20日 下午5:16:05
	 */
	private Afp013Dto getUnkMsgByAFP010(String msg) throws Exception {
		Afp013Dto request = null;
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
	private String getBodyStrByAFP010(Afp013Dto response) {
		//生成body
		StringBuffer buff = new StringBuffer();
		buff.append("<soapenv:Body>");
		buff.append("<gateway:NoAS400>");
		buff.append(getGatewayTag("errorcode", response.getErrorcode()));
		buff.append(getGatewayTag("errormsg", response.getErrormsg()));
		List<Afp013QueryDto> list = response.getResultList();
		if (list != null && list.size() > 0) {
			//分页信息
			Page page = response.getPage();
			buff.append(getGatewayTag("totalpage", page.getTotalPage() + ""));//总页数
			buff.append(getGatewayTag("totalpount", page.getTotalRecord() + ""));//总记录数
			buff.append(getGatewayTag("currpage", page.getCurrPageNo() + ""));//当前页码
			//处理最后一页数据不满足分页size的情况
			buff.append(getGatewayTag("currcount", list.size()<page.getPageSize()?list.size()+"": page.getPageSize()+""));//每页记录数 
			for (Afp013QueryDto afp013 : list) {
				buff.append(getGatewayTag("bdhm", afp013.getBdhm()));
				buff.append(getGatewayTag("xm", afp013.getXm()));
				buff.append(getGatewayTag("zjlx", afp013.getZjlx()));
				buff.append(getGatewayTag("dsrzjhm", afp013.getDsrzjhm()));
				buff.append(getGatewayTag("fymc", afp013.getFymc()));
				buff.append(getGatewayTag("fydm", afp013.getFydm()));
				buff.append(getGatewayTag("cbr", afp013.getCbr()));
				buff.append(getGatewayTag("yhdh", afp013.getYhdh()));
				buff.append(getGatewayTag("ah", afp013.getAh()));
				buff.append(getGatewayTag("gzzbh", afp013.getGzzbh()));
				buff.append(getGatewayTag("gwzbh", afp013.getGwzbh()));
				buff.append(getGatewayTag("ckh", afp013.getCkh()));
				buff.append(getGatewayTag("wsbh", afp013.getWsbh()));
				buff.append(getGatewayTag("ckkssj", afp013.getCkkssj()));
				buff.append(getGatewayTag("ckjssj", afp013.getCkjssj()));
				buff.append(getGatewayTag("qrydt", afp013.getQrydt()));
			}
		} else {
			buff.append(getGatewayTag("totalpage", 0 + ""));//总页数
			buff.append(getGatewayTag("totalpount", 0 + ""));//总记录数
			buff.append(getGatewayTag("currpage", 1 + ""));//当前页码
			buff.append(getGatewayTag("currcount", 0 + ""));//每页记录数
		}
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
	private Afp013Dto getRequestMsg(String soapXML) {
		Afp013Dto request = new Afp013Dto();
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
	 * 高法控制明细查询
	 * 
	 * @param request
	 * @return
	 */
	private Afp013Dto getDtoFromDB(Afp013Dto request) {
		Afp013Dto response = new Afp013Dto();
		response.setErrorcode(SUCCEED);
		try {
			List<Afp013QueryDto> resultList = busiDao.selectList(namespace + "selectCXInfoByInterface", request);
			//将list封装到对象，并设置查询结果和记录数
			Page page = request.getPage();
			response.setPage(page);
			response.setResultList(resultList);
		} catch (Exception e) {
			response.setErrorcode("DB01");
			response.setErrormsg("查询条件存在长度非法的字段！");
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
	private Afp013Dto validateRequestMsg(Afp013Dto request) {
		
		//页码处理
		if (StringUtils.isBlank(request.getCurrpage()) || !NumberUtils.isDigits(request.getCurrcount()) || "0".equals(request.getCurrpage())) {
			request.setCurrpage("1");
		}
		//每页行数检查
		if (StringUtils.isBlank(request.getCurrcount()) || !NumberUtils.isDigits(request.getCurrcount()) || "0".equals(request.getCurrcount())) {
			request.setCurrcount(COUNT + "");
		}
		//设置分页信息
		Page page = new Page();
		page.setCurrPageNo(Integer.parseInt(request.getCurrpage()));
		page.setPageSize(Integer.parseInt(request.getCurrcount()));
		page.setCount(true);
		
		request.setPage(page);
		request.setErrorcode(SUCCEED);
		request.setErrormsg("");
		return request;
	}
	
}
