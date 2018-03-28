package citic.cgb.xmlmsg.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import citic.base.utils.DtUtils;
import citic.cgb.tools.WfTools;
import citic.cgb.xmlmsg.domain.Afp007QueryDto;
import citic.cgb.xmlmsg.domain.Afp010Dto;
import citic.core.service.CodeService;

import com.google.common.collect.Lists;

@Service("afp012")
public class AFP012InterfaceService extends AFPService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5745141039520766877L;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/** map命名空间 */
	private String namespace = "citic.cgb.xmlmsg.mapper.busi.Afp007DtoMapper.";
	//交易代码【6位接口编号】
	private final String TRANS_OCDE = "AFP012";
	private final String senderId = "AFPM";//客户端系统标识
	private final String SUCCEED = "0000";//0000：成功  其他代码：失败
	private final String SYMBOL = "|";//分隔符号(英文竖线)
	private final String destPath = "/cdadmin/UFSM/TELE/save/AFPS";//目标目录路径
	private final String taskId = "P7CQ0KKV";// taskid从UFS获取
	private final String encoding = "GB18030";
	private final String sysId = "TELE";//对端系统标识
	private Set<String> set = null;//请求字段set
	
	@Autowired
	private CodeService codeService;
	@Autowired
	private WfTools tools;
	
	/**
	 * 构造接口输入字段的set<br>
	 * 若接口变更，此处需要变更
	 */
	private AFP012InterfaceService() {
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
		set.add("kzcs");//控制措施 措施类型（01-冻结，02-继续冻结，04-解除冻结，06-扣划）
		set.add("status");//任务状态 控制措施为 06 时（H-待执行；S-补录；R-拒绝；O-成功；C-成功（待核实）；X-失败 二代 往行外转账失败）；其他为 （O-成功；X-失败）
		set.add("fydm");//法院代码
		set.add("fymc");//法院名称
		set.add("ckwh");//裁定文书号
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
			Afp010Dto request = this.getUnkMsgByAFP012(Msg);
			if (!SUCCEED.equals(request.getErrorcode())) {
				//获取异常报文的body
				String err_body = getBodyStrByAFP012(request);
				//组装异常报文
				re_msg = getResponseMsgRes(senderId, request.getSenderId(), TRANS_OCDE, request.getSenderSN(), err_body);
			} else {
				//处理数据
				Afp010Dto response = this.getDtoFromDB(request);
				//生成报文body
				String body = this.getBodyStrByAFP012(response);
				//组装响应报文
				re_msg = this.getResponseMsgRes(senderId, request.getSenderId(), TRANS_OCDE, request.getSenderSN(), body);
			}
		} catch (Exception e) {
			logger.error("报文解析异常：" + e.getMessage(), e);
		}
		
		return re_msg;
	}
	
	/**
	 * 解析AFP012接口请求数据
	 * 
	 * @param msg
	 * @return
	 * @throws Exception
	 * @author yinxiong
	 * @date 2017年6月20日 下午5:16:05
	 */
	private Afp010Dto getUnkMsgByAFP012(String msg) throws Exception {
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
	private String getBodyStrByAFP012(Afp010Dto response) {
		//生成body
		StringBuffer buff = new StringBuffer();
		buff.append("<soapenv:Body>");
		buff.append("<gateway:NoAS400>");
		buff.append(getGatewayTag("errorcode", response.getErrorcode()));
		buff.append(getGatewayTag("errormsg", response.getErrormsg()));
		buff.append(getGatewayTag("filename", response.getFilename()));
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
	 * 导出控制明细信息<br>
	 * 生成TXT文本，以“|”分隔<br>
	 * 没有查询到数据时，生成一个空文件
	 * 
	 * @param request
	 * @return
	 */
	private Afp010Dto getDtoFromDB(Afp010Dto request) {
		Afp010Dto response = new Afp010Dto();
		response.setErrorcode(SUCCEED);
		try {
			List<Afp007QueryDto> resultList = busiDao.selectList(namespace + "selectKZInfoByInterface", request);
			if (resultList != null && resultList.size() > 0) {
				List<String> list = this.getSeparationList(resultList, SYMBOL);
				//设置文件生成路径及文件名
				String fileIOName = "AFPTXT0";//自定义业务类型
				String root = codeService.getCodeValue("Dpara", "1");//取根路径
				String srcPath = root + File.separatorChar + "webtemp" + File.separatorChar + DtUtils.getNowDate("yyyyMMdd") + File.separatorChar + "TELE";
				String srcName = "AFPS.TELE.AFPTXT.S" + DtUtils.getNowDate("yyMMdd") + ".G" + DtUtils.getNowDate("HHmmss");
				this.getTxt(list, srcPath, srcName);
				//调用文服，推送附件
				boolean flag = tools.sendFile(srcPath, srcName, destPath, srcName, taskId, sysId, fileIOName, encoding);
				//封装响应消息
				if (flag) {
					response.setFilename(srcName);
					response.setErrorcode(SUCCEED);
				} else {
					response.setErrorcode("WF01");
					response.setErrormsg("文服发送失败！");
				}
			} else {
				response.setErrorcode("DB05");
				response.setErrormsg("未查询到记录，无法导出！");
			}
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
		
		//查询日期处理
		String begindate = request.getBegindate().trim();
		String enddate = request.getEnddate().trim();
		if (!StringUtils.isBlank(begindate)) {
			//10位日期补成19位
			if (begindate.length() == 10) {
				request.setBegindate(begindate + " 00:00:00");
			}
		}
		if (StringUtils.isBlank(enddate)) {
			request.setEnddate(DtUtils.getNowTime());
		} else {
			if (enddate.length() == 10) {
				request.setEnddate(enddate + " 23:59:59");
			}
		}
		
		request.setErrorcode(SUCCEED);
		request.setErrormsg("");
		return request;
	}
	
	/**
	 * 将字段以分隔符号拼接
	 * 
	 * @param datalist
	 * @param Separate 分隔符号
	 * @return
	 * @author yinxiong
	 * @date 2017年7月8日 下午5:48:06
	 */
	private List<String> getSeparationList(List<Afp007QueryDto> datalist, String Separate) {
		List<String> list = null;
		if (datalist != null && datalist.size() > 0) {
			list = Lists.newArrayList();
			for (Afp007QueryDto dto : datalist) {
				StringBuilder sb = new StringBuilder();
				sb.append(dto.getBdhm()).append(Separate);//控制请求单号
				sb.append(dto.getCcxh()).append(Separate);//序号
				sb.append(dto.getKzlx()).append(Separate);//控制类型
				sb.append(dto.getXm()).append(Separate);//被查询人姓名
				sb.append(dto.getZjlx()).append(Separate);//证件类型
				sb.append(dto.getDsrzjhm()).append(Separate);//被查询人证件/组织机构号码
				sb.append(dto.getKhzh()).append(Separate);//被执行人开户账号
				sb.append(dto.getGlzhhm()).append(Separate);//被执行人开户账号子账号
				sb.append(dto.getZhlx()).append(Separate);//被执行人开户账号类型
				sb.append(dto.getKhwd()).append(Separate);//被执行人开户网点
				sb.append(dto.getKhwddm()).append(Separate);//被执行人开户网点代码
				sb.append(dto.getKznr()).append(Separate);//申请控制内容
				sb.append(dto.getKsrq()).append(Separate);//申请控制开始时间
				sb.append(dto.getJsrq()).append(Separate);//申请控制结束时间
				sb.append(dto.getBz()).append(Separate);//申请控制金额币种
				sb.append(dto.getJe()).append(Separate);//申请控制金额（数额）
				sb.append(dto.getSfjh()).append(Separate);//是否结汇
				sb.append(dto.getFymc()).append(Separate);//执行法院名称
				sb.append(dto.getFydm()).append(Separate);//执行法院代码
				sb.append(dto.getCbr()).append(Separate);//承办法官
				sb.append(dto.getYhdh()).append(Separate);//承办法官联系电话
				sb.append(dto.getAh()).append(Separate);//执行案号
				sb.append(dto.getGzzbh()).append(Separate);//承办法官工作证编号
				sb.append(dto.getGwzbh()).append(Separate);//承办法官公务证编号
				sb.append(dto.getLxfs()).append(Separate);//承办人联系地址
				sb.append(dto.getCkwh()).append(Separate);//裁定书文号
				sb.append(dto.getZxkzhhm()).append(Separate);//收款专户户名
				sb.append(dto.getZxkzhkhh()).append(Separate);//收款专户开户行
				sb.append(dto.getZxkzhkhhhh()).append(Separate);//收款专户开户行行号
				sb.append(dto.getZxkzhzh()).append(Separate);//收款专户账号
				sb.append(dto.getZxkzhlx()).append(Separate);//收款专户类型
				sb.append(dto.getSxzh()).append(Separate);//收息账号
				sb.append(dto.getSxzhmc()).append(Separate);//收息账户名
				sb.append(dto.getSxzhkhhh()).append(Separate);//收息账户开户行号
				sb.append(dto.getSxzhkhhmc()).append(Separate);//收息账户开户行名称
				sb.append(dto.getUserid()).append(Separate);//操作员
				sb.append(dto.getCheckuserid()).append(Separate);//复合员
				sb.append(dto.getYdjah()).append(Separate);//原冻结案号
				sb.append(dto.getYdjdh()).append(Separate);//原冻结请求单号
				sb.append(dto.getWnkzyy()).append(Separate);//失败原因
				sb.append(dto.getStatus()).append(Separate);//处理结果
				sb.append(dto.getRecipient_time()).append(Separate);//任务时间
				sb.append(dto.getKzcs()).append(Separate);;//控制措施
				sb.append(dto.getZcmc()).append(Separate);//金融资产名称
				sb.append(dto.getZclx()).append(Separate);//金融资产类型
				sb.append(dto.getCpxszl()).append(Separate);//产品销售种类
				sb.append(dto.getDqh()).append(Separate);//地区号
				sb.append(dto.getJrcpbh()).append(Separate);//金融产品编号
				sb.append(dto.getLczh()).append(Separate);//理财账号
				sb.append(dto.getZjhkzh()).append(Separate);//资金回款账户
				sb.append(dto.getSe()).append(Separate);//申请控制数量/份额/金额
				sb.append(dto.getJldw());//计量单位

				list.add(sb.toString());
			}
		}
		return list;
	}
	
	/**
	 * 生成文本文件
	 * 
	 * @param list
	 * @param localpath
	 * @param filename
	 * @return
	 * @author yinxiong
	 * @date 2017年7月8日 下午5:47:40
	 */
	private void getTxt(List<String> list, String localpath, String filename) {
		File file = new File(localpath);
		if (!file.exists() || !file.isDirectory()) {// 保证目录存在
			file.mkdirs();
		}
		try {
			File outFile = new File(localpath + File.separator + filename);
			if (list != null && list.size() > 0) {
				String encoding = "GB18030";
				FileUtils.writeLines(outFile, encoding, list);
			}
		} catch (IOException e) {
			logger.info("AFP012生成文件异常" + e.getMessage(), e);
		}
	}
}
