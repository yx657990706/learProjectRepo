/*
 * =============================================
 * Copyright (c) 2014-2015 by CITIC All rights reserved.
 * Created [2017-05-16]
 * =============================================
 */

package citic.cgb.counterterror.web;

/**
 * <p>
 * Bb11_aml_warn_logController.java
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
import citic.cgb.counterterror.domain.Bb11_aml_warn_log;
import citic.cgb.counterterror.service.Bb11_aml_warn_logService;

@Controller
@RequestMapping("/bb11_aml_warn_log")
public class Bb11_aml_warn_logController extends AmlBaseController {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1308110957164694772L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Bb11_aml_warn_logService bb11_aml_warn_logService;
	
	/**
	 * @param model
	 */
	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String performGetBb11_aml_warn_logList(Model model, HttpServletRequest request, Page page, Bb11_aml_warn_log bb11_aml_warn_log) {
		//
		try {
			/** 从session中获取查询对象 */
			Bb11_aml_warn_log searchObj = getSearchObject(bb11_aml_warn_log, page, request);
			List<Bb11_aml_warn_log> bb11_aml_warn_logList = bb11_aml_warn_logService.getBb11_aml_warn_logList(searchObj);
			
			model.addAttribute("statusMap", getSelectMap("S00002"));
			model.addAttribute("bb11_aml_warn_logList", bb11_aml_warn_logList);
			model.addAttribute("pageInfoStr", getPageInfoStr(page));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ("/errors/exception");
		}
		
		//
		return ("/bb11_aml_warn_log/list");
	}
	
	/**
	 * @param model
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	@Token(setToken = true)
	public String performAddBb11_aml_warn_log(Model model) {
		//
		try {
			Bb11_aml_warn_log bb11_aml_warn_log = new Bb11_aml_warn_log();
			
			model.addAttribute("bb11_aml_warn_log", bb11_aml_warn_log);
			//
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ("/errors/exception");
		}
		
		return ("/bb11_aml_warn_log/add");
	}
	
	/**
	 * @param Afp006Dto
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@Token(checkToken = true)
	public String performaddBb11_aml_warn_logDo(@ModelAttribute Bb11_aml_warn_log bb11_aml_warn_log) throws Exception {
		//
		try {
			int i = bb11_aml_warn_logService.insertBb11_aml_warn_log(bb11_aml_warn_log);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ("/errors/exception");
		}
		
		return ("redirect:/bb11_aml_warn_log/list");
	}
	
	/**
	 * @param model
	 */
	@RequestMapping(value = "/{tx_organkey}/modify", method = RequestMethod.GET)
	public String performModifyBb11_aml_warn_log(@PathVariable String tx_organkey, Model model) {
		//
		try {
			Bb11_aml_warn_log bb11_aml_warn_log = new Bb11_aml_warn_log();
			bb11_aml_warn_log = bb11_aml_warn_logService.getBb11_aml_warn_logDisp(tx_organkey);
			
			model.addAttribute("bb11_aml_warn_log", bb11_aml_warn_log);
			//
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ("/errors/exception");
		}
		
		return ("/bb11_aml_warn_log/modify");
	}
	
	/**
	 * @param model
	 */
	@RequestMapping(value = "/{tx_organkey}/modify", method = RequestMethod.POST)
	public String performModifyBb11_aml_warn_logDo(@ModelAttribute Bb11_aml_warn_log bb11_aml_warn_log) throws Exception {
		//
		try {
			int i = bb11_aml_warn_logService.modifyBb11_aml_warn_log(bb11_aml_warn_log);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ("/errors/exception");
		}
		
		return ("/redirect:bb11_aml_warn_log/list");
	}
	
	/**
	 * @param model
	 */
	@RequestMapping(value = "/{tx_organkey}/delete", method = RequestMethod.POST)
	public String performDeleteBb11_aml_warn_logDo(Model model, String tx_organkey) throws Exception {
		//
		try {
			int i = bb11_aml_warn_logService.deleteBb11_aml_warn_log(tx_organkey);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ("/errors/exception");
		}
		
		return ("redirect:/bb11_aml_warn_log/list");
	}
	
	/**
	 * @param model
	 */
	@RequestMapping(value = "/{tx_organkey}/disp", method = RequestMethod.GET)
	public String performGetBb11_aml_warn_logDisp(Model model, String tx_organkey) {
		//
		try {
			Bb11_aml_warn_log bb11_aml_warn_log = new Bb11_aml_warn_log();
			bb11_aml_warn_log = bb11_aml_warn_logService.getBb11_aml_warn_logDisp(tx_organkey);
			
			model.addAttribute("bb11_aml_warn_log", bb11_aml_warn_log);
			//
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ("/errors/exception");
		}
		
		return ("/bb11_aml_warn_log/disp");
	}
}
