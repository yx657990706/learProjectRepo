/* =============================================
 *  Copyright (c) 2014-2015 by CITIC All rights reserved.
 *  Created [2016-04-15] 
 * =============================================
 */

package citic.dxzp.ct.domain;

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
public class Ct_yjmd_private extends BaseVo {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7053014628729271885L;
	
	/**编号 */
	private String serialno = "";

	/**证件类型  */
	private String cert_type = "";
	private String cert_type_disp = "";

	/** 证件代码 */
	private String cert_num = "";

	/** 客户名称 */
	private String cust_name = "";

	/** 客户地址*/
	private String cust_addr = "";
	
	/** 违约类型 */
	private String deflt_type = "";

	/** 违约天数*/
	private String deflt_day = "";

	/** 所属地区 */
	private String cust_zone = "";
	private String cust_zone_disp="";
	
	/** 数据时间 */
	private String data_month = "";
	
	/** 有效期*/
	private String valid_date = "";
	
}
