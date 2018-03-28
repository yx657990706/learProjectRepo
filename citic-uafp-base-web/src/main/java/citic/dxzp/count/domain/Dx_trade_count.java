package citic.dxzp.count.domain;

import citic.base.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Dx_trade_count  extends BaseVo{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9115117867336638995L;
	//城市代号
	private String city="";
	private String city_disp="";
	//交易类型
	private String  business_kind="";
	//交易总数
	private String business_num="";
	//交易金额
	private String money="";
	//账卡号
	private  String accountnumber="";
	//查询日期
	private String qrydt="";
	private String qrydt_start="";
	private String qrydt_end="";
}
