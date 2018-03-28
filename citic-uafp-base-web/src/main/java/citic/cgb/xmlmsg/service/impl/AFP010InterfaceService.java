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
import citic.base.utils.DtUtils;
import citic.cgb.xmlmsg.domain.Afp007QueryDto;
import citic.cgb.xmlmsg.domain.Afp010Dto;

@Service("afp010")
public class AFP010InterfaceService extends AFPService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5745141039520766877L;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/** map命名空间 */
	private String namespace = "citic.cgb.xmlmsg.mapper.busi.Afp007DtoMapper.";
	//交易代码【6位接口编号】
	private final String TRANS_OCDE = "AFP010";
	private final String senderId = "AFPM";//客户端系统标识
	private final String SUCCEED = "0000";//0000：成功  其他代码：失败
	private final int COUNT = 10;//默认每页行数
	private Set<String> set = null;//请求字段set
	
	/**
	 * 构造接口输入字段的set<br>
	 * 若接口变更，此处需要变更
	 */
	private AFP010InterfaceService() {
		set = new HashSet<String>();
		set.add("bdhm");//请求单号
		set.add("begindate");//任务开始日期
		set.add("enddate");//任务结束日期
		set.add("khzh");//被执行人账号
		set.add("xm");//被查询人姓名
		set.add("zjlx");//证件类型
		set.add("dsrzjhm");//被查询人证件/组织机构号码
		set.add("khhsh");//开户行所号
		set.add("khhfhh");//开户行分行号
		set.add("bz");//币种
		set.add("je");//金额
		set.add("sfjh");//是否结汇
		set.add("kzlx");//控制类型（1-存款，2-非存款类金融资产）
		set.add("kzcs");//控制措施 措施类型（01-冻结，02-继续冻结，04-解除冻结，06-扣划）
		set.add("status");//任务状态 控制措施为 06 时（H-待执行；S-补录；R-拒绝；O-成功；C-成功（待核实）；X-失败 二代 往行外转账失败）；其他为 （O-成功；X-失败）
		set.add("fydm");//法院代码
		set.add("fymc");//法院名称
		set.add("ckwh");//裁定文书号
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
			Afp010Dto request = this.getUnkMsgByAFP010(Msg);
			if (!SUCCEED.equals(request.getErrorcode())) {
				//获取异常报文的body
				String err_body = getBodyStrByAFP010(request);
				//组装异常报文
				re_msg = getResponseMsgRes(senderId, request.getSenderId(), TRANS_OCDE, request.getSenderSN(), err_body);
			} else {
				//查询数据
				Afp010Dto response = this.getDtoFromDB(request);
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
	 * 解析AFP010接口请求数据
	 * 
	 * @param msg
	 * @return
	 * @throws Exception
	 * @author yinxiong
	 * @date 2017年6月20日 下午5:16:05
	 */
	private Afp010Dto getUnkMsgByAFP010(String msg) throws Exception {
		Afp010Dto request = null;
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
	private String getBodyStrByAFP010(Afp010Dto response) {
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
				buff.append(getGatewayTag("kzlx", afp007.getKzlx()));
				buff.append(getGatewayTag("xm", afp007.getXm()));
				buff.append(getGatewayTag("zjlx", afp007.getZjlx()));
				buff.append(getGatewayTag("dsrzjhm", afp007.getDsrzjhm()));
				buff.append(getGatewayTag("khzh", afp007.getKhzh()));
				buff.append(getGatewayTag("glzhhm", afp007.getGlzhhm()));
				buff.append(getGatewayTag("zhlx", afp007.getZhlx()));
				buff.append(getGatewayTag("khwd", afp007.getKhwd()));
				buff.append(getGatewayTag("khwddm", afp007.getKhwddm()));
				buff.append(getGatewayTag("kznr", afp007.getKznr()));
				buff.append(getGatewayTag("ksrq", afp007.getKsrq()));
				buff.append(getGatewayTag("jsrq", afp007.getJsrq()));
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
				buff.append(getGatewayTag("recipient_time", afp007.getRecipient_time()));
				buff.append(getGatewayTag("kzcs", afp007.getKzcs()));
				//冻结理财有关信息
				buff.append(getGatewayTag("zcmc", afp007.getZcmc()));
				buff.append(getGatewayTag("zclx", afp007.getZclx()));
				buff.append(getGatewayTag("cpxszl", afp007.getCpxszl()));
				buff.append(getGatewayTag("dqh", afp007.getDqh()));
				buff.append(getGatewayTag("jrcpbh", afp007.getJrcpbh()));
				buff.append(getGatewayTag("lczh", afp007.getLczh()));
				buff.append(getGatewayTag("zjhkzh", afp007.getZjhkzh()));
				buff.append(getGatewayTag("se", afp007.getSe()));
				buff.append(getGatewayTag("jldw", afp007.getJldw()));
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
	private Afp010Dto getRequestMsg(String soapXML) {
		Afp010Dto request = new Afp010Dto();
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
	private Afp010Dto getDtoFromDB(Afp010Dto request) {
		Afp010Dto response = new Afp010Dto();
		response.setErrorcode(SUCCEED);
		try {
			List<Afp007QueryDto> resultList = busiDao.selectList(namespace + "selectKZInfoByInterface", request);
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
	private Afp010Dto validateRequestMsg(Afp010Dto request) {
		
		//页码处理
		if (StringUtils.isBlank(request.getCurrpage()) || !NumberUtils.isDigits(request.getCurrcount()) || "0".equals(request.getCurrpage())) {
			request.setCurrpage("1");
		}
		//每页行数检查
		if (StringUtils.isBlank(request.getCurrcount()) || !NumberUtils.isDigits(request.getCurrcount()) || "0".equals(request.getCurrcount())) {
			request.setCurrcount(COUNT + "");
		}
		//查询日期处理
		String begindate = request.getBegindate();
		String enddate = request.getEnddate();
		if (!StringUtils.isBlank(begindate)) {
			//10位日期补成19位
			if (begindate.length() == 10) {
				request.setBegindate(begindate + " 00:00:00");
			}
		}
		if (StringUtils.isBlank(enddate)) {
			request.setEnddate(DtUtils.getNowTime());
		}else{
			if (enddate.length() == 10) {
				request.setEnddate(enddate + " 23:59:59");
			}
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
