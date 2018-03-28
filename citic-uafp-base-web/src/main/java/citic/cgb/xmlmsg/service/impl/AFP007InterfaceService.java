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
import citic.cgb.xmlmsg.domain.Afp007Dto;
import citic.cgb.xmlmsg.domain.Afp007QueryDto;

@Service("afp007")
public class AFP007InterfaceService extends AFPService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5745141039520766877L;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/** map命名空间 */
	private String namespace = "citic.cgb.xmlmsg.mapper.busi.Afp007DtoMapper.";
	//交易代码【6位接口编号】
	private final String TRANS_OCDE = "AFP007";
	private final String senderId = "AFPM";//客户端系统标识
	private final String SUCCEED = "0000";//0000：成功  其他代码：失败
	private final int COUNT = 10;//默认每页行数
	private Set<String> set = null;//请求字段set
	
	/**
	 * 构造接口输入字段的set<br>
	 * 若接口变更，此处需要变更
	 */
	private AFP007InterfaceService() {
		set = new HashSet<String>();
		set.add("bdhm");//请求单号
		set.add("khzh");//被执行人账号(账号或者子账号)
		set.add("xm");//被查询人姓名
		set.add("zjlx");//证件类型
		set.add("dsrzjhm");//被查询人证件/组织机构号码
		set.add("bz");//币种
		set.add("sfjh");//是否结汇
		set.add("fydm");//法院代码
		set.add("fymc");//法院名称
		set.add("begindate");//任务开始日期
		set.add("enddate");//任务结束日期
		set.add("ckwh");//裁定文书号
		set.add("status");//任务状态   N-未处理 ; F-处理失败
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
			Afp007Dto request = this.getUnkMsgByAFP007(Msg);
			if (!SUCCEED.equals(request.getErrorcode())) {//本接口的校验方式决定该步骤不会走。。
				//获取异常报文的body
				String err_body = getBodyStrByAFP007(request);
				//组装异常报文
				re_msg = getResponseMsgRes(senderId, request.getSenderId(), TRANS_OCDE, request.getSenderSN(), err_body);
			} else {
				//查询数据
				Afp007Dto response = this.getDtoFromDB(request);
				//生成报文body
				String body = this.getBodyStrByAFP007(response);
				//组装响应报文
				re_msg = this.getResponseMsgRes(senderId, request.getSenderId(), TRANS_OCDE, request.getSenderSN(), body);
			}
		} catch (Exception e) {
			logger.error("报文解析异常：" + e.getMessage(), e);
		}
		
		return re_msg;
	}
	
	/**
	 * 解析AFP007接口请求数据
	 * 
	 * @param msg
	 * @return
	 * @throws Exception
	 * @author yinxiong
	 * @date 2017年6月20日 下午5:16:05
	 */
	private Afp007Dto getUnkMsgByAFP007(String msg) throws Exception {
		Afp007Dto request = null;
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
	private String getBodyStrByAFP007(Afp007Dto response) {
		//生成body
		StringBuffer buff = new StringBuffer();
		buff.append("<soapenv:Body>");
		buff.append("<gateway:NoAS400>");
		buff.append(getGatewayTag("errorcode", response.getErrorcode()));
		buff.append(getGatewayTag("errormsg", response.getErrormsg()));
		List<Afp007QueryDto> list = response.getResultList();
		if (list != null && list.size() > 0) {
			//分页信息
			Page page = response.getPage();
			buff.append(getGatewayTag("totalpage", page.getTotalPage() + ""));//总页数
			buff.append(getGatewayTag("totalpount", page.getTotalRecord() + ""));//总记录数
			buff.append(getGatewayTag("currpage", page.getCurrPageNo() + ""));//当前页码
			//处理最后一页数据不满足分页size的情况
			buff.append(getGatewayTag("currcount", list.size()<page.getPageSize()?list.size()+"": page.getPageSize()+""));//每页记录数 
			for (Afp007QueryDto afp007 : list) {
				buff.append(getGatewayTag("bdhm", afp007.getBdhm()));
				buff.append(getGatewayTag("ccxh", afp007.getCcxh()));
				buff.append(getGatewayTag("xm", afp007.getXm()));
				buff.append(getGatewayTag("zjlx", afp007.getZjlx()));
				buff.append(getGatewayTag("dsrzjhm", afp007.getDsrzjhm()));
				buff.append(getGatewayTag("khzh", afp007.getKhzh()));
				buff.append(getGatewayTag("glzhhm", afp007.getGlzhhm()));
				buff.append(getGatewayTag("zhlx", afp007.getZhlx()));
				buff.append(getGatewayTag("cclb", afp007.getCclb()));
				buff.append(getGatewayTag("khwd", afp007.getKhwd()));
				buff.append(getGatewayTag("khwddm", afp007.getKhwddm()));
				buff.append(getGatewayTag("bz", afp007.getBz()));
				buff.append(getGatewayTag("je", afp007.getJe()));
				buff.append(getGatewayTag("sfjh", afp007.getSfjh()));
				buff.append(getGatewayTag("fymc", afp007.getFymc()));
				buff.append(getGatewayTag("fydm", afp007.getFydm()));
				buff.append(getGatewayTag("cbr", afp007.getCbr()));
				buff.append(getGatewayTag("yhdh", afp007.getYhdh()));
				buff.append(getGatewayTag("ah", afp007.getAh()));
				buff.append(getGatewayTag("gzzbh", afp007.getGzzbh()));
				buff.append(getGatewayTag("gwzbh", afp007.getGwzbh()));
				buff.append(getGatewayTag("lxfs", afp007.getLxfs()));
				buff.append(getGatewayTag("ckwh", afp007.getCkwh()));
				buff.append(getGatewayTag("zxkzhhm", afp007.getZxkzhhm()));
				buff.append(getGatewayTag("zxkzhkhh", afp007.getZxkzhkhh()));
				buff.append(getGatewayTag("zxkzhkhhhh", afp007.getZxkzhkhhhh()));
				buff.append(getGatewayTag("zxkzhzh", afp007.getZxkzhzh()));
				buff.append(getGatewayTag("zxkzhlx", afp007.getZxkzhlx()));
				buff.append(getGatewayTag("ydjah", afp007.getYdjah()));
				buff.append(getGatewayTag("ydjdh", afp007.getYdjdh()));
				buff.append(getGatewayTag("wnkzyy", afp007.getWnkzyy()));
				buff.append(getGatewayTag("status", afp007.getStatus()));
				buff.append(getGatewayTag("receivetime", afp007.getRecipient_time()));
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
	private Afp007Dto getRequestMsg(String soapXML) {
		Afp007Dto request = new Afp007Dto();
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
	 * 查询扣划的请求信息
	 * 
	 * @param request
	 * @return
	 */
	private Afp007Dto getDtoFromDB(Afp007Dto request) {
		Afp007Dto response = new Afp007Dto();
		response.setErrorcode(SUCCEED);//0：查询失败  1：查询成功
		try {
			List<Afp007QueryDto> resultList = busiDao.selectList(namespace + "selectKHInfoByInterface", request);
			//将list封装到对象，并设置查询结果和记录数
			Page page = request.getPage();
			response.setPage(page);
			response.setResultList(resultList);
		} catch (Exception e) {
			response.setErrorcode("DB01");
			response.setErrormsg("查询条件存在长度非法的字段！");
			logger.error(e.getMessage(),e);
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
	private Afp007Dto validateRequestMsg(Afp007Dto request) {
		
		//将非法输入转换为默认值
		//页码检查
		if (StringUtils.isBlank(request.getCurrpage()) || !NumberUtils.isDigits(request.getCurrcount()) || "0".equals(request.getCurrpage())) {
			request.setCurrpage("1");
		}
		//每页行数检查
		if (StringUtils.isBlank(request.getCurrcount()) || !NumberUtils.isDigits(request.getCurrcount()) || "0".equals(request.getCurrcount())) {
			request.setCurrcount(COUNT + "");
		}
		
		//分页设置
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
