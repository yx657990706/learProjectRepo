/* =============================================
 *  Copyright (c) 2014-2015 by CITIC All rights reserved.
 *  Created [2015-03-23]
 * =============================================
 */

package citic.aml.system.domain;

/**
 * <p>Mp02_user.java</p>
 * <p>Description: </p>
 * @author $Author:  $
 */

import citic.base.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Mp02_user extends BaseVo {

	/**
	 *
	 */
	private static final long serialVersionUID = -6548864193238005143L;

	/** 总行用户，不限制机构权限 参见[S00001] 1-是 0-否 */
	private String ishead = "";

	/** null */
	private String mobilephone = "";

	/** 其它 */
	private String remark = "";

	/**
	 * 修改人员 private String lastuser = "";
	 */

	/** 政治面貌 */
	private String political = "";

	/** null */
	private String workorgankey = "";

	/**
	 * 修改时间 private String lastts = "";
	 */

	/** null */
	private String postalcode = "";

	/** 职称 */
	private String postitle = "";

	/** 参见[B00003] 1-男 2-女 */
	private String sex = "";

	/** 密码 */
	private String password = "";
	private String new_password = "";
	private String qr_password = "";

	/** 参见[S00002] 0-禁用 1-正常 2-删除 */
	private String flag = "";

	/** 职务名称 */
	private String position = "";

	/** null */
	private String emailaddress = "";

	/** null */
	private String address = "";

	/** 出生日期 */
	private String birth = "";

	/** 入行日期 */
	private String indate = "";

	/** 员工号 */
	private String stafcode = "";

	/** null */
	private String telephone = "";

	/** 参见[B00004] 1-1级 2-2级 3-3级 4-4级 5-5级 */
	private String worklevel = "";

	/** null */
	private String realname = "";

	/** null */
	private String organkey = "";

	/** null */
	private String userdes = "";

	/** 参见[S00001] 1-是 0-否 */
	private String isadmin = "";

	/** 参见[S00001] 1-是 0-否 
	private String isbuildin = "";*/

	/** 学历 */
	private String education = "";

	/** null */
	private String loginname = "";

	private String poststr = "";

	private String organstr = "";

	/** 角色 */
	private String role;

	private String[] roles;

	/** 数据组 */
	private String dataGroup;

	private String[] dataGroups;

	/** 部门 */
	private String depart = "";

	private String conform_password = "";

	private String organ_disp;

	private String role_disp;
	private String dataGroup_disp;
	private String flag_disp;

	private String[] userids;
	
	private String msgcode;
	
}
