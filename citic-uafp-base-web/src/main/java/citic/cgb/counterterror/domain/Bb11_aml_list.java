/*
 * =============================================
 * Copyright (c) 2014-2015 by CITIC All rights reserved.
 * Created [2017-05-16]
 * =============================================
 */

package citic.cgb.counterterror.domain;

/**
 * <p>
 * Bb11_aml_list.java
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author $Author: $
 */

import citic.base.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Bb11_aml_list extends BaseVo {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3547478776708573382L;
	
	/** 监控名单唯一标识码 */
	private String source_id = "";
	
	/** 发送时间 */
	private String send_time = "";
	
	/** 证件值 */
	private String idvalue = "";
	
	/** 预留字段 */
	private String remark = "";
	
	/** 名称 */
	private String pname = "";
	
	/** 0：待发送 1：已发送 9：中间状态 */
	private String send_flag = "";
	
	/** +:增加 -:减少 */
	private String act_status = "";
	
	/** F001国内射孔名单 F002中国公安部涉恐名单 F003中国人名银行涉恐名单 F004联合国涉恐名单 */
	private String san_name_type = "";
	
	/** 名单编码 */
	private String md_code = "";
	
	/** yyyy-MM-dd */
	private String data_date = "";
	
	/** add：新增 chg：变更 */
	private String black_action = "";
	
	/** I：个体 C：实体 */
	private String black_class_cd = "";
	
	/** 涉及国外证件类型 */
	private String idtype = "";
	
}
