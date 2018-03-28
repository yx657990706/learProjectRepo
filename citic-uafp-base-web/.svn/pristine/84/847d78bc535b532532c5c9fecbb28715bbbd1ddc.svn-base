/*
 * =============================================
 * Copyright (c) 2014-2015 by CITIC All rights reserved.
 * Created [2017-05-16]
 * =============================================
 */

package citic.cgb.counterterror.web;

/**
 * <p>
 * Bb11_aml_listController.java
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import citic.aml.base.AmlBaseController;
import citic.base.Page;
import citic.base.annotations.Token;
import citic.cgb.counterterror.domain.Bb11_aml_list;
import citic.cgb.counterterror.service.Bb11_aml_listService;

@Controller
@RequestMapping("/bb11_aml_list")
public class Bb11_aml_listController extends AmlBaseController {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6267791836714860311L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Bb11_aml_listService bb11_aml_listService;
	
	/**
	 * @param model
	 */
	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String performGetBb11_aml_listList(Model model, HttpServletRequest request, Page page, Bb11_aml_list bb11_aml_list) {
		//
		try {
			/** 从session中获取查询对象 */
			Bb11_aml_list searchObj = getSearchObject(bb11_aml_list, page, request);
			List<Bb11_aml_list> bb11_aml_listList = bb11_aml_listService.getBb11_aml_listList(searchObj);
			
			model.addAttribute("statusMap", getSelectMap("S00002"));
			model.addAttribute("bb11_aml_listList", bb11_aml_listList);
			model.addAttribute("pageInfoStr", getPageInfoStr(page));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ("/errors/exception");
		}
		
		//
		return ("/bb11_aml_list/list");
	}
	
	/**
	 * @param model
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	@Token(setToken = true)
	public String performAddBb11_aml_list(Model model) {
		//
		try {
			Bb11_aml_list bb11_aml_list = new Bb11_aml_list();
			
			model.addAttribute("bb11_aml_list", bb11_aml_list);
			//
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ("/errors/exception");
		}
		
		return ("/bb11_aml_list/add");
	}
	
	/**
	 * @param Bb11_aml_list
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@Token(checkToken = true)
	public String performaddBb11_aml_listDo(@ModelAttribute Bb11_aml_list bb11_aml_list) throws Exception {
		//
		try {
			int i = bb11_aml_listService.insertBb11_aml_list(bb11_aml_list);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ("/errors/exception");
		}
		
		return ("redirect:/bb11_aml_list/list");
	}
	
	/**
	 * @param model
	 */
	@RequestMapping(value = "/{md_code}/modify", method = RequestMethod.GET)
	public String performModifyBb11_aml_list(@PathVariable String md_code, Model model) {
		//
		try {
			Bb11_aml_list bb11_aml_list = new Bb11_aml_list();
			bb11_aml_list = bb11_aml_listService.getBb11_aml_listDisp(md_code);
			
			model.addAttribute("bb11_aml_list", bb11_aml_list);
			//
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ("/errors/exception");
		}
		
		return ("/bb11_aml_list/modify");
	}
	
	/**
	 * @param model
	 */
	@RequestMapping(value = "/{md_code}/modify", method = RequestMethod.POST)
	public String performModifyBb11_aml_listDo(@ModelAttribute Bb11_aml_list bb11_aml_list) throws Exception {
		//
		try {
			int i = bb11_aml_listService.modifyBb11_aml_list(bb11_aml_list);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ("/errors/exception");
		}
		
		return ("/redirect:bb11_aml_list/list");
	}
	
	/**
	 * @param model
	 */
	@RequestMapping(value = "/{md_code}/delete", method = RequestMethod.POST)
	public String performDeleteBb11_aml_listDo(Model model, String md_code) throws Exception {
		//
		try {
			int i = bb11_aml_listService.deleteBb11_aml_list(md_code);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ("/errors/exception");
		}
		
		return ("redirect:/bb11_aml_list/list");
	}
	
	/**
	 * @param model
	 */
	@RequestMapping(value = "/{md_code}/disp", method = RequestMethod.GET)
	public String performGetBb11_aml_listDisp(Model model, String md_code) {
		//
		try {
			Bb11_aml_list bb11_aml_list = new Bb11_aml_list();
			bb11_aml_list = bb11_aml_listService.getBb11_aml_listDisp(md_code);
			
			model.addAttribute("bb11_aml_list", bb11_aml_list);
			//
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ("/errors/exception");
		}
		
		return ("/bb11_aml_list/disp");
	}
}
