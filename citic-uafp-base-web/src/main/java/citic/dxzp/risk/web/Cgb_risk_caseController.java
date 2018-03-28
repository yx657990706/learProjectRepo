/*
 * =============================================
 * Copyright (c) 2014-2015 by CITIC All rights reserved.
 * Created [2016-02-29]
 * =============================================
 */

package citic.dxzp.risk.web;

/**
 * <p>
 * Cgb_risk_caseController.java
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author $Author: $
 */

import java.io.PrintWriter;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import citic.aml.base.AmlBaseController;
import citic.base.Page;
import citic.base.annotations.Token;
import citic.base.utils.DtUtils;
import citic.base.utils.StrUtils;
import citic.dxzp.risk.domain.Cgb_risk_case;
import citic.dxzp.risk.domain.Cgb_risk_category;
import citic.dxzp.risk.service.Cgb_risk_caseService;

import com.google.gson.Gson;

@Controller
@RequestMapping("/risk_case")
public class Cgb_risk_caseController extends AmlBaseController {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6493445989537225562L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Cgb_risk_caseService cgb_risk_caseService;
	
	/**
	 * 录入list
	 * 
	 * @param model
	 */
	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String performGetCgb_risk_caseList(Model model, HttpServletRequest request, Page page, Cgb_risk_case cgb_risk_case) throws Exception {
		
		try {
			String isNewSearch = StrUtils.nullToString(request.getParameter("isNewSearch"));
			if ("1".equals(isNewSearch)) {// 获取查询机构范围
				HttpSession session = request.getSession();
				String loginname = StrUtils.nullToString((String) session.getAttribute("loginname"));
				String organstr = commonService.getMp02_OrganList(loginname);
				cgb_risk_case.setOrganstr(organstr);
			}
            if(StringUtils.equals("", cgb_risk_case.getStatus_cd())){
            	cgb_risk_case.setStatus_cd("0");//默认查询录入状态的
            }
			/** 从session中获取查询对象 */
			Cgb_risk_case searchObj = getSearchObject(cgb_risk_case, page, request);
			List<Cgb_risk_case> cgb_risk_caseList = cgb_risk_caseService.getCgb_risk_caseList(searchObj);
			model.addAttribute("cgb_risk_caseList", cgb_risk_caseList);
			// 设置查询对象
			model.addAttribute("cgb_risk_case", searchObj);
			model.addAttribute("status_cdMap", getSelectMap("G00003"));// 状态 0：录入1：待审核2：待审批3：审批通过4：退回
			// 设置分页信息
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/dxzp/risk/case_list");
	}
	
	@RequestMapping(value = "/check_list", method = {RequestMethod.GET, RequestMethod.POST})
	public String performGetCgb_risk_case_checkList(Model model, HttpServletRequest request, Page page, Cgb_risk_case cgb_risk_case) throws Exception {
		//
		try {
			String isNewSearch = StrUtils.nullToString(request.getParameter("isNewSearch"));
			if ("1".equals(isNewSearch)) {// 获取查询机构范围
				HttpSession session = request.getSession();
				String loginname = StrUtils.nullToString((String) session.getAttribute("loginname"));
				String organstr = commonService.getMp02_OrganList(loginname);
				cgb_risk_case.setOrganstr(organstr);
			}
			 if(StringUtils.equals("", cgb_risk_case.getStatus_cd())){
	            	cgb_risk_case.setStatus_cd("1");//默认查询待审核的
	            }
			cgb_risk_case.setStatus_cd_x("'1','2','3'");// 待审核的
			/** 从session中获取查询对象 */
			Cgb_risk_case searchObj = getSearchObject(cgb_risk_case, page, request);
			List<Cgb_risk_case> cgb_risk_caseList = cgb_risk_caseService.getCgb_risk_caseList(searchObj);
			model.addAttribute("cgb_risk_caseList", cgb_risk_caseList);
			// 设置查询对象
			model.addAttribute("cgb_risk_case", searchObj);
			model.addAttribute("status_cdMap", getSelectParaMap("G00003", "1,2,3"));// 状态 0：录入1：待审核2：待审批3：审批通过4：退回
			// 设置分页信息
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		
		return ("/dxzp/risk/case_check_list");
	}
	
	@RequestMapping(value = "/recheck_list", method = {RequestMethod.GET, RequestMethod.POST})
	public String performGetCgb_risk_case_recheckList(Model model, HttpServletRequest request, Page page, Cgb_risk_case cgb_risk_case) throws Exception {
		//
		try {
			String isNewSearch = StrUtils.nullToString(request.getParameter("isNewSearch"));
			if ("1".equals(isNewSearch)) {// 获取查询机构范围
				HttpSession session = request.getSession();
				String loginname = StrUtils.nullToString((String) session.getAttribute("loginname"));
				String organstr = commonService.getMp02_OrganList(loginname);
				cgb_risk_case.setOrganstr(organstr);
			}
			 if(StringUtils.equals("", cgb_risk_case.getStatus_cd())){
	            	cgb_risk_case.setStatus_cd("2");//默认查询待审批的
	            }
			cgb_risk_case.setStatus_cd_x("'2','3'");// 待审批和审批通过的
			if (StringUtils.equals("", cgb_risk_case.getStatus_cd())) {//默认查询待审批
				cgb_risk_case.setStatus_cd("2");
			}
			/** 从session中获取查询对象 */
			Cgb_risk_case searchObj = getSearchObject(cgb_risk_case, page, request);
			List<Cgb_risk_case> cgb_risk_caseList = cgb_risk_caseService.getCgb_risk_caseList(searchObj);
			model.addAttribute("cgb_risk_caseList", cgb_risk_caseList);
			// 设置查询对象
			model.addAttribute("cgb_risk_case", searchObj);
			model.addAttribute("status_cdMap", getSelectParaMap("G00003", "2,3",false));// 状态 0：录入1：待审核2：待审批3：审批通过4：退回
			// 设置分页信息
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		
		return ("/dxzp/risk/case_recheck_list");
	}
	
	@RequestMapping(value = "/query_list", method = {RequestMethod.GET, RequestMethod.POST})
	public String performGetCgb_risk_caseQuery_list(Model model, HttpServletRequest request, Page page, Cgb_risk_case cgb_risk_case) throws Exception {
		
		try {
			String isNewSearch = StrUtils.nullToString(request.getParameter("isNewSearch"));
			if ("1".equals(isNewSearch)) {// 获取查询机构范围
				HttpSession session = request.getSession();
				String loginname = StrUtils.nullToString((String) session.getAttribute("loginname"));
				String organstr = commonService.getMp02_OrganList(loginname);
				cgb_risk_case.setOrganstr(organstr);
			}
            cgb_risk_case.setStatus_cd("3");//默认查询审批通过的
			/** 从session中获取查询对象 */
			Cgb_risk_case searchObj = getSearchObject(cgb_risk_case, page, request);
			List<Cgb_risk_case> cgb_risk_caseList = cgb_risk_caseService.getCgb_risk_caseList(searchObj);
			model.addAttribute("cgb_risk_caseList", cgb_risk_caseList);
			// 设置查询对象
			model.addAttribute("cgb_risk_case", searchObj);
			// 设置分页信息
			model.addAttribute("pageInfoStr", getPageInfoStr(searchObj.getPage()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return ("/dxzp/risk/query_list");
	}
	/**
	 * 添加
	 * @param model
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	@Token(setToken = true)
	public String performAddBb21_card(HttpServletResponse response,Model model) throws Exception {
		try {
			Cgb_risk_case cgb_risk_case = new Cgb_risk_case();
			model.addAttribute("infosourceMap", getSelectMap("G00001"));// 诈骗信息来源
			model.addAttribute("infochannelMap", getSelectMap("G00002"));// 信息来源渠道
			model.addAttribute("isreportMap", getSelectMap("S00001"));//是否已报案
			model.addAttribute("risk_categoryMap", getSelectMap("D00015"));//风险信息类别
			model.addAttribute("bussines_lineMap", getSelectMap("D00016"));//业务条线
			model.addAttribute("risk_levelMap", getSelectMap("G00028"));//风险等级
			model.addAttribute("cgb_risk_case", cgb_risk_case);
			
		} catch (Exception e) {
			 logger.error(e.getMessage(),e);
			 return ("/errors/exception");
		}
		//
		return ("/dxzp/risk/case_add");
	}
	@ResponseBody
	@RequestMapping(value = "/ajax_add", method = RequestMethod.POST)
	public void performAddBb21_cardAdd(HttpServletResponse response,Model model,Cgb_risk_case cgb_risk_case) throws Exception {
		try {
			if(cgb_risk_case.getRisk_category()!=null &&!"".equals(cgb_risk_case.getRisk_category())){
				List<Cgb_risk_category> cgb_risk_caseList = cgb_risk_caseService.getRisk_subCategory(cgb_risk_case.getRisk_category());
				Gson gson = new Gson();
				String obj=gson.toJson(cgb_risk_caseList);
			    PrintWriter out=response.getWriter();
			     out.print(obj);
			     out.close();
			}
		} catch (Exception e) {
			 logger.error(e.getMessage(),e);
			
		}
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@Token(checkToken = true)
	 public String performAddBb21_cardDo(@ModelAttribute Cgb_risk_case cgb_risk_case,HttpServletRequest request) throws Exception {

	 try {
		 HttpSession session = request.getSession();
		 String loginname = StrUtils.nullToString((String) session.getAttribute("loginname"));
		 cgb_risk_case.setCreate_user(loginname);
		 cgb_risk_caseService.InsertCgb_risk_case(cgb_risk_case);
	 } catch (Exception e) {
	 logger.error(e.getMessage(),e);
	 return ("/errors/exception");
	 }
	
	 return ("/common/common_close");
	 }
	
	/**
	 * 修改
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String performModifyBb21_card(Cgb_risk_case cgb_risk_case,Model model) throws Exception {

		try {
			Cgb_risk_case risk_case = cgb_risk_caseService.getCgb_risk_case(cgb_risk_case);
			
			model.addAttribute("infosourceMap", getSelectMap("G00001"));// 诈骗信息来源
			model.addAttribute("infochannelMap", getSelectMap("G00002"));// 信息来源渠道
			model.addAttribute("isreportMap", getSelectMap("S00001"));//是否已报案
			model.addAttribute("cgb_risk_case", risk_case);
		} catch (Exception e) {
			 logger.error(e.getMessage(),e);
			 return ("/errors/exception");
		}
		//
		return ("/dxzp/risk/case_modify");
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	 public String performModifyBb21_cardDo(@ModelAttribute Cgb_risk_case cgb_risk_case) throws Exception {

		 try {
			 cgb_risk_caseService.modifyCgb_risk_case(cgb_risk_case);
		 } catch (Exception e) {
		      logger.error(e.getMessage(),e);
		 return ("/errors/exception");
		 }
		
		 return ("/common/common_close");
		 }
	
	/**
	 * 删除
	 * @param cgb_risk_case
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	 public String performDeleteBb21_card(@ModelAttribute Cgb_risk_case cgb_risk_case) throws Exception {

		 try {
			 cgb_risk_caseService.deleteCgb_risk_caseById(cgb_risk_case.getCaseid());
		 } catch (Exception e) {
		 logger.error(e.getMessage(),e);
		 return ("/errors/exception");
		 }
		
		 return ("redirect:/risk_case/list");
		 }
	
	/**
	 * 提交审核、审核通过和审批通过 共用
	 * [勾选模式] 
	 * @param cgb_risk_case
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 * 
	 */
	@RequestMapping(value = "/choose_save", method = RequestMethod.POST)
	public String performModifyCgb_risk_caseDo(Cgb_risk_case cgb_risk_case,  HttpServletRequest request) throws Exception {
		
		String forword = "";
		try {
			String loginname = StrUtils.nullToString((String) request.getSession().getAttribute("loginname"));
			String[] keys = request.getParameterValues("keys");
			String in_key = "";
			if (keys != null && keys.length > 0) {
				for (int i = 0; i < keys.length; i++) {
					in_key += ",'" + keys[i] + "'";
				}
				in_key = in_key.substring(1);
			}
			cgb_risk_case.setIn_key(in_key);
			String time = DtUtils.getNowTime();
			if ("1".equals(cgb_risk_case.getBzw())) {//提交审核
				cgb_risk_case.setStatus_cd("1");//待审核
				forword = "redirect:/risk_case/list?isNewSearch=1";
			} else if ("2".equals(cgb_risk_case.getBzw())) {//审核审核
				cgb_risk_case.setStatus_cd("2");//待审批
				cgb_risk_case.setCheck_user(loginname);// 审核人
				cgb_risk_case.setCheck_dt(time);
				forword = "redirect:/risk_case/check_list?isNewSearch=1";
			} else {//批量审批
				cgb_risk_case.setStatus_cd("3");//审批通过
				cgb_risk_case.setRecheck_user(loginname);// 审批人
				cgb_risk_case.setRecheck_dt(time);
				forword = "redirect:/risk_case/recheck_list?isNewSearch=1";
			}
			//执行
			cgb_risk_caseService.modifyCgb_risk_caseStatus_cdByPl_choose(cgb_risk_case);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return (forword);
	}
	
	/**
	 * 退回
	 * @param cgb_risk_case
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/back", method = RequestMethod.POST)
	public String performModifyCgb_risk_caseByBack(@ModelAttribute Cgb_risk_case cgb_risk_case, HttpServletRequest request){
		String forword = "";
		try {
			String loginname = StrUtils.nullToString((String) request.getSession().getAttribute("loginname"));
			cgb_risk_case.setRecheck_user(loginname);// 审批人
			cgb_risk_case.setStatus_cd("4");//退回
			String time = DtUtils.getNowTime();
			if ("2".equals(cgb_risk_case.getBzw())) {//审核时退回
				cgb_risk_case.setCheck_user(loginname);// 审核人
				cgb_risk_case.setCheck_dt(time);
				forword = "redirect:/risk_case/check_list?isNewSearch=1";
			}else{//审批时退回
				cgb_risk_case.setRecheck_user(loginname);// 审批人
				cgb_risk_case.setRecheck_dt(time);
				forword = "redirect:/risk_case/recheck_list?isNewSearch=1";
			}
			//执行
			cgb_risk_caseService.modifyCgb_risk_caseStatus_cdByBack(cgb_risk_case);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		return (forword);
	}
	
	@RequestMapping(value = "/export", method = RequestMethod.POST)
	public String performGetCgb_risk_case_recheckListExport(Model model, HttpServletRequest request, Page page, Cgb_risk_case cgb_risk_case) throws Exception {
		//
		try {
			String isNewSearch = StrUtils.nullToString(request.getParameter("isNewSearch"));
			if ("1".equals(isNewSearch)) {// 获取查询机构范围
				HttpSession session = request.getSession();
				String loginname = StrUtils.nullToString((String) session.getAttribute("loginname"));
				String organstr = commonService.getMp02_OrganList(loginname);
				cgb_risk_case.setOrganstr(organstr);
			}
			 cgb_risk_case.setStatus_cd("3");//默认查询审批通过的
			//设置导出记录限制
			page.setCount(false);  //设置受影响的行数
			String size = codeService.getCodeValue("Dpara", "10");//导出记录数限制
			page.setPageSize(Integer.parseInt(size));
			cgb_risk_case.setPage(page);
			List<Cgb_risk_case> cgb_risk_caseList = cgb_risk_caseService.getCgb_risk_caseList(cgb_risk_case);
			model.addAttribute("cgb_risk_caseList", cgb_risk_caseList);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return ("/errors/exception");
		}
		
		return ("/dxzp/risk/case_export");
	}
}
