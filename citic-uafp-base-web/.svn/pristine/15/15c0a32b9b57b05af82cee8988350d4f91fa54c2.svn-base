/*
 * =============================================
 * Copyright (c) 2014-2015 by CITIC All rights reserved.
 * Created [2017-05-16]
 * =============================================
 */

package citic.cgb.counterterror.service;

/**
 * <p>
 * Bb11_aml_listService.java
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
import citic.cgb.counterterror.domain.Bb11_aml_list;

@Service
public class Bb11_aml_listService extends AmlBaseService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2428865527196847324L;
	
	/** map命名空间 */
	private String namespace = "citic.cgb.counterterror.mapper.busi.Bb11_aml_listMapper.";
	
	/**
	 * 列表查询，根据查询对象中的page对象属性，确定是否进行分页查询，查询总记录数，放在page对象中
	 * 
	 * @param bb11_aml_list * @return
	 */
	public List<Bb11_aml_list> getBb11_aml_listList(Bb11_aml_list bb11_aml_list) throws SQLException {
		// 定义转换码表 
		String[] cdColumns = new String[] {"flag:S00002:flag_disp"};
		List<Bb11_aml_list> list = mngDao.selectList(namespace + "selectBb11_aml_listByVo", bb11_aml_list);
		//或在DAO查询中直接转换  
		list = codeService.transListOfBean(list, cdColumns);
		return list;
	}
	
	/**
	 * 插入单条记录
	 * 
	 * @param bb11_aml_list * @return
	 */
	public int insertBb11_aml_list(Bb11_aml_list bb11_aml_list) throws SQLException {
		int i = mngDao.insert(namespace + "insertBb11_aml_list", bb11_aml_list);
		return i;
	}
	
	/**
	 * 执行更新操作
	 * 
	 * @param bb11_aml_list * @return
	 */
	public int modifyBb11_aml_list(Bb11_aml_list bb11_aml_list) throws SQLException {
		int i = mngDao.update(namespace + "updateBb11_aml_list", bb11_aml_list);
		return i;
	}
	
	/**
	 * 根据主键删除
	 * 
	 * @param md_code * @return
	 */
	public int deleteBb11_aml_list(String md_code) throws SQLException {
		int i = mngDao.delete(namespace + "deleteBb11_aml_listByID", md_code);
		return i;
	}
	
	/**
	 * 根据主键查询单条记录
	 * 
	 * @param md_code * @return
	 */
	public Bb11_aml_list getBb11_aml_listDisp(String md_code) throws SQLException {
		String[] cdColumns = new String[] {"flag:S00002:flag_disp"};
		
		Bb11_aml_list bb11_aml_list = mngDao.selectOne(namespace + "selectBb11_aml_listByID", md_code, cdColumns);
		if (bb11_aml_list == null)
			bb11_aml_list = new Bb11_aml_list();
		return bb11_aml_list;
	}
	
}
