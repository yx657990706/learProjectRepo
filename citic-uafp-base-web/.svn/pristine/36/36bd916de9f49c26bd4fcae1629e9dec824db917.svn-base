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

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.springframework.web.multipart.MultipartFile;

import citic.base.BaseVo;

@Data
@EqualsAndHashCode(callSuper = false)
public class Cgb_face_data extends BaseVo {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7781508296439330811L;
	
	/** 指纹信息 */
	private String fingerprint = "";
	
	/** 图片唯一标识 */
	private String suspect_img_id = "";
	
	/** 6位码 */
	private String busi_type = "";
	
	/** 录入人员编号 */
	private String add_user_id = "";
	
	/** 业务办理时间 */
	private String busi_time = "";
	private String busi_time_start = "";
	private String busi_time_end = "";
	
	/** 联系地址 */
	private String address = "";
	
	/** 录入时间 */
	private String add_time = "";
	
	/** 受害人证件有效期 */
	private String victim_card_validity = "";
	
	/** 1：黑名单 2：灰名单 */
	private String risk_type = "";
	private String risk_type_disp = "";
	
	/** 核心证件类型 */
	private String victim_card_type = "";
	
	/** 0.863 最高1，精确到小数点后3位 */
	private String similarity = "";
	
	/** 业务办理网点 */
	private String busi_website = "";
	
	/** 联系电话 */
	private String telephone = "";
	
	/** 受害人证件号码 */
	private String victim_card_num = "";
	
	/** 受害人姓名 */
	private String victim_name = "";
	
	/** 图片唯一标识 */
	private String victim_img_id = "";
	
	/** 003:VTM 004:柜面 */
	private String busi_way = "";
	
	/** 1：人工新增 2：柜面上传3：高清拍摄 */
	private String data_source = "";
	
	/** 业务办理柜员号 */
	private String busi_teller_num = "";
	
	/** 修改人员编号 */
	private String modify_user_id = "";
	
	/** 修改时间 */
	private String modify_time = "";
	
	/** 认定状态 0：未认定 1：已认定 */
	private String firmly_flag = "";
	
	/** 名单建库渠道 ABS1:柜面 VTMS:VTM  BRCA:后台 AFPM:有权机关 */
	private String md_channel = "";
	private String md_channel_disp = "";
	/** 辅助图像批次号*/
	private String assist_batch_id = "";
	/** 其他说明*/
	private String remark = "";
	/** 出库人编号*/
	private String rm_user_id = "";
	/** 出库时间*/
	private String rm_time = "";
	/** 出库审核人编号*/
	private String rm_check_user_id = "";
	/** 出库审核时间*/
	private String rm_check_time = "";
	/** 出库标识 0:未出库 1：待出库 2：出库通过 3：出库不通过*/
	private String rm_flag = "";
	private String rm_flag_disp = "";
	
	/*------------new  addd--------------------*/
	//辅助证件图像ID
	private String assist_img_id = "";
	private String assist_img = "";
	//图像BASE64字符串
	private String img_base64 = "";
	
	//附件
	MultipartFile file_suspect_path=null;
	MultipartFile file_victim_path=null;
	MultipartFile file_assist_path=null;
	//对应名称
	String[] file_name;
	
	private String busi_website_disp = "";
	private String busi_type_disp = "";
	private String victim_card_type_disp = "";
	private String busi_way_disp = "";
	private String data_source_disp = "";
	private String operatetype = "";//5位业务办理类型(人脸识别用)
	//辅助证件类型 */
	private String assist_card_type = "";
	//辅助证件号码 */
	private String assist_card_num = "";
	// 辅助证件名称 */
	private String assist_card_name = "";
	// 组号 */
	private String group_id = "";
	//序号 */
	private String num = "";
	// 是否是主要图片 */
	private String is_main = "";
	// 图像id */
	private String img_id = "";
	//图像路径 */
	private String img_path = "";
	private String img_path_2 = "";
	//文件名 
	private String img_name = "";
	//审核结果 1:待审核 2：审核通过 3：审核未通过  【4：出库通过 5：出库未通过   额外添加的，做辅助用】
	private String check_result = "";
	private String check_result_disp = "";
	
	//======================接口处理附加字段=====================
	//相似图像ID
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
	//辅助证件图片
	private String assist_img_1 = "";
	private String assist_img_2 = "";
	private String assist_img_3 = "";
	//处理结果  0 成功 1 失败 -100 异常失败 程序抛出的异常信息 -204 报文错误 报文必传项没有传过来 -210 报文参数错误 报文中所传的信息有误
	private String result = "";
	//描述
	private String message = "";
	//id数组
	private String[] gID; 
	//认定结果 0：正常 1：黑名单 2：灰名单
	private String identify_result = "";
	//审核人、时间
	private String check_user_id = "";
	private String check_time = "";
	//提交人、时间
	private String commit_user = "";
	private String commit_time = "";
	//id拼接的字符串，做in条件
	private String ids = "";
	//组展示标识位 1:审核 2：查询  3：出库 4：出库审核
	//标识位 Z:出库  Y:通过  N:不通过
	private String bzw = "";
}
