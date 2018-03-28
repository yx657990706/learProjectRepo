/**========================================================
 * Copyright (c) 2014-2015 by CITIC All rights reserved.
 * Created Date : 2015年9月7日
 * Description: 
 * 
 *=========================================================
 */
package citic.aml.sso.service;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang3.StringUtils;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import citic.base.utils.DtUtils;
//import citic.base.utils.SftpUtils;
import citic.core.service.CodeService;
import citic.dxzp.cases.domain.Br22_attach;
import citic.dxzp.cases.domain.Br22_case;
import citic.dxzp.cases.service.Br22_case_cgbService;
import citic.dxzp.datainfo.domain.Bb21_trans;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sunyard.TransEngine.client.ClientApi;
import com.sunyard.TransEngine.doc.ECMDoc;
import com.sunyard.TransEngine.util.OptionKey;



/**
 * @author gaojx
 * 柜员处理类
 */
public class CaseHandler extends IoHandlerAdapter {
	private final Logger logger = LoggerFactory.getLogger(CaseHandler.class);
	
	/**影像开始标签*/
	private final String IMG_START_TAG ="URL=\"";
	/**影像结束标签*/
	private final String IMG_END_TAG ="\"";
	/**batch_id开始标签*/
	private final String BATCH_ID_START_TAG="BATCH_ID=\"";
	/**batch_id结束标签*/
	private final String BATCH_ID_END_TAG="\"";
	
	@Autowired
	private CodeService codeService;
	
	@Autowired
	private Br22_case_cgbService br22_case_cgbService;
	
	@Setter @Getter
	private String ip ;//影像系统ip
	@Setter @Getter
	private String port;//端口
	//影像系统取消了密码校验，口令无实际意义
	@Setter @Getter
	private String username = "admin";//用户名
	@Setter @Getter
	private String password = "111";//口令

	
	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		logger.error("处理时出现异常...");
		logger.error(cause.getMessage());
		session.close(true);
	}

	
	@Override
	public void sessionClosed(IoSession session) throws Exception {
		logger.warn("session 关闭 ...");
		session.close(true);
	}

	@Override
	public void messageReceived(IoSession session, Object message)  {
		// 1.反欺诈系统解析报文［去长度统计的纯报文］
		// 2.反欺诈解析出报文中影像ID，调用影像接口（调用两次），获取影像地址
		// 3.通过影像地址，获取影像（http方式下载），保存为附件。案件信息填入到相关信息表中（相当于审批通过）
		// 4.组装响应报文，返回接收成功消息给柜面系统
		String re_msg = "";
		try {
			String msg = (String) message;
			logger.debug("=========接收的消息========");
			Br22_case br22_case = new Br22_case();// 案件信息
			Bb21_trans bb21_trans = new Bb21_trans();// 交易信息
			String imgId = getUnkMsg(msg, br22_case, bb21_trans);// 解析报文获取信息
			logger.debug("=========解析的影像id========");
			//判断公安机构编码是否在马表中
            if(getToorgFlag(br22_case.getToorg())){
            	// 获取影像地址
    			List<String> imgUrlsList = getImgUrl(imgId);
    			// 生成附件信息
    			if (imgUrlsList != null && imgUrlsList.size() > 0) {
    				//插入案件。关系。交易。止付表数据
    				br22_case_cgbService.insertInfo(br22_case, bb21_trans);
    				
    				for(int i=0;i<imgUrlsList.size();i++){	// 插入附件信息
    					Map<String, String> map = insertImgToFile(imgUrlsList.get(i),i,br22_case.getCtid(),bb21_trans.getCardnumber());
    					Br22_attach attach = new Br22_attach();
    					attach.setCaseid(br22_case.getCaseid());//案件编号
    					attach.setFileno(UUID.randomUUID().toString());//文件编号
    					attach.setFilename(map.get("filename"));//文件名
    					attach.setFilepath(map.get("filepath"));//文件地址
    					attach.setCreate_dt(DtUtils.getNowDate());//创建日期
    					
    					br22_case_cgbService.insertFileAttach(attach);
    				}
    				logger.debug("附件处理成功");
    				 re_msg = getResponseMsg("1","");// 组装反馈报文
    			}
            }else{
            	 re_msg = getResponseMsg("0","公安机构编码不正确");// 组装反馈报文
            }
			
		} catch (Exception e) {
			 logger.error(e.getMessage(),e);
			 re_msg = getResponseMsg("0",e.getLocalizedMessage());
		}
	
		session.write(re_msg);
	}
	
	/**
	 * 解析报文获取信息
	 * 
	 * @param msg 报文
	 * @param br22_case 案件信息 
	 * @param bb21_trans 交易信息
	 * @return
	 * @throws Exception 
	 */
	private  String getUnkMsg(String msg,Br22_case br22_case,Bb21_trans bb21_trans) throws Exception{
		String imgId = "";

		
			try {
				byte[] bytes = msg.getBytes("UTF-8");
				String caseid = "c" +codeService.getSequenceValus("seq_br22_case");
				//报文头长76个字断，报文体从76算起
				br22_case.setToorg(new String(bytes, 76, 12).trim());//接收机构id
				//获取案件编号
				br22_case.setCaseid(caseid);
				br22_case.setCasename(new String(bytes, 88, 90).trim());//受害人姓名
				br22_case.setTelphone(new String(bytes, 178, 30).trim());//受害人联系电话
				br22_case.setCitp(new String(bytes, 208, 5).trim());//证件类型
				br22_case.setCtid(new String(bytes, 213, 30).trim());//证件号码
				br22_case.setEvent_desc(new String(bytes, 243, 450).trim());//事件描述
				//报文中存在，但数据不用存【内部已经定义好了统一的信息】。
//			br22_case.setOrgkey(new String(bytes, 693, 225);//上报机构名称
//			br22_case.set//经办人姓名 new String(bytes, 918, 60);
//			br22_case.set//经办人电话  new String(bytes, 978, 30);
				br22_case.setCreate_user( new String(bytes, 918, 60).trim());//1级流程，将经办人存为创建人
				
				bb21_trans.setTransactionserial(new String(bytes, 1008, 64).trim());//20-交易流水号
				String time = new String(bytes, 1072, 14).trim();//交易时间
				
				bb21_trans.setTransactiontime(DtUtils.toStrTimeStamp(time));//交易时间
				bb21_trans.setTransactiontype(new String(bytes, 1086, 20).trim());//交易类型 1-银行对账户充值;2-账户对账户转账;3-账户对银行提现
				bb21_trans.setCurrency(new String(bytes, 1106, 3).trim());//币种
				bb21_trans.setTransamt(new String(bytes, 1109, 18).trim());//交易金额
				bb21_trans.setOrgankey(new String(bytes, 1127, 12).trim());//账户所属银行机构编码
			    bb21_trans.setOrganname( new String(bytes, 1139, 225).trim());//账户所属银行名称 没有字段，不存了
				bb21_trans.setAccountname(new String(bytes, 1364, 100).trim());//账户名
				bb21_trans.setCardnumber(new String(bytes, 1464, 30).trim());//卡折号
				bb21_trans.setOpp_openbank_id(new String(bytes, 1494, 12).trim());//交易对端账户所属银行机构编码
				bb21_trans.setOpp_openbank(new String(bytes, 1506, 225).trim());//交易对端账户所属银行名称
				bb21_trans.setOpp_name(new String(bytes, 1731, 100).trim());//交易对端账户名
				bb21_trans.setOpp_cardnum(new String(bytes, 1831, 30).trim());//交易对端卡折号
				bb21_trans.setIpadress(new String(bytes, 1861, 30).trim());//IP地址
				bb21_trans.setMac(new String(bytes, 1891, 20).trim());//MAC地址
				bb21_trans.setTstp_type_f_cd(new String(bytes, 1911, 20).trim());//设备ID
				bb21_trans.setTransactionaddress(new String(bytes, 1931, 255).trim());//交易地点
				bb21_trans.setRemark(new String(bytes, 2186, 255).trim());//备注
				
				bb21_trans.setIsceased(new String(bytes, 2441, 1));//是否已止付
				bb21_trans.setHxappid(new String(bytes, 2442, 256));//冻结编号
				imgId = new String(bytes, 2698,255 ).trim();//影像id
			    bb21_trans.setAccountbalance(new String(bytes, 2953,18 ).trim());//交易余额
				
				br22_case.setMsg_type_cd("N"); //N:正常 D:取消
				br22_case.setDatasource("2");//1.系统 2.人工
				br22_case.setFeaturecodetype("4");//1:异常开卡 2:涉案账户 3:异常事件 4:案件举报
				br22_case.setOrgkey(bb21_trans.getOrgankey());//归属机构
				br22_case.setData_dt(DtUtils.getNowDate());
				br22_case.setStatus_cd("5");//走一级流程，直接变为5  0:未处理 1:待审核 2 待审批 3退回 4：排除 5待报送 6报送中 7报送成功 8报送失败
				br22_case.setCreate_dt(DtUtils.getNowTime());
				
				bb21_trans.setCaseid(caseid);//案件编号
				bb21_trans.setTrans_key("t"+codeService.getSequenceValus("seq_bb21_trans"));//交易key
				bb21_trans.setData_dt(DtUtils.getNowDate());//数据日期
				bb21_trans.setTx_dt(DtUtils.FormatDate(DtUtils.toDate(time), "yyyy-MM-dd"));//交易日期 交易时间截取
				bb21_trans.setIsceased(bb21_trans.getIsceased());//是否已止付
				bb21_trans.setValidate_id("1");//验证标志 0：未通过 1通过
				bb21_trans.setState_cd("1");//状态1：正常 4删除
				bb21_trans.setTransactionstatus("00");//交易是否成功 00-成功；01-失败
			} catch (Exception e) {
				logger.error(e.getMessage(),e);
				throw new Exception("报文截取转换过程发生异常，请检查报文数据");
			}
			
		return imgId;
	}
	

	/**
	 * 获取影像地址
	 * 
	 * @param imgId 影像id
	 * @return
	 * @throws Exception 
	 */
	private List<String> getImgUrl(String busiSerialNo) throws Exception {
		List<String> imgUrlsList = Lists.newArrayList();
		String[] imgBatchs = null;
		String imgxml = "";
		ClientApi api = new ClientApi(ip, port, username, password);
		ECMDoc doc = new ECMDoc();
		doc.setBusiAttribute("BUSI_SERIAL_NO", busiSerialNo); // 指定要查询的影像流水号
		doc.setObjName("SDSS");// 指定查询批次所属的业务模型名
		doc.setOption(OptionKey.QUERY_BATCH_FILE);// 指定查询类型为查询批次文件
		// 查询批次信息
		imgxml = api.queryBatch(doc);
		imgBatchs = StringUtils.substringsBetween(imgxml, BATCH_ID_START_TAG, BATCH_ID_END_TAG);
		if (imgBatchs != null && imgBatchs.length > 0) {
			for (String batchid : imgBatchs) {
				// 查询批次下的影像文件
				doc.setBatchID(batchid);// 指定要查询的批次号
				String imgUrlXml = api.queryFile(doc);

				String[] imgUrls = StringUtils.substringsBetween(imgUrlXml, IMG_START_TAG, IMG_END_TAG);// 截取图片的影像url用数组返回
				if (imgUrls != null && imgUrls.length > 0) {
					for (int i = 0; i < imgUrls.length; i++) {
						if(!StringUtils.contains(imgUrls[i] , ".xml")){//过滤掉xml
							imgUrls[i] = imgUrls[i].replaceAll("&amp;", "&").replaceAll("&lt;", "<")
									.replaceAll("&gt;", ">");
							imgUrlsList.add(imgUrls[i]);
						}
					}
				} else {
					logger.debug("============影像url不存在================");
					throw  new Exception("影像url不存在");
				}
			}
		} else {
			logger.debug("============根据影像流水查询批次号失败================");
			throw  new Exception("根据影像流水查询批次号失败");
		}

		return imgUrlsList;
	}
	
	/**
	 * 根据url下载影像
	 * @param imgId
	 * @param num
	 * @param ctid 身份证
	 * @param cardnumber 卡折号
	 * 根据cfca要求
     * 受害人证件名=文件类型+文件格式类型+"_"+业务申请编号+"_"+身份号码
     * 紧急止付申请表名：文件类型+文件格式类型+"_"+业务申请编号+"_"+身份号码/被止付目标账号
     * 文件类型：    01:警官身份证件 02：冻结法律文书 03：紧急止付申请表 04：身份证
	 * 文件格式类型：   0:jpg  1:PDF
	 * 业务申请编码 36位
	 * 目标证件、账号  50位
	 * @return map 地址[filepath]和名称[filename]
	 * @throws Exception 
	 */
    private   Map<String,String> insertImgToFile(String imgUrl,int num,String ctid, String cardnumber) throws Exception {
        Map<String,String> map = Maps.newHashMap();
    	DataInputStream dis = null;
    	FileOutputStream fos = null;
        try {
        	URL url = new URL(imgUrl); 
			//打开网络输入流
			dis = new DataInputStream(url.openStream());
			// 从缓存中获取根路径
			String root = codeService.getCodeValue("Dpara", "1");//"D:/Users/yinxiong";
			String attachpath= codeService.getCodeValue("Dpara", "attachpath");//附件和反馈报文存储路径
			String path =root+"/"+attachpath+"/"+DtUtils.getNowDate()+"/dx/attach";
			File newFile = new File(path);
			if (!newFile.exists()) {
				newFile.mkdirs();
			}
			//此处约定,取的第一个是身份证，第二个是申请表
			String newImageName = "";
			//业务申请编号=业务编码类型+32位随机数 【参见电信诈骗附录I】
			String applicationId = "0401"+UUID.randomUUID().toString().replaceAll("-", "");
			if(num==0){
				newImageName = "040_"+applicationId+"_"+ctid+".jpg";
			}else{
				newImageName = "030_"+applicationId+"_"+cardnumber+".jpg";
			}
			
			String filepath="/"+attachpath+"/"+DtUtils.getNowDate()+"/dx/attach/"+newImageName;
			map.put("filepath",filepath);//文件地址
			map.put("filename",newImageName);//文件名称
			//建立一个新的文件
			File newfile = new File(path+File.separator +newImageName);
			fos = new FileOutputStream(newfile);
			byte[] buffer = new byte[1024];
			int length;
			//开始填充数据
			while( (length = dis.read(buffer))>0){
			    fos.write(buffer,0,length);
			}
			logger.error("影像附件生成成功！");
		} catch (Exception e) {
			logger.error("影像下载失败："+e.getMessage(),e);
			throw new Exception("影像下载失败");
		}finally{
			try {
				dis.close();
				fos.close();
			} catch (Exception e) {
				logger.error("流关闭异常");
			}
		}

		return map;
	}
    /**
     * 生成响应报文
     * @return
     */
    private String getResponseMsg(String tx_sts,String error_msg){
    	StringBuffer re_msg = new StringBuffer();
		re_msg.append(this.getHeadStr("AFP001"));//报文头部
		re_msg.append(tx_sts);//报文体 0:失败 1:成功
		re_msg.append(rightPad(error_msg, 255));// 异常消息
		return re_msg.toString();
	}
	/**
	 * 生成通用报文头
	 * @param tradeCode 交易代码
	 * @return
	 */
	private String getHeadStr(String tradeCode) {
		StringBuffer buf = new StringBuffer();
		buf.append("1");// 1-versionNo 版本号 标识当前数据包的格式版本，目前该版本号为1，默认填“1”
		buf.append("0");// 1-toEncrypt 密押标识 表示数据报文是否压缩格式，目前不使用，默认填“0”
		buf.append("510001");// 6-commCode 通讯代码 请求填“500001" 响应填“510001”------
		buf.append("0");// 1-commType 通讯类型 0--同步请求(等待接收方返回业务处理结果)；1--异步请求(接收方不返回结果,由网关返回给请求方通讯回执)
		buf.append("TELE");// 4-receiverId 接收方标识--柜面
		buf.append("AFPS");// 4-senderId 发起方标识--反欺诈
		String time = DtUtils.getNowDate("yyyyMMddHHmmss")+(int)((Math.random()*9+1)*10000000);//日期＋随机数的22位流水号
		buf.append(time);// 22-senderSN 发起方流水
		buf.append(time.substring(0,8));// 8-senderDate 发起方日期
		buf.append(time.substring(8,14));// 6-senderTime 发起方时间
		buf.append(tradeCode);// 6-tradeCode 交易代码 柜员签到交易(990001)， 查询柜员信息交易(990002)
		buf.append("01");// 2-gwErrorCode 网关错误标识 网关用于表示是否处理过程发生错误。发起方填空01 ---- 成功 00 ---- 错误-----
		buf.append(StringUtils.rightPad("", 7, " "));// 7-gwErrorMessage 网关错误代码 用于表示具体错误内容的七位的半角字符串，发起方填空
		buf.append("G");// 1-gwEncoding U:UTF-8 g:GBK G或空:GB18030
		buf.append("N");// 1-resendFlag 重发标志 Y：重发 其他：非重发
		buf.append(StringUtils.rightPad("", 6, " "));// 6-reserved1 保留位 空格填充
		return buf.toString();
	}
	
	/**
	 * 处理中文字节长度问题
	 * @param str  源字符串
	 * @param length 指定长度
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	private  String rightPad(String str,int length){
		int len = 0;
		try {
			len = str.getBytes("GBK").length;
			if(len>=length){
				return str;
			}
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage(),e);
		}
		return str+StringUtils.rightPad("", length-len, ' ');
	}

	/**
	 * 判断公安机构编码是否在码表中
	 * 
	 * @param toorg
	 * @return
	 */
	private boolean getToorgFlag(String toorg){
		boolean flag = false;
		Map<String,String> map =  codeService.getCodeMap("Dtoorg");
		if(map.containsKey(toorg)){
			flag = true;
		}
		return flag;
	}
	
}
