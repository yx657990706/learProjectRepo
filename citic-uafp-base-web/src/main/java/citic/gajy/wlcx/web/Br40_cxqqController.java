package citic.gajy.wlcx.web;

/**
 * <p>
 * Br40_cxqqController.java
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author $Author: $
 */
import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import citic.aml.base.AmlBaseController;
import citic.aml.system.domain.Mp02_user;
import citic.base.Page;
import citic.base.annotations.Token;
import citic.base.utils.DtUtils;
import citic.base.utils.FileUtils;
import citic.base.utils.StrUtils;
import citic.gajy.wlcx.domain.Br40_cxqq;
import citic.gajy.wlcx.domain.Br40_cxqq_back;
import citic.gajy.wlcx.domain.Br40_cxqq_back_pz;
import citic.gajy.wlcx.domain.Br40_cxqq_back_pz_attach;
import citic.gajy.wlcx.domain.Br40_cxqq_hzws;
import citic.gajy.wlcx.service.Br40_cxqqService;
import citic.gajy.wlcx.service.Br40_cxqq_hzwsService;
import citic.gajy.wlcx.service.Br40_cxqq_hzws_mService;

@Controller
@RequestMapping("/br40_cxqq")
public class Br40_cxqqController extends AmlBaseController {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6084578271074209766L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Br40_cxqqService br40_cxqqService;
	@Autowired
	private Br40_cxqq_hzwsService br40_cxqq_hzwsService;
	@Autowired
	private Br40_cxqq_hzws_mService br40_cxqq_hzws_mService;

	// 凭证图像附件存放的相对路径定义
	private final String PZTX_PATH = "/attach/pztx";

	/**
	 * 查询请求认定
	 * 
	 * @param model
	 * @param request
	 * @param page
	 * @param br40_cxqq
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/request_list", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr40_cxqqList(Model model, HttpServletRequest request, Page page, Br40_cxqq br40_cxqq) throws Exception {
		try {
			// 获取机构号
			String loginname = StrUtils.nullToString((String) request.getSession().getAttribute("loginname"));
			String organstr = commonService.getMp02_OrganList(loginname);
			br40_cxqq.setOrgkey_disp(organstr.trim());
			/** 从session中获取查询对象 */
			br40_cxqq.setStatus("0");
			Br40_cxqq searchObj = getSearchObject(br40_cxqq, page, request);
			String start = searchObj.getFssj_start();
			String end = searchObj.getFssj_end();
			List<Br40_cxqq> br40_cxqqList = br40_cxqqService.getBr40_cxqqList(searchObj);
			// 判断 只有高检5 国安4 有凭证图像查询
			if (br40_cxqq.getTasktype().equals("4") || br40_cxqq.getTasktype().equals("5")) {
				model.addAttribute("qqcslxMap", getSelectMap("B00073", "05,06,07,08,09"));
			} else {
				model.addAttribute("qqcslxMap", getSelectMap("B00073", "05,06,07,08,09,10"));
			}
			searchObj.setFssj_start(start);
			searchObj.setFssj_end(end);
			model.addAttribute("jjcdMap", getSelectMap("B00009"));
			model.addAttribute("br40_cxqqList", br40_cxqqList);
			model.addAttribute("br40_cxqq", searchObj);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/cxqqrd/request_list");
	}

	/**
	 * 查询请求单信息
	 * 
	 * @param model
	 * @param br40_cxqq
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/request_cx_disp", method = RequestMethod.GET)
	public String performGetBr41_kzqqDisp(Model model, Br40_cxqq br40_cxqq) throws Exception {
		Br40_cxqq cxqq = br40_cxqqService.performgetBr40_cxqqMain(br40_cxqq);
		List<Br40_cxqq> br40_wh_attachList = br40_cxqqService.getBr40_wh_attach(br40_cxqq);
		model.addAttribute("br40_cxqq", cxqq);
		model.addAttribute("br40_wh_attachList", br40_wh_attachList);
		return ("/gajy/search/request_cx_disp");
	}

	@RequestMapping(value = "/request_cx_main", method = { RequestMethod.GET, RequestMethod.POST })
	public String performgetBr40_cxqqMain(Model model, HttpServletRequest request) throws Exception {
		String qqdbs = request.getParameter("qqdbss");
		String resource = request.getParameter("resource");
		String qqcslx = request.getParameter("qqcslxs");
		String tasktype = request.getParameter("tasktypes");

		model.addAttribute("tasktype", tasktype);
		model.addAttribute("qqcslx", qqcslx);
		model.addAttribute("qqdbs", qqdbs);
		model.addAttribute("resource", resource);
		return ("/gajy/search/request_cx_main");
	}

	/**
	 * 统计分析 查询
	 * 
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/search_cg_list_main", method = { RequestMethod.GET, RequestMethod.POST })
	public String performgetBr40_cxqqSearchMain(Model model, HttpServletRequest request) throws Exception {
		String qqdbs = request.getParameter("qqdbss");
		String tasktype = request.getParameter("tasktypes");
		String qqcslx = request.getParameter("qqcslxs");
		model.addAttribute("qqcslx", qqcslx);
		model.addAttribute("qqdbs", qqdbs);
		model.addAttribute("tasktype", tasktype);
		return ("/gajy/tjfx/search_cg_list_main");
	}

	/**
	 * 统计分析 常规查询
	 * 
	 * @param model
	 * @param request
	 * @param page
	 * @param br40_cxqq
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/request_cg_list", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr40_cxqq_cxList(Model model, HttpServletRequest request, Page page, Br40_cxqq br40_cxqq) throws Exception {
		try {
			/* 获取机构号 */
			String loginname = StrUtils.nullToString((String) request.getSession().getAttribute("loginname"));
			String organstr = commonService.getMp02_OrganList(loginname);
			br40_cxqq.setOrgkey_disp(organstr.trim());
			/* 从session中获取查询对象 */
			String startDate = br40_cxqq.getFssj_start();
			String endDate = br40_cxqq.getFssj_end();
			br40_cxqq.setQqcslx_disp("'01'");// 常规查询
			Br40_cxqq searchObj = getSearchObject(br40_cxqq, page, request);
			List<Br40_cxqq> br40_cxqqList = br40_cxqqService.getBr40_cxqq_cxList(searchObj);

			searchObj.setFssj_start(startDate);
			searchObj.setFssj_end(endDate);
			model.addAttribute("jjcdMap", getSelectMap("B00009"));
			model.addAttribute("statusMap", getSelectMap("B00089"));
			model.addAttribute("br40_cxqqList", br40_cxqqList);
			model.addAttribute("br40_cxqq", searchObj);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/tjfx/request_cg_list");
	}

	/**
	 * 统计分析 动态查询
	 * 
	 * @param model
	 * @param request
	 * @param page
	 * @param br40_cxqq
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/request_dt_list", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr40_cxqq_cxdtList(Model model, HttpServletRequest request, Page page, Br40_cxqq br40_cxqq) throws Exception {
		try {
			/* 获取机构号 */
			String loginname = StrUtils.nullToString((String) request.getSession().getAttribute("loginname"));
			String organstr = commonService.getMp02_OrganList(loginname);
			br40_cxqq.setOrgkey_disp(organstr.trim());
			/* 从session中获取查询对象 */
			if ("".equals(br40_cxqq.getQqcslx()) || br40_cxqq.getQqcslx() == null) {
				br40_cxqq.setQqcslx_disp("'02','03','04'");// 动态查询
			}
			String startDate = br40_cxqq.getFssj_start();
			String endDate = br40_cxqq.getFssj_end();
			Br40_cxqq searchObj = getSearchObject(br40_cxqq, page, request);
			List<Br40_cxqq> br40_cxqqList = br40_cxqqService.getBr40_cxqq_cxList(searchObj);

			searchObj.setFssj_start(startDate);
			searchObj.setFssj_end(endDate);
			model.addAttribute("jjcdMap", getSelectMap("B00009"));
			model.addAttribute("statusMap", getSelectMap("B00089"));
			model.addAttribute("qqcslxMap", getSelectMap("B00073", "01,05,06,07,08,09,10"));
			model.addAttribute("br40_cxqqList", br40_cxqqList);
			model.addAttribute("br40_cxqq", searchObj);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/tjfx/request_dt_list");
	}

	/**
	 * @param model
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	@Token(setToken = true)
	public String performAddBr40_cxqq(Model model) throws Exception {
		//
		Br40_cxqq br40_cxqq = new Br40_cxqq();

		model.addAttribute("br40_cxqq", br40_cxqq);
		//
		return ("/br40_cxqq/add");
	}

	/**
	 * @param Br40_cxqq
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@Token(checkToken = true)
	public String performaddBr40_cxqqDo(@ModelAttribute Br40_cxqq br40_cxqq) throws Exception {
		//
		try {
			int i = br40_cxqqService.insertBr40_cxqq(br40_cxqq);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}

		return ("redirect:/br40_cxqq/list");
	}

	/**
	 * @param model
	 */
	@RequestMapping(value = "/{qqdbs}/modify", method = RequestMethod.GET)
	public String performModifyBr40_cxqq(@PathVariable String qqdbs, Model model) throws Exception {
		//
		Br40_cxqq br40_cxqq = new Br40_cxqq();
		br40_cxqq = br40_cxqqService.getBr40_cxqqDisp(qqdbs);

		model.addAttribute("br40_cxqq", br40_cxqq);
		//
		return ("/br40_cxqq/modify");
	}

	/**
	 * @param model
	 */
	@RequestMapping(value = "/{qqdbs}/modify", method = RequestMethod.POST)
	public String performModifyBr40_cxqqDo(@ModelAttribute Br40_cxqq br40_cxqq) throws Exception {
		//
		try {
			int i = br40_cxqqService.modifyBr40_cxqq(br40_cxqq);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}

		return ("/redirect:br40_cxqq/list");
	}

	/**
	 * @param model
	 */
	@RequestMapping(value = "/{qqdbs}/delete", method = RequestMethod.POST)
	public String performDeleteBr40_cxqqDo(Model model, String qqdbs) throws Exception {
		//
		try {
			int i = br40_cxqqService.deleteBr40_cxqq(qqdbs);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}

		return ("redirect:/br40_cxqq/list");
	}

	/**
	 * 查询请求处理
	 * 
	 * @param model
	 * @param request
	 * @param page
	 * @param br40_cxqq
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/deal_list", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr40_cxqqdealList(Model model, HttpServletRequest request, Page page, Br40_cxqq br40_cxqq) throws Exception {
		try {
			// 获取机构号
			String loginname = StrUtils.nullToString((String) request.getSession().getAttribute("loginname"));
			String organstr = commonService.getMp02_OrganList(loginname);
			br40_cxqq.setOrgkey_disp(organstr.trim());

			/** 从session中获取查询对象 */
			String begnDate = br40_cxqq.getFssj_start();
			String endDate = br40_cxqq.getFssj_end();
			br40_cxqq.setStatus("1");
			page.setParaid(br40_cxqq.getTasktype());
			Br40_cxqq searchObj = getSearchObject(br40_cxqq, page, request);
			String dt_rg_flag = StrUtils.nullToString(codeService.getCodeValue("Dpara", "cbrc_dtrg_flag"));
			searchObj.setDt_rg_flag(dt_rg_flag);
			if(dt_rg_flag.equals("1")){ //若动态查询需要处理则修改以及到期的记录状态
				br40_cxqqService.updateBr40_cxqq_backDStatus();
			}
			List<Br40_cxqq> br40_cxqqList = br40_cxqqService.getBr40_cxqqdealList(searchObj);
			searchObj.setFssj_start(begnDate);
			searchObj.setFssj_end(endDate);
			// 判断 只有高检5 国安4 有凭证图像查询
			// if (br40_cxqq.getTasktype().equals("4") || br40_cxqq.getTasktype().equals("5")) {
			// model.addAttribute("qqcslxMap", getSelectMap("B00073", "05,06,07,08,09"));
			// }else{
			// model.addAttribute("qqcslxMap", getSelectMap("B00073", "05,06,07,08,09,10"));
			// }

			model.addAttribute("qqcslxMap", getSelectMap("B00073", "05,06,07,08,09,10"));
			model.addAttribute("jjcdMap", getSelectMap("B00009"));
			model.addAttribute("br40_cxqqList", br40_cxqqList);
			model.addAttribute("br40_cxqq", searchObj);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/cxqqcl/deal_list");
	}
	
	/**
	 * 查询请求处理
	 * 
	 * @param model
	 * @param request
	 * @param page
	 * @param br40_cxqq
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/deal_check_list", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr40_cxqqdeal_checkList(Model model, HttpServletRequest request, Page page, Br40_cxqq br40_cxqq) throws Exception {
		try {
			// 获取机构号
			String loginname = StrUtils.nullToString((String) request.getSession().getAttribute("loginname"));
			String organstr = commonService.getMp02_OrganList(loginname);
			br40_cxqq.setOrgkey_disp(organstr.trim());

			/** 从session中获取查询对象 */
			String begnDate = br40_cxqq.getFssj_start();
			String endDate = br40_cxqq.getFssj_end();
			page.setParaid(br40_cxqq.getTasktype());
			Br40_cxqq searchObj = getSearchObject(br40_cxqq, page, request);

			List<Br40_cxqq> br40_cxqqList = br40_cxqqService.getBr40_cxqqdeal_checkList(searchObj);
			searchObj.setFssj_start(begnDate);
			searchObj.setFssj_end(endDate);
			model.addAttribute("qqcslxMap", getSelectMap("B00073", "05,06,07,08,09,10"));
			model.addAttribute("jjcdMap", getSelectMap("B00009"));
			model.addAttribute("br40_cxqqList", br40_cxqqList);
			model.addAttribute("br40_cxqq", searchObj);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/cxqqcl/deal_check_list");
	}

	/**
	 * @param model
	 */
	@RequestMapping(value = "/deal_response_list", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr40_cxqqListResponse(Model model, HttpServletRequest request, Page page, Br40_cxqq br40_cxqq) throws Exception {
		try {
			/** 从session中获取查询对象 */
			br40_cxqq.setStatus("1");
			Br40_cxqq searchObj = getSearchObject(br40_cxqq, page, request);
			List<Br40_cxqq> br40_cxqqList = br40_cxqqService.getBr40_cxqqList(searchObj);
			// 判断 只有高检5 国安4 有凭证图像查询
			if (br40_cxqq.getTasktype().equals("4") || br40_cxqq.getTasktype().equals("5")) {
				model.addAttribute("cslxMap", getSelectMap("B00073", "05,06,07,08,09"));
			} else {
				model.addAttribute("cslxMap", getSelectMap("B00073", "05,06,07,08,09,10"));
			}
			model.addAttribute("jjcdMap", getSelectMap("B00009"));
			model.addAttribute("br40_cxqqList", br40_cxqqList);
			model.addAttribute("br40_cxqq", searchObj);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/cxqqcl/deal_response_list");
	}

	/**
	 * 查询请求反馈信息
	 * 
	 * @param model
	 * @param request
	 * @param page
	 * @param br40_cxqq
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/response_list", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr40_cxqqresponseList(Model model, HttpServletRequest request, Page page, Br40_cxqq br40_cxqq) throws Exception {
		try {
			// 获取机构号
			String startDate=br40_cxqq.getFssj_start();
			String endDate=br40_cxqq.getFssj_end();
			String loginname = StrUtils.nullToString((String) request.getSession().getAttribute("loginname"));
			String organstr = commonService.getMp02_OrganList(loginname);
			br40_cxqq.setOrgkey_disp(organstr.trim());
			/** 从session中获取查询对象 */
			Br40_cxqq searchObj = getSearchObject(br40_cxqq, page, request);
			List<Br40_cxqq> br40_cxqqList = br40_cxqqService.getBr40_cxqqResponseList(searchObj);
			// 判断 只有高检5 国安4 有凭证图像查询
			if (br40_cxqq.getTasktype().equals("4") || br40_cxqq.getTasktype().equals("5")) {
				model.addAttribute("qqcslxMap", getSelectMap("B00073", "05,06,07,08,09"));
			} else {
				model.addAttribute("qqcslxMap", getSelectMap("B00073", "05,06,07,08,09,10"));
			}
			searchObj.setFssj_start(startDate);
			searchObj.setFssj_end(endDate);
			model.addAttribute("jjcdMap", getSelectMap("B00009"));
			//广发没有待认证的状态
			model.addAttribute("statusMap", getSelectMap("B00089","0"));
			model.addAttribute("br40_cxqqList", br40_cxqqList);
			model.addAttribute("br40_cxqq", searchObj);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}

		return ("/gajy/cxqqfk/response_list");
	}

	@RequestMapping(value = "/response_main", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr40_cxqqresponseMain(Model model, HttpServletRequest request) throws Exception {
		String qqdbs = request.getParameter("qqdbss");
		String qqcslx = request.getParameter("qqcslxs");
		String tasktype = request.getParameter("tasktype");
		model.addAttribute("qqdbs", qqdbs);
		model.addAttribute("qqcslx", qqcslx);
		model.addAttribute("tasktype", tasktype);
		return ("/gajy/cxqqfk/response_main");
	}

	/**
	 * @param model
	 *            回执文书信息
	 */
	@RequestMapping(value = "/hzws_list", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr40_cxqq_hzwsList(Model model, HttpServletRequest request, Page page, Br40_cxqq_hzws br40_cxqq_hzws) throws Exception {
		try {
			/** 从session中获取查询对象 */
			Br40_cxqq_hzws searchObj = getSearchObject(br40_cxqq_hzws, page, request);
			List<Br40_cxqq_hzws> br40_cxqq_hzwsList = br40_cxqq_hzwsService.getBr40_cxqq_hzwsList(searchObj);
			model.addAttribute("statusMap", getSelectMap("S00002"));
			model.addAttribute("br40_cxqq_hzwsList", br40_cxqq_hzwsList);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
			model.addAttribute("br40_cxqq_hzws", searchObj);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/cxqqcl/deal_hzws_list");
	}

	@RequestMapping(value = "/hzws_modify", method = RequestMethod.GET)
	public String performModifyBr40_cxqq_hzws(@ModelAttribute Br40_cxqq_hzws br40_cxqq_hzws, Model model) throws Exception {

		try {
			br40_cxqq_hzws = br40_cxqq_hzwsService.getBr40_cxqq_hzwsDisp(br40_cxqq_hzws);
			// 查询文书明细
			br40_cxqq_hzws = br40_cxqq_hzwsService.getBr40_cxqq_hzws_m(br40_cxqq_hzws);
			// 查询关联通知书
			// HashMap<String, String> wjMap = br40_kzqq_hzwsService.getBr40_ws(br40_cxqq_hzws.getBdhm());
			model.addAttribute("br40_cxqq_hzws", br40_cxqq_hzws);
			// model.addAttribute("wjMap", wjMap);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/cxqqcl/deal_hzws_modify");
	}

	/**
	 * @param model
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String performModifyBr40_kzqq_hzwsDo(@ModelAttribute Br40_cxqq_hzws br40_cxqq_hzws, HttpSession session) throws Exception {
		//
		try {
			String loginname = StrUtils.nullToString((String) session.getAttribute("loginname"));
			Mp02_user user = commonService.getMp02_userDisp(loginname);
			br40_cxqq_hzws.setDjr(user.getRealname());
			int i = br40_cxqq_hzwsService.modifyBr40_kzqq_hzws(br40_cxqq_hzws);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}

		return ("redirect:/br40_cxqq/hzws_list?isNewSearch=1&tasktype=" + br40_cxqq_hzws.getTasktype() + "&rwlsh=" + br40_cxqq_hzws.getRwlsh() + "&qqdbs=" + br40_cxqq_hzws
				.getQqdbs());
	}

	/**
	 * @param model
	 */
	@RequestMapping(value = "/request_disp", method = RequestMethod.GET)
	public String performGetBr40_cxqqDisp(Model model, Br40_cxqq br40_cxqq) throws Exception {

		Br40_cxqq b_cxqq = br40_cxqqService.getBr40_cxqqMain(br40_cxqq);
		List<Br40_cxqq> br40_wh_attachList = br40_cxqqService.getBr40_wh_attach(br40_cxqq);
		model.addAttribute("br40_cxqq", b_cxqq);
		model.addAttribute("br40_wh_attachList", br40_wh_attachList);
		return ("/gajy/cxqqrd/request_disp");
	}

	/**
	 * 查询请求认定 main页面
	 * 
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/request_main", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr40_cxqqMain(Model model, HttpServletRequest request) throws Exception {
		String qqdbs = request.getParameter("qqdbss");
		String qqcslx = request.getParameter("qqcslxs");
		String tasktype = request.getParameter("tasktypes");
		model.addAttribute("tasktype", tasktype);
		model.addAttribute("qqdbs", qqdbs);
		model.addAttribute("qqcslx", qqcslx);
		return ("/gajy/cxqqrd/request_main");
	}

	/**
	 * 查询请求处理
	 * 
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/cxqq_deal_main", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr40_cxqqDealList(Model model, HttpServletRequest request) throws Exception {
		String path = "";
		String qqdbs = request.getParameter("qqdbss");
		String qqcslx = request.getParameter("qqcslxs");
		String rwlsh = request.getParameter("rwlshs");
		String tasktype = request.getParameter("tasktypes");
		String resource = request.getParameter("resource");
		// 查询内容 01 账户信息；02 账户交易明细信息；03 账户和账户的交易明细信息
		String cxnr = request.getParameter("cxnr");
		model.addAttribute("qqdbs", qqdbs);
		model.addAttribute("qqcslx", qqcslx);
		model.addAttribute("rwlsh", rwlsh);
		model.addAttribute("tasktype", tasktype);
		model.addAttribute("cxnr", cxnr);
		model.addAttribute("resource", resource);
		if (qqcslx != null && !"".equals(qqcslx)) {
			if (qqcslx.equals("01")) {
				path = "/gajy/cxqqcl/deal_cg_main";
			} else if (qqcslx.equals("02") || qqcslx.equals("03")) {
				// path = "/gajy/cxqqcl/deal_dtjx_main";
				return ("redirect:/br40_cxqq_mx/deal_dtjx_deal_list?isNewSearch=1");
			} else if (qqcslx.equals("04")) {
				path = "/gajy/cxqqcl/deal_dtjc_main";
			} else if (qqcslx.equals("10")) {
				path = "/gajy/cxqqcl/deal_yxpz_main";
			} else {
				path = "/errors/exception";
			}
		}
		String cbrc_check_flag = StrUtils.nullToString(codeService.getCodeValue("Dpara", "cbrc_check_flag")); // 是否走复核
		model.addAttribute("cbrc_check_flag", cbrc_check_flag);
		return (path);
	}
	
	@RequestMapping(value = "/cxqq_deal_check_main", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr40_cxqqDeal_checkList(Model model, HttpServletRequest request,@ModelAttribute Br40_cxqq_back br40_cxqq_back) throws Exception {
		String qqdbs = request.getParameter("qqdbss");
		String qqcslx = request.getParameter("qqcslxs");
		String rwlsh = request.getParameter("rwlshs");
		String tasktype = request.getParameter("tasktypes");
		// 查询内容 01 账户信息；02 账户交易明细信息；03 账户和账户的交易明细信息
		String cxnr = request.getParameter("cxnr");
		br40_cxqq_back.setQqdbs(qqdbs);
		br40_cxqq_back.setQqcslx(qqcslx);
		br40_cxqq_back.setRwlsh(rwlsh);
		br40_cxqq_back.setTasktype(tasktype);
		br40_cxqq_back.setCxnr(cxnr);

		model.addAttribute("br40_cxqq_back", br40_cxqq_back);
		
		return "/gajy/cxqqcl/deal_cg_check_main";
	}

	/**
	 * 统计分析 反馈信息查询
	 * 
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/deal_cg_main", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr40_cxqqDealMain(Model model, HttpServletRequest request) throws Exception {
		String path = "";
		String qqdbs = request.getParameter("qqdbss");
		String qqcslx = request.getParameter("qqcslxs");
		String rwlsh = request.getParameter("rwlshs");
		String tasktype = request.getParameter("tasktypes");
		String resource = request.getParameter("resource");
		// 查询内容 01 账户信息；02 账户交易明细信息；03 账户和账户的交易明细信息
		String cxnr = request.getParameter("cxnr");
		model.addAttribute("qqdbs", qqdbs);
		model.addAttribute("qqcslx", qqcslx);
		model.addAttribute("rwlsh", rwlsh);
		model.addAttribute("tasktype", tasktype);
		model.addAttribute("cxnr", cxnr);
		model.addAttribute("resource", resource);
		if (qqcslx != null && !"".equals(qqcslx)) {
			if (qqcslx.equals("01")) {
				path = "/gajy/tjfx/deal_cg_main";
			} else if (qqcslx.equals("02") || qqcslx.equals("03")) {
				path = "/gajy/tjfx/deal_dtjx_main";
			} else if (qqcslx.equals("04")) {
				path = "/gajy/tjfx/deal_dtjc_main";
			} else if (qqcslx.equals("10")) {
				path = "/gajy/tjfx/deal_yxpz_main";
			} else {
				path = "/errors/exception";
			}
		}

		return (path);
	}

	/**
	 * 统计分析 反馈信息
	 * 
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/search_cgdt_main", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr40_cxqqBackMain(Model model, HttpServletRequest request) throws Exception {
		String path = "";
		String qqdbs = request.getParameter("qqdbss");
		String rwlsh = request.getParameter("rwlshs");
		String qqcslx = request.getParameter("qqcslxs");
		String tasktype = request.getParameter("tasktypes");
		String cxnr = request.getParameter("cxnr");
		 String backurl = StrUtils.nullToString(request.getParameter("backurl"));
		model.addAttribute("cxnr", cxnr);
		model.addAttribute("qqdbs", qqdbs);
		model.addAttribute("rwlsh", rwlsh);
		model.addAttribute("qqcslx", qqcslx);
		model.addAttribute("tasktype", tasktype);
		model.addAttribute("backurl", backurl);
		if (qqcslx != null && !"".equals(qqcslx)) {
			if (qqcslx.equals("01")) {
				path = "/gajy/search/search_cg_main";
			} else if (qqcslx.equals("02") || qqcslx.equals("03")) {
				path = "/gajy/search/search_dtjx_main";
			} else if (qqcslx.equals("04")) {
				path = "/gajy/search/search_dtjc_main";
			} else {
				path = "/errors/exception";
			}
		}

		return (path);
	}

	/**
	 * 发送核心/监管
	 * 
	 * @param model
	 */
	@RequestMapping(value = "/gajy_send", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGajy_sendDo(HttpServletRequest request, @ModelAttribute Br40_cxqq br40_cxqq, HttpSession session) throws Exception {

		String path;
		try {
			String tasktype = request.getParameter("tasktype");
			String rwlsh = request.getParameter("rwlsh");
			String seq = StrUtils.nullToString(request.getParameter("seq"));
			String loginname = StrUtils.nullToString((String) session.getAttribute("loginname"));
			br40_cxqq = br40_cxqqService.getBr40_cxqqMain(br40_cxqq);
			br40_cxqq.setRecipient_p(loginname);
			br40_cxqq.setRecipient_time(DtUtils.getNowDate());
			br40_cxqq.setRwlsh(rwlsh);
			path = "redirect:/br40_cxqq/request_list?isNewSearch=1&tasktype=" + tasktype;
			String flag = request.getParameter("flag");// 1.发送核心 2.发送监管
			int i = br40_cxqqService.modifyBr40_cxqqStatus(br40_cxqq, flag,seq);
			if ("1".equals(flag)) {
				path = "redirect:/br40_cxqq/request_list?tasktype=" + tasktype;
			} else {
				path = "redirect:/br40_cxqq/deal_list?tasktype=" + tasktype;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}

		return path;
	}
	
	@RequestMapping(value = "/gajy_check_send", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGajy_sendCheckDo(HttpServletRequest request, @ModelAttribute Br40_cxqq_back br40_cxqq_back , HttpSession session) throws Exception {


		try {
			String loginname = StrUtils.nullToString((String) session.getAttribute("loginname"));
	
			br40_cxqq_back.setDealing_p(loginname);
			br40_cxqq_back.setDealing_time(DtUtils.getNowTime());
			br40_cxqq_back.setLast_up_dt(DtUtils.getNowTime());
			br40_cxqq_back.setStatus("2");
			 br40_cxqqService.modifyBr40_cxqqCheckStatus(br40_cxqq_back,"1");
	
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}

		return "redirect:/br40_cxqq/deal_check_list?tasktype=" + br40_cxqq_back.getTasktype();
	}
	
	@RequestMapping(value = "/gajy_check_returnBack", method = { RequestMethod.GET })
	public String performGajy_sendCheckReturn(Model model, @ModelAttribute Br40_cxqq_back br40_cxqq_back ) throws Exception {


	    model.addAttribute("br40_cxqq_back",br40_cxqq_back);

		return ("/gajy/cxqqcl/deal_Reason_add");
	}

	
	
	@RequestMapping(value = "/gajy_check_returnBack", method = {RequestMethod.POST })
	public String performGajy_sendCheckReturnDo(HttpServletRequest request, @ModelAttribute Br40_cxqq_back br40_cxqq_back , HttpSession session) throws Exception {


		try {
			String loginname = StrUtils.nullToString((String) session.getAttribute("loginname"));
	
			br40_cxqq_back.setDealing_p(loginname);
			br40_cxqq_back.setDealing_time(DtUtils.getNowTime());
			br40_cxqq_back.setLast_up_dt(DtUtils.getNowTime());
			br40_cxqq_back.setStatus("1");
		    br40_cxqqService.modifyBr40_cxqqCheckStatus(br40_cxqq_back,"0");
	
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}

		return "/common/common_close" ;
	}

	/**
	 * 查询请求处理
	 * 
	 * @param model
	 * @param request
	 * @param page
	 * @param br40_cxqq
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/proof_list", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr40_cxqq_back_pzList(Model model, HttpServletRequest request, Page page, Br40_cxqq_back_pz br40_cxqq_back_pz) throws Exception {
		try {
			// 获取机构号
			String loginname = StrUtils.nullToString((String) request.getSession().getAttribute("loginname"));
			String organstr = commonService.getMp02_OrganList(loginname);
			br40_cxqq_back_pz.setOrgkey(organstr.trim());
			// /** 从session中获取查询对象 */
			 String begnDate = br40_cxqq_back_pz.getFssj_start();
			 String endDate = br40_cxqq_back_pz.getFssj_end();
			br40_cxqq_back_pz.setStatus("1");
			br40_cxqq_back_pz.setStatus_disp("'0','1'");
			Br40_cxqq_back_pz searchObj = getSearchObject(br40_cxqq_back_pz, page, request);
			List<Br40_cxqq_back_pz> br40_cxqq_back_pzList = br40_cxqqService.getBr40_cxqq_back_pzList(searchObj);
			searchObj.setFssj_start(begnDate);
			 searchObj.setFssj_end(endDate);
			model.addAttribute("jjcdMap", getSelectMap("B00009"));
			model.addAttribute("br40_cxqq_back_pzList", br40_cxqq_back_pzList);
			model.addAttribute("br40_cxqq_back_pz", searchObj);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/cxqqcl/proof_list");
	}

	/**
	 * 凭证图像上传--链接
	 * 
	 * @param br40_cxqq_back_pz
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/proof_modify", method = RequestMethod.GET)
	public String performModifyBr40_cxqq_back_pz(@ModelAttribute Br40_cxqq_back_pz br40_cxqq_back_pz, Model model) throws Exception {
		try {

			Br40_cxqq_back_pz back_pz = br40_cxqqService.getBr40_cxqq_back_pz(br40_cxqq_back_pz);
			// 查询附件信息
			List<Br40_cxqq_back_pz_attach> attachList = br40_cxqqService.getBr40_cxqq_back_pz_attach(br40_cxqq_back_pz);

			model.addAttribute("cxfkjgMap", getSelectMap("B00099"));
			model.addAttribute("br40_cxqq_back_pz", back_pz);
			model.addAttribute("attachList", attachList);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/cxqqcl/proof_modify");
	}

	/**
	 * 凭证图像上传
	 * 
	 * @param model
	 */
	@RequestMapping(value = "/proof_modify", method = RequestMethod.POST)
	public String performModifyBr40_cxqq_back_pzDo(@ModelAttribute Br40_cxqq_back_pz br40_cxqq_back_pz, HttpSession session) throws Exception {
		//
		try {
			// 附件信息
			this.uploadFile(br40_cxqq_back_pz);
			// 获取当前用户
			String loginname = StrUtils.nullToString((String) session.getAttribute("loginname"));
			br40_cxqq_back_pz.setDealing_p(loginname);// 设置修改用户
			br40_cxqq_back_pz.setDealing_time(DtUtils.getNowTime());// 设置修改时间

			// ------------------获取凭证图像名称-------------------------------
			// 国安：凭证图像名称是多个附件名以竖线拼接
			// --------------------------------------------------------------
			List<Br40_cxqq_back_pz_attach> attachList = br40_cxqqService.getBr40_cxqq_back_pz_attach(br40_cxqq_back_pz);
			String pztxmc = "";
			if (attachList != null && attachList.size() > 0) {
				for (Br40_cxqq_back_pz_attach br40_cxqq_back_pz_attach : attachList) {
					String filename= br40_cxqq_back_pz_attach.getFilename() ;
					String filepath=br40_cxqq_back_pz_attach.getFilepath();
					filepath=filepath.replace("/", "\\");
					int index=filepath.lastIndexOf("\\");
					if(index>0){
						filename=filepath.substring(index+1);
					}
					pztxmc += filename+ "|";
				}
				br40_cxqq_back_pz.setPztxmc(pztxmc.substring(0, pztxmc.length() - 1));
			}
			// 修改数据
			br40_cxqqService.modifyBr40_cxqq_back_pz(br40_cxqq_back_pz);
			//提交监管
			br40_cxqq_back_pz.setFeedback_p(loginname);
			br40_cxqq_back_pz.setFeedback_time(DtUtils.getNowTime());
			br40_cxqq_back_pz.setStatus("2");
			br40_cxqqService.modifyStatusAndInsertTask3(br40_cxqq_back_pz);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		//return ("redirect:/br40_cxqq/proof_modify?tasktype="+br40_cxqq_back_pz.getTasktype()+"&qqdbs="+br40_cxqq_back_pz.getQqdbs()+"&rwlsh="+br40_cxqq_back_pz.getRwlsh());
	  return("redirect:/br40_cxqq/proof_list?tasktype="+br40_cxqq_back_pz.getTasktype());
	}

	/**
	 * 上传附件
	 * 
	 * @param Bb16_law
	 * @throws Exception
	 */
	private void uploadFile(Br40_cxqq_back_pz br40_cxqq_back_pz) throws Exception {
		String path = "";
		MultipartFile[] file = br40_cxqq_back_pz.getFile_path();// 附件
		// String[] file_name1 = br40_cxqq_back_pz.getFile_name();// 附件名称
		if (null != file && file.length > 0) {
			String tasktype = br40_cxqq_back_pz.getTasktype();// 监管类别 3：公安 4:国安 5:高检
			// 根路劲
			String root = codeService.getCodeValue("Dpara", "1");
			// 分类代码
			String fldm = "SS26";// 高检：SS26 国安：RP29、RP30
			if ("01".equals(br40_cxqq_back_pz.getPztxlx())) {
				fldm = "RP29";// 反馈凭证图像文件：交易凭单图像
			} else if ("02".equals(br40_cxqq_back_pz.getPztxlx())) {
				fldm = "RP30";// 反馈凭证图像文件：证件图像
			}
			// 取银行代码 高检：8位 国安：17位
			Map<String, String> codeMap = codeService.getCodeMap("Dbankcode");// 监管端定义的银行代码
			String yhdm = codeMap.get(tasktype);
			// 请求单标识[22位]
			String qqdbs = br40_cxqq_back_pz.getQqdbs();
			// 取当前qqdbs下的最大序号
			int max_pztxxh = br40_cxqqService.getMaxPztxxhByVo(br40_cxqq_back_pz);
			String last_max_pztxxh = "";

			for (int i = 0; i < file.length; i++) {
				if (null != file[i] && file[i].getOriginalFilename().trim().length() > 0) {
					Br40_cxqq_back_pz_attach back_pz = new Br40_cxqq_back_pz_attach();
					back_pz.setTasktype(br40_cxqq_back_pz.getTasktype());
					back_pz.setQqdbs(br40_cxqq_back_pz.getQqdbs());
					back_pz.setRwlsh(br40_cxqq_back_pz.getRwlsh());
					back_pz.setSeq(codeService.getSequenceValus("seq_br40_cxqq_back_pz"));// 序列
					back_pz.setFilename(file[i].getOriginalFilename().trim());// 附件名（输入的附件名）
					path = PZTX_PATH +"/" + DtUtils.getNowDate("yyyyMMdd");// 相对路劲
					String filename = file[i].getOriginalFilename();
					String type = filename.substring(filename.lastIndexOf("."));// 获取文件格式
					last_max_pztxxh = max_pztxxh + i + 1 + "";
					// 附件名称规则：分类代码【4位】+银行代码【17位】+请求单标识【22位】+序号【6位】+.jpg/.pdf
					String name = fldm + yhdm + qqdbs + StringUtils.leftPad(last_max_pztxxh, 6, "0") + type;
					back_pz.setFilepath(path +"/"+ name);
					// 上传文件
					FileUtils.uploadFile(file[i].getInputStream(), root + path, name);
					// 保存上传信息
					br40_cxqqService.insertBr40_cxqq_back_pz_attach(back_pz);
				}
			}
			// 记录此时的最大序号
			br40_cxqq_back_pz.setPztxxh(last_max_pztxxh);
		}

	}

	/**
	 * 附件删除
	 * 
	 * @param model
	 */
	@RequestMapping(value = "/deletefile", method = RequestMethod.POST)
	public void performDeleteLaw_attchDo(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Br40_cxqq_back_pz_attach br40_cxqq_back_pz_attach)
			throws Exception {
		try {
			this.deleteFile(br40_cxqq_back_pz_attach);
			this.out(response, "{\"success\":true}");
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
	}

	/**
	 * 删除附件及信息（单个）
	 * 
	 * @param id
	 * @param path
	 * @throws Exception
	 */
	private void deleteFile(Br40_cxqq_back_pz_attach br40_cxqq_back_pz_attach) throws Exception {
		// 删除表中信息
		br40_cxqqService.deleteBr40_cxqq_back_pz_attach(br40_cxqq_back_pz_attach);

		// 删除附件文件
		String root = codeService.getCodeValue("Dpara", "1");
		File file = new File(root + PZTX_PATH + File.separator + br40_cxqq_back_pz_attach.getFilepath().trim());
		if (file.exists()) {
			file.delete();
		}
	}

	/**
	 * 凭证图像处理---发送监管
	 * 
	 * @param model
	 * @param request
	 * @param br40_cxqq_back_pz
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/send_jg", method = { RequestMethod.POST })
	public String performGetBr40_cxqq_back_pzAndTask3(@ModelAttribute Br40_cxqq_back_pz br40_cxqq_back_pz, HttpSession session) throws Exception {
		
		try {
			String loginname = StrUtils.nullToString((String) session.getAttribute("loginname"));
			br40_cxqq_back_pz.setFeedback_p(loginname);// 设置反馈用户
			br40_cxqq_back_pz.setFeedback_time(DtUtils.getNowTime());// 设置反馈时间
			br40_cxqq_back_pz.setStatus("2");
			br40_cxqqService.modifyStatusAndInsertTask3(br40_cxqq_back_pz);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}

		return ("redirect:/br40_cxqq/proof_list?tasktype=" + br40_cxqq_back_pz.getTasktype());
	}
	
	/**
	 * 统计分析 -- 凭证图像查询
	 * @param model
	 * @param request
	 * @param page
	 * @param br40_cxqq_back_pz
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/search_proof_list", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr40_cxqq_back_pzListBySearch(Model model, HttpServletRequest request, Page page, Br40_cxqq_back_pz br40_cxqq_back_pz) throws Exception {
		try {
			// 获取机构号
			String loginname = StrUtils.nullToString((String) request.getSession().getAttribute("loginname"));
			String organstr = commonService.getMp02_OrganList(loginname);
			br40_cxqq_back_pz.setOrgkey(organstr.trim());
			// /** 从session中获取查询对象 */
			 String begnDate = br40_cxqq_back_pz.getFssj_start();
			String endDate = br40_cxqq_back_pz.getFssj_end();
			br40_cxqq_back_pz.setStatus("1");
			Br40_cxqq_back_pz searchObj = getSearchObject(br40_cxqq_back_pz, page, request);
			List<Br40_cxqq_back_pz> br40_cxqq_back_pzList = br40_cxqqService.getBr40_cxqq_back_pzList(searchObj);
			searchObj.setFssj_start(begnDate);
			 searchObj.setFssj_end(endDate);
			model.addAttribute("jjcdMap", getSelectMap("B00009"));
			model.addAttribute("br40_cxqq_back_pzList", br40_cxqq_back_pzList);
			model.addAttribute("br40_cxqq_back_pz", searchObj);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/cxqqcl/search_proof_list");
	}

	/**
	 * 凭证图像详情
	 * 
	 * @param br40_cxqq_back_pz
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/proof_modify_disp", method = RequestMethod.GET)
	public String performModifyBr40_cxqq_back_pzDisp(@ModelAttribute Br40_cxqq_back_pz br40_cxqq_back_pz, Model model) throws Exception {
		try {

			Br40_cxqq_back_pz back_pz = br40_cxqqService.getBr40_cxqq_back_pz(br40_cxqq_back_pz);
			// 查询附件信息
			List<Br40_cxqq_back_pz_attach> attachList = br40_cxqqService.getBr40_cxqq_back_pz_attach(br40_cxqq_back_pz);

			model.addAttribute("cxfkjgMap", getSelectMap("B00099"));
			model.addAttribute("br40_cxqq_back_pz", back_pz);
			model.addAttribute("attachList", attachList);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/cxqqcl/proof_modify_disp");
	}
}
