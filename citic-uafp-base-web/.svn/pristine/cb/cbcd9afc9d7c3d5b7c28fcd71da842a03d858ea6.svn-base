/* =============================================
 *  Copyright (c) 2014-2015 by CITIC All rights reserved.
 *  Created [2016-04-15] 
 * =============================================
 */

package citic.dxzp.risk.domain;

/**
 * <p>Cgb_risk_case.java</p>
 * <p>Description: </p>
 * @author $Author:  $
 */

import citic.base.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Cgb_risk_case extends BaseVo {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2355697062649542867L;
	
	/** 事件编码 */
	private String caseid="";
	
	/** 机构名称 */
	private String organkey="";
	private String organkey_disp="";
	
	/** 部门/支行 */
	private String suborgankey="";
	private String suborgankey_disp="";
	
	/** 涉案账户名 */
	private String accountname="";
	
	/** 涉案账户 */
	private String account="";
	
	/** 证照号码 ：
	 *  涉案人员身份信息/组织机构代码证 */
	private String cardnumber="";
	
	/** 涉案金额*/
	private String je="";
	
	/** 诈骗信息来源 01:诈骗电话 02:诈骗短信 03:虚假网站网址 04:QQ号 05:微信号 06:其他*/
	private String infosource="";
	private String infosource_disp="";
	
	/** 事件发生日期*/
	private String happendate="";
	private String happendate_q="";
	private String happendate_z="";
	
	/** 事件简述 */
	private String casedesc="";
	private String casedesc_disp="";
	
	/** 信息来源渠道 1：公安机关 2：人民银行 3：银监局 4：网点报案 5：其他渠道 */
	private String infochannel="";
	
	/** 信息来源渠道描述*/
	private String channeldesc="";
	
	/**是否已报案0:否1：是*/
	private String isreport="";
	private String isreport_disp="";
	
	/** 受理报案机关*/
	private String dealorgan="";
	
	/**创建人*/
	private String create_user="";
	/**创建时间*/
	private String create_dt="";
	/**审核人*/
	private String check_user="";
	/**审核时间*/
	private String check_dt="";
	/**审批人*/
	private String recheck_user="";
	/**审批时间*/
	private String recheck_dt="";
	/**风险信息类别*/
	private String risk_category="";
	/**风险信息子类别*/
	private String risk_sub_category="";
	/**业务条线*/
	private String bussines_line="";
	/**风险等级*/
	private String risk_level="";
	
	/** 流程状态0：录入1：待审核2：待审批3：审批通过4：退回*/
	private String status_cd="";
	private String status_cd_x="";
	private String status_cd_disp="";
 

	
	//sql中的in条件
	private String in_key="";
	//标识位 1:编辑岗 2：审核岗 3：审批岗
	private String bzw="";
	
}
