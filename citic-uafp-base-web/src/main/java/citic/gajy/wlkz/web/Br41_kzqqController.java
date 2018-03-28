/* =============================================
 *  Copyright (c) 2014-2015 by CITIC All rights reserved.
 *  Created [2016-05-31] 
 * =============================================
 */

package citic.gajy.wlkz.web;

/**
 * <p>Br41_kzqqController.java</p>
 * <p>Description: </p>
 * @author $Author:  $
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
import citic.base.utils.StrUtils;
import citic.gajy.wlcx.domain.Br40_cxqq;
import citic.gajy.wlcx.domain.Br40_cxqq_hzws;
import citic.gajy.wlcx.service.Br40_cxqqService;
import citic.gajy.wlkz.domain.Br41_kzqq;
import citic.gajy.wlkz.domain.Br41_kzqq_hzws;
import citic.gajy.wlkz.service.Br41_kzqqService;

@Controller
@RequestMapping("/br41_kzqq")
public class Br41_kzqqController extends AmlBaseController {
	private static final long serialVersionUID = -3411970292621777508L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Br41_kzqqService br41_kzqqService;
	@Autowired
	private Br40_cxqqService br40_cxqqService;

	/**
	 * 控制止付类请求认定
	 * 
	 * @param model
	 * @param request
	 * @param page
	 * @param br41_kzqq
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/request_zf_list", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr41_kzqq_ZfList(Model model, HttpServletRequest request, Page page, Br41_kzqq br41_kzqq) throws Exception {
		try {
			 /* 获取机构号*/
			 String loginname = StrUtils.nullToString((String)request.getSession().getAttribute("loginname"));
			 String organstr = commonService.getMp02_OrganList(loginname);
			 br41_kzqq.setOrgkey_disp(organstr.trim());
			 String startDate=br41_kzqq.getFssj_start();
			 String endDate=br41_kzqq.getFssj_end();
			/* 从session中获取查询对象 */
			if (br41_kzqq.getQqcslx() == null || "".equals(br41_kzqq.getQqcslx())) {
				br41_kzqq.setQqcslx_disp("'08','09'");
			}
			br41_kzqq.setStatus("0");
			Br41_kzqq searchObj = getSearchObject(br41_kzqq, page, request);
			List<Br41_kzqq> br41_kzqqList = br41_kzqqService.getBr41_kzqqzfList(searchObj);
			// 判断 只有高检5 国安4 有凭证图像查询
			if (br41_kzqq.getTasktype().equals("4") || br41_kzqq.getTasktype().equals("5")) {
				model.addAttribute("qqcslxMap", getSelectMap("B00073", "01,02,03,04,05,06,07"));
			}
			model.addAttribute("qqcslxMap", getSelectMap("B00073", "01,02,03,04,05,06,07,10"));
			searchObj.setFssj_start(startDate);
			searchObj.setFssj_end(endDate);
			model.addAttribute("jjcdMap", getSelectMap("B00009"));
			model.addAttribute("statusMap", getSelectMap("B00089"));
			model.addAttribute("ztlbMap", getSelectMap("B00024"));
			model.addAttribute("br41_kzqqList", br41_kzqqList);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
			model.addAttribute("br41_kzqq", searchObj);

		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/kzqqrd/request_zf_list");
	}

	/**
	 * 控制冻结类请求认定
	 * 
	 * @param model
	 * @param request
	 * @param page
	 * @param br41_kzqq
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/request_dj_list", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr41_kzqq_DJList(Model model, HttpServletRequest request, Page page, Br41_kzqq br41_kzqq) throws Exception {
		try {
			 /* 获取机构号*/
			 String loginname = StrUtils.nullToString((String)request.getSession().getAttribute("loginname"));
			 String organstr = commonService.getMp02_OrganList(loginname);
			 br41_kzqq.setOrgkey_disp(organstr.trim());
			/*从session中获取查询对象 */
			if (br41_kzqq.getQqcslx() == null || "".equals(br41_kzqq.getQqcslx())) {
				br41_kzqq.setQqcslx_disp("'05','06','07'");
			}
			if(br41_kzqq.getStatus()==null||"".equals(br41_kzqq.getStatus())){
				br41_kzqq.setStatus("0");
			}
			Br41_kzqq searchObj = getSearchObject(br41_kzqq, page, request);
			String start = searchObj.getFssj_start();
			String end = searchObj.getFssj_end();
			List<Br41_kzqq> br41_kzqqList = br41_kzqqService.getBr41_kzqqzfList(searchObj);
			// 判断 只有高检5 国安4 有凭证图像查询
			if (br41_kzqq.getTasktype().equals("4") || br41_kzqq.getTasktype().equals("5")) {
				model.addAttribute("qqcslxMap", getSelectMap("B00073", "01,02,03,04,08,09"));
			}
			model.addAttribute("qqcslxMap", getSelectMap("B00073", "01,02,03,04,08,09,10"));
			searchObj.setFssj_start(start);
			searchObj.setFssj_end(end);
			model.addAttribute("jjcdMap", getSelectMap("B00009"));

			model.addAttribute("br41_kzqqList", br41_kzqqList);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
			model.addAttribute("br41_kzqq", searchObj);

		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/kzqqrd/request_dj_list");
	}

	/**
	 * @param model
	 *  回执文书信息
	 */
	@RequestMapping(value = "/hzws_list", method = {RequestMethod.GET, RequestMethod.POST})
	public String performGetBr40_cxqq_hzwsList(Model model, HttpServletRequest request, Page page, Br41_kzqq_hzws br41_kzqq_hzws) throws Exception {
		try {
			/** 从session中获取查询对象 */
			Br41_kzqq_hzws searchObj = getSearchObject(br41_kzqq_hzws, page, request);
			List<Br41_kzqq_hzws> br41_kzqq_hzwsList = br41_kzqqService.getBr41_kzqq_hzwsList(searchObj);
			model.addAttribute("statusMap", getSelectMap("S00002"));
			model.addAttribute("br41_kzqq_hzwsList", br41_kzqq_hzwsList);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
			model.addAttribute("br41_kzqq_hzws", searchObj);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/search/deal_hzws_list");
	}
	
	/**
	 * 查询请求反馈
	 * 
	 * @param model
	 * @param request
	 * @param page
	 * @param br41_kzqq
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/response_fk_list", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr41_kzqqBackList(Model model, HttpServletRequest request, Page page, Br41_kzqq br41_kzqq) throws Exception {
		try {
			/** 从session中获取查询对象 */
			String start = br41_kzqq.getFssj_start();
			String end = br41_kzqq.getFssj_end();
			Br41_kzqq searchObj = getSearchObject(br41_kzqq, page, request);
			List<Br41_kzqq> br41_kzqqList = br41_kzqqService.getBr41_kzqqList(searchObj);
			searchObj.setFssj_start(start);
			searchObj.setFssj_end(end);
			model.addAttribute("qqcslxMap", getSelectMap("B00073"));
			model.addAttribute("jjcdMap", getSelectMap("B00009"));
			model.addAttribute("statusMap", getSelectMap("B00089"));
			model.addAttribute("ztlbMap", getSelectMap("B00024"));
			model.addAttribute("br41_kzqqList", br41_kzqqList);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
			model.addAttribute("br41_kzqq", searchObj);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("response_zffk_list");
	}

	/**
	 *止付请求反馈查询信息
	 * 
	 * @param model
	 * @param request
	 * @param page
	 * @param br41_kzqq
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/response_kzzf_list", method = { RequestMethod.GET, RequestMethod.POST })
	public String getBr41_kzqq_kzzfList(Model model, HttpServletRequest request, Page page, Br41_kzqq br41_kzqq) throws Exception {
		try {
			/* 获取机构号*/
			String startDate=br41_kzqq.getFssj_start();
			String endDate=br41_kzqq.getFssj_end();
			 String loginname = StrUtils.nullToString((String)request.getSession().getAttribute("loginname"));
			 String organstr = commonService.getMp02_OrganList(loginname);
			 br41_kzqq.setOrgkey_disp(organstr.trim());
			if("".equals(br41_kzqq.getQqcslx())||br41_kzqq.getQqcslx()==null){
				br41_kzqq.setQqcslx_disp("'08','09'");//查询止付信息
			}
			page.setParaid(br41_kzqq.getTasktype());
			Br41_kzqq searchObj = getSearchObject(br41_kzqq, page, request);
			List<Br41_kzqq> br41_kzqqList = br41_kzqqService.getBr41_kzqqResponseList(searchObj,"2");
			model.addAttribute("jjcdMap", getSelectMap("B00009"));
			model.addAttribute("statusMap", getSelectMap("B00089"));
			model.addAttribute("qqcslxMap", getSelectMap("B00073","01,02,03,04,05,06,07,10"));
			model.addAttribute("br41_kzqqList", br41_kzqqList);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
			searchObj.setFssj_start(startDate);
			searchObj.setFssj_end(endDate);
			model.addAttribute("br41_kzqq", searchObj);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/kzqqfk/response_zf_list");
	}

	/**
	 *冻结请求信息反馈
	 * 
	 * @param model
	 * @param request
	 * @param page
	 * @param br41_kzqq
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/response_kzdj_list", method = { RequestMethod.GET, RequestMethod.POST })
	public String getBr41_kzqq_kzdjList(Model model, HttpServletRequest request, Page page, Br41_kzqq br41_kzqq) throws Exception {
		try {
			/* 获取机构号*/
			 String loginname = StrUtils.nullToString((String)request.getSession().getAttribute("loginname"));
			 String organstr = commonService.getMp02_OrganList(loginname);
			 br41_kzqq.setOrgkey_disp(organstr.trim());
			if("".equals(br41_kzqq.getQqcslx())||br41_kzqq.getQqcslx()==null){
				br41_kzqq.setQqcslx_disp("'05','06','07'");//查询冻结信息
			}
			page.setParaid(br41_kzqq.getTasktype());
			Br41_kzqq searchObj = getSearchObject(br41_kzqq, page, request);
			List<Br41_kzqq> br41_kzqqList = br41_kzqqService.getBr41_kzqqResponseList(searchObj,"1");
			model.addAttribute("jjcdMap", getSelectMap("B00009"));
			model.addAttribute("statusMap", getSelectMap("B00089"));
			model.addAttribute("qqcslxMap", getSelectMap("B00073","01,02,03,04,08,09"));
			model.addAttribute("br41_kzqqList", br41_kzqqList);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
			model.addAttribute("br41_kzqq", searchObj);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/kzqqfk/response_dj_list");
	}
	
	
	/**
	 * 止付请求信息
	 * @param model
	 */
	@RequestMapping(value = "/request_kz_main", method = { RequestMethod.GET, RequestMethod.POST })
	public String performgetBr41_kzqq_kzzfMain(Model model, HttpServletRequest request) throws Exception {
		String path = "";
		String tasktype = request.getParameter("tasktype");
		String qqdbs = request.getParameter("qqdbs");
		String isdync = request.getParameter("isdync");
		String resource = request.getParameter("resource");
		String qqcslx = request.getParameter("qqcslx");
		model.addAttribute("qqcslx", qqcslx);
		model.addAttribute("qqdbs", qqdbs);
		model.addAttribute("tasktype", tasktype);
		model.addAttribute("resource", resource);
		if (isdync != null && !"".equals(isdync)) {
			// isdync  此变量只在这里有效  1 止付 ;2 冻结
			if (isdync.equals("1")) {
				path = "/gajy/search/request_kzzf_main";
			} else if (isdync.equals("2")) {
				path = "/gajy/search/request_kzdj_main";
			} else {
				path = "/errors/exception";
			}
		}
		return (path);
	}
	
	
	
	
	/**
	 *  统计分析   查询反馈信息
	 * @param model
	 */
	@RequestMapping(value = "/request_tjfx_main", method = { RequestMethod.GET, RequestMethod.POST })
	public String performgetBr41_kzqq_kzzfTjfxMain(Model model, HttpServletRequest request) throws Exception {
		String path = "";
		String rwlsh = request.getParameter("rwlsh");
		String tasktype = request.getParameter("tasktype");
		String qqdbs = request.getParameter("qqdbs");
		String isdync = request.getParameter("isdync");
		String resource = request.getParameter("resource");
		String qqcslx = request.getParameter("qqcslx");
		model.addAttribute("qqcslx", qqcslx);
		model.addAttribute("qqdbs", qqdbs);
		model.addAttribute("tasktype", tasktype);
		model.addAttribute("rwlsh", rwlsh);
		model.addAttribute("resource", resource);
		if (isdync != null && !"".equals(isdync)) {
			// isdync  此变量只在这里有效  1 止付 ;2 冻结
			if (isdync.equals("1")) {
				path = "/gajy/tjfx/request_kzzf_main";
			} else if (isdync.equals("2")) {
				path = "/gajy/tjfx/request_kzdj_main";
			} else {
				path = "/errors/exception";
			}
		}
		return (path);
	}


	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/request_kzzf_disp", method = RequestMethod.GET)
	public String performgetBr41_kzqq_kzzfDisp(Model model, HttpServletRequest request, String qqdbs, String qqcslx) throws Exception {
		String tasktype = request.getParameter("tasktype");
		Br40_cxqq br40_cxqq = new Br40_cxqq();
		Br41_kzqq br41_kzqq = new Br41_kzqq();
		br40_cxqq.setQqdbs(qqdbs);
		br40_cxqq.setTasktype(tasktype);
		br41_kzqq.setQqdbs(qqdbs);
		br41_kzqq.setQqcslx(qqcslx);
		br41_kzqq.setTasktype(tasktype);
		Br41_kzqq kzqq = br41_kzqqService.performgetBr41_kzqq_kzzfMain(br41_kzqq);
		List<Br40_cxqq> br40_wh_attachList = br40_cxqqService.getBr40_wh_attach(br40_cxqq);
		model.addAttribute("br41_kzqq", kzqq);
		model.addAttribute("br40_wh_attachList", br40_wh_attachList);

		return ("/gajy/search/request_kzzf_disp");
	}

	/*
	 * //发送核心 提交监管
	 * 
	 * @RequestMapping(value = "/gajy_send", method = { RequestMethod.GET,
	 * RequestMethod.POST }) public String performGajy_sendDo(HttpServletRequest
	 * request, @ModelAttribute Br41_kzqq br41_kzqq,HttpSession session) throws
	 * Exception {
	 * 
	 * String loginname = StrUtils.nullToString((String)
	 * session.getAttribute("loginname")); br41_kzqq.setRecipient_p(loginname);
	 * br41_kzqq.setRecipient_time(DtUtils.getNowDate());
	 * 
	 * String tasktype = request.getParameter("tasktype"); String rwlsh =
	 * request.getParameter("rwlsh"); String path =
	 * "redirect:/br40_cxqq/request_list?isNewSearch=1&tasktype="+tasktype;
	 * String flag = request.getParameter("flag");// 1.发送核心 2.发送监管 int i =
	 * br40_cxqqService.modifyBr40_cxqqStatus(br41_kzqq, flag); if
	 * ("1".equals(flag)) { path =
	 * "redirect:/br40_cxqq/request_list?isNewSearch=1&tasktype="+tasktype; }
	 * else { path =
	 * "redirect:/br40_cxqq/deal_list?isNewSearch=1&tasktype="+tasktype;; }
	 * 
	 * return path; }
	 */

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/request_zf_disp", method = RequestMethod.GET)
	public String performGetBr41_kzqqDisp(Model model, Br41_kzqq br41_kzqq) throws Exception {
		Br40_cxqq br40_cxqq = new Br40_cxqq();
		br40_cxqq.setQqdbs(br41_kzqq.getQqdbs());
		br40_cxqq.setTasktype(br41_kzqq.getTasktype());
		Br41_kzqq kzqq = br41_kzqqService.getBr41_kzqqMain(br41_kzqq);
		List<Br40_cxqq> br40_wh_attachList = br40_cxqqService.getBr40_wh_attach(br40_cxqq);
		model.addAttribute("br41_kzqq", kzqq);

		model.addAttribute("br40_wh_attachList", br40_wh_attachList);

		return ("/gajy/kzqqrd/request_zf_disp");
	}

	@RequestMapping(value = "/request_zf_main", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr41_kzqqMain(Model model, HttpServletRequest request) throws Exception {
		String qqdbs = request.getParameter("qqdbss");
		String resource = request.getParameter("resource");
		String tasktype = request.getParameter("tasktypes");

		model.addAttribute("tasktype", tasktype);
		model.addAttribute("qqdbs", qqdbs);
		model.addAttribute("resource", resource);
		return ("/gajy/kzqqrd/request_zf_main");
	}

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	@Token(setToken = true)
	public String performAddBr41_kzqq(Model model) throws Exception {
		Br41_kzqq br41_kzqq = new Br41_kzqq();
		model.addAttribute("br41_kzqq", br41_kzqq);
		return ("/br41_kzqq/add");
	}

	/**
	 *
	 * @param Br41_kzqq
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@Token(checkToken = true)
	public String performaddBr41_kzqqDo(@ModelAttribute Br41_kzqq br41_kzqq) throws Exception {
		try {
			int i = br41_kzqqService.insertBr41_kzqq(br41_kzqq);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}

		return ("redirect:/br41_kzqq/list");
	}

	@RequestMapping(value = "/{qqdbs}/modify", method = RequestMethod.GET)
	public String performModifyBr41_kzqq(@PathVariable String qqdbs, Model model) throws Exception {
		Br41_kzqq br41_kzqq = new Br41_kzqq();
		br41_kzqq = br41_kzqqService.getBr41_kzqqDisp(qqdbs);
		model.addAttribute("br41_kzqq", br41_kzqq);
		return ("/br41_kzqq/modify");
	}

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/{qqdbs}/modify", method = RequestMethod.POST)
	public String performModifyBr41_kzqqDo(@ModelAttribute Br41_kzqq br41_kzqq) throws Exception {
		try {
			int i = br41_kzqqService.modifyBr41_kzqq(br41_kzqq);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/redirect:br41_kzqq/list");
	}

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/{qqdbs}/delete", method = RequestMethod.POST)
	public String performDeleteBr41_kzqqDo(Model model, String qqdbs) throws Exception {
		try {
			int i = br41_kzqqService.deleteBr41_kzqq(qqdbs);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("redirect:/br41_kzqq/list");
	}

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/{qqdbs}/disp", method = RequestMethod.GET)
	public String performGetBr41_kzqqDisp(Model model, String qqdbs) throws Exception {
		Br41_kzqq br41_kzqq = new Br41_kzqq();
		br41_kzqq = br41_kzqqService.getBr41_kzqqDisp(qqdbs);
		model.addAttribute("br41_kzqq", br41_kzqq);
		return ("/br41_kzqq/disp");
	}
}
