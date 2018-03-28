/*
 * =============================================
 * Copyright (c) 2014-2015 by CITIC All rights reserved.
 * Created [2017-05-16]
 * =============================================
 */

package citic.cgb.xmlmsg.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Afp013QueryDto extends CommonHead {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4807065088961653914L;
	
	private String bdhm = "";//请求单号
	private String xm = "";//被查询人姓名
	private String zjlx = "";//证件类型
	private String dsrzjhm = "";//被查询人证件/组织机构号码
	private String fymc = "";//执行法院名称
	private String fydm = "";//执行法院代码
	private String cbr = "";//承办法官
	private String yhdh = "";//承办法官联系电话
	private String ah = "";//执行案号
	private String gzzbh = "";//承办法官工作证编号
	private String gwzbh = "";//承办法官公务证编号
	private String ckh = "";//查询法律文书名称
	private String wsbh = "";//文书编号
	private String ckkssj = "";//账户资金往来交易信息查询开始时间
	private String ckjssj = "";//账户资金往来交易信息查询结束时间
	private String qrydt = "";//任务查询日期

}
