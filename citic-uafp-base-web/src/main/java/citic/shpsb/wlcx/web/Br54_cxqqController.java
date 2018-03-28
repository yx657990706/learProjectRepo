package citic.shpsb.wlcx.web;

/**
 * <p>
 * Br51_cxqqController.java
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import citic.aml.base.AmlBaseController;
import citic.base.Page;
import citic.base.utils.DtUtils;
import citic.base.utils.StrUtils;
import citic.shpsb.wlcx.domain.Br54_cxqq;
import citic.shpsb.wlcx.domain.Br54_cxqq_mx;
import citic.shpsb.wlcx.service.Br54_cxqqService;

@Controller
@RequestMapping("/br54_cxqq")
public class Br54_cxqqController extends AmlBaseController {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1903217182266661310L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Br54_cxqqService br54_cxqqService;
	
	/**
	 * 查询请求信息
	 * 
	 * @param model
	 */
	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String performGetBr51_cxqqList(Model model, HttpServletRequest request, Page page, Br54_cxqq br54_cxqq) throws Exception {
		try {
			//判断是否第一次查询
			if (br54_cxqq.getIsFirst().equals("1")) {
				String end_dt = DtUtils.getNowDate();
				String start_dt = DtUtils.add(end_dt, 1, -30);
				br54_cxqq.setQrydt_start(DtUtils.toStrDate(start_dt));
				br54_cxqq.setQrydt_end(end_dt);
				br54_cxqq.setStatus("4");
			}
			//获取机构号
			String loginname = StrUtils.nullToString((String) request.getSession().getAttribute("loginname"));
			String organstr = commonService.getMp02_OrganList(loginname);
			br54_cxqq.setOrganstr(organstr.trim());
			/** 从session中获取查询对象 */
			Br54_cxqq searchObj = getSearchObject(br54_cxqq, page, request);
			List<Br54_cxqq> br54_cxqqList = br54_cxqqService.getBr54_cxqqList(searchObj);
			
			model.addAttribute("party_class_cdMap", getSelectMap("G00037"));
			model.addAttribute("qrymodeMap", getSelectMap("G00030"));
			model.addAttribute("statusMap", getSelectMap("G00036"));//状态
			model.addAttribute("br54_cxqqList", br54_cxqqList);
			model.addAttribute("br54_cxqq", searchObj);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/shpsb/cxqq/request_list");
	}
	
	/**
	 * 查询任务信息
	 * 
	 * @param model
	 */
	@RequestMapping(value = "/request_mx_list", method = {RequestMethod.GET, RequestMethod.POST})
	public String performGetBr51_cxqq_mx_List(Model model, HttpServletRequest request, Page page, Br54_cxqq_mx br54_cxqq_mx) throws Exception {
		String title = "";
		String path = "/errors/exception";
		try {
			/** 从session中获取查询对象 */
			Br54_cxqq_mx searchObj = getSearchObject(br54_cxqq_mx, page, request);
			List<Br54_cxqq_mx> br54_cxqq_mxList = br54_cxqqService.getBr54_cxqq_mxList(searchObj);
			//单位个人  账户信息查询   开户资料查询
			if (br54_cxqq_mx.getQrymode().equalsIgnoreCase("grzhxxcx") || br54_cxqq_mx.getQrymode().equalsIgnoreCase("dwzhxxcx")) {
				title = "账户信息查询";
				path = "/shpsb/cxqq/request_zhxxcx_list";
				// 单位个人  开户资料查询
			} else if (br54_cxqq_mx.getQrymode().equalsIgnoreCase("grkhzlcx") || br54_cxqq_mx.getQrymode().equalsIgnoreCase("dwkhzlcx")) {
				title = "开户资料查询";
				path = "/shpsb/cxqq/request_khzlcx_list";
				// 单位个人  持有人资料查询
			} else if (br54_cxqq_mx.getQrymode().equalsIgnoreCase("grzhcyrcx") || br54_cxqq_mx.getQrymode().equalsIgnoreCase("dwzhcyrcx")) {
				title = "持有人资料查询";
				path = "/shpsb/cxqq/request_zhcyrcx_list";
				// 单位个人  	交易明细查询
			} else if (br54_cxqq_mx.getQrymode().equalsIgnoreCase("grjymxcx") || br54_cxqq_mx.getQrymode().equalsIgnoreCase("dwjymxcx")) {
				title = "交易明细查询";
				path = "/shpsb/cxqq/request_jymxcx_list";
				// 单位个人  操作日志查询
			} else if (br54_cxqq_mx.getQrymode().equalsIgnoreCase("grczrzcx") || br54_cxqq_mx.getQrymode().equalsIgnoreCase("dwczrzcx")) {
				title = "操作日志查询";
				path = "/shpsb/cxqq/request_czrzcx_list";
				// 单位个人    对端账户查询
			} else if (br54_cxqq_mx.getQrymode().equalsIgnoreCase("grddzhcx") || br54_cxqq_mx.getQrymode().equalsIgnoreCase("dwddzhcx")) {
				title = "对端账户查询";
				path = "/shpsb/cxqq/request_ddzhcx_list";
				// 单位个人    交易关联号查询
			} else if (br54_cxqq_mx.getQrymode().equalsIgnoreCase("grjyglhcx") || br54_cxqq_mx.getQrymode().equalsIgnoreCase("dwjyglhcx")) {
				title = "交易关联号查询";
				path = "/shpsb/cxqq/request_jyglhcx_list";
			}
			if (br54_cxqq_mx.getQrymode().contains("dw")) {
				model.addAttribute("zzlxMap", getSelectMap("Dshqyzjlx"));
			} else {
				model.addAttribute("zzlxMap", getSelectMap("Dshgrzjlx"));
			}
			model.addAttribute("title", title);
			model.addAttribute("br54_cxqq_mxList", br54_cxqq_mxList);
			model.addAttribute("br54_cxqq_mx", searchObj);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return (path);
		}
		return (path);
	}
	
	/**
	 * @param model
	 * @param br54_cxqq
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/request_main", method = {RequestMethod.GET, RequestMethod.POST})
	public String performGetBr51_cxqqMain(Model model, Br54_cxqq br54_cxqq) throws Exception {
		try {
			/** 从session中获取查询对象 */
			model.addAttribute("br54_cxqq", br54_cxqq);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/shpsb/cxqq/request_main");
	}
	
	/**
	 * 查询请求单信息
	 * 
	 * @param model
	 */
	@RequestMapping(value = "/request_disp", method = {RequestMethod.GET, RequestMethod.POST})
	public String performGetBr51_cxqq_qqbxx_List(Model model, HttpServletRequest request, Br54_cxqq_mx br54_cxqq_mx) throws Exception {
		String path = "/errors/exception";
		try {
			Br54_cxqq_mx searchObj = br54_cxqqService.getBr54_cxqq_mxDisp(br54_cxqq_mx.getBdhm(), br54_cxqq_mx.getQrymode());
			//单位/个人  账户信息查询   开户资料查询
			if (br54_cxqq_mx.getQrymode().equalsIgnoreCase("grzhxxcx") || br54_cxqq_mx.getQrymode().equalsIgnoreCase("dwzhxxcx")) {
				path = "/shpsb/qqdxx/request_zhxx_disp";
				// 单位/个人  开户资料查询
			} else if (br54_cxqq_mx.getQrymode().equalsIgnoreCase("grkhzlcx") || br54_cxqq_mx.getQrymode().equalsIgnoreCase("dwkhzlcx")) {
				path = "/shpsb/qqdxx/request_khzl_disp";
				// 单位/个人  持有人资料查询
			} else if (br54_cxqq_mx.getQrymode().equalsIgnoreCase("grzhcyrcx") || br54_cxqq_mx.getQrymode().equalsIgnoreCase("dwzhcyrcx")) {
				path = "/shpsb/qqdxx/request_zhcyr_disp";
				// 单位/个人  	交易明细查询
			} else if (br54_cxqq_mx.getQrymode().equalsIgnoreCase("grjymxcx") || br54_cxqq_mx.getQrymode().equalsIgnoreCase("dwjymxcx")) {
				path = "/shpsb/qqdxx/request_jymx_disp";
				// 单位/个人  操作日志查询
			} else if (br54_cxqq_mx.getQrymode().equalsIgnoreCase("grczrzcx") || br54_cxqq_mx.getQrymode().equalsIgnoreCase("dwczrzcx")) {
				path = "/shpsb/qqdxx/request_czrz_disp";
				// 单位/个人    对端账户查询
			} else if (br54_cxqq_mx.getQrymode().equalsIgnoreCase("grddzhcx") || br54_cxqq_mx.getQrymode().equalsIgnoreCase("dwddzhcx")) {
				path = "/shpsb/qqdxx/request_ddzh_disp";
				// 单位/个人    交易关联号查询
			} else if (br54_cxqq_mx.getQrymode().equalsIgnoreCase("grjyglhcx") || br54_cxqq_mx.getQrymode().equalsIgnoreCase("dwjyglhcx")) {
				path = "/shpsb/qqdxx/request_jyglh_disp";
			}
			model.addAttribute("br54_cxqq_mx", searchObj);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return (path);
		}
		return (path);
	}
	
}
