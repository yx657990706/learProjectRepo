package citic.shpsb.wlcx.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import citic.base.BaseVo;

@Data
@EqualsAndHashCode(callSuper = false)
public class Br54_cxqq extends BaseVo{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5882682956246372464L;
	
	/** 报文批次号 */
	private String msgseq = "";
	
	/** 银行代码 */
	private String yhdm = "";
	
	/** 数据报名 */
	private String packetkey = "";
	
	/** 公安操作时间 */
	private String czsj = "";
	
	/** 总记录数 */
	private String count = "";
	
	/** 0：等认定 1:待执行  5.待生成报文  6.已生成报文  8：成功 9：失败回执 */
	private String status = "";
	
	/** 归属机构 */
	private String orgkey = "";
	
	/** 查询日期（分区） */
	private String qrydt = "";
	
	/** 接收人 */
	private String recipient_p = "";
	
	/** 接收时间 */
	private String recipient_time = "";
	
	/** 最后修改时间 */
	private String last_up_dt = "";

	/** 反馈人 */
	private String feedback_P = "";
	
	/** 反馈时间 */
	private String feedback_time = "";
	
	/**----------------new  add-----------*/
	/**是否第一次查询 1是  否则   不是*/
    private String 	isFirst="";
    private String qrydt_start = "";
    private String qrydt_end = "";
    private String status_disp="";
    private String orgkey_disp = "";
    private String tjlb="";
    private String party_class_cd="";
    private String party_class_cd_disp="";
    private String qrymode="";
    private String qrymode_disp="";
    private String yhdm_disp = "";

}
