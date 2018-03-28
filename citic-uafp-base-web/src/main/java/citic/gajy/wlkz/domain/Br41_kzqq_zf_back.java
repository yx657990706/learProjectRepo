/* =============================================
*  Copyright (c) 2014-2015 by CITIC All rights reserved.
*  Created [2016-05-31] 
* =============================================
*/

package citic.gajy.wlkz.domain;                
                                                  
/**
* <p>Br41_kzqq_zf_back.java</p>
* <p>Description: </p>
* @author $Author:  $
*/

import citic.base.BaseVo;  
import lombok.Data; 
import lombok.EqualsAndHashCode; 
                                              
@Data                                                  
@EqualsAndHashCode(callSuper = false)                                                  
public class Br41_kzqq_zf_back extends BaseVo {
                                              
/**
	 * 
	 */
	private static final long serialVersionUID = 3562469881329185558L;

/** 账号 */
private String zh = "";
                                              
/** 归属机构 */
private String organkey = "";
private String tasktype="";
private String tasktype_disp="";
                                              
/** 0未处理 1已处理 2 错误回执 */
private String status = "";
private String status_disp = "";
                                              
/** 失败原因 */
private String sbyy = "";
                                              
/** 采用格式YYYYMMDDhhmmss，24小时制格式 */
private String zxqssj = "";
                                              
/** 卡号 */
private String kh = "";
                                              
/** 主键， 请求单流水号，用于唯一标识查控请求单 */
private String qqdbs = "";
                                              
/** 执行结果  0-执行成功； 1-执行失败；
*/
private String zxjg = "";
                                              
/** 任务流水号 */
private String rwlsh = "";
                                              
/** 查询日期（分区） */
private String qrydt = "";
/*处理人*/
private String dealing_p="";
/*处理时间*/
private String dealing_time="";
/*反馈人*/
private String feedback_p="";
/*反馈时间*/
private String feedback_time="";
/*最后修改时间 */
private String last_up_dt="";
private String zxjg_disp = "";
private String zhxh = "";        

private String qqcslx="";
private String deal_reason="";
                                              
}
