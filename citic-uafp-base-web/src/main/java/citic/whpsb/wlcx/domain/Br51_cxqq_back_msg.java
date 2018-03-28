/*
 * =============================================
 * Copyright (c) 2014-2015 by CITIC All rights reserved.
 * Created [2016-08-31]
 * =============================================
 */

package citic.whpsb.wlcx.domain;

/**
 * <p>
 * Br51_cxqq_back_msg.java
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
public class Br51_cxqq_back_msg extends BaseVo {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5180021992678371729L;
	/** 报文批次号 */
	private String msgseq = "";
	/** 序号 */
	private String xh = "";
	
	/** 0未处理 1已上传 */
	private String status = "";
	
	/** 包中报文文件名 */
	private String msg_filename = "";
	
	/** 生成时间 */
	private String create_dt = "";
	
	/** 包中报文文件名+路径 */
	private String msg_filepath = "";
	
	private String create_dt_start = "";
	private String create_dt_end = "";
	private String status_disp = "";
}
