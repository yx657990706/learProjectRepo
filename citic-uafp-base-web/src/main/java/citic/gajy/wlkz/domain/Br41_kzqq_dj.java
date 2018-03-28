/* =============================================
*  Copyright (c) 2014-2015 by CITIC All rights reserved.
*  Created [2016-05-31] 
* =============================================
*/

package citic.gajy.wlkz.domain;                
                                                  
/**
* <p>Br41_kzqq_dj.java</p>
* <p>Description: </p>
* @author $Author:  $
*/

import citic.base.BaseVo;  
import lombok.Data; 
import lombok.EqualsAndHashCode; 
                                              
@Data                                                  
@EqualsAndHashCode(callSuper = false)                                                  
public class Br41_kzqq_dj extends BaseVo {
                                              
/**
	 * 
	 */
	private static final long serialVersionUID = -3313615092159071486L;

/** 冻结方式 */
private String djfs = "";
/** 发送时间 */
private String fssj = "";
private String fssj_start="";
private String fssj_end="";
                                              
/** 账户序号 */
private String zhxh = "";

private String zxqssj = "";
/** 证照号码 */
private String zzhm = "";
                                              
/** 开始时间 */
private String kssj = "";
                                              
/** 主键， 请求单流水号，用于唯一标识查控请求单 */
private String qqdbs = "";
                                              
/** 原任务流水号 */
private String yrwlsh = "";
                                              
/** 请求查询的账号或卡号 */
private String zh = "";
                                              
/** 归属机构 */
private String organkey = "";
                                              
/** 描述被查控人的名称（姓名、公司名称 */
private String djzhhz = "";
                                              
/** 结束时间 */
private String jssj = "";
                                              
/** 证照类型代码 */
private String zzlxdm = "";
private String zzlxdm_disp = "";
                                              
/** 币种 */
private String bz = "";
                                              
/** 金额 */
private String je = "";
                                              
/** 查询日期（分区） */
private String qrydt = "";
                                              
/** 任务流水号 */
private String rwlsh = "";
                                              
/** 监管机构 */
private String tasktype = "";     

private String djfs_disp = ""; 
private String bz_disp = "";

private String msgcheckresult="";
private String msgcheckresult_disp="";
private String ztlb="";
private String ztlb_disp="";

}
