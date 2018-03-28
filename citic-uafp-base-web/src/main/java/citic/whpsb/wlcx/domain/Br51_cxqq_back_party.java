/*
 * =============================================
 * Copyright (c) 2014-2015 by CITIC All rights reserved.
 * Created [2016-08-31]
 * =============================================
 */

package citic.whpsb.wlcx.domain;

/**
 * <p>
 * Br51_cxqq_back_party.java
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author $Author: $
 */

import citic.base.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Br51_cxqq_back_party extends BaseVo {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2518027185306692081L;
	
	/** 请求单号 */
	private String bdhm = "";
	
	/** 工商营业执照号 */
	private String gsyyzzh = "";
	
	/** 开户网点代码 */
	private String khwddm = "";
	
	/** 住宅地址 */
	private String zzdz = "";
	
	/** 报文批次号 */
	private String msgseq = "";
	
	/** 联系固话 */
	private String lxdh = "";
	
	/** 法人代表证件号码 */
	private String frdbzjhm = "";
	
	/** 联系人 */
	private String lxr = "";
	
	/** 开户网点 */
	private String khwd = "";
	
	/** E_MAIL地址 */
	private String email = "";
	
	/** 法人代表 */
	private String frdb = "";
	
	/** 联系地址 */
	private String lxdz = "";
	
	/** 单位地址 */
	private String dwdz = "";
	
	/** 国税纳税号 */
	private String gsnsh = "";
	
	/** 联系手机 */
	private String lxsj = "";
	
	/** 邮政编码 */
	private String yzbm = "";
	
	/** 代办人姓名 */
	private String dbrxm = "";
	
	/** 查询日期（分区） */
	private String qrydt = "";
	
	/** 代办人证照号码 */
	private String dbrzzh = "";
	
	/** 代办人证照类型 */
	private String dbrzzlx = "";
	
	/** 单位电话 */
	private String dwdh = "";
	
	/** 通讯地址 */
	private String txdz = "";
	
	/** 法人代表证件类型 */
	private String frdbzjlx = "";
	
	/** 工作单位 */
	private String gzdw = "";
	
	/** 住宅电话 */
	private String zzdh = "";
	
	/** 地税纳税号 */
	private String dsnsh = "";
	
	private String qrydt_start = "";
	private String qrydt_end = "";
	private String dbrzzlx_disp = "";
	private String frdbzjlx_disp = "";
	private String khwddm_disp = "";
	
}
