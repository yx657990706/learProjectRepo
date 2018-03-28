package citic.whpsb.wlcx.web;

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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import citic.base.BaseController;
import citic.base.Page;
import citic.base.annotations.Token;
import citic.whpsb.wlcx.domain.Br51_cxqq_mx;
import citic.whpsb.wlcx.service.Br51_cxqq_mxService;

@Controller
@RequestMapping("/br51_cxqq_mx")
public class Br51_cxqq_mxController extends BaseController {
	/**
	 * 
	 */
	private static final long serialVersionUID = -296139652547390803L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Br51_cxqq_mxService br51_cxqq_mxService;
	
	/**
	 * @param model
	 */
	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String performGetBr51_cxqq_mxList(Model model, HttpServletRequest request, Page page, Br51_cxqq_mx br51_cxqq_mx) throws Exception {
		String path = "";
		String title = "";
		try {
			/**
			 * I:对私 C:对公
			 * 个人账号信息查询请求文件（grzhxxcx，xml格式）
			 * 单位账号信息查询请求文件（dwzhxxcx，xml格式） 
			 * 个人开户资料查询请求文件（grkhzlcx，xml格式） 
			 * 单位开户资料查询请求文件（dwkhzlcx，xml格式） 
			 * 个人账（卡）号交易明细查询请求文件（grjymxcx，xml格式） 
			 * 单位账（卡）号交易明细查询请求文件（dwjymxcx，xml格式）
			 * 个人账户持有人资料查询请求文件（grzhcyrcx，xml格式）
			 * 单位账户持有人资料查询请求文件（dwzhcyrcx，xml格式）
			 */
			/** 从session中获取查询对象 */
			Br51_cxqq_mx searchObj = getSearchObject(br51_cxqq_mx, page, request);
			List<Br51_cxqq_mx> br51_cxqq_mxList = br51_cxqq_mxService.getBr51_cxqq_mxList(searchObj);
			//单位个人  账户信息查询   开户资料查询
			if (br51_cxqq_mx.getQrymode().equalsIgnoreCase("grzhxx") || br51_cxqq_mx.getQrymode().equalsIgnoreCase("dwzhxx")) {
				title = "账户信息查询";
				path = "/whpsb/cxqq/request_zhxxcx_disp";
				// 单位个人  开户资料查询
			} else if (br51_cxqq_mx.getQrymode().equalsIgnoreCase("grkhzl") || br51_cxqq_mx.getQrymode().equalsIgnoreCase("dwkhzl")) {
				title = "开户资料查询";
				path = "/whpsb/cxqq/request_zhxxcx_disp";
				// 单位个人  持有人资料查询
			} else if (br51_cxqq_mx.getQrymode().equalsIgnoreCase("grzhcyr") || br51_cxqq_mx.getQrymode().equalsIgnoreCase("dwzhcyr")) {
				title = "持有人资料查询";
				path = "/whpsb/cxqq/request_zhcyrcx_disp";
				// 单位个人  	交易明细查询
			} else if (br51_cxqq_mx.getQrymode().equalsIgnoreCase("grjymx") || br51_cxqq_mx.getQrymode().equalsIgnoreCase("dwjymx")) {
				title = "交易明细查询";
				path = "/whpsb/cxqq/request_jymxcx_disp";
			}
			model.addAttribute("cljgMap", getSelectMap("G00025"));
			model.addAttribute("party_class_cdMap", getSelectMap("G00023"));
			model.addAttribute("qrymodeMap", getSelectMap("G00024"));
			model.addAttribute("title", title);
			model.addAttribute("br51_cxqq_mxList", br51_cxqq_mxList);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return (path);
	}
	
	/**
	 * 查询请求单信息
	 * 
	 * @param model
	 */
	@RequestMapping(value = "/request_disp", method = RequestMethod.GET)
	public String performGetBr51_cxqq_mxDisp(Model model, Br51_cxqq_mx br51_cxqq_mx) throws Exception {
		String path = "/errors/exception";
		if (br51_cxqq_mx.getQrymode() != null && !"".equals(br51_cxqq_mx.getQrymode())) {
			if (br51_cxqq_mx.getQrymode().equalsIgnoreCase("grzhxx") || br51_cxqq_mx.getQrymode().equalsIgnoreCase("dwzhxx") || br51_cxqq_mx.getQrymode().equalsIgnoreCase("grkhzl")
				|| br51_cxqq_mx.getQrymode().equalsIgnoreCase("dwkhzl")) {
				path = "/whpsb/cxqq/request_zhxx";
			} else if (br51_cxqq_mx.getQrymode().equalsIgnoreCase("grzhcyr") || br51_cxqq_mx.getQrymode().equalsIgnoreCase("dwzhcyr")) {
				path = "/whpsb/cxqq/request_zhcyr";
			} else if (br51_cxqq_mx.getQrymode().equalsIgnoreCase("grjymx") || br51_cxqq_mx.getQrymode().equalsIgnoreCase("dwjymx")) {
				path = "/whpsb/cxqq/request_jymx";
			}
		} else {
			path = "/errors/exception";
		}
		br51_cxqq_mx = br51_cxqq_mxService.getBr51_cxqq_mxDisp(br51_cxqq_mx.getBdhm());
		
		model.addAttribute("br51_cxqq_mx", br51_cxqq_mx);
		return (path);
	}
}
