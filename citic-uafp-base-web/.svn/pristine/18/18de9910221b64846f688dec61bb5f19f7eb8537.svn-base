/* =============================================
 *  Copyright (c) 2014-2015 by CITIC All rights reserved.
 *  Created [2016-02-29] 
 * =============================================
 */

package citic.dxzp.cases.service;

/**
 * <p>Br22_caseService.java</p>
 * <p>Description: </p>
 * @author $Author:  $
 */


import org.springframework.stereotype.Service;

import citic.aml.base.AmlBaseService;
import citic.base.annotations.BusiTx;
import citic.base.utils.DtUtils;
import citic.dxzp.cases.domain.Br22_attach;
import citic.dxzp.cases.domain.Br22_case;
import citic.dxzp.cases.domain.Br22_stop;
import citic.dxzp.datainfo.domain.Bb21_trans;

@Service
public class Br22_case_cgbService extends AmlBaseService {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7954083877700020666L;
	/** map命名空间 */
	private String namespace = "citic.dxzp.cases.mapper.busi.Br22_case_cgbMapper.";

	/**
	 * 插入记录
	 * 插入案件。关系。交易。止付表数据
	 * @param br22_case
	 *            * @return
	 */
	@BusiTx
	public void insertInfo(Br22_case br22_case ,Bb21_trans bb21_trans){
		//数据准备 
		Br22_stop br22_stop = new Br22_stop();
		br22_stop.setCaseid(bb21_trans.getCaseid());//案件编号
		br22_stop.setHxappid(bb21_trans.getHxappid());//冻结编号
		br22_stop.setResult(bb21_trans.getIsceased());//是否已止付
		br22_stop.setCardnumber(bb21_trans.getCardnumber());//卡折号
		br22_stop.setCurrency(bb21_trans.getCurrency());//币种
		br22_stop.setAccountbalance(bb21_trans.getAccountbalance());//余额
		br22_stop.setFeedback_dt(DtUtils.getNowTime());//反馈时间
		//插入案件主表数据
		busiDao.insert(namespace + "insertBr22_case", br22_case);
		//插入关系表数据
		busiDao.insert(namespace + "insertBr22_case_trans", bb21_trans);
		//插入交易表数据
		busiDao.insert(namespace + "insertBr21_trans", bb21_trans);
		//插入止付反馈登记表数据
		busiDao.insert(namespace + "insertBr22_stop", br22_stop);
	}

	public void insertFileAttach(Br22_attach attach){
		//插入止付反馈登记表数据
		busiDao.insert(namespace + "insertBr22_attach", attach);
	}
}
