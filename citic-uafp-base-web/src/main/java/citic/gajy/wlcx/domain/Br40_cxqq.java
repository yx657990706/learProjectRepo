/* =============================================
*  Copyright (c) 2014-2015 by CITIC All rights reserved.
*  Created [2016-05-23] 
* =============================================
*/

package citic.gajy.wlcx.domain;                
                                                  
/**
* <p>Br40_cxqq.java</p>
* <p>Description: </p>
* @author $Author:  $
*/

import citic.base.BaseVo;  
import lombok.Data; 
import lombok.EqualsAndHashCode; 
                                              
@Data                                                  
@EqualsAndHashCode(callSuper = false)                                                  
public class Br40_cxqq extends BaseVo {

/**
* 
*/
private static final long serialVersionUID = 4375446540650013220L;

/** 协查人证件类型 */
private String xcrzjlx = "";
private String xcrzjlx_disp = "";
                                              
/** 发起请求的主办民警姓名 */
private String qqrxm = "";
                                              
/** 发送时间 */
private String fssj = "";
private String fssj_start="";
private String fssj_end="";
                                              
/** 查询申请人所属单位名称 */
private String qqrdwmc = "";
                                              
/** 协查人姓名 */
private String xcrxm = "";
                                              
/** 主键， 请求单流水号，用于唯一标识查控请求单 */
private String qqdbs = "";
private String qqdbs_s = "";
                                              
/** 协查人证件号码 */
private String xcrzjhm = "";
private String xcrzjhm_disp = "";
                                              
/** 01代表正常；02代表加急 */
private String jjcd = "";
private String jjcd_disp = "";
                                              
/** 此处默认为110031 警官证 */
private String qqrzjlx = "";
private String qqrzjlx_disp = "";
                                              
/** 请求人手机号 */
private String qqrsjh = "";
                                              
/** 请求人警号 */
private String qqrzjhm = "";
                                              
/** 0：待认定 1:待执行  5.待生成报文  6.已生成报文  8：成功 9：失败回执 */
private String status = "";
private String status_disp="";

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
                                              
/**  监管类别  3国安 4高检 5 公安 */
private String tasktype = "";
                                              
/** 查询机构代码,统一编码 */
private String mbjgdm = "";
private String mbjgdm_disp = "";                                      
/** 备注 */
private String beiz = "";
                                              
/** 案件类型 */
private String ajlx = "";
private String ajlx_disp = "";  
private String czsbyy="";
/** 01代表个人主体；
02代表对公（单位）主体；
沿用请求单的类别；
 */
private String ztlb = "";
private String ztlb_disp = "";                                             
/** 查询机构代码,统一编码 */
private String sqjgdm = "";
private String sqjgdm_disp = "";
                                              
/** 查询日期（分区） */
private String qrydt = "";
/**请求人办公电话 */
private String qqrbgdh="";
/**协查人手机号*/
private String xcrsjh="";
/**协查人办公电话 */
private String xcrbgdh="";
/** 归属机构 */
private String orgkey = "";
private String rwlsh="";
private String cxfkjg="";
private String cxzh="";
/** 证照类型代码 */
private String zzlx = "";
private String zzlx_disp = "";
private String cxjssj = "";
private String zzhm="";
private String cxnr="";
private String cxnr_disp="";
 

private String scount = "";   
private String fcount = ""; 
private String ucount = ""; 

private String wjmc="";
private String wjlx="";
private String wslx="";
private String wslx_disp="";
private String filepath="";
/*接收人*/
private String recipient_p="";
/*接收时间*/
private String recipient_time="";
/*最后修改时间*/
private String last_up_dt="";

private String  cxfkjg_disp="";
private String orgkey_disp = "";
private String qrydt_start = "";
private String qrydt_end = "";
private String cxlx="";
private String ztmc="";
private String mxsdlx="";
private String mxqssj="";
private String mxjzsj="";
//动态查询是否走人工
private String dt_rg_flag = ""; 
private String seq="";
//回执代码
private String hzdm="";
private String hzdm_disp="";
//回执说明
private String hzsm="";

}
