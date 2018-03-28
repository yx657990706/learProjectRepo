/*
 * =============================================
 * Copyright (c) 2014-2015 by CITIC All rights reserved.
 * Created [2017-05-16]
 * =============================================
 */

package citic.cgb.task.web;

/**
 * <p>
 * Bb11_data_taskController.java
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author $Author: $
 */

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import citic.aml.base.AmlBaseController;
import citic.base.Page;
import citic.cgb.task.domain.Bb11_data_task;
import citic.cgb.task.service.Bb11_data_taskService;

@Controller
@RequestMapping("/bb11_data_task")
public class Bb11_data_taskController extends AmlBaseController {


	/**
	 * 
	 */
	private static final long serialVersionUID = -2513046015304045816L;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Bb11_data_taskService bb11_data_taskService;
	
	/**
	 * @param model
	 */
	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String performGetBb11_data_taskList(Model model, HttpServletRequest request, Page page, Bb11_data_task bb11_data_task) {
		//
		try {
			/** 从session中获取查询对象 */
			Bb11_data_task searchObj = getSearchObject(bb11_data_task, page, request);
			List<Bb11_data_task> bb11_data_taskList = bb11_data_taskService.getBb11_data_taskList(searchObj);
			
			model.addAttribute("statusMap", getSelectMap("G00049"));
			model.addAttribute("bb11_data_taskList", bb11_data_taskList);
			model.addAttribute("pageInfoStr", getPageInfoStr(page));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ("/errors/exception");
		}
		
		return ("/cgb/task/bb11_data_task_list");
	}
	
	/**
	 * 任务重算
	 * <br>将任务状态重置为0
	 * @param task_id
	 * @return
	 * @throws Exception
	 * 
	 * @author yinxiong
	 * @date 2017年6月9日 上午9:17:00
	 */
	@RequestMapping(value = "/{task_id}/recal", method = RequestMethod.POST)
	public String performModifyBb11_aml_listStatusDo(@PathVariable String task_id) throws Exception {
		try {
			bb11_data_taskService.modifyBb11_data_taskStatus(task_id);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ("/errors/exception");
		}
		
		return ("redirect:/bb11_data_task/list?isNewSearch=1");
	}	

}
