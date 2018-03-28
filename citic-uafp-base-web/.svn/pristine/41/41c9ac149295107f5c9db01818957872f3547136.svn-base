package citic.aml.system.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import citic.aml.base.AmlBaseController;
import citic.aml.system.domain.Citrth_statistics;
import citic.aml.system.service.Citrth_statisticsService;
import citic.base.Page;
import citic.base.utils.DtUtils;
import citic.base.utils.StrUtils;

@Controller
@RequestMapping("citrth_statistics")
public class Citrth_statisticsController  extends AmlBaseController{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5403761480008777145L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private  Citrth_statisticsService   citrth_statisticsService;
	
	@RequestMapping("/citrth_list")
	public String performGetDx_trade_countList(Model model, HttpServletRequest request, Page page,Citrth_statistics  citrth_statistics) throws Exception {
		try {
				HttpSession session = request.getSession();
				String loginname = StrUtils.nullToString((String) session.getAttribute("loginname"));
				String organstr = commonService.getMp02_OrganList(loginname);
				citrth_statistics.setOrganstr(organstr);
				String end_dt = DtUtils.getNowDate();
				String start_dt = DtUtils.add(end_dt, 1, -90);
				citrth_statistics.setAc_dt_start(DtUtils.toStrDate(start_dt));
				citrth_statistics.setAc_dt_end(end_dt);
				
			    /** 从session中获取查询对象 */
				Citrth_statistics searchObj = getSearchObject(citrth_statistics, page, request);
			    List<Citrth_statistics> citrth_statisticsList = citrth_statisticsService.getCitrth_statisticsList(searchObj);
			    model.addAttribute("citrth_statisticsList", citrth_statisticsList);
			    // 设置查询对象
				model.addAttribute("citrth_statistics", searchObj);
				// 设置分页信息
				model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/dxzp/count/citrth_statistics_list");
	}
	
	@RequestMapping("/export_excel")
	public String performGetDx_trade_countListExcel(Model model, HttpServletRequest request, Page page,Citrth_statistics  citrth_statistics) throws Exception {
		try {
				HttpSession session = request.getSession();
				String loginname = StrUtils.nullToString((String) session.getAttribute("loginname"));
				String organstr = commonService.getMp02_OrganList(loginname);
				citrth_statistics.setOrganstr(organstr);
			    /** 从session中获取查询对象 */
				Citrth_statistics searchObj = getSearchObject(citrth_statistics, page, request);
			    List<Citrth_statistics> citrth_statisticsList = citrth_statisticsService.getCitrth_statisticsList(searchObj);
			    model.addAttribute("citrth_statisticsList", citrth_statisticsList);
			    // 设置查询对象
				model.addAttribute("citrth_statistics", searchObj);
				// 设置分页信息
				model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/dxzp/count/export_excel");
	}
}
