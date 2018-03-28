/*
 * =============================================
 * Copyright (c) 2014-2015 by CITIC All rights reserved.
 * Created [2017-05-16]
 * =============================================
 */

package citic.cgb.counterterror.service;

/**
 * <p>
 * Bb11_aml_warn_logService.java
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author $Author: $
 */

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import citic.aml.base.AmlBaseService;
import citic.cgb.counterterror.domain.Bb11_aml_warn_log;

@Service
public class Bb11_aml_warn_logService extends AmlBaseService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4590972154266500178L;
	
	/** map命名空间 */
	private String namespace = "citic.cgb.counterterror.mapper.busi.Bb11_aml_warn_logMapper.";
	
	/**
	 * 列表查询，根据查询对象中的page对象属性，确定是否进行分页查询，查询总记录数，放在page对象中
	 * 
	 * @param bb11_aml_warn_log * @return
	 */
	public List<Bb11_aml_warn_log> getBb11_aml_warn_logList(Bb11_aml_warn_log bb11_aml_warn_log) throws SQLException {
		// 定义转换码表 
		String[] cdColumns = new String[] {"flag:S00002:flag_disp"};
		List<Bb11_aml_warn_log> list = mngDao.selectList(namespace + "selectBb11_aml_warn_logByVo", bb11_aml_warn_log);
		//或在DAO查询中直接转换  
		list = codeService.transListOfBean(list, cdColumns);
		return list;
	}
	
	/**
	 * 插入单条记录
	 * 
	 * @param bb11_aml_warn_log * @return
	 */
	public int insertBb11_aml_warn_log(Bb11_aml_warn_log bb11_aml_warn_log) throws SQLException {
		int i = mngDao.insert(namespace + "insertBb11_aml_warn_log", bb11_aml_warn_log);
		return i;
	}
	
	/**
	 * 执行更新操作
	 * 
	 * @param bb11_aml_warn_log * @return
	 */
	public int modifyBb11_aml_warn_log(Bb11_aml_warn_log bb11_aml_warn_log) throws SQLException {
		int i = mngDao.update(namespace + "updateBb11_aml_warn_log", bb11_aml_warn_log);
		return i;
	}
	
	/**
	 * 根据主键删除
	 * 
	 * @param tx_organkey * @return
	 */
	public int deleteBb11_aml_warn_log(String tx_organkey) throws SQLException {
		int i = mngDao.delete(namespace + "deleteBb11_aml_warn_logByID", tx_organkey);
		return i;
	}
	
	/**
	 * 根据主键查询单条记录
	 * 
	 * @param tx_organkey * @return
	 */
	public Bb11_aml_warn_log getBb11_aml_warn_logDisp(String tx_organkey) throws SQLException {
		String[] cdColumns = new String[] {"flag:S00002:flag_disp"};
		
		Bb11_aml_warn_log bb11_aml_warn_log = mngDao.selectOne(namespace + "selectBb11_aml_warn_logByID", tx_organkey, cdColumns);
		if (bb11_aml_warn_log == null)
			bb11_aml_warn_log = new Bb11_aml_warn_log();
		return bb11_aml_warn_log;
	}
	
}
