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

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import citic.aml.base.AmlBaseService;
import citic.base.annotations.BusiTx;
import citic.cgb.task.domain.Button_task;

@Service
public class Button_taskService extends AmlBaseService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2367296563169504351L;
	/** map命名空间 */
	private String namespace = "citic.cgb.task.mapper.busi.Button_taskMapper.";
	private final int NUM = 800;//单次最大in条件
	
	/**
	 * 根据id查询配置
	 * 
	 * @param button_task
	 * @return
	 * @throws Exception
	 * @author yinxiong
	 * @date 2017年7月24日 上午10:43:07
	 */
	public Button_task getBb11_data_taskByID(Button_task button_task) throws Exception {
		
		button_task.setCode("gf.start.control.out");
		button_task.setFlag("1");//0：无效 1：有效
		Button_task sysPara = busiDao.selectOne(namespace + "selectBb13_sys_paraValsByVo", button_task);
		
		return sysPara;
	}
	
	/**
	 * 01高法TASK3特殊情况重算
	 * 
	 * @return
	 * @throws Exception
	 * @author yinxiong
	 * @date 2017年7月24日 下午3:50:07
	 */
	public boolean doGFRecal() throws Exception {
		boolean flag = false;
		//查询fail状态的bdhm
		List<String> list = busiDao.selectList(namespace + "selectTaskkeyByCode", null);
		if (list != null && list.size() > 0) {
			//判断size，一次最多处理800
			int size = list.size();
			int m = size / NUM;//整数部分
			int n = size % NUM;//余数部分
			for (int i = 0; i < m; i++) {
				List<String> subListA = list.subList(i * NUM, (i + 1) * NUM);
				this.GFcal(subListA);
			}
			if (n > 0) {
				List<String> subListB = list.subList(m * NUM, size);
				this.GFcal(subListB);
			}
			flag = true;
		} else {
			flag = true;
		}
		return flag;
	}
	
	/**
	 * 02根据id修改配置
	 * 
	 * @param button_task
	 * @return
	 * @throws Exception
	 * @author yinxiong
	 * @date 2017年7月24日 下午2:59:25
	 */
	public int updateBb13_sys_paraByID(Button_task button_task) throws Exception {
		
		button_task.setCode("gf.start.control.out");
		button_task.setVals_new(StringUtils.equals("1", button_task.getVals()) ? "0" : "1");//开关切换
		
		int i = busiDao.update(namespace + "updateBb13_sys_paraByID", button_task);
		
		return i;
	}
	
	/**
	 * TASK3任务重置
	 * 
	 * @param list
	 * @throws Exception
	 * @author yinxiong
	 * @date 2017年7月24日 下午3:58:43
	 */
	@BusiTx
	private void GFcal(List<String> list) throws Exception {
		String keys = "";
		for (String taskkey : list) {
			keys += ",'" + taskkey + "'";
		}
		keys = keys.substring(1);
		// 重置task3任务1.将任务表中serverid置为空串 2.状态表中相关数据删除
		busiDao.update(namespace + "batchUpdateMc21_task_fact3ByIn", keys);
		busiDao.delete(namespace + "batchDeleteMc21_task_statusByIn", keys);
	}
	
}
