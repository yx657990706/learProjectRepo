/* =============================================
 *  Copyright (c) 2014-2015 by CITIC All rights reserved.
 *  Created [2016-06-06] 
 * =============================================
 */

package citic.gajy.wlkz.web;

/**
 * <p>Br41_kzqq_hzwsController.java</p>
 * <p>Description: </p>
 * @author $Author:  $
 */

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import citic.aml.system.domain.Mp02_user;
import citic.base.Page;
import citic.base.annotations.Token;
import citic.base.utils.StrUtils;
import citic.gajy.wlkz.domain.Br41_kzqq_hzws;
import citic.gajy.wlkz.service.Br41_kzqq_hzwsService;

@Controller
@RequestMapping("/br41_kzqq_hzws")
public class Br41_kzqq_hzwsController extends AmlBaseController {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Br41_kzqq_hzwsService br41_kzqq_hzwsService;

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/list", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String performGetBr41_kzqq_hzwsList(Model model,
			HttpServletRequest request, Page page, Br41_kzqq_hzws br41_kzqq_hzws)
			throws Exception {
		try {
			/** 从session中获取查询对象 */
			Br41_kzqq_hzws searchObj = getSearchObject(br41_kzqq_hzws, page,
					request);
			List<Br41_kzqq_hzws> br41_kzqq_hzwsList = br41_kzqq_hzwsService
					.getBr41_kzqq_hzwsList(searchObj);

			model.addAttribute("statusMap", getSelectMap("S00002"));
			model.addAttribute("br41_kzqq_hzwsList", br41_kzqq_hzwsList);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/br41_kzqq_hzws/list");
	}

	
	
	/**
	*
	* @param model
	* 回执文书信息
	*/
	@RequestMapping(value="/hzws_list",method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr40_cxqq_hzwsList(Model model,HttpServletRequest request,Page page,Br41_kzqq_hzws br41_kzqq_hzws) throws Exception{
	try {
		String qqdbs=request.getParameter("qqdbss");
		String rwlsh=request.getParameter("rwlshs");
		String tasktype=request.getParameter("tasktypes");
	    /**从session中获取查询对象*/ 
		br41_kzqq_hzws.setQqdbs(qqdbs);
		br41_kzqq_hzws.setRwlsh(rwlsh);
		br41_kzqq_hzws.setTasktype(tasktype);
	Br41_kzqq_hzws searchObj = getSearchObject(br41_kzqq_hzws, page, request); 
	List<Br41_kzqq_hzws> br41_kzqq_hzwsList = br41_kzqq_hzwsService.getBr41_kzqq_hzwsList(searchObj);
	model.addAttribute("statusMap", getSelectMap("S00002"));
	model.addAttribute("br41_kzqq_hzwsList", br41_kzqq_hzwsList);
	model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
	model.addAttribute("br41_kzqq_hzws", searchObj);
	}catch (Exception e) {
	logger.error(e.getMessage(),e);
	 return("/errors/exception");
	}
	return ("/gajy/kzdj/kzdj_hzws_list");
	}
	
	
	@RequestMapping(value = "/hzws_modify", method = RequestMethod.GET)
	public String performModifyBr40_cxqq_hzws(@ModelAttribute Br41_kzqq_hzws br41_kzqq_hzws, Model model) throws Exception {

		try {
			br41_kzqq_hzws = br41_kzqq_hzwsService.getBr41_kzqq_hzwsDisp(br41_kzqq_hzws);
			// 查询文书明细
			br41_kzqq_hzws = br41_kzqq_hzwsService.getBr41_kzqq_hzws_m(br41_kzqq_hzws);
			// 查询关联通知书
		//	HashMap<String, String> wjMap = br40_kzqq_hzwsService.getBr40_ws(br40_cxqq_hzws.getBdhm());
			model.addAttribute("br41_kzqq_hzws", br41_kzqq_hzws);
		//	model.addAttribute("wjMap", wjMap);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/kzdj/kzdj_hzws_modify");
	}
	
	
	
	
	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String performModifyBr40_kzqq_hzwsDo(@ModelAttribute Br41_kzqq_hzws br41_kzqq_hzws, HttpSession session) throws Exception {
		//
		try {
			String loginname = StrUtils.nullToString((String) session.getAttribute("loginname"));
			Mp02_user user = commonService.getMp02_userDisp(loginname);
			br41_kzqq_hzws.setDjr(user.getRealname());
			int i = br41_kzqq_hzwsService.updateBr41_kzqq_hzws(br41_kzqq_hzws);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}

		return ("redirect:/br41_kzqq_hzws/hzws_list?isNewSearch=1&tasktypes="+br41_kzqq_hzws.getTasktype()+"&rwlshs="+br41_kzqq_hzws.getRwlsh()+"&qqdbss="+br41_kzqq_hzws.getQqdbs());
	}
	
	
	
	
	
	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	@Token(setToken = true)
	public String performAddBr41_kzqq_hzws(Model model) throws Exception {
		//
		Br41_kzqq_hzws br41_kzqq_hzws = new Br41_kzqq_hzws();

		model.addAttribute("br41_kzqq_hzws", br41_kzqq_hzws);
		//
		return ("/br41_kzqq_hzws/add");
	}

	/**
	 *
	 * @param Br41_kzqq_hzws
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@Token(checkToken = true)
	public String performaddBr41_kzqq_hzwsDo(
			@ModelAttribute Br41_kzqq_hzws br41_kzqq_hzws) throws Exception {
		//
		try {
			int i = br41_kzqq_hzwsService.insertBr41_kzqq_hzws(br41_kzqq_hzws);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}

		return ("redirect:/br41_kzqq_hzws/list");
	}

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/{wskey}/modify", method = RequestMethod.GET)
	public String performModifyBr41_kzqq_hzws(@PathVariable String wskey,
			Model model) throws Exception {
		//
		Br41_kzqq_hzws br41_kzqq_hzws = new Br41_kzqq_hzws();
		br41_kzqq_hzws = br41_kzqq_hzwsService
				.getBr41_kzqq_hzwsDisp(br41_kzqq_hzws);

		model.addAttribute("br41_kzqq_hzws", br41_kzqq_hzws);
		//
		return ("/br41_kzqq_hzws/modify");
	}

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/{wskey}/modify", method = RequestMethod.POST)
	public String performModifyBr41_kzqq_hzwsDo(
			@ModelAttribute Br41_kzqq_hzws br41_kzqq_hzws) throws Exception {
		//
		try {
			int i = br41_kzqq_hzwsService.modifyBr41_kzqq_hzws(br41_kzqq_hzws);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}

		return ("/redirect:br41_kzqq_hzws/list");
	}

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/{wskey}/delete", method = RequestMethod.POST)
	public String performDeleteBr41_kzqq_hzwsDo(Model model, String wskey)
			throws Exception {
		//
		try {
			int i = br41_kzqq_hzwsService.deleteBr41_kzqq_hzws(wskey);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}

		return ("redirect:/br41_kzqq_hzws/list");
	}

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/{wskey}/disp", method = RequestMethod.GET)
	public String performGetBr41_kzqq_hzwsDisp(Model model, String wskey)
			throws Exception {
		Br41_kzqq_hzws br41_kzqq_hzws = new Br41_kzqq_hzws();
		br41_kzqq_hzws = br41_kzqq_hzwsService
				.getBr41_kzqq_hzwsDisp(br41_kzqq_hzws);

		model.addAttribute("br41_kzqq_hzws", br41_kzqq_hzws);
		return ("/br41_kzqq_hzws/disp");
	}
}
