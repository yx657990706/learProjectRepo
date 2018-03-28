/* =============================================
*  Copyright (c) 2014-2015 by CITIC All rights reserved.
*  Created [2016-05-23] 
* =============================================
*/

package citic.gajy.wlcx.domain;                
                                                  
/**
* <p>Br40_cxqq_back_acct_sub.java</p>
* <p>Description: </p>
* @author $Author:  $
*/

import citic.base.BaseVo;  
import lombok.Data; 
import lombok.EqualsAndHashCode; 
                                              
@Data                                                  
@EqualsAndHashCode(callSuper = false)                                                  
public class Br40_cxqq_back_acct_sub extends BaseVo {
                                              
/**
	 * 
	 */
	private static final long serialVersionUID = 4017588094972026955L;

/** 账户状态 */
private String zhzt = "";
private String zhzt_disp = "";
                                              
/** 子账号，例如关联账号，定（活）期存单号等； */
private String zzhzh = "";
                                              
/** 账卡号 */
private String zh = "";
                                              
/** 子类账户类别，例如，关联账户，定期，活期等； */
private String zzhlb = "";
                                              
/** 钞汇标志 */
private String chbz = "";
                                              
/** 账户余额 */
private String zhye = "";
                                              
/** 币种 */
private String bz = "";
                                              
/** 可用余额 */
private String kyye = "";
                                              
/** 起始为1，递增为1的序号，非多记录反馈1即可。 */
private String zzhxh = "";
                                              
/** 主键， 请求单流水号，用于唯一标识查控请求单 */
private String qqdbs = "";
                                              
/** 查询日期（分区） */
private String qrydt = "";
                                              
/** 任务流水号 */
private String rwlsh = "";
/** 01  常规查询
02  动态查询
03  继续动态查询
04  解除动态查询
05  冻结
06  继续冻结
07  解除冻结
08  紧急止付
09  解除止付
10  凭证图像查询 */
private String qqcslx = "";
private String qqcslx_disp = ""; 
private String tasktype="";
private String bz_disp = "";
                                              
}
