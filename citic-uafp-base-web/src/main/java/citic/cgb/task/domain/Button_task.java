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
public class Button_task extends BaseVo {
	
	private static final long serialVersionUID = 7388201714705565303L;
	
	//============查询bb13_sys_para需要的字段====================
	private String code = "";//代码
	private String codename = "";//中文名
	private String des = "";//描述
	private String vals = "";//值
	private String vals_new = "";
	private String flag = "";//生效标识
	
	private String taskkey = "";//任务key
	private String msg = "";//消息
	private String xh = "";//按钮序号
	
	private String in_key = "";//sql中的in条件
	
}
