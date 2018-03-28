/*
 * =============================================
 * Copyright (c) 2014-2015 by CITIC All rights reserved.
 * Created [2017-04-12]
 * =============================================
 */

package citic.cgb.xmlmsg.service.impl;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

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
import citic.cgb.face.domain.Cgb_face_data_AFP;
import citic.cgb.face.domain.Cgb_face_group_rel;
import citic.cgb.face.domain.Cgb_face_img;
import citic.cgb.tools.ImageQuary;

/**
 * @author yinxiong
 * @date 2017年4月12日 下午3:52:27
 */
@Service("afp004")
public class AFP004InterfaceService extends AFPService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6386258000208963465L;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ImageQuary imageQuary;
	
	/** map命名空间 */
	private String namespace = "citic.cgb.face.mapper.busi.Cgb_face_dataMapper.";
	
	private final String TRANS_OCDE = "AFP004";//交易代码【6位接口编号】
	private final String senderId = "AFPM";//客户端系统标识
	private final String SUCCEED = "0000";//0000：成功  其他代码：失败
	private String IMGPATH = "webtemp" + File.separatorChar + "checkface";//人脸识别图片上传路径
	private final String IMGFORMAT = ".png";//默认文件格式
	private Set<String> set = null;//请求字段set
	
	/**
	 * 构造接口输入字段的set<br>
	 * 若接口变更，此处需要变更
	 */
	private AFP004InterfaceService() {
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
		set.add("assist_img_id");//辅助图像id
		set.add("similarity");//相似度
		set.add("similarity_id_1");//相似图片ID_1
		set.add("similarity_id_2");//相似图片ID_2
		set.add("similarity_id_3");//相似图片ID_3
		set.add("similarity_id_4");//相似图片ID_4
		set.add("similarity_id_5");//相似图片ID_5
		set.add("assist_batch_id");//辅助图像批次号
		set.add("remark");//其他说明
	}
	
	/**
	 * 柜面认定数据入库<br>
	 * 1.解析报文，获取所有数据<br>
	 * 2.生成组号，将数据入库<br>
	 * 3.生成响应报文
	 * 
	 * @param Msg
	 * @return
	 * @author yinxiong
	 * @date 2017年4月12日 下午4:22:21
	 */
	@Override
	public String messageReceived(String Msg) {
		String re_msg = "";
		try {
			//解析xml，获取请求对象
			Cgb_face_data_AFP request = this.getUnkMsgByAFP004(Msg);
			if (!SUCCEED.equals(request.getErrorcode())) {
				//获取异常报文的body
				String err_body = getBodyStr(request);
				//组装异常报文
				re_msg = getResponseMsgRes(senderId, request.getSenderId(), TRANS_OCDE, request.getSenderSN(), err_body);
			} else {
				//辅助图像处理
				this.dealAssistImg(request.getSuspect_img_id(), request.getAssist_batch_id());
				//插入数据
				Cgb_face_data_AFP response = this.InsertDBFromDto(request);
				//生成报文body
				String body = this.getBodyStr(response);
				//组装响应报文
				re_msg = this.getResponseMsgRes(senderId, request.getSenderId(), TRANS_OCDE, request.getSenderSN(), body);
				
			}
		} catch (Exception e) {
			logger.error("报文解析异常：" + e.getMessage(), e);
		}
		
		return re_msg;
	}
	
	/**
	 * 解析AFP004接口请求数据
	 * 
	 * @param msg
	 * @return
	 * @throws Exception
	 * @author yinxiong
	 * @date 2017年4月13日 下午5:15:41
	 */
	private Cgb_face_data_AFP getUnkMsgByAFP004(String msg) {
		Cgb_face_data_AFP request = null;
		try {
			//解析xml，获取查询信息
			request = this.getRequestMsg(msg);
			String errorcode = SUCCEED;
			String errormsg = "";
			//校验数据 简单的必输校验
			if (StringUtils.isBlank(request.getSuspect_img_id())) {
				request.setErrorcode("S001");
				request.setErrormsg("suspect_img_id必输");//
				return request;
			}
			if (StringUtils.isBlank(request.getVictim_img_id())) {
				request.setErrorcode("S002");
				request.setErrormsg("victim_img_id必输");//
				return request;
			}
			if (StringUtils.isBlank(request.getVictim_name())) {
				request.setErrorcode("S002");
				request.setErrormsg("victim_name必输");//
				return request;
			}
			if (StringUtils.isBlank(request.getVictim_card_type())) {
				request.setErrorcode("S003");
				request.setErrormsg("victim_card_type必输");//
				return request;
			}
			if (StringUtils.isBlank(request.getVictim_card_num())) {
				request.setErrorcode("S004");
				request.setErrormsg("victim_card_num必输");//
				return request;
			}
			if (StringUtils.isBlank(request.getBusi_website())) {
				request.setErrorcode("S005");
				request.setErrormsg("busi_website必输");//
				return request;
			}
			if (StringUtils.isBlank(request.getBusi_teller_num())) {
				request.setErrorcode("S006");
				request.setErrormsg("busi_teller_num必输");//
				return request;
			}
			if (StringUtils.isBlank(request.getBusi_time())) {
				request.setErrorcode("S007");
				request.setErrormsg("busi_time必输");//
				return request;
			}
			if (StringUtils.isBlank(request.getBusi_way())) {
				request.setErrorcode("S008");
				request.setErrormsg("busi_way必输");//
				return request;
			}
			request.setErrorcode(errorcode);
			request.setErrormsg(errormsg);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return request;
	}
	
	private String getBodyStr(Cgb_face_data_AFP response) {
		//生成body
		StringBuffer buff = new StringBuffer();
		buff.append("<soapenv:Body>");
		buff.append("<gateway:NoAS400>");
		buff.append(getGatewayTag("errorcode", response.getErrorcode()));//处理结果 0：无结果 1：成功
		buff.append(getGatewayTag("errormsg", response.getErrormsg()));//备注
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
	
	/**
	 * 插入上报数据
	 * 
	 * @param request
	 * @return
	 * @author yinxiong
	 * @date 2017年4月13日 下午5:06:56
	 */
	@BusiTx
	private Cgb_face_data_AFP InsertDBFromDto(Cgb_face_data_AFP request) {
		Cgb_face_data_AFP response = new Cgb_face_data_AFP();
		response.setErrorcode(SUCCEED);
		try {
			String group_id = this.getGroupID("SEQ_CGB_FACE_GROUP");//生成组号
			request.setGroup_id(group_id);
			request.setData_source("2");//1:人工新增 2：系统上传 3：高清拍摄
			request.setAdd_time(DtUtils.getNowTime());//19位提交时间
			request.setCheck_result("1");//1：待审核 2：审核通过 3：审核不通过
			request.setFirmly_flag("1");//认定状态 0：未认定 1：已认定
			request.setMd_channel(request.getSenderId());//名单建库渠道
			request.setRm_flag("0");//出库标识 
			//插入主表信息
			busiDao.insert(namespace + "insertCgb_face_dataByInterface", request);
			//插入组信息
			busiDao.insert(namespace + "InsertCgb_face_groupByInterface", request);
			//插入关系信息
			List<Cgb_face_group_rel> list = this.getRelList(request);
			busiDao.insert(namespace + "insertCgb_face_group_relByBatch", list);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			response.setErrorcode("0001");//0：查询失败  1：查询成功
			response.setErrormsg("数据入库失败");//
		}
		return response;
	}
	
	/**
	 * 获取10位长度的组号
	 * 
	 * @param seqName
	 * @return
	 * @throws Exception
	 * @author yinxiong
	 * @date 2017年4月14日 下午2:03:19
	 */
	private String getGroupID(String seqName) throws Exception {
		int init_len = 10;//定义组号长度
		String seq = this.getSequenceValus("SEQ_CGB_FACE_GROUP");
		int x = seq.length();//序列长度
		StringBuilder sb = new StringBuilder("G");
		for (int i = 0; i < (init_len - x - 1); i++) {
			sb.append("0");
		}
		return sb.toString() + seq;
	}
	
	/**
	 * 获取分组关系list
	 * 
	 * @param request
	 * @return
	 * @author yinxiong
	 * @date 2017年4月14日 下午3:37:07
	 */
	private List<Cgb_face_group_rel> getRelList(Cgb_face_data_AFP request) {
		List<Cgb_face_group_rel> list = new ArrayList<Cgb_face_group_rel>();
		Cgb_face_group_rel rel = new Cgb_face_group_rel();
		int i = 1;
		rel.setGroup_id(request.getGroup_id());
		rel.setSuspect_img_id(request.getSuspect_img_id());
		rel.setNum(i);
		rel.setIs_main("1");
		list.add(rel);
		if (!StringUtils.isBlank(request.getSimilarity_id_1())) {
			Cgb_face_group_rel rel2 = new Cgb_face_group_rel();
			rel2.setGroup_id(request.getGroup_id());
			rel2.setSuspect_img_id(request.getSimilarity_id_1());
			rel2.setNum(++i);
			rel2.setIs_main("0");
			list.add(rel2);
		}
		if (!StringUtils.isBlank(request.getSimilarity_id_2())) {
			Cgb_face_group_rel rel2 = new Cgb_face_group_rel();
			rel2.setGroup_id(request.getGroup_id());
			rel2.setSuspect_img_id(request.getSimilarity_id_2());
			rel2.setNum(++i);
			rel2.setIs_main("0");
			list.add(rel2);
		}
		if (!StringUtils.isBlank(request.getSimilarity_id_3())) {
			Cgb_face_group_rel rel2 = new Cgb_face_group_rel();
			rel2.setGroup_id(request.getGroup_id());
			rel2.setSuspect_img_id(request.getSimilarity_id_3());
			rel2.setNum(++i);
			rel2.setIs_main("0");
			list.add(rel2);
		}
		if (!StringUtils.isBlank(request.getSimilarity_id_4())) {
			Cgb_face_group_rel rel2 = new Cgb_face_group_rel();
			rel2.setGroup_id(request.getGroup_id());
			rel2.setSuspect_img_id(request.getSimilarity_id_4());
			rel2.setNum(++i);
			rel2.setIs_main("0");
			list.add(rel2);
		}
		if (!StringUtils.isBlank(request.getSimilarity_id_5())) {
			Cgb_face_group_rel rel2 = new Cgb_face_group_rel();
			rel2.setGroup_id(request.getGroup_id());
			rel2.setSuspect_img_id(request.getSimilarity_id_5());
			rel2.setNum(++i);
			rel2.setIs_main("0");
			list.add(rel2);
		}
		return list;
	}
	
	/**
	 * 辅助证件照处理
	 * 
	 * @param batch_id
	 * @author yinxiong
	 * @date 2017年6月18日 下午1:33:32
	 */
	public void dealAssistImg(String suspect_img_id, String busiSerialNo) {
		if (!StringUtils.isBlank(busiSerialNo)) {
			try {
				List<String> list = imageQuary.getImgUrlByBusiSerialNo(busiSerialNo);
				if (list != null && list.size() > 0) {
					for (int i = 0; i < list.size(); i++) { // 插入附件信息
						String imgId = UUID.randomUUID().toString().replaceAll("-", "");
						String fileName = imgId + IMGFORMAT;
						imageQuary.insertImgToFile(list.get(i), IMGPATH, fileName);
						//封装信息
						Cgb_face_img img = new Cgb_face_img();
						img.setImg_id(imgId);
						img.setImg_type("3");//1.嫌疑人照片 2.受害人照片 3.辅助证件照片
						img.setImg_path(IMGPATH + File.separatorChar + fileName);
						img.setImg_name(fileName);
						img.setSuspect_img_id(suspect_img_id);
						//插入图片路径信息
						busiDao.insert(namespace + "insertCgb_face_imgByInterface", img);
						//插入辅助信息
						busiDao.insert(namespace + "insertCgb_face_assistByInterface", img);
					}
				}
			} catch (Exception e) {
				logger.error("获取影像发生异常", e);
			}
		}
	}
	
}
