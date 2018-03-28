/*
 * =============================================
 * Copyright (c) 2014-2015 by CITIC All rights reserved.
 * Created [2017-05-16]
 * =============================================
 */

package citic.cgb.xmlmsg.domain;



import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Afp007Dto extends CommonHead {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 508251798275600946L;
	
	private String bdhm = "";//请求单号
	private String khzh = "";//被执行人账号
	private String xm = "";//被查询人姓名
	private String zjlx = "";//证件类型
	private String dsrzjhm = "";//被查询人证件/组织机构号码
	private String bz = "";//币种
	private String sfjh = "";//是否结汇
	private String fydm = "";//法院代码
	private String fymc = "";//法院名称
	private String begindate = "";//任务开始日期
	private String enddate = "";//任务结束日期
	private String ckwh = "";//裁定文书号
	private String status = "";//任务状态
	private String currpage = "";// 当前页码
	private String currcount = "";//每页输出行数

	private List<Afp007QueryDto> resultList = null; //查询结果列表
	
	//==================附加字段==============================
	//错误代码 0：失败 1：成功
	private String errorcode = "";
	//错误描述
	private String errormsg = "";
	

}
