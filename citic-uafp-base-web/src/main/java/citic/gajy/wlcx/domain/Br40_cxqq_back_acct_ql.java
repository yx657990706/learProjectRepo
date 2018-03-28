/* =============================================
*  Copyright (c) 2014-2015 by CITIC All rights reserved.
*  Created [2016-05-23] 
* =============================================
*/

package citic.gajy.wlcx.domain;                
                                                  
/**
* <p>Br40_cxqq_back_acct_ql.java</p>
* <p>Description: </p>
* @author $Author:  $
*/

import citic.base.BaseVo;  
import lombok.Data; 
import lombok.EqualsAndHashCode; 
                                              
@Data                                                  
@EqualsAndHashCode(callSuper = false)                                                  
public class Br40_cxqq_back_acct_ql extends BaseVo {
                                              
/**
	 * 
	 */
	private static final long serialVersionUID = 1477958629978476441L;

/** 权利金额 */
private String qlje = "";
                                              
/** 权利人通讯地址 */
private String qlrdz = "";
                                              
/** 权利序号 */
private String xh = "";
                                              
/** 账号 */
private String zh = "";
                                              
/** 证件号码 */
private String zzhm = "";
                                              
/** 权利人姓名 */
private String qlrxm = "";
                                              
/** 共有权/优先权人的证件类型代码； */
private String zzlxdm = "";
                                              
/** 主键， 请求单流水号，用于唯一标识查控请求单 */
private String qqdbs = "";
                                              
/** 权利类型名称，可根据银行实际数据反馈； */
private String qllx = "";
private String qllx_disp = "";                                       
/** 查询日期（分区） */
private String qrydt = "";
                                              
/** 权利人联系方式 */
private String qlrlxfs = "";
                                              
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
private String tasktype = "";  
                                              
}
