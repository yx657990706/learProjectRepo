/* =============================================
 *  Copyright (c) 2014-2015 by CITIC All rights reserved.
 *  Created [2016-05-31] 
 * =============================================
 */

package citic.gajy.wlkz.web;

/**
 * <p>Br41_kzqq_zfController.java</p>
 * <p>Description: </p>
 * @author $Author:  $
 */

import java.util.*;

import org.slf4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import citic.gajy.wlcx.domain.Br40_cxqq;
import citic.gajy.wlcx.domain.Br40_cxqq_back;
import citic.gajy.wlcx.service.Br40_cxqqService;
import citic.gajy.wlcx.service.Br40_cxqq_backService;
import citic.gajy.wlkz.service.Br41_kzqqService;
import citic.gajy.wlkz.service.Br41_kzqq_zfService;
import citic.gajy.wlkz.service.Br41_kzqq_zf_backService;
import citic.gajy.wlkz.domain.Br41_kzqq;
import citic.gajy.wlkz.domain.Br41_kzqq_zf;
import citic.gajy.wlkz.domain.Br41_kzqq_zf_back;

@Controller
@RequestMapping("/br41_kzqq_zf")
public class Br41_kzqq_zfController extends AmlBaseController {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6078653830896812029L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Br41_kzqq_zfService br41_kzqq_zfService;
	@Autowired
	private Br41_kzqq_zf_backService br41_kzqq_zf_backService;
	@Autowired
	private Br40_cxqqService br40_cxqqService;
	@Autowired
	private Br40_cxqq_backService br40_cxqq_backService;
	@Autowired
	private Br41_kzqqService br41_kzqqService;

	/**
	 * 查询请求认定  请求主体信息
	 * @param model
	 * @param request
	 * @param page
	 * @param br41_kzqq_zf
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/request_zt_list", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr41_kzqq_zfList(Model model, HttpServletRequest request, Page page, Br41_kzqq_zf br41_kzqq_zf) throws Exception {
		try {
			/** 从session中获取查询对象 */
			Br41_kzqq_zf searchObj = getSearchObject(br41_kzqq_zf, page, request);
			List<Br41_kzqq_zf> br41_kzqq_zfList = br41_kzqq_zfService.getBr41_kzqq_zfList(searchObj);
			model.addAttribute("br41_kzqq_zfList", br41_kzqq_zfList);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
			model.addAttribute("br41_kzqq_zf", br41_kzqq_zf);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/kzqqrd/request_zt_list");
	}

	
	
	/**
	 * 新增控制和止付主体请求信息页面
	 * 
	 * @param model
	 * @param request
	 * @param page
	 * @param br41_kzqq_zf
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/request_kzzt_list", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr41_kzqq_kzzfList(Model model, HttpServletRequest request, Page page, Br41_kzqq_zf br41_kzqq_zf) throws Exception {
		try {
			/** 从session中获取查询对象 */
			Br41_kzqq_zf searchObj = getSearchObject(br41_kzqq_zf, page, request);
			List<Br41_kzqq_zf> br41_kzqq_zfList = br41_kzqq_zfService.getBr41_kzqq_zfList(searchObj);
			model.addAttribute("br41_kzqq_zfList", br41_kzqq_zfList);
			model.addAttribute("br41_kzqq_zf", searchObj);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/search/request_kzzt_list");
	}

	/**
	 * 查询紧急止付反馈信息
	 * 
	 * @param model
	 * @param br41_kzqq_zf
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/response_zf_main", method = { RequestMethod.GET, RequestMethod.POST })
	public String performgetBr41_kzqq_zfMain(Model model, Br41_kzqq_zf br41_kzqq_zf) throws Exception {
		model.addAttribute("br41_kzqq_zf", br41_kzqq_zf);
		return ("/gajy/search/request_zf_main");
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/request_kzzf_main", method = { RequestMethod.GET, RequestMethod.POST })
	public String performgetBr41_kzqq_kzzfBackMain(Model model, HttpServletRequest request) throws Exception {
		String qqdbs = request.getParameter("qqdbs");
		String type = request.getParameter("type");
		String resource = request.getParameter("resource");
		String qqcslx = request.getParameter("qqcslx");

		model.addAttribute("qqcslx", qqcslx);
		model.addAttribute("qqdbs", qqdbs);
		model.addAttribute("type", type);
		model.addAttribute("resource", resource);
		return ("/gajy/search/request_kzzf_main");
	}

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/request_kzzf_disp", method = RequestMethod.GET)
	public String performgetBr41_kzqq_kzzfDisp(Model model, String qqdbs, String qqcslx) throws Exception {
		Br40_cxqq br40_cxqq = new Br40_cxqq();
		Br41_kzqq_zf br41_kzqq_zf = new Br41_kzqq_zf();
		br41_kzqq_zf.setQqdbs(qqdbs);
		Br41_kzqq_zf kzqq_zf = br41_kzqq_zfService.performgetBr41_kzqq_kzzfBackMain(br41_kzqq_zf);
		List<Br40_cxqq> br40_wh_attachList = br40_cxqqService.getBr40_wh_attach(br40_cxqq);
		model.addAttribute("br41_kzqq_zf", kzqq_zf);

		model.addAttribute("br40_wh_attachList", br40_wh_attachList);

		return ("/gajy/search/request_kzzf_disp");
	}

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	@Token(setToken = true)
	public String performAddBr41_kzqq_zf(Model model) throws Exception {
		Br41_kzqq_zf br41_kzqq_zf = new Br41_kzqq_zf();
		model.addAttribute("br41_kzqq_zf", br41_kzqq_zf);
		return ("/br41_kzqq_zf/add");
	}

	/**
	 *
	 * @param Br41_kzqq_zf
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@Token(checkToken = true)
	public String performaddBr41_kzqq_zfDo(@ModelAttribute Br41_kzqq_zf br41_kzqq_zf) throws Exception {
		try {
			int i = br41_kzqq_zfService.insertBr41_kzqq_zf(br41_kzqq_zf);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("redirect:/br41_kzqq_zf/list");
	}

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/{rwlsh}/modify", method = RequestMethod.GET)
	public String performModifyBr41_kzqq_zf(@PathVariable String rwlsh, Model model) throws Exception {
		Br41_kzqq_zf br41_kzqq_zf = new Br41_kzqq_zf();
		br41_kzqq_zf = br41_kzqq_zfService.getBr41_kzqq_zfDisp(rwlsh);
		model.addAttribute("br41_kzqq_zf", br41_kzqq_zf);
		return ("/br41_kzqq_zf/modify");
	}

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/deal_list", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr41_kzqq_zfDealList(Model model, HttpServletRequest request, Page page, Br41_kzqq br41_kzqq) throws Exception {
		try {
			 /* 获取机构号*/
			 String loginname = StrUtils.nullToString((String)request.getSession().getAttribute("loginname"));
			 String organstr = commonService.getMp02_OrganList(loginname);
			 br41_kzqq.setOrgkey_disp(organstr.trim());
			/* 从session中获取查询对象 */
			br41_kzqq.setStatus_disp("'0','1'");
			br41_kzqq.setStatus("1");
			page.setParaid(br41_kzqq.getTasktype());
			Br41_kzqq searchObj = getSearchObject(br41_kzqq, page, request);
			String start = searchObj.getFssj_start();
			String end = searchObj.getFssj_end();
			List<Br41_kzqq> br41_kzqq_zfList = br41_kzqq_zfService.getBr41_kzqq_zfzxList(searchObj);
			// 判断 只有高检5 国安4 有凭证图像查询
			if (br41_kzqq.getTasktype().equals("4") || br41_kzqq.getTasktype().equals("5")) {
				model.addAttribute("qqcslxMap", getSelectMap("B00073", "01,02,03,04,05,06,07"));
			}
			searchObj.setFssj_start(start);
			searchObj.setFssj_end(end);
			model.addAttribute("qqcslxMap", getSelectMap("B00073", "01,02,03,04,05,06,07,10"));
			model.addAttribute("jjcdMap", getSelectMap("B00009"));
			model.addAttribute("br41_kzqq_zfList", br41_kzqq_zfList);
			model.addAttribute("br41_kzqq", searchObj);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/kzqqcl/deal_list");
	}
	
	@RequestMapping(value = "/deal_check_list", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr41_kzqq_zfCheckList(Model model, HttpServletRequest request, Page page, Br41_kzqq br41_kzqq) throws Exception {
		try {
			 /* 获取机构号*/
			 String loginname = StrUtils.nullToString((String)request.getSession().getAttribute("loginname"));
			 String organstr = commonService.getMp02_OrganList(loginname);
			 br41_kzqq.setOrgkey_disp(organstr.trim());
			page.setParaid(br41_kzqq.getTasktype());
			Br41_kzqq searchObj = getSearchObject(br41_kzqq, page, request);
			String start = searchObj.getFssj_start();
			String end = searchObj.getFssj_end();
			List<Br41_kzqq> br41_kzqq_zfList = br41_kzqq_zfService.getBr41_kzqq_zfzx_checkList(searchObj);
			// 判断 只有高检5 国安4 有凭证图像查询
			if (br41_kzqq.getTasktype().equals("4") || br41_kzqq.getTasktype().equals("5")) {
				model.addAttribute("qqcslxMap", getSelectMap("B00073", "01,02,03,04,05,06,07"));
			}
			searchObj.setFssj_start(start);
			searchObj.setFssj_end(end);
			model.addAttribute("qqcslxMap", getSelectMap("B00073", "01,02,03,04,05,06,07,10"));
			model.addAttribute("jjcdMap", getSelectMap("B00009"));
			model.addAttribute("br41_kzqq_zfList", br41_kzqq_zfList);
			model.addAttribute("br41_kzqq", searchObj);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/kzqqcl/zf_check_list");
	}
	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/query_kzzf_list", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr41_kzqq_zfResponseList(Model model, HttpServletRequest request, Page page, Br41_kzqq br41_kzqq) throws Exception {
		try {
			 /* 获取机构号*/
			String startDate = br41_kzqq.getFssj_start();
			String endDate = br41_kzqq.getFssj_end();
			 String loginname = StrUtils.nullToString((String)request.getSession().getAttribute("loginname"));
			 String organstr = commonService.getMp02_OrganList(loginname);
			 br41_kzqq.setOrgkey_disp(organstr.trim());
			/*从session中获取查询对象 */
			Br41_kzqq searchObj = getSearchObject(br41_kzqq, page, request);

			List<Br41_kzqq> br41_kzqq_zfList = br41_kzqq_zfService.getBr41_kzqq_zfzxSearchList(searchObj);
			// 判断 只有高检5 国安4 有凭证图像查询
			if (br41_kzqq.getTasktype().equals("4") || br41_kzqq.getTasktype().equals("5")) {
				model.addAttribute("qqcslxMap", getSelectMap("B00073", "01,02,03,04,05,06,07"));
			}
			model.addAttribute("qqcslxMap", getSelectMap("B00073", "01,02,03,04,05,06,07,10"));
			model.addAttribute("jjcdMap", getSelectMap("B00009"));
			model.addAttribute("ztlbMap", getSelectMap("B00080"));
			searchObj.setFssj_start(startDate);
			searchObj.setFssj_end(endDate);
			model.addAttribute("br41_kzqq", searchObj);
			model.addAttribute("br41_kzqq_zfList", br41_kzqq_zfList);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/kzqqfk/query_kzzf_list");
	}

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/zffk_main", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr41_kzqq_zffkMian(Model model, HttpServletRequest request, Br41_kzqq br41_kzqq) throws Exception {
		try {
			String qqdbs = request.getParameter("qqdbss");
			String tasktype = request.getParameter("tasktypes");
			String rwlsh = request.getParameter("rwlshs");
			String zh = request.getParameter("zhs");
			br41_kzqq.setQqdbs(qqdbs);
			br41_kzqq.setRwlsh(rwlsh);
			br41_kzqq.setTasktype(tasktype);
			br41_kzqq.setZh(zh);
			model.addAttribute("br41_kzqq", br41_kzqq);
			String cbrc_check_flag = StrUtils.nullToString(codeService.getCodeValue("Dpara", "cbrc_check_flag")); // 是否走复核
			model.addAttribute("cbrc_check_flag", cbrc_check_flag);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/kzqqcl/zffk_main");
	}
	
	@RequestMapping(value = "/zffk_check_main", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr41_kzqq_zffk_checkMian(Model model, HttpServletRequest request, Br41_kzqq br41_kzqq) throws Exception {
		try {
			String qqdbs = request.getParameter("qqdbss");
			String tasktype = request.getParameter("tasktypes");
			String rwlsh = request.getParameter("rwlshs");
			String zh = request.getParameter("zhs");
			String qqcslx = request.getParameter("qqcslxs");
			br41_kzqq.setQqdbs(qqdbs);
			br41_kzqq.setRwlsh(rwlsh);
			br41_kzqq.setTasktype(tasktype);
			br41_kzqq.setZh(zh);
			br41_kzqq.setQqcslx(qqcslx);
			model.addAttribute("br41_kzqq", br41_kzqq);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/kzqqcl/zffk_check_main");
	}

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/zffk_save", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr41_kzqq_savedisp(Model model, Br41_kzqq_zf_back br41_kzqq_zf_back, HttpSession session) throws Exception {
		try {
			String loginname = StrUtils.nullToString((String) session.getAttribute("loginname"));
			br41_kzqq_zf_back.setDealing_p(loginname);
			br41_kzqq_zf_back.setDealing_time(DtUtils.getNowTime());
			br41_kzqq_zf_backService.modifyBr41_kzqq_zf_back_disp(br41_kzqq_zf_back);

			model.addAttribute("br41_kzqq", br41_kzqq_zf_back);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return "redirect:/br41_kzqq_zf/zffk_disp?tasktype=" + br41_kzqq_zf_back.getTasktype() + "&qqdbs=" + br41_kzqq_zf_back.getQqdbs() + "&rwlsh="
				+ br41_kzqq_zf_back.getRwlsh();
	}

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/zffk_disp", method = RequestMethod.GET)
	public String performGetBr41_kzqq_zffkdisp(Model model, Br41_kzqq_zf_back br41_kzqq_zf_back) throws Exception {
		try {
			Br41_kzqq_zf_back kzqq_zf_back = new Br41_kzqq_zf_back();
			kzqq_zf_back = br41_kzqq_zfService.getBr41_kzqq_zffkDisp(br41_kzqq_zf_back);
			model.addAttribute("zxjgMap", getSelectMap("B00099"));
			model.addAttribute("br41_kzqq_zf_back", kzqq_zf_back);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}

		return ("/gajy/kzqqcl/zffk_disp");
	}

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/{rwlsh}/modify", method = RequestMethod.POST)
	public String performModifyBr41_kzqq_zfDo(@ModelAttribute Br41_kzqq_zf br41_kzqq_zf) throws Exception {
		try {
			int i = br41_kzqq_zfService.modifyBr41_kzqq_zf(br41_kzqq_zf);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}

		return ("/redirect:br41_kzqq_zf/list");
	}

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/{rwlsh}/delete", method = RequestMethod.POST)
	public String performDeleteBr41_kzqq_zfDo(Model model, String rwlsh) throws Exception {
		try {
			int i = br41_kzqq_zfService.deleteBr41_kzqq_zf(rwlsh);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("redirect:/br41_kzqq_zf/list");
	}

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/{rwlsh}/disp", method = RequestMethod.GET)
	public String performGetBr41_kzqq_zfDisp(Model model, String rwlsh) throws Exception {
		Br41_kzqq_zf br41_kzqq_zf = new Br41_kzqq_zf();
		br41_kzqq_zf = br41_kzqq_zfService.getBr41_kzqq_zfDisp(rwlsh);
		model.addAttribute("br41_kzqq_zf", br41_kzqq_zf);
		return ("/br41_kzqq_zf/disp");
	}

	/**
	 * 发送核心   止付类请求认定
	 * 
	 * @param request
	 * @param br41_kzqq
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/gajy_send_hx", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGajy_send_hxDo(HttpServletRequest request, @ModelAttribute Br41_kzqq br41_kzqq, HttpSession session) throws Exception {
		String tasktype = request.getParameter("tasktype"); 
		String path = "redirect:/br41_kzqq/request_zf_list?isNewSearch=1&tasktype=" + tasktype;
		try {
			String loginname = StrUtils.nullToString((String) session.getAttribute("loginname"));
			br41_kzqq = br41_kzqqService.getBr41_kzqqMain(br41_kzqq);
			br41_kzqq.setRecipient_p(loginname);
			br41_kzqq.setRecipient_time(DtUtils.getNowDate());
			br41_kzqq.setLast_up_dt(DtUtils.getNowTime());
			br41_kzqq_zfService.send_hx(br41_kzqq);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return path;
	}

	/**
	 * 提交监管
	 * 
	 * @param request
	 * @param br41_kzqq
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/gajy_send_jg", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGajy_sendDo(HttpServletRequest request, @ModelAttribute Br41_kzqq br41_kzqq, HttpSession session) throws Exception {
		try {
			String loginname = StrUtils.nullToString((String) session.getAttribute("loginname"));
			br41_kzqq.setRecipient_p(loginname);

			String rwlsh = request.getParameter("rwlsh");
			br41_kzqq = br41_kzqqService.getBr41_kzqqMain(br41_kzqq);
			br41_kzqq.setRwlsh(rwlsh);
			br41_kzqq_zfService.send_jg(br41_kzqq);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return "redirect:/br41_kzqq_zf/deal_list" ;
	}
	
	@RequestMapping(value = "/gajy_zfcheck_send_jg", method =RequestMethod.POST )
	public String performgajy_zfcheck_send_jg(HttpServletRequest request, @ModelAttribute Br41_kzqq_zf_back br41_kzqq_zf_back, HttpSession session) throws Exception {
		try {
		String loginname = StrUtils.nullToString((String) session.getAttribute("loginname"));
		br41_kzqq_zf_back.setFeedback_p(loginname);
		br41_kzqq_zfService.send_zfcheck_jg(br41_kzqq_zf_back);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return "redirect:/br41_kzqq_zf/deal_check_list";
	}
	
	
	@RequestMapping(value = "/gajy_zfcheck_returnBack", method =RequestMethod.GET)
	public String performFajy_zfcheck_returnBack(Model model, @ModelAttribute Br41_kzqq_zf_back br41_kzqq_zf_back) throws Exception {
	   
	     model.addAttribute("br41_kzqq_zf_back", br41_kzqq_zf_back);
			return ("/gajy/kzqqcl/deal_Reason_add");
	}
	
	@RequestMapping(value = "/gajy_zfcheck_returnBack", method =RequestMethod.POST )
	public String performFajy_zfcheck_returnBackDo(HttpServletRequest request, @ModelAttribute Br41_kzqq_zf_back br41_kzqq_zf_back, HttpSession session) throws Exception {
		try {
		String loginname = StrUtils.nullToString((String) session.getAttribute("loginname"));
		br41_kzqq_zf_back.setFeedback_p(loginname);
		br41_kzqq_zfService.return_zfcheck_jg(br41_kzqq_zf_back);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return "redirect:/br41_kzqq_zf/deal_check_list";
	}
	
	
	

}
