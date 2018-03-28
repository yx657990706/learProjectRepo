/* =============================================
 *  Copyright (c) 2014-2015 by CITIC All rights reserved.
 *  Created [2016-08-18] 
 * =============================================
 */

package citic.gdjc.ckdj.domain;

/**
 * <p>Br50_cxqq_back.java</p>
 * <p>Description: </p>
 * @author $Author:  $
 */

import citic.base.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Br50_cxqq_back extends BaseVo {

	/** 对该查询任务的查询结果描述，成功或失败；01表示成功，02表示失败； */
	private String cxfkjg = "";

	/** 案件编号 */
	private String caseno = "";

	/** 最后修改时间 */
	private String last_up_dt = "";

	/** 协作编号 */
	private String docno = "";

	/** 反馈时间 */
	private String feedback_time = "";

	/** 反馈人 */
	private String feedback_p = "";

	/**
	 * 操作失败相关信息，成功则返回为空。 操作成功但无结果，需注明“未找到符合请求条件的数据”
	 */
	private String czsbyy = "";

	/** 处理时间 */
	private String dealing_time = "";

	/** 处理人 */
	private String dealing_p = "";

	/** 0未处理 1已处理 2 错误回执 */
	private String status = "";

	/** 报文校验结果 */
	private String msgcheckresult = "";

	/** 唯一标识 */
	private String uniqueid = "";

	/** 采用格式YYYYMMDDhhmmss，24小时制格式，例如：20150410082210 */
	private String yhzjsjsj = "";

	/** 查询日期（分区） */
	private String qrydt = "";

	/** 归属机构 */
	private String status_disp = "";
	private String qrydt_start = "";
	private String qrydt_end = "";
	private String type="";
	private String type_disp="";
	private String querymode="";
	private String querymode_disp="";
	private String datasource="";
	private String datasource_disp="";
	private String orgkey = "";
	private String orgkey_disp = "";
	private String cxfkjg_disp = "";
	private String account="";
	//判断是否第一次查询  1 是 反之 否
	private String isFirst="";
}
