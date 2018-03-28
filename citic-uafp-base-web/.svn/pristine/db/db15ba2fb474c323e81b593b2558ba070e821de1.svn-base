/*
 * =============================================
 * Copyright (c) 2014-2015 by CITIC All rights reserved.
 * Created [2017-05-16]
 * =============================================
 */

package citic.cgb.task.domain;

/**
 * <p>
 * Bb11_data_task.java
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
public class Bb11_data_task extends BaseVo {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4462684236574705950L;
	
	/** 任务编码：TK+4位编号 eg:TK0001 */
	private String task_id = "";
	
	/** 任务10位日期 */
	private String task_date = "";
	
	/** 任务14或19位时间 与task_date处理任务类型不同 */
	private String task_date_time = "";
	
	/** 任务状态 0：待处理 1：处理中 */
	private String task_status = "";
	private String task_status_disp = "";
	
	/** 备注 */
	private String remark = "";
	
}
