/*
 * =============================================
 * Copyright (c) 2014-2015 by CITIC All rights reserved.
 * Created [2016-02-29]
 * =============================================
 */

package citic.dxzp.count.web;

/**
 * <p>
 * Dx_trade_countController.java
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author $Author: $
 */

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import citic.aml.base.AmlBaseController;
import citic.base.Page;
import citic.base.utils.StrUtils;
import citic.dxzp.count.domain.Dx_trade_count;
import citic.dxzp.count.service.Dx_trade_countService;

@Controller
@RequestMapping("/dx_trade_count")
public class Dx_trade_countController extends AmlBaseController {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9126223822395369191L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Dx_trade_countService dx_trade_countService;
	/**
	 *   快速查询统计
	 * @param model
	 */
	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String performGetDx_trade_countList(Model model, HttpServletRequest request, Page page, Dx_trade_count  dx_trade_count) throws Exception {
		try {
				HttpSession session = request.getSession();
				String loginname = StrUtils.nullToString((String) session.getAttribute("loginname"));
				String organstr = commonService.getMp02_OrganList(loginname);
				dx_trade_count.setOrganstr(organstr);
			    /** 从session中获取查询对象 */
				Dx_trade_count searchObj = getSearchObject(dx_trade_count, page, request);
			    List<Dx_trade_count> br24_q_mainList = dx_trade_countService.getDx_trade_countList(searchObj);
			    model.addAttribute("br24_q_mainList", br24_q_mainList);
			    // 设置查询对象
				model.addAttribute("br24_q_main", searchObj);
				// 设置分页信息
				model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/dxzp/count/dx_query_list");
	}
	
	/**
	 * 导出excel
	 * @param model
	 * @param request
	 * @param page
	 * @param cgb_risk_case
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/export_excel", method = RequestMethod.POST)
	public String performGetDx_trade_countListExport(Model model, HttpServletRequest request, Page page, Dx_trade_count  dx_trade_count) throws Exception {
		try {
			String isNewSearch = StrUtils.nullToString(request.getParameter("isNewSearch"));
			if ("1".equals(isNewSearch)) {// 获取查询机构范围
				HttpSession session = request.getSession();
				String loginname = StrUtils.nullToString((String) session.getAttribute("loginname"));
				String organstr = commonService.getMp02_OrganList(loginname);
				dx_trade_count.setOrganstr(organstr);
			}
			//设置导出记录限制
			page.setCount(false);  //设置受影响的行数
			String size = codeService.getCodeValue("Dpara", "10");//导出记录数限制
			page.setPageSize(Integer.parseInt(size));
			dx_trade_count.setPage(page);
			List<Dx_trade_count> dx_trade_countList = dx_trade_countService.getDx_trade_countListExport(dx_trade_count);
			model.addAttribute("dx_trade_countList", dx_trade_countList);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/dxzp/count/export_count");
	}
}
