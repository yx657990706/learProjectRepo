package citic.shpsb.wlcx.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import citic.base.BaseVo;

@Data
@EqualsAndHashCode(callSuper=false)
public class Br54_cxqq_back_jyglh  extends BaseVo{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2281032594769499018L;

	/**请求单号*/
	private String bdhm="";
	
	/**报文批次号*/
	private String msgseq="";
	
	/**交易关联号*/
	private String jyglh="";
	

}
