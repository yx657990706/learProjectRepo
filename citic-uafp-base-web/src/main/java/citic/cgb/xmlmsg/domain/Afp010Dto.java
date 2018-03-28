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
public class Afp010Dto extends CommonHead {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8060637399770965323L;
	
	private String bdhm = "";//请求单号
	private String begindate = "";//任务开始日期
	private String enddate = "";//任务结束日期
	private String khzh = "";//被执行人账号
	private String xm = "";//被查询人姓名
	private String zjlx = "";//证件类型
	private String dsrzjhm = "";//被查询人证件/组织机构号码
	private String khhsh = "";//开户行所号  对应khwddm(开户网点代码)字段
	private String khhfhh = "";//开户行分行号
	private String bz = "";//币种
	private String je = "";//金额
	private String sfjh = "";//是否结汇
	private String kzlx = "";////控制类型（1-存款，2-非存款类金融资产）
	private String kzcs = "";//控制措施
	private String status = "";//任务状态
	private String fydm = "";//法院代码
	private String fymc = "";//法院名称
	private String ckwh = "";//裁定文书号
	private String currpage = "";//当前页码
	private String currcount = "";//每页输出行数
	
	private List<Afp007QueryDto> resultList = null; //查询结果列表
	
	//==================附加字段==============================
	//错误代码 0：失败 1：成功
	private String errorcode = "";
	//错误描述
	private String errormsg = "";
	//文件名
	private String filename = "";
	
}
