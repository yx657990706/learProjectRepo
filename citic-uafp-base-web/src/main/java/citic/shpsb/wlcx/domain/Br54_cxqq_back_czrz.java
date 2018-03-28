package citic.shpsb.wlcx.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import citic.base.BaseVo;

@Data
@EqualsAndHashCode(callSuper=false)
public class Br54_cxqq_back_czrz extends BaseVo{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4118307806033551661L;

	/**请求单号*/
	private String  bdhm="";
	
	/**报文批次号*/
	private String msgseq="";
	
	/**IP地址*/
	private String ip="";
	
	/**MAC地址*/
	private String mac="";
	
	/**造作类型*/
	private String czlx="";
	
	/**操作网点*/
	private String zzwd="";
	
	/**操作开始时间*/
	private   String czkssj="";
	
	/**操作结束时间*/
	private String czjssj="";
	
	/**经度*/
	private String lng="";
	
	/**纬度*/
	private String lat="";
	
}
