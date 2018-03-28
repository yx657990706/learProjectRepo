/*
 * =============================================
 * Copyright (c) 2014-2015 by CITIC All rights reserved.
 * Created [2017-05-16]
 * =============================================
 */

package citic.cgb.task.service;

/**
 * <p>
 * Bb11_data_taskService.java
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
import citic.cgb.task.domain.Bb11_data_task;

@Service
public class Bb11_data_taskService extends AmlBaseService {
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2458976550536002038L;
	/** map命名空间 */
	private String namespace = "citic.cgb.task.mapper.busi.Bb11_data_taskMapper.";
	
	/**
	 * 列表查询，根据查询对象中的page对象属性，确定是否进行分页查询，查询总记录数，放在page对象中
	 * 
	 * @param bb11_aml_list * @return
	 */
	public List<Bb11_data_task> getBb11_data_taskList(Bb11_data_task bb11_data_task) throws SQLException {
		// 定义转换码表 
		String[] cdColumns = new String[] {"task_status:G00049:task_status_disp"};
		List<Bb11_data_task> list = busiDao.selectList(namespace + "selectBb11_data_taskByVo", bb11_data_task);
		//或在DAO查询中直接转换  
		list = codeService.transListOfBean(list, cdColumns);
		return list;
	}
	
	/**
	 * 执行更新操作
	 * 
	 * @param bb11_aml_list * @return
	 */
	public int modifyBb11_data_taskStatus(String task_id) throws SQLException {
		int i = busiDao.update(namespace + "updateStatusByID", task_id);
		return i;
	}
	
	
}
