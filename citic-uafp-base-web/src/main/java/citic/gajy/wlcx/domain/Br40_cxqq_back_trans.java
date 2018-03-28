/* =============================================
*  Copyright (c) 2014-2015 by CITIC All rights reserved.
*  Created [2016-05-23] 
* =============================================
*/

package citic.gajy.wlcx.domain;                
                                                  
/**
* <p>Br40_cxqq_back_trans.java</p>
* <p>Description: </p>
* @author $Author:  $
*/

import citic.base.BaseVo;  
import lombok.Data; 
import lombok.EqualsAndHashCode; 
                                              
@Data                                                  
@EqualsAndHashCode(callSuper = false)                                                  
public class Br40_cxqq_back_trans extends BaseVo {
                                              
/**
	 * 
	 */
	private static final long serialVersionUID = 7062431066254358924L;

/** 01标识成功；02表示失败； */
private String jysfcg = "";
private String jysfcg_disp = "";                    
/** 交易对方名称 */
private String jydfxm = "";
                                              
/** 电子架进登录用户名 */
private String dlyhm = "";
                                              
/** 若无可不反馈； */
private String pzzl = "";
private String pzzl_disp = "";
                                              
/** 交易类型 */
private String jylx = "";
private String jylx_disp = "";
                                              
/** 若无可不反馈； */
private String jyfsd = "";
                                              
/** 日志号 */
private String rzh = "";
                                              
/** 交易柜员号 */
private String jygyh = "";
                                              
/** IP地址 */
private String ip = "";
                                              
/** 若无可不反馈； */
private String jydfzhkhh = "";
                                              
/** 若无可不反馈； */
private String pzh = "";
                                              
/** 账号 */
private String zh = "";
                                              
/** 交易摘要 */
private String jyzy = "";
                                              
/** 代办人证件类型 */
private String dbrzjlx = "";
                                              
/** 备注 */
private String beiz = "";
                                              
/** 交易对方账号 */
private String jydfzh = "";
                                              
/** 代办人姓名 */
private String dbrxm = "";
                                              
/** 若无可不反馈； */
private String cph = "";
                                              
/** 查询日期（分区） */
private String qrydt = "";
                                              
/** 交易手续费币种 */
private String jysxfbz = "";
                                              
/** 电子渠道交易必须反馈MAC地址；如果不是则可以反馈为空。 */
private String mac = "";
                                              
/** 交易网点代码 */
private String jywddm = "";
                                              
/** 若无可不反馈； */
private String shh = "";
                                              
/** 查询卡号 */
private String cxkh = "";
                                              
/** 01表示成功，02表示失败； */
private String cxfkjg = "";
private String cxfkjg_disp = "";
                                              
/** 交易手续费金额 */
private String jysxfje = "";
                                              
/** 代办人联系电话 */
private String dbrlxdh = "";
                                              
/** 交易余额 */
private String ye = "";
                                              
/** 对手续费的说明，没有可 为空 */
private String jysxfzy = "";
                                              
/** 借贷标志 */
private String jdbz = "";
private String jdbz_disp = "";
                                              
/** 交易对方证件号码 */
private String jydfzjhm = "";
                                              
/** 中文描述 */
private String shmc = "";
                                              
/** 若无可不反馈； */
private String zdh = "";
                                              
/** 交易时间 */
private String jysj = "";
private String jysj_start = "";
private String jysj_end = "";
                                              
/** 交易流水号 */
private String jylsh = "";
                                              
/** 交易序号 */
private String transseq = "";
                                              
/** 00表示其它，01表示现金交易； */
private String xjbz = "";
private String xjbz_disp = "";
                                              
/** 主键， 请求单流水号，用于唯一标识查控请求单 */
private String qqdbs = "";
                                              
/** 交易对手余额 */
private String jydsye = "";
                                              
/** 对该查询反馈结果的原因的描述 */
private String cxfkjgyy = "";
                                              
/** 代办人证件号码 */
private String dbrzjhm = "";
                                              
/** 交易对方卡号 */
private String jydfkh = "";
                                              
/** 交易网点名称 */
private String jywdmc = "";
/** 证照类型 */
private String zzlx="";
/** 证照号码 */
private String zzhm="";
/** 交易对方通讯地址 */
private String jydftxdz="";
/** 客户名称 */
private String khmc="";
/** 交易对方联系电话 */
private String jydflxdh="";
/** 币种 */
private String bz = "";
private String bz_disp = "";
                                              
/** 交易金额 */
private String je = "";
private String je_start = "";
private String je_end = "";

/** 交易对方的账卡号的类型（0为账号、1为卡号、2为未知） */
private String jydfzkhlx = "";

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
private String zzlx_disp="";
private String dbrzjlx_disp="";

private String seq = "";
private String status="";
private String backurl="";
                                              
}
