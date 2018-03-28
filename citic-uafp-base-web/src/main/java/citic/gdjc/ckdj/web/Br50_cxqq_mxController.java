/* =============================================
 *  Copyright (c) 2014-2015 by CITIC All rights reserved.
 *  Created [2016-08-18] 
 * =============================================
 */

package citic.gdjc.ckdj.web;

/**
 * <p>Br50_cxqq_mxController.java</p>
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import citic.aml.base.AmlBaseController;
import citic.base.Page;
import citic.base.utils.DtUtils;
import citic.base.utils.StrUtils;
import citic.gdjc.ckdj.domain.Br50_cxqq_back;
import citic.gdjc.ckdj.domain.Br50_cxqq_mx;
import citic.gdjc.ckdj.service.Br50_cxqq_mxService;

@Controller
@RequestMapping("/br50_cxqq_mx")
public class Br50_cxqq_mxController extends AmlBaseController {
	/**
	 * 
	 */
	private static final long serialVersionUID = -156896293155640575L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Br50_cxqq_mxService br50_cxqq_mxService;

	/**
	 * 查询请求单信息
	 * @param model
	 */
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr50_cxqq_mxList(Model model, HttpServletRequest request, Page page, Br50_cxqq_mx br50_cxqq_mx) throws Exception {
		try {
			/** 从session中获取查询对象 */
			Br50_cxqq_mx searchObj = getSearchObject(br50_cxqq_mx, page, request);
			List<Br50_cxqq_mx> br50_cxqq_mxList = br50_cxqq_mxService.getBr50_cxqq_mxList(searchObj);
			model.addAttribute("typeMap", getSelectMap("G00006"));
			model.addAttribute("br50_cxqq_mxList", br50_cxqq_mxList);
			model.addAttribute("pageInfoStr", getPageInfoStr(page));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gdjc/cxqq/request_list_disp");
	}
	
	/**
	 *  查询反馈信息
	 * @param model
	 */
	@RequestMapping(value = "/response_list", method = { RequestMethod.GET, RequestMethod.POST })
	public String performGetBr50_cxqq_backList(Model model, HttpServletRequest request, Page page, Br50_cxqq_back br50_cxqq_back) throws Exception {
		try {
			//判断是否第一次查询
			if(br50_cxqq_back.getIsFirst().equals("1")){
				String end_dt = DtUtils.getNowDate();
				String start_dt = DtUtils.add(end_dt, 1,-30);		
				br50_cxqq_back.setQrydt_start(start_dt);
				br50_cxqq_back.setQrydt_end(end_dt);
				br50_cxqq_back.setCxfkjg("01");//默认先查询成功的
			}
			//获取机构号
			 String loginname = StrUtils.nullToString((String)request.getSession().getAttribute("loginname"));
			 String organstr = commonService.getMp02_OrganList(loginname);
			 br50_cxqq_back.setOrgkey_disp(organstr.trim());
			/** 从session中获取查询对象 */
			Br50_cxqq_back searchObj = getSearchObject(br50_cxqq_back, page, request);
			List<Br50_cxqq_back> br50_cxqq_backList = br50_cxqq_mxService.getBr50_cxqq_backList(searchObj);
			model.addAttribute("datasourceMap", getSelectMap("G00012"));
			model.addAttribute("cxfkjgMap", getSelectMap("G00021"));
			model.addAttribute("statusMap", getSelectMap("G00017"));
			model.addAttribute("br50_cxqq_backList", br50_cxqq_backList);
			model.addAttribute("br50_cxqq_back", searchObj);
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/gdjc/cxfk/response_list");
	}
}
