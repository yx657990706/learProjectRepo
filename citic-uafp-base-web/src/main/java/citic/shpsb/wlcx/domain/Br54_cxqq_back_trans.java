/*
 * =============================================
 * Copyright (c) 2014-2015 by CITIC All rights reserved.
 * Created [2016-08-31]
 * =============================================
 */

package citic.shpsb.wlcx.domain;

import citic.base.BaseVo;
/**
 * <p>
 * Br54_cxqq_back_trans.java
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author $Author: $
 */
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Br54_cxqq_back_trans extends BaseVo {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8177065281088405963L;

	/** 请求单号 */
	private String bdhm = "";
	
	/** 报文批次号 */
	private String msgseq = "";
	
	/** 资金往来序号 */
	private String transseq = "";
	
	/** 查询日期（分区） */
	private String qrydt = "";
	
	/** 账（卡）号 */
	private String zh = "";
	
	/** 交易日期*/
	private String jyrq="";
	
	/** 交易时间*/
	private  String jysj="";
	
	/** 对方账号 */
	private String dfzh = "";
	
	/** 对方行名 */
	private String dfhm = "";
	
	/** 对方户名 */
	private String dfmc = "";
	
	/** 币种 */
	private String bz = "";
	
	/** 交易金额 */
	private String jyje = "";
	
	/** 借：- 贷：+ */
	private String jdbz = "";
	
	/** 交易渠道 */
	private String jyqd = "";
	
	/** 交易网点 */
	private String jywd = "";
	
	/** IP地址 */
	private String ip = "";
	
	/** MAC地址 */
	private String mac = "";
	
	/**交易关联号*/
	private String jyglh="";
	
	/**交易后余额*/
	private String jyye="";
	
	/**传票号*/
	private String cph="";
	
	/**交易对手证件类型*/
	private String dfzzlx="";
	
	/**交易对手证照号*/
	private String zfzzhm="";
	
	/**系统交易流水号*/
	private  String   jylsh="";
	
	/**备注*/
	private  String beiz="";
	
	/*-----------------new add------------*/
	private String bz_disp="";
	private String  jdbz_disp="";
	private String dfzzlx_disp="";
	
}
