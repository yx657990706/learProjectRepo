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
public class Afp009Dto extends CommonHead {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3826002630186299287L;
	
	/** 请求单号 */
	private String bdhm = "";
	
	/** 序号 */
	private String xh = "";
	
	/** 文件类型 1-文书，2-证件，3-回执文书 */
	private String filetype = "";
	
	/** 请求方文服CD路径 */
	private String cdpath = "";
	
	/** 文书编号*/
	private String wsbh = "";
	
	//==================附加字段==============================
	//错误代码 0：失败 1：成功
	private String errorcode = "";
	//错误描述
	private String errormsg = "";
	
	//文件名
	private String filename = "";
	
}
