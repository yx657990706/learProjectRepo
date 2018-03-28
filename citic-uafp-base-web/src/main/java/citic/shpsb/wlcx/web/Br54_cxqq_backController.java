package citic.shpsb.wlcx.web;

/**
 * <p>
 * Br51_cxqq_mxController.java
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
import citic.shpsb.wlcx.domain.Br54_cxqq_back;
import citic.shpsb.wlcx.domain.Br54_cxqq_back_acct;
import citic.shpsb.wlcx.domain.Br54_cxqq_back_card;
import citic.shpsb.wlcx.domain.Br54_cxqq_back_czrz;
import citic.shpsb.wlcx.domain.Br54_cxqq_back_ddzh;
import citic.shpsb.wlcx.domain.Br54_cxqq_back_jyglh;
import citic.shpsb.wlcx.domain.Br54_cxqq_back_msg;
import citic.shpsb.wlcx.domain.Br54_cxqq_back_party;
import citic.shpsb.wlcx.domain.Br54_cxqq_back_trans;
import citic.shpsb.wlcx.service.Br54_cxqq_backService;

@Controller
@RequestMapping("/br54_cxqq_back")
public class Br54_cxqq_backController extends AmlBaseController {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3969411569028097005L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Br54_cxqq_backService br54_cxqq_backService;
	
	/**
	 * 查询反馈主表数据
	 * 
	 * @param model
	 * @param request
	 * @param page
	 * @param br54_cxqq_back
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/response_list", method = {RequestMethod.GET, RequestMethod.POST})
	public String performGetBr51_cxqqList(Model model, HttpServletRequest request, Page page, Br54_cxqq_back br54_cxqq_back) throws Exception {
		try {
			if ("1".equals(br54_cxqq_back.getIsFirst())) {
				String end_dt = DtUtils.getNowDate();
				String start_dt = DtUtils.add(end_dt, 1, -30);
				br54_cxqq_back.setQrydt_start(DtUtils.toStrDate(start_dt));
				br54_cxqq_back.setQrydt_end(end_dt);
				br54_cxqq_back.setCljg("0");//默认查询成功的
			}
			/** 从session中获取查询对象 */
			Br54_cxqq_back searchObj = getSearchObject(br54_cxqq_back, page, request);
			List<Br54_cxqq_back> br54_cxqq_backList = br54_cxqq_backService.getBr54_cxqq_backList(searchObj);
			model.addAttribute("party_class_cdMap", getSelectMap("G00037"));
			model.addAttribute("qrymodeMap", getSelectMap("G00030"));
			model.addAttribute("statusMap", getSelectMap("G00039"));//反馈状态
			model.addAttribute("cljgMap", getSelectMap("G00038"));
			model.addAttribute("br54_cxqq_backList", br54_cxqq_backList);
			model.addAttribute("br54_cxqq_back", searchObj);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/shpsb/cxqqfk/response_list");
	}
	
	/**
	 * 查询反馈main
	 * 
	 * @param model
	 * @param br54_cxqq_back
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/response_main", method = RequestMethod.GET)
	public String performGetBr41_kzqqDisp(Model model, Br54_cxqq_back br54_cxqq_back) throws Exception {
		model.addAttribute("br54_cxqq_back", br54_cxqq_back);
		return ("/shpsb/cxqqfk/response_main");
	}
	
	/**
	 * 查询反馈 明细信息
	 * 
	 * @param model
	 * @param request
	 * @param page
	 * @param br54_cxqq_mx
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/response_mx_list", method = {RequestMethod.GET, RequestMethod.POST})
	public String performGetBr51_cxqq_mx_List(Model model, HttpServletRequest request, Page page, Br54_cxqq_back br54_cxqq_back) throws Exception {
		String path = "/errors/exception";
		try {
			/** 从session中获取查询对象 */
			//单位/个人  账户信息查询  
			Br54_cxqq_back searchObj = getSearchObject(br54_cxqq_back, page, request);
			if (br54_cxqq_back.getQrymode().equalsIgnoreCase("grzhxxcx") || br54_cxqq_back.getQrymode().equalsIgnoreCase("dwzhxxcx")) {
				List<Br54_cxqq_back_acct> br54_cxqq_back_acctList = br54_cxqq_backService.getBr54_cxqq_back_acctList(searchObj);
				model.addAttribute("br54_cxqq_back_acctList", br54_cxqq_back_acctList);
				model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
				path = "/shpsb/cxqqfk/response_zhxxcx_list";
				// 个人  开户资料查询
			} else if (br54_cxqq_back.getQrymode().equalsIgnoreCase("grkhzlcx")) {
				Br54_cxqq_back_party br54_cxqq_back_party = br54_cxqq_backService.getBr54_cxqq_back_partyDisp(searchObj);
				model.addAttribute("br54_cxqq_back_party", br54_cxqq_back_party);
				path = "/shpsb/cxqqfk/response_grkhzlcx_disp";
				// 单位  开户资料查询
			} else if (br54_cxqq_back.getQrymode().equalsIgnoreCase("dwkhzlcx")) {
				Br54_cxqq_back_party br54_cxqq_back_party = br54_cxqq_backService.getBr54_cxqq_back_partyDisp(searchObj);
				model.addAttribute("br54_cxqq_back_party", br54_cxqq_back_party);
				path = "/shpsb/cxqqfk/response_dwkhzlcx_disp";
				//单位/个人 持有人信息查询
			} else if (br54_cxqq_back.getQrymode().equalsIgnoreCase("grzhcyrcx") || br54_cxqq_back.getQrymode().equalsIgnoreCase("dwzhcyrcx")) {
				Br54_cxqq_back_card br54_cxqq_back_card = br54_cxqq_backService.getBr54_cxqq_back_cardDisp(searchObj);
				model.addAttribute("br54_cxqq_back_card", br54_cxqq_back_card);
				path = "/shpsb/cxqqfk/response_zhcyrcx_disp";
				// 单位/个人  交易明细查询
			} else if (br54_cxqq_back.getQrymode().equalsIgnoreCase("grjymxcx") || br54_cxqq_back.getQrymode().equalsIgnoreCase("dwjymxcx")) {
				List<Br54_cxqq_back_trans> br54_cxqq_back_transList = br54_cxqq_backService.getBr54_cxqq_back_transtList(searchObj);
				model.addAttribute("br54_cxqq_back_transList", br54_cxqq_back_transList);
				model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
				path = "/shpsb/cxqqfk/response_jymxcx_list";
				// 单位/个人  操作日志查询
			} else if (br54_cxqq_back.getQrymode().equalsIgnoreCase("grczrzcx") || br54_cxqq_back.getQrymode().equalsIgnoreCase("dwczrzcx")) {
				List<Br54_cxqq_back_czrz> br54_cxqq_back_czrzList = br54_cxqq_backService.getBr54_cxqq_back_czrztList(searchObj);
				model.addAttribute("br54_cxqq_back_czrzList", br54_cxqq_back_czrzList);
				model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
				path = "/shpsb/cxqqfk/response_czrzcx_list";
				// 单位/个人   对端账户查询
			} else if (br54_cxqq_back.getQrymode().equalsIgnoreCase("grddzhcx") || br54_cxqq_back.getQrymode().equalsIgnoreCase("dwddzhcx")) {
				List<Br54_cxqq_back_ddzh> br54_cxqq_back_ddzhList = br54_cxqq_backService.getBr54_cxqq_back_ddzhtList(searchObj);
				model.addAttribute("br54_cxqq_back_ddzhList", br54_cxqq_back_ddzhList);
				model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
				path = "/shpsb/cxqqfk/response_ddzhcx_list";
				// 单位/个人    交易关联号查询
			} else if (br54_cxqq_back.getQrymode().equalsIgnoreCase("grjyglhcx") || br54_cxqq_back.getQrymode().equalsIgnoreCase("dwjyglhcx")) {
				List<Br54_cxqq_back_jyglh> br54_cxqq_back_jyglhList = br54_cxqq_backService.getBr54_cxqq_back_jyglhtList(br54_cxqq_back);
				model.addAttribute("br54_cxqq_back_jyglhList", br54_cxqq_back_jyglhList);
				model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
				path = "/shpsb/cxqqfk/response_jyglhcx_list";
			}
			model.addAttribute("br54_cxqq_back", br54_cxqq_back);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return (path);
		}
		return (path);
	}
	
	/**
	 * 查询反馈文件信息
	 * 
	 * @param model
	 * @param request
	 * @param page
	 * @param br54_cxqq_back
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/response_msg_list", method = {RequestMethod.GET, RequestMethod.POST})
	public String performGetBr51_cxqq_back_msgList(Model model, HttpServletRequest request, Page page, Br54_cxqq_back br54_cxqq_back) throws Exception {
		try {
			/** 从session中获取查询对象 */
			Br54_cxqq_back searchObj = getSearchObject(br54_cxqq_back, page, request);
			List<Br54_cxqq_back_msg> br54_cxqq_back_msgList = br54_cxqq_backService.getBr54_cxqq_back_msgtList(searchObj);
			model.addAttribute("br54_cxqq_back_msgList", br54_cxqq_back_msgList);
			model.addAttribute("br54_cxqq_back", searchObj);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/shpsb/cxqqfk/response_msg_list");
	}
	
}
