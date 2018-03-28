/* =============================================
 *  Copyright (c) 2014-2015 by CITIC All rights reserved.
 *  Created [2016-08-18] 
 * =============================================
 */

package citic.gdjc.ckdj.service;

/**
 * <p>Br50_cxqq_backService.java</p>
 * <p>Description: </p>
 * @author $Author:  $
 */

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import citic.base.BaseService;
import citic.base.annotations.MngTx;
import citic.gdjc.ckdj.domain.Br50_cxqq_back;

@Service
public class Br50_cxqq_backService extends BaseService {

	/** 日志记录器 */
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/** map命名空间 */
	private String namespace = "citic.gdjc.ckdj.mapper.busi.Br50_cxqq_backMapper.";

	/**
	 * 列表查询，根据查询对象中的page对象属性，确定是否进行分页查询，查询总记录数，放在page对象中
	 * 
	 * @param br50_cxqq_back
	 *            * @return
	 */
	public List<Br50_cxqq_back> getBr50_cxqq_backList(Br50_cxqq_back br50_cxqq_back) throws SQLException {
		// 定义转换码表
		String[] cdColumns = new String[] { "flag:S00002:flag_disp" };
		List<Br50_cxqq_back> list = mngDao.selectList(namespace + "selectBr50_cxqq_backByVo", br50_cxqq_back);
		// 或在DAO查询中直接转换
		list = codeService.transListOfBean(list, cdColumns);
		return list;
	}

	/**
	 * 插入单条记录
	 * 
	 * @param br50_cxqq_back
	 *            * @return
	 */
	public int insertBr50_cxqq_back(Br50_cxqq_back br50_cxqq_back) throws SQLException {
		int i = mngDao.insert(namespace + "insertBr50_cxqq_back", br50_cxqq_back);
		return i;
	}

	/**
	 * 执行更新操作
	 * 
	 * @param br50_cxqq_back
	 *            * @return
	 */
	public int modifyBr50_cxqq_back(Br50_cxqq_back br50_cxqq_back) throws SQLException {
		int i = mngDao.update(namespace + "updateBr50_cxqq_back", br50_cxqq_back);
		return i;
	}

	/**
	 * 根据主键删除
	 * 
	 * @param uniqueid
	 *            * @return
	 */
	public int deleteBr50_cxqq_back(String uniqueid) throws SQLException {
		int i = mngDao.delete(namespace + "deleteBr50_cxqq_backByID", uniqueid);
		return i;
	}

	/**
	 * 根据主键查询单条记录
	 * 
	 * @param uniqueid
	 *            * @return
	 */
	public Br50_cxqq_back getBr50_cxqq_backDisp(String uniqueid) throws SQLException {
		String[] cdColumns = new String[] { "flag:S00002:flag_disp" };

		Br50_cxqq_back br50_cxqq_back = mngDao.selectOne(namespace + "selectBr50_cxqq_backByID", uniqueid, cdColumns);
		if (br50_cxqq_back == null)
			br50_cxqq_back = new Br50_cxqq_back();
		return br50_cxqq_back;
	}

}
