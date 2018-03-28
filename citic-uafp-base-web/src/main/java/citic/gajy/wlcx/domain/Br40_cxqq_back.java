/* =============================================
 *  Copyright (c) 2014-2015 by CITIC All rights reserved.
 *  Created [2016-05-23] 
 * =============================================
 */

package citic.gajy.wlcx.domain;

/**
 * <p>Br40_cxqq_back.java</p>
 * <p>Description: </p>
 * @author $Author:  $
 */

import citic.base.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Br40_cxqq_back extends BaseVo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7387575804392234415L;

	/** 对该查询任务的查询结果描述，成功或失败；01表示成功，02表示失败； */
	private String cxfkjg = "";
	private String cxfkjg_disp = "";

	/**
	 * 操作失败相关信息，成功则返回为空。 操作成功但无结果，需注明“未找到符合请求条件的数据”
	 */
	private String czsbyy = "";

	/** 卡号（动态查询用） */
	private String kh = "";

	/** 动态查询用，其他默认1 */
	private String seq = "";

	/** 主键， 请求单流水号，用于唯一标识查控请求单 */
	private String qqdbs = "";

	/** 账号（动态查询用） */
	private String zh = "";

	/** 0未处理 1已发送 3成功 4失败 */
	private String status = "";
	private String status_disp = "";

	/** 查询机构代码,统一编码 */
	private String mbjgdm = "";
	private String mbjgdm_disp = "";

	/** 查控主体类别 */
	private String ztlb = "";
	private String ztlb_disp = "";

	/** 查询机构代码,统一编码 */
	private String sqjgdm = "";
	private String sqjgdm_disp = "";

	/** 执行完查询结果日期，采用格式YYYYMMDDhhmmss，24小时制格式，例如：20150410093230； */
	private String cxjssj = "";

	/** 归属机构 */
	private String orgkey = "";
	private String orgkey_disp = "";

	/** 任务流水号 */
	private String rwlsh = "";

	/** 查询日期（分区） */
	private String qrydt = "";
	/** 反馈手机号码 */
	private String fksjhm = "";
	/** 动态查询起始时间 */
	private String zxqssj = "";

	private String zxqssj_s = "";
	private String zxqssj_e = "";
	/** 动态查询结束时间 */
	private String jssj = "";
	/** 银行主机数据时间 */
	private String yhzjsjsj = "";
	/** 是否修订 */
	private String sfxd = "";
	/** 执行时间区间 */
	private String mxsdlx = "";
	private String mxsdlx_disp = "";
	private String tasktype = "";
	private String dealing_p = "";
	private String dealing_time = "";
	private String feedback_p = "";
	private String feedback_time = "";
	/**excle附件名称*/
	private String filename="";
	/**excle附件路径（包含文件名称）*/
	private String filepath="";
	
	/* 最后修改时间 */
	private String last_up_dt = "";
	private String sfxd_disp = "";
	private String qqcslx = "";
	private String backurl = "";
	
	// 查询内容 01 账户信息；02 账户交易明细信息；03 账户和账户的交易明细信息
	private String cxnr = "";
	private String cxnr_disp="";
	// 动态查询时，数据库中同一个请求下的当前最大序号
	private String maxseq;
	
	private String msgcheckresult="";
	private String msgcheckresult_disp="";	
	private String zzlx="";
	private String zzlx_disp="";
	private String zzhm="";
	private String cxzh="";
	private String ztmc="";
	private String mxqssj="";
	private String mxjzsj="";
	private String deal_reason="";
}
