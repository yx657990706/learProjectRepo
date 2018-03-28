/* =============================================
 *  Copyright (c) 2014-2015 by CITIC All rights reserved.
 *  Created [2016-05-31] 
 * =============================================
 */

package citic.gajy.wlkz.web;

/**
 * <p>Br41_kzqq_djController.java</p>
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
import citic.base.Page;
import citic.base.annotations.Token;
import citic.base.utils.DtUtils;
import citic.base.utils.StrUtils;
import citic.gajy.wlkz.domain.Br41_kzqq;
import citic.gajy.wlkz.domain.Br41_kzqq_dj;
import citic.gajy.wlkz.domain.Br41_kzqq_dj_back;
import citic.gajy.wlkz.service.Br41_kzqqService;
import citic.gajy.wlkz.service.Br41_kzqq_djService;
import citic.gajy.wlkz.service.Br41_kzqq_dj_backService;

@Controller
@RequestMapping("/br41_kzqq_dj")
public class Br41_kzqq_djController extends AmlBaseController {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7367737390859552366L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Br41_kzqq_djService br41_kzqq_djService;
	@Autowired
	private Br41_kzqq_dj_backService br41_kzqq_dj_backService;
	@Autowired
	private Br41_kzqqService br41_kzqqService;

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/request_dj_list", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr41_kzqq_djList(Model model, HttpServletRequest request, Page page, Br41_kzqq_dj br41_kzqq_dj) throws Exception {
		try {
			// ** 从session中获取查询对象 *//*
			Br41_kzqq_dj searchObj = getSearchObject(br41_kzqq_dj, page, request);
			List<Br41_kzqq_dj> br41_kzqq_djList = br41_kzqq_djService.getBr41_kzqq_djList(searchObj);

			model.addAttribute("qqcslxMap", getSelectMap("B00073"));
			model.addAttribute("jjcdMap", getSelectMap("B00009"));
			model.addAttribute("statusMap", getSelectMap("B00089"));
			model.addAttribute("zxjgMap", getSelectMap("B00099"));
			model.addAttribute("br41_kzqq_djList", br41_kzqq_djList);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
			model.addAttribute("br41_kzqq_dj", searchObj);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/kzqqrd/request_dj_list");
	}

	@RequestMapping(value = "/request_djfk_list", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr41_kzqq_djfkList(Model model, HttpServletRequest request, Page page, Br41_kzqq_dj_back  br41_kzqq_dj_back) throws Exception {
		try {
			/* 从session中获取查询对象 */
			Br41_kzqq_dj_back searchObj = getSearchObject(br41_kzqq_dj_back, page, request);
			List<Br41_kzqq_dj_back> br41_kzqq_djbackList = br41_kzqq_djService.getBr41_kzqq_djfkList(searchObj);
			model.addAttribute("br41_kzqq_djbackList", br41_kzqq_djbackList);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
			model.addAttribute("br41_kzqq_dj_back", searchObj);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/search/kzdj_list");
	}

	@RequestMapping(value = "/request_dj_main", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr41_kzqq_dj_disp(Model model, HttpServletRequest request) throws Exception {
		String qqdbs = request.getParameter("qqdbss");
		String resource = request.getParameter("resource");
		String tasktype = request.getParameter("tasktypes");
		model.addAttribute("tasktype", tasktype);
		model.addAttribute("qqdbs", qqdbs);
		model.addAttribute("resource", resource);
		return ("/gajy/kzqqrd/request_dj_main");
	}

	/**
	 * 冻结请求认定  请求主体信息
	 * @param model
	 */
	@RequestMapping(value = "/dj_task_list", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr41_kzqq_djBackList(Model model, HttpServletRequest request, Page page, Br41_kzqq_dj br41_kzqq_dj) throws Exception {
		try {
			/** 从session中获取查询对象 */
			Br41_kzqq_dj searchObj = getSearchObject(br41_kzqq_dj, page, request);
			List<Br41_kzqq_dj> br41_kzqq_djList = br41_kzqq_djService.getBr41_kzqq_djList(searchObj);
			model.addAttribute("br41_kzqq_djList", br41_kzqq_djList);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
			model.addAttribute("br41_kzqq_dj", searchObj);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/kzqqrd/dj_task_list");
	}

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/deal_list", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr41_kzqq_djDealList(Model model, HttpServletRequest request, Page page, Br41_kzqq br41_kzqq) throws Exception {
		try {
			/* 获取机构号 */
			String loginname = StrUtils.nullToString((String) request.getSession().getAttribute("loginname"));
			String organstr = commonService.getMp02_OrganList(loginname);
			br41_kzqq.setOrgkey_disp(organstr.trim());
			/** 从session中获取查询对象 */
			br41_kzqq.setStatus_disp("'0','1'");
			br41_kzqq.setStatus("1");
			Br41_kzqq searchObj = getSearchObject(br41_kzqq, page, request);
			String start = searchObj.getFssj_start();
			String end = searchObj.getFssj_end();
			List<Br41_kzqq> br41_kzqq_djList = br41_kzqq_djService.getBr41_kzqq_kzdjList(searchObj);
			// 判断 只有高检5 国安4 有凭证图像查询
			if (br41_kzqq.getTasktype().equals("4") || br41_kzqq.getTasktype().equals("5")) {
				model.addAttribute("qqcslxMap", getSelectMap("B00073", "01,02,03,04,08,09"));
			}else{
			model.addAttribute("qqcslxMap", getSelectMap("B00073", "01,02,03,04,08,09,10"));
			}
			model.addAttribute("jjcdMap", getSelectMap("B00009"));
			model.addAttribute("zxjgMap", getSelectMap("B00099"));
			model.addAttribute("ztlbMap", getSelectMap("B00080"));
			model.addAttribute("djfsMap", getSelectMap("B00071"));
			model.addAttribute("br41_kzqq_djList", br41_kzqq_djList);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
			searchObj.setFssj_start(start);
			searchObj.setFssj_end(end);
			model.addAttribute("br41_kzqq", searchObj);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/kzdj/deal_list");
	}
	
	
	@RequestMapping(value = "/deal_check_list", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr41_kzqq_djDeal_checkList(Model model, HttpServletRequest request, Page page, Br41_kzqq br41_kzqq) throws Exception {
		try {
			/* 获取机构号 */
			String loginname = StrUtils.nullToString((String) request.getSession().getAttribute("loginname"));
			String organstr = commonService.getMp02_OrganList(loginname);
			br41_kzqq.setOrgkey_disp(organstr.trim());
			Br41_kzqq searchObj = getSearchObject(br41_kzqq, page, request);
			String start = searchObj.getFssj_start();
			String end = searchObj.getFssj_end();
			List<Br41_kzqq> br41_kzqq_djList = br41_kzqq_djService.getBr41_kzqq_kzdj_checkList(searchObj);
			// 判断 只有高检5 国安4 有凭证图像查询
			if (br41_kzqq.getTasktype().equals("4") || br41_kzqq.getTasktype().equals("5")) {
				model.addAttribute("qqcslxMap", getSelectMap("B00073", "01,02,03,04,08,09"));
			}else{
			model.addAttribute("qqcslxMap", getSelectMap("B00073", "01,02,03,04,08,09,10"));
			}
			model.addAttribute("jjcdMap", getSelectMap("B00009"));
			model.addAttribute("zxjgMap", getSelectMap("B00099"));
			model.addAttribute("ztlbMap", getSelectMap("B00080"));
			model.addAttribute("djfsMap", getSelectMap("B00071"));
			model.addAttribute("br41_kzqq_djList", br41_kzqq_djList);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
			searchObj.setFssj_start(start);
			searchObj.setFssj_end(end);
			model.addAttribute("br41_kzqq", searchObj);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/kzdj/deal_check_list");
	}

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/query_kzdj_list", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr41_kzqq_djResponseList(Model model, HttpServletRequest request, Page page, Br41_kzqq br41_kzqq) throws Exception {
		try {
			/* 获取机构号 */
			String startDate=br41_kzqq.getFssj_start();
			String endDate=br41_kzqq.getFssj_end();
			String loginname = StrUtils.nullToString((String) request.getSession().getAttribute("loginname"));
			String organstr = commonService.getMp02_OrganList(loginname);
			br41_kzqq.setOrgkey_disp(organstr.trim());
			/** 从session中获取查询对象 */
			Br41_kzqq searchObj = getSearchObject(br41_kzqq, page, request);
			List<Br41_kzqq> br41_kzqq_djList = br41_kzqq_djService.getBr41_kzqq_kzdjSearchList(searchObj);
			if (br41_kzqq.getTasktype().equals("4") || br41_kzqq.getTasktype().equals("5")) {
				model.addAttribute("qqcslxMap", getSelectMap("B00073", "01,02,03,04,08,09"));
			}else{
			model.addAttribute("qqcslxMap", getSelectMap("B00073", "01,02,03,04,08,09,10"));
			}
			model.addAttribute("jjcdMap", getSelectMap("B00009"));
			model.addAttribute("ztlbMap", getSelectMap("B00080"));
			model.addAttribute("zxjgMap", getSelectMap("B00099"));
			model.addAttribute("br41_kzqq_djList", br41_kzqq_djList);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
			searchObj.setFssj_start(startDate);
			searchObj.setFssj_end(endDate);
			model.addAttribute("br41_kzqq", searchObj);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/kzdj/query_kzdj_list");
	}


	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/kzdj_main", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr41_kzqq_zffkMian(Model model, HttpServletRequest request, Br41_kzqq br41_kzqq) throws Exception {
		try {
			String qqdbs = request.getParameter("qqdbss");
			String tasktype = request.getParameter("tasktypes");
			String rwlsh = request.getParameter("rwlshs");
			br41_kzqq.setQqdbs(qqdbs);
			br41_kzqq.setRwlsh(rwlsh);
			br41_kzqq.setTasktype(tasktype);
			br41_kzqq.setZh(request.getParameter("zhs"));
			br41_kzqq.setZhxh(request.getParameter("zhxhs"));
			model.addAttribute("br41_kzqq", br41_kzqq);
			String cbrc_check_flag = StrUtils.nullToString(codeService.getCodeValue("Dpara", "cbrc_check_flag")); // 是否走复核
			model.addAttribute("cbrc_check_flag", cbrc_check_flag);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/kzdj/kzdj_main");
	}
	
	@RequestMapping(value = "/kzdj_check_main", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr41_kzqq_zffk_checkMian(Model model, HttpServletRequest request, Br41_kzqq br41_kzqq) throws Exception {
		try {
			String qqdbs = request.getParameter("qqdbss");
			String tasktype = request.getParameter("tasktypes");
			String rwlsh = request.getParameter("rwlshs");
			String qqcslx = request.getParameter("qqcslxs");
			br41_kzqq.setQqdbs(qqdbs);
			br41_kzqq.setRwlsh(rwlsh);
			br41_kzqq.setTasktype(tasktype);
			br41_kzqq.setQqcslx(qqcslx);
			model.addAttribute("br41_kzqq", br41_kzqq);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/kzdj/kzdj_check_main");
	}

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/kzdj_save", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr41_kzqq_zfSaveMian(Model model, HttpServletRequest request, Br41_kzqq_dj_back br41_kzqq_dj_back) throws Exception {
		try {
			String loginname = StrUtils.nullToString((String) request.getSession().getAttribute("loginname"));
			br41_kzqq_dj_back.setDealing_p(loginname);
			br41_kzqq_dj_back.setDealing_time(DtUtils.getNowTime());
			br41_kzqq_dj_backService.modifyBr41_kzqq_dj_back(br41_kzqq_dj_back);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return "redirect:/br41_kzqq_dj/kzdj_disp?tasktype=" + br41_kzqq_dj_back.getTasktype() + "&qqdbs=" + br41_kzqq_dj_back.getQqdbs() + "&rwlsh="
				+ br41_kzqq_dj_back.getRwlsh();
	}

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/kzdj_disp", method = RequestMethod.GET)
	public String performGetBr41_kzqq_zffkdisp(Model model, Br41_kzqq_dj_back br41_kzqq_dj_back) throws Exception {
		try {
			Br41_kzqq_dj_back kzqq_dj_back = new Br41_kzqq_dj_back();
			kzqq_dj_back = br41_kzqq_djService.getBr41_kzqq_djfkDisp(br41_kzqq_dj_back);
			model.addAttribute("zxjgMap", getSelectMap("B00099"));
			model.addAttribute("br41_kzqq_dj_back", kzqq_dj_back);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/kzdj/kzdj_disp");
	}

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	@Token(setToken = true)
	public String performAddBr41_kzqq_dj(Model model) throws Exception {
		Br41_kzqq_dj br41_kzqq_dj = new Br41_kzqq_dj();
		model.addAttribute("br41_kzqq_dj", br41_kzqq_dj);
		return ("/br41_kzqq_dj/add");
	}

	/**
	 *
	 * @param Br41_kzqq_dj
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@Token(checkToken = true)
	public String performaddBr41_kzqq_djDo(@ModelAttribute Br41_kzqq_dj br41_kzqq_dj) throws Exception {
		try {
			int i = br41_kzqq_djService.insertBr41_kzqq_dj(br41_kzqq_dj);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("redirect:/br41_kzqq_dj/list");
	}

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/{rwlsh}/modify", method = RequestMethod.GET)
	public String performModifyBr41_kzqq_dj(@PathVariable String rwlsh, Model model) throws Exception {
		Br41_kzqq_dj br41_kzqq_dj = new Br41_kzqq_dj();
		br41_kzqq_dj = br41_kzqq_djService.getBr41_kzqq_djDisp(rwlsh);
		model.addAttribute("br41_kzqq_dj", br41_kzqq_dj);
		return ("/br41_kzqq_dj/modify");
	}

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/{rwlsh}/modify", method = RequestMethod.POST)
	public String performModifyBr41_kzqq_djDo(@ModelAttribute Br41_kzqq_dj br41_kzqq_dj) throws Exception {
		try {
			int i = br41_kzqq_djService.modifyBr41_kzqq_dj(br41_kzqq_dj);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/redirect:br41_kzqq_dj/list");
	}

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/{rwlsh}/delete", method = RequestMethod.POST)
	public String performDeleteBr41_kzqq_djDo(Model model, String rwlsh) throws Exception {
		try {
			int i = br41_kzqq_djService.deleteBr41_kzqq_dj(rwlsh);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("redirect:/br41_kzqq_dj/list");
	}

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/{rwlsh}/disp", method = RequestMethod.GET)
	public String performGetBr41_kzqq_djDisp(Model model, String rwlsh) throws Exception {
		Br41_kzqq_dj br41_kzqq_dj = new Br41_kzqq_dj();
		br41_kzqq_dj = br41_kzqq_djService.getBr41_kzqq_djDisp(rwlsh);
		model.addAttribute("br41_kzqq_dj", br41_kzqq_dj);
		return ("/br41_kzqq_dj/disp");
	}

	
	/**
	 *  发送核心   冻结请求认定
	 * @param request
	 * @param br41_kzqq
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/gajy_send_hx", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGajy_send_hxDo(HttpServletRequest request, @ModelAttribute Br41_kzqq br41_kzqq, HttpSession session) throws Exception {
		String tasktype = request.getParameter("tasktype");
		String path = "redirect:/br41_kzqq/request_dj_list?isNewSearch=1&tasktype=" + tasktype;
		try {
			String loginname = StrUtils.nullToString((String) session.getAttribute("loginname"));
			br41_kzqq = br41_kzqqService.getBr41_kzqqMain(br41_kzqq);
			br41_kzqq.setRecipient_p(loginname);
			br41_kzqq.setRecipient_time(DtUtils.getNowDate());
			br41_kzqq.setLast_up_dt(DtUtils.getNowTime());
			br41_kzqq_djService.send_hx(br41_kzqq);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}

		return path;
	}

	// 提交监管
	@RequestMapping(value = "/gajy_send_jg", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGajy_sendDo(HttpServletRequest request, @ModelAttribute Br41_kzqq br41_kzqq, HttpSession session) throws Exception {
		String loginname = StrUtils.nullToString((String) session.getAttribute("loginname"));
		br41_kzqq.setRecipient_p(loginname);
		String tasktype = request.getParameter("tasktype");
		String rwlsh = request.getParameter("rwlsh");
		br41_kzqq = br41_kzqqService.getBr41_kzqqMain(br41_kzqq);
		br41_kzqq.setRwlsh(rwlsh);
		br41_kzqq_djService.send_jg(br41_kzqq);

		return "redirect:/br41_kzqq_dj/deal_list?isNewSearch=1&tasktype=" + tasktype;
	}
	
	@RequestMapping(value = "/gajy_djcheck_send_jg", method =RequestMethod.POST )
	public String performgajy_djcheck_send_jg(HttpServletRequest request, @ModelAttribute Br41_kzqq_dj_back br41_kzqq_dj_back, HttpSession session) throws Exception {
		try {
		String loginname = StrUtils.nullToString((String) session.getAttribute("loginname"));
		br41_kzqq_dj_back.setFeedback_p(loginname);
		br41_kzqq_djService.send_djcheck_jg(br41_kzqq_dj_back);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return "redirect:/br41_kzqq_dj/deal_check_list";
	}
	
	@RequestMapping(value = "/gajy_djcheck_returnBack", method =RequestMethod.GET )
	public String performFajy_djcheck_returnBack(Model model, @ModelAttribute Br41_kzqq_dj_back br41_kzqq_dj_back) throws Exception {
        model.addAttribute("br41_kzqq_dj_back", br41_kzqq_dj_back);
		return ("/gajy/kzdj/deal_Reason_add");
	}
	
	@RequestMapping(value = "/gajy_djcheck_returnBack", method =RequestMethod.POST )
	public String performFajy_djcheck_returnBackDo(HttpServletRequest request, @ModelAttribute Br41_kzqq_dj_back br41_kzqq_dj_back, HttpSession session) throws Exception {
		try {
		String loginname = StrUtils.nullToString((String) session.getAttribute("loginname"));
		br41_kzqq_dj_back.setFeedback_p(loginname);
		br41_kzqq_djService.return_djcheck_jg(br41_kzqq_dj_back);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return "/common/common_close";
	}
	
}
