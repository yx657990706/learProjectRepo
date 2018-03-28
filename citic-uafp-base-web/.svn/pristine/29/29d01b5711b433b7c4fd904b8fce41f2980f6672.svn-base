/* =============================================
 *  Copyright (c) 2014-2015 by CITIC All rights reserved.
 *  Created [2016-04-15] 
 * =============================================
 */

package citic.dxzp.ct.domain;

/**
 * <p>Cgb_risk_case.java</p>
 * <p>Description: </p>
 * @author $Author:  $
 */

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.springframework.web.multipart.MultipartFile;

import citic.base.BaseVo;

@Data
@EqualsAndHashCode(callSuper = false)
public class Ct_yjmd extends BaseVo {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5525543220835074469L;

	/**编码  */
	private String file_code = "";

	/**文件名称  */
	private String file_name = "";

	/** 文件路径 */
	private String file_path = "";

	/** 文件大小 */
	private String file_size = "";

	/** 名单类型  01 个人   02 单位*/
	private String md_type = "";
	private String md_type_disp = "";
	
	/** 上传时间 */
	private String create_dt = "";

	/**  上传人*/
	private String create_user = "";

	/** 状态（0：待处理 1：处理成功 2：处理失败） */
	private String status_cd = "";
	private String status_cd_disp = "";

	/** 处理失败 说明 */
	private String instructions = "";

	/** 处理时间 */
	private String deal_dt = "";

	// 上传文件
	private MultipartFile md_file;
	
	//客户名称
	private String customer_name = "";

}
