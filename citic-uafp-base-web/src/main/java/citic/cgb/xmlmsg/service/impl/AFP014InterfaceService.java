package citic.cgb.xmlmsg.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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

import citic.base.utils.DtUtils;
import citic.base.utils.ZipUtil;
import citic.cgb.tools.WfTools;
import citic.cgb.xmlmsg.domain.AFP009AttachDto;
import citic.cgb.xmlmsg.domain.Afp009Dto;
import citic.core.service.CodeService;

@Service("afp014")
public class AFP014InterfaceService extends AFPService {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -5745141039520766877L;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private WfTools tools;
	@Autowired
	private CodeService codeService;
	
	/** map命名空间 */
	private String namespace = "citic.cgb.xmlmsg.mapper.busi.Afp007DtoMapper.";
	//交易代码【6位接口编号】
	private final String TRANS_OCDE = "AFP014";
	private final String senderId = "AFPM";//客户端系统标识
	private final String SUCCEED = "0000";//0000：成功  其他代码：失败
	private final String destPath = "/cdadmin/UFSM/TELE/save/AFPS";//目标目录路径
	private final String taskId = "P7CQ0KKV";// taskid从UFS获取
	private final String encoding = "GB18030";
	private final String sysId = "TELE";//对端系统标识
 	private Set<String> set = null;//请求字段set
	
	/**
	 * 构造接口输入字段的set<br>
	 * 若接口变更，此处需要变更
	 */
	private AFP014InterfaceService() {
		set = new HashSet<String>();
		set.add("bdhm");//控制请求单号
		set.add("wsbh");//文书编号
		set.add("filetype");//附件类型：1-文书，2-证件
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
	 * @date 2017年9月11日 下午20:45:20
	 */
	@Override
	public String messageReceived(String Msg) {
		String re_msg = "";
		try {
			//解析xml，获取查询对象
			Afp009Dto request = this.getUnkMsgByAFP009(Msg);
			if (!SUCCEED.equals(request.getErrorcode())) {
				//获取异常报文的body
				String err_body = getBodyStrByAFP009(request);
				//组装异常报文
				re_msg = getResponseMsgRes(senderId, request.getSenderId(), TRANS_OCDE, request.getSenderSN(), err_body);
			} else {
				//处理数据
				Afp009Dto response = this.getDtoFromDB(request);
				//生成报文body
				String body = this.getBodyStrByAFP009(response);
				//组装响应报文
				re_msg = this.getResponseMsgRes(senderId, request.getSenderId(), TRANS_OCDE, request.getSenderSN(), body);
			}
		} catch (Exception e) {
			logger.error("报文解析异常：" + e.getMessage(), e);
		}
		
		return re_msg;
	}
	/**
	 * 解析AFP014接口请求数据
	 * 
	 * @param msg
	 * @return
	 * @throws Exception
	 * @author yinxiong
	 * @date 2017年9月11日 下午5:16:05
	 */
	private Afp009Dto getUnkMsgByAFP009(String msg) throws Exception {
		Afp009Dto request = null;
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
	 * @date 2017年9月11日 下午3:23:21
	 */
	private String getBodyStrByAFP009(Afp009Dto response) {
		//生成body
		StringBuffer buff = new StringBuffer();
		buff.append("<soapenv:Body>");
		buff.append("<gateway:NoAS400>");
		buff.append(getGatewayTag("errorcode", response.getErrorcode()));
		buff.append(getGatewayTag("errormsg", response.getErrormsg()));
		buff.append(getGatewayTag("filename", response.getFilename()));//文件名
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
	private Afp009Dto getRequestMsg(String soapXML) {
		Afp009Dto request = new Afp009Dto();
		try {
			SOAPMessage msg = this.formatSoapString(soapXML);
			//解析header的数据
			SOAPHeader header = msg.getSOAPHeader();
			Iterator<SOAPElement> it_header = header.getChildElements();
			parseHeader(it_header, request);
			//解析body的数据
			SOAPBody body = msg.getSOAPBody();
			Iterator<SOAPElement> it_body = body.getChildElements();
			parseBody(it_body, request,set);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return request;
	}
	
	/**
	 * 查询受害人信息<br>
	 * 查询存在待审核记录却没有黑灰名单记录的数据<br>
	 * 最大查询记录数为20
	 * 
	 * @param request
	 * @return
	 */
	private Afp009Dto getDtoFromDB(Afp009Dto request) {
		Afp009Dto response = new Afp009Dto();
		List<AFP009AttachDto> resultList = null;
		//查询附件路径
		try {
			if("1".equals(request.getFiletype())){
				resultList = busiDao.selectList(namespace + "selectCxWsInfoByInterface", request);
			}else if("2".equals(request.getFiletype())){
				resultList = busiDao.selectList(namespace + "selectCxGzzInfoByInterface", request);
			}
            if(resultList != null && resultList.size()>0){
            	String fileIOName = "AFPWAR0";//自定义业务类型
    			String srcName = "AFPS.TELE.AFPWAR.S" + DtUtils.getNowDate("yyMMdd") + ".G" + DtUtils.getNowDate("HHmmss");
    			String root = codeService.getCodeValue("Dpara", "1");//取根路径
    			String srcPath = root+File.separator+"webtemp"+File.separatorChar+DtUtils.getNowDate("yyyyMMdd")+File.separatorChar+"TELE";
    			String desZipPath = srcPath+File.separatorChar+srcName;//压缩包绝对路径
    			String destName = srcName;
    			//保证路径存在
    			File f = new File(srcPath);
    			if(!f.exists()){
    				f.mkdirs();
    			}
    			List<String> list = new ArrayList<String>(resultList.size());
    			for(AFP009AttachDto dto : resultList){
    				list.add(root+dto.getFilepath());
    			}
    			//多文件压缩
    			ZipUtil.zip(desZipPath,list,"");
    			
    			//调用文服，推送附件
    			boolean flag = tools.sendFile(srcPath, srcName, destPath, destName, taskId, sysId, fileIOName, encoding);
    			//封装响应消息
    			if(flag){
    				response.setFilename(srcName);
    				response.setErrorcode(SUCCEED);
    			}else{
    				response.setErrorcode("WF01");
    				response.setErrormsg("文服发送失败！");
    			}
            }else{
            	response.setErrorcode("DB03");
    			response.setErrormsg("附件信息不存在！");
            }
		} catch (Exception e) {
			response.setErrorcode("DB04");
			response.setErrormsg("文件处理异常！");
			logger.error(e.getMessage(), e);
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
	private Afp009Dto validateRequestMsg(Afp009Dto request){
		
		if(StringUtils.isBlank(request.getFiletype())){
			request.setErrorcode("Q021");
			request.setErrormsg("filetype不能为空");
			return request;
		}
		//附件类型为文书时，wshb必输；为证件时，bdhm必输
		if("1".equals(request.getFiletype())){
			if(StringUtils.isBlank(request.getWsbh())){
				request.setErrorcode("Q022");
				request.setErrormsg("wsbh不能为空");
				return request;
			}
		}else{
			if(StringUtils.isBlank(request.getBdhm())){
				request.setErrorcode("Q023");
				request.setErrormsg("bdhm不能为空");
				return request;
			}
		}
		request.setErrorcode(SUCCEED);
		request.setErrormsg("");
		return request;
	}
	
}
