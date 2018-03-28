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
public class Br41_kzqq_dj_back_mx extends BaseVo {

/**
 * 
*/
private static final long serialVersionUID = 1609886788531948207L;

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

/**执行结果  0-执行成功；1-执行失败*/
private String zxjg = "";

/**执行失败原因*/
private String zxjgyy = "";

/**在先冻结机关 */
private String djjg = "";

/**在先冻结金额 */
private String zxdjje = "";

/**在先冻结到期日 */
private String djjzrq = "";

/**冻结金额 */
private String djje = "";

/**冻结开始时间*/
private String djkssj = "";

/**未冻结金额*/
private String wdjje = "";

/**冻结结束时间*/
private String djjssj = "";

/**币种*/
private String bz = "";

/**核心冻结编号*/
private String hxappid= "";

/**钞汇标志*/
private String chbz = "";

/**归属机构*/
private String organkey="";
private String organkey_disp="";

private String bz_disp = "";
private String zxjg_disp = "";
private String djkssj_start="";
private String djkssj_end="";
private String djjssj_start="";
private String djjssj_end="";
}
