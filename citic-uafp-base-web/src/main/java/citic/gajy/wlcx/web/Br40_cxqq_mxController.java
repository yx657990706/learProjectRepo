package citic.gajy.wlcx.web;

/**
 * <p>Br40_cxqq_mxController.java</p>
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
import citic.dxzp.datainfo.domain.Bb21_trans;
import citic.gajy.wlcx.domain.Br40_cxqq;
import citic.gajy.wlcx.domain.Br40_cxqq_back;
import citic.gajy.wlcx.domain.Br40_cxqq_back_acct;
import citic.gajy.wlcx.domain.Br40_cxqq_back_acct_ql;
import citic.gajy.wlcx.domain.Br40_cxqq_back_acct_qzcs;
import citic.gajy.wlcx.domain.Br40_cxqq_back_acct_sub;
import citic.gajy.wlcx.domain.Br40_cxqq_back_party;
import citic.gajy.wlcx.domain.Br40_cxqq_back_pz;
import citic.gajy.wlcx.domain.Br40_cxqq_back_trans;
import citic.gajy.wlcx.domain.Br40_cxqq_mx;
import citic.gajy.wlcx.service.Br40_cxqq_mxService;

@Controller
@RequestMapping("/br40_cxqq_mx")
public class Br40_cxqq_mxController extends AmlBaseController {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7715867227322588591L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Br40_cxqq_mxService br40_cxqq_mxService;

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr40_cxqq_mxList(Model model, HttpServletRequest request, Page page, Br40_cxqq_mx br40_cxqq_mx) throws Exception {
		String path = "";
		try {
			/** 从session中获取查询对象 */
			Br40_cxqq_mx searchObj = getSearchObject(br40_cxqq_mx, page, request);
			List<Br40_cxqq_mx> br40_cxqq_mxList = br40_cxqq_mxService.getBr40_cxqq_mxList(searchObj);
			String qqcslx = br40_cxqq_mx.getQqcslx();
			if (qqcslx != null && !"".equals(qqcslx)) {
				if (qqcslx.equals("01")) {// 常规查询
					path = "/gajy/cxqqrd/request_cg_list";
				} else if (qqcslx.equals("02") || qqcslx.equals("03") || qqcslx.equals("04")) {// 动态查询
					path = "/gajy/cxqqrd/request_dt_list";
				} else if (qqcslx.equals("10")) {
					path = "/gajy/cxqqrd/request_yx_list";
				} else {
					path = "/errors/exception";
				}
			}
			model.addAttribute("br40_cxqq_mxList", br40_cxqq_mxList);
			model.addAttribute("br40_cxqq_mx", searchObj);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return (path);
		}
		return (path);
	}

	@RequestMapping(value = "/request_cx_list", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr40_cxqq_mx_cx_List(Model model, HttpServletRequest request, Page page, Br40_cxqq_mx br40_cxqq_mx) throws Exception {
		try {
			/** 从session中获取查询对象 */
			Br40_cxqq_mx searchObj = getSearchObject(br40_cxqq_mx, page, request);
			List<Br40_cxqq_mx> br40_cxqq_mxList = br40_cxqq_mxService.getBr40_cxqq_mxList(searchObj);
			model.addAttribute("br40_cxqq_mxList", br40_cxqq_mxList);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
			model.addAttribute("br40_cxqq_mx", searchObj);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/search/request_cx_list");
	}
    /**
     * 统计分析     查询请求主体信息
     * @param model
     * @param request
     * @param page
     * @param br40_cxqq_mx
     * @return
     * @throws Exception
     */
	@RequestMapping(value = "/search_cg_list", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr40_cxqq_mx_cg_List(Model model, HttpServletRequest request, Page page, Br40_cxqq_mx br40_cxqq_mx) throws Exception {
		try {
			/** 从session中获取查询对象 */
			Br40_cxqq_mx searchObj = getSearchObject(br40_cxqq_mx, page, request);
			List<Br40_cxqq_mx> br40_cxqq_mxList = br40_cxqq_mxService.getBr40_cxqq_mxList(searchObj);
			model.addAttribute("br40_cxqq_mxList", br40_cxqq_mxList);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
			model.addAttribute("br40_cxqq_mx", searchObj);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/tjfx/search_cg_list");
	}

	@RequestMapping(value = "/deal_yxpz_list", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr40_cxqq_backYxpzList(Model model, HttpServletRequest request, Page page, Br40_cxqq_mx br40_cxqq_mx) throws Exception {
		try {
			/** 从session中获取查询对象 */
			Br40_cxqq_mx searchObj = getSearchObject(br40_cxqq_mx, page, request);
			List<Br40_cxqq_back_pz> br40_cxqq_back_pzList = br40_cxqq_mxService.getBr40_cxqq_back_pz_List(br40_cxqq_mx);
			model.addAttribute("br40_cxqq_back_pzList", br40_cxqq_back_pzList);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/cxqqcl/deal_yxpz_list");
	}

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/deal_cg_disp", method = {RequestMethod.GET,RequestMethod.POST})
	public String performGetBr40_cxqq_backDisp(Model model, Br40_cxqq_back br40_cxqq_back) throws Exception {
		try {
			Br40_cxqq_back cxqq_back = new Br40_cxqq_back();
			cxqq_back = br40_cxqq_mxService.getBr40_cxqq_backDisp(br40_cxqq_back);
			cxqq_back.setCxnr(br40_cxqq_back.getCxnr());
			cxqq_back.setQqcslx(br40_cxqq_back.getQqcslx());
			model.addAttribute("cxfkjgMap", getSelectMap("B00092"));
			model.addAttribute("br40_cxqq_back", cxqq_back);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/cxqqcl/deal_cg_disp");
	}

	@RequestMapping(value = "/search_cg_disp", method = RequestMethod.GET)
	public String performGetBr40_cxqq_searchDisp(Model model, Br40_cxqq_back br40_cxqq_back) throws Exception {
		try {
		Br40_cxqq_back cxqq_back = br40_cxqq_mxService.getBr40_cxqq_backDisp(br40_cxqq_back);
		model.addAttribute("br40_cxqq_back", cxqq_back);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/search/search_cg_disp");
	}

	/**
	 *  查询请求处理反馈信息
	 * @param model
	 */
	@RequestMapping(value = "/deal_dtjc_disp", method = RequestMethod.GET)
	public String performGetBr40_cxqq_backDtjcDisp(Model model, Br40_cxqq_back br40_cxqq_back) throws Exception {
		Br40_cxqq_back cxqq_back = new Br40_cxqq_back();
		cxqq_back = br40_cxqq_mxService.getBr40_cxqq_backDtjcDisp(br40_cxqq_back);
		model.addAttribute("cxfkjgMap", getSelectMap("B00099"));
		model.addAttribute("br40_cxqq_back", cxqq_back);
		return ("/gajy/cxqqcl/deal_dtjc_disp");
	}
	
	
	/**
	 *  查询请求处理反馈信息
	 * @param model
	 */
	@RequestMapping(value = "/response_dtjc_disp", method = RequestMethod.GET)
	public String performGetBr40_cxqq_backDyncjcDisp(Model model, Br40_cxqq_back br40_cxqq_back) throws Exception {
		Br40_cxqq_back 	cxqq_back = br40_cxqq_mxService.getBr40_cxqq_backDtjcDisp(br40_cxqq_back);
		model.addAttribute("br40_cxqq_back", cxqq_back);
		return ("/gajy/cxqqfk/response_dtjc_disp");
	}

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/deal_yxpz_disp", method = RequestMethod.GET)
	public String performGetBr40_cxqq_backYxpzDisp(Model model, Br40_cxqq_back br40_cxqq_back) throws Exception {
		Br40_cxqq_back cxqq_back = new Br40_cxqq_back();
		cxqq_back = br40_cxqq_mxService.getBr40_cxqq_backDtjcDisp(br40_cxqq_back);
		model.addAttribute("cxfkjgMap", getSelectMap("B00077"));
		model.addAttribute("br40_cxqq_back", cxqq_back);
		return ("/gajy/cxqqcl/deal_yxpz_disp");
	}

	/**
	 * 查询请求处理 反馈信息
	 * @param model
	 */
	@RequestMapping(value = "/save_data", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr40_cxqq_backSave(Model model,Br40_cxqq_back br40_cxqq_back) throws Exception {
		try {
		int count=br40_cxqq_mxService.getBr40_cxqq_backDispCount(br40_cxqq_back);
		  if(count>0){
			br40_cxqq_mxService.modifyBr40_cxqq_back(br40_cxqq_back);
			return "redirect:/br40_cxqq_mx/deal_cg_disp?qqdbs="+br40_cxqq_back.getQqdbs()+"&qqcslx="+br40_cxqq_back.getQqcslx()+"&rwlsh="+br40_cxqq_back.getRwlsh()
					+"&tasktype="+br40_cxqq_back.getTasktype();
		}else {
			return ("/errors/exception");
		}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}   
	}

	/**
	 *  
	 * @param model
	 */
	@RequestMapping(value = "/deal_dtjx_list", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr40_cxqq_backDtjxDisp(Model model,HttpServletRequest request,Page page, Br40_cxqq_back br40_cxqq_back) throws Exception {
		try {
			/** 从session中获取查询对象 */
			Br40_cxqq_back searchObj = getSearchObject(br40_cxqq_back, page, request);
			List<Br40_cxqq_back> br40_cxqq_backList = br40_cxqq_mxService.getBr40_cxqq_backDtList(searchObj);
			model.addAttribute("br40_cxqq_back", searchObj);
			model.addAttribute("br40_cxqq_backList", br40_cxqq_backList);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
			model.addAttribute("cxfkjgMap", this.getSelectMap("B00077"));
			model.addAttribute("backurl", StrUtils.nullToString(request.getParameter("backurl")));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/cxqqcl/deal_dtjx_list");
	}
	
	@RequestMapping(value = "/deal_dtjx_query_list", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr40_cxqq_backDtjx_queryList(Model model,HttpServletRequest request,Page page, Br40_cxqq_back br40_cxqq_back) throws Exception {
		try {
			String startDate=br40_cxqq_back.getZxqssj_s();
			String endDate=br40_cxqq_back.getZxqssj_e();
			/** 从session中获取查询对象 */
			Br40_cxqq_back searchObj = getSearchObject(br40_cxqq_back, page, request);
			List<Br40_cxqq_back> br40_cxqq_backList = br40_cxqq_mxService.getBr40_cxqq_backDtList(searchObj);
			searchObj.setZxqssj_s(startDate);
			searchObj.setZxqssj_e(endDate);
			model.addAttribute("br40_cxqq_back", searchObj);
			model.addAttribute("br40_cxqq_backList", br40_cxqq_backList);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
			model.addAttribute("cxfkjgMap", this.getSelectMap("B00077"));
			model.addAttribute("backurl", StrUtils.nullToString(request.getParameter("backurl")));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/cxqqfk/query_dt_mx_list");
	}
	
	@RequestMapping(value = "/deal_dtjx_deal_list", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr40_cxqq_backDtjx_dealList(Model model,HttpServletRequest request,Page page, Br40_cxqq_back br40_cxqq_back) throws Exception {
		try {
			/** 从session中获取查询对象 */
			Br40_cxqq_back searchObj = getSearchObject(br40_cxqq_back, page, request);
			List<Br40_cxqq_back> br40_cxqq_backList = br40_cxqq_mxService.getBr40_cxqq_backDtList(searchObj);
			model.addAttribute("br40_cxqq_back", searchObj);
			model.addAttribute("br40_cxqq_backList", br40_cxqq_backList);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
			model.addAttribute("cxfkjgMap", this.getSelectMap("B00077"));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/cxqqcl/deal_dtjx_deal_list");
	}

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	@Token(setToken = true)
	public String performAddBr40_cxqq_mx(Model model) throws Exception {
		//
		Br40_cxqq_mx br40_cxqq_mx = new Br40_cxqq_mx();

		model.addAttribute("br40_cxqq_mx", br40_cxqq_mx);
		//
		return ("/br40_cxqq_mx/add");
	}

	/**
	 *
	 * @param Br40_cxqq_mx
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@Token(checkToken = true)
	public String performaddBr40_cxqq_mxDo(@ModelAttribute Br40_cxqq_mx br40_cxqq_mx) throws Exception {
		try {
			int i = br40_cxqq_mxService.insertBr40_cxqq_mx(br40_cxqq_mx);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("redirect:/br40_cxqq_mx/list");
	}

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/{rwlsh}/modify", method = RequestMethod.GET)
	public String performModifyBr40_cxqq_mx(@PathVariable String rwlsh, Model model) throws Exception {
		Br40_cxqq_mx br40_cxqq_mx = new Br40_cxqq_mx();
		br40_cxqq_mx = br40_cxqq_mxService.getBr40_cxqq_mxDisp(rwlsh);
		model.addAttribute("br40_cxqq_mx", br40_cxqq_mx);
		return ("/br40_cxqq_mx/modify");
	}

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/{rwlsh}/modify", method = RequestMethod.POST)
	public String performModifyBr40_cxqq_mxDo(@ModelAttribute Br40_cxqq_mx br40_cxqq_mx) throws Exception {
		try {
			int i = br40_cxqq_mxService.modifyBr40_cxqq_mx(br40_cxqq_mx);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}

		return ("/redirect:br40_cxqq_mx/list");
	}

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/{rwlsh}/delete", method = RequestMethod.POST)
	public String performDeleteBr40_cxqq_mxDo(Model model, String rwlsh) throws Exception {
		//
		try {
			int i = br40_cxqq_mxService.deleteBr40_cxqq_mx(rwlsh);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}

		return ("redirect:/br40_cxqq_mx/list");
	}

	/**
	 *
	 * @param model
	 */
	@RequestMapping(value = "/{rwlsh}/disp", method = RequestMethod.GET)
	public String performGetBr40_cxqq_mxDisp(Model model, String rwlsh) throws Exception {
		//
		Br40_cxqq_mx br40_cxqq_mx = new Br40_cxqq_mx();
		br40_cxqq_mx = br40_cxqq_mxService.getBr40_cxqq_mxDisp(rwlsh);

		model.addAttribute("br40_cxqq_mx", br40_cxqq_mx);
		//
		return ("/br40_cxqq_mx/disp");
	}

	/**
	 * 客户信息明细
	 * 
	 * @param model
	 */
	@RequestMapping(value = "/deal_cust_info", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr40_cxqq_deal_cust_info(Model model, HttpServletRequest request, @ModelAttribute Br40_cxqq_back_party br40_cxqq_back_party) throws Exception {
		String path = "/errors/exception";
		try {
			String qqcslx = br40_cxqq_back_party.getQqcslx();
			/** 从session中获取查询对象 */
			br40_cxqq_back_party = br40_cxqq_mxService.getBr40_cxqq_back_partyDisp(br40_cxqq_back_party);

			br40_cxqq_back_party.setQqcslx(qqcslx);
			model.addAttribute("br40_cxqq_back_party", br40_cxqq_back_party);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return (path);
		}
		return ("/gajy/cxqqcl/deal_cust_info");
	}

	/**
	 * 账户信息
	 * 
	 * @param model
	 */
	@RequestMapping(value = "/deal_acct_info", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr40_cxqq_deal_acct_info(Model model, HttpServletRequest request, Page page, @ModelAttribute Br40_cxqq_back_acct br40_cxqq_back_acct) throws Exception {
		String path = "/errors/exception";
		try {
			String qqcslx = br40_cxqq_back_acct.getQqcslx();
			/** 从session中获取查询对象 */
			Br40_cxqq_back_acct searchObj = getSearchObject(br40_cxqq_back_acct, page, request);
			List<Br40_cxqq_back_acct> br40_cxqq_back_acctList = br40_cxqq_mxService.getBr40_cxqq_back_acctList(searchObj);

			br40_cxqq_back_acct.setQqcslx(qqcslx);
			model.addAttribute("statusMap", getSelectMap("S00002"));
			model.addAttribute("br40_cxqq_back_acctList", br40_cxqq_back_acctList);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
			model.addAttribute("br40_cxqq_back_acct", searchObj);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return (path);
		}
		return ("/gajy/cxqqcl/deal_acct_info");
	}

	/**
	 * 强制措施信息
	 * 
	 * @param model
	 */
	@RequestMapping(value = "/deal_qzcs_info", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr40_cxqq_deal_qzcs_info(Model model, HttpServletRequest request, Page page, @ModelAttribute Br40_cxqq_back_acct_qzcs br40_cxqq_back_acct_qzcs)
			throws Exception {
		try {
			/** 从session中获取查询对象 */
			Br40_cxqq_back_acct_qzcs searchObj = getSearchObject(br40_cxqq_back_acct_qzcs, page, request);
			List<Br40_cxqq_back_acct_qzcs> br40_cxqq_back_acct_qzcsList = br40_cxqq_mxService.getBr40_cxqq_back_acct_qzcsList(searchObj);

			model.addAttribute("djcslxMap", getSelectMap("S00062"));
			model.addAttribute("br40_cxqq_back_acct_qzcsList", br40_cxqq_back_acct_qzcsList);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
			model.addAttribute("br40_cxqq_back_acct_qzcs", searchObj);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/cxqqcl/deal_qzcs_info");
	}

	/**
	 * 共享权优先权信息
	 * 
	 * @param model
	 */
	@RequestMapping(value = "/deal_ql_info", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr40_cxqq_deal_ql_info(Model model, HttpServletRequest request, Page page, @ModelAttribute Br40_cxqq_back_acct_ql br40_cxqq_back_acct_ql)
			throws Exception {
		try {
			/** 从session中获取查询对象 */
			Br40_cxqq_back_acct_ql searchObj = getSearchObject(br40_cxqq_back_acct_ql, page, request);
			List<Br40_cxqq_back_acct_ql> br40_cxqq_back_acct_qlList = br40_cxqq_mxService.getBr40_cxqq_back_acct_qlList(searchObj);

			model.addAttribute("br40_cxqq_back_acct_qlList", br40_cxqq_back_acct_qlList);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
			model.addAttribute("br40_cxqq_back_acct_ql", searchObj);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/cxqqcl/deal_ql_info");
	}

	/**
	 * 关联子账户信息
	 * 
	 * @param model
	 */
	@RequestMapping(value = "/deal_sub_info", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr40_cxqq_deal_sub_info(Model model, HttpServletRequest request, Page page, @ModelAttribute Br40_cxqq_back_acct_sub br40_cxqq_back_acct_sub)
			throws Exception {
		try {
			/** 从session中获取查询对象 */
			Br40_cxqq_back_acct_sub searchObj = getSearchObject(br40_cxqq_back_acct_sub, page, request);
			List<Br40_cxqq_back_acct_sub> br40_cxqq_back_acct_subList = br40_cxqq_mxService.getBr40_cxqq_back_acct_subList(searchObj);


			model.addAttribute("br40_cxqq_back_acct_subList", br40_cxqq_back_acct_subList);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
			model.addAttribute("br40_cxqq_back_acct_sub", searchObj);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/cxqqcl/deal_sub_info");
	}

	@RequestMapping(value = "/response_mx_list", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr40_cxqq_response_mxList(Model model, HttpServletRequest request, Page page, Br40_cxqq_mx br40_cxqq_mx) throws Exception {
		String path = "/errors/exception";
		try {
			String qqcslx = br40_cxqq_mx.getQqcslx();
			/** 从session中获取查询对象 */
			Br40_cxqq_mx searchObj = getSearchObject(br40_cxqq_mx, page, request);
			  if (qqcslx.equals("02") || qqcslx.equals("03")){
				  searchObj.setSeq("0");
			  }
			List<Br40_cxqq_mx> br40_cxqq_mxList = br40_cxqq_mxService.getBr40_cxqq_mxList(searchObj);

			model.addAttribute("br40_cxqq_mxList", br40_cxqq_mxList);
			model.addAttribute("cxnrMap", getSelectMap("B00074"));
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
			model.addAttribute("br40_cxqq_mx", searchObj);
			model.addAttribute("qqcslx", qqcslx);
			if (qqcslx != null && !"".equals(qqcslx)) {
				if (qqcslx.equals("01")) {// 常规查询
					path = "/gajy/cxqqfk/response_cg_list";
				} else if (qqcslx.equals("02") || qqcslx.equals("03") || qqcslx.equals("04")) {// 动态查询
					path = "/gajy/cxqqfk/response_dt_list";
				} else if (qqcslx.equals("10")) {
					path = "/gajy/cxqqfk/response_yx_list";
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return (path);
		}
		return (path);
	}

	/**
	 * 账户交易明细
	 * 
	 * @param model
	 */
	@RequestMapping(value = "/deal_acct_trans_info", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr40_cxqq_deal_acct_trans_info(Model model, HttpServletRequest request, Page page, @ModelAttribute Br40_cxqq_back_trans br40_cxqq_back_trans)
			throws Exception {
		try {
			String  startDate=br40_cxqq_back_trans.getJysj_start();
			String endDate=br40_cxqq_back_trans.getJysj_end();
			/** 从session中获取查询对象 */
			Br40_cxqq_back_trans searchObj = getSearchObject(br40_cxqq_back_trans, page, request);
			List<Br40_cxqq_back_trans> br40_cxqq_back_transList = br40_cxqq_mxService.getBr40_cxqq_back_transList(searchObj);
			model.addAttribute("br40_cxqq_back_transList", br40_cxqq_back_transList);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
			searchObj.setJysj_start(startDate);
			searchObj.setJysj_end(endDate);
			model.addAttribute("cxfkjgMap", getSelectMap("B00092"));
			model.addAttribute("br40_cxqq_back_trans", searchObj);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/cxqqcl/deal_acct_trans_info");
	}
	
	
	
	/**
	 * 账户交易明细
	 * 
	 * @param model
	 */
	@RequestMapping(value = "/deal_acct_dt_trans_list", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr40_cxqq_deal_acct_dt_trans_info(Model model, HttpServletRequest request, Page page, @ModelAttribute Br40_cxqq_back_trans br40_cxqq_back_trans)
			throws Exception {
		try {
			/** 从session中获取查询对象 */
			Br40_cxqq_back_trans searchObj = getSearchObject(br40_cxqq_back_trans, page, request);
			List<Br40_cxqq_back_trans> br40_cxqq_back_transList = br40_cxqq_mxService.getBr40_cxqq_back_transList(searchObj);
			model.addAttribute("br40_cxqq_back_transList", br40_cxqq_back_transList);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
			model.addAttribute("br40_cxqq_back_trans", searchObj);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/cxqqcl/deal_acct_dt_trans_list");
	}
	
	
	@RequestMapping(value = "/delete_dt", method = RequestMethod.POST)
	public String performDeleteBb21_case_transDo(Model model, @ModelAttribute Br40_cxqq_back br40_cxqq_back) throws Exception {
		try {
			br40_cxqq_mxService.deleteBr40_cxqq_backByKeys(br40_cxqq_back);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}

		return ("redirect:/br40_cxqq_mx/deal_dtjx_deal_list?isNewSearch=1&qqdbs="+br40_cxqq_back.getQqdbs()+"&qqcslx="+br40_cxqq_back.getQqcslx()+"&rwlsh="+br40_cxqq_back.getRwlsh()+"&tasktype="+br40_cxqq_back.getTasktype());
	}
	
	
	@RequestMapping(value = "/query_cg_list", method = {RequestMethod.GET, RequestMethod.POST})
	public String performQuery_cg_list(Model model, HttpServletRequest request, Page page, Br40_cxqq br40_cxqq) throws Exception {
		try {
			 String startDate=br40_cxqq.getFssj_start();
			 String endDate=br40_cxqq.getFssj_end();
			 //获取机构号
			 String loginname = StrUtils.nullToString((String)request.getSession().getAttribute("loginname"));
			 String organstr = commonService.getMp02_OrganList(loginname);
			 br40_cxqq.setOrgkey_disp(organstr.trim());
			page.setParaid(br40_cxqq.getTasktype());
			Br40_cxqq searchObj = getSearchObject(br40_cxqq, page, request);
			List<Br40_cxqq> br40_cxqqList = br40_cxqq_mxService.getBr40_cxqq_queryRgList(searchObj);
			model.addAttribute("cxfkjgMap", getSelectMap("B00092"));
			model.addAttribute("cxnrMap", getSelectMap("B00074"));
			model.addAttribute("ztlbMap", getSelectMap("B00080"));
			model.addAttribute("jjcdMap", getSelectMap("B00009"));
			model.addAttribute("cxqq_mxList", br40_cxqqList);
			searchObj.setFssj_start(startDate);
			searchObj.setFssj_end(endDate);
			model.addAttribute("br40_cxqq", searchObj);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/cxqqfk/query_cg_list");
	}
	
	@RequestMapping(value = "/query_dt_list", method = {RequestMethod.GET, RequestMethod.POST})
	public String performQuery_dt_list(Model model, HttpServletRequest request, Page page, Br40_cxqq br40_cxqq) throws Exception {
		try {
			 //获取机构号
			 String loginname = StrUtils.nullToString((String)request.getSession().getAttribute("loginname"));
			 String organstr = commonService.getMp02_OrganList(loginname);
			 br40_cxqq.setOrgkey_disp(organstr.trim());
			page.setParaid(br40_cxqq.getTasktype());
			Br40_cxqq searchObj = getSearchObject(br40_cxqq, page, request);
			List<Br40_cxqq> br40_cxqqList = br40_cxqq_mxService.getBr40_cxqq_queryDtList(searchObj);
			model.addAttribute("cxqq_mxList", br40_cxqqList);
			model.addAttribute("br40_cxqq", searchObj);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
			model.addAttribute("qqcslxMap", getSelectMap("B00073", "01,05,06,07,08,09,10"));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gajy/cxqqfk/query_dt_list");
	}
}
