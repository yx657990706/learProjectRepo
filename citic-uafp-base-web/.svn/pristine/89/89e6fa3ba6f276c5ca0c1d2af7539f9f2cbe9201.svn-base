/*
 * =============================================
 * Copyright (c) 2014-2015 by CITIC All rights reserved.
 * Created [2017-04-12]
 * =============================================
 */

package citic.cgb.face.domain;

/**
 * <p>
 * Cgb_face_data.java
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author $Author: $
 */

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import citic.cgb.xmlmsg.domain.CommonHead;

@Data
@EqualsAndHashCode(callSuper = false)
public class Cgb_face_data_AFP extends CommonHead {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1356775223909389242L;
	
	/** 嫌疑人图像ID（图片唯一标识） */
	private String suspect_img_id = "";
	
	/** 业务办理类型（6位码） */
	private String busi_type = "";
	
	/** 录入人员编号 */
	private String add_user_id = "";
	
	/** 业务办理时间 */
	private String busi_time = "";
	
	/** 联系地址 */
	private String address = "";
	
	/** 录入时间 */
	private String add_time = "";
	
	/** 受害人证件有效期 */
	private String victim_card_validity = "";
	
	/** 风险类型（1：黑名单 2：灰名单） */
	private String risk_type = "";
	
	/** 核心证件类型 */
	private String victim_card_type = "";
	
	/** 相似度（0.863 最高1，精确到小数点后3位） */
	private String similarity = "";
	
	/** 业务办理网点 */
	private String busi_website = "";
	
	/** 联系电话 */
	private String telephone = "";
	
	/** 受害人证件号码 */
	private String victim_card_num = "";
	
	/** 受害人姓名 */
	private String victim_name = "";
	
	/** 受害人联网核查图像ID（图片唯一标识） */
	private String victim_img_id = "";
	
	/** 业务办理渠道（003:VTM 004:柜面） */
	private String busi_way = "";
	
	/** 数据来源（1：人工新增 2：柜面上传3：高清拍摄） */
	private String data_source = "";
	
	/** 业务办理柜员号 */
	private String busi_teller_num = "";
	
	/** 指纹信息 */
	private String fingerprint = "";
	
	/** 名单建库渠道 ABS1:柜面 VTMS:VTM  SDSS:后台 AFPM:有权机关 */
	private String md_channel = "";
	
	/** 辅助图像批次号*/
	private String assist_batch_id = "";
	
	/** 其他说明*/
	private String remark = "";
	
	/** 出库标识 0:未出库 1：待出库 2：出库通过 3：出库不通过*/
	private String rm_flag = "";
	
	//相似图片ID 最多五个
	private String similarity_id_1 = "";
	private String similarity_id_2 = "";
	private String similarity_id_3 = "";
	private String similarity_id_4 = "";
	private String similarity_id_5 = "";
	//对应图片的base64
	private String suspect_img = "";
	private String victim_img = "";
	private String similarity_img_1 = "";
	private String similarity_img_2 = "";
	private String similarity_img_3 = "";
	private String similarity_img_4 = "";
	private String similarity_img_5 = "";
	//相似图片的联网核查照
	private String similarity_lwhc_img_1 = "";
	private String similarity_lwhc_img_2 = "";
	private String similarity_lwhc_img_3 = "";
	private String similarity_lwhc_img_4 = "";
	private String similarity_lwhc_img_5 = "";
	
	/** 辅助证件类型 */
	private String assist_card_type = "";
	/** 辅助证件号码 */
	private String assist_card_num = "";
	/** 辅助证件图像ID */
	private String assist_img_id = "";
	/** 组号 */
	private String group_id = "";
	/** 审核结果 */
	private String check_result = "";
	
	/** 认定状态 0：未认定 1：已认定 */
	private String firmly_flag = "";
	
	//错误代码 0：失败 1：成功
	private String errorcode = "";
	//错误描述
	private String errormsg = "";
	//查询结果计数
	private String count = "";
	
	//对方接口返回
	//处理结果  0 成功 1 失败 -100 异常失败 程序抛出的异常信息 -204 报文错误 报文必传项没有传过来 -210 报文参数错误 报文中所传的信息有误
	private String result = "";
	//描述
	private String message = "";
	
	private List<Cgb_face_data_AFP> quarylist;
}
