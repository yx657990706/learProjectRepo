/*
 * =============================================
 * Copyright (c) 2014-2015 by CITIC All rights reserved.
 * Created [2016-08-31]
 * =============================================
 */

package citic.shpsb.wlcx.service;

/**
 * <p>
 * Br51_cxqq_mxService.java
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author $Author: $
 */

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import citic.base.BaseService;
import citic.shpsb.wlcx.domain.Br54_cxqq_back;
import citic.shpsb.wlcx.domain.Br54_cxqq_back_acct;
import citic.shpsb.wlcx.domain.Br54_cxqq_back_card;
import citic.shpsb.wlcx.domain.Br54_cxqq_back_czrz;
import citic.shpsb.wlcx.domain.Br54_cxqq_back_ddzh;
import citic.shpsb.wlcx.domain.Br54_cxqq_back_jyglh;
import citic.shpsb.wlcx.domain.Br54_cxqq_back_msg;
import citic.shpsb.wlcx.domain.Br54_cxqq_back_party;
import citic.shpsb.wlcx.domain.Br54_cxqq_back_trans;

@Service
public class Br54_cxqq_backService extends BaseService {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2255129290888022846L;
	
	/** 日志记录器 */
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/** map命名空间 */
	private String namespace = "citic.shpsb.mapper.busi.Br54_cxqq_backMapper.";
	
	/**
	 * 列表查询，根据查询对象中的page对象属性，确定是否进行分页查询，查询总记录数，放在page对象中
	 * 
	 * @param br51_cxqq_mx
	 * @return
	 */
	public List<Br54_cxqq_back> getBr54_cxqq_backList(Br54_cxqq_back Br54_cxqq_back) throws SQLException {
		// 定义转换码表  
		String[] cdColumns = new String[] {"cljg:G00038:cljg_disp", "qrymode:G00030:qrymode_disp", "orgkey:Dorgan:orgkey_disp", "status:G00039:status_disp",
											"party_class_cd:G00037:party_class_cd_disp"};
		List<Br54_cxqq_back> list = busiDao.selectList(namespace + "selectBr54_cxqq_backByVo", Br54_cxqq_back);
		//或在DAO查询中直接转换  
		list = codeService.transListOfBean(list, cdColumns);
		return list;
	}
	
	/**
	 * 查询反馈账户信息
	 * 
	 * @param br51_cxqq_back
	 * @return
	 */
	public List<Br54_cxqq_back_acct> getBr54_cxqq_back_acctList(Br54_cxqq_back Br54_cxqq_back) throws SQLException {
		// 定义转换码表  
		String[] cdColumns = new String[] {"hbzl:Dshgabz:hbzl_disp", "zhzt:G00042:zhzt_disp"};
		List<Br54_cxqq_back_acct> list = busiDao.selectList(namespace + "selectBr54_cxqq_back_acctListByVo", Br54_cxqq_back);
		//或在DAO查询中直接转换  
		list = codeService.transListOfBean(list, cdColumns);
		return list;
	}
	
	/**
	 * 查询交易明细信息
	 * 
	 * @param br51_cxqq_back
	 * @return
	 */
	public List<Br54_cxqq_back_trans> getBr54_cxqq_back_transtList(Br54_cxqq_back Br54_cxqq_back) throws SQLException {
		// 定义转换码表  
		String[] cdColumns = new String[] {"dfzzlx:Dshgrzjlx:dfzzlx_disp", "bz:Dshgabz:bz_disp", "jdbz:G00041:jdbz_disp"};
		List<Br54_cxqq_back_trans> list = busiDao.selectList(namespace + "selectBr54_cxqq_back_transListByVo", Br54_cxqq_back);
		//或在DAO查询中直接转换  
		list = codeService.transListOfBean(list, cdColumns);
		return list;
	}
	
	/**
	 * 查询操作日志
	 * 
	 * @param br51_cxqq_back
	 * @return
	 */
	public List<Br54_cxqq_back_czrz> getBr54_cxqq_back_czrztList(Br54_cxqq_back Br54_cxqq_back) throws SQLException {
		// 定义转换码表  
		List<Br54_cxqq_back_czrz> list = busiDao.selectList(namespace + "selectBr54_cxqq_back_czrzListByVo", Br54_cxqq_back);
		//或在DAO查询中直接转换  
		list = codeService.transListOfBean(list, null);
		return list;
	}
	
	/**
	 * 查询对端账号信息
	 * 
	 * @param br51_cxqq_back_ddzh
	 * @return
	 */
	public List<Br54_cxqq_back_ddzh> getBr54_cxqq_back_ddzhtList(Br54_cxqq_back Br54_cxqq_back) throws SQLException {
		// 定义转换码表  
		List<Br54_cxqq_back_ddzh> list = busiDao.selectList(namespace + "selectBr54_cxqq_back_ddzhListByVo", Br54_cxqq_back);
		//或在DAO查询中直接转换  
		list = codeService.transListOfBean(list, null);
		return list;
	}
	
	/**
	 * 查询交易关联号
	 * 
	 * @param br51_cxqq_back
	 * @return
	 */
	public List<Br54_cxqq_back_jyglh> getBr54_cxqq_back_jyglhtList(Br54_cxqq_back Br54_cxqq_back) throws SQLException {
		// 定义转换码表  
		String[] cdColumns = new String[] {"zzlx:DwhZjlx:zzlx_disp", "cljg:G00025:cljg_disp"};
		List<Br54_cxqq_back_jyglh> list = busiDao.selectList(namespace + "selectBr54_cxqq_back_jyglhListByVo", Br54_cxqq_back);
		//或在DAO查询中直接转换  
		list = codeService.transListOfBean(list, cdColumns);
		return list;
	}
	
	/**
	 * 查询反馈文件信息
	 * 
	 * @param br51_cxqq_back
	 * @return
	 */
	public List<Br54_cxqq_back_msg> getBr54_cxqq_back_msgtList(Br54_cxqq_back Br54_cxqq_back) throws SQLException {
		// 定义转换码表  
		String[] cdColumns = new String[] {"status:DwhZjlx:status_disp"};
		List<Br54_cxqq_back_msg> list = busiDao.selectList(namespace + "selectBr54_cxqq_back_msgListByVo", Br54_cxqq_back);
		//或在DAO查询中直接转换  
		list = codeService.transListOfBean(list, cdColumns);
		return list;
	}
	
	/**
	 * 列表查询，根据查询对象中的page对象属性，确定是否进行分页查询，查询总记录数，放在page对象中 getBr54_cxqq_back_mxList
	 * 
	 * @param br51_cxqq_mx
	 * @return
	 */
	public List<Br54_cxqq_back> getBr54_cxqq_back_dispList(Br54_cxqq_back Br54_cxqq_back) throws SQLException {
		// 定义转换码表  
		String[] cdColumns = new String[] {"zzlx:DwhZjlx:zzlx_disp", "cljg:G00025:cljg_disp"};
		List<Br54_cxqq_back> list = busiDao.selectList(namespace + "selectBr54_cxqq_backByVo", Br54_cxqq_back);
		//或在DAO查询中直接转换  
		list = codeService.transListOfBean(list, cdColumns);
		return list;
	}
	
	/**
	 * 根据主键查询单条记录 持卡人信息查询
	 * 
	 * @param bdhm
	 * @return
	 */
	public Br54_cxqq_back_card getBr54_cxqq_back_cardDisp(Br54_cxqq_back br54_cxqq_back) throws SQLException {
		String[] cdColumns = new String[] {"zzlx:DwhZjlx:zzlx_disp"};
		Br54_cxqq_back_card br54_cxqq_back_card = busiDao.selectOne(namespace + "selectBr54_cxqq_back_cardByID", br54_cxqq_back, cdColumns);
		if (br54_cxqq_back_card == null)
			br54_cxqq_back_card = new Br54_cxqq_back_card();
		return br54_cxqq_back_card;
	}
	
	/**
	 * 根据主键查询单条记录 开户资料查询
	 * 
	 * @param bdhm
	 * @return
	 */
	public Br54_cxqq_back_party getBr54_cxqq_back_partyDisp(Br54_cxqq_back br54_cxqq_back) throws SQLException {
		String[] cdColumns = new String[] {"dbrzzlx:Dshgrzjlx:dbrzzlx_disp", "frdbzjlx:Dshqyzjlx:frdbzjlx_disp"};
		Br54_cxqq_back_party br54_cxqq_back_party = busiDao.selectOne(namespace + "selectBr54_cxqq_back_partyByID", br54_cxqq_back, cdColumns);
		if (br54_cxqq_back_party == null)
			br54_cxqq_back_party = new Br54_cxqq_back_party();
		return br54_cxqq_back_party;
	}
	
}
