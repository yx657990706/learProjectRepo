package citic.whpsb.wlcx.domain;

/**
 * <p>
 * Br51_cxqq.java
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
public class Br51_cxqq extends BaseVo {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8476648699453221184L;
	
	/** 接收人 */
	private String recipient_p = "";
	
	/** 报文批次号 */
	private String msgseq = "";
	
	/** 最后修改时间 */
	private String last_up_dt = "";
	
	/** 0：待处理 1：待生成报文 2：待打包反馈 3：反馈成功 4：反馈失败 */
	private String status = "";
	
	/** 公安操作时间 */
	private String czsj = "";
	
	/** 银行代码 */
	private String yhdm = "";
	
	/** 接收时间 */
	private String recipient_time = "";
	
	/** 总记录数 */
	private String count = "";
	
	/** 查询日期（分区） */
	private String qrydt = "";
	
	/** 归属机构 */
	private String orgkey = "";
	/** 反馈人 */
	private String feedback_P = "";
	/** 反馈时间 */
	private String feedback_time = "";
	/** 数据报名 */
	private String packetkey = "";
	/** ----------new add----------- */
	private String qrymode = "";
	private String qrymode_disp = "";
	private String party_class_cd = "";
	private String party_class_cd_disp = "";
	private String orgkey_disp = "";
	private String status_disp = "";
	private String czsj_start = "";
	private String czsj_end = "";
	private String qrydt_start = "";
	private String qrydt_end = "";
	private String isFirst = "";
}
