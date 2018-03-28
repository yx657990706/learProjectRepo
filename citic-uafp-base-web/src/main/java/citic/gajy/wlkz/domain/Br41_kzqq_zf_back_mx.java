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
public class Br41_kzqq_zf_back_mx extends BaseVo {
                                              
/**
 * 
*/
private static final long serialVersionUID = -3494067434069455790L;

/** 任务流水号 */
private String rwlsh = "";

/** 请求单标识 */
private String qqdbs = "";

/** 监管类别 */
private String tasktype = "";
                                              
/** 账号 */
private String zh = "";

/** 账户子账号 */
private String zhzzh = "";

/**子账号序号 */
private String zzhxh = "";

/**子账号余额 */
private String zzhye = "";

/**执行结果  0-执行成功；1-执行失败
*/
private String zxjg = "";

/**执行失败原因*/
private String zxjgyy = "";

/**止付开始时间 */
private String zfkssj = "";

/**止付结束时间 */
private String zfjssj = "";

/**币种 */
private String bz = "";

/**钞汇标志 */
private String chbz = "";
/**查询时间*/
private String qrydt="";
/**核心冻结编号*/
private String hxappid="";
/**归属机构*/
private String organkey="";
private String organkey_disp="";
 
private String bz_disp = "";
private String zxjg_disp = "";
private String zfjssj_start = "";
private String zfjssj_end = "";
private  String zfkssj_start="";
private String zfkssj_end="";
}
