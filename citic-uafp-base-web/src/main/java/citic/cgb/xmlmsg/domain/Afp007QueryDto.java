/*
 * =============================================
 * Copyright (c) 2014-2015 by CITIC All rights reserved.
 * Created [2017-05-16]
 * =============================================
 */

package citic.cgb.xmlmsg.domain;



import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Afp007QueryDto  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8076867624542522423L;

	private String bdhm = "";//控制请求单号
	private String ccxh = "";//序号
	private String xm = "";//被查询人姓名
	private String zjlx = "";//证件类型
	private String dsrzjhm = "";//被查询人证件/组织机构号码
	private String khzh = "";//被执行人开户账号
	private String glzhhm = "";//被执行人开户账号子账号
	private String zhlx = "";//被执行人开户账号类型
	private String cclb = "";//被执行人账户类别
	private String khwd = "";//被执行人开户网点
	private String khwddm = "";//被执行人开户网点代码
	private String ksrq = "";//申请控制开始时间
	private String jsrq = "";//申请控制结束时间
	private String bz = "";//申请控制金额币种
	private String je = "";//申请控制金额（数额）
	private String sfjh = "";//是否结汇
	private String fymc = "";//执行法院名称
	private String fydm = "";//执行法院代码
	private String cbr = "";//承办法官
	private String yhdh = "";//承办法官联系电话
	private String ah = "";//执行案号
	private String gzzbh = "";//承办法官工作证编号
	private String gwzbh = "";//承办法官公务证编号
	private String lxfs = "";//承办人联系地址
	private String ckwh = "";//裁定书文号
	private String zxkzhhm = "";//收款专户户名
	private String zxkzhkhh = "";//收款专户开户行
	private String zxkzhkhhhh = "";//收款专户开户行行号
	private String zxkzhzh = "";//收款专户账号
	private String zxkzhlx = "";//收款专户类型
	private String ydjah = "";//原冻结案号
	private String ydjdh = "";//原冻结请求单号
	private String beiz = "";//回执备注信息
	private String wnkzyy = "";//失败原因
	private String mxresult = "";//处理结果	
	private String status = "";//任务状态 H-待执行；S-补录；R-拒绝；O-成功；C-成功（待核实）N-待处理 F-核心处理失败  X-失败（二代失败或冻结失败）
	private String recipient_time = "";//系统接收请求时间
	private String kzcs = "";//控制措施  01-冻结，02-继续冻结，04-解除冻结，06-扣划
	
	private String kzlx = "";//控制类型  1-存款，2-非存款类金融资产。
	private String kznr = "";// 1-账户下的资金,2-账户（在先对控制类型判断结束后再针对控制内容进行判断）（当控制措施非06时）
	private String sxzh = "";//收息账号
	private String sxzhmc = "";//收息账户名
	private String sxzhkhhh = "";//收息账户开户行号
	private String sxzhkhhmc = "";//收息账户开户行名称
	private String userid = "";//操作员
	private String checkuserid = "";//复合员
	
	private String zcmc = "";//金融资产名称
	private String zclx = "";//金融资产类型
	private String cpxszl = "";//产品销售种类
	private String dqh = "";//地区号
	private String jrcpbh = "";//金融产品编号
	private String lczh = "";//理财账号
	private String zjhkzh = "";//资金回款账户
	private String se = "";//申请控制数量/份额/金额
	private String jldw = "";//计量单位

}
