/* =============================================
 *  Copyright (c) 2014-2015 by CITIC All rights reserved.
 *  Created [2016-08-18] 
 * =============================================
 */

package citic.gdjc.ckdj.service;

/**
 * <p>Br50_cxqq_mxService.java</p>
 * <p>Description: </p>
 * @author $Author:  $
 */

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import citic.base.BaseService;
import citic.gdjc.ckdj.domain.Br50_cxqq_back;
import citic.gdjc.ckdj.domain.Br50_cxqq_mx;

@Service
public class Br50_cxqq_mxService extends BaseService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 377226780815936777L;

	/** 日志记录器 */
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/** map命名空间 */
	private String namespace = "citic.gdjc.ckdj.mapper.busi.Br50_cxqq_mxMapper.";

	/**
	 * 列表查询，根据查询对象中的page对象属性，确定是否进行分页查询，查询总记录数，放在page对象中
	 * 
	 * @param br50_cxqq_mx
	 *            * @return
	 */
	public List<Br50_cxqq_mx> getBr50_cxqq_mxList(Br50_cxqq_mx br50_cxqq_mx) throws SQLException {
		// 定义转换码表
		String[] cdColumns = new String[] {"orgkey:Dorgan:orgkey_disp","type:G00006:type_disp","querymode:G00013:querymode_disp","idtype:DgdjcZjlx:idtype_disp"};
		List<Br50_cxqq_mx> list = busiDao.selectList(namespace + "selectBr50_cxqq_mxByVo", br50_cxqq_mx);
		// 或在DAO查询中直接转换
		list = codeService.transListOfBean(list, cdColumns);
		return list;
	}
	/**
	 * 查询反馈信息
	 * 
	 * @param br50_cxqq_mx
	 *  * @return
	 */
	public List<Br50_cxqq_back> getBr50_cxqq_backList(Br50_cxqq_back br50_cxqq_back) throws SQLException {
		// 定义转换码表
		String[] cdColumns = new String[] { "status:G00017:status_disp","querymode:G00013:querymode_disp","type:G00006:type_disp","cxfkjg:G00021:cxfkjg_disp","datasource:G00012:datasource_disp"};
		List<Br50_cxqq_back> list = busiDao.selectList(namespace + "selectBr50_cxqq_backListByVo", br50_cxqq_back);
		// 或在DAO查询中直接转换
		list = codeService.transListOfBean(list, cdColumns);
		return list;
	}
	
	/**
	 * 根据主键查询单条记录
	 * 
	 * @param docno
	 *            * @return
	 */
	public Br50_cxqq_mx getBr50_cxqq_mxDisp(String docno) throws SQLException {
		String[] cdColumns = new String[] { "flag:S00002:flag_disp" };

		Br50_cxqq_mx br50_cxqq_mx = busiDao.selectOne(namespace + "selectBr50_cxqq_mxByID", docno, cdColumns);
		if (br50_cxqq_mx == null)
			br50_cxqq_mx = new Br50_cxqq_mx();
		return br50_cxqq_mx;
	}

}
