package citic.aml.system.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import citic.base.BaseVo;

@Data
@EqualsAndHashCode(callSuper = false)
public class Citrth_statistics  extends BaseVo{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3856936002406676809L;

	/*交易日期*/
	private   String  ac_dt="";
	
	/*名单类型*/
    private String    lst_cd="";	
    
    /*收款方账户*/
    private String  col_ac="";
    
    /*渠道大类*/
    private String  chnl1="";
    
    /*交易金额*/
    private  String tx_amt="";
    
    /**---------------new add-----------*/
    /*涉案总金额*/
    private String money="";
    /*拦截次数*/
    private String  num="";
    /*涉案账户数*/
    private String  account_num="";
    private String  ac_dt_start="";
    private String  ac_dt_end="";
    /*总拦截次数*/
    private String total_num="";
   /*总的拦截账户数*/
    private String tal_account_num="";
    /*总的拦截金额*/
    private String tal_money="";
}
