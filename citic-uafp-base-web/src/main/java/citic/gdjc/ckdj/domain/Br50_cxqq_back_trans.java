/* =============================================
 *  Copyright (c) 2014-2015 by CITIC All rights reserved.
 *  Created [2016-08-18] 
 * =============================================
 */

package citic.gdjc.ckdj.domain;

/**
 * <p>Br50_cxqq_back_trans.java</p>
 * <p>Description: </p>
 * @author $Author:  $
 */
import citic.base.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Br50_cxqq_back_trans extends BaseVo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4858471871326915957L;

	/** 对方账号 */
	private String matchaccou = "";

	/** 交易联系电话 */
	private String transtel = "";

	/** 交易类型 */
	private String transtype = "";

	/** 存入金额 */
	private String income = "";

	/** 交易地址编号 */
	private String transaddrno = "";

	/** 汇钞类型 */
	private String exchangetype = "";

	/** 查询卡号客户的名称； */
	private String accname = "";

	/** 交易备注 */
	private String transremark = "";

	/** 交易余额 */
	private String banlance = "";

	/** 账号 */
	private String zh = "";

	/** 交易时间 */
	private String transtime = "";

	/** 交易终端IP */
	private String transtermi = "";

	/** 对方机构号 */
	private String matchbankn = "";

	/** 账户类型 */
	private String acctype = "";

	/** 对方机构名 */
	private String matchbankname = "";

	/** 查询日期（分区） */
	private String qrydt = "";

	/** 交易地址 */
	private String transaddr = "";

	/** 01表示成功，02表示失败； */
	private String cxfkjg = "";

	/** 支出金额 */
	private String expense = "";

	/** 交易柜员号 */
	private String transtelle = "";

	/** 卡号 */
	private String cardno = "";

	/** 对方户名 */
	private String matchaccna = "";

	/** 案件编号 */
	private String caseno = "";
	private String caseno_s = "";
	
	/** 协作编号 */
	private String docno = "";
	private String docno_s = "";
	
	/** 币种 */
	private String currency = "";

	/** 交易序号 */
	private String transseq = "";

	/** 对该查询反馈结果的原因的描述 */
	private String cxfkjgyy = "";

	/** 子账户 */
	private String subaccount = "";
	/** 账号 */
	private String account="";

	/** 核心源账号 */
	private String ctac = "";

	/** 交易流水号 */
	private String transnum = "";

	/** 唯一标识 */
	private String uniqueid = "";
	/** 唯一标识（页面区分用） */
	private String uniqueid_s = "";
	
	/** 交易国家或地区 */
	private String transcountry = "";

	/** 交易渠道 */
	private String transchannel = "";
	
	/** --------------new add--------------------- */
	private String qrydt_start = "";
	private String qrydt_end = "";
	private String enddate = "";
	private String startdate = "";
	private String type = "";
	private String idtype = "";
	private String id = "";
	private String transtime_start = "";
	private String transtime_end = "";
	private String exchangetype_disp="";
    private String currency_disp="";
}
