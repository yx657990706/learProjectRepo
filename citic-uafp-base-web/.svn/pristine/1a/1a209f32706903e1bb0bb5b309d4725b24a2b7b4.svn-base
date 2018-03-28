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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import citic.base.utils.DtUtils;
import citic.cgb.face.domain.Cgb_face_data_AFP;
import citic.cgb.face.domain.Cgb_face_request_log;

@Service("afp011")
public class AFP011InterfaceService extends AFPService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3773957260740841769L;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/** map命名空间 */
	private String namespace = "citic.cgb.face.mapper.busi.Cgb_face_dataMapper.";
	//交易代码【6位接口编号】
	private final String TRANS_OCDE = "AFP011";
	private final String senderId = "AFPM";//客户端系统标识
	private final String SUCCEED = "0000";//0000：成功  其他代码：失败
	private Set<String> set = null;//请求字段set
	
	/**
	 * 构造接口输入字段的set<br>
	 * 若接口变更，此处需要变更
	 */
	private AFP011InterfaceService() {
		set = new HashSet<String>();
		set.add("suspect_img_id");//嫌疑人图像ID
		set.add("victim_img_id");//受害人图像ID
		set.add("victim_name");//受害人姓名
		set.add("victim_card_type");//受害人证件类型
		set.add("victim_card_num");//受害人证件号码
		set.add("victim_card_validity");//受害人证件有效期
		set.add("busi_website");//业务办理网点
		set.add("busi_teller_num");//业务办理柜员号
		set.add("busi_time");//业务办理时间
		set.add("busi_type");//业务办理类型
		set.add("busi_way");//业务办理渠道
		set.add("telephone");//联系电话
		set.add("address");//联系地址
		set.add("fingerprint");//指纹信息
		set.add("assist_card_type");//辅助证件类型
		set.add("assist_card_num");//辅助证件号码
		set.add("assist_img_id");//辅助图像批次号
		set.add("similarity");//相似度
		set.add("similarity_id_1");//相似图片ID_1
		set.add("similarity_id_2");//相似图片ID_2
		set.add("similarity_id_3");//相似图片ID_3
		set.add("similarity_id_4");//相似图片ID_4
		set.add("similarity_id_5");//相似图片ID_5
	}
	
	/**
	 * 解析AFP011接口请求数据
	 * 
	 * @param msg
	 * @return
	 * @throws Exception
	 * @author yinxiong
	 * @date 2017年4月13日 下午5:16:05
	 */
	private Cgb_face_data_AFP getUnkMsgByAFP005(String msg) throws Exception {
		Cgb_face_data_AFP request = null;
		Cgb_face_request_log log = null;
		try {
			//解析xml，获取查询信息
			request = this.getRequestMsg(msg);
			//获取访问系统的系统标识
			String sys_code = request.getSenderId();
			//查询条件
			String victim_card_num = request.getVictim_card_num();
			
			//记录接口访问日志
			log = new Cgb_face_request_log();
			StringBuffer buff = new StringBuffer();
			log.setSys_code(sys_code);//请求来源系统
			log.setTrans_code(TRANS_OCDE);//交易代码
			log.setQuery_time(DtUtils.getNowTime());//查询时间
			log.setSender_sn(request.getSenderSN());//发起方交易流水
			
			if (StringUtils.isBlank(victim_card_num)) {
				request.setErrorcode("0002");
				request.setErrormsg("查询条件为空");
				request.setCount("0");//记录数
				buff.append("victim_card_num").append(":").append(victim_card_num);
				log.setQuery_condition(buff.toString());
				log.setRemark(request.getErrormsg());
			} else {
				request.setErrorcode(SUCCEED);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new Exception("报文截取转换过程发生异常，请检查报文数据");
		}
		
		//日志入库
		this.insertCgb_face_request_log(log);
		
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
	private String getBodyStrByAFP011(Cgb_face_data_AFP response) {
		//生成body
		StringBuffer buff = new StringBuffer();
		buff.append("<soapenv:Body>");
		buff.append("<gateway:NoAS400>");
		buff.append(getGatewayTag("errorcode", response.getErrorcode()));
		buff.append(getGatewayTag("errormsg", response.getErrormsg()));
		List<Cgb_face_data_AFP> list = response.getQuarylist();
		if (list != null && list.size() > 0) {
			buff.append(getGatewayTag("count", list.size() + ""));//记录数
			for (Cgb_face_data_AFP afp005 : list) {
				buff.append(getGatewayTag("suspect_img_id", afp005.getSuspect_img_id()));//嫌疑人图像ID
				buff.append(getGatewayTag("victim_img_id", afp005.getVictim_img_id()));//受害人图像ID
				buff.append(getGatewayTag("victim_name", afp005.getVictim_name()));//受害人姓名
				buff.append(getGatewayTag("victim_card_type", afp005.getVictim_card_type()));//受害人证件类型
				buff.append(getGatewayTag("victim_card_num", afp005.getVictim_card_num()));//受害人证件号码
				buff.append(getGatewayTag("victim_card_validity", afp005.getVictim_card_validity()));//受害人证件有效期
				buff.append(getGatewayTag("busi_website", afp005.getBusi_website()));//业务办理网点
				buff.append(getGatewayTag("busi_teller_num", afp005.getBusi_teller_num()));//业务办理柜员号
				buff.append(getGatewayTag("busi_time", afp005.getBusi_time()));//业务办理时间
				buff.append(getGatewayTag("busi_type", afp005.getBusi_type()));//业务办理类型
				buff.append(getGatewayTag("risk_type", afp005.getRisk_type()));//风险类型
				buff.append(getGatewayTag("telephone", afp005.getTelephone()));//联系电话
				buff.append(getGatewayTag("address", afp005.getAddress()));//联系地址
				buff.append(getGatewayTag("fingerprint", afp005.getFingerprint()));//指纹信息
				buff.append(getGatewayTag("assist_card_type", afp005.getAssist_card_type()));//辅助证件类型
				buff.append(getGatewayTag("assist_card_num", afp005.getAssist_card_num()));//辅助证件号码
			}
		} else {
			buff.append(getGatewayTag("count", "0"));//默认记录数
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
	private Cgb_face_data_AFP getRequestMsg(String soapXML) {
		Cgb_face_data_AFP request = new Cgb_face_data_AFP();
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
	private Cgb_face_data_AFP getDtoFromDB(Cgb_face_data_AFP request) {
		Cgb_face_data_AFP response = new Cgb_face_data_AFP();
		response.setErrorcode(SUCCEED);//0：查询失败  1：查询成功
		
		List<Cgb_face_data_AFP> list = busiDao.selectList(namespace + "selectCheckingStatusByInterface", request.getVictim_card_num());
		//将list封装到对象，并设置查询结果和记录数
		if (list != null) {
			if (list.size() > 20) {
				list = list.subList(0, 20);
			}
			response.setCount(list.size() + "");//记录数
			response.setQuarylist(list);
		} else {
			response.setCount(0 + "");
		}
		return response;
	}
	
	/**
	 * 插入AFP011访问记录
	 * 
	 * @param log
	 * @author yinxiong
	 * @date 2017年6月16日 下午4:44:07
	 */
	public void insertCgb_face_request_log(Cgb_face_request_log log) {
		busiDao.insert(namespace + "insertCgb_face_request_log", log);
	}
	
	/**
	 * 根据证件号码查询受害人列表<br>
	 * 1.解析报文，获取所有数据<br>
	 * 2.根据证件号码查询list<br>
	 * 3.生成响应报文
	 * 
	 * @param Msg
	 * @return
	 * @author yinxiong
	 * @date 2017年4月12日 下午4:25:20
	 */
	@Override
	public String messageReceived(String Msg) {
		String re_msg = "";
		try {
			//解析xml，获取查询对象
			Cgb_face_data_AFP request = this.getUnkMsgByAFP005(Msg);
			if (!SUCCEED.equals(request.getErrorcode())) {
				//获取异常报文的body
				String err_body = getBodyStrByAFP011(request);
				//组装异常报文
				re_msg = getResponseMsgRes(senderId, request.getSenderId(), TRANS_OCDE, request.getSenderSN(), err_body);
			} else {
				//查询数据
				Cgb_face_data_AFP response = this.getDtoFromDB(request);
				//生成报文body
				String body = this.getBodyStrByAFP011(response);
				//组装响应报文
				re_msg = this.getResponseMsgRes(senderId, request.getSenderId(), TRANS_OCDE, request.getSenderSN(), body);
				
			}
		} catch (Exception e) {
			logger.error("报文解析异常：" + e.getMessage(), e);
		}
		
		return re_msg;
	}
	
}
