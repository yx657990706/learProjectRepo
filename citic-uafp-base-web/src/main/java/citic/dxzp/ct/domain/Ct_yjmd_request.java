package citic.dxzp.ct.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import citic.cgb.xmlmsg.domain.CommonHead;

@Data
@EqualsAndHashCode(callSuper = false)
public class Ct_yjmd_request extends CommonHead {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2950765052219827891L;

	/**
	 * 查询客户类型 
	 * 01-	个人客户
     * 02-	企业客户
     */
	private String customertype = "";
	
	/**客户名称*/
	private String customername = "";
	
	/**证件种类 （个人客户必输）*/
	private String certtype = "";
	
	/**证件号码 （证件号码或者企业证件号码）*/
	private String certid = "";
	
	
	//=========================辅助字段====================================
	//错误代码4位（客户类型2为+2位编号）
	private String code = "";
	private String code_msg = "";
}
