/* =============================================
*  Copyright (c) 2014-2015 by CITIC All rights reserved.
*  Created [2016-05-23] 
* =============================================
*/

package citic.gajy.wlcx.domain;                
                                                  
/**
* <p>Br40_cxqq_back_pz.java</p>
* <p>Description: </p>
* @author $Author:  $
*/

import citic.base.BaseVo;  
import lombok.Data; 
import lombok.EqualsAndHashCode; 
                                              
@Data                                                  
@EqualsAndHashCode(callSuper = false)                                                  
public class Br40_cxqq_back_pz_attach extends BaseVo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7489502922783969154L;
	
	/** 监管类别 */
	private String tasktype = "";
	/** 主键， 请求单流水号，用于唯一标识查控请求单 */
	private String qqdbs = "";
	/** 任务流水号 */
	private String rwlsh = "";
	/**文件名 */                                         
	private String filename = "";
	/**文件路径 */
	private String filepath = "";
	/**编号 */
	private String seq = "";
	/**附件序号 */
	private String xh = "";
}
